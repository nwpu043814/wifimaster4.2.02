package com.wifipay.wallet.pay.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.common.a.g;
import com.wifipay.common.logging.Logger;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.wallet.pay.SPayResp;
import com.wifipay.wallet.pay.SyncResp;

public class PayDetailsResultFragment
  extends BaseFragment
{
  private TextView a;
  private TextView b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private ImageView k;
  private LinearLayout l;
  private View m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private int x;
  
  private void e()
  {
    SPayResp localSPayResp = new SPayResp();
    localSPayResp.resultCode = "0";
    SyncResp.a(localSPayResp);
  }
  
  private void f()
  {
    SPayResp localSPayResp = new SPayResp();
    localSPayResp.resultCode = "-1";
    SyncResp.a(localSPayResp);
  }
  
  private void g()
  {
    SPayResp localSPayResp = new SPayResp();
    localSPayResp.resultCode = "-2";
    SyncResp.a(localSPayResp);
  }
  
  private void h()
  {
    this.m.setVisibility(0);
    this.j.setText(this.n);
    this.b.setText(this.p);
    this.c.setText("¥ " + this.o);
    this.d.setText(this.q);
    if (g.a(this.r))
    {
      this.e.setText(f.a(R.string.wifipay_pay_with_balance));
      this.g.setText(this.u);
      this.f.setText(this.t);
      if ((g.a(this.v)) || (g.a(this.w))) {
        break label257;
      }
      this.l.setVisibility(0);
      this.i.setVisibility(0);
      this.h.setText("连尚支付随机立减¥ " + this.v);
      this.i.setText("¥ " + this.w);
      this.i.getPaint().setFlags(16);
    }
    for (;;)
    {
      return;
      this.e.setText(this.r + "(" + this.s + ")");
      break;
      label257:
      this.l.setVisibility(8);
      this.i.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.n = getArguments().getString("goodsInfo");
    this.o = getArguments().getString("tradeAmount");
    this.p = getArguments().getString("merchantName");
    this.q = getArguments().getString("tradeTime");
    this.r = getArguments().getString("bankName");
    this.s = getArguments().getString("cardNo");
    this.t = getArguments().getString("orderId");
    this.u = getArguments().getString("merchantOrderNo");
    this.v = getArguments().getString("mOrderAmountFavourable");
    this.w = getArguments().getString("mOrderAmountOld");
    this.x = getActivity().getIntent().getIntExtra("which_fragment", R.id.wifipay_fragment_default);
    Logger.v("zhao resultId== %s", new Object[] { Integer.valueOf(this.x) });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.wifipay_fragment_pay_result, null);
    this.k = ((ImageView)paramLayoutInflater.findViewById(R.id.wifipay_result_icon));
    this.a = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_result_status));
    this.m = paramLayoutInflater.findViewById(R.id.wifipay_success_content);
    this.b = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_pay_merchant_success_name));
    this.c = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_pay_merchant_success_amount));
    this.d = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_pay_merchant_success_time));
    this.g = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_pay_merchant_success_order));
    this.e = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_pay_success_method));
    this.f = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_pay_success_business));
    this.h = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_pay_order_success_favourable_content));
    this.i = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_pay_merchant_success_amount_old));
    this.l = ((LinearLayout)paramLayoutInflater.findViewById(R.id.wifipay_pay_order_success_favourable));
    this.j = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_pay_merchant_success_name_header));
    h();
    if (this.x == R.id.wifipay_fragment_success)
    {
      this.k.setImageResource(R.drawable.wifipay_wallet_pay_result_success);
      paramViewGroup = f.a(R.string.wifipay_pay_success);
      this.a.setText(paramViewGroup);
      e();
    }
    if (this.x == R.id.wifipay_fragment_default)
    {
      this.k.setImageResource(R.drawable.wifipay_wallet_pay_result_waiting);
      paramViewGroup = f.a(R.string.wifipay_pay_paying);
      this.a.setText(paramViewGroup);
      f();
    }
    if (this.x == R.id.wifipay_fragment_fail)
    {
      this.k.setImageResource(R.drawable.wifipay_wallet_pay_result_fail);
      paramViewGroup = f.a(R.string.wifipay_payee_fail);
      this.a.setText(paramViewGroup);
      g();
    }
    return paramLayoutInflater;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/pay/fragment/PayDetailsResultFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */