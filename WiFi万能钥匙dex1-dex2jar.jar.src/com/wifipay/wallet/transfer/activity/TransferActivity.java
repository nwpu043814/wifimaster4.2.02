package com.wifipay.wallet.transfer.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.string;
import com.wifipay.common.logging.Logger;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.openapi.a;
import com.wifipay.wallet.transfer.fragment.TransferInputNumberFragment;

public class TransferActivity
  extends BaseActivity
{
  static
  {
    StubApp1053578832.interface11(136);
  }
  
  public void i()
  {
    if (!b.a().n()) {}
    try
    {
      a.a(this, 4, 1, "null");
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
    Logger.v("zhao == %s", new Object[] { "activityRequestCode" + paramInt1 });
    Logger.v("zhao == %s", new Object[] { "activityResultCode" + paramInt2 });
    if (paramInt1 == 1) {
      this.a.findFragmentByTag(String.valueOf(R.id.wifipay_fragment_contacts_number)).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(getResources().getString(R.string.wifipay_select_the_payee));
    a(R.id.wifipay_fragment_contacts_number, TransferInputNumberFragment.class, getIntent().getExtras());
    i();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/transfer/activity/TransferActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */