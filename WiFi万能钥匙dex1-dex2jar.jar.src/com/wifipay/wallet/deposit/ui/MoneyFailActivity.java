package com.wifipay.wallet.deposit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.wallet.BaseActivity;

public class MoneyFailActivity
  extends BaseActivity
{
  private String h;
  private String i;
  
  static
  {
    StubApp1053578832.interface11(116);
  }
  
  private void i()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      if (localBundle.containsKey("extra_type")) {
        this.i = localBundle.getString("extra_type");
      }
      if (localBundle.containsKey("reason")) {
        this.h = localBundle.getString("reason");
      }
    }
    else
    {
      return;
    }
    throw new IllegalArgumentException("启动该Activity需要type");
  }
  
  private void j()
  {
    finish();
  }
  
  public boolean a()
  {
    j();
    return true;
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      j();
    }
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/deposit/ui/MoneyFailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */