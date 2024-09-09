import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Liyema Masala (st10453409)
 */
public class TicTacToe {
    
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();
    public static void main(String[] args) {
      
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, //gameboard
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};
        
        
 
        
        while(true){
                   Scanner scan = new Scanner(System.in);
                   System.out.println("Insert your placement(1-9):");
        int playerPos = scan.nextInt();
        while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){
            System.out.println("Position taken! Enter a correct position");
            playerPos = scan.nextInt();
        }

        
        placePiece(gameBoard, playerPos, "player");
        
        
                String result = checkWinner();
                        if(result != null){
            System.out.println(result);
            break;
        }
        
        Random rand = new Random();
        int cpuPos = rand.nextInt(9)+ 1;
                while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
            cpuPos = rand.nextInt(9)+ 1;
        }
        placePiece(gameBoard, cpuPos, "cpu");
        
         printGameBoard(gameBoard); //prints the gameboard 
         
        result =  checkWinner();
        if(result != null){
            System.out.println(result);
            break;
        }

        }

    }
    
    public static void printGameBoard(char[][] gameBoard) {
        for( char[] row : gameBoard) { 
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
    
    public static void placePiece(char[][] gameBoard, int pos, String user) {
        
        char symbol = ' ';
        
        if(user.equals("player")) {
            symbol = 'x';
            playerPositions.add(pos);
        }else if(user.equals("cpu")){
            symbol = 'o';
            cpuPositions.add(pos);
        }
        
                switch(pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
        
    }
    
    public static String checkWinner() { //winning conditions
        
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);
        
        List<List> winningConditions = new ArrayList<>();
        winningConditions.add(topRow);
        winningConditions.add(midRow);
        winningConditions.add(botRow);
        winningConditions.add(leftCol);
        winningConditions.add(midCol);
        winningConditions.add(rightCol);
        winningConditions.add(cross1);
        winningConditions.add(cross2);
        
        for(List l : winningConditions) {
            if(playerPositions.containsAll(l)){
                return "Congratulations you won :)";
            }else if(cpuPositions.containsAll(l)){
                return "CPU wins, sorry:(";
            }
        }
        
        if(playerPositions.size() + cpuPositions.size() == 9){
            return "It's a draw ;)";
        }
        
        return null;
    }
}