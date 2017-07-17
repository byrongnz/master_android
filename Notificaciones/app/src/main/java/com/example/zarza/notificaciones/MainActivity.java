package com.example.zarza.notificaciones;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button) findViewById(R.id.button);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              crearNotificacionSimple();
            }
        });
    }

    public void crearNotificacionSimple(){

        /*Creamos un objeto de NotificationCompat.Builder que contiene toda la información
        * y acciones del de la interfaz gráfica*/

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder)
                new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("Proteco cursos")
                .setContentText("Aprendiendo notifications básico");

        mBuilder.setPriority(-2);       /*Asignamos prioridad a la notificación*/
        mBuilder.setAutoCancel(true);   /*Efecto: La notificación se elimina al hacer clic en esta*/

        /*Creamos una intención que se lanzará al hacer clic en la notificación*/
        Intent aviso = new Intent(this,Notification.class);

        /*VIRTUAL  STACK*/
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

        /*AGREGAMOS ACTIVIDAD NOTIFICATION A LA BASE DE LA PILA*/
        stackBuilder.addParentStack(Notification.class);

        /*AGREGAMOS ACTIVIDAD MAIN AL TOPE DE LA PILA*/
        stackBuilder.addNextIntent(aviso);


        /*Creamos un pendingIntent object to poder lanzar la Activity NOTIFICATION
        * creado por la pila virtual
        * el primer parámetro es un código de solicitud y la bandera de servicio*/

        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
                0,PendingIntent.FLAG_UPDATE_CURRENT
        );

        /*Asignamos el Pending a la notificación*/
        mBuilder.setContentIntent(resultPendingIntent);


        /*Creamos un obkect de notificationManager para gestionar la notification*/
        NotificationManager notificationManager =
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        /*Lanzamos la notificación*/
        notificationManager.notify(0,mBuilder.build());

    }


}















