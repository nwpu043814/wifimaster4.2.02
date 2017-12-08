package com.wifipay.wallet.deposit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.framework.app.a;
import com.wifipay.framework.widget.WPTwoTextView;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.utils.d;

public class MoneySuccessActivity
  extends BaseActivity
{
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private WPTwoTextView o;
  private WPTwoTextView p;
  private WPTwoTextView q;
  private WPTwoTextView r;
  private View s;
  private View t;
  private TextView u;
  
  static
  {
    StubApp1053578832.interface11(117);
  }
  
  private void a(Bundle paramBundle)
  {
    this.u.setText(getString(R.string.wifipay_deposit_success));
    this.o.setText("¥" + d.e(this.i));
    this.o.setBarTitle(getString(R.string.wifipay_deposit_amount));
    this.p.setText(this.k + "(*" + this.j + ")");
    this.p.setBarTitle(getString(R.string.wifipay_pay_method));
    this.q.setVisibility(8);
    this.r.setVisibility(8);
    this.t.setVisibility(8);
    this.s.setVisibility(8);
  }
  
  private void b(Bundle paramBundle)
  {
    if (paramBundle.containsKey("extra_payeename")) {
      this.l = paramBundle.getString("extra_payeename");
    }
    if (paramBundle.containsKey("extra_payeeloginname")) {
      this.m = paramBundle.getString("extra_payeeloginname");
    }
    if (paramBundle.containsKey("extra_remark")) {
      this.n = paramBundle.getString("extra_remark");
    }
    this.u.setText(getString(R.string.wifipay_transfer_success_title));
    this.o.setBarTitle(getString(R.string.wifipay_transfer_to_title));
    this.p.setBarTitle(getString(R.string.wifipay_transfer_to_amount));
    this.q.setBarTitle(getString(R.string.wifipay_transfer_brand_name));
    this.r.setBarTitle(getString(R.string.wifipay_transfer_order_title));
    if ((!g.a(this.l)) && (!com.wifipay.wallet.common.utils.f.e(this.l)))
    {
      paramBundle = this.l.replace(this.l.substring(0, 1), "*");
      this.o.setText(this.m + "(" + paramBundle + ")");
      this.p.setText(d.e(this.i) + getString(R.string.wifipay_online_payee_unit));
      if (!g.a(this.k)) {
        break label307;
      }
      this.q.setText(com.wifipay.common.a.f.a(R.string.wifipay_home_header_content_remain));
      label264:
      if (!g.a(this.n)) {
        break label351;
      }
      this.r.setVisibility(8);
      this.s.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.o.setText(this.m);
      break;
      label307:
      this.q.setText(this.k + "(*" + this.j + ")");
      break label264;
      label351:
      this.r.setVisibility(0);
      this.s.setVisibility(0);
      this.r.setText(this.n);
    }
  }
  
  private void c(Bundle paramBundle)
  {
    this.u.setText(getString(R.string.wifipay_withdraw_apply_for));
    this.o.setText(this.k + "(*" + this.j + ")");
    this.o.setBarTitle(getString(R.string.wifipay_withdraw_bank_name));
    this.p.setText("¥" + d.e(this.i));
    this.p.setBarTitle(getString(R.string.wifipay_withdraw_amount));
    this.q.setVisibility(8);
    this.r.setVisibility(8);
    this.t.setVisibility(8);
    this.s.setVisibility(8);
  }
  
  private void i()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      if (!localBundle.containsKey("extra_type")) {
        break label161;
      }
      this.h = localBundle.getString("extra_type");
      if (localBundle.containsKey("extra_amoubt")) {
        this.i = localBundle.getString("extra_amoubt");
      }
      if (localBundle.containsKey("extra_bankcode")) {
        this.j = localBundle.getString("extra_bankcode");
      }
      if (localBundle.containsKey("extra_bankname")) {
        this.k = localBundle.getString("extra_bankname");
      }
      if (!TextUtils.equals(this.h, getString(R.string.wifipay_deposit_title))) {
        break label111;
      }
      a(localBundle);
    }
    for (;;)
    {
      return;
      label111:
      if (TextUtils.equals(this.h, getString(R.string.wifipay_transfer_title))) {
        b(localBundle);
      } else if (TextUtils.equals(this.h, getString(R.string.wifipay_withdraw_title))) {
        c(localBundle);
      }
    }
    label161:
    throw new IllegalArgumentException("启动该Activity需要type");
  }
  
  private void j() {}
  
  public boolean a()
  {
    j();
    return true;
  }
  
  public native void onCreate(Bundle paramBundle);
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      j();
    }
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/deposit/ui/MoneySuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */