package com.usocamara;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btnFoto;
    ImageView imgFoto;
    Bitmap foto;

    //Identificador de actividad de foto
    public static final int FOTO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFoto = (Button)findViewById(R.id.btnCaptura);
        imgFoto = (ImageView)findViewById(R.id.imgFoto);

        //Listener para botón de captura de foto
        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capturar();
            }
        });
    }

    public void capturar(){
        //Llamada de actividad implicíta
        Intent captura = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Se inicia la actividad con el identificador FOTO
        startActivityForResult(captura,FOTO);
    }

    //Listener de actividades
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Si la actividad capturada fue una foografía
        if(resultCode == RESULT_OK){
            //Se asgina la información de la actividad y se agrega al ImageView
            Bundle extras = data.getExtras();
            foto = (Bitmap)extras.get("datos");
            imgFoto.setImageBitmap(foto);
        }
    }
}
