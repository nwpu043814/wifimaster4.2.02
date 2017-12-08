package com.wifipay.wallet.home.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.wifipay.R.color;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.framework.widget.WPRelativeLayout;
import com.wifipay.wallet.bank.activity.BankManageActivity;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.home.bill.ui.WalletBillActivity;
import com.wifipay.wallet.home.remian.RemainActivity;
import com.wifipay.wallet.home.widget.e;

public class o
  implements View.OnTouchListener
{
  public TextView a;
  public boolean b = true;
  private WPRelativeLayout c;
  private ImageView d;
  private TextView e;
  private WPRelativeLayout f;
  private ImageView g;
  private TextView h;
  private WPRelativeLayout i;
  private ImageView j;
  private TextView k;
  private long l;
  private HomeActivity m;
  
  public o(HomeActivity paramHomeActivity)
  {
    this.m = paramHomeActivity;
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == this.c)
    {
      if (paramInt == 1)
      {
        a(paramView);
        if (b.a().n()) {
          break label69;
        }
        com.wifipay.wallet.openapi.a.a(this.m, 1, 1, "账单");
      }
      for (;;)
      {
        this.d.setImageResource(R.drawable.wifipay_home_header_bill_n);
        this.e.setTextColor(this.m.getResources().getColor(R.color.wifipay_color_ffffff));
        return;
        label69:
        com.wifipay.wallet.common.utils.a.a(this.m, "账单");
        paramView = new Intent(this.m, WalletBillActivity.class);
        this.m.startActivity(paramView);
      }
    }
    if (paramView == this.f)
    {
      if (paramInt == 1)
      {
        a(paramView);
        if (b.a().n()) {
          break label174;
        }
        com.wifipay.wallet.openapi.a.a(this.m, 1, 1, "零钱");
      }
      for (;;)
      {
        this.g.setImageResource(R.drawable.wifipay_home_header_remain_n);
        this.h.setTextColor(this.m.getResources().getColor(R.color.wifipay_color_ffffff));
        break;
        label174:
        com.wifipay.wallet.common.utils.a.a(this.m, "余额");
        paramView = new Intent(this.m, RemainActivity.class);
        this.m.startActivityForResult(paramView, 1);
      }
    }
    if (paramInt == 1)
    {
      a(paramView);
      if (b.a().n()) {
        break label272;
      }
      com.wifipay.wallet.openapi.a.a(this.m, 1, 1, "银行卡");
    }
    for (;;)
    {
      this.j.setImageResource(R.drawable.wifipay_home_header_bandcard_n);
      this.k.setTextColor(this.m.getResources().getColor(R.color.wifipay_color_ffffff));
      break;
      label272:
      com.wifipay.wallet.common.utils.a.a(this.m, "银行卡");
      paramView = new Intent(this.m, BankManageActivity.class);
      this.m.startActivity(paramView);
    }
  }
  
  private void b()
  {
    this.c.setOnTouchListener(this);
    this.f.setOnTouchListener(this);
    this.i.setOnTouchListener(this);
  }
  
  public void a()
  {
    this.c = ((WPRelativeLayout)this.m.findViewById(R.id.wifipay_home_header_scan));
    this.d = ((ImageView)this.m.findViewById(R.id.wifipay_home_header_scan_image));
    this.e = ((TextView)this.m.findViewById(R.id.wifipay_home_header_scan_text));
    this.f = ((WPRelativeLayout)this.m.findViewById(R.id.wifipay_home_header_remain));
    this.g = ((ImageView)this.m.findViewById(R.id.wifipay_home_header_remain_image));
    this.h = ((TextView)this.m.findViewById(R.id.wifipay_home_header_remain_text));
    this.i = ((WPRelativeLayout)this.m.findViewById(R.id.wifipay_home_header_pay));
    this.j = ((ImageView)this.m.findViewById(R.id.wifipay_home_header_pay_image));
    this.k = ((TextView)this.m.findViewById(R.id.wifipay_home_header_pay_text));
    this.a = ((TextView)this.m.findViewById(R.id.wifipay_home_header_content_price));
    b();
  }
  
  public void a(View paramView)
  {
    if (paramView.isEnabled()) {
      new e(paramView).a();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.l = System.currentTimeMillis();
      if (paramView == this.c)
      {
        this.d.setImageResource(R.drawable.wifipay_home_header_bill_p);
        this.e.setTextColor(this.m.getResources().getColor(R.color.wifipay_color_a5cbfe));
      }
      else if (paramView == this.f)
      {
        this.g.setImageResource(R.drawable.wifipay_home_header_remain_p);
        this.h.setTextColor(this.m.getResources().getColor(R.color.wifipay_color_a5cbfe));
      }
      else
      {
        this.j.setImageResource(R.drawable.wifipay_home_header_bandcard_p);
        this.k.setTextColor(this.m.getResources().getColor(R.color.wifipay_color_a5cbfe));
        continue;
        a(paramView, 3);
        continue;
        if (System.currentTimeMillis() - this.l < 500L) {
          a(paramView, 1);
        } else {
          a(paramView, 3);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */