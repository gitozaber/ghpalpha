package ua.ck.ghpalpha.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import ua.ck.ghpalpha.R;
import ua.ck.ghpalpha.adapters.TrackListAdapter;
import ua.ck.ghpalpha.data.TrackList;
import ua.ck.ghpalpha.interfaces.ClickListener;
import ua.ck.ghpalpha.listeners.RecyclerTouchListener;
import ua.ck.ghpalpha.models.Track;

public class TrackListFragment extends Fragment implements ClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_track_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // VIEWS
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_track_list_recycler_view);

        // ADAPTER
        final TrackListAdapter trackListAdapter = new TrackListAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // TOUCH
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, this));

        recyclerView.setAdapter(trackListAdapter);
    }

    @Override
    public void onClick(View view, int position) {
        ArrayList<Track> trackList = TrackList.getInstance().getTrackList(getContext());
        Toast.makeText(getContext(), trackList.get(position).getTitle(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLongClick(View view, int position) {
        ArrayList<Track> trackList = TrackList.getInstance().getTrackList(getContext());
        Toast.makeText(getContext(), trackList.get(position).getAlbum(), Toast.LENGTH_SHORT).show();

    }

}
