package com.vhontar.beatbox;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BeatBoxFragment extends Fragment {

    private RecyclerView mRvBeatBox;

    public static BeatBoxFragment newInstance() {
        BeatBoxFragment beatBoxFragment = new BeatBoxFragment();
        return beatBoxFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_beat_box, null);

        mRvBeatBox = v.findViewById(R.id.rv_fbb_beat_box);
        mRvBeatBox.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mRvBeatBox.setAdapter(new SoundAdapter());

        return v;
    }

    private class SoundHolder extends RecyclerView.ViewHolder {

        private Button mBtnSound;

        public SoundHolder(@NonNull LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.list_item_sound, container));
            mBtnSound = itemView.findViewById(R.id.btn_lis_sound);
        }
    }

    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {

        @NonNull
        @Override
        public SoundHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new SoundHolder(layoutInflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull SoundHolder soundHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

}
