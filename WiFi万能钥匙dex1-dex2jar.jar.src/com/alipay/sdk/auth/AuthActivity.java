package com.alipay.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.alipay.sdk.j.k;
import com.alipay.sdk.j.k.a;
import java.lang.reflect.Method;

public final class AuthActivity
  extends Activity
{
  private WebView a;
  private String b;
  private com.alipay.sdk.k.a c;
  private Handler d;
  private boolean e;
  private boolean f;
  private Runnable g;
  
  public final void onBackPressed()
  {
    if (this.a.canGoBack()) {
      if (this.f)
      {
        g.a(this, this.b + "?resultCode=150");
        finish();
      }
    }
    for (;;)
    {
      return;
      g.a(this, this.b + "?resultCode=150");
      finish();
    }
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    for (;;)
    {
      try
      {
        paramBundle = getIntent().getExtras();
        if (paramBundle == null)
        {
          finish();
          return;
        }
      }
      catch (Exception paramBundle)
      {
        finish();
        continue;
        try
        {
          this.b = paramBundle.getString("redirectUri");
          paramBundle = paramBundle.getString("params");
          if (k.b(paramBundle)) {
            continue;
          }
          finish();
        }
        catch (Exception paramBundle)
        {
          finish();
        }
        continue;
        super.requestWindowFeature(1);
        this.d = new Handler(getMainLooper());
        LinearLayout localLinearLayout = new LinearLayout(this);
        Object localObject = new LinearLayout.LayoutParams(-1, -1);
        localLinearLayout.setOrientation(1);
        setContentView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
        this.a = new WebView(this);
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        this.a.setVisibility(0);
        localLinearLayout.addView(this.a, (ViewGroup.LayoutParams)localObject);
        localObject = this.a.getSettings();
        ((WebSettings)localObject).setUserAgentString(((WebSettings)localObject).getUserAgentString() + k.e(getApplicationContext()));
        ((WebSettings)localObject).setRenderPriority(WebSettings.RenderPriority.HIGH);
        ((WebSettings)localObject).setSupportMultipleWindows(true);
        ((WebSettings)localObject).setJavaScriptEnabled(true);
        ((WebSettings)localObject).setSavePassword(false);
        ((WebSettings)localObject).setJavaScriptCanOpenWindowsAutomatically(true);
        ((WebSettings)localObject).setMinimumFontSize(((WebSettings)localObject).getMinimumFontSize() + 8);
        ((WebSettings)localObject).setAllowFileAccess(false);
        ((WebSettings)localObject).setTextSize(WebSettings.TextSize.NORMAL);
        this.a.setVerticalScrollbarOverlay(true);
        this.a.setWebViewClient(new b((byte)0));
        this.a.setWebChromeClient(new a((byte)0));
        this.a.setDownloadListener(new a(this));
        this.a.loadUrl(paramBundle);
        if (Build.VERSION.SDK_INT < 7) {}
      }
      for (;;)
      {
        try
        {
          paramBundle = this.a.getSettings().getClass().getMethod("setDomStorageEnabled", new Class[] { Boolean.TYPE });
          if (paramBundle != null) {
            paramBundle.invoke(this.a.getSettings(), new Object[] { Boolean.valueOf(true) });
          }
        }
        catch (Exception paramBundle)
        {
          continue;
        }
        try
        {
          this.a.removeJavascriptInterface("searchBoxJavaBridge_");
          this.a.removeJavascriptInterface("accessibility");
          this.a.removeJavascriptInterface("accessibilityTraversal");
          if (Build.VERSION.SDK_INT < 19) {
            break;
          }
          this.a.getSettings().setCacheMode(1);
        }
        catch (Throwable paramBundle)
        {
          try
          {
            paramBundle = this.a.getClass().getMethod("removeJavascriptInterface", new Class[0]);
            if (paramBundle == null) {
              continue;
            }
            paramBundle.invoke(this.a, new Object[] { "searchBoxJavaBridge_" });
            paramBundle.invoke(this.a, new Object[] { "accessibility" });
            paramBundle.invoke(this.a, new Object[] { "accessibilityTraversal" });
          }
          catch (Throwable paramBundle) {}
        }
      }
    }
  }
  
  protected final void onDestroy()
  {
    super.onDestroy();
    if (this.a != null) {
      this.a.removeAllViews();
    }
    try
    {
      this.a.destroy();
      this.a = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
  }
  
  private final class a
    extends WebChromeClient
  {
    private a() {}
    
    public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
    {
      String str2 = paramConsoleMessage.message();
      boolean bool;
      if (TextUtils.isEmpty(str2)) {
        bool = super.onConsoleMessage(paramConsoleMessage);
      }
      for (;;)
      {
        return bool;
        String str1 = null;
        if (str2.startsWith("h5container.message: ")) {
          str1 = str2.replaceFirst("h5container.message: ", "");
        }
        if (TextUtils.isEmpty(str1))
        {
          bool = super.onConsoleMessage(paramConsoleMessage);
        }
        else
        {
          AuthActivity.b(AuthActivity.this, str1);
          bool = super.onConsoleMessage(paramConsoleMessage);
        }
      }
    }
  }
  
  private final class b
    extends WebViewClient
  {
    private b() {}
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      AuthActivity.g(AuthActivity.this);
      AuthActivity.f(AuthActivity.this).removeCallbacks(AuthActivity.e(AuthActivity.this));
    }
    
    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AuthActivity.d(AuthActivity.this);
      AuthActivity.f(AuthActivity.this).postDelayed(AuthActivity.e(AuthActivity.this), 30000L);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    
    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AuthActivity.a(AuthActivity.this);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    }
    
    public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
    {
      if (AuthActivity.b(AuthActivity.this))
      {
        paramSslErrorHandler.proceed();
        AuthActivity.a(AuthActivity.this, false);
      }
      for (;;)
      {
        return;
        AuthActivity.this.runOnUiThread(new d(this, paramSslErrorHandler));
      }
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      boolean bool2 = true;
      if ((paramString.toLowerCase().startsWith("alipays://platformapi/startApp?".toLowerCase())) || (paramString.toLowerCase().startsWith("intent://platformapi/startapp?".toLowerCase()))) {}
      for (;;)
      {
        try
        {
          paramWebView = k.a(AuthActivity.this);
          bool1 = bool2;
          if (paramWebView != null)
          {
            if (!paramWebView.a()) {
              continue;
            }
            bool1 = bool2;
          }
        }
        catch (Throwable paramWebView)
        {
          bool1 = bool2;
          continue;
        }
        return bool1;
        paramWebView = paramString;
        if (paramString.startsWith("intent://platformapi/startapp")) {
          paramWebView = paramString.replaceFirst("intent://platformapi/startapp?", "alipays://platformapi/startApp?");
        }
        paramString = new android/content/Intent;
        paramString.<init>("android.intent.action.VIEW", Uri.parse(paramWebView));
        AuthActivity.this.startActivity(paramString);
        boolean bool1 = bool2;
        continue;
        if (AuthActivity.a(AuthActivity.this, paramString))
        {
          paramWebView.stopLoading();
          bool1 = bool2;
        }
        else
        {
          bool1 = super.shouldOverrideUrlLoading(paramWebView, paramString);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/auth/AuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */