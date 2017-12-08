package com.wifipay.wallet.paypassword.ui.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.CountDown;
import com.wifipay.wallet.common.utils.CountDown.OnCountDownListener;
import com.wifipay.wallet.paypassword.ui.ResetPPActivity;
import com.wifipay.wallet.prod.paypassword.PPService;
import com.wifipay.wallet.prod.paypassword.ResetPPSmsResp;
import com.wifipay.wallet.prod.paypassword.ResetPPSmsResp.ResultObject;

public class RetrieviePPSmsFragment
  extends BaseFragment
  implements View.OnClickListener, CountDown.OnCountDownListener
{
  private String a;
  private String b;
  private TextView c;
  private TextView d;
  private EditText e;
  private Button f;
  private com.wifipay.framework.api.b g;
  private CountDown h;
  private String i;
  private String j;
  
  private void a(int paramInt)
  {
    String str = this.b.replace("[count]", String.valueOf(paramInt));
    this.d.setText(str);
  }
  
  private void c(String paramString)
  {
    paramString = this.a.replace("[amount]", paramString);
    this.c.setText(paramString);
  }
  
  private void d(String paramString)
  {
    a(paramString, com.wifipay.common.a.f.a(R.string.wifipay_common_confirm), new b(this));
  }
  
  private void h()
  {
    this.g.a(this.e);
    this.g.a(this.f);
    this.d.setOnClickListener(this);
    this.f.setOnClickListener(this);
    e();
  }
  
  protected void e()
  {
    g();
    ((PPService)RpcService.getBgRpcProxy(PPService.class)).resetPPSendSms(String.valueOf(System.currentTimeMillis()));
  }
  
  protected void f()
  {
    b("");
    ((PPService)RpcService.getBgRpcProxy(PPService.class)).resetPPVerifySms(this.i, this.e.getText().toString());
  }
  
  public void g()
  {
    a(60);
    this.h = new CountDown(60);
    this.h.a(this);
    this.h.a(1000);
    this.d.setEnabled(false);
  }
  
  @Subscribe
  public void handleGetVerifyCode(ResetPPSmsResp paramResetPPSmsResp)
  {
    if (com.wifipay.wallet.common.utils.f.a(paramResetPPSmsResp))
    {
      if (!paramResetPPSmsResp.resultCode.equals(ResponseCode.SUCCESS.getCode())) {
        break label46;
      }
      this.i = paramResetPPSmsResp.resultObject.requestNo;
      c(paramResetPPSmsResp.resultObject.bindMobile);
    }
    for (;;)
    {
      return;
      label46:
      if (paramResetPPSmsResp.resultCode.equals(ResponseCode.RESET_PAY_PWD_NO_BINDMOBILE.getCode()))
      {
        if (this.h != null) {
          this.h.a();
        }
        onCountDownFinished();
      }
      else
      {
        d(paramResetPPSmsResp.resultMessage);
      }
    }
  }
  
  @Subscribe
  public void handleVerifySms(ResetPPSmsResp paramResetPPSmsResp)
  {
    d();
    if (com.wifipay.wallet.common.utils.f.a(paramResetPPSmsResp))
    {
      if (!paramResetPPSmsResp.resultCode.equals(ResponseCode.SUCCESS.getCode())) {
        break label92;
      }
      Intent localIntent = new Intent(c(), ResetPPActivity.class);
      localIntent.putExtra("result", paramResetPPSmsResp.resultObject.requestNo);
      if (!g.a(this.j)) {
        localIntent.putExtra("cashier_type", this.j);
      }
      c().startActivity(localIntent);
      c().finish();
    }
    for (;;)
    {
      return;
      label92:
      d(paramResetPPSmsResp.resultMessage);
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_pp_sms_btn_commit) {
      f();
    }
    if (paramView.getId() == R.id.wifipay_btn_get_code) {
      e();
    }
  }
  
  public void onCountDownFinished()
  {
    this.d.setEnabled(true);
    this.d.setText(R.string.wifipay_verify_code_get);
  }
  
  public void onCountDownRun(int paramInt1, int paramInt2)
  {
    a(paramInt2);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = new com.wifipay.framework.api.b();
    this.a = getResources().getString(R.string.wifipay_input_sms_code_by_account);
    this.b = getResources().getString(R.string.wifipay_verify_code_get_again);
    this.j = getArguments().getString("cashier_type");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.wifipay_fragment_retrieve_pp_sms, null);
    this.e = ((EditText)paramLayoutInflater.findViewById(R.id.wifipay_verify_code));
    this.d = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_btn_get_code));
    this.c = ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_pp_sms_note));
    this.f = ((Button)paramLayoutInflater.findViewById(R.id.wifipay_pp_sms_btn_commit));
    h();
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.h != null) {
      this.h.a();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/fragment/RetrieviePPSmsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */