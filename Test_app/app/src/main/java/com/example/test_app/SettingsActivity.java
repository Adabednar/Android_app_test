package com.example.test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.yieldlove.adIntegration.AdFormats.YieldloveBannerAd;
import com.yieldlove.adIntegration.AdFormats.YieldloveBannerAdListener;
import com.yieldlove.adIntegration.AdFormats.YieldloveBannerAdView;
import com.yieldlove.adIntegration.Yieldlove;
import com.yieldlove.adIntegration.YieldloveConsent;
import com.yieldlove.adIntegration.exceptions.YieldloveException;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        YieldloveConsent consent = new YieldloveConsent(
                this,
                R.id.Settings);

        consent.collect();

        final ViewGroup adContainer = findViewById(R.id.AdContainer);

        try {
            YieldloveBannerAd ad = new YieldloveBannerAd(this);

            ad.load("banner", new YieldloveBannerAdListener() {

                @Override
                public AdManagerAdRequest.Builder onAdRequestBuild() {
                    return null;
                }

                @Override
                public void onAdLoaded(YieldloveBannerAdView banner) {
                    adContainer.addView(banner.getAdView());
                }

                @Override
                public void onAdFailedToLoad(YieldloveBannerAdView yieldloveBannerAdView, YieldloveException e) {

                }

                @Override
                public void onAdOpened(YieldloveBannerAdView yieldloveBannerAdView) {

                }

                @Override
                public void onAdClosed(YieldloveBannerAdView yieldloveBannerAdView) {

                }

                @Override
                public void onAdClicked(YieldloveBannerAdView yieldloveBannerAdView) {

                }

                @Override
                public void onAdImpression(YieldloveBannerAdView yieldloveBannerAdView) {

                }
                // other methods required by interface
            });

        } catch (YieldloveException e) {
            e.printStackTrace();
        }




    }

    public void backTmain(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}