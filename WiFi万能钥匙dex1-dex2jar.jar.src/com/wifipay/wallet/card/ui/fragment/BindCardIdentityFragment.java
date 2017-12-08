package com.wifipay.wallet.card.ui.fragment;

import android.content.Intent;
import android.content.res.Resources;
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
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.framework.api.c;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.framework.widget.WPCheckBox;
import com.wifipay.framework.widget.WPEditTextView;
import com.wifipay.framework.widget.WPTwoTextView;
import com.wifipay.wallet.card.ui.BindCardResultActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.d;
import com.wifipay.wallet.home.ui.HomeWebActivity;
import com.wifipay.wallet.prod.bandcard.BindCardService;
import com.wifipay.wallet.prod.bandcard.dto.BindCardPreSignResp;
import com.wifipay.wallet.prod.bandcard.dto.BindCardPreSignResp.ResultObject;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import java.util.HashMap;
import java.util.Map;

public class BindCardIdentityFragment
  extends BaseFragment
  implements View.OnClickListener, PayListener
{
  private TextView a;
  private WPTwoTextView b;
  private WPEditTextView c;
  private WPEditTextView d;
  private WPEditTextView e;
  private WPEditTextView f;
  private WPEditTextView g;
  private Button h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private com.wifipay.wallet.cashier.b.a o;
  private TextView p;
  private TextView q;
  private WPCheckBox r;
  private View s;
  private View t;
  private View u;
  private c v;
  private String w;
  
  private void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ownerName", this.c.getText());
    localHashMap.put("ownId", this.d.getText());
    localHashMap.put("ownPhone", this.e.getText());
    localHashMap.put("exceptTime", this.f.getText());
    localHashMap.put("maskCode", this.g.getText());
    com.wifipay.wallet.common.utils.a.a(getActivity(), getClass().getSimpleName(), paramString1, paramString2, localHashMap);
  }
  
  private void f()
  {
    if (CashierType.SETPWD.getType().equals(this.w))
    {
      this.s.setVisibility(0);
      this.u.setVisibility(0);
      this.d.setVisibility(0);
      this.v.a(this.c.getEditText(), this.t);
      this.v.a(this.d.getEditText());
      this.d.setHint(getResources().getString(R.string.wifipay_hint_credentials_number));
      this.c.setHint(getResources().getString(R.string.wifipay_hint_card_realname, new Object[] { b.a().i() }));
      this.c.requestFocus();
      this.p.setText(getString(R.string.wifipay_bankcard_message_note));
      if (!h()) {
        break label389;
      }
      this.f.setVisibility(0);
      this.g.setVisibility(0);
      this.v.a(this.f.getEditText());
      this.v.a(this.g.getEditText());
      this.q.setVisibility(0);
    }
    for (;;)
    {
      this.h.setOnClickListener(this);
      this.a.setOnClickListener(this);
      this.b.setText(this.i);
      return;
      if (!TextUtils.isEmpty(this.l))
      {
        this.c.setText(this.l);
        this.s.setVisibility(8);
        this.p.setText(getString(R.string.wifipay_bankcard_message_note));
        this.e.requestFocus();
      }
      for (;;)
      {
        if (TextUtils.isEmpty(this.m)) {
          break label364;
        }
        this.d.setText(this.m);
        this.d.setVisibility(8);
        break;
        this.v.a(this.c.getEditText(), this.t);
        this.s.setVisibility(0);
        this.p.setText(getString(R.string.wifipay_bankcard_onlyself_note));
        this.s.requestFocus();
      }
      label364:
      this.d.setVisibility(0);
      this.v.a(this.d.getEditText());
      break;
      label389:
      this.f.setVisibility(8);
      this.g.setVisibility(8);
      this.q.setVisibility(4);
    }
  }
  
  private void g()
  {
    if (!com.wifipay.wallet.common.utils.f.d(this.d.getText()))
    {
      d();
      a(getResources().getString(R.string.wifipay_personal_idcard_info));
    }
    for (;;)
    {
      return;
      if (!com.wifipay.wallet.common.utils.f.b(this.e.getText()))
      {
        d();
        a(getResources().getString(R.string.wifipay_mobile_invalid_patten));
      }
      else
      {
        ((BindCardService)RpcService.getBgRpcProxy(BindCardService.class)).preSign(this.j, this.k, this.n, this.c.getText().replaceAll(" ", ""), this.d.getText(), this.g.getText(), this.f.getText(), this.e.getText());
      }
    }
  }
  
  private boolean h()
  {
    return "CR".equalsIgnoreCase(this.n);
  }
  
  public void e()
  {
    a("返回", "");
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleCheckAndSendSms(BindCardPreSignResp paramBindCardPreSignResp)
  {
    if (g.a(ResponseCode.SUCCESS.getCode(), paramBindCardPreSignResp.resultCode))
    {
      StartPayParams localStartPayParams = new StartPayParams();
      localStartPayParams.additionalParams = new HashMap();
      localStartPayParams.type = CashierType.BINDCARD.getType();
      localStartPayParams.bindcardsource = getArguments().getString("bindcardsource");
      localStartPayParams.additionalParams.put("requestNo", paramBindCardPreSignResp.resultObject.requestNo);
      localStartPayParams.additionalParams.put("trueName", this.c.getText().replaceAll(" ", ""));
      localStartPayParams.additionalParams.put("certNo", this.d.getText());
      localStartPayParams.additionalParams.put("mobile", this.e.getText());
      localStartPayParams.additionalParams.put("bankCode", this.j);
      localStartPayParams.additionalParams.put("cardType", this.n);
      localStartPayParams.additionalParams.put("cardNo", this.k);
      localStartPayParams.additionalParams.put("cvv2", this.g.getText());
      localStartPayParams.additionalParams.put("validDate", this.f.getText());
      if (this.o == null) {
        this.o = com.wifipay.wallet.cashier.a.a(CashierType.BINDCARD.getType(), c(), this);
      }
      this.o.a(localStartPayParams);
      this.o.d();
    }
    for (;;)
    {
      a("下一步", paramBindCardPreSignResp.resultMessage);
      return;
      a(paramBindCardPreSignResp.resultMessage);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_bindcard_btn_next)
    {
      b("");
      g();
    }
    for (;;)
    {
      return;
      if (paramView.getId() == R.id.wifipay_pp_prompt_text)
      {
        HomeWebActivity.a(getActivity(), "https://css.shengpay.com/html/instruction/view/wifi.html");
      }
      else if (paramView.getId() == R.id.wifipay_bindcard_name_note)
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
    this.n = getArguments().getString("cardType");
    this.i = getArguments().getString("bankName");
    StringBuilder localStringBuilder = new StringBuilder().append(this.i).append(" ");
    if (h()) {}
    for (paramBundle = com.wifipay.common.a.f.a(R.string.wifipay_credit_card);; paramBundle = com.wifipay.common.a.f.a(R.string.wifipay_debit_card))
    {
      this.i = paramBundle;
      this.j = getArguments().getString("bankCode");
      this.k = getArguments().getString("bankNumber");
      this.l = getArguments().getString("trueName");
      this.m = getArguments().getString("certNo");
      this.w = getArguments().getString("bindcardsource");
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(R.layout.wifipay_fragment_new_card_detail, null);
    this.b = ((WPTwoTextView)paramViewGroup.findViewById(R.id.wifipay_bindcard_card_info));
    this.d = ((WPEditTextView)paramViewGroup.findViewById(R.id.wifipay_bindcard_card_own_id));
    this.u = paramViewGroup.findViewById(R.id.wifipay_bindcard_identity_card);
    this.c = ((WPEditTextView)paramViewGroup.findViewById(R.id.wifipay_bindcard_card_own_name));
    this.e = ((WPEditTextView)paramViewGroup.findViewById(R.id.wifipay_bindcard_card_own_phone));
    this.f = ((WPEditTextView)paramViewGroup.findViewById(R.id.wifipay_bindcard_card_except_time));
    this.g = ((WPEditTextView)paramViewGroup.findViewById(R.id.wifipay_bindcard_card_mask_code));
    this.a = ((TextView)paramViewGroup.findViewById(R.id.wifipay_pp_prompt_text));
    this.h = ((Button)paramViewGroup.findViewById(R.id.wifipay_bindcard_btn_next));
    this.p = ((TextView)paramViewGroup.findViewById(R.id.wifipay_bankcard_bottom_note));
    this.q = ((TextView)paramViewGroup.findViewById(R.id.wifipay_verify_account));
    this.t = paramViewGroup.findViewById(R.id.wifipay_bindcard_name_note);
    paramLayoutInflater = paramViewGroup.findViewById(R.id.wifipay_bindcard_phone_note);
    this.s = paramViewGroup.findViewById(R.id.wifipay_bindcard_rlname_note);
    this.r = ((WPCheckBox)paramViewGroup.findViewById(R.id.wifipay_agree_protocol));
    this.t.setOnClickListener(this);
    paramLayoutInflater.setOnClickListener(this);
    this.v = new c(this.h);
    this.v.a(this.r);
    this.v.a(this.e.getEditText(), paramLayoutInflater);
    f();
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.o != null)
    {
      this.o.b();
      this.o = null;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (com.wifipay.wallet.common.utils.f.a(this.o)) {
      this.o.a();
    }
  }
  
  public void payFinish(int paramInt, BaseResp paramBaseResp)
  {
    HashMap localHashMap;
    Intent localIntent;
    if (paramInt == -1) {
      if (com.wifipay.wallet.common.utils.f.a(paramBaseResp))
      {
        localHashMap = new HashMap();
        localHashMap.put("requestLoginName", b.a().f());
        localHashMap.put("resposeTime", d.a(System.currentTimeMillis()));
        localHashMap.put("resposeCode", paramBaseResp.resultCode);
        localHashMap.put("resposeMessage", paramBaseResp.resultMessage);
        localHashMap.put("type", "BindCard");
        localIntent = new Intent(c(), BindCardResultActivity.class);
        if (!ResponseCode.SUCCESS.getCode().equals(paramBaseResp.resultCode)) {
          break label232;
        }
        localIntent.putExtra("bankNo", this.k.substring(this.k.length() - 4));
        localIntent.putExtra("bankName", this.i);
        localIntent.putExtra("which_fragment", R.id.wifipay_fragment_success);
        localHashMap.put("orderBankName", this.i);
        localHashMap.put("orderCardNo", this.k);
      }
    }
    for (;;)
    {
      com.wifipay.wallet.common.utils.a.a(getActivity(), "BindCard", localHashMap);
      startActivity(localIntent);
      c().finish();
      return;
      label232:
      localIntent.putExtra("reason", paramBaseResp.resultMessage);
      localIntent.putExtra("which_fragment", R.id.wifipay_fragment_fail);
    }
  }
  
  public void rePay() {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/card/ui/fragment/BindCardIdentityFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */