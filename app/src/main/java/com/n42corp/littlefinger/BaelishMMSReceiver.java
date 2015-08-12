package com.n42corp.littlefinger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import com.parse.ParseObject;

import java.util.Date;

public class BaelishMMSReceiver extends BroadcastReceiver {
    static final String logTag = "WAP_PUSH_RECEIVED";
    static final String ACTION = "android.provider.Telephony.WAP_PUSH_RECEIVED";

    public BaelishMMSReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION)) {
            Bundle bundle = intent.getExtras();
        }
    }
}
