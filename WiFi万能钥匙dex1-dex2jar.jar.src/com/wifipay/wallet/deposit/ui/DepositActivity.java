package com.wifipay.wallet.deposit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.common.logging.Logger;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.openapi.a;

public class DepositActivity
  extends BaseActivity
{
  static
  {
    StubApp1053578832.interface11(115);
  }
  
  public void i()
  {
    if (!b.a().n()) {}
    try
    {
      a.a(this, 3, 1, "null");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Logger.v("zhao == %s", new Object[] { "ActivityrequestCode" + paramInt1 });
    Logger.v("zhao == %s", new Object[] { "ActivityresultCode" + paramInt2 });
    if (paramInt1 == 1) {
      this.a.findFragmentByTag(String.valueOf(R.id.wifipay_fragment_deposit)).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/deposit/ui/DepositActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */