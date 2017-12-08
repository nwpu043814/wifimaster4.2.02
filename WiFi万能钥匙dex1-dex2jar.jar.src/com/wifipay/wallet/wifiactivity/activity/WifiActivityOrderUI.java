package com.wifipay.wallet.wifiactivity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.a.d;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.PayStatus;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.pay.SPayResp;
import com.wifipay.wallet.pay.SyncResp;
import com.wifipay.wallet.prod.core.model.PayCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.core.model.StartPayParams.ProductInfo;
import com.wifipay.wallet.prod.wifiactivity.WifiActivityPayResp;
import com.wifipay.wallet.prod.wifiactivity.WifiActivityPayResp.ResultObject;

public class WifiActivityOrderUI
  extends BaseActivity
  implements View.OnClickListener
{
  private View h;
  private View i;
  private FrameLayout j;
  private TextView k;
  private TextView l;
  private StartPayParams m;
  
  static
  {
    StubApp1053578832.interface11(139);
  }
  
  private void a(BaseResp paramBaseResp)
  {
    int n;
    if (com.wifipay.wallet.common.utils.f.a(paramBaseResp))
    {
      WifiActivityPayResp localWifiActivityPayResp = (WifiActivityPayResp)paramBaseResp;
      if (ResponseCode.SUCCESS.getCode().equals(paramBaseResp.resultCode))
      {
        n = PayStatus.findStatus(localWifiActivityPayResp.resultObject.payStatus);
        if (n == PayStatus.PAY_SUCCESS.getStatus())
        {
          paramBaseResp = new SPayResp();
          paramBaseResp.resultCode = "0";
          paramBaseResp.telNo = localWifiActivityPayResp.resultObject.mobileNo;
          paramBaseResp.merchantOrederNo = localWifiActivityPayResp.resultObject.merchantOrderNo;
          paramBaseResp.pay_source = 1;
          SyncResp.a(paramBaseResp);
          SyncResp.b();
          finish();
        }
      }
    }
    for (;;)
    {
      return;
      if (n == PayStatus.PAYING.getStatus())
      {
        paramBaseResp = new SPayResp();
        paramBaseResp.resultCode = "-1";
        paramBaseResp.pay_source = 1;
        SyncResp.a(paramBaseResp);
        SyncResp.b();
        finish();
      }
      else
      {
        m();
        finish();
        continue;
        a(paramBaseResp.resultMessage);
        m();
        finish();
        continue;
        l();
      }
    }
  }
  
  private void i()
  {
    this.h = findViewById(R.id.wifipay_wifiactivity_root);
    this.i = findViewById(R.id.wifipay_wifiactivity_card_info);
    this.j = ((FrameLayout)findViewById(R.id.wifipay_wifiactivity_back));
    this.k = ((TextView)findViewById(R.id.wifipay_wifiactivity_product_name));
    this.l = ((TextView)findViewById(R.id.wifipay_wifiactivity_product_amount));
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    j();
  }
  
  private void j()
  {
    if (this.m.productInfo != null)
    {
      this.k.setText(com.wifipay.common.a.f.a(R.string.wifipay_pay_amount_title));
      this.l.setText(this.m.productInfo.productAmount + "元");
    }
    PayCard localPayCard = PayCard.newCard(CashierType.CALLAPPPAY.getType());
    this.m.chosenCard = localPayCard;
  }
  
  private void k()
  {
    Intent localIntent = new Intent(this, WifiActivityCardInfo.class);
    localIntent.putExtra("pay_params", this.m);
    startActivity(localIntent);
  }
  
  private void l()
  {
    SPayResp localSPayResp = new SPayResp();
    localSPayResp.resultCode = "-3";
    localSPayResp.pay_source = 1;
    SyncResp.a(localSPayResp);
    SyncResp.b();
    finish();
  }
  
  private void m()
  {
    SPayResp localSPayResp = new SPayResp();
    localSPayResp.resultCode = "-2";
    localSPayResp.pay_source = 1;
    SyncResp.a(localSPayResp);
    SyncResp.b();
  }
  
  @Subscribe(priority=1, sticky=true, threadMode=ThreadMode.MAIN)
  public void handlePayCompleteEvent(d paramd)
  {
    a(paramd.c);
    EventBus.getDefault().removeStickyEvent(paramd);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_wifiactivity_card_info) {
      k();
    }
    if (paramView.getId() == R.id.wifipay_wifiactivity_back) {
      l();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.wifipay_wifiactivity_pay_detail);
    a(8);
    this.m = ((StartPayParams)getIntent().getSerializableExtra("pay_params"));
    i();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt) {}
    for (boolean bool = true;; bool = super.onKeyDown(paramInt, paramKeyEvent)) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/wifiactivity/activity/WifiActivityOrderUI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */