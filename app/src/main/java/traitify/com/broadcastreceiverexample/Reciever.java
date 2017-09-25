package traitify.com.broadcastreceiverexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by gleecus on 9/25/17.
 */

public class Reciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        final Bundle bundle = intent.getExtras();

        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();

                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();

                    Log.e("SmsReciver", "senderNum: " + senderNum + ", message: " + message);

                    MainActivity Sms = new MainActivity();
                    Sms.recivedSms(message );

                    if(message.equals("Milind")){
                        Toast.makeText(context, "sms matched", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(context, "not matched", Toast.LENGTH_LONG).show();
                    }
                } // end of for loop
            } // bundle

        } catch (Exception e) {
            // TODO: handle exception
            Log.e("SmsReciver", "Exception smsReciver" + e);
        }

    }
}
