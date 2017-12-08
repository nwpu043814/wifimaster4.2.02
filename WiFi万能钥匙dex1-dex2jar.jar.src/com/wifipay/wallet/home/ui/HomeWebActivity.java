package com.wifipay.wallet.home.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.common.a.g;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.WifiPayFactory;
import com.wifipay.wallet.common.utils.f;
import com.wifipay.wallet.home.a.b;
import com.wifipay.wallet.pay.WifiPayApi;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class HomeWebActivity
  extends BaseActivity
{
  private WebView h;
  private ProgressBar i;
  private WifiPayApi j;
  private String k;
  
  static
  {
    StubApp1053578832.interface11(125);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, HomeWebActivity.class);
    localIntent.putExtra("webViewType", "web");
    localIntent.putExtra("webViewName", paramString);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private void a(WebView paramWebView, String paramString)
  {
    if ((!g.a(paramString)) && (paramString.contains("api?pay="))) {}
    for (;;)
    {
      try
      {
        paramWebView = URLDecoder.decode(paramString, "UTF-8");
        String str = paramWebView.substring(paramWebView.indexOf("=") + 1, paramWebView.length());
        paramString = new java/lang/Thread;
        paramWebView = new com/wifipay/wallet/home/ui/q;
        paramWebView.<init>(this, str);
        paramString.<init>(paramWebView);
        paramString.start();
        return;
      }
      catch (UnsupportedEncodingException paramWebView)
      {
        paramWebView.printStackTrace();
        continue;
      }
      paramWebView.loadUrl(paramString);
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, HomeWebActivity.class);
    localIntent.putExtra("webViewType", "file");
    localIntent.putExtra("webViewName", paramString);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private void f(String paramString)
  {
    this.h.loadUrl(paramString);
    this.h.setWebViewClient(new p(this));
    this.h.setWebChromeClient(new a());
  }
  
  private void g(String paramString)
  {
    paramString = e(paramString);
    this.h.loadUrl(paramString);
    this.h.setWebChromeClient(new a());
  }
  
  private void i()
  {
    this.h.requestFocusFromTouch();
    this.h.setDownloadListener(new b(null));
    this.j = WifiPayFactory.createWifiPayAPI(this);
    WebSettings localWebSettings = this.h.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setBuiltInZoomControls(false);
    localWebSettings.setSupportZoom(false);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    localWebSettings.setLoadsImagesAutomatically(true);
  }
  
  public boolean a()
  {
    if (this.h.canGoBack()) {
      this.h.goBack();
    }
    for (boolean bool = true;; bool = super.a()) {
      return bool;
    }
  }
  
  public String e(String paramString)
  {
    return "file:///" + b.a() + File.separator + paramString + File.separator + "desc" + File.separator + paramString + ".html";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.wifipay_activity_home_webview);
    this.h = ((WebView)findViewById(R.id.wifipay_home_content_webview));
    this.i = ((ProgressBar)findViewById(R.id.wifipay_home_content_webview_progress));
    i();
    paramBundle = getIntent();
    try
    {
      this.k = paramBundle.getStringExtra("title");
      if (f.a(this.k)) {
        a(this.k);
      }
      String str = paramBundle.getStringExtra("webViewType");
      paramBundle = paramBundle.getStringExtra("webViewName");
      if (f.a(paramBundle))
      {
        if (g.a(str, "file")) {
          g(paramBundle);
        }
        if (g.a(str, "web")) {
          f(paramBundle);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == 4) {
      if (this.h.canGoBack())
      {
        this.h.goBack();
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      continue;
      bool = false;
    }
  }
  
  public class a
    extends WebChromeClient
  {
    public a() {}
    
    public void onProgressChanged(WebView paramWebView, int paramInt)
    {
      if (paramInt == 100) {
        HomeWebActivity.b(HomeWebActivity.this).setVisibility(8);
      }
      for (;;)
      {
        return;
        HomeWebActivity.b(HomeWebActivity.this).setProgress(paramInt);
      }
    }
    
    public void onReceivedTitle(WebView paramWebView, String paramString)
    {
      super.onReceivedTitle(paramWebView, paramString);
      if (f.a(paramWebView.getTitle())) {
        HomeWebActivity.this.a(paramWebView.getTitle());
      }
    }
  }
  
  private class b
    implements DownloadListener
  {
    private b() {}
    
    public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
    {
      paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
      HomeWebActivity.this.startActivity(paramString1);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/HomeWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */