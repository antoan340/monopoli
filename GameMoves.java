import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GameMoves {

    private static void playerOneMovment(String[][] gameBoard, String[][] gameTrap,Scanner word) {
        int diceOne, diceTwo, dice;
        int row = 7,colune=3;
        int playerOneHPosition=0, playerOneLPosition=0;
        for (int i=0;i<=colune;i++){
            for (int j=0;j<=row;j++){
                if(gameBoard[i][j].equals("|1 |")||gameBoard[i][j].equals("|12|")){
                    playerOneHPosition=i;
                    playerOneLPosition=j;
                }
            }
        }
        System.out.println("Натиснете ENTER за да хвърлите зара");
        String enter = word.nextLine();
        diceOne = ThreadLocalRandom.current().nextInt(1, 3);
        diceTwo = ThreadLocalRandom.current().nextInt(1, 3);
        dice = diceOne + diceTwo;
        MapGeneration.printGameboard(gameBoard);
        if (gameBoard[playerOneHPosition][playerOneLPosition] == "|12|")
            gameBoard[playerOneHPosition][playerOneLPosition] = "| 2|";
        if (gameBoard[playerOneHPosition][playerOneLPosition] == "|1 |")
            gameBoard[playerOneHPosition][playerOneLPosition] = "|  |";
        System.out.println("Вие хвърлихте " + dice);
        for (int i = 1; i <= dice; i++) {
            if (playerOneHPosition < 3 && playerOneHPosition >= 0 && playerOneLPosition == 7) {
                playerOneHPosition++;
            }
            if (playerOneLPosition < 7 && playerOneLPosition >= 0 && playerOneHPosition == 0) {
                playerOneLPosition++;
            }
            if (playerOneHPosition <= 3 && playerOneHPosition > 0 && playerOneLPosition == 0) {
                playerOneHPosition--;
            }
            if (playerOneLPosition <= 7 && playerOneLPosition > 0 && playerOneHPosition == 3) {
                playerOneLPosition--;
            }
        }

        if (gameBoard[playerOneHPosition][playerOneLPosition] == "| 2|")
            gameBoard[playerOneHPosition][playerOneLPosition] = "|12|";
        if (gameBoard[playerOneHPosition][playerOneLPosition] == "|  |")
            gameBoard[playerOneHPosition][playerOneLPosition] = "|1 |";
        MapGeneration.printGameboard(gameBoard);

    }

    private static void playerTwoMovment(String[][] gameBoard, String[][] gameTrap,Scanner word) {
        int diceOne, diceTwo, dice;
        int colune=3,row=7;
        int playerTwoHPosition = 0, playerTwoLPosition = 0;
        for (int i=0;i<=colune;i++){
            for (int j=0;j<=row;j++){
                if(gameBoard[i][j].equals("| 2|")||gameBoard[i][j].equals("|12|")){
                    playerTwoHPosition=i;
                    playerTwoLPosition=j;
                }
            }
        }
        System.out.println("Натиснете ENTER за да хвърлите зара");
        String enter = word.nextLine();
        diceOne = ThreadLocalRandom.current().nextInt(1, 3);
        diceTwo = ThreadLocalRandom.current().nextInt(1, 3);
        dice = diceOne + diceTwo;
        MapGeneration.printGameboard(gameBoard);
        if (gameBoard[playerTwoHPosition][playerTwoLPosition] == "|12|")
            gameBoard[playerTwoHPosition][playerTwoLPosition] = "|1 |";
        if (gameBoard[playerTwoHPosition][playerTwoLPosition] == "| 2|")
            gameBoard[playerTwoHPosition][playerTwoLPosition] = "|  |";
        MapGeneration.printGameboard(gameBoard);
        System.out.println("Вие хвърлихте " + dice);
        for (int i = 1; i <= dice; i++) {

            if (playerTwoHPosition < 3 && playerTwoHPosition >= 0 && playerTwoLPosition == 7) {
                playerTwoHPosition++;
            }
            if (playerTwoLPosition < 7 && playerTwoLPosition >= 0 && playerTwoHPosition == 0) {
                playerTwoLPosition++;
            }
            if (playerTwoHPosition <= 3 && playerTwoHPosition > 0 && playerTwoLPosition == 0) {
                playerTwoHPosition--;
            }
            if (playerTwoLPosition <= 7 && playerTwoLPosition > 0 && playerTwoHPosition == 3) {
                playerTwoLPosition--;

            }

        }
        if (gameBoard[playerTwoHPosition][playerTwoLPosition] == "|1 |")
            gameBoard[playerTwoHPosition][playerTwoLPosition] = "|12|";
        if (gameBoard[playerTwoHPosition][playerTwoLPosition] == "|  |")
            gameBoard[playerTwoHPosition][playerTwoLPosition] = "| 2|";
        MapGeneration.printGameboard(gameBoard);

    }

    public static void gameSettings(String[][] gameBoard, String[][] gameTrap) {

        int diceOneCount=0,diceTwoCount=0;
        Scanner word = new Scanner(System.in);
        do {
            playerOneMovment(gameBoard, gameTrap,word);
            playerTwoMovment(gameBoard, gameTrap,word);
        } while (diceOneCount<20&&diceTwoCount<20);
    }
    private static void cheetLoop(){

    }

}
