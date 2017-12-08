package com.lantern.browser.search.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import bluefay.app.Fragment;
import com.bluefay.b.h;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.browser.R.id;
import com.lantern.browser.WkBrowserJsInterface;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.bd;
import com.lantern.browser.bd.a;
import com.lantern.browser.bp;
import com.lantern.browser.cc;
import com.lantern.browser.search.a.a.a;
import com.lantern.webox.browser.BrowserJsInterface;
import com.lantern.webox.event.WebEvent;
import com.lantern.webox.handler.g;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WkSearchFragment
  extends Fragment
  implements cc, a.a, com.lantern.webox.event.c
{
  private WkSearchTitleBar g;
  private WkBrowserWebView h;
  private RelativeLayout i;
  private ProgressBar j;
  private FrameLayout k;
  private LinearLayout l;
  private WkSearchHistoryListView m;
  private LinearLayout n;
  private WkSearchHotWordView o;
  private bd.a p;
  private int q = 0;
  private int r = 0;
  private String s;
  
  private void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (this.h != null)
      {
        this.h.setVisibility(0);
        if (!paramString.contains("?")) {
          break label67;
        }
        paramString = paramString + "&kw=" + this.s;
        this.h.loadUrl(paramString);
      }
    }
    for (;;)
    {
      return;
      label67:
      paramString = paramString + "?kw=" + this.s;
      break;
      o();
    }
  }
  
  private WkSearchTitleBar n()
  {
    if (this.g == null) {
      this.g = new WkSearchTitleBar(this.e);
    }
    return this.g;
  }
  
  private void o()
  {
    if (this.i != null) {
      this.i.setVisibility(0);
    }
  }
  
  private void p()
  {
    if (this.i != null) {
      this.i.setVisibility(8);
    }
    if (this.k != null) {
      this.k.setVisibility(0);
    }
  }
  
  private void q()
  {
    p();
    String str = com.lantern.browser.search.a.a.a().g();
    if (TextUtils.isEmpty(str)) {
      com.lantern.browser.search.a.a.a().a(new c(this));
    }
    for (;;)
    {
      return;
      b(str);
    }
  }
  
  public final void a(int paramInt1, int paramInt2) {}
  
  public final void a(int paramInt, String paramString) {}
  
  public final void a(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2) {}
  
  public final void a(String paramString)
  {
    h.a("onHideHistory", new Object[0]);
    if ((this.l != null) && (this.l.getVisibility() == 0)) {
      this.l.setVisibility(8);
    }
    this.g.a();
    this.g.a(paramString);
    this.s = paramString;
    q();
  }
  
  public final boolean a(WebView paramWebView, Message paramMessage)
  {
    paramWebView = new WebView(paramWebView.getContext());
    paramWebView.setWebViewClient(new WkSearchFragment.3(this));
    ((WebView.WebViewTransport)paramMessage.obj).setWebView(paramWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    if (!bp.b((WkBrowserWebView)paramWebView, paramString))
    {
      paramWebView = new Intent("wifi.intent.action.BROWSER");
      paramWebView.setData(Uri.parse(paramString));
      paramWebView.setPackage(this.e.getPackageName());
      paramWebView.addFlags(268435456);
      this.e.startActivity(paramWebView);
    }
    return true;
  }
  
  public final void c()
  {
    h.a("onRefreshHistory", new Object[0]);
    if (this.m != null) {
      this.m.a();
    }
  }
  
  public final void c_()
  {
    h.a("onShowHistory", new Object[0]);
    if ((this.l != null) && (this.l.getVisibility() != 0)) {
      this.l.setVisibility(0);
    }
    if (this.m != null)
    {
      if (this.m.getVisibility() != 0) {
        this.m.setVisibility(0);
      }
      this.m.a();
    }
  }
  
  public final void d()
  {
    h.a("onRefreshHotWord", new Object[0]);
    if ((this.n != null) && (this.n.getVisibility() != 0)) {
      this.n.setVisibility(0);
    }
    if (this.o != null) {
      this.o.a(com.lantern.browser.search.a.a.a().h());
    }
  }
  
  public final void d_()
  {
    h.a("onShowHotWord", new Object[0]);
    if ((this.l != null) && (this.l.getVisibility() != 0)) {
      this.l.setVisibility(0);
    }
    if ((this.n != null) && (this.n.getVisibility() != 0)) {
      this.n.setVisibility(0);
    }
    if (this.o != null) {
      this.o.a(com.lantern.browser.search.a.a.a().h());
    }
  }
  
  public final void e()
  {
    h.a("onClearHistory", new Object[0]);
    if ((this.m != null) && (this.m.getVisibility() != 8)) {
      this.m.setVisibility(8);
    }
  }
  
  public final void f() {}
  
  public final void g() {}
  
  public final void h() {}
  
  public final void i() {}
  
  public final void j() {}
  
  public final void k() {}
  
  public final void l() {}
  
  public final void m() {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = new WkSearchMainView(this.e);
    com.lantern.browser.search.a.a.a().e();
    paramViewGroup = getArguments();
    if (paramViewGroup != null)
    {
      paramViewGroup = paramViewGroup.getString("kw");
      if (!TextUtils.isEmpty(paramViewGroup)) {
        n().b(paramViewGroup);
      }
    }
    this.h = ((WkBrowserWebView)paramLayoutInflater.findViewById(R.id.searchWebview));
    try
    {
      this.h.removeJavascriptInterface("searchBoxJavaBridge_");
      this.h.removeJavascriptInterface("accessibility");
      this.h.removeJavascriptInterface("accessibilityTraversal");
      this.h.a("jsi:wifikey", new BrowserJsInterface(this.h));
      this.h.a(this);
      this.h.a(this);
      new WkBrowserJsInterface();
      this.i = ((RelativeLayout)paramLayoutInflater.findViewById(R.id.search_error_layout));
      ((Button)this.i.findViewById(R.id.search_error_btn)).setOnClickListener(new a(this));
      this.j = ((ProgressBar)paramLayoutInflater.findViewById(R.id.search_progressbar));
      this.p = new b(this);
      bd.a(this.j, this.p);
      this.l = ((LinearLayout)paramLayoutInflater.findViewById(R.id.search_history_layout));
      this.m = ((WkSearchHistoryListView)this.l.findViewById(R.id.searchHistory));
      this.n = ((LinearLayout)this.l.findViewById(R.id.searchHotWord));
      this.o = ((WkSearchHotWordView)this.n.findViewById(R.id.hotWord));
      com.lantern.browser.search.a.a.a().a(this);
      this.k = ((FrameLayout)paramLayoutInflater.findViewById(R.id.searchloading));
      return paramLayoutInflater;
    }
    catch (Exception paramViewGroup)
    {
      for (;;)
      {
        h.a(paramViewGroup);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    n().a();
    com.lantern.browser.search.a.a.a().f();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      n().a();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b().a(n());
  }
  
  public void onWebEvent(WebEvent paramWebEvent)
  {
    switch (paramWebEvent.getType())
    {
    }
    for (;;)
    {
      return;
      bd.a();
      this.j.setVisibility(0);
      continue;
      bd.b();
      this.j.setVisibility(4);
      continue;
      int i1 = ((Integer)paramWebEvent.getData()).intValue();
      this.q = i1;
      this.j.setProgress(Math.max(this.r, this.q));
      if (i1 > 10)
      {
        paramWebEvent = this.h.getTitle();
        if (!TextUtils.isEmpty(paramWebEvent))
        {
          if (!bp.g(paramWebEvent)) {
            break label185;
          }
          h.a("onProgressChanged showErrorPage", new Object[0]);
          o();
        }
      }
      for (;;)
      {
        if (i1 != 100) {
          break label190;
        }
        bd.b();
        this.j.setVisibility(4);
        break;
        label185:
        p();
      }
      label190:
      continue;
      this.h.j().a(this.h);
      continue;
      h.a("onReceivedError " + paramWebEvent.getData().toString(), new Object[0]);
      paramWebEvent = (String)((HashMap)paramWebEvent.getData()).get("failingUrl");
      if (Pattern.compile("\\.(jpg|jpeg|gif|png|bmp|js|css)").matcher(paramWebEvent).find()) {
        h.a("onReceivedError ignore this error", new Object[0]);
      }
      if ((paramWebEvent.startsWith("http://")) || (paramWebEvent.startsWith("https://")) || (paramWebEvent.startsWith("file://")))
      {
        o();
      }
      else
      {
        h.a("onReceivedError ignore this error", new Object[0]);
        continue;
        paramWebEvent = paramWebEvent.getData().toString();
        if (Pattern.compile("\\.(jpg|jpeg|gif|png|bmp|js|css)").matcher(paramWebEvent).find()) {
          this.h.j().a(this.h);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/WkSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */