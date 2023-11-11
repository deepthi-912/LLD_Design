package MusicRecommendation;

//A library of songs in the application’s in-memory data store. Songs can be described by the following attributes: genre, tempo, singer, popularity_score, release year etc..
//        User: Each user will have a list of friends.
//        Playlist: Each user has a playlist of songs that he/she can choose to play from.
//        Similarity-Index (SI): SI between two songs s1 and s2 = Number of same attributes between s1 and s2 / total number of attributes of a song.
//
//        We need to design a system that recommends a set of songs from our music library (which are currently not present in his/her playlist) to the user based on the Similarity-Index (SI) with the songs present in his/her playlist.
//        Requirements:
//        Add songs to library where songs can be uniquely identified by song name
//        Add users with their playlist of songs(by song name). User can be uniquely identified by name
//        Add friends(by user name) to the given user
//        Show song recommendations for a given user, based on SimilarityIndex(Songs recommended are ordered based on similarity Index high - low)(Do not include songs part of the user playlist)

import java.util.*;

class Song {
    String songName;
    String genre;
    String tempo;
    String singer;
    Double popularity_score;
    String year;

    public Song(String songName, String genre, String tempo, String singer, Double popularity_score, String year) {
        this.songName = songName;
        this.genre = genre;
        this.tempo = tempo;
        this.singer = singer;
        this.popularity_score = popularity_score;
        this.year = year;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Double getPopularity_score() {
        return popularity_score;
    }

    public void setPopularity_score(Double popularity_score) {
        this.popularity_score = popularity_score;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
class User {
    String userId;
    String userName;
    String email;
    String phoneNum;

    public User(String userId, String userName, String email, String phoneNum) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.phoneNum = phoneNum;
    }
}
class Playlist {
    String userId;
    String playListName;
    List<Song> playlistSongs;

    public Playlist(String userId, String playListName, List<Song> playlistSongs) {
        this.userId = userId;
        this.playListName = playListName;
        this.playlistSongs = playlistSongs;
    }
}
public class MusicRecommendationSystem {
    HashMap<String, Song> songsMapLibraryList; // all songs list with the song name as the key

    // users playlist with the list of playlists mapping to a particular user key
    HashMap<String, Playlist> usersPlaylists;

    //map of friends
    HashMap<String, List<String>> friendsMap;

    void addSongToLibrary(String songName, String genre, String tempo, String singer, Double popularity_score, String year) {
        songsMapLibraryList.put(songName, new Song(songName, genre, tempo, singer, popularity_score, year));
    }

    void addFriend(String user1, String user2) {
        List<String> friends = friendsMap.get(user1);
        friends.add(user2);
    }

    void addUser(String userId, String userName, String email, String phoneNum) {
        User newUser = new User(userId, userName, email, phoneNum);
    }

    void addPlayList(String userId, String playlistName) {
        Playlist playlist = new Playlist(userId, playlistName, new ArrayList<Song>());
        usersPlaylists.put(userId, playlist);
    }

    void showRecommendations(String user) {
        Playlist userPlayList = usersPlaylists.get(user);
        List<Song> userPlaylistSongs = userPlayList.playlistSongs;
        List<Song> listOfRecommendedSongs = new ArrayList<>();
        HashMap<Song, Double> mapOfRecommendedSongsScore = new HashMap<>();
        for(int i=0;i<userPlaylistSongs.size();i++) {
            for(Map.Entry<String, Song> entry : songsMapLibraryList.entrySet()) {
                if(!userPlaylistSongs.contains(entry.getValue())) {
                    mapOfRecommendedSongsScore.put(entry.getValue(), calculateSimilarityIndex(entry.getValue().getSongName(), userPlaylistSongs.get(i).getSongName()));
                }
            }
        }
    }
    Double calculateSimilarityIndex(String song1, String song2) {
        Song s1 = songsMapLibraryList.get(song1);
        Song s2 = songsMapLibraryList.get(song2);
        int count = 0;
        if(s1.getGenre()==s2.getGenre()) {
            count++;
        }
        if(s1.getSinger()==s2.getSinger()) {
            count++;
        }
        if(s1.getPopularity_score()==s2.getPopularity_score()) {
            count++;
        }
        if(s1.getYear()==s2.getYear()) {
            count++;
        }
        return count/4.0;
    }
}


