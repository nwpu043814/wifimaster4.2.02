package com.wifipay.wallet.bank.activity;

import android.os.Bundle;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.bank.presenter.a;
import com.wifipay.wallet.prod.security.query.QueryHpsCardResp;

public class BankManageActivity
  extends BaseActivity
{
  private a h;
  
  static
  {
    StubApp1053578832.interface11(105);
  }
  
  @Subscribe
  public void handleQueryHpsCard(QueryHpsCardResp paramQueryHpsCardResp)
  {
    d();
    this.h.setAdapter(paramQueryHpsCardResp);
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onStart()
  {
    super.onStart();
    try
    {
      c("");
      this.h.onStart();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d();
        this.h.setAdapter(null);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/bank/activity/BankManageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */