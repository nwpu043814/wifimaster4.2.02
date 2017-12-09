package com.wifi.connect.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import bluefay.app.ViewPagerFragment;
import com.bluefay.a.e;
import com.bluefay.d.b;
import com.bluefay.material.SwipeRefreshLayout;
import com.bluefay.material.SwipeRefreshLayout.a;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.connect.R.drawable;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;
import com.lantern.connect.R.string;
import com.lantern.core.config.AppStoreConf;
import com.lantern.core.config.PresentBoxConf;
import com.lantern.core.config.RecommendLinkConf;
import com.lantern.core.config.RedDotConf;
import com.lantern.core.f;
import com.lantern.core.g.j;
import com.lantern.core.g.k.a;
import com.lantern.core.g.k.b;
import com.lantern.core.location.LocationType;
import com.lantern.core.location.WkLocationManager;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.q;
import com.wifi.connect.b.ag;
import com.wifi.connect.b.v;
import com.wifi.connect.model.AccessPoint;
import com.wifi.connect.model.AccessPointAlias;
import com.wifi.connect.plugin.l;
import com.wifi.connect.widget.l.a;
import com.wifi.connect.widget.n.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

//连接进度界面。
public class ConnectFragment
  extends ViewPagerFragment
{
  private boolean A = false;
  private boolean B = false;
  private AccessPoint C;
  private boolean D = false;
  private boolean E;
  private boolean F;
  private AtomicBoolean G = new AtomicBoolean(false);
  private View H = null;
  private BitmapDrawable I;
  private boolean J = false;
  private boolean K = false;
  private boolean L = false;
  private final int M = 128101;
  private final int N = 128102;
  private final int[] O = { 128005, 128100, 128030, 128035, 128036, 128203, 128310 };
  private String P = "";
  private boolean Q = false;
  private com.wifi.a.a.a R;
  private b S = new c(this, this.O);
  private WifiListHeaderView.a T = new aa(this);
  private WifiListFooterView.a U = new ah(this);
  private AdapterView.OnItemClickListener V = new ai(this);
  private AbsListView.OnScrollListener W = new aj(this);
  private SwipeRefreshLayout.a X = new ak(this);
  private com.bluefay.b.a Y = new al(this);
  private com.bluefay.b.a Z = new am(this);
  private n.a aa = new g(this);
  private com.bluefay.b.a ab = new k(this);
  private com.bluefay.b.a ac = new n(this);
  private l.a ad = new r(this);
  private com.bluefay.b.a ae = new t(this);
  private com.bluefay.b.a af = new z(this);
  private k.a ag = new ae(this);
  long g = 0L;
  private SwipeRefreshLayout h;
  private WifiDisabledView i;
  private ViewGroup j;
  private ListView k;
  private WifiListHeaderView l;
  private WifiListFooterView m;
  private View n;
  private TextView o;
  private a p;
  private com.wifi.connect.widget.n q;
  private ag r;
  private WifiManager s;
  private com.wifi.connect.b.aj t;
  private com.wifi.connect.b.ah u;
  private l v;
  private com.wifi.connect.e.c w;
  private com.lantern.core.g.r x;
  private int y = 0;
  private boolean z = false;
  
  private Drawable a(View paramView)
  {
    try
    {
      int i1 = Math.round(this.e.getResources().getDisplayMetrics().density * 4.0F);
      paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramView.layout(0, 0, paramView.getMeasuredWidth() + i1, i1 + paramView.getMeasuredHeight());
      paramView.buildDrawingCache();
      Bitmap localBitmap = paramView.getDrawingCache();
      if (localBitmap == null) {
        break label89;
      }
      paramView = new android/graphics/drawable/BitmapDrawable;
      paramView.<init>(this.e.getResources(), localBitmap);
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramView);
        label89:
        paramView = null;
      }
    }
    return paramView;
  }
  
  private void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("parameter", null);
    com.bluefay.b.h.a("parameter=" + paramBundle, new Object[0]);
    if (paramBundle != null)
    {
      paramBundle = new Intent("android.intent.action.VIEW", Uri.parse("wkb://" + paramBundle));
      paramBundle.setPackage(this.e.getPackageName());
      e.a(getActivity(), paramBundle);
    }
  }
  
  private void a(WkAccessPoint paramWkAccessPoint, int paramInt)
  {
    if (paramWkAccessPoint != null)
    {
      if (paramInt != 3) {
        break label55;
      }
      paramWkAccessPoint = paramWkAccessPoint.a();
      if (com.lantern.core.g.u.c(paramWkAccessPoint)) {
        break label36;
      }
      com.bluefay.b.h.a("ssid is invalid,ssid:[%s]", new Object[] { paramWkAccessPoint });
    }
    for (;;)
    {
      return;
      label36:
      this.l.a(5, new Object[] { paramWkAccessPoint });
      continue;
      label55:
      if (paramInt == 1) {
        a(paramWkAccessPoint.a(), paramWkAccessPoint.c);
      } else {
        c();
      }
    }
  }


  private void a(AccessPoint paramAccessPoint, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    WkAccessPoint localWkAccessPoint = new WkAccessPoint(paramAccessPoint);
    boolean bool = paramAccessPoint.h();
    String str1 = paramAccessPoint.d();
    WifiConfiguration localWifiConfiguration = com.lantern.core.g.u.a(this.e, paramAccessPoint.a, paramAccessPoint.c);
    this.K = false;
    if (localWifiConfiguration != null)
    {
      this.L = a(localWifiConfiguration);
      if ((this.L) || (Build.VERSION.SDK_INT < 23)) {
        break label279;
      }
      this.K = true;
      if (paramInt == 2)
      {
        com.lantern.analytics.a.e().onEvent("cannotupconfig");
        if (bool)
        {
          if (com.bluefay.a.a.c(this.e))
          {
            new v(this.e).a(bool, localWkAccessPoint, paramAccessPoint.d(), this.K, this.ab);
            this.z = true;
            this.A = true;
          }
          for (;;)
          {
            return;
            this.ab.a(0, "share", Boolean.valueOf(false));
          }
        }
        paramAccessPoint.d("");
      }
    }
    for (;;)
    {
      if (this.B) {
        d();
      }
      this.S.removeMessages(128101);
      this.k.smoothScrollToPosition(0);
      this.p.a(false);
      this.p.a(paramAccessPoint);
      this.B = true;
      String str2 = paramAccessPoint.d();
      this.x.a(localWkAccessPoint, str2, new o(this, paramBoolean6, localWkAccessPoint, paramInt, paramBoolean1, paramBoolean2, str2, bool, localWifiConfiguration, paramAccessPoint, str1, paramBoolean3, paramBoolean4, paramBoolean5), 15000L);
      break;
      label279:
      if (paramInt == 2) {
        com.lantern.analytics.a.e().onEvent("canupconfig");
      }
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!com.lantern.core.g.u.c(paramString)) {
      com.bluefay.b.h.a("ssid is invalid,ssid:[%s]", new Object[] { paramString });
    }
    for (;;)
    {
      return;
      AccessPointAlias localAccessPointAlias = com.wifi.connect.a.a.a().a(paramString, paramInt);
      String str = paramString;
      if (localAccessPointAlias != null)
      {
        str = paramString;
        if (!TextUtils.isEmpty(localAccessPointAlias.e)) {
          str = "【" + localAccessPointAlias.e + "】";
        }
      }
      this.l.a(6, new Object[] { str });
      if (this.p != null)
      {
        paramString = this.p.b();
        if ((paramString != null) && (com.wifi.connect.a.a.a().c(paramString.a, paramString.c)))
        {
          paramString = com.wifi.connect.a.a.a().c(paramString);
          if ((!TextUtils.isEmpty(paramString.trim())) && (!"0".equals(paramString.trim()))) {
            this.l.a(paramString.trim());
          } else {
            this.l.c();
          }
        }
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.j.getVisibility() == 0)
    {
      com.bluefay.b.h.c("wifi is loading");
      com.lantern.analytics.a.e().onEvent("qrycli_1");
    }
    for (;;)
    {
      return;
      if (this.i.getVisibility() == 0)
      {
        com.bluefay.b.h.c("wifi disabled");
        com.lantern.analytics.a.e().onEvent("qrycli_2");
      }
      else if (paramBoolean)
      {
        com.bluefay.b.h.a("do oneKeyQuery authto ", new Object[0]);
        new com.wifi.connect.b.d(this.e).a(new h(this), paramBoolean);
      }
      else if (this.G.compareAndSet(false, true))
      {
        com.bluefay.b.h.a("do oneKeyQuery" + paramBoolean, new Object[0]);
        this.l.d();
        com.lantern.analytics.a.e().onEvent("qrycli");
        c(true);
        new com.wifi.connect.b.d(this.e).a(new i(this), false);
      }
    }
  }
  
  private boolean a(WifiConfiguration paramWifiConfiguration)
  {
    bool2 = false;
    bool1 = bool2;
    if (Build.VERSION.SDK_INT >= 21) {}
    try
    {
      paramWifiConfiguration = e.a(paramWifiConfiguration, "creatorUid");
      if (paramWifiConfiguration == null) {
        break label75;
      }
      int i1 = ((Integer)paramWifiConfiguration).intValue();
      com.lantern.core.c.getServer();
      int i2 = com.lantern.core.o.a(this.e);
      if ((i2 == -1) || (i2 != i1)) {
        break label75;
      }
      bool1 = true;
    }
    catch (Exception paramWifiConfiguration)
    {
      for (;;)
      {
        com.bluefay.b.h.a(paramWifiConfiguration);
        bool1 = bool2;
        continue;
        bool1 = false;
      }
    }
    return bool1;
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (System.currentTimeMillis() - this.g >= 1000L) {}
    }
    for (;;)
    {
      return;
      this.g = System.currentTimeMillis();
      WkLocationManager.getInstance(com.lantern.core.c.getAppContext()).startLocation(new ab(this));
      if (f.i())
      {
        WkLocationManager.getInstance(com.lantern.core.c.getAppContext()).startLocation(new ad(this), LocationType.Tiger);
        continue;
        this.l.a("");
      }
    }
  }
  
  private void c()
  {
    int i1 = this.p.getCount();
    if (i1 > 0) {
      this.l.a(2, new Object[] { Integer.valueOf(i1) });
    }
    for (;;)
    {
      return;
      this.l.a(1, new Object[0]);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.l.a(3, new Object[0]);
    }
    for (;;)
    {
      return;
      this.l.a(4, new Object[0]);
    }
  }
  
  private void d()
  {
    this.p.b(false);
    this.x.b();
    a(null, 0);
    this.B = false;
  }
  
  private void d(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1)) {
      this.l.a(0, new Object[0]);
    }
    for (;;)
    {
      return;
      if (paramInt == 2) {
        this.l.a(8, new Object[0]);
      } else if (paramInt == 3) {
        this.l.a(9, new Object[0]);
      }
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.r.b();
    }
    try
    {
      boolean bool = this.u.a(paramBoolean);
      if ((paramBoolean == true) && (!bool)) {
        e.a(R.string.tips_wifi_perm_wlan_disable);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.bluefay.b.h.a(localException);
      }
    }
  }
  
  private void e()
  {
    if ((this.q != null) && (this.q.isShowing()))
    {
      this.q.dismiss();
      this.q = null;
    }
  }
  
  private void e(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      this.t.a();
      continue;
      this.j.setVisibility(0);
      this.m.setVisibility(4);
      this.n.setVisibility(4);
      continue;
      this.p.a(null);
      this.t.b();
    }
  }
  
  private void f()
  {
    switch (this.s.getWifiState())
    {
    }
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.t.d().iterator();
      while (localIterator.hasNext())
      {
        AccessPoint localAccessPoint = (AccessPoint)localIterator.next();
        if ((localAccessPoint.e() != -1) && (!localArrayList.contains(localAccessPoint))) {
          localArrayList.add(localAccessPoint);
        }
      }
      com.bluefay.b.h.a("footview updateListView WIFI_STATE_ENABLED", new Object[0]);
      this.p.a(localArrayList);
      this.j.setVisibility(8);
      if (localArrayList.size() == 0)
      {
        this.k.removeFooterView(this.n);
        this.m.setVisibility(0);
        if (this.k.getFooterViewsCount() == 0)
        {
          com.lantern.analytics.a.e().onEvent("nolist");
          this.k.addFooterView(this.m);
        }
        if (this.H != null) {
          this.H.setVisibility(0);
        }
        this.k.setDivider(null);
      }
      else if (localArrayList.size() >= 3)
      {
        this.k.removeFooterView(this.m);
        this.n.setVisibility(0);
        if (this.k.getFooterViewsCount() == 0) {
          this.k.addFooterView(this.n);
        }
      }
      else
      {
        this.k.removeFooterView(this.m);
        this.k.removeFooterView(this.n);
      }
    }
  }
  
  private void f(int paramInt)
  {
    if (paramInt == 3) {
      this.i.a(4);
    }
    for (;;)
    {
      return;
      if (paramInt == 2) {
        this.i.a(3);
      } else if (this.r.a()) {
        this.i.a(1);
      } else {
        this.i.a(2);
      }
    }
  }
  
  private void g()
  {
    String str2 = this.e.getString(R.string.connect_actionbar_title);
    String str1 = str2 + "\n" + "WWW.WiFi.COM";
    SpannableString localSpannableString = new SpannableString(str1);
    localSpannableString.setSpan(new AbsoluteSizeSpan(10, true), str2.length() + 1, str1.length(), 17);
    a(localSpannableString);
    b().f(R.drawable.common_actionbar_logo);
  }
  
  private void h()
  {
    b().d(3);
    bluefay.app.u localu = new bluefay.app.u(this.e);
    com.lantern.core.g.k localk = com.lantern.core.g.k.a();
    if (this.s == null) {
      this.s = ((WifiManager)this.e.getSystemService("wifi"));
    }
    localu.add(101, 1001, 0, this.e.getText(R.string.action_bar_hotspot)).setIcon(R.drawable.settings_ic_m_wifi);
    localu.add(101, 1002, 0, "Map").setIcon(R.drawable.connect_compact_menu_map);
    Object localObject = localu.add(101, 1003, 0, "More");
    int i1;
    if (localk.d(k.b.d))
    {
      ((MenuItem)localObject).setIcon(R.drawable.common_icon_title_more_reddot);
      boolean bool = this.s.isWifiEnabled();
      localObject = this.e;
      if (!bool) {
        break label334;
      }
      i1 = R.string.connect_close_wifi;
      label166:
      localObject = localu.add(101, 1005, 0, ((Context)localObject).getText(i1));
      if (!bool) {
        break label341;
      }
      ((MenuItem)localObject).setIcon(R.drawable.connect_switch_turn_on);
      label199:
      bool = "freemeos".equals(com.lantern.core.p.d("-1"));
      localObject = (AppStoreConf)com.lantern.core.config.d.a(this.e).a(AppStoreConf.class);
      if ((!bool) && (f.g()) && (((AppStoreConf)localObject).d()))
      {
        String str = ((AppStoreConf)localObject).g();
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.e.getText(R.string.action_bar_appstore);
        }
        localObject = localu.add(101, 1006, 0, (CharSequence)localObject);
        if (!localk.d(k.b.q)) {
          break label354;
        }
        ((MenuItem)localObject).setIcon(R.drawable.connect_compact_menu_appstore_reddot);
      }
    }
    for (;;)
    {
      a(a, localu);
      return;
      ((MenuItem)localObject).setIcon(R.drawable.common_icon_title_more);
      break;
      label334:
      i1 = R.string.connect_open_wifi;
      break label166;
      label341:
      ((MenuItem)localObject).setIcon(R.drawable.connect_switch_turn_off);
      break label199;
      label354:
      ((MenuItem)localObject).setIcon(R.drawable.connect_compact_menu_appstore);
    }
  }
  
  public final void a(Context paramContext)
  {
    this.E = true;
    g();
    RedDotConf localRedDotConf = (RedDotConf)com.lantern.core.config.d.a(this.e).a(RedDotConf.class);
    paramContext = (AppStoreConf)com.lantern.core.config.d.a(this.e).a(AppStoreConf.class);
    int i1;
    if ((localRedDotConf.d()) && (f.g()) && (paramContext.d()))
    {
      i1 = 1;
      if (i1 != 0)
      {
        this.J = true;
        com.lantern.core.g.k.a().b(this.ag);
      }
      if (i1 == 0) {
        break label210;
      }
      long l1 = com.lantern.core.p.a(this.e, "sdk_common", "last_appbox_reddot_show_time", 0L);
      paramContext = Calendar.getInstance();
      paramContext.setTimeInMillis(l1);
      if (paramContext.get(5) == Calendar.getInstance().get(5)) {
        break label205;
      }
      i1 = 1;
      label131:
      if (i1 != 0)
      {
        com.lantern.core.g.k.a().a(k.b.q);
        com.lantern.core.p.b(this.e, "sdk_common", "last_appbox_reddot_show_time", System.currentTimeMillis());
      }
    }
    for (;;)
    {
      h();
      com.lantern.analytics.a.e().onEvent("conin");
      if (this.w != null) {
        this.w.b();
      }
      if (this.k != null) {
        f();
      }
      return;
      i1 = 0;
      break;
      label205:
      i1 = 0;
      break label131;
      label210:
      com.lantern.core.g.k.a().c(k.b.q);
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    String str = paramString;
    if (!com.lantern.core.g.u.c(paramString)) {
      if ((paramString == null) || (paramString.length() <= 0)) {}
    }
    for (;;)
    {
      return;
      paramString = this.s.getConnectionInfo();
      com.bluefay.b.h.a("info:" + paramString);
      if ((paramString != null) && (paramString.getSSID() != null))
      {
        str = com.lantern.core.g.u.a(paramString.getSSID());
        if ((str != null) && (str.length() != 0))
        {
          int i2 = 0;
          paramString = this.s.getConnectionInfo();
          int i1 = i2;
          if (paramString != null)
          {
            int i3 = paramString.getNetworkId();
            i1 = i2;
            if (i3 != -1)
            {
              paramString = com.lantern.core.g.u.a(this.e, i3);
              i1 = i2;
              if (paramString != null) {
                i1 = com.lantern.core.g.u.a(paramString);
              }
            }
          }
          paramString = this.S.obtainMessage(128101, 1, i1, str);
          if (paramBoolean)
          {
            if (this.S.hasMessages(128101)) {
              this.S.removeMessages(128101);
            }
            this.S.sendMessageDelayed(paramString, 1000L);
          }
          else
          {
            this.S.sendMessage(paramString);
          }
        }
      }
    }
  }
  
  public final void b(Context paramContext)
  {
    this.E = false;
    g();
    e();
    com.lantern.analytics.a.e().onEvent("conout");
    if (this.J)
    {
      this.J = false;
      com.lantern.core.g.k.a().a(this.ag);
    }
    if (this.w != null) {
      this.w.c();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.bluefay.b.h.b("requestCode:%d resultCode:%d data:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    if ((paramInt1 != 5) || (paramInt2 != -1) || (paramIntent == null)) {}
    for (;;)
    {
      return;
      if (paramIntent.getBooleanExtra("doQuery", false)) {
        a(false);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.v = new l(this.e);
    if (this.s == null) {
      this.s = ((WifiManager)this.e.getSystemService("wifi"));
    }
    if (this.x == null) {
      this.x = new com.lantern.core.g.r(this.e);
    }
    this.r = new ag(this.s);
    this.t = new com.wifi.connect.b.aj(this.e, this.Y);
    this.u = new com.wifi.connect.b.ah(this.e, this.Z);
    this.u.a();
    com.lantern.core.c.addListener(this.S);
    paramBundle = getArguments();
    if ((paramBundle != null) && (paramBundle.containsKey("tab"))) {
      this.Q = true;
    }
    for (;;)
    {
      return;
      if ((paramBundle != null) && (paramBundle.containsKey("path"))) {
        a(paramBundle);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.connect_main_new, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    this.u.b();
    com.lantern.core.c.removeListener(this.S);
    if (com.lantern.core.c.getShareValue().e()) {
      com.bluefay.a.a.a(this.e, false);
    }
    if ((this.I != null) && (this.I.getBitmap() != null))
    {
      this.I.getBitmap().recycle();
      this.I = null;
    }
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = true;
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      boolean bool1 = super.onOptionsItemSelected(paramMenuItem);
      int i1;
      do
      {
        do
        {
          for (;;)
          {
            return bool1;
            paramMenuItem = new Intent("wifi.intent.action.HOTSPOT_MAIN");
            paramMenuItem.setPackage(this.e.getPackageName());
            startActivity(paramMenuItem);
            com.lantern.analytics.a.e().onEvent("cph");
            bool1 = bool2;
            continue;
            if (this.R == null) {
              this.R = new com.wifi.a.a.a(this.e);
            }
            this.R.a();
            com.lantern.analytics.a.e().onEvent("map_clickdl");
            bool1 = bool2;
            continue;
            paramMenuItem = new Intent("wifi.intent.action.APPSTORE_MAIN");
            paramMenuItem.setPackage(this.e.getPackageName());
            e.a(this.e, paramMenuItem);
            com.lantern.analytics.a.e().onEvent("bbxin_c");
            com.lantern.core.g.k.a().b(k.b.q);
            bool1 = bool2;
            continue;
            localObject = (PresentBoxConf)com.lantern.core.config.d.a(this.e).a(PresentBoxConf.class);
            com.lantern.core.g.k.a().b(k.b.s);
            ((PresentBoxConf)localObject).f();
            if ((!((PresentBoxConf)localObject).d()) || (TextUtils.isEmpty(((PresentBoxConf)localObject).e())))
            {
              com.bluefay.b.h.a("invalid data for present box", new Object[0]);
              bool1 = bool2;
            }
            else
            {
              paramMenuItem = new Intent("wifi.intent.action.BROWSER");
              paramMenuItem.setData(Uri.parse(((PresentBoxConf)localObject).e()));
              paramMenuItem.addFlags(268435456);
              paramMenuItem.setPackage(this.e.getPackageName());
              localObject = new Bundle();
              ((Bundle)localObject).putBoolean("allowbannerad", false);
              paramMenuItem.putExtras((Bundle)localObject);
              e.a(this.e, paramMenuItem);
              bool1 = bool2;
            }
          }
          i1 = this.s.getWifiState();
          bool1 = bool2;
        } while (i1 == 0);
        bool1 = bool2;
      } while (i1 == 2);
      if (i1 == 1)
      {
        f(2);
        e(2);
        d(2);
      }
      bool1 = this.s.isWifiEnabled();
      if (bool1)
      {
        com.lantern.analytics.a.e().onEvent("wlanoff_new");
        label420:
        if (bool1) {
          break label449;
        }
      }
      label449:
      for (bool1 = true;; bool1 = false)
      {
        d(bool1);
        bool1 = bool2;
        break;
        com.lantern.analytics.a.e().onEvent("wlanon_new");
        break label420;
      }
      Object localObject = (RecommendLinkConf)com.lantern.core.config.d.a(this.e).a(RecommendLinkConf.class);
      Intent localIntent = new Intent("wifi.intent.action.BROWSER");
      localIntent.setPackage(this.e.getPackageName());
      localIntent.setData(Uri.parse(((RecommendLinkConf)localObject).d()));
      e.a(this.e, localIntent);
      com.lantern.core.g.k.a().b(k.b.r);
    }
  }
  
  public void onPause()
  {
    this.t.b();
    super.onPause();
    if (this.w != null) {
      this.w.c();
    }
    this.F = false;
  }
  
  public void onResume()
  {
    this.t.a();
    super.onResume();
    this.F = true;
    if (this.w != null) {
      this.w.b();
    }
    if (this.r.a()) {
      this.i.a(1);
    }
    for (;;)
    {
      if ((this.o.getVisibility() == 0) && (com.bluefay.a.a.a(this.e))) {
        j.a().a(this.af);
      }
      return;
      if (!this.s.isWifiEnabled()) {
        this.i.a(2);
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.h = ((SwipeRefreshLayout)paramView.findViewById(R.id.wifi_list_fragment));
    this.i = ((WifiDisabledView)paramView.findViewById(R.id.wifi_disabled_fragment));
    this.i.a(new x(this));
    this.j = ((ViewGroup)paramView.findViewById(R.id.frag_wifilist_prgbar_ap_scan));
    this.k = ((ListView)this.h.findViewById(R.id.list));
    this.h.a(this.X);
    this.l = new WifiListHeaderView(getActivity());
    this.l.a(this.T);
    this.m = new WifiListFooterView(getActivity());
    this.m.a(this.U);
    this.n = new WifiListLinksureFooterView(getActivity());
    this.k.addHeaderView(this.l);
    this.p = new a(getActivity());
    this.k.setAdapter(this.p);
    this.k.setOnScrollListener(this.W);
    this.k.setOnItemClickListener(this.V);
    this.o = ((TextView)paramView.findViewById(R.id.web_auth));
    this.o.setOnClickListener(new y(this));
    this.w = new com.wifi.connect.e.c(this.e, paramView.findViewById(R.id.frag_wifilist_ad_box));
    this.w.a(this.i);
    paramView = this.e.getSharedPreferences("WkUserSettings", 0);
    int i1;
    if (paramView != null)
    {
      i1 = paramView.getInt("setting_pref_beginner_guide_step", 0);
      this.y = i1;
      f(this.s.getWifiState());
      f();
      if (!com.bluefay.a.a.a(this.e)) {
        break label565;
      }
      paramView = this.s.getConnectionInfo();
      if (paramView == null) {
        break label558;
      }
      a(com.lantern.core.g.u.a(paramView.getSSID()), false);
      label360:
      if ((this.s.getWifiState() == 3) && (com.bluefay.a.a.a(this.e)))
      {
        paramView = this.s.getConnectionInfo();
        if ((paramView != null) && (com.lantern.core.g.u.c(com.lantern.core.g.u.a(paramView.getSSID())))) {
          break label572;
        }
      }
      label406:
      paramView = getArguments();
      if (paramView != null)
      {
        paramView = (WkAccessPoint)paramView.getParcelable("extra_jump_connect_ap");
        if (paramView != null) {
          com.lantern.core.h.a(paramView);
        }
      }
      if ((com.lantern.core.p.b(this.e, "sdk_device", "connectupgrade", false)) && (com.lantern.core.p.b(this.e, "sdk_device", "connectshowhostguide", true)))
      {
        this.Q = false;
        paramView = new Intent(this.e, ShowHostGuideActivity.class);
        paramView.setPackage(this.e.getPackageName());
        e.a(this.e, paramView);
        com.lantern.core.p.k(this.e);
      }
      paramView = com.lantern.core.config.d.a(com.lantern.core.c.getAppContext()).a("aquery");
      if (paramView == null) {
        break label608;
      }
    }
    label558:
    label565:
    label572:
    label608:
    for (boolean bool = paramView.optBoolean("isquery");; bool = true)
    {
      if (bool) {
        a(bool);
      }
      return;
      i1 = 0;
      break;
      c();
      break label360;
      c();
      break label360;
      paramView = com.lantern.core.g.u.a(paramView.getSSID());
      com.lantern.core.c.getShareValue().a(paramView);
      com.lantern.core.h.a(paramView);
      j.a().a(new p(this));
      break label406;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/ConnectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */