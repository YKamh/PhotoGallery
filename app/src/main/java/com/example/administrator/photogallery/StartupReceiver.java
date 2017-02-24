package com.example.administrator.photogallery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2016/12/4.
 */
public class StartupReceiver extends BroadcastReceiver{

    private static final String TAG = "StartupReceiver";

    //监听android.intent.action.BOOT_COMPLETED这个开机广播
    //监听到android.intent.action.BOOT_COMPLETED这个开机广播BroadcastReceiver的onReceive方法就会调用执行相应的动作
    //这里执行的是将闹铃唤醒
    @Override
    public void onReceive(Context context, Intent intent){
        Log.i(TAG, "Received broadcast intent:" + intent.getAction());

        boolean isOn = QueryPreferences.isAlarmOn(context);
        PollService.setServiceAlarm(context, isOn);


    }

}
