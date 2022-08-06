package com.example.rssreader;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;


public class Radio extends Fragment implements View.OnClickListener {

    private Button play, stop;
    MediaPlayer media = new MediaPlayer();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_radio, container, false);

        play = (Button) view.findViewById(R.id.play);
        play.setOnClickListener(this);
        stop = (Button) view.findViewById(R.id.stop);
        stop.setOnClickListener(this);
        stop.setVisibility(View.INVISIBLE);

            if(media.isPlaying()){
                play(getView());
            }else {

                try {
                    media.setDataSource("http://162.249.6.80:9998/;.mp3");
                    media.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    media.prepare();

                } catch (IOException e) {

                    Toast toast = Toast.makeText(view.getContext(), "Se ha perdido la conexión de Streaming", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.show();

                }
            }

        super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    public void ejecutar(View v) {
        media.start();
        stop.setEnabled(true);
        play.setEnabled(false);
        stop.setVisibility(View.VISIBLE);
        play.setVisibility(View.INVISIBLE);

    }

    public void play(View v){
        media.pause();
        play.setEnabled(true);
        stop.setEnabled(false);
        stop.setVisibility(View.INVISIBLE);
        play.setVisibility(View.VISIBLE);
    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.play) {

            ejecutar(getView());

        }else if(v.getId() == R.id.stop){

            play(getView());

        }

    }
}
