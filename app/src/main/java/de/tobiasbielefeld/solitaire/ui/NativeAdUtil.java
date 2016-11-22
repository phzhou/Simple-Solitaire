package de.tobiasbielefeld.solitaire.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdChoicesView;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;

/**
 * Created by atu on 11/21/16.
 */

public class NativeAdUtil {
    private static NativeAd nativeAd;
    private static LinearLayout adContainer;

    public static LinearLayout getAdView(final Context context, View parent) {
        adContainer = new LinearLayout(context);
        adContainer.setOrientation(LinearLayout.VERTICAL);
        adContainer.setLayoutParams(parent.getLayoutParams());
        nativeAd = new NativeAd(context, "YOUR_PLACEMENT_ID");
        nativeAd.setAdListener(new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
                AdChoicesView adChoicesView = new AdChoicesView(context, nativeAd, true);
                TextView tvAdTitle = new TextView(context);
                tvAdTitle.setTextSize(5);
                tvAdTitle.setText(nativeAd.getAdTitle());
                tvAdTitle.setWidth(300);

               // adContainer.addView(adChoicesView);
                adContainer.addView(tvAdTitle);
        nativeAd.registerViewForInteraction(adContainer);

            }

            @Override
            public void onAdClicked(Ad ad) {

            }
        });
        nativeAd.loadAd();

        return adContainer;
    }
}
