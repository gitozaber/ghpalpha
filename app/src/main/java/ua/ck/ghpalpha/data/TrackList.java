package ua.ck.ghpalpha.data;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

import ua.ck.ghpalpha.models.Track;

public class TrackList {

    // CONSTANTS
    private String[] projection = {
            MediaStore.Audio.Media._ID,             // Type: INTEGER (long)     Constant Value: "_id"
            MediaStore.Audio.Media.ALBUM,           // Type: TEXT               Constant Value: "album"
            MediaStore.Audio.Media.ARTIST,          // Type: TEXT               Constant Value: "artist"
            MediaStore.Audio.Media.TITLE            // Type: TEXT               Constant Value: "title"
    };

    private static TrackList instance;

    private TrackList() {
    }

    public static synchronized TrackList getInstance() {
        if (instance == null) {
            instance = new TrackList();
        }
        return instance;
    }

    public ArrayList<Track> getTrackList(Context context) {

        ArrayList<Track> trackList = new ArrayList<>();
        Uri uriExternalContent = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = contentResolver.query(
                uriExternalContent,
                projection,
                null,
                null,
                "artist ASC"
        );

        if (cursor != null) {
            cursor.moveToFirst();
            do {
                long id = cursor.getLong(cursor.getColumnIndex("_id"));
                String album = cursor.getString(cursor.getColumnIndex("album"));
                String artist = cursor.getString(cursor.getColumnIndex("artist"));
                String title = cursor.getString(cursor.getColumnIndex("title"));
                trackList.add(new Track(id, album, artist, title));
            } while (cursor.moveToNext());
            cursor.close();
        }

        return trackList;
    }
}
