package com.wifipay.wallet.card.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.framework.a.a;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.card.ui.fragment.BindCardIdentityFragment;
import com.wifipay.wallet.card.ui.fragment.BindCardNumberInputFragment;
import com.wifipay.wallet.cashier.CashierType;

public class BindCardActivity
  extends BaseActivity
{
  private String h;
  private String i;
  
  static
  {
    StubApp1053578832.interface11(107);
  }
  
  private void i()
  {
    if ((TextUtils.equals(this.i, CashierType.CALLAPPPAY.getType())) || ((!g.a(this.h)) && (TextUtils.equals(this.h, CashierType.CALLAPPPAY.getType()))))
    {
      EventBus.getDefault().post(new a());
      j();
    }
    BaseFragment localBaseFragment = c(f());
    if ((localBaseFragment instanceof BindCardNumberInputFragment)) {
      ((BindCardNumberInputFragment)localBaseFragment).e();
    }
    for (;;)
    {
      return;
      if ((localBaseFragment instanceof BindCardIdentityFragment)) {
        ((BindCardIdentityFragment)localBaseFragment).e();
      }
    }
  }
  
  private void j()
  {
    View localView = getWindow().peekDecorView();
    if (localView != null) {
      ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(localView.getWindowToken(), 0);
    }
  }
  
  public boolean a()
  {
    i();
    return super.a();
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      i();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/card/ui/BindCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */