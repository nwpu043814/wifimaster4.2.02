package com.wifipay.wallet.paypassword.ui.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.framework.api.c;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.framework.widget.WPCheckBox;
import com.wifipay.framework.widget.WPEditTextView;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.ui.SMSValidatorActivity;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.d;
import com.wifipay.wallet.home.ui.HomeWebActivity;
import com.wifipay.wallet.prod.core.model.BankCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.paypassword.PPService;
import com.wifipay.wallet.prod.paypassword.ResetPPPreResp;
import com.wifipay.wallet.prod.paypassword.ResetPPPreResp.ResultObject;
import com.wifipay.wallet.prod.paypassword.ResetPPSmsResp;
import java.util.HashMap;

public class RetrievePPVerifyFragment
  extends BaseFragment
  implements View.OnClickListener
{
  protected BankCard a;
  private WPEditTextView b;
  private WPEditTextView c;
  private WPEditTextView d;
  private WPEditTextView e;
  private WPEditTextView f;
  private WPEditTextView g;
  private View h;
  private TextView i;
  private Button j;
  private String k;
  private WPCheckBox l;
  
  private void e()
  {
    if (g()) {
      this.h.setVisibility(0);
    }
    this.g.setHint(getResources().getString(R.string.wifipay_hint_card_realname, new Object[] { b.a().i() }));
    String str = getResources().getString(R.string.wifipay_hint_card_number, new Object[] { this.a.cardNo });
    this.b.setHint(str);
    this.b.requestFocus();
    d.a(this.b.getEditText());
    this.j.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }
  
  private void f()
  {
    b("");
    PPService localPPService = (PPService)RpcService.getBgRpcProxy(PPService.class);
    String str = this.b.getText().replace(" ", "");
    localPPService.resetPPPre(this.a.agreementNo, this.e.getText(), str, this.d.getText(), this.c.getText(), this.f.getText());
  }
  
  private boolean g()
  {
    return this.a.cardType.equalsIgnoreCase("CR");
  }
  
  @Subscribe
  public void handleResetPP(ResetPPSmsResp paramResetPPSmsResp)
  {
    c().finish();
  }
  
  @Subscribe
  public void handleResetResp(ResetPPPreResp paramResetPPPreResp)
  {
    d();
    if (ResponseCode.SUCCESS.getCode().equals(paramResetPPPreResp.resultCode))
    {
      StartPayParams localStartPayParams = new StartPayParams();
      localStartPayParams.type = CashierType.RETRIEVEPASSWORD.getType();
      localStartPayParams.bindcardsource = "RETRIEVEPASSWORD";
      localStartPayParams.additionalParams = new HashMap();
      localStartPayParams.additionalParams.put("agreementNo", this.a.agreementNo);
      localStartPayParams.additionalParams.put("requestNo", paramResetPPPreResp.resultObject.requestNo);
      localStartPayParams.additionalParams.put("cardNo", this.b.getText().replace(" ", ""));
      localStartPayParams.additionalParams.put("certNo", this.e.getText());
      if (g())
      {
        localStartPayParams.additionalParams.put("cvv2", this.d.getText().trim());
        localStartPayParams.additionalParams.put("validDate", this.c.getText().trim());
      }
      localStartPayParams.additionalParams.put("mobile", this.f.getText());
      paramResetPPPreResp = new Intent(c(), SMSValidatorActivity.class);
      paramResetPPPreResp.putExtra("pay_params", localStartPayParams);
      startActivity(paramResetPPPreResp);
    }
    for (;;)
    {
      return;
      a(paramResetPPPreResp.resultMessage);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    c().a(c().getResources().getString(R.string.wifipay_retrieve_pp_verify_title));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_pp_retrieve_btn_next) {
      f();
    }
    for (;;)
    {
      return;
      if (paramView.getId() == R.id.wifipay_pp_prompt_text)
      {
        HomeWebActivity.a(getActivity(), "https://css.shengpay.com/html/instruction/view/wifi.html");
      }
      else if (paramView.getId() == R.id.wifipay_retrieve_note)
      {
        a(getString(R.string.wifipay_cardholders_that), getString(R.string.wifipay_band_card_note), getString(R.string.wifipay_alert_btn_i_know), null, null, null);
      }
      else if (paramView.getId() == R.id.wifipay_retrieve_phoneinfo)
      {
        paramView = LayoutInflater.from(c()).inflate(R.layout.wifipay_mobile_phone_description, null);
        a(getString(R.string.wifipay_phone_numble_that), getString(R.string.wifipay_alert_btn_i_know), null, paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = ((BankCard)getArguments().getSerializable("card_info"));
    this.k = getArguments().getString("cashier_type");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(R.layout.wifipay_fragment_retrieve_pp_verify, null);
    this.b = ((WPEditTextView)paramViewGroup.findViewById(R.id.wifipay_pp_card_number));
    this.c = ((WPEditTextView)paramViewGroup.findViewById(R.id.wifipay_pp_card_credit_date));
    this.d = ((WPEditTextView)paramViewGroup.findViewById(R.id.wifipay_pp_card_credit_number));
    this.g = ((WPEditTextView)paramViewGroup.findViewById(R.id.wifipay_pp_card_reserve_name));
    this.e = ((WPEditTextView)paramViewGroup.findViewById(R.id.wifipay_pp_card_reserve_credentials_number));
    this.f = ((WPEditTextView)paramViewGroup.findViewById(R.id.wifipay_pp_card_reserve_mobile));
    this.i = ((TextView)paramViewGroup.findViewById(R.id.wifipay_pp_prompt_text));
    this.j = ((Button)paramViewGroup.findViewById(R.id.wifipay_pp_retrieve_btn_next));
    this.h = paramViewGroup.findViewById(R.id.wifipay_pp_card_credit_info_container);
    paramLayoutInflater = paramViewGroup.findViewById(R.id.wifipay_retrieve_note);
    paramBundle = paramViewGroup.findViewById(R.id.wifipay_retrieve_phoneinfo);
    this.l = ((WPCheckBox)paramViewGroup.findViewById(R.id.wifipay_agree_protocol));
    paramLayoutInflater.setOnClickListener(this);
    paramBundle.setOnClickListener(this);
    c localc = new c(this.j);
    localc.a(this.b.getEditText());
    localc.a(this.g.getEditText(), paramLayoutInflater);
    localc.a(this.e.getEditText());
    localc.a(this.f.getEditText(), paramBundle);
    localc.a(this.l);
    if (g())
    {
      localc.a(this.c.getEditText());
      localc.a(this.d.getEditText());
    }
    e();
    return paramViewGroup;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/fragment/RetrievePPVerifyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */