import model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataSource source = new DataSource();
        if(!source.open()){
            System.out.println("Couldn't open db connection ");
            return;
        }
//        List<Artist> artists = source.queryArtists(5);
//
//        if (artists != null){
//            for (Artist artist: artists){
//                System.out.println(artist.getId() + " " + artist.getName());
//            }
//        }
//
//        List<Album> albums = source.queryAlbumForArtist("Iron Maiden", DataSource.ORDER_BY_ASC);
//        if (albums != null){
//            for (Album album: albums){
//                System.out.println(album.getId() + " " + album.getName() + " " + album.getArtist());
//            }
//        }

        List<SongArtist>  songArtists = source.queryArtistForSong("Go Your Own Way", DataSource.ORDER_BY_ASC);

        songArtists = source.querySongInfoView("Go Your Own Way");
        for(SongArtist songArtist: songArtists){
            System.out.println("Artist : " + songArtist.getArtistName() + " Album: " + songArtist.getAlbumName() + " Track: " + songArtist.getTrack());
        }
        System.out.println(source.getCount(DataSource.TABLE_SONGS ));

        source.createViewForSongArtists();

        source.insertSong("Evil Woman", "Black Sabbath", "Black Sabbath", 5);

        source.close();
    }
}