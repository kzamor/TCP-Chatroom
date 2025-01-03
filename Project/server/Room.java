package Project.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.Random;

import Project.common.Constants;

public class Room implements AutoCloseable {
    // server is a singleton now so we don't need this
    // protected static Server server;// used to refer to accessible server
    // functions
    private String name;
    protected List<ServerThread> clients = new ArrayList<ServerThread>();
    private boolean isRunning = false;
    // Commands
    private final static String COMMAND_TRIGGER = "/";
    private final static String CREATE_ROOM = "createroom";
    private final static String JOIN_ROOM = "joinroom";
    private final static String DISCONNECT = "disconnect";
    private final static String LOGOUT = "logout";
    private final static String LOGOFF = "logoff";
    private static final String ROLL = "roll";
    private static final String FLIP = "flip";
    private final static String MUTE = "mute";
    private final static String UNMUTE = "unmute";
    private static Logger logger = Logger.getLogger(Room.class.getName());
    private List<ServerThread> mutedClients = new ArrayList<>();

    public Room(String name) {
        this.name = name;
        isRunning = true;
    }

    private void info(String message) {
        System.out.println(String.format("Room[%s]: %s", name, message));
    }

    public String getName() {
        return name;
    }

    public boolean isRunning() {
        return isRunning;
    }

    protected synchronized void addClient(ServerThread client) {
        logger.info("Room addClient called");
        if (!isRunning) {
            return;
        }
        client.setCurrentRoom(this);
        if (clients.indexOf(client) > -1) {
            logger.warning("Attempting to add client that already exists in room");
        } else {
            clients.add(client);
            client.sendResetUserList();
            syncCurrentUsers(client);
            sendConnectionStatus(client, true);
        }
    }

    protected synchronized void removeClient(ServerThread client) {
        if (!isRunning) {
            return;
        }
        // attempt to remove client from room
        try {
            clients.remove(client);
        } catch (Exception e) {
            logger.severe(String.format("Error removing client from room %s", e.getMessage()));
            e.printStackTrace();
        }
        // if there are still clients tell them this person left
        if (clients.size() > 0) {
            sendConnectionStatus(client, false);
        }
        checkClients();
    }

    private void syncCurrentUsers(ServerThread client) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread existingClient = iter.next();
            if (existingClient.getClientId() == client.getClientId()) {
                continue;// don't sync ourselves
            }
            boolean messageSent = client.sendExistingClient(existingClient.getClientId(),
                    existingClient.getClientName());
            if (!messageSent) {
                handleDisconnect(iter, existingClient);
                break;// since it's only 1 client receiving all the data, break if any 1 send fails
            }
        }
    }

    /***
     * Checks the number of clients.
     * If zero, begins the cleanup process to dispose of the room
     */
    private void checkClients() {
        // Cleanup if room is empty and not lobby
        if (!name.equalsIgnoreCase(Constants.LOBBY) && (clients == null || clients.size() == 0)) {
            close();
        }
    }

    private ServerThread getClientByName(String username) {
        for (ServerThread client : clients) {
            if (client.getClientName().equals(username)) {
                return client;
            }
        }
        return null;
    }

    /***
     * Helper function to process messages to trigger different functionality.
     * 
     * @param message The original message being sent
     * @param client  The sender of the message (since they'll be the ones
     *                triggering the actions)
     */
    @Deprecated // not used in my project as of this lesson, keeping it here in case things
                // change
    private boolean processCommands(String message, ServerThread client) {
        boolean wasCommand = false;
        try {
            if (message.startsWith(COMMAND_TRIGGER)) {
                String[] comm = message.split(COMMAND_TRIGGER);
                String part1 = comm[1];
                String[] comm2 = part1.split(" ");
                String command = comm2[0];
                String roomName;
                wasCommand = true;
                switch (command) {
                    case CREATE_ROOM:
                        roomName = comm2[1];
                        Room.createRoom(roomName, client);
                        break;
                    case JOIN_ROOM:
                        roomName = comm2[1];
                        Room.joinRoom(roomName, client);
                        break;
                    case ROLL:
                        String text = comm2[1];
                        if (text.contains("d")) {
                            String[] arrOfStr = text.split("d", 2);
                            String numOfDice = arrOfStr[0];
                            String max = arrOfStr[1];
                            int maxNum = Integer.parseInt(max);
                            int numDice = Integer.parseInt(numOfDice);
                            double result = ((Math.random() * ((numDice * maxNum) - numDice)) + numDice);
                            int result1 = (int) result;
                            message = "triggered roll: *b The result of the roll is: " + result1 + "b*";
                            // *b displays roll command in bold format
                            sendMessage(client, message);
                        } else {
                            int num = Integer.parseInt(text);
                            int randomNum = (int) (Math.random() * (num - 1)) + 1;
                            message = "triggered roll: *b The result of the roll is: " + randomNum + "b*";
                            // *b displays roll command in bold format
                            sendMessage(client, message);
                        }
                        break;
                    case FLIP:
                        Random random = new Random();
                        int result = random.nextInt(2);
                        if (result == 0) {
                            message = "triggered flip: *bThe result of the coin flip is heads.b*";
                            // *b displays flip command in bold format
                        } else {
                            message = "triggered flip: *bThe result of the coin flip is tails.b*";
                        }
                        sendMessage(client, message);
                        info("Flip command triggered");
                        wasCommand = true;
                        break;
                    case DISCONNECT:
                    case LOGOUT:
                    case LOGOFF:
                        Room.disconnectClient(client, this);
                        break;
                    // kpz2 5/5/23
                    case MUTE:
                        String username = comm2[1];
                        ServerThread mutedClient = getClientByName(username);
                        if (mutedClient != null) {
                            mutedClients.add(mutedClient);
                            sendMessage(client,
                                    "You have muted user " + username + " (muted by " + client.getClientName() + ")");
                            sendMessage(mutedClient, "You have been muted by " + client.getClientName());
                        } else {
                            sendMessage(client, "User " + username + " not found");
                        }
                        break;
                    case UNMUTE:
                        String unmuteUsername = comm2[1];
                        ServerThread unmutedClient = getClientByName(unmuteUsername);
                        if (unmutedClient != null) {
                            mutedClients.remove(unmutedClient);
                            sendMessage(client, "Unmuted user " + unmuteUsername);
                            break;
                        }
                    default:
                        wasCommand = false;
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wasCommand;
    }

    // Command helper methods
    protected static void getRooms(String query, ServerThread client) {
        String[] rooms = Server.INSTANCE.getRooms(query).toArray(new String[0]);
        client.sendRoomsList(rooms,
                (rooms != null && rooms.length == 0) ? "No rooms found containing your query string" : null);
    }

    protected static void createRoom(String roomName, ServerThread client) {
        if (Server.INSTANCE.createNewRoom(roomName)) {
            Room.joinRoom(roomName, client);
        } else {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s already exists", roomName));
        }
    }

    /**
     * Will cause the client to leave the current room and be moved to the new room
     * if applicable
     * 
     * @param roomName
     * @param client
     */
    protected static void joinRoom(String roomName, ServerThread client) {
        if (!Server.INSTANCE.joinRoom(roomName, client)) {
            client.sendMessage(Constants.DEFAULT_CLIENT_ID, String.format("Room %s doesn't exist", roomName));
        }
    }

    protected static void disconnectClient(ServerThread client, Room room) {
        client.disconnect();
        room.removeClient(client);
    }
    // end command helper methods

    /***
     * Takes a sender and a message and broadcasts the message to all clients in
     * this room. Client is mostly passed for command purposes but we can also use
     * it to extract other client info.
     * 
     * @param sender  The client sending the message
     * @param message The message to broadcast inside the room
     * 
     */

    protected synchronized void sendMessage(ServerThread sender, String message) {
        if (!isRunning) {
            return;
        }
        info("Sending message to " + clients.size() + " clients");
        if (sender != null && processCommands(message, sender)) {
            // it was a command, don't broadcast
            return;
        }

        // Process commands
        if (sender != null && processCommands(message, sender)) {
            return;
        }

        // Check if it is a private message
        if (message.startsWith("@")) {
            String[] privateMessage = message.split("\\s", 2);
            if (privateMessage.length > 1) {
                String username = privateMessage[0].substring(1);
                String privateMsg = privateMessage[1];
                // Find the receiver
                for (ServerThread client : clients) {
                    if (client.getClientName().equals(username)) {
                        // Send the private message to the sender and recipient
                        sender.sendMessage(sender.getClientId(), "To " + username + ": " + privateMsg);
                        client.sendMessage(sender.getClientId(), "From " + sender.getClientName() + ": " + privateMsg);
                        return;
                    }
                }
            }
        }
        // Filter and broadcast the message to all clients
        if (message.contains("*b")) {
            message = message.replace("*b", "<b>");
            message = message.replace("b*", "</b>");
        }
        if (message.contains("*")) {
            message = message.replace("*i", "<i>");
            message = message.replace("i*", "</i>");
        }
        if (message.contains("*u")) {
            message = message.replace("*u", "<u>");
            message = message.replace("u*", "</u>");
        }
        if (message.contains("#r")) {
            message = message.replace("#r", "<font color = 'red'>");
            message = message.replace("r#", "</font>");
        }
        if (message.contains("#b")) {
            message = message.replace("#b", "<font color = 'blue'>");
            message = message.replace("b#", "</font>");
        }
        if (message.contains("#g")) {
            message = message.replace("#g", "<font color = 'green'>");
            message = message.replace("g#", "</font>");
        }

        long from = sender == null ? Constants.DEFAULT_CLIENT_ID : sender.getClientId();
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread client = iter.next();
            if (client != sender && mutedClients.contains(client)) { // check if client is muted, but not the sender
                continue;
            }
            boolean messageSent = client.sendMessage(from, message);
            if (!messageSent) {
                handleDisconnect(iter, client);
            }
        }
    }

    

    protected synchronized void sendConnectionStatus(ServerThread sender, boolean isConnected) {
        Iterator<ServerThread> iter = clients.iterator();
        while (iter.hasNext()) {
            ServerThread receivingClient = iter.next();
            boolean messageSent = receivingClient.sendConnectionStatus(
                    sender.getClientId(),
                    sender.getClientName(),
                    isConnected);
            if (!messageSent) {
                handleDisconnect(iter, receivingClient);
            }
        }
    }

    protected void handleDisconnect(Iterator<ServerThread> iter, ServerThread client) {
        if (iter != null) {
            iter.remove();
        } else {
            Iterator<ServerThread> iter2 = clients.iterator();
            while (iter2.hasNext()) {
                ServerThread th = iter2.next();
                if (th.getClientId() == client.getClientId()) {
                    iter2.remove();
                    break;
                }
            }
        }
        logger.info(String.format("Removed client %s", client.getClientName()));
        sendMessage(null, client.getClientName() + " disconnected");
        checkClients();
    }

    public void close() {
        Server.INSTANCE.removeRoom(this);
        isRunning = false;
        clients.clear();
    }
}