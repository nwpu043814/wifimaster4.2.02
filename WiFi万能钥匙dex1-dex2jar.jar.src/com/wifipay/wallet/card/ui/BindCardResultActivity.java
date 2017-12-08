package com.wifipay.wallet.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.a.c;

public class BindCardResultActivity
  extends BaseActivity
{
  static
  {
    StubApp1053578832.interface11(108);
  }
  
  public boolean a()
  {
    if (getIntent().getIntExtra("which_fragment", R.id.wifipay_fragment_default) == R.id.wifipay_fragment_success) {
      EventBus.getDefault().post(new c());
    }
    return super.a();
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (getIntent().getIntExtra("which_fragment", R.id.wifipay_fragment_default) == R.id.wifipay_fragment_success)) {
      EventBus.getDefault().post(new c());
    }
    return false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/card/ui/BindCardResultActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */