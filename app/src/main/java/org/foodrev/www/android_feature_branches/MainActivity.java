package org.foodrev.www.android_feature_branches;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button basicButton;

    private NotificationCompat.Builder mBuilder;
    private NotificationManager mNotifyMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        basicButton = (Button) findViewById(R.id.button);


        basicButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //place button action here
                makeNotification();
            }
        });


    }
    private void makeNotification() {
        //set up the notification details
        mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.drawable.notification_template_icon_bg)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        int mNotificationId = 001;

        // Gets a NotificationManager service instance
        mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // make notification.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
