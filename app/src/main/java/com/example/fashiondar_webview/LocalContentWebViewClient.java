package com.example.fashiondar_webview;

import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

import androidx.annotation.RequiresApi;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class LocalContentWebViewClient extends WebViewClientCompat {
    private static final String TAG = "MyActivity";
    private final WebViewAssetLoader mAssetLoader;
    private  Uri TAG1 ;
    private  String TAG2 ;
    LocalContentWebViewClient(WebViewAssetLoader assetLoader) {
        mAssetLoader = assetLoader;
    }

    @Override
    @RequiresApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView view,
                                                      WebResourceRequest request) {
        Uri TAG1 = request.getUrl();
        String TAG2 = TAG1.toString().replace("/static/", "/assets/static/");
        Log.d(TAG,">>>"+TAG2);
        return mAssetLoader.shouldInterceptRequest(Uri.parse(TAG2));
    }

    @Override
    @SuppressWarnings("deprecation") // to support API < 21
    public WebResourceResponse shouldInterceptRequest(WebView view,
                                                      String url) {
        return mAssetLoader.shouldInterceptRequest(Uri.parse(url));
    }

}
