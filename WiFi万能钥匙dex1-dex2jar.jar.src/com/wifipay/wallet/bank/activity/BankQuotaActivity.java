package com.wifipay.wallet.bank.activity;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.logging.Logger;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.bank.BankStatusColor;
import com.wifipay.wallet.card.ui.UnBindCardActivity;

public class BankQuotaActivity
  extends BaseActivity
{
  private WebView h;
  private String i;
  private String j;
  private String k;
  private String l;
  
  static
  {
    StubApp1053578832.interface11(106);
  }
  
  private void i()
  {
    this.i = getIntent().getStringExtra("agreement_id");
    this.j = getIntent().getStringExtra("card_no");
    this.k = getIntent().getStringExtra("card_unbind_h5");
  }
  
  private void j()
  {
    a(8);
    k();
    l();
    Logger.i("url == %s", new Object[] { "https://bankcardlimit.shengpay.com/index.html" + this.k });
    this.h.loadUrl("https://bankcardlimit.shengpay.com/index.html" + this.k);
  }
  
  private void k()
  {
    this.l = getIntent().getStringExtra("card_code");
    try
    {
      BankStatusColor localBankStatusColor = BankStatusColor.valueOf(this.l.toUpperCase());
      if (localBankStatusColor != null) {
        a(true, localBankStatusColor.getType());
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  private void l()
  {
    this.h.setWebChromeClient(new WebChromeClient());
    this.h.setWebViewClient(new a(this));
    WebSettings localWebSettings = this.h.getSettings();
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setBuiltInZoomControls(false);
    localWebSettings.setSupportZoom(false);
    localWebSettings.setUseWideViewPort(true);
    localWebSettings.setLoadWithOverviewMode(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    localWebSettings.setLoadsImagesAutomatically(true);
    if (Build.VERSION.SDK_INT >= 14) {
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
  
  private void m()
  {
    Intent localIntent = new Intent(this, UnBindCardActivity.class);
    localIntent.putExtra("agreement_id", this.i);
    localIntent.putExtra("card_no", this.j);
    startActivityForResult(localIntent, 4097);
  }
  
  @Subscribe
  public void handlerUnbind(com.wifipay.wallet.a.a parama)
  {
    Logger.i("handlerUnbind == %s", new Object[] { "click handlerUnbind " + parama.a });
    if ("unbind_card".equals(parama.a)) {
      m();
    }
    for (;;)
    {
      EventBus.getDefault().removeStickyEvent(parama);
      return;
      if ("unbind_close".equals(parama.a)) {
        finish();
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Logger.i("requestCode == %s", new Object[] { String.valueOf(paramInt1) });
    Logger.i("resultCode == %s", new Object[] { String.valueOf(paramInt2) });
    if (paramInt1 == paramInt2) {
      finish();
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/bank/activity/BankQuotaActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */