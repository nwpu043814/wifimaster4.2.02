package com.lantern.settings.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import bluefay.app.q;
import bluefay.app.u;
import bluefay.preference.Preference;
import bluefay.preference.PreferenceCategory;
import bluefay.preference.PreferenceScreen;
import bluefay.preference.ValuePreference;
import com.bluefay.a.b;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.bluefay.material.f;
import com.bluefay.preference.PSPreferenceFragment;
import com.lantern.core.g.k.b;
import com.lantern.core.o;
import com.lantern.core.p;
import com.lantern.settings.R.drawable;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;
import com.lantern.settings.R.style;
import com.lantern.settings.R.xml;
import com.snda.wifilocating.wxapi.WkWeiXinUtil;
import com.tencent.mm.sdk.openapi.IWXAPI;
import java.io.File;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class MoreFragment
  extends PSPreferenceFragment
  implements q
{
  private w A;
  private f B;
  private ar C;
  private ValuePreference D;
  private ValuePreference E;
  private com.bluefay.b.a F = new ae(this);
  private com.lantern.core.g.k.a G = new aj(this);
  private Handler H = new ag(this);
  private final String j = "settings_pref_ver_check";
  private final String k = "settings_pref_cache_check";
  private final String l = "settings_pref_feedback";
  private final String m = "settings_pref_grade";
  private final int n = 1001;
  private final int o = 1002;
  private String p = "";
  private Preference q;
  private Preference r;
  private Preference s;
  private ValuePreference t;
  private ValuePreference u;
  private Preference v;
  private Preference w;
  private Preference x;
  private Preference y;
  private ExitPreference z;
  
  private void f()
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.SUBJECT", getString(R.string.settings_more_sendto_subject));
    localIntent.putExtra("android.intent.extra.TEXT", getString(R.string.settings_more_sendto_content));
    localIntent.addFlags(268435456);
    try
    {
      startActivity(Intent.createChooser(localIntent, getString(R.string.settings_more_sendto_title)));
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private void g()
  {
    if (this.B == null)
    {
      this.B = new f(this.e);
      this.B.a(getString(R.string.pull_to_refresh_footer_refreshing_label));
      this.B.setCanceledOnTouchOutside(false);
      this.B.setOnCancelListener(new aq(this));
    }
    this.B.show();
  }
  
  private void h()
  {
    for (;;)
    {
      try
      {
        Activity localActivity = getActivity();
        localObject1 = "0KB";
        localObject2 = localActivity.getCacheDir();
        File localFile = com.lantern.core.c.getAppCacheDir();
        l1 = com.lantern.settings.b.d.a((File)localObject2);
        long l2 = com.lantern.settings.b.d.a(localFile) + (l1 + 0L);
        l1 = l2;
        if (Build.VERSION.SDK_INT >= 8) {
          l1 = l2 + com.lantern.settings.b.d.a(localActivity.getExternalCacheDir());
        }
        if (l1 > 0L)
        {
          localObject1 = new java/text/DecimalFormat;
          ((DecimalFormat)localObject1).<init>("#.00");
          if (l1 >= 1024L) {
            continue;
          }
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          localObject1 = ((DecimalFormat)localObject1).format(l1) + "B";
        }
        this.p = ((String)localObject1);
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2;
        long l1;
        localException.printStackTrace();
        this.p = "0KB";
        continue;
      }
      if (this.u != null) {
        this.u.a(this.p);
      }
      return;
      if (l1 < 1048576L)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = ((DecimalFormat)localObject1).format(l1 / 1024.0D) + "KB";
      }
      else if (l1 < 1073741824L)
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = ((DecimalFormat)localObject1).format(l1 / 1048576.0D) + "MB";
      }
      else
      {
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        localObject1 = ((DecimalFormat)localObject1).format(l1 / 1.073741824E9D) + "G";
      }
    }
  }
  
  public final void a(Context paramContext)
  {
    h.a("OK", new Object[0]);
    b(-1);
    paramContext = new u(this.e);
    paramContext.add(101, 1001, 0, "Recommend").setIcon(R.drawable.common_icon_title_recommend);
    a(a, paramContext);
  }
  
  public final boolean a(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    if (this.r == paramPreference)
    {
      com.lantern.analytics.a.e().onEvent("invcli");
      if (WkWeiXinUtil.isWXAppInstalledAndSupported()) {
        break label66;
      }
      f();
    }
    boolean bool;
    label66:
    Object localObject1;
    while (this.s == paramPreference)
    {
      startActivity(new Intent(this.e, SpitslotActivity.class));
      com.lantern.analytics.a.e().onEvent("suggestion");
      bool = true;
      return bool;
      Object localObject2 = getActivity().getLayoutInflater().inflate(R.layout.settings_invite_dialog, null);
      Object localObject3 = (GridView)((View)localObject2).findViewById(R.id.settings_invite_grid_view);
      ((GridView)localObject3).setAdapter(this.A);
      localObject1 = new Dialog(this.e, R.style.Settings_Dlg_Transparent);
      ((Dialog)localObject1).setContentView((View)localObject2, new ViewGroup.LayoutParams(-1, -2));
      ((GridView)localObject3).setOnItemClickListener(new an(this, (Dialog)localObject1));
      ((Button)((View)localObject2).findViewById(R.id.settings_invite_cancel)).setOnClickListener(new ao(this, (Dialog)localObject1));
      ((Dialog)localObject1).setOnCancelListener(new ap(this));
      localObject3 = ((Dialog)localObject1).getWindow();
      localObject2 = new DisplayMetrics();
      getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
      localObject3 = ((Window)localObject3).getAttributes();
      ((WindowManager.LayoutParams)localObject3).x = 0;
      ((WindowManager.LayoutParams)localObject3).y = ((DisplayMetrics)localObject2).heightPixels;
      ((WindowManager.LayoutParams)localObject3).width = -1;
      ((WindowManager.LayoutParams)localObject3).height = -2;
      ((Dialog)localObject1).onWindowAttributesChanged((WindowManager.LayoutParams)localObject3);
      ((Dialog)localObject1).setCanceledOnTouchOutside(true);
      ((Dialog)localObject1).show();
    }
    if (this.y == paramPreference)
    {
      paramPreference = "http://master.lianwifi.com/act?title=" + URLEncoder.encode(String.valueOf(this.y.r()));
      paramPreferenceScreen = com.lantern.core.config.d.a(this.e).a("claimap");
      if (paramPreferenceScreen != null)
      {
        paramPreferenceScreen = paramPreferenceScreen.optString("masb");
        label343:
        if (TextUtils.isEmpty(paramPreferenceScreen)) {
          break label1106;
        }
      }
    }
    for (;;)
    {
      paramPreference = new Intent("wifi.intent.action.BROWSER", Uri.parse(paramPreferenceScreen));
      paramPreference.setPackage(this.e.getPackageName());
      paramPreferenceScreen = new Bundle();
      paramPreferenceScreen.putBoolean("showoptionmenu", false);
      paramPreference.putExtras(paramPreferenceScreen);
      this.e.startActivity(paramPreference);
      com.lantern.analytics.a.e().onEvent("bemaster");
      bool = true;
      break;
      paramPreferenceScreen = null;
      break label343;
      if (this.t == paramPreference)
      {
        g();
        com.lantern.c.a.a(this.e).a(true, this.F);
        com.lantern.analytics.a.e().onEvent("ups");
        bool = true;
        break;
      }
      if (this.u == paramPreference)
      {
        localObject1 = new bluefay.app.k.a(getActivity());
        ((bluefay.app.k.a)localObject1).a(R.string.settings_pref_clean_cache_dialog_title);
        ((bluefay.app.k.a)localObject1).b(R.string.settings_pref_clean_cache_dialog_tip);
        ((bluefay.app.k.a)localObject1).a(R.string.dialog_ok, new ah(this));
        ((bluefay.app.k.a)localObject1).b(R.string.dialog_cancel, new ai(this));
        ((bluefay.app.k.a)localObject1).d();
      }
      if (paramPreference == this.v) {
        try
        {
          paramPreferenceScreen = new java/lang/StringBuilder;
          paramPreferenceScreen.<init>("http://static.51y5.net/wifi/allege_ap_v2/?lang=");
          paramPreference = paramPreferenceScreen.append(com.lantern.core.k.c()).append("&appid=");
          paramPreferenceScreen = new com/lantern/core/o;
          paramPreferenceScreen.<init>(this.e);
          paramPreference = paramPreferenceScreen.k();
          paramPreferenceScreen = new android/content/Intent;
          paramPreferenceScreen.<init>("wifi.intent.action.BROWSER", Uri.parse(paramPreference));
          paramPreferenceScreen.setPackage(getActivity().getPackageName());
          paramPreference = new android/os/Bundle;
          paramPreference.<init>();
          paramPreference.putBoolean("showoptionmenu", false);
          paramPreference.putBoolean("allowbannerad", false);
          paramPreferenceScreen.putExtras(paramPreference);
          getActivity().startActivity(paramPreferenceScreen);
          com.lantern.analytics.a.e().onEvent("sharecancel");
          bool = true;
        }
        catch (ActivityNotFoundException paramPreferenceScreen)
        {
          for (;;)
          {
            paramPreferenceScreen.printStackTrace();
          }
        }
      }
      if (paramPreference == this.x)
      {
        com.lantern.analytics.a.e().onEvent("rateus");
        paramPreferenceScreen = new Intent("android.intent.action.VIEW");
        paramPreferenceScreen.setData(Uri.parse("market://details?id=" + getActivity().getPackageName()));
        try
        {
          startActivity(paramPreferenceScreen);
          bool = true;
        }
        catch (ActivityNotFoundException paramPreferenceScreen)
        {
          for (;;)
          {
            e.a(R.string.settings_about_no_market_installed);
          }
        }
      }
      if (paramPreference == this.z)
      {
        paramPreferenceScreen = new bluefay.app.k.a(getActivity());
        paramPreferenceScreen.a(R.string.settings_pref_exiting_dialog_title);
        paramPreferenceScreen.b(R.string.settings_pref_exiting_dialog_tip);
        paramPreferenceScreen.a(R.string.dialog_ok, new al(this));
        paramPreferenceScreen.b(R.string.dialog_cancel, new am(this));
        paramPreferenceScreen.d();
        com.lantern.analytics.a.e().onEvent("exit_login");
        bool = true;
        break;
      }
      if (this.D == paramPreference)
      {
        if (WkWeiXinUtil.getWxApi().isWXAppInstalled())
        {
          com.lantern.analytics.a.e().onEvent("followus");
          WkWeiXinUtil.openApp();
          new Handler().postDelayed(new ak(this), 1500L);
        }
        for (;;)
        {
          bool = true;
          break;
          e.a(R.string.settings_no_install_weixin_tip);
        }
      }
      if (this.E == paramPreference)
      {
        if (b.a(this.e, "com.sina.weibo"))
        {
          paramPreferenceScreen = new Intent("android.intent.action.VIEW");
          paramPreferenceScreen.setPackage("com.sina.weibo");
          paramPreferenceScreen.setData(Uri.parse("sinaweibo://userinfo?uid=2636535561"));
          paramPreferenceScreen.setFlags(268435456);
          e.a(this.e, paramPreferenceScreen);
        }
        for (;;)
        {
          p.a(this.e, "sdk_common", "weibo_clicked", true);
          com.lantern.core.g.k.a().c(k.b.w);
          com.lantern.analytics.a.e().onEvent("Followuswb");
          bool = true;
          break;
          paramPreferenceScreen = new Intent("wifi.intent.action.BROWSER", Uri.parse("http://weibo.com/wifikey"));
          paramPreferenceScreen.setPackage(this.e.getPackageName());
          paramPreferenceScreen.addFlags(268435456);
          paramPreference = new Bundle();
          paramPreference.putBoolean("showclose", true);
          paramPreferenceScreen.putExtras(paramPreference);
          e.a(this.e, paramPreferenceScreen);
        }
      }
      bool = super.a(paramPreferenceScreen, paramPreference);
      break;
      label1106:
      paramPreferenceScreen = paramPreference;
    }
  }
  
  public final void b(Context paramContext) {}
  
  public final void c(Context paramContext) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d(R.xml.settings_more);
    this.q = b("settings_pref_settings");
    this.r = b("settings_pref_invite");
    this.x = b("settings_pref_grade");
    this.y = b("settings_pref_became_ap_owner");
    this.t = ((ValuePreference)b("settings_pref_ver_check"));
    this.u = ((ValuePreference)b("settings_pref_cache_check"));
    paramBundle = com.bluefay.a.c.a(this.e);
    if ((this.t != null) && (paramBundle != null)) {
      this.t.a(paramBundle);
    }
    h();
    this.D = ((ValuePreference)b("settings_pref_follow_weixin"));
    this.E = ((ValuePreference)b("settings_pref_follow_weibo"));
    if (this.D != null) {
      this.D.a(this.e.getResources().getString(R.string.settings_about_wenxinhao_title));
    }
    if (this.E != null) {
      this.E.a("weibo.com/wifikey");
    }
    this.v = b("settings_pref_shared_ap");
    this.s = b("settings_pref_feedback");
    this.w = b("settings_pref_about");
    this.z = ((ExitPreference)b("settings_pref_exit"));
    int i;
    if (!TextUtils.isEmpty(p.c(this.e)))
    {
      ((PreferenceCategory)b("settings_pref_exit_category")).b(this.z);
      this.A = new w(this.e);
      this.C = new ar(this.e);
      paramBundle = b("settings_pref_set_default");
      if (Build.VERSION.SDK_INT < 23) {
        break label340;
      }
      i = 1;
      label309:
      if (i == 0) {
        break label345;
      }
      a(paramBundle);
    }
    label340:
    label345:
    label459:
    for (;;)
    {
      return;
      ((PreferenceCategory)b("settings_pref_exit_category")).c(this.z);
      break;
      i = 0;
      break label309;
      Context localContext = this.e;
      Object localObject2 = localContext.getPackageManager();
      Object localObject1 = new ArrayList();
      ((PackageManager)localObject2).getPreferredActivities(new ArrayList(), (List)localObject1, localContext.getPackageName());
      localObject2 = new ComponentName(localContext.getPackageName(), "com.lantern.launcher.ui.DefaultSettings");
      localObject1 = ((ArrayList)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!((ComponentName)localObject2).equals((ComponentName)((Iterator)localObject1).next()));
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label459;
        }
        a(paramBundle);
        com.lantern.analytics.a.e().onEvent("wfm");
        break;
      }
    }
  }
  
  public void onDestroyView()
  {
    com.lantern.core.g.k.a().a(this.G);
    super.onDestroyView();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    com.lantern.core.g.k.a().b(this.G);
  }
  
  private final class a
    extends AsyncTask<View, Void, String>
  {
    private a() {}
    
    protected final void onPreExecute()
    {
      f localf = new f(MoreFragment.this.getActivity());
      localf.a(MoreFragment.this.getString(R.string.settings_pref_exiting));
      localf.setCanceledOnTouchOutside(false);
      localf.show();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/MoreFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */