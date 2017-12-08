package com.lantern.settings.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.app.k.a;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.core.o;
import com.lantern.core.p;
import com.lantern.core.q;
import com.lantern.settings.R.drawable;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.diagnose.a;
import com.lantern.settings.diagnose.d;
import com.lantern.settings.ui.developer.DeveloperActivity;
import com.qihoo.util.StubApp1053578832;
import java.text.SimpleDateFormat;
import java.util.List;

public class DiagnoseActivity
  extends Activity
{
  private static long d = 0L;
  private static int f = -1;
  private final long a = 7200000L;
  private final String b = "http://wifi01.51y5.net/wifi/clientdebug.php?l=";
  private final String c = "http://wifi01.51y5.net/wifi/clientdebug.php";
  private Handler e = new Handler();
  private f g = null;
  private WebView h;
  private ProgressBar i;
  
  static
  {
    StubApp1053578832.interface11(48);
  }
  
  private static String b(long paramLong)
  {
    Object localObject1 = "00:00:00";
    try
    {
      Object localObject2 = new java/text/SimpleDateFormat;
      ((SimpleDateFormat)localObject2).<init>("yyyy-MM-dd HH:mm:ss");
      localObject2 = ((SimpleDateFormat)localObject2).format(Long.valueOf(1000L * paramLong));
      localObject1 = localObject2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return (String)localObject1;
  }
  
  public void BtnGetAppList(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btn302html(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnApOwnerTest(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnBack(View paramView)
  {
    finish();
  }
  
  public void btnBeWebView(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnBindUHid(View paramView)
  {
    paramView = new Intent("wifi.intent.action.ADD_ACCOUNT_MAIN");
    paramView.setPackage(getPackageName());
    startActivity(paramView);
  }
  
  public void btnChinaNetLog(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnClearUHID(View paramView)
  {
    com.lantern.core.c.getServer().b("");
    com.lantern.core.c.getServer().p();
    p.b("sdk_device", "sessionid", "");
  }
  
  public void btnCmccLog(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnConnInfo(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnDebugOn(View paramView)
  {
    if ((a.a()) || (com.lantern.core.c.getShareValue().c()))
    {
      a.a(false);
      com.lantern.core.c.getShareValue().a(false);
      h.a("-----diagnose mode disabled-----", new Object[0]);
      h.a(2);
      h.a(1, null);
      ((TextView)paramView).setText("debug on");
      Toast.makeText(com.lantern.core.c.getAppContext(), "已关闭诊断模式", 0).show();
    }
    for (;;)
    {
      return;
      if (a.b())
      {
        a.a(true);
        com.lantern.core.c.getShareValue().a(true);
        new Handler().postDelayed(new i(this), 600000L);
        ((TextView)paramView).setText("debug off");
        Toast.makeText(com.lantern.core.c.getAppContext(), "已开启诊断模式", 0).show();
      }
      else
      {
        Toast.makeText(com.lantern.core.c.getAppContext(), "诊断模式开启失败,请检查存储卡!", 0).show();
      }
    }
  }
  
  public void btnDeepUnlock(View paramView) {}
  
  public void btnFeedUrlTest(View paramView)
  {
    Object localObject = ((EditText)findViewById(R.id.act_diagnose_feed_url)).getEditableText().toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      Toast.makeText(getBaseContext(), "请输入正确的地址", 0).show();
    }
    paramView = (View)localObject;
    if (!((String)localObject).startsWith("javascript:"))
    {
      paramView = (View)localObject;
      if (!((String)localObject).contains("://")) {
        paramView = "http://" + (String)localObject;
      }
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("wifi.intent.action.BROWSER_FEED_TEST");
    ((Intent)localObject).setPackage(getPackageName());
    ((Intent)localObject).putExtra("feed_test", paramView);
    getApplicationContext().sendBroadcast((Intent)localObject);
  }
  
  public void btnGotoSetup(View paramView) {}
  
  public void btnHitStat(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnIShanghai(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnJsInject(View paramView)
  {
    Object localObject = ((EditText)findViewById(R.id.act_diagnose_js_url)).getEditableText().toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      Toast.makeText(getBaseContext(), "请输入正确的地址", 0).show();
    }
    paramView = (View)localObject;
    if (!((String)localObject).startsWith("javascript:"))
    {
      paramView = (View)localObject;
      if (!((String)localObject).contains("://")) {
        paramView = "http://" + (String)localObject;
      }
    }
    localObject = new Intent();
    ((Intent)localObject).setAction("wifi.intent.action.BROWSER_JS_INJECT");
    ((Intent)localObject).setPackage(getPackageName());
    ((Intent)localObject).putExtra("js_inject", paramView);
    getApplicationContext().sendBroadcast((Intent)localObject);
  }
  
  public void btnKenHuang(View paramView) {}
  
  public void btnLogWinConn(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnLogWinDef(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnMD5(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnManageAccount(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnNearbyAP(View paramView) {}
  
  public void btnNewsBrowser(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnRefreshKeyWords(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnReportLogNum(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnShowChannelInfo(View paramView)
  {
    paramView = new k.a(this);
    paramView.a("渠道信息").b(com.lantern.core.k.l(getApplicationContext()) + ";\n versionCode:" + com.lantern.core.k.b(getApplicationContext()));
    paramView.a("确认", null);
    paramView.c().show();
  }
  
  public void btnShowRegisterInfo(View paramView)
  {
    paramView = new k.a(this);
    TextView localTextView = new TextView(this);
    localTextView.setTextColor(-16777216);
    localTextView.setTextSize(15.0F);
    localTextView.setBackgroundResource(R.drawable.settings_clickable_background);
    localTextView.setText("dhid:" + com.lantern.core.c.getServer().g() + "\nuhid:" + com.lantern.core.c.getServer().h());
    localTextView.setOnLongClickListener(new j(this));
    paramView.a("用户信息");
    int j = e.a(this, 20.0F);
    int k = j >> 1;
    paramView.a(localTextView, j, k, j, k);
    paramView.a("确认", null);
    paramView.c().show();
  }
  
  public void btnSwitchMap(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnSwitchServer(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnTestLoLa(View paramView)
  {
    View localView = LayoutInflater.from(this).inflate(R.layout.settings_diagnose_lalo, null);
    EditText localEditText = (EditText)localView.findViewById(R.id.settings_diagnose_lalo_la);
    paramView = (EditText)localView.findViewById(R.id.settings_diagnose_lalo_lo);
    new k.a(this).a("请输入纬度和经度").a(localView).a("确定", new l(this, localEditText, paramView)).b("取消", new k(this)).d();
  }
  
  public void btnToastErrorInBrowser(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnTrafficSpeed(View paramView)
  {
    paramView = new StringBuffer();
    try
    {
      paramView.append("BRAND: ");
      paramView.append(Build.BRAND);
      paramView.append("\n");
      paramView.append("MANUFACTURER: ");
      paramView.append(Build.MANUFACTURER);
      paramView.append("\n");
      paramView.append("FINGERPRINT: ");
      paramView.append(Build.FINGERPRINT);
      Toast.makeText(this, paramView.toString(), 1).show();
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Toast.makeText(this, "查询失败", 0).show();
      }
    }
  }
  
  public void btnTrafficState(View paramView)
  {
    paramView = (TextView)findViewById(R.id.textView1);
    List localList = d.a(this).a();
    StringBuilder localStringBuilder = new StringBuilder();
    for (int j = 0; j < localList.size(); j++)
    {
      com.lantern.settings.diagnose.c localc = (com.lantern.settings.diagnose.c)localList.get(j);
      localStringBuilder.append("应用名称" + localc.a()).append("\r\n");
      localStringBuilder.append("服务器下发开始时间" + b(localc.b())).append("\r\n");
      localStringBuilder.append("服务器下发结束时间" + b(localc.c())).append("\r\n");
      localStringBuilder.append("客户端记录时间" + b(localc.d())).append("\r\n");
      localStringBuilder.append("服务器下发流量" + localc.g()).append("\r\n");
      localStringBuilder.append("客户端接收流量" + localc.h()).append("\r\n");
      localStringBuilder.append("服务器下发次数" + localc.e()).append("\r\n");
      localStringBuilder.append("客户端显示次数" + localc.f()).append("\r\n");
      localStringBuilder.append("使用时间S" + localc.j()).append("\r\n");
      localStringBuilder.append("服务器下发间隔" + localc.i()).append("\r\n");
      paramView.setText(localStringBuilder);
    }
  }
  
  public void btnUpdateAdOneSwitch(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnUploadTopn(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnUrltest(View paramView)
  {
    startActivity(new Intent(this, UrlTestActivity.class));
  }
  
  public void btnViewDownQueue(View paramView)
  {
    paramView = new Intent("wifi.intent.action.DOWNLOADS_MAIN");
    paramView.setPackage(getPackageName());
    startActivity(paramView);
  }
  
  public void btnViewMsg(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void btnWebPageTest(View paramView)
  {
    Toast.makeText(getBaseContext(), "尚未支持该功能", 0).show();
  }
  
  public void clickNoop(View paramView) {}
  
  public void gotoDeveloperOption(View paramView)
  {
    startActivity(new Intent(this, DeveloperActivity.class));
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/DiagnoseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */