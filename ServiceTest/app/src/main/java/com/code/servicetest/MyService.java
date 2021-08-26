package com.code.servicetest;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG = "服务啊";
    private MyService.DownloadBinder mBinder = new MyService.DownloadBinder();
    class DownloadBinder extends Binder{
        public void startDownload(){
            Log.d("MyService", "开始下载执行！");
        }

        public int getProgress(){
            Log.d("MyService", "获取进度执行!");
            return 0;
        }

    }
    public MyService() {
    }



    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "服务创建了！");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "服务启动了！");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d( TAG,"服务销毁了！");
    }
}