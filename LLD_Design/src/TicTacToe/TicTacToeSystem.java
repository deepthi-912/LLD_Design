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
    Integer numWins;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getNumWins() {
        return numWins;
    }

    public void setNumWins(Integer numWins) {
        this.numWins = numWins;
    }
}
class Game {
    HashMap<String, Player> playerHashMap;
    ArrayList<ArrayList<String>> gameBoard;
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
            playerHashMap.get(userId).setNumWins(playerHashMap.get(userId).getNumWins()+1);
        }
    }
}

class LeadershipBoard {
    HashMap<String, Player> playersHashMap = new HashMap<>();
    List<Player> orderLeaderBoard(HashMap<String, Player> playersHashMap) {
        HashMap<String, Player> sortedHashMap = new HashMap<>();
        List<Player> sortedPlayers = new ArrayList<>();
        Comparator<String> comparator = (k1, k2) -> playersHashMap.get(k2).getNumWins().compareTo(playersHashMap.get(k1).getNumWins());
        // Create a TreeMap with the custom comparator
        Map<String, Player> sortedMap = new TreeMap<>(comparator);
        sortedHashMap.putAll(sortedMap);
        for(Map.Entry<String, Player> entry : sortedMap.entrySet()) {
            sortedPlayers.add(entry.getValue());
        }
        return sortedPlayers;
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
