package com.wifipay.wallet.cashier.ui.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.framework.api.b;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.widget.WPEditTextView;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.d;
import com.wifipay.wallet.common.utils.f;
import com.wifipay.wallet.prod.bandcard.BindCardService;
import com.wifipay.wallet.prod.bandcard.dto.BindCardCheckBinResp;
import com.wifipay.wallet.prod.bandcard.dto.BindCardCheckBinResp.ResultObject;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.security.account.AccountManagerService;
import com.wifipay.wallet.prod.security.account.dto.QueryRNInfoResp;
import com.wifipay.wallet.prod.security.account.dto.QueryRNInfoResp.ResultObject;
import com.wifipay.wallet.widget.virtualkeyboard.VirtualKeyBoardFlag;
import com.wifipay.wallet.widget.virtualkeyboard.VirtualKeyboardView;
import java.util.HashMap;

public class NewCardNoFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private ImageView a;
  private WPEditTextView b;
  private WPEditTextView c;
  private View d;
  private View e;
  private b f;
  private VirtualKeyboardView g;
  
  private void e()
  {
    this.f.a(this.b.getEditText());
    this.f.a(this.e);
    this.e.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.b.requestFocus();
    this.g.setNotUseSystemKeyBoard(this.b.getEditText());
    this.g.a(this.b.getEditText(), VirtualKeyBoardFlag.NUMBER.getFlag());
    d.a(this.b.getEditText());
    f();
  }
  
  private void f()
  {
    ((AccountManagerService)RpcService.getBgRpcProxy(AccountManagerService.class)).queryRealName(String.valueOf(System.currentTimeMillis()));
  }
  
  private void g()
  {
    b("");
    ((BindCardService)RpcService.getBgRpcProxy(BindCardService.class)).checkBin(this.b.getText().replace(" ", ""));
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
        if (("CR".equals(paramBindCardCheckBinResp.resultObject.cardType)) && ((CashierType.DEPOSIT.getType().equals(localStartPayParams.type)) || (CashierType.TRANSFER.getType().equals(localStartPayParams.type))))
        {
          a(getResources().getString(R.string.wifipay_bindcard_un_support));
        }
        else
        {
          localStartPayParams.additionalParams.put("bankName", paramBindCardCheckBinResp.resultObject.bankName);
          localStartPayParams.additionalParams.put("cardNo", this.b.getText().replace(" ", ""));
          localStartPayParams.additionalParams.put("bankCode", paramBindCardCheckBinResp.resultObject.bankCode);
          localStartPayParams.additionalParams.put("cardType", paramBindCardCheckBinResp.resultObject.cardType);
          localStartPayParams.additionalParams.put("trueName", this.c.getText());
          HashMap localHashMap = localStartPayParams.additionalParams;
          if (this.c.getTag(R.id.wifipay_tag1) == null) {}
          for (paramBindCardCheckBinResp = null;; paramBindCardCheckBinResp = (String)this.c.getTag(R.id.wifipay_tag1))
          {
            localHashMap.put("certNo", paramBindCardCheckBinResp);
            paramBindCardCheckBinResp = new Bundle();
            paramBindCardCheckBinResp.putSerializable("pay_params", localStartPayParams);
            a(R.id.wifipay_fragment_identity_check, paramBindCardCheckBinResp);
            break;
          }
        }
      }
      else if (TextUtils.equals(ResponseCode.HPS_AGREEMENTNO_MAX.getCode(), paramBindCardCheckBinResp.resultCode)) {
        a(ResponseCode.HPS_AGREEMENTNO_MAX.getDesc());
      } else {
        a(paramBindCardCheckBinResp.resultMessage);
      }
    }
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleRealName(QueryRNInfoResp paramQueryRNInfoResp)
  {
    if ((g.a(ResponseCode.SUCCESS.getCode(), paramQueryRNInfoResp.resultCode)) && (paramQueryRNInfoResp.resultObject != null) && (!g.a(paramQueryRNInfoResp.resultObject.trueName)))
    {
      this.d.setVisibility(0);
      this.c.setText(paramQueryRNInfoResp.resultObject.trueName);
      this.c.setTag(R.id.wifipay_tag1, paramQueryRNInfoResp.resultObject.certNo);
      this.c.setEnabled(false);
      this.a.setVisibility(0);
    }
    for (;;)
    {
      return;
      this.c.setTag(R.id.wifipay_tag1, null);
      this.d.setVisibility(8);
      this.a.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_bindcard_btn_next) {
      g();
    }
    for (;;)
    {
      return;
      if (paramView.getId() == R.id.wifipay_card_own_note) {
        a(getString(R.string.wifipay_remindertitle), getString(R.string.wifipay_band_card_note), getString(R.string.wifipay_alert_btn_i_know), new a(this), null, null);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = new b();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.wifipay_fragment_new_card_no, null);
    this.a = ((ImageView)paramLayoutInflater.findViewById(R.id.wifipay_card_own_note));
    this.b = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_bindcard_card_id));
    this.c = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_card_own));
    this.d = paramLayoutInflater.findViewById(R.id.wifipay_bindcard_card_own_container);
    this.e = paramLayoutInflater.findViewById(R.id.wifipay_bindcard_btn_next);
    this.g = ((VirtualKeyboardView)paramLayoutInflater.findViewById(R.id.wifipay_bottom_virtual_keyboard));
    e();
    return paramLayoutInflater;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/ui/fragment/NewCardNoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */