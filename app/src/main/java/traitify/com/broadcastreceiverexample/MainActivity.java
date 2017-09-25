package traitify.com.broadcastreceiverexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static TextView SMS_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SMS_textview=(TextView)findViewById(R.id.tv);
    }

    public void recivedSms(String message)
    {
        try
        {
            SMS_textview.setText(message);

        }
        catch (Exception e)
        {
        }
    }
}
