package com.example.justinrashall.gaalarmclock;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class RingtonePlayingService extends Service {

    MediaPlayer media_song;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        media_song = MediaPlayer.create(this, R.raw.forest);
        media_song.start();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        // Tell the user we stopped
        Toast.makeText(this, "on Destroy called", Toast.LENGTH_SHORT).show();
    }
}
