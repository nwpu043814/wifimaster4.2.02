package com.wifipay.wallet.cashier.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.framework.api.c;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.widget.WPCheckBox;
import com.wifipay.framework.widget.WPEditTextView;
import com.wifipay.framework.widget.WPTwoTextView;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.home.ui.HomeWebActivity;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import java.util.HashMap;

public class NewCardDetailFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private TextView a;
  private WPTwoTextView b;
  private WPEditTextView c;
  private WPEditTextView d;
  private WPEditTextView e;
  private WPEditTextView f;
  private WPEditTextView g;
  private Button h;
  private StartPayParams i;
  private WPCheckBox j;
  private View k;
  private View l;
  private c m;
  private TextView n;
  private TextView o;
  private String p;
  private String q;
  private String r;
  
  private void f()
  {
    label82:
    label141:
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(this.r))
    {
      this.c.setText(this.r);
      this.k.setVisibility(8);
      this.n.setText(getString(R.string.wifipay_bankcard_message_note));
      this.e.requestFocus();
      if (TextUtils.isEmpty(this.q)) {
        break label266;
      }
      this.d.setText(this.q);
      this.d.setVisibility(8);
      if (!g()) {
        break label291;
      }
      this.f.setVisibility(0);
      this.g.setVisibility(0);
      this.m.a(this.f.getEditText());
      this.m.a(this.g.getEditText());
      this.o.setVisibility(0);
      this.h.setOnClickListener(this);
      this.a.setOnClickListener(this);
      localStringBuilder = new StringBuilder().append(this.p).append(" ");
      if (!g()) {
        break label320;
      }
    }
    label266:
    label291:
    label320:
    for (String str = com.wifipay.common.a.f.a(R.string.wifipay_credit_card);; str = com.wifipay.common.a.f.a(R.string.wifipay_debit_card))
    {
      this.p = str;
      this.b.setText(this.p);
      return;
      this.m.a(this.c.getEditText(), this.l);
      this.k.setVisibility(0);
      this.n.setText(getString(R.string.wifipay_bankcard_onlyself_note));
      this.k.requestFocus();
      break;
      this.d.setVisibility(0);
      this.m.a(this.d.getEditText());
      break label82;
      this.f.setVisibility(8);
      this.g.setVisibility(8);
      this.o.setVisibility(4);
      break label141;
    }
  }
  
  private boolean g()
  {
    return "CR".equalsIgnoreCase((String)this.i.additionalParams.get("cardType"));
  }
  
  protected void e()
  {
    if (!com.wifipay.wallet.common.utils.f.d(this.d.getText())) {
      a(com.wifipay.common.a.f.a(R.string.wifipay_personal_idcard_info));
    }
    for (;;)
    {
      return;
      if (!com.wifipay.wallet.common.utils.f.b(this.e.getText()))
      {
        a(com.wifipay.common.a.f.a(R.string.wifipay_mobile_invalid_patten));
      }
      else
      {
        this.i.additionalParams.put("trueName", this.c.getText().replaceAll(" ", ""));
        this.i.additionalParams.put("certNo", this.d.getText());
        this.i.additionalParams.put("mobile", this.e.getText());
        this.i.additionalParams.put("isSign", "true");
        this.i.additionalParams.put("validDate", this.f.getText());
        this.i.additionalParams.put("cvv2", this.g.getText());
        if (CashierType.CALLAPPPAY.getType().equals(this.i.type)) {
          this.i.type = CashierType.NEWCARDPAY.getType();
        }
        if (CashierType.DEPOSIT.getType().equals(this.i.type)) {
          this.i.type = CashierType.NEWDEPOSITPAY.getType();
        }
        if (CashierType.TRANSFER.getType().equals(this.i.type)) {
          this.i.type = CashierType.NEWTRANSFERPAY.getType();
        }
        com.wifipay.wallet.cashier.a.a(c(), this.i, null).a((String)this.i.additionalParams.get("payPwd"));
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_bindcard_btn_next) {
      e();
    }
    if (paramView.getId() == R.id.wifipay_pp_prompt_text) {
      HomeWebActivity.a(getActivity(), "https://css.shengpay.com/html/instruction/view/wifi.html");
    }
    for (;;)
    {
      return;
      if (paramView.getId() == R.id.wifipay_bindcard_name_note)
      {
        a(getString(R.string.wifipay_cardholders_that), getString(R.string.wifipay_band_card_note), getString(R.string.wifipay_alert_btn_i_know), null, null, null);
      }
      else if (paramView.getId() == R.id.wifipay_bindcard_phone_note)
      {
        paramView = LayoutInflater.from(c()).inflate(R.layout.wifipay_mobile_phone_description, null);
        a(getString(R.string.wifipay_phone_numble_that), getString(R.string.wifipay_alert_btn_i_know), null, paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.i = ((StartPayParams)getArguments().getSerializable("pay_params"));
    this.p = ((String)this.i.additionalParams.get("bankName"));
    this.r = ((String)this.i.additionalParams.get("trueName"));
    this.q = ((String)this.i.additionalParams.get("certNo"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.wifipay_fragment_new_card_detail, null);
    this.b = ((WPTwoTextView)paramLayoutInflater.findViewById(R.id.wifipay_bindcard_card_info));
    this.d = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_bindcard_card_own_id));
    this.c = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_bindcard_card_own_name));
    this.e = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_bindcard_card_own_phone));
    this.f = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_bindcard_card_except_time));
    this.g = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_bindcard_card_mask_code));
    this.a = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_pp_prompt_text));
    this.h = ((Button)paramLayoutInflater.findViewById(R.id.wifipay_bindcard_btn_next));
    this.n = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_bankcard_bottom_note));
    this.o = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_verify_account));
    this.l = paramLayoutInflater.findViewById(R.id.wifipay_bindcard_name_note);
    paramViewGroup = paramLayoutInflater.findViewById(R.id.wifipay_bindcard_phone_note);
    this.k = paramLayoutInflater.findViewById(R.id.wifipay_bindcard_rlname_note);
    this.j = ((WPCheckBox)paramLayoutInflater.findViewById(R.id.wifipay_agree_protocol));
    this.l.setOnClickListener(this);
    paramViewGroup.setOnClickListener(this);
    this.m = new c(this.h);
    this.m.a(this.j);
    this.m.a(this.e.getEditText(), paramViewGroup);
    f();
    return paramLayoutInflater;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/ui/fragment/NewCardDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */