package com.wifipay.wallet.home.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.authentication.activity.AuthenticationActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.f;
import com.wifipay.wallet.prod.deposit.QueryRemindResp;
import com.wifipay.wallet.prod.deposit.QueryRemindResp.ResultObject;
import com.wifipay.wallet.prod.security.query.QueryCategoryResp;
import com.wifipay.wallet.prod.security.query.QueryCategoryResp.ResultObject;
import com.wifipay.wallet.prod.security.query.QueryService;
import java.util.HashMap;

public class AccountWebActivity
  extends BaseActivity
{
  private WebView h;
  private ProgressBar i;
  private boolean j = false;
  
  static
  {
    StubApp1053578832.interface11(123);
  }
  
  private void i()
  {
    Object localObject1 = getIntent().getStringExtra("webViewName");
    Object localObject2 = new a(this);
    this.h.setWebViewClient((WebViewClient)localObject2);
    localObject2 = new b(this);
    this.h.setDownloadListener((DownloadListener)localObject2);
    this.h.setWebChromeClient(new WebChromeClient());
    this.h.loadUrl((String)localObject1);
    localObject1 = this.h.getSettings();
    ((WebSettings)localObject1).setJavaScriptEnabled(true);
    ((WebSettings)localObject1).setBuiltInZoomControls(false);
    ((WebSettings)localObject1).setSupportZoom(false);
    ((WebSettings)localObject1).setUseWideViewPort(true);
    ((WebSettings)localObject1).setLoadWithOverviewMode(true);
    ((WebSettings)localObject1).setJavaScriptCanOpenWindowsAutomatically(true);
    ((WebSettings)localObject1).setLoadsImagesAutomatically(true);
    if (Build.VERSION.SDK_INT >= 17) {
      this.h.addJavascriptInterface(new com.wifipay.wallet.home.net.dto.a(), "SPJSBridge");
    }
    for (;;)
    {
      return;
      try
      {
        this.h.removeJavascriptInterface("searchBoxJavaBridge_");
        this.h.removeJavascriptInterface("accessibility");
        this.h.removeJavascriptInterface("accessibilityTraversal");
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  private void j()
  {
    c("");
    ((QueryService)RpcService.getBgRpcProxy(QueryService.class)).queryCategory(String.valueOf(System.currentTimeMillis()));
  }
  
  private void k()
  {
    String str2 = com.wifipay.wallet.common.info.b.a().f();
    String str1 = str2;
    if (f.a(str2)) {
      str1 = str2.substring(0, str2.indexOf("@"));
    }
    runOnUiThread(new c(this, str1));
  }
  
  private void l()
  {
    c("");
    ((QueryService)RpcService.getBgRpcProxy(QueryService.class)).queryCheckRemind("INDEX", "");
  }
  
  @Subscribe
  public void handleCer(com.wifipay.wallet.a.a parama)
  {
    if ("certification".equals(parama.a)) {
      l();
    }
    for (;;)
    {
      EventBus.getDefault().removeStickyEvent(parama);
      return;
      if ("add_card".equals(parama.a))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("bindcardsource", CashierType.UPLOADIDCARD.getType());
        new com.wifipay.wallet.card.a.a(this).a(localHashMap);
      }
      else if (!"authentication_phone".equals(parama.a))
      {
        "user_info".equals(parama.a);
      }
    }
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleCheckRemind(QueryRemindResp paramQueryRemindResp)
  {
    d();
    Intent localIntent;
    if ((f.a(paramQueryRemindResp)) && (ResponseCode.SUCCESS.getCode().equals(paramQueryRemindResp.resultCode)))
    {
      localIntent = new Intent(this, AuthenticationActivity.class);
      if (!"1".equals(paramQueryRemindResp.resultObject.identityStatus))
      {
        localIntent.putExtra("which_fragment", R.id.wifipay_fragment_upload_card);
        localIntent.putExtra("extra_param", paramQueryRemindResp);
        startActivity(localIntent);
      }
    }
    for (;;)
    {
      return;
      localIntent.putExtra("which_fragment", R.id.wifipay_fragment_not_real_name);
      localIntent.putExtra("cashier_type", CashierType.UPLOADIDCARD.getType());
      break;
      b(paramQueryRemindResp.resultMessage);
    }
  }
  
  @Subscribe
  public void handleEvent(com.wifipay.wallet.a.b paramb)
  {
    if (paramb.a.equals(CashierType.UPLOADIDCARD.getType())) {
      j();
    }
  }
  
  @Subscribe
  public void handleQuery(QueryCategoryResp paramQueryCategoryResp)
  {
    d();
    if ((f.a(paramQueryCategoryResp)) && (ResponseCode.SUCCESS.getCode().equals(paramQueryCategoryResp.resultCode)))
    {
      String str2 = paramQueryCategoryResp.resultObject.category;
      String str1 = paramQueryCategoryResp.resultObject.outFlow;
      paramQueryCategoryResp = str1;
      if (g.a(str1)) {
        paramQueryCategoryResp = "0";
      }
      runOnUiThread(new d(this, str2, paramQueryCategoryResp));
      k();
    }
    for (;;)
    {
      return;
      b(paramQueryCategoryResp.resultMessage);
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.h.destroy();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/AccountWebActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */