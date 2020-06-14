import java.util.concurrent.ThreadLocalRandom;

public class MapGeneration {
    public static void map() {
        String[][] gameBoard = {
                {"|  |", "|  |", "|  |", "|  |", "|  |", "|  |", "|  |", "|  |"},
                {"|  |", "    ", "    ", "    ", "    ", "    ", "    ", "|  |"},
                {"|  |", "    ", "    ", "    ", "    ", "    ", "    ", "|  |"},
                {"|  |", "|  |", "|  |", "|  |", "|  |", "|  |", "|  |", "|12|"},
        };

        String[][] gameTrap = {
                {"|X|", "|X|", "|X|", "|X|", "|X|", "|X|", "|X|", "|X|"},
                {"|X|", "   ", "   ", "   ", "   ", "   ", "   ", "|X|"},
                {"|X|", "   ", "   ", "   ", "   ", "   ", "   ", "|X|"},
                {"|X|", "|X|", "|X|", "|X|", "|X|", "|X|", "|X|", "|S|"},
        };
        traps(gameTrap);
        printGameboard(gameTrap);
        GameMoves.gameSettings(gameBoard,gameTrap);
    }
    public static void printGameboard(String[][] gameBoard) {
        for (String[] row : gameBoard) {
            for (String c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void traps(String[][]gameTrap){
        int hight,length;
        int trap=7,invest=3,partyHard=3,chance=3,steal=3;
        int trapCount=7,investCount=3,partHardCount=3,chanceCount=3,stealCount=3;
        // t=trap/i=invest/p=partyHard/c=chance/s=steal
        for(int i=0;i<=7;i++){
            do {
                hight = ThreadLocalRandom.current().nextInt(0, 4);
                length = ThreadLocalRandom.current().nextInt(0, 8);
                if (gameTrap[hight][length] == "|X|") {
                    gameTrap[hight][length] = "|t|";
                    trap--;

                }
            }while (trap==trapCount&&trap>0);
            trapCount--;
            while (invest==investCount&&invest>0){
                hight = ThreadLocalRandom.current().nextInt(0, 4);
                length = ThreadLocalRandom.current().nextInt(0, 8);
                if (gameTrap[hight][length] == "|X|") {
                    gameTrap[hight][length] = "|i|";
                    invest--;
                }
            }
            investCount--;
            while (partyHard==partHardCount&&partyHard>0){
                hight = ThreadLocalRandom.current().nextInt(0, 4);
                length = ThreadLocalRandom.current().nextInt(0, 8);
                if (gameTrap[hight][length] == "|X|") {
                    gameTrap[hight][length] = "|p|";
                    partyHard--;
                }
            }
            partHardCount--;
            while (chance==chanceCount&&chance>0){
                hight = ThreadLocalRandom.current().nextInt(0, 4);
                length = ThreadLocalRandom.current().nextInt(0, 8);
                if (gameTrap[hight][length] == "|X|") {
                    gameTrap[hight][length] = "|c|";
                    chance--;
                }
            }
            chanceCount--;
            while (steal==stealCount&&steal>0){
                hight = ThreadLocalRandom.current().nextInt(0, 4);
                length = ThreadLocalRandom.current().nextInt(0, 8);
                if (gameTrap[hight][length] == "|X|") {
                    gameTrap[hight][length] = "|s|";
                    steal--;
                }
            }
            stealCount--;

        }


    }
}