package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.app.androidjokes.JokeActivity;

//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity implements EndpointsAsyncTaskInterface{

    public ProgressBar mProgressBar;
    private TextView mTextView;
    private Button mButton;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = findViewById(R.id.pb_loading_indicator);
        mTextView = findViewById(R.id.instructions_text_view);
        mButton = findViewById(R.id.tellJoke_bn);

        mProgressBar.setVisibility(View.INVISIBLE);

    MobileAds.initialize(this,
            "ca-app-pub-3940256099942544~3347511713");

    mInterstitialAd = new InterstitialAd(this);
    mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                getJokes();
            }

        });
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
        mProgressBar.setVisibility(View.VISIBLE);
        mTextView.setVisibility(View.INVISIBLE);
        mButton.setVisibility(View.INVISIBLE);

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }


public void getJokes(){

    EndPointsAsyncTask myTask = new EndPointsAsyncTask(this);
    myTask.execute();

}

    @Override
    public void returnJokeData(String result)
    {
        Log.i("result", result);

//        EspressoIdlingResource.increment();
        Intent intent = new Intent(MainActivity.this, JokeActivity.class);
        intent.putExtra("joke", result);
        startActivity(intent);

//        EspressoIdlingResource.decrement();
    }

    @Override
    public void onResume() {
        super.onResume();
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mProgressBar.setVisibility(View.INVISIBLE);
        mTextView.setVisibility(View.VISIBLE);
        mButton.setVisibility(View.VISIBLE);

    }
}
