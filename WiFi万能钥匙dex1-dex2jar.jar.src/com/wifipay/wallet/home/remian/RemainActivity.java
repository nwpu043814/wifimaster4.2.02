package com.wifipay.wallet.home.remian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.framework.widget.WPButton;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.f;
import com.wifipay.wallet.prod.core.model.WalletCard;
import com.wifipay.wallet.prod.security.query.QueryService;
import com.wifipay.wallet.prod.security.query.WalletBalanceResp;

public class RemainActivity
  extends BaseActivity
{
  private TextView h;
  private WPButton i;
  
  static
  {
    StubApp1053578832.interface11(120);
  }
  
  private String e(String paramString)
  {
    return "¥ " + paramString;
  }
  
  private void i()
  {
    this.h = ((TextView)findViewById(R.id.wifipay_remain_text_money));
  }
  
  private void j()
  {
    if (!b.a().n()) {}
    for (;;)
    {
      return;
      String str = b.a().o();
      if (f.a(str))
      {
        if (Float.valueOf(str).floatValue() == 0.0F) {
          this.i.setVisibility(8);
        }
        this.h.setText(e(str));
      }
      c("");
      ((QueryService)RpcService.getBgRpcProxy(QueryService.class)).queryWalletBalance(String.valueOf(System.currentTimeMillis()));
    }
  }
  
  public void clickToActivity(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_remain_btn_top_up) {
      startActivity(new Intent("com.wifipay.action.WP_DEPOSIT"));
    }
    if (paramView.getId() == R.id.wifipay_remain_btn_withdrawals) {
      startActivity(new Intent("com.wifipay.action.WP_WITHDRAW"));
    }
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleWalletBalance(WalletBalanceResp paramWalletBalanceResp)
  {
    d();
    if (ResponseCode.SUCCESS.getCode().equals(paramWalletBalanceResp.resultCode)) {
      if (f.a(paramWalletBalanceResp.resultObject.availableBalance))
      {
        b.a().a(paramWalletBalanceResp.resultObject.availableBalance);
        if (Float.valueOf(paramWalletBalanceResp.resultObject.availableBalance).floatValue() == 0.0F) {
          this.i.setVisibility(8);
        }
        this.h.setText(e(paramWalletBalanceResp.resultObject.availableBalance));
      }
    }
    for (;;)
    {
      return;
      b(paramWalletBalanceResp.resultMessage);
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onResume()
  {
    super.onResume();
    j();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/remian/RemainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */