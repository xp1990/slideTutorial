package com.avanti.slidetutorial.Services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by emichniak on 19/01/2015.
 */
public class WebService extends Service{
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public class WebServiceBinder extends Binder{

    }
}
