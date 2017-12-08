package com.lantern.browser.ui;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;
import bluefay.app.Fragment;
import bluefay.app.u;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.auth.WkRegisterInterface;
import com.lantern.auth.g;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.id;
import com.lantern.browser.R.string;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.at;
import com.lantern.browser.bg;
import com.lantern.browser.bh;
import com.lantern.browser.bn;
import com.lantern.browser.bp;
import com.lantern.browser.c.b;
import com.lantern.browser.m;
import com.lantern.core.c;
import com.lantern.core.config.DownloadBlackListConf;
import com.lantern.core.config.d;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class WkBrowserFragment
  extends Fragment
{
  protected at g;
  private boolean h = false;
  private boolean i = false;
  private boolean j = true;
  private boolean k = true;
  private String l;
  private WkRegisterInterface m;
  private String n = "";
  private String o = "";
  
  public void a(String paramString)
  {
    if (this.g != null) {
      this.g.c(paramString);
    }
    this.l = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.i) || (this.h)) {}
    for (;;)
    {
      return;
      ActionTopBarView localActionTopBarView = b();
      if (localActionTopBarView != null) {
        if (paramBoolean)
        {
          localActionTopBarView.c(0);
          localActionTopBarView.a(true);
        }
        else
        {
          localActionTopBarView.c(8);
          localActionTopBarView.a(false);
        }
      }
    }
  }
  
  protected Menu c()
  {
    u localu = new u(this.e);
    localu.add(1001, 10001, 0, "").setIcon(R.drawable.common_icon_title_more);
    localu.add(1001, 10004, 0, R.string.browser_btn_friend).setIcon(R.drawable.browser_menu_tofriend);
    localu.add(1001, 10005, 0, R.string.browser_btn_timeline).setIcon(R.drawable.browser_menu_towechat);
    localu.add(1001, 10006, 0, R.string.browser_btn_favorite).setIcon(R.drawable.browser_menu_collect);
    localu.add(1001, 10003, 0, R.string.browser_btn_copylink).setIcon(R.drawable.browser_menu_copylink);
    localu.add(1001, 10002, 0, R.string.browser_btn_refresh).setIcon(R.drawable.browser_menu_refresh);
    localu.add(1001, 10009, 0, R.string.browser_btn_report).setIcon(R.drawable.browser_menu_report);
    return localu;
  }
  
  public final void c(String paramString)
  {
    a(paramString);
  }
  
  public final void d()
  {
    this.j = true;
    a(a, c());
  }
  
  public final void e()
  {
    this.j = false;
    u localu = new u(this.e);
    a(a, localu);
  }
  
  public final void f()
  {
    ActionTopBarView localActionTopBarView = b();
    if (localActionTopBarView != null) {
      localActionTopBarView.setVisibility(0);
    }
  }
  
  public final void g()
  {
    ActionTopBarView localActionTopBarView = b();
    if (localActionTopBarView != null) {
      localActionTopBarView.setVisibility(8);
    }
  }
  
  public final Context h()
  {
    return this.e;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.g.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    m.a().a(this.e);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = getActivity().getIntent();
    paramBundle = new bg();
    paramLayoutInflater = null;
    Object localObject1;
    if (paramViewGroup != null)
    {
      if (!TextUtils.isEmpty(this.l)) {
        paramViewGroup.setData(Uri.parse(this.l));
      }
      paramBundle.a(paramViewGroup.getBooleanExtra("allowdownload", true));
      paramBundle.c(paramViewGroup.getBooleanExtra("allowtitlebar", false));
      paramBundle.d(paramViewGroup.getBooleanExtra("allowtoolbar", false));
      paramBundle.b(paramViewGroup.getBooleanExtra("allowinput", false));
      this.j = paramViewGroup.getBooleanExtra("showoptionmenu", true);
      paramBundle.e(this.j);
      this.h = paramViewGroup.getBooleanExtra("isregister", false);
      this.i = paramViewGroup.getBooleanExtra("showclose", false);
      this.k = paramViewGroup.getBooleanExtra("showactionbar", true);
      paramLayoutInflater = paramViewGroup.getData();
      if ((!paramBundle.a()) || (paramLayoutInflater == null)) {
        break label544;
      }
      localObject1 = paramLayoutInflater.getHost();
      Object localObject2 = ((DownloadBlackListConf)d.a(this.e).a(DownloadBlackListConf.class)).d();
      if (localObject2 == null) {
        break label544;
      }
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if ((localObject1 != null) && (((String)localObject1).indexOf(str) != -1)) {
          paramBundle.a(false);
        }
      }
    }
    label496:
    label544:
    for (;;)
    {
      this.g = new at(this, paramBundle);
      localObject1 = this.g.h().b().a();
      paramBundle = getArguments();
      if (paramBundle != null) {
        ((WkBrowserWebView)localObject1).c(paramBundle.getString("title"));
      }
      ((WkBrowserWebView)localObject1).a(new h(this, (WkBrowserWebView)localObject1));
      if (this.h)
      {
        this.n = paramViewGroup.getStringExtra("fromSource");
        this.m = new WkRegisterInterface((WebView)localObject1, this.g.r(), this.n);
        this.g.h().b().a().addJavascriptInterface(this.m, "client");
      }
      if (paramLayoutInflater != null)
      {
        com.bluefay.b.h.a("onCreateView url:" + paramLayoutInflater.toString(), new Object[0]);
        paramViewGroup = paramLayoutInflater.toString();
        paramLayoutInflater = paramViewGroup;
        if (paramViewGroup.startsWith("wkb"))
        {
          paramLayoutInflater = paramViewGroup;
          if (!paramViewGroup.startsWith("wkb://"))
          {
            if (!paramViewGroup.startsWith("wkb//")) {
              break label496;
            }
            paramLayoutInflater = paramViewGroup.replaceFirst("//", "://");
          }
        }
      }
      for (;;)
      {
        paramViewGroup = paramLayoutInflater.substring(6);
        paramLayoutInflater = paramViewGroup;
        if (!bp.a(paramViewGroup)) {
          paramLayoutInflater = "http://" + paramViewGroup;
        }
        this.g.c(paramLayoutInflater);
        return this.g;
        if ((paramViewGroup.startsWith("wkb:/")) && (!paramViewGroup.startsWith("wkb://"))) {
          paramLayoutInflater = paramViewGroup.replaceFirst(":/", "://");
        } else {
          paramLayoutInflater = paramViewGroup.replaceFirst("wkb", "wkb://");
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.g.j();
    this.g = null;
  }
  
  public void onDestroyView()
  {
    if ((this.h) && (this.m != null))
    {
      Bundle localBundle = this.m.getLoginRet();
      String str = "4";
      if (localBundle != null)
      {
        this.o += localBundle.getString("lastPath");
        str = localBundle.getString("ret");
      }
      com.lantern.analytics.a.e().onEvent("LoginEnd", g.a(this.n, this.o, str, c.getServer().k()));
      this.m = null;
    }
    bp.g(this.e);
    super.onDestroyView();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Object localObject = null;
    boolean bool;
    if (this.g == null) {
      bool = true;
    }
    String str;
    for (;;)
    {
      return bool;
      str = this.g.l();
      switch (paramMenuItem.getItemId())
      {
      default: 
        bool = super.onOptionsItemSelected(paramMenuItem);
        break;
      case 10002: 
        this.g.f();
        com.lantern.analytics.a.e().onEvent("rf", str);
        bool = true;
        break;
      case 10003: 
        label128:
        if (!TextUtils.isEmpty(str)) {
          break label173;
        }
        bool = true;
      }
    }
    label173:
    paramMenuItem = d.a(this.e).a("wkbrowser");
    if (paramMenuItem != null) {}
    for (paramMenuItem = paramMenuItem.optString("preurl");; paramMenuItem = null)
    {
      if (TextUtils.isEmpty(paramMenuItem)) {
        paramMenuItem = "http://wifiapi02.51y5.net/wifiapi/rd.do?f=link_pv&b=cplk&rurl=";
      }
      for (;;)
      {
        ClipboardManager localClipboardManager = (ClipboardManager)this.e.getSystemService("clipboard");
        JSONObject localJSONObject = d.a(this.e).a("errpage");
        if (localJSONObject != null) {
          localObject = localJSONObject.optString("url");
        }
        if ((localObject != null) && (str.startsWith((String)localObject)))
        {
          localObject = b.b(str, "url");
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            localClipboardManager.setText(paramMenuItem + URLEncoder.encode((String)localObject));
          }
        }
        for (;;)
        {
          Toast.makeText(this.e, R.string.browser_tip_copylink, 0).show();
          com.lantern.analytics.a.e().onEvent("copy", str);
          bool = true;
          break;
          localClipboardManager.setText(paramMenuItem + URLEncoder.encode(str));
        }
        this.g.a("menu", 0);
        bool = true;
        break;
        this.g.a("menu", 1);
        bool = true;
        break;
        this.g.a("menu", 100);
        bool = true;
        break;
        if ((this.i) || (this.h)) {
          a();
        }
        for (;;)
        {
          bool = true;
          break;
          this.g.e();
        }
        this.g.g();
        bool = true;
        break;
        localObject = new Intent("wifi.intent.action.DOWNLOADS_MAIN");
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).setPackage(this.e.getPackageName());
        this.e.startActivity((Intent)localObject);
        break label128;
        localObject = new Intent("wifi.intent.action.APPSTORE_MAIN");
        ((Intent)localObject).setPackage(this.e.getPackageName());
        ((Intent)localObject).addFlags(268435456);
        this.e.startActivity((Intent)localObject);
        break label128;
        localObject = com.lantern.browser.a.b() + "?url=" + URLEncoder.encode(str);
        this.g.c((String)localObject);
        break label128;
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.g != null) {
      this.g.t();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.g != null) {
      this.g.s();
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = b();
    if (paramView != null)
    {
      paramView.d(1);
      paramView.c(8);
      paramView.a();
      paramBundle = (Button)paramView.findViewById(R.id.title_panel);
      if (paramBundle != null)
      {
        paramBundle.setSingleLine(true);
        paramBundle.setEllipsize(TextUtils.TruncateAt.END);
      }
      if (!this.k) {
        paramView.setVisibility(8);
      }
    }
    if ((this.i) || (this.h))
    {
      int i1 = R.drawable.framework_title_bar_close_button;
      paramView = getActivity();
      if ((paramView != null) && ((paramView instanceof bluefay.app.o))) {
        ((bluefay.app.o)paramView).c(i1);
      }
    }
    for (;;)
    {
      return;
      if (this.j) {
        a(a, c());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/WkBrowserFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */