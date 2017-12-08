package com.lantern.auth.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import bluefay.app.Fragment;
import com.lantern.core.c;
import com.lantern.core.n;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class WebViewFragment
  extends Fragment
{
  private WebView g;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new WebView(this.e);
    paramLayoutInflater.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    paramLayoutInflater.getSettings().setJavaScriptEnabled(true);
    paramLayoutInflater.addJavascriptInterface(new o(getActivity()), "client");
    paramLayoutInflater.getSettings().setCacheMode(2);
    paramLayoutInflater.setWebChromeClient(new p(this));
    paramLayoutInflater.setWebViewClient(new WebViewFragment.2(this));
    this.g = paramLayoutInflater;
    paramLayoutInflater.post(new a());
    return paramLayoutInflater;
  }
  
  private final class a
    implements Runnable
  {
    private String b = null;
    
    public a()
    {
      Object localObject = c.getServer().s();
      this$1 = new JSONObject((Map)localObject).toString();
      ((HashMap)localObject).clear();
      localObject = c.getServer();
      this$1 = n.a(Uri.encode(WebViewFragment.this.trim(), "UTF-8"), ((com.lantern.core.o)localObject).l(), ((com.lantern.core.o)localObject).m());
      localObject = ((com.lantern.core.o)localObject).k();
      this.b = (com.lantern.auth.h.b() + "ed=" + WebViewFragment.this + "&et=" + "a" + "&appId=" + (String)localObject);
      com.bluefay.b.h.a(this.b);
    }
    
    public final void run()
    {
      WebViewFragment.a(WebViewFragment.this).loadUrl(this.b);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/WebViewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */