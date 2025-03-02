package com.example.hiphopapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
//    private AdView facebookBannerAd;
//    private InterstitialAd facebookInterstitialAd;
    private AdView adView;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this);

        // Load Banner Ad
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        // Load Interstitial Ad
        com.google.android.gms.ads.interstitial.InterstitialAd.load(this, getString(R.string.interstitial_Ad), adRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(com.google.android.gms.ads.interstitial.InterstitialAd ad) {
                interstitialAd = ad;
                interstitialAd.show(MainActivity.this);
            }
        });

        // Initialize Facebook Ads
//        AudienceNetworkAds.initialize(this);

        // Load Facebook Banner Ad
//        facebookBannerAd = new AdView(this, "YOUR_FACEBOOK_BANNER_AD_ID", AdSize.BANNER_HEIGHT_50);
//        LinearLayout adContainer = findViewById(R.id.facebookBannerAd);
//        adContainer.addView(facebookBannerAd);
//        facebookBannerAd.loadAd();
//
//        // Load Facebook Interstitial Ad
//        facebookInterstitialAd = new InterstitialAd(this, "YOUR_FACEBOOK_INTERSTITIAL_AD_ID");
//        facebookInterstitialAd.loadAd();

        // Setup WebView
        WebView webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.intuitivebrands.org/new-music");
    }

}
