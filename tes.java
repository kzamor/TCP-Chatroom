public class tes {

        public static void main(String[] args) {
          String text = "2d6";
                              if (text.contains("d")) {				
                                  String[] arrOfStr = text.split("d", 2);
                                  String numOfDice = arrOfStr[0];
                                  String max = arrOfStr[1];
                                  int min = 1;
							int maxNum = Integer.parseInt(max);
							int numDice = Integer.parseInt(numOfDice);
							int randomNum = (int) (Math.random() * (1 - maxNum)) + 1;
							String message = "The result of the roll is: " + randomNum*(maxNum - min)*numDice;
                                  System.out.println(message);
        }
      }
      
    
}
