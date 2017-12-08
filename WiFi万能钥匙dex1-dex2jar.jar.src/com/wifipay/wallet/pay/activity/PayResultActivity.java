package com.wifipay.wallet.pay.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.string;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.pay.SyncResp;
import com.wifipay.wallet.pay.fragment.PayDetailsResultFragment;

public class PayResultActivity
  extends BaseActivity
{
  static
  {
    StubApp1053578832.interface11(126);
  }
  
  public boolean a()
  {
    finish();
    return super.a();
  }
  
  public void finish()
  {
    super.finish();
    SyncResp.b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(getResources().getString(R.string.wifipay_pay_title));
    c();
    a(getIntent().getIntExtra("which_fragment", R.id.wifipay_fragment_default), PayDetailsResultFragment.class, getIntent().getExtras());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/pay/activity/PayResultActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */