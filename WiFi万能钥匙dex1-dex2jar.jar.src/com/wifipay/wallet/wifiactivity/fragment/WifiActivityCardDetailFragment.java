package com.wifipay.wallet.wifiactivity.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.wifipay.R.color;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.framework.api.b;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.framework.widget.WPCheckBox;
import com.wifipay.framework.widget.WPEditTextView;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.d;
import com.wifipay.wallet.home.ui.HomeWebActivity;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.wifiactivity.WifiActivityCheckResp;
import com.wifipay.wallet.prod.wifiactivity.WifiActivityCheckResp.ResultObject;
import com.wifipay.wallet.prod.wifiactivity.WifiActivityService;
import com.wifipay.wallet.wifiactivity.activity.WifiActivitySMS;
import java.util.HashMap;

public class WifiActivityCardDetailFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private TextView a;
  private ImageView b;
  private WPEditTextView c;
  private WPEditTextView d;
  private WPEditTextView e;
  private WPEditTextView f;
  private WPEditTextView g;
  private WPEditTextView h;
  private Button i;
  private b j;
  private StartPayParams k;
  private WPCheckBox l;
  private TextView m;
  
  private void e()
  {
    this.m.setText(c().getResources().getString(R.string.wifipay_card_info_input));
    f();
    if (g())
    {
      this.f.setVisibility(0);
      this.g.setVisibility(0);
      this.j.a(this.f.getEditText());
      this.j.a(this.g.getEditText());
      this.f.requestFocus();
    }
    this.j.a(this.i);
    this.i.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.k.additionalParams.get("bankCode");
    Object localObject = (String)this.k.additionalParams.get("bankName");
    String str3 = (String)this.k.additionalParams.get("cardNo");
    String str1 = (String)this.k.additionalParams.get("trueName");
    String str2 = (String)this.k.additionalParams.get("certNo");
    StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
    if (g())
    {
      localObject = com.wifipay.common.a.f.a(R.string.wifipay_card_type_cr);
      localObject = (String)localObject;
      str3 = (String)localObject + " (*" + str3.substring(str3.length() - 4) + ")";
      localObject = d.a(str3, str3.indexOf((String)localObject), ((String)localObject).length(), com.wifipay.common.a.f.b(R.color.wifipay_color_0285f0));
      this.h.setText((CharSequence)localObject);
      this.h.setEnabled(false);
      if (!g.c(str1)) {
        break label369;
      }
      this.c.setText(str1);
      this.c.setEnabled(false);
      label335:
      if (!g.c(str2)) {
        break label404;
      }
      this.d.setText(str2);
      this.d.setEnabled(false);
    }
    for (;;)
    {
      return;
      localObject = com.wifipay.common.a.f.a(R.string.wifipay_card_type_dr);
      break;
      label369:
      if (!g()) {
        this.c.requestFocus();
      }
      this.c.setEnabled(true);
      this.c.setText("");
      break label335;
      label404:
      this.d.setEnabled(true);
      this.d.setText("");
    }
  }
  
  private void f()
  {
    this.j.a(this.d.getEditText());
    this.j.a(this.c.getEditText());
    this.j.a(this.e.getEditText());
  }
  
  private boolean g()
  {
    return "CR".equalsIgnoreCase((String)this.k.additionalParams.get("cardType"));
  }
  
  private void h()
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
        this.k.additionalParams.put("trueName", this.c.getText().replaceAll(" ", ""));
        this.k.additionalParams.put("certNo", this.d.getText());
        this.k.additionalParams.put("mobile", this.e.getText());
        this.k.additionalParams.put("validDate", this.f.getText());
        this.k.additionalParams.put("cvv2", this.g.getText());
        ((WifiActivityService)RpcService.getBgRpcProxy(WifiActivityService.class)).wifiActivityCheck(this.c.getText().toString().replaceAll(" ", ""), this.d.getText().toString(), (String)this.k.additionalParams.get("cardNo"), this.e.getText().toString(), (String)this.k.additionalParams.get("merchantNo"), (String)this.k.additionalParams.get("merchantOrderNo"), (String)this.k.additionalParams.get("validDate"), (String)this.k.additionalParams.get("cvv2"), (String)this.k.additionalParams.get("bankCode"), (String)this.k.additionalParams.get("cardType"), (String)this.k.additionalParams.get("imei"));
      }
    }
  }
  
  private void i()
  {
    Intent localIntent = new Intent(c(), WifiActivitySMS.class);
    localIntent.putExtra("pay_params", this.k);
    c().startActivity(localIntent);
  }
  
  @Subscribe
  public void handleAfterCheck(WifiActivityCheckResp paramWifiActivityCheckResp)
  {
    d();
    if (ResponseCode.SUCCESS.getCode().equals(paramWifiActivityCheckResp.resultCode)) {
      if (paramWifiActivityCheckResp.resultObject != null)
      {
        String str = paramWifiActivityCheckResp.resultObject.memberId;
        this.k.additionalParams.put("memberId", str);
        this.k.additionalParams.put("requestNo", paramWifiActivityCheckResp.resultObject.requestNo);
        i();
      }
    }
    for (;;)
    {
      return;
      a(paramWifiActivityCheckResp.resultMessage);
    }
  }
  
  public void handlerNullSubscribe(com.wifipay.framework.a.a parama)
  {
    super.handlerNullSubscribe(parama);
    c().finish();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_wifiactivity_detail_btn_next)
    {
      b("");
      h();
    }
    if (paramView.getId() == R.id.wifipay_wifiactivity_prompt_text) {
      HomeWebActivity.a(getActivity(), "https://css.shengpay.com/html/instruction/view/wifi.html");
    }
    if (paramView.getId() == R.id.wifipay_wifiactivity_title_back) {
      c().finish();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.j = new b();
    this.k = ((StartPayParams)getArguments().getSerializable("pay_params"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.wifipay_wifiactivity_fragment_card_detail, null);
    this.m = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_title_content));
    this.h = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_card_item));
    this.a = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_prompt_text));
    this.c = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_card_own_name));
    this.d = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_card_own_id));
    this.e = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_card_own_phone));
    this.f = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_card_except_time));
    this.g = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_card_mask_code));
    this.i = ((Button)paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_detail_btn_next));
    this.b = ((ImageView)paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_title_back));
    this.l = ((WPCheckBox)paramLayoutInflater.findViewById(R.id.wifipay_wifiactivity_prompt_check_box));
    this.l.setListener(new a(this));
    e();
    return paramLayoutInflater;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/wifiactivity/fragment/WifiActivityCardDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */