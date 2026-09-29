package com.aipromptdifferent.app;

import android.app.*;import android.os.*;import android.content.*;import android.net.Uri;import android.view.*;import android.webkit.*;import android.widget.*;import java.util.*;

public class MainActivity extends Activity {
  WebView web; ValueCallback<Uri[]> fileCallback;
  @Override public void onCreate(Bundle b){super.onCreate(b); setContentView(R.layout.activity_main); web=findViewById(R.id.webView);
    WebSettings s=web.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setAllowFileAccess(true); s.setAllowContentAccess(true); s.setMediaPlaybackRequiresUserGesture(false);
    web.setWebViewClient(new WebViewClient(){@Override public boolean shouldOverrideUrlLoading(WebView v, WebResourceRequest r){String u=r.getUrl().toString(); if(u.startsWith("https://")||u.startsWith("http://")){v.loadUrl(u);return true;} return false;}});
    web.setWebChromeClient(new WebChromeClient(){@Override public boolean onShowFileChooser(WebView v,ValueCallback<Uri[]> cb,FileChooserParams p){fileCallback=cb; Intent i=p.createIntent(); try{startActivityForResult(i,1001);}catch(Exception e){return false;} return true;}});
    web.setDownloadListener((url,user,content, mime,len)->{Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse(url)); startActivity(i);});
    web.loadUrl("file:///android_asset/index.html");
  }
  @Override protected void onActivityResult(int r,int c,Intent d){super.onActivityResult(r,c,d);if(r==1001&&fileCallback!=null){Uri[] x=WebChromeClient.FileChooserParams.parseResult(c,d);fileCallback.onReceiveValue(x);fileCallback=null;}}
  @Override public void onBackPressed(){if(web.canGoBack()) web.goBack(); else super.onBackPressed();}
}
