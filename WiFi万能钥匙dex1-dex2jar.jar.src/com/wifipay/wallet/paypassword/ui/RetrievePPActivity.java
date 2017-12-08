package com.wifipay.wallet.paypassword.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.paypassword.ui.fragment.RetrievePPCardFragment;
import com.wifipay.wallet.paypassword.ui.fragment.RetrievePPVerifyFragment;
import com.wifipay.wallet.paypassword.ui.fragment.RetrieviePPSmsFragment;
import com.wifipay.wallet.paypassword.widget.a;

public class RetrievePPActivity
  extends BaseActivity
{
  private String h;
  
  static
  {
    StubApp1053578832.interface11(135);
  }
  
  public boolean a()
  {
    if ((!g.a(this.h)) && (g.a(this.h, CashierType.CALLAPPPAY.getType()))) {
      EventBus.getDefault().post(new a());
    }
    return super.a();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(getResources().getString(R.string.wifipay_setting_text_forget_password));
    if (!g.a(getIntent().getStringExtra("retrive"))) {
      a(getIntent().getStringExtra("retrive"));
    }
    this.h = getIntent().getStringExtra("cashier_type");
    a(R.id.wifipay_fragment_pp_old, RetrievePPCardFragment.class, getIntent().getExtras());
    a(R.id.wifipay_fragment_pp_new, RetrievePPVerifyFragment.class, getIntent().getExtras());
    a(R.id.wifipay_fragment_pp_sms, RetrieviePPSmsFragment.class, getIntent().getExtras());
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (!g.a(this.h)) && (g.a(this.h, CashierType.CALLAPPPAY.getType()))) {
      EventBus.getDefault().post(new a());
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/RetrievePPActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */