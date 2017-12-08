package com.lantern.webox.browser;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import bluefay.app.ViewPagerFragment;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.b.e;
import com.lantern.webox.event.WebEvent;
import com.lantern.webox.event.c;

public class BrowserFragment
  extends ViewPagerFragment
  implements c
{
  private WkBrowserWebView g;
  private TextView h;
  private ProgressBar i;
  private e j = new e(getClass());
  
  public final void a(Context paramContext) {}
  
  public final void b(Context paramContext) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getActivity().getWindow().setFlags(16777216, 16777216);
    setRetainInstance(true);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.webox_browser, paramViewGroup, false);
    this.h = ((TextView)paramLayoutInflater.findViewById(R.id.title));
    this.i = ((ProgressBar)paramLayoutInflater.findViewById(R.id.progressBar));
    this.g = ((WkBrowserWebView)paramLayoutInflater.findViewById(R.id.webox));
    this.g.a(this);
    this.g.loadUrl("file:///android_asset/tester.html");
    this.g.a("jsi:wifikey", new BrowserJsInterface(this.g));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    new StringBuilder("onDestroy ").append(this);
    if (this.g != null) {
      this.g.destroy();
    }
  }
  
  public void onWebEvent(WebEvent paramWebEvent)
  {
    if (paramWebEvent.getType() == 4)
    {
      this.i.setVisibility(0);
      this.i.setProgress(0);
      this.h.setText(paramWebEvent.getData().toString());
    }
    if (paramWebEvent.getType() == 5) {
      this.i.setVisibility(4);
    }
    if (paramWebEvent.getType() == 3) {
      this.h.setText(paramWebEvent.getData());
    }
    if (paramWebEvent.getType() == 1) {
      this.i.setProgress(((Integer)paramWebEvent.getData()).intValue());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/browser/BrowserFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */