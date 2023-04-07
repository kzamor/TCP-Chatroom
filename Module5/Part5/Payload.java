package Module5.Part5;
import java.io.Serializable;
public class Payload implements Serializable {
    //read https://www.baeldung.com/java-serial-version-uid
    private static final long serialVersionUID = 1L;//change this if the class changes
    
    /**
     * Determines how to process the data on the receiver's side
     */
    //getter method that returns payload type. kpz2 4/52023
    private PayloadType payloadType;
    public PayloadType getPayloadType() {
        return payloadType;
    }
    //setter method that sets the payload type
    public void setPayloadType(PayloadType payloadType) {
        this.payloadType = payloadType;
    }

    /**
     * Who the payload is from
     */
    // getter method that returns the client name.  kpz2 4/52023
    private String clientName;
    public String getClientName() {
        return clientName;
    }
    //setter method that sets the client name
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * Generic text based message
     */
    // string method that returns the message from the user. kpz2 4/52023
    private String message;
    public String getMessage() {
        return message;
    }
    // method that sets the mesasge from the user to the "message" variable
    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * Generic number for example sake
     */
    // setter and getter for the number
    private int number;
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    //toString method that returns the payload type, number and message in a string.  kpz2 4/52023
    @Override
    public String toString() {
	return String.format("Type[%s], Number[%s], Message[%s]", getPayloadType().toString(), getNumber(),
		getMessage());
    }
}
