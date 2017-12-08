package com.wifipay.wallet;

import android.content.Intent;
import android.os.Bundle;
import com.wifipay.framework.app.ui.SuperActivity;

public class BaseActivity
  extends SuperActivity
{
  protected void a(Intent paramIntent)
  {
    new SecondLogin(this, paramIntent).a(null);
  }
  
  protected void h()
  {
    com.wifipay.wallet.wifilogin.a.a.a();
    com.wifipay.wallet.common.a.b = false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      com.wifipay.wallet.common.a.b = true;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.wifipay.framework.app.a.a().a(this);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */