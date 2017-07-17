package com.example.cursos.multimedia;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    int SELECT_IMAGE_REQUEST = 123;
    int SELECT_AUDIO_REQUEST = 456;
    int SELECT_VIDEO_REQUEST = 789;
    private VideoView vidView;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vidView = (VideoView) findViewById(R.id.video);
        imgView = (ImageView) findViewById(R.id.imagen);
    }

    public void elegirImagen(View v) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(
                intent, "Selecciona una imagen..."),
                SELECT_IMAGE_REQUEST
        );
    }

    public void elegirAudio(View v) {
        Intent intent = new Intent();
        intent.setType("audio/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(
                intent, "Selecciona una pista..."),
                SELECT_AUDIO_REQUEST
        );
    }

    public void elegirVideo(View v) {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(
                intent, "Selecciona un video..."),
                SELECT_VIDEO_REQUEST
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == SELECT_IMAGE_REQUEST) {
            Uri imgUri = data.getData();
            imgView.setImageURI(imgUri);
        }
        else if (resultCode == RESULT_OK && requestCode == SELECT_AUDIO_REQUEST) {
            Uri audioUri = data.getData();
            vidView.setVideoURI(audioUri);
            MediaController control = new MediaController(this);
            control.setAnchorView(vidView);
            vidView.setMediaController(control);
            vidView.start();
        }
        else if (resultCode == RESULT_OK && requestCode == SELECT_VIDEO_REQUEST) {
            Uri videoUri = data.getData();
            vidView.setVideoURI(videoUri);
            MediaController control = new MediaController(this);
            control.setAnchorView(vidView);
            vidView.setMediaController(control);
            vidView.start();
        }
    }
}
