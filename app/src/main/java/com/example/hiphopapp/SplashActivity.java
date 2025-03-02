package com.example.hiphopapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.MobileAds;

public class SplashActivity extends Activity {
    private AdView adView;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize Google Mobile Ads SDK
        MobileAds.initialize(this);

        // Load Banner Ad
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        // Load Interstitial Ad
        InterstitialAd.load(this, getString(R.string.interstitial_Ad), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(InterstitialAd ad) {
                interstitialAd = ad;
                interstitialAd.show(SplashActivity.this);
            }
        });

        // Delay and move to next activity
//        new Handler().postDelayed(() -> {

//        }, 3000); // 3-second delay
    }

    public void next(View view) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
    }
}
