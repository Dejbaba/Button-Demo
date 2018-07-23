package deji.dejman.com.buttondemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import static deji.dejman.com.buttondemo.R.drawable.button_play_pressed;


public class MainActivity extends AppCompatActivity {


    ImageButton play;
    TextView counter;
    int Counter = 0;
    String SavedCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadSavedPreferences();



        play = (ImageButton) findViewById(R.id.img_play);
        counter = (TextView) findViewById(R.id.counter);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter++;
                counter.setText(String.valueOf(Counter));


            }
        });








    }

    private void savedPreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();

    }

    private void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SavedCounter = sharedPreferences.getString("improve", "0");
    }

    public void onBackPressed(){


        String CurrentCounter = String.valueOf(counter);
        savedPreferences("improve", CurrentCounter);
        System.exit(0);




    }


}
