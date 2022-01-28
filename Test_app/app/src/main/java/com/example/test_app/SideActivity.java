package com.example.test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.yieldlove.adIntegration.AdFormats.YieldloveInterstitialAd;
import com.yieldlove.adIntegration.AdFormats.YieldloveInterstitialAdListener;
import com.yieldlove.adIntegration.AdFormats.YieldloveInterstitialAdView;
import com.yieldlove.adIntegration.Yieldlove;
import com.yieldlove.adIntegration.YieldloveConsent;
import com.yieldlove.adIntegration.exceptions.YieldloveException;

public class SideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side);
    }

    public void showInterstitialAd() {
        Yieldlove.setApplicationName("appDfpTestCMP");

        YieldloveConsent consent = new YieldloveConsent(
                this,
                R.id.sideA);

        consent.collect();

        try {
            YieldloveInterstitialAd ad = new YieldloveInterstitialAd(this);

            ad.load("interstitial", new YieldloveInterstitialAdListener() {

                @Override
                public AdManagerAdRequest.Builder onAdRequestBuild() {
                    return null;
                }

                @Override
                public void onAdLoaded(YieldloveInterstitialAdView interstitial) {
                    interstitial.getAdView().setFullScreenContentCallback(
                            new FullScreenContentCallback() {

                                @Override
                                public void onAdFailedToShowFullScreenContent(AdError adError) {
                                    super.onAdFailedToShowFullScreenContent(adError);
                                }

                                // or other functions from FullScreenContentCallback interface
                            }
                    );
                    interstitial.show();
                }

                @Override
                public void onAdFailedToLoad(YieldloveInterstitialAdView yieldloveInterstitialAdView, YieldloveException e) {

                }

                // other methods required by interface

            });
        } catch (YieldloveException exception) {

        }
    }






    public void backTmain(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}