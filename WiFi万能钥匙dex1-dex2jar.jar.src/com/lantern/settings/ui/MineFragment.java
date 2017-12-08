package com.lantern.settings.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import bluefay.app.q;
import bluefay.app.u;
import bluefay.preference.Preference;
import bluefay.preference.PreferenceCategory;
import bluefay.preference.PreferenceScreen;
import com.bluefay.b.h;
import com.bluefay.preference.PSPreferenceFragment;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.core.config.AppStoreConf;
import com.lantern.core.config.RedDotConf;
import com.lantern.core.config.ShopEntranceConf;
import com.lantern.core.config.WalletConf;
import com.lantern.core.f;
import com.lantern.core.g.k;
import com.lantern.core.g.k.a;
import com.lantern.core.g.k.b;
import com.lantern.core.p;
import com.lantern.settings.R.dimen;
import com.lantern.settings.R.drawable;
import com.lantern.settings.R.string;
import com.lantern.settings.R.xml;
import com.lantern.settings.widget.OperationPreference;
import com.lantern.settings.widget.ShopPreference;
import com.lantern.settings.widget.UserLevelPreference;
import com.lantern.settings.widget.WalletPreference;
import com.wifipay.wallet.WalletApi;
import com.wifipay.wallet.openapi.ActionType;
import com.wifipay.wallet.openapi.WalletParams;
import java.util.Calendar;

public class MineFragment
  extends PSPreferenceFragment
  implements q
{
  private ShopPreference A;
  private k.a B = new ab(this);
  private ar j;
  private Preference k;
  private UserLevelPreference l;
  private Preference m;
  private Preference n;
  private Preference o;
  private Preference p;
  private Preference q;
  private WalletPreference r;
  private Preference s;
  private Preference t;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private Handler x;
  private String y;
  private OperationPreference z;
  
  private void f()
  {
    String str = p.e(this.e);
    if ((com.bluefay.b.j.a(str)) && (!str.equals(this.y))) {
      com.lantern.settings.b.a.a(this.x, str, false, new aa(this, str));
    }
  }
  
  private void g()
  {
    u localu = new u(this.e);
    Object localObject = (AppStoreConf)com.lantern.core.config.d.a(this.e).a(AppStoreConf.class);
    boolean bool = true;
    if (localObject != null) {
      bool = ((AppStoreConf)localObject).d();
    }
    if ((!"freemeos".equals(p.d("-1"))) && (f.g()) && (bool))
    {
      if (localObject == null) {
        break label115;
      }
      localObject = localu.add(101, 10001, 0, ((AppStoreConf)localObject).g());
      if (!k.a().d(k.b.t)) {
        break label134;
      }
      ((MenuItem)localObject).setIcon(R.drawable.common_icon_appstore_reddot);
    }
    for (;;)
    {
      a(a, localu);
      return;
      label115:
      localObject = localu.add(101, 10001, 0, R.string.browser_btn_appstore);
      break;
      label134:
      ((MenuItem)localObject).setIcon(R.drawable.common_icon_appstore);
    }
  }
  
  private void h()
  {
    ShopEntranceConf localShopEntranceConf = (ShopEntranceConf)com.lantern.core.config.d.a(this.e).a(ShopEntranceConf.class);
    if ((localShopEntranceConf != null) && (localShopEntranceConf.d())) {
      if (com.bluefay.a.d.a(this.e, "WkServiceAccount", com.lantern.core.c.getServer().h())) {
        a(true);
      }
    }
    for (;;)
    {
      return;
      new com.lantern.settings.a.a(new ac(this)).start();
      continue;
      a(false);
    }
  }
  
  private void i()
  {
    if (!com.bluefay.a.a.c(this.e)) {
      com.bluefay.a.e.a(this.e.getString(R.string.auth_failed_no_network));
    }
    for (;;)
    {
      return;
      Intent localIntent = new Intent("wifi.intent.action.ADD_ACCOUNT_MAIN");
      localIntent.setPackage(this.e.getPackageName());
      localIntent.putExtra("srcReq", "2");
      localIntent.putExtra("fromSource", "app_login");
      com.bluefay.a.e.a(this.e, localIntent);
      this.v = false;
    }
  }
  
  public final void a(Context paramContext)
  {
    a(R.string.settings_title);
    b(-1);
    b().a(null);
    int i;
    if (((RedDotConf)com.lantern.core.config.d.a(this.e).a(RedDotConf.class)).e())
    {
      long l1 = p.b(this.e);
      paramContext = Calendar.getInstance();
      paramContext.setTimeInMillis(l1);
      if (paramContext.get(5) != Calendar.getInstance().get(5))
      {
        i = 1;
        if (i != 0)
        {
          k.a().a(k.b.t);
          p.b(this.e, System.currentTimeMillis());
        }
      }
    }
    for (;;)
    {
      g();
      com.lantern.analytics.a.e().onEvent("minin");
      h();
      return;
      i = 0;
      break;
      k.a().b(k.b.t);
    }
  }
  
  final void a(boolean paramBoolean)
  {
    PreferenceCategory localPreferenceCategory = (PreferenceCategory)b("settings_pref_activity_category");
    if (localPreferenceCategory != null)
    {
      if (!paramBoolean) {
        break label29;
      }
      localPreferenceCategory.b(this.A);
    }
    for (;;)
    {
      return;
      label29:
      localPreferenceCategory.c(this.A);
    }
  }
  
  public final boolean a(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    boolean bool;
    if (paramPreference == this.k) {
      if (!this.u)
      {
        i();
        com.lantern.analytics.a.e().onEvent("bscskip");
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      paramPreferenceScreen = new Intent("wifi.intent.action.SETTINGS_USER_INFO");
      paramPreferenceScreen.setPackage(this.e.getPackageName());
      com.bluefay.a.e.a(getActivity(), paramPreferenceScreen);
      com.lantern.analytics.a.e().onEvent("bsccli");
      break;
      if (paramPreference == this.p)
      {
        if (!this.u) {
          i();
        }
        for (;;)
        {
          com.lantern.analytics.a.e().onEvent("backuprestore");
          bool = true;
          break;
          paramPreferenceScreen = new Intent("wifi.intent.action.SETTINGS_BACKUP");
          paramPreferenceScreen.setPackage(this.e.getPackageName());
          com.bluefay.a.e.a(this.e, paramPreferenceScreen);
        }
      }
      if (this.t == paramPreference)
      {
        paramPreferenceScreen = "http://kf.lianwifi.com/";
        if (!com.bluefay.a.e.c(this.e)) {
          paramPreferenceScreen = "file:///android_asset/html/" + this.e.getString(R.string.settings_web_feedback_faq_file_name);
        }
        paramPreferenceScreen = new Intent("wifi.intent.action.BROWSER", Uri.parse(paramPreferenceScreen));
        paramPreferenceScreen.setPackage(this.e.getPackageName());
        paramPreference = new Bundle();
        paramPreference.putBoolean("showoptionmenu", false);
        paramPreference.putInt("orientation", 1);
        paramPreferenceScreen.putExtras(paramPreference);
        startActivity(paramPreferenceScreen);
        com.lantern.analytics.a.e().onEvent("help");
        bool = true;
      }
      else if (this.l == paramPreference)
      {
        try
        {
          paramPreferenceScreen = new java/lang/StringBuilder;
          paramPreferenceScreen.<init>("uhid=");
          paramPreference = com.lantern.core.c.getServer().h();
          paramPreferenceScreen = new java/lang/StringBuilder;
          paramPreferenceScreen.<init>("http://master.lianwifi.com/api/myrank?data=");
          paramPreference = com.lantern.settings.b.e.a(paramPreference);
          paramPreferenceScreen = new android/content/Intent;
          paramPreferenceScreen.<init>("wifi.intent.action.BROWSER", Uri.parse(paramPreference));
          paramPreferenceScreen.setPackage(this.e.getPackageName());
          paramPreference = new android/os/Bundle;
          paramPreference.<init>();
          paramPreference.putBoolean("showoptionmenu", false);
          paramPreference.putBoolean("allowbannerad", false);
          paramPreferenceScreen.putExtras(paramPreference);
          this.e.startActivity(paramPreferenceScreen);
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
      else if (this.m == paramPreference)
      {
        paramPreferenceScreen = new Intent("wifi.intent.action.MAILBOX_MAIN");
        paramPreferenceScreen.setPackage(this.e.getPackageName());
        com.bluefay.a.e.a(getActivity(), paramPreferenceScreen);
        k.a().c(k.b.e);
        com.lantern.analytics.a.e().onEvent("msg");
        bool = true;
      }
      else if (this.n == paramPreference)
      {
        paramPreferenceScreen = new Intent("wifi.intent.action.PLUGIN_MAIN");
        paramPreferenceScreen.setPackage(this.e.getPackageName());
        com.bluefay.a.e.a(this.e, paramPreferenceScreen);
        com.lantern.analytics.a.e().onEvent("tools");
        bool = true;
      }
      else if (this.q == paramPreference)
      {
        paramPreferenceScreen = new Intent("wifi.intent.action.SETTINGS_MAIN");
        paramPreferenceScreen.setPackage(this.e.getPackageName());
        com.bluefay.a.e.a(this.e, paramPreferenceScreen);
        com.lantern.analytics.a.e().onEvent("my_set");
        bool = true;
      }
      else
      {
        if (this.o != paramPreference) {
          break label674;
        }
        paramPreferenceScreen = new Intent("wifi.intent.action.BROWSER", Uri.parse("http://insurance.lianwifi.com/"));
        paramPreferenceScreen.setPackage(this.e.getPackageName());
        paramPreference = new Bundle();
        paramPreference.putBoolean("showoptionmenu", false);
        paramPreferenceScreen.putExtras(paramPreference);
        this.e.startActivity(paramPreferenceScreen);
        p.a(this.e, "sdk_common", "insurance_clicked", true);
        k.a().c(k.b.j);
        com.lantern.analytics.a.e().onEvent("insurance");
        bool = true;
      }
    }
    label674:
    Object localObject;
    if (this.s == paramPreference)
    {
      localObject = new Intent("wifi.intent.action.FAVORITE");
      ((Intent)localObject).setPackage(this.e.getPackageName());
      com.bluefay.a.e.a(this.e, (Intent)localObject);
    }
    for (;;)
    {
      bool = super.a(paramPreferenceScreen, paramPreference);
      break;
      if (this.z == paramPreference)
      {
        com.lantern.core.j.a();
        paramPreferenceScreen = new Intent("wifi.intent.action.BROWSER", Uri.parse(com.lantern.core.j.a("activity_url", "http://www.wifi.com/")));
        paramPreferenceScreen.setPackage(this.e.getPackageName());
        paramPreference = new Bundle();
        paramPreference.putBoolean("showoptionmenu", false);
        paramPreferenceScreen.putExtras(paramPreference);
        this.e.startActivity(paramPreferenceScreen);
        p.b(this.e, "sdk_common", "last_activity_time", System.currentTimeMillis());
        k.a().c(k.b.k);
        paramPreferenceScreen = com.lantern.analytics.a.e();
        com.lantern.core.j.a();
        paramPreferenceScreen.onEvent("actyclick", com.lantern.core.j.a("activity_id", ""));
        bool = true;
        break;
      }
      if (paramPreference == this.r)
      {
        paramPreferenceScreen = getActivity();
        localObject = new WalletParams();
        ((WalletParams)localObject).lati = com.lantern.core.c.getServer().d();
        ((WalletParams)localObject).longi = com.lantern.core.c.getServer().e();
        ((WalletParams)localObject).mapSP = com.lantern.core.c.getServer().o();
        ((WalletParams)localObject).uhid = p.c("");
        ((WalletParams)localObject).userToken = p.f(com.lantern.core.c.getInstance());
        paramPreference = ActionType.HOME_PAGE;
        h.a("wallet params " + localObject, new Object[0]);
        com.lantern.analytics.a.e().onEvent("wt_home");
        if (((WalletConf)com.lantern.core.config.d.a(paramPreferenceScreen).a(WalletConf.class)).e() == 2)
        {
          paramPreference = new Intent("wifi.intent.action.BROWSER", Uri.parse(((WalletConf)com.lantern.core.config.d.a(paramPreferenceScreen).a(WalletConf.class)).f()));
          paramPreference.setPackage(paramPreferenceScreen.getPackageName());
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("showclose", true);
          paramPreference.putExtras((Bundle)localObject);
          com.bluefay.a.e.a(paramPreferenceScreen, paramPreference);
        }
        for (;;)
        {
          bool = true;
          break;
          WalletApi.startAction(paramPreferenceScreen, (WalletParams)localObject, paramPreference);
        }
      }
      if (this.A == paramPreference)
      {
        k.a().c(k.b.x);
        com.lantern.core.g.o.a().c();
        this.A.b();
        try
        {
          com.lantern.analytics.a.e().onEvent("slistcli");
          localObject = new android/content/Intent;
          ((Intent)localObject).<init>("com.linksure.aps.action.LIST");
          ((Intent)localObject).setPackage(this.e.getPackageName());
          ((Intent)localObject).addFlags(268435456);
          this.e.startActivity((Intent)localObject);
        }
        catch (Exception localException)
        {
          h.a(localException);
        }
      }
    }
  }
  
  public final void b(Context paramContext)
  {
    com.lantern.analytics.a.e().onEvent("minout");
  }
  
  public final void c(Context paramContext) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d(R.xml.settings_mine);
    this.x = new Handler();
    this.l = ((UserLevelPreference)b("settings_pref_level"));
    this.m = b("settings_pref_message");
    this.s = b("settings_pref_favorite");
    this.o = b("settings_pref_insurance");
    this.n = b("settings_pref_plugin");
    this.k = b("pref_person");
    this.p = b("settings_pref_backup_ap");
    this.q = b("settings_pref_minesettings");
    this.t = b("settings_pref_feedback");
    this.r = ((WalletPreference)b("settings_wallet"));
    this.z = ((OperationPreference)b("settings_pref_activity"));
    this.A = ((ShopPreference)b("settings_pref_shop"));
    com.lantern.core.j.a();
    Object localObject;
    if (com.lantern.core.j.a("activity_enable") == 1)
    {
      paramBundle = this.z;
      com.lantern.core.j.a();
      paramBundle.a(com.lantern.core.j.a("activity_title", ""));
      paramBundle = new ImageView(this.e);
      localObject = this.e;
      com.lantern.core.j.a();
      com.lantern.core.imageloader.c.a((Context)localObject, com.lantern.core.j.a("activity_icon", ""), paramBundle, new x(this, paramBundle), null, getResources().getDimensionPixelSize(R.dimen.settings_icon_length), getResources().getDimensionPixelSize(R.dimen.settings_icon_length));
      ((PreferenceCategory)b("settings_pref_activity_category")).b(this.z);
      paramBundle = com.lantern.analytics.a.e();
      com.lantern.core.j.a();
      paramBundle.onEvent("actyshow", com.lantern.core.j.a("activity_id", ""));
      ((PreferenceCategory)b("settings_pref_activity_category")).c(this.A);
      ((PreferenceCategory)b("settings_pref_activity_category")).c(this.l);
      h();
      paramBundle = (WalletConf)com.lantern.core.config.d.a(getActivity()).a(WalletConf.class);
      if (paramBundle != null) {
        break label531;
      }
      paramBundle = new WalletConf(getActivity());
    }
    label531:
    for (;;)
    {
      if (!paramBundle.d()) {
        a(b("settings_pref_wallet_category"));
      }
      if (paramBundle.i())
      {
        this.r.a(paramBundle.h());
        localObject = new ImageView(this.e);
        com.lantern.core.imageloader.c.a(this.e, paramBundle.g(), (ImageView)localObject, new ad(this, (ImageView)localObject), null, getResources().getDimensionPixelSize(R.dimen.settings_icon_length), getResources().getDimensionPixelSize(R.dimen.settings_icon_length));
      }
      for (;;)
      {
        this.j = new ar(this.e);
        return;
        ((PreferenceCategory)b("settings_pref_activity_category")).c(this.z);
        break;
        this.r.b(null);
        this.r.a("");
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroyView()
  {
    k.a().a(this.B);
    super.onDestroyView();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      try
      {
        k.a().b(k.b.t);
        Intent localIntent = new android/content/Intent;
        localIntent.<init>("wifi.intent.action.APPSTORE_MAIN");
        localIntent.setPackage(this.e.getPackageName());
        this.e.startActivity(localIntent);
        com.lantern.analytics.a.e().onEvent("bbxin_m");
      }
      catch (Exception localException) {}
    }
  }
  
  public void onResume()
  {
    h();
    if (isVisible()) {
      g();
    }
    String str2 = p.c(this.e);
    h.a("mobile:" + str2, new Object[0]);
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.indexOf("-") != -1)
      {
        String[] arrayOfString = str2.split("-");
        str1 = str2;
        if (arrayOfString != null)
        {
          str1 = str2;
          if (arrayOfString.length == 2)
          {
            str1 = str2;
            if (!TextUtils.isEmpty(arrayOfString[1])) {
              str1 = arrayOfString[1];
            }
          }
        }
      }
    }
    boolean bool;
    if (str1.length() > 0)
    {
      bool = true;
      this.u = bool;
      if (!this.u) {
        break label245;
      }
      str2 = p.d(this.e);
      if (!com.lantern.settings.b.e.a(str2)) {
        break label180;
      }
      this.k.b(str2);
      f();
      label159:
      this.k.a(com.lantern.settings.b.e.b(str1));
    }
    for (;;)
    {
      super.onResume();
      return;
      bool = false;
      break;
      label180:
      this.k.b("");
      if (!this.v)
      {
        this.v = true;
        new com.lantern.settings.a.d(new z(this)).execute(new Void[0]);
        break label159;
      }
      this.k.e(R.string.settings_user_info_no_nickname);
      f();
      break label159;
      label245:
      this.k.e(R.string.settings_pref_register_title);
      this.k.g(R.string.settings_pref_register_summary);
      this.l.g(R.string.settings_pref_level_summary);
      this.k.f(R.drawable.settings_account_avtar);
      this.y = "";
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    g();
    k.a().b(this.B);
    com.lantern.core.g.o.a().a(new y(this));
    com.lantern.core.g.o.a().b();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/MineFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */