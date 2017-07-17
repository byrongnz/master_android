package com.example.zarza.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Vibrator;
import android.widget.Toast;

public class MyService extends Service {
    Vibrator mVibrator;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        mVibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        mVibrator.vibrate(new long[] { 0, 200, 0 }, 0);;
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mVibrator.cancel();
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }
}
