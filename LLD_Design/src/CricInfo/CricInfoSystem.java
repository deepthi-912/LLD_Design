package CricInfo;

import java.time.LocalDate;
import java.util.List;

enum RunType {
    FOUR, SIX, SINGLE, NO_BALL, WIDE;
}
enum MatchStatus {
    DRAW, CANCELLED, STARTED, LIVE, ENDED;
}
enum PlayerType {
    BATSMAN, BOWLER, ALLROUNDER;
}
enum MatchType {
    ODI, T20, TEST;
}
enum WicketType {
    BOLD, STUMPED, LBW, RUN_OUT,
}
class Team {
    String teamName;
    List<Player> playersList;
}
class Playing11 {
    List<Player> playerList;
    String matchId;
    String teamId;
    void addPlayer(Player player) {

    }
}
class Player {
    Person person;
    String teamId;
    PlayerType playerType;
}
class Ball {
    Over over;
    Run run;
    Player bowler;
    Player batsmen;
    Commentary commentary;
    void updateRuns(Run run) {

    }
}
class Commentary {
    Commentor commentor;
    String comment;
}
class Commentor {
    Person commentor;
    void assignMatch(Match matchId) {

    }
}

class Run {
    RunType runType;
    Integer numOfRuns;
}
class Person {
    String name;
    String sex;
    String color;
    String height;
    String weight;
}
class Match {
    String matchName;
    Stadium stadium;
    LocalDate matchDate;
    MatchType matchType;
}
class Tournament {
    String tournamentName;
    LocalDate startDate;
    LocalDate endDate;
    Stadium stadium;
    void addTeam(Team team1, Team team2) {

    }
}
class Stadium {
    String stadiumName;
    Address address;
}
class Over {
    Match matchid;
    Player Bowler;
    Integer overNumber;
    Player batsman;
}
class Wicket {
    Player bowler;
    WicketType wicketType;
    Player batsmen;
    Ball ballInfo;
}
class Admin {
    void addPlayerInTeam(Player player, Team tean) {

    }
    void addPlayerInPlayerTeam(Player player, Playing11 tean) {

    }
    void addMatch(Match match, Tournament tournament) {

    }
    void addTournament(Tournament tournament) {

    }
    void addPlaying11(Player player) {

    }
}
class Address {
    String streetName;
    String apartmentNumber;
    String country;
    String state;
    String pincode;
}
class T20 extends Match {

}
class ODI extends Match {

}
class Test extends Match {

}
class StatisticsService {
    void getMatchStatistics(String matchId) {

    }
    void getTournamentStatistics(String tournamentId) {

    }
    void getPlayerStatistics(Player player) {

    }
    void getOverStatistics(Over over) {

    }
}
public class CricInfoSystem {

}
