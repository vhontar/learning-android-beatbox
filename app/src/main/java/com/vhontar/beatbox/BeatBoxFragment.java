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

import com.vhontar.beatbox.helpers.BeatBox;
import com.vhontar.beatbox.models.Sound;

import java.util.List;

public class BeatBoxFragment extends Fragment {

    private RecyclerView mRvBeatBox;

    private BeatBox mBeatBox;

    public static BeatBoxFragment newInstance() {
        BeatBoxFragment beatBoxFragment = new BeatBoxFragment();
        return beatBoxFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        mBeatBox = new BeatBox(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_beat_box, null);

        mRvBeatBox = v.findViewById(R.id.rv_fbb_beat_box);
        mRvBeatBox.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mRvBeatBox.setAdapter(new SoundAdapter(mBeatBox.getSounds()));

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBeatBox.release();
    }

    private class SoundHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private Button mBtnSound;

        private Sound mSound;

        public SoundHolder(@NonNull LayoutInflater inflater, ViewGroup container) {
            super(inflater.inflate(R.layout.list_item_sound, container, false));
            mBtnSound = itemView.findViewById(R.id.btn_lis_sound);
            mBtnSound.setOnClickListener(this);
        }

        public void bindSound(Sound sound) {
            mSound = sound;
            mBtnSound.setText(mSound.getName());
        }

        @Override
        public void onClick(View v) {
            mBeatBox.play(mSound);
        }
    }

    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {

        private List<Sound> mSounds;

        public SoundAdapter(List<Sound> sounds) {
            mSounds = sounds;
        }

        @NonNull
        @Override
        public SoundHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new SoundHolder(layoutInflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull SoundHolder soundHolder, int i) {
            Sound sound = mSounds.get(i);
            soundHolder.bindSound(sound);
        }

        @Override
        public int getItemCount() {
            return mSounds.size();
        }
    }

}
