package ua.ck.ghpalpha.models;

public class Track {

    // FIELDS
    private long id;
    private String album;
    private String artist;
    private String title;

    public Track(long id, String album, String artist, String title) {
        this.id = id;
        this.album = album;
        this.artist = artist;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
