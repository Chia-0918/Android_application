package com.example.ttt;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.view.KeyEvent;



public class MainActivity extends AppCompatActivity {
    class MyChromeViewClient extends WebChromeClient{
        public void onGeolocationPermissionsShowPrompt(final String origin, final android.webkit.GeolocationPermissions.Callback callback) {
            final boolean remember = true;
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("位置訊息");
            builder.setMessage(origin + "允許獲取您的地理位置嗎?").setCancelable(true).setPositiveButton("允許",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog,
                                            int id) {
                            callback.invoke(origin, true, remember);
                        }
                    })
                    .setNegativeButton("不允許",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int id) {
                                    callback.invoke(origin, false, remember);
                                }
                            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event){
        WebView webview = (WebView) findViewById(R.id.web_view);
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webview = (WebView) findViewById(R.id.web_view);
        WebSettings webSettings = webview.getSettings();
        webSettings.setGeolocationEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        setContentView(webview);
        webview.setWebViewClient(new WebViewClient());
        webview.setWebChromeClient(new MyChromeViewClient());
        webview.loadUrl("https://140.129.18.59/");
    }
}