package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.app.androidjokes.JokeActivity;
import com.google.app.javajokes.Jokes;

//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });
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

    public void tellJoke(View view) {

//        MainActivityFragment fragment = new MainActivityFragment();
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.jokesLayout, fragment)
//                .commit();

        TextView jo = findViewById(R.id.instructions_text_view);
//        jo.setText(getJokes());
//        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, JokeActivity.class);
        intent.putExtra("joke", getJokes());
        startActivity(intent);
    }

public String getJokes(){

    Jokes jokes = new Jokes();
    String joke = jokes.getJokes();

    return joke;
}
}
