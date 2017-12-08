package bluefay.webkit;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import bluefay.app.o;
import bluefay.app.t;
import com.bluefay.b.h;
import com.bluefay.framework.R.id;
import com.bluefay.framework.R.layout;
import com.bluefay.widget.ActionTopBarView;

public final class c
  extends bluefay.app.b
  implements o
{
  protected ActionTopBarView e;
  protected boolean f;
  protected boolean g;
  protected boolean h;
  protected boolean i;
  protected String j;
  protected String k;
  private FrameLayout l;
  private FrameLayout m;
  private FrameLayout n;
  private b o;
  private a p;
  private BrowserWebView q;
  private t r;
  private GestureDetector s;
  private com.bluefay.widget.b t;
  private View.OnTouchListener u;
  private DownloadListener v;
  private WebViewClient w;
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == a) && (this.e != null)) {
      this.e.setVisibility(paramInt2);
    }
  }
  
  public final boolean a(int paramInt, Menu paramMenu)
  {
    if (paramInt == a) {
      if (paramMenu != null)
      {
        this.r = new t(getBaseContext(), paramMenu);
        this.o.a(this.r);
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean b(int paramInt, Menu paramMenu)
  {
    if (paramInt == a) {
      if ((this.r != null) && (this.e != null))
      {
        this.r.a(paramMenu);
        this.e.b(this.r);
      }
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      if (paramInt != b) {
        break;
      }
    }
  }
  
  public final void c(int paramInt) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    int i2 = 8;
    super.onCreate(paramBundle);
    setContentView(R.layout.framework_webview_activity);
    this.m = ((FrameLayout)findViewById(R.id.topbar_container));
    this.n = ((FrameLayout)findViewById(R.id.bottombar_container));
    this.l = ((FrameLayout)findViewById(R.id.fragment_container));
    this.o = new b(this);
    this.o.a(this.t);
    this.m.addView(this.o);
    this.e = this.o.a();
    this.p = new a(this);
    this.n.addView(this.p);
    paramBundle = this.m;
    if (this.h) {}
    for (int i1 = 0;; i1 = 8)
    {
      paramBundle.setVisibility(i1);
      paramBundle = this.n;
      i1 = i2;
      if (this.i) {
        i1 = 0;
      }
      paramBundle.setVisibility(i1);
      this.s = new GestureDetector(this, new d(this));
      this.j = getIntent().getDataString();
      h.a("View Url:" + this.j);
      this.q = new BrowserWebView(this);
      this.l.addView(this.q);
      this.q.getSettings().setJavaScriptEnabled(this.f);
      this.q.getSettings().setDomStorageEnabled(true);
      this.q.getSettings().setBuiltInZoomControls(this.g);
      this.q.getSettings().setUseWideViewPort(true);
      this.q.getSettings().setLoadWithOverviewMode(true);
      this.q.getSettings().setSavePassword(false);
      this.q.getSettings().setSaveFormData(false);
      this.q.getSettings().setGeolocationEnabled(true);
      this.q.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
      this.q.setWebChromeClient(new a());
      this.q.setWebViewClient(this.w);
      this.q.setDownloadListener(this.v);
      this.q.requestFocus(130);
      this.q.setOnTouchListener(this.u);
      this.q.getSettings().setUserAgentString(this.k);
      this.q.loadUrl(this.j);
      return;
    }
  }
  
  protected final void onDestroy()
  {
    this.l.removeAllViews();
    this.q.destroy();
    super.onDestroy();
  }
  
  public final boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i1 = paramMenuItem.getItemId();
    h.a("onOptionsItemSelected id:" + i1);
    if (i1 == 16908332) {
      finish();
    }
    for (boolean bool = true;; bool = super.onOptionsItemSelected(paramMenuItem)) {
      return bool;
    }
  }
  
  public final void setTitle(int paramInt)
  {
    this.o.b(paramInt);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.o.a(paramCharSequence);
  }
  
  public final void setTitleColor(int paramInt)
  {
    this.o.c(paramInt);
  }
  
  final class a
    extends WebChromeClient
  {
    a() {}
    
    public final View getVideoLoadingProgressView()
    {
      return null;
    }
    
    public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
    {
      h.a("onGeolocationPermissionsShowPrompt, origin = %s", new Object[] { paramString });
      paramCallback.invoke(paramString, true, false);
    }
    
    public final void onHideCustomView() {}
    
    public final void onProgressChanged(WebView paramWebView, int paramInt)
    {
      c.a(c.this).a(paramInt);
      super.onProgressChanged(paramWebView, paramInt);
    }
    
    public final void onReceivedTitle(WebView paramWebView, String paramString)
    {
      super.onReceivedTitle(paramWebView, paramString);
      c.this.setTitle(paramString);
    }
    
    public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      h.a("onShowCustomView, sdk int = " + Build.VERSION.SDK_INT);
    }
    
    public final void openFileChooser(ValueCallback paramValueCallback) {}
    
    public final void openFileChooser(ValueCallback paramValueCallback, String paramString) {}
    
    public final void openFileChooser(ValueCallback paramValueCallback, String paramString1, String paramString2) {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/webkit/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */