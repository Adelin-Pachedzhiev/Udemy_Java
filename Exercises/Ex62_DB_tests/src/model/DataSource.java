package model;

import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/adelinpachedzhiev/Documents/Udemy/Java/Exercises/Ex62_DB_tests/" + DB_NAME;


    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUMS_ID = "_id";
    public static final String COLUMN_ALBUMS_NAME = "name";
    public static final String COLUMN_ALBUMS_ARTIST = "artist";
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;


    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTISTS_ID = "_id";
    public static final String COLUMN_ARTISTS_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONGS_ID = "_id";
    public static final String COLUMN_SONGS_TRACK = "track";
    public static final String COLUMN_SONGS_TITLE = "title";
    public static final String COLUMN_SONGS_ALBUM = "album";
    public static final int INDEX_SONGS_ID = 1;
    public static final int INDEX_SONGS_TRACK = 2;
    public static final int INDEX_SONGS_TITLE = 3;
    public static final int INDEX_SONGS_ALBUM = 4;

    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    public static final String QUERY_ALBUMS_BY_ARTIST_START = "SELECT * FROM " + TABLE_ALBUMS + " INNER JOIN " +
            TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ARTIST + " = " + TABLE_ARTISTS
            + "." + COLUMN_ARTISTS_ID + " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + " = " + "\"";

    public static final String QUERY_ALBUMS_BY_ARTIST_SORT = " ORDER BY " + COLUMN_ARTISTS_NAME + " COLLATE NOCASE ";

    public static final String QUERY_ARTIST_FOR_SONG_START = "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME +
            ", " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + ", " + TABLE_SONGS + "." + COLUMN_SONGS_TRACK +
            " FROM " + TABLE_SONGS + " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONGS_ALBUM +
            " = " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ID + " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ARTISTS +
            "." + COLUMN_ARTISTS_ID + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ARTIST + " WHERE " + TABLE_SONGS + "." +
            COLUMN_SONGS_TITLE + " = " + "\"";
    public static final String QUERY_ARTIST_FOR_SONG_SORT = " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME +
            ", " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + " COLLATE NOCASE ";

    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " + TABLE_ARTIST_SONG_VIEW + " AS SELECT " +
            TABLE_ARTISTS + "." + COLUMN_ARTISTS_NAME + ", " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_NAME + " AS " + COLUMN_SONGS_ALBUM
            + ", " +
            TABLE_SONGS + "." + COLUMN_SONGS_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONGS_TITLE + " FROM " + TABLE_SONGS +
            " INNER JOIN " +
            TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONGS_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ID +
            " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ARTIST + " = " + TABLE_ARTISTS +
            "." + COLUMN_ARTISTS_ID + " ORDER BY " + TABLE_ARTISTS + '.' + COLUMN_ARTISTS_NAME + ", " + TABLE_ALBUMS + "." +
            COLUMN_ALBUMS_NAME + ", " + TABLE_SONGS + "." + COLUMN_SONGS_TRACK;

    public static final String QUERY_VIEW_SONG_INFO = "SELECT " + COLUMN_ALBUMS_NAME + ", " + COLUMN_SONGS_ALBUM + ", " +
            COLUMN_SONGS_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + COLUMN_SONGS_TITLE + " = " + "\"";

    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTISTS_NAME + ", " + COLUMN_SONGS_ALBUM +
            ", " + COLUMN_SONGS_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW + " WHERE " + COLUMN_SONGS_TITLE + " = ?";

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS + "(" + COLUMN_ARTISTS_NAME + ") VALUES(?)";
    public static final String INSERT_ALBUMS = "INSERT INTO " + TABLE_ALBUMS +
            "(" + COLUMN_ALBUMS_NAME + ", " + COLUMN_ALBUMS_ARTIST + ") VALUES( ?, ?)";
    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS +
            "(" + COLUMN_SONGS_TRACK + ", " + COLUMN_SONGS_TITLE + ", " + COLUMN_SONGS_ALBUM +
            ") VALUES(?, ? ,?)";
    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTISTS_ID + " FROM " + TABLE_ARTISTS + " WHERE " +
            COLUMN_ARTISTS_NAME + " = ?";
    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUMS_ID + " FROM " + TABLE_ALBUMS + " WHERE " +
            COLUMN_ALBUMS_NAME + " = ?";

    public static final String QUERY_SONG = "SELECT " + TABLE_SONGS + "." + COLUMN_SONGS_ID + " FROM " + TABLE_SONGS + " INNER JOIN "
            + TABLE_ALBUMS + " ON "  + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ID + " = " + TABLE_SONGS + "." + COLUMN_SONGS_ALBUM
            + " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ARTISTS + "." + COLUMN_ARTISTS_ID + " = "
            + TABLE_ALBUMS + "." +  COLUMN_ALBUMS_ARTIST + " WHERE " + TABLE_SONGS + "." + COLUMN_SONGS_ALBUM + " = ? AND "
            + TABLE_SONGS + "." + COLUMN_SONGS_TITLE + " = ? AND " + TABLE_SONGS + "." + COLUMN_SONGS_TRACK + " = ?";

//    SELECT songs._id FROM songs INNER JOIN albums ON albums._id = songs.album INNER JOIN artists ON
//    artists._id = albums.artist WHERE songs.album ="260" AND songs.title="Let's Have A Party" AND songs.track = "6"


    private Connection conn;
    private PreparedStatement querySongInfoView;
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;
    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;
    private PreparedStatement querySong;


    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONGS);
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);
            querySong = conn.prepareStatement(QUERY_SONG);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        try {
            if (querySongInfoView != null) {
                querySongInfoView.close();
            }

            if (insertIntoArtists != null) {
                insertIntoArtists.close();
            }

            if (insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }

            if (insertIntoSongs != null) {
                insertIntoSongs.close();
            }

            if (queryAlbum != null) {
                queryAlbum.close();
            }

            if (queryArtist != null) {
                queryArtist.close();
            }

            if(querySong != null){
                querySong.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Artist> queryArtists(int sortOrder) {
        StringBuilder query = new StringBuilder("SELECT * FROM ");
        query.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE) {
            query.append(" ORDER BY ");
            query.append(COLUMN_ARTISTS_NAME);
            query.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC) {
                query.append("DESC");
            } else {
                query.append("ASC");
            }
        }
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query.toString())) {
            List<Artist> artists = new ArrayList<>();
            while (resultSet.next()) {
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(INDEX_ARTIST_ID));
                artist.setName(resultSet.getString(INDEX_ARTIST_NAME));
                artists.add(artist);

            }

            return artists;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Album> queryAlbumForArtist(String artist, int sortOrder) {
        List<Album> albums = new ArrayList<>();
        StringBuilder query = new StringBuilder(QUERY_ALBUMS_BY_ARTIST_START);
        query.append(artist);
        query.append("\"");
        if (sortOrder != ORDER_BY_NONE) {
            query.append(QUERY_ALBUMS_BY_ARTIST_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                query.append("DESC");
            } else {
                query.append("ASC");
            }
        }
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query.toString())) {

            while (resultSet.next()) {
                Album album = new Album();
                album.setId(resultSet.getInt(INDEX_ALBUM_ID));
                album.setArtist(resultSet.getInt(INDEX_ALBUM_ARTIST));
                album.setName(resultSet.getString(INDEX_ALBUM_NAME));
                albums.add(album);
            }

        } catch (SQLException e) {

        }

        return albums;
    }

    public List<SongArtist> queryArtistForSong(String songName, int sortOrder) {
        List<SongArtist> songArtists = new ArrayList<>();
        StringBuilder query = new StringBuilder(QUERY_ARTIST_FOR_SONG_START);
        query.append(songName);
        query.append("\"");
        if (sortOrder != ORDER_BY_NONE) {
            query.append(QUERY_ARTIST_FOR_SONG_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                query.append("DECS");
            } else {
                query.append("ASC");
            }
        }
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(query.toString())) {
            while (resultSet.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(resultSet.getString(1));
                songArtist.setAlbumName(resultSet.getString(2));
                songArtist.setTrack(resultSet.getInt(3));
                songArtists.add(songArtist);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songArtists;
    }

    public int getCount(String table) {
        String sql = "SELECT COUNT(*) FROM " + table;
        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            int count = resultSet.getInt(1);
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }

    }

    public boolean createViewForSongArtists() {
        try (Statement statement = conn.createStatement()) {

            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<SongArtist> querySongInfoView(String title) {

        try {
            querySongInfoView.setString(1, title);
            ResultSet resultSet = querySongInfoView.executeQuery();
            List<SongArtist> songArtists = new ArrayList<>();
            while (resultSet.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(resultSet.getString(1));
                songArtist.setArtistName(resultSet.getString(2));
                songArtist.setTrack(resultSet.getInt(3));
                songArtists.add(songArtist);
            }
            return songArtists;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    private int insertArtist(String name) throws SQLException {
        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();
        if (results.next()) {
            return results.getInt(1);
        } else {
            insertIntoArtists.setString(1, name);
            int affectedRows = insertIntoArtists.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert artist.");
            }

            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for artist");
            }
        }
    }

    private int insertAlbums(String name, int artistId) throws SQLException {
        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();
        if (results.next()) {
            return results.getInt(1);
        } else {
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistId);
            int affectedRows = insertIntoAlbums.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert album.");
            }

            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for album");
            }
        }
    }

    public void insertSong(String title, String artist, String album, int track) {
        try {
            conn.setAutoCommit(false);

            int artistId = insertArtist(artist);
            int albumId = insertAlbums(album, artistId);
            insertIntoSongs.setInt(1, track);
            insertIntoSongs.setString(2, title);
            insertIntoSongs.setInt(3, albumId);

            querySong.setInt(1, albumId);
            querySong.setString(2, title);
            querySong.setInt(3, track);

            ResultSet resultSet = querySong.executeQuery();
            if(!resultSet.next()){
                int affectedRows = insertIntoSongs.executeUpdate();

                if (affectedRows == 1) {
                    conn.commit();
                } else {
                    throw new SQLException("The song insert failed");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting default commit behaviour");
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                System.out.println("Couldn't reset auto commit");
            }
        }
    }
}
