package com.lantern.launcher;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import com.lantern.core.c;
import com.lantern.core.config.ABTestConf;
import com.lantern.core.config.AppListSaveConf;
import com.lantern.core.config.AppStoreConf;
import com.lantern.core.config.AuthConfig;
import com.lantern.core.config.CheckHtmlConf;
import com.lantern.core.config.CommonConf;
import com.lantern.core.config.ConnectDlgBgConf;
import com.lantern.core.config.Crty5Conf;
import com.lantern.core.config.DomainBlackListConf;
import com.lantern.core.config.DomainZenmenConf;
import com.lantern.core.config.DownloadBlackListConf;
import com.lantern.core.config.FeedNativeConf;
import com.lantern.core.config.HQConf;
import com.lantern.core.config.LinkedForwardConf;
import com.lantern.core.config.LocationWhiteListConf;
import com.lantern.core.config.Nbaps_Conf;
import com.lantern.core.config.PresentBoxConf;
import com.lantern.core.config.PushConf;
import com.lantern.core.config.RecommendLinkConf;
import com.lantern.core.config.RedDotConf;
import com.lantern.core.config.SSLErrorConfig;
import com.lantern.core.config.SchemeWhiteListConf;
import com.lantern.core.config.ShareApNewConf;
import com.lantern.core.config.ShopEntranceConf;
import com.lantern.core.config.SmsDomainWhiteListConf;
import com.lantern.core.config.SsrpConfig;
import com.lantern.core.config.StandbyIPConf;
import com.lantern.core.config.TrafficMonitorConfig;
import com.lantern.core.config.WalletConf;
import com.lantern.core.config.WifiExamConf;
import com.lantern.core.config.d;
import com.lantern.core.o;
import com.lantern.core.p;
import com.lantern.launcher.task.XunfeiCorpConf;
import com.wifi.connect.b.al;

public class WifiApp
  extends c
{
  private al mApNoticeManager;
  private com.lantern.core.g.b mAppInstallMonitor;
  private a mManager;
  private com.lantern.core.h mMessager;
  private String mPackageName;
  
  private void initializeAppConfig()
  {
    d locald = d.a(c.getAppContext());
    locald.a("domain_bl", DomainBlackListConf.class);
    locald.a("domain_zm", DomainZenmenConf.class);
    locald.a("lf", LinkedForwardConf.class);
    locald.a("standby_ip", StandbyIPConf.class);
    locald.a("monapp", TrafficMonitorConfig.class);
    locald.a("sms_dwl", SmsDomainWhiteListConf.class);
    locald.a("location_wl", LocationWhiteListConf.class);
    locald.a("check_net", CheckHtmlConf.class);
    locald.a("push", PushConf.class);
    locald.a("pb", PresentBoxConf.class);
    locald.a("rdcf", RedDotConf.class);
    locald.a("hq", HQConf.class);
    locald.a("feed_native", FeedNativeConf.class);
    locald.a("scheme_wl", SchemeWhiteListConf.class);
    locald.a("recommend_link", RecommendLinkConf.class);
    locald.a("pkgsav", AppListSaveConf.class);
    locald.a("download_bl", DownloadBlackListConf.class);
    locald.a("sbbx_ssb", AppStoreConf.class);
    locald.a("wifiexam", WifiExamConf.class);
    locald.a("nbaps_num", Nbaps_Conf.class);
    locald.a("dg_bg", ConnectDlgBgConf.class);
    locald.b("claimap");
    locald.a("ssc", ShareApNewConf.class);
    locald.a("abtest", ABTestConf.class);
    locald.a("ssrp", SsrpConfig.class);
    locald.a("common_conf", CommonConf.class);
    locald.b("aquery");
    locald.a("ssl_err", SSLErrorConfig.class);
    locald.a("crty5", Crty5Conf.class);
    locald.a("shop_entr", ShopEntranceConf.class);
    locald.a("auth_conf", AuthConfig.class);
    locald.a("wallet_conf", WalletConf.class);
    locald.b("nearbyappop");
    locald.b("netmonitor");
    locald = d.a(getApplication());
    locald.a("xunfei_bind", XunfeiCorpConf.class);
    locald.a();
  }
  
  private void registerPushMsgReceiver()
  {
    try
    {
      com.lantern.launcher.receiver.a locala = new com/lantern/launcher/receiver/a;
      locala.<init>();
      IntentFilter localIntentFilter = new android/content/IntentFilter;
      localIntentFilter.<init>("com.lantern.wifilocating.push.action.TRANSFER");
      registerReceiver(locala, localIntentFilter);
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
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mManager != null) {
      this.mManager.b();
    }
  }
  
  public void onCreate()
  {
    this.mCustomTag = "WifiApp";
    super.onCreate();
    this.mPackageName = getAppContext().getPackageName();
    com.bluefay.b.h.a("process:" + this.mProcessName);
    com.lantern.analytics.a.a(this);
    com.lantern.auth.a.a(this);
    if (this.mPackageName.equals(this.mProcessName))
    {
      initializeAppConfig();
      com.lantern.analytics.a.e().onEvent("appact");
      c.getServer().a();
      this.mManager = new a(getApplicationContext());
      this.mManager.a();
      if (!p.i(mInstance)) {
        com.lantern.notifaction.a.a(mInstance).d();
      }
      this.mMessager = new com.lantern.core.h(getApplicationContext());
      registerPushMsgReceiver();
      b.a(mInstance);
      this.mAppInstallMonitor = com.lantern.core.g.b.a(mInstance);
      this.mApNoticeManager = new al(mInstance);
      com.lantern.bindapp.a.a();
      if (Build.VERSION.SDK_INT > 13)
      {
        HQConf localHQConf = (HQConf)d.a(getApplication()).a(HQConf.class);
        if ((localHQConf != null) && (localHQConf.d()))
        {
          com.lantern.analytics.a.e().onEvent("cap03");
          new com.lantern.core.f.a().execute(new Void[0]);
        }
      }
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (this.mManager != null) {
      this.mManager.c();
    }
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    if (this.mManager != null) {
      this.mManager.d();
    }
    if (this.mAppInstallMonitor != null) {
      this.mAppInstallMonitor.b();
    }
    if (this.mMessager != null) {
      this.mMessager.a();
    }
    if (this.mApNoticeManager != null) {
      this.mApNoticeManager.a();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/WifiApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */