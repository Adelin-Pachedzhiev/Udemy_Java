import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songs.add(new Song(title, duration));

    }


    public boolean addToPlayList(int trackNum, LinkedList<Song> songsList) {
        Song songFound = songs.findSong(trackNum);
        if (songFound == null) {
            return false;
        }
        songsList.add(songFound);
        return true;
    }

    public boolean addToPlayList(String title, LinkedList<Song> songsList) {

        Song songFound = songs.findSong(title);
        if (songFound == null) {
            return false;
        }
        for (Song song : songsList) {
            if (song.getTitle().equals(title)) {
                return false;
            }
        }
        songsList.add(songFound);
        return true;
    }

    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
            if (findSong(song.getTitle()) != null) {
                return false;
            }
            songs.add(song);
            return true;
        }

        private Song findSong(String title) {
            for (Song currentSong : songs) {
                if (currentSong.getTitle().equals(title)) {
                    return currentSong;
                }
            }
            return null;
        }

        private Song findSong(int trackNum) {
            int index = trackNum - 1;
            if (index < 0 || index >= songs.size()) {
                return null;
            }
            return songs.get(index);
        }
    }
}
