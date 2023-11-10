package TicTacToe;


import java.util.*;

class Player {
    String playerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    Double rating;
    String email;
    String phoneNum;
    String password;
}
class Game {
    ArrayList<ArrayList<String>> gameBoard;
    HashMap<String, List<Player>> listOfPlayers;
    String gameId;
    String player1Id;
    String player2Id;

    public Game(ArrayList<ArrayList<String>> gameBoard, String gameId, String player1Id, String player2Id) {
        this.gameBoard = gameBoard;
        this.gameId = gameId;
        this.player1Id = player1Id;
        this.player2Id = player2Id;
    }

    void makeMove(String move, int row, int col, String userId) {
        gameBoard.get(row).set(col, move);
        int n = gameBoard.size();
        boolean flag1=true, flag2=true, flag3=true, flag4 = true;
        for(int i=0;i<n;i++) {
            if (!gameBoard.get(row).get(i).equals(move)) {
                flag1 = false;
            }
            if (!gameBoard.get(i).get(col).equals(move)) {
                flag2 = false;
            }
            if((col==n-1-row)&&!gameBoard.get(i).get(n-i-1).equals(move)) {
                flag3=false;
            }
            if((col==row) && !gameBoard.get(i).get(i).equals(move)) {
                flag4=false;
            }
        }
        if(flag1 || flag2 || flag3 || flag4) {
            System.out.println("Winner is " + userId);
        }
    }

}

class LeadershipBoard {
    HashMap<Double, Player> playersList = new HashMap<>();
    Map<Double, Player> sortedPlayerList = new TreeMap<>(playersList);
    List<Player> leaderShipBoard(Map<Double, Player> leaderShip) {
        List<Player> playersLeaderBoard = null;
        for(Map.Entry<Double, Player> entry : leaderShip.entrySet()) {
            playersLeaderBoard.add(entry.getValue());
        }
        return playersLeaderBoard;
    }
}
public class TicTacToeSystem {
    String gameName;
    Integer numofSquares;

    public TicTacToeSystem(String gameName, Integer numofSquares) {
        this.gameName = gameName;
        this.numofSquares = numofSquares;
    }
}
