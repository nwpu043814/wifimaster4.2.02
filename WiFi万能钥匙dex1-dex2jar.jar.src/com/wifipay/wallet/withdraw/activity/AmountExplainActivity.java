package com.wifipay.wallet.withdraw.activity;

import android.content.res.Resources;
import android.os.Bundle;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.wallet.BaseActivity;

public class AmountExplainActivity
  extends BaseActivity
{
  static
  {
    StubApp1053578832.interface11(142);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(getResources().getString(R.string.wifipay_withdraw_declare_amount));
    setContentView(R.layout.wifipay_activity_amount_explain);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/withdraw/activity/AmountExplainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */