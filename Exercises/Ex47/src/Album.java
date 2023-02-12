import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration){
        if(findSong(title) != null){
            return false;
        }
        songs.add(new Song(title, duration));
        return true;
    }

    private Song findSong(String title){
        for (Song currentSong : songs) {
            if (currentSong.getTitle().equals(title)) {
                return currentSong;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNum, LinkedList<Song> songsList){
        int index = trackNum - 1;
        if(index < 0 || index >= songs.size()){
            return false;
        }
//        Song songToAdd = songs.get(trackNum);
//        for(Song song: songsList){
//            if(song.getTitle().equals(songToAdd.getTitle())){
//                return false;
//            }
//        }
        songsList.add(songs.get(index));
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> songsList){
        
        Song songFound = findSong(title);
        if(songFound == null){
            return false;
        }
        for(Song song: songsList){
            if(song.getTitle().equals(title)){
                return false;
            }
        }
        songsList.add(songFound);
        return true;
    }
}
