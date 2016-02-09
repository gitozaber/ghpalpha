package ua.ck.ghpalpha.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ua.ck.ghpalpha.R;
import ua.ck.ghpalpha.data.TrackList;
import ua.ck.ghpalpha.models.Track;

public class TrackListAdapter extends RecyclerView.Adapter<TrackListAdapter.MyViewHolder> {

    // TRACK LIST
    private Context context;
    private ArrayList<Track> trackList;

    public TrackListAdapter(Context context) {
        this.context = context;
        this.trackList = TrackList.getInstance().getTrackList(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_track_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.id.setText(String.valueOf(trackList.get(position).getId()));
        holder.album.setText(trackList.get(position).getAlbum());
        holder.artist.setText(trackList.get(position).getArtist());
        holder.title.setText(trackList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        // VIEWS
        public TextView id;
        public TextView album;
        public TextView artist;
        public TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.item_track_list_id);
            album = (TextView) itemView.findViewById(R.id.item_track_list_album);
            artist = (TextView) itemView.findViewById(R.id.item_track_list_artist);
            title = (TextView) itemView.findViewById(R.id.item_track_list_title);
        }
    }

}
