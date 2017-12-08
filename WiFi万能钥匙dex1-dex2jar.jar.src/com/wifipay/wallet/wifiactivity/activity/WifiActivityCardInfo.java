package com.wifipay.wallet.wifiactivity.activity;

import android.content.Intent;
import android.os.Bundle;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.wifiactivity.fragment.WifActivityCardNoFragment;
import com.wifipay.wallet.wifiactivity.fragment.WifiActivityCardDetailFragment;

public class WifiActivityCardInfo
  extends BaseActivity
{
  static
  {
    StubApp1053578832.interface11(138);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(8);
    a(R.id.wifipay_fragment_card_number, WifActivityCardNoFragment.class, getIntent().getExtras());
    a(R.id.wifipay_fragment_identity_check, WifiActivityCardDetailFragment.class, null);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/wifiactivity/activity/WifiActivityCardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */