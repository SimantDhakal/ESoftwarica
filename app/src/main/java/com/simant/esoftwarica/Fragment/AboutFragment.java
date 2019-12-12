package com.simant.esoftwarica.Fragment;


import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.simant.esoftwarica.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    WebView webViewFrame;
    ProgressBar pbar;

    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        webViewFrame = (WebView) view.findViewById(R.id.webView);
        pbar = (ProgressBar) view.findViewById(R.id.progressBar1);
        webViewFrame.loadUrl("https://softwarica.edu.np/");

        // Enable Javascript
        WebSettings webSettings = webViewFrame.getSettings();
        webSettings.setJavaScriptEnabled(true);
//        webViewFrame.setWebViewClient(new WebViewClient());

        webViewFrame.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap facIcon) {
                pbar.setVisibility(View.VISIBLE);
                webViewFrame.setVisibility(View.GONE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                webViewFrame.setVisibility(View.VISIBLE);
                pbar.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }


}
