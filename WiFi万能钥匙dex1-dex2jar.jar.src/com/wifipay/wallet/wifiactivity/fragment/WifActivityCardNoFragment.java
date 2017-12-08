package com.wifipay.wallet.wifiactivity.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.framework.api.b;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.framework.widget.WPEditTextView;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.d;
import com.wifipay.wallet.common.utils.f;
import com.wifipay.wallet.prod.bandcard.BindCardService;
import com.wifipay.wallet.prod.bandcard.dto.BindCardCheckBinResp;
import com.wifipay.wallet.prod.bandcard.dto.BindCardCheckBinResp.ResultObject;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import java.util.HashMap;

public class WifActivityCardNoFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private WPEditTextView a;
  private View b;
  private View c;
  private b d;
  
  private void e()
  {
    this.d.a(this.a.getEditText());
    this.d.a(this.b);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    d.a(this.a.getEditText());
  }
  
  private void f()
  {
    b("");
    ((BindCardService)RpcService.getBgRpcProxy(BindCardService.class)).checkNotLogin(this.a.getText().replace(" ", ""));
  }
  
  @Subscribe
  public void handleCheckCardBin(BindCardCheckBinResp paramBindCardCheckBinResp)
  {
    d();
    StartPayParams localStartPayParams = (StartPayParams)getArguments().getSerializable("pay_params");
    if (f.b(localStartPayParams)) {}
    for (;;)
    {
      return;
      if (g.a(ResponseCode.SUCCESS.getCode(), paramBindCardCheckBinResp.resultCode))
      {
        localStartPayParams.additionalParams.put("bankName", paramBindCardCheckBinResp.resultObject.bankName);
        localStartPayParams.additionalParams.put("cardNo", this.a.getText().replace(" ", ""));
        localStartPayParams.additionalParams.put("bankCode", paramBindCardCheckBinResp.resultObject.bankCode);
        localStartPayParams.additionalParams.put("cardType", paramBindCardCheckBinResp.resultObject.cardType);
        paramBindCardCheckBinResp = new Bundle();
        paramBindCardCheckBinResp.putSerializable("pay_params", localStartPayParams);
        a(R.id.wifipay_fragment_identity_check, paramBindCardCheckBinResp);
      }
      else if (TextUtils.equals(ResponseCode.HPS_AGREEMENTNO_MAX.getCode(), paramBindCardCheckBinResp.resultCode))
      {
        a(ResponseCode.HPS_AGREEMENTNO_MAX.getDesc());
      }
      else
      {
        a(paramBindCardCheckBinResp.resultMessage);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_wifiactivity_btn_next) {
      f();
    }
    if (paramView.getId() == R.id.wifipay_wifiactivity_title_back) {
      c().finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.d = new b();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.wifipay_wifiactivity_fragment_card_no, null);
    this.a = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_card_id));
    this.b = paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_btn_next);
    this.c = paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_title_back);
    e();
    return paramLayoutInflater;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/wifiactivity/fragment/WifActivityCardNoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */