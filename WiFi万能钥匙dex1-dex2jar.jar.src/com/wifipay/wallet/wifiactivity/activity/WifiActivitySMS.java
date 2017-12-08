package com.wifipay.wallet.wifiactivity.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.anim;
import com.wifipay.R.color;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.widget.WPButton;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.CountDown;
import com.wifipay.wallet.common.utils.CountDown.OnCountDownListener;
import com.wifipay.wallet.prod.core.model.PayCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.wifiactivity.WifiActivityCheckResp;
import com.wifipay.wallet.prod.wifiactivity.WifiActivityCheckResp.ResultObject;
import com.wifipay.wallet.prod.wifiactivity.WifiActivityPayResp;
import com.wifipay.wallet.prod.wifiactivity.WifiActivityPayResp.ResultObject;
import com.wifipay.wallet.prod.wifiactivity.WifiActivityService;
import java.util.HashMap;
import java.util.Map;

public class WifiActivitySMS
  extends BaseActivity
  implements View.OnClickListener, CountDown.OnCountDownListener
{
  private TextView h;
  private TextView i;
  private EditText j;
  private View k;
  private WPButton l;
  private CountDown m;
  private HashMap<String, String> n;
  private String o;
  private String p;
  private Animation q;
  private Animation r;
  private PayCard s;
  private TextView t;
  private Animation.AnimationListener u = new b(this);
  
  static
  {
    StubApp1053578832.interface11(140);
  }
  
  private void a(int paramInt, BaseResp paramBaseResp)
  {
    EventBus.getDefault().postSticky(new com.wifipay.wallet.a.d(this.p, paramInt, paramBaseResp));
    EventBus.getDefault().post(new com.wifipay.framework.a.a());
    finish();
  }
  
  private void e(int paramInt)
  {
    String str = this.o.replace("[count]", String.valueOf(paramInt));
    this.h.setText(str);
  }
  
  private void e(String paramString)
  {
    a(paramString, com.wifipay.common.a.f.a(R.string.wifipay_common_repeat), new c(this));
  }
  
  private void i()
  {
    StartPayParams localStartPayParams = (StartPayParams)getIntent().getSerializableExtra("pay_params");
    if (com.wifipay.wallet.common.utils.f.a(localStartPayParams))
    {
      this.n = localStartPayParams.additionalParams;
      this.p = localStartPayParams.type;
      this.s = localStartPayParams.chosenCard;
      return;
    }
    throw new IllegalArgumentException("WifiActivitySMS pay params null!");
  }
  
  private void j()
  {
    this.q = AnimationUtils.loadAnimation(this, R.anim.wifipay_anim_sms_dialog_enter);
    this.r = AnimationUtils.loadAnimation(this, R.anim.wifipay_anim_sms_dialog_exit);
    this.r.setAnimationListener(this.u);
    this.q.setAnimationListener(this.u);
    this.o = com.wifipay.common.a.f.a(R.string.wifipay_verify_code_get_again);
    this.k = findViewById(R.id.wifipay_sms_validator_root);
    this.j = ((EditText)findViewById(R.id.wifipay_sms_verify_code));
    this.h = ((TextView)findViewById(R.id.wifipay_sms_btn_get_code));
    this.t = ((TextView)findViewById(R.id.wifipay_unverification_code));
    this.i = ((TextView)findViewById(R.id.wifipay_sms_validator_phone));
    this.i.setText(getString(R.string.wifipay_validator_phone_sms, new Object[] { k(), com.wifipay.wallet.common.utils.d.k((String)this.n.get("mobile")) }));
    this.l = ((WPButton)findViewById(R.id.wifipay_sms_submit));
    this.h.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.t.setOnClickListener(this);
    com.wifipay.framework.api.b localb2 = new com.wifipay.framework.api.b();
    com.wifipay.framework.api.b localb1 = new com.wifipay.framework.api.b();
    localb2.a(this.i);
    localb2.a(this.h);
    localb1.a(this.j);
    localb1.a(this.l);
    o();
  }
  
  private String k()
  {
    if (TextUtils.equals(this.p, CashierType.CALLAPPPAY.getType())) {}
    for (String str = getString(R.string.wifipay_callpay_title);; str = getString(R.string.wifipay_unknown_type)) {
      return str;
    }
  }
  
  private void l()
  {
    Object localObject = getResources().getString(R.string.wifipay_unreceived_auth_code);
    TextView localTextView = (TextView)LayoutInflater.from(this).inflate(R.layout.wifipay_unverification_code, null);
    localObject = new SpannableString((CharSequence)localObject);
    ((SpannableString)localObject).setSpan(new URLSpan("tel:4007208888"), ((SpannableString)localObject).length() - 11, ((SpannableString)localObject).length() - 1, 33);
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(getResources().getColor(R.color.wifipay_color_0285f0)), ((SpannableString)localObject).length() - 11, ((SpannableString)localObject).length() - 1, 33);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setText((CharSequence)localObject);
    a("收不到验证码", "知道了", null, localTextView);
  }
  
  private void m()
  {
    this.k.startAnimation(this.r);
  }
  
  private void n()
  {
    a(((WifiActivityService)RpcService.getRpcProxy(WifiActivityService.class)).wifiActivityCheck((String)this.n.get("trueName"), (String)this.n.get("certNo"), (String)this.n.get("cardNo"), (String)this.n.get("mobile"), (String)this.n.get("merchantNo"), (String)this.n.get("merchantOrderNo"), (String)this.n.get("validDate"), (String)this.n.get("cvv2"), (String)this.n.get("bankCode"), (String)this.n.get("cardType"), (String)this.n.get("imei")));
  }
  
  private void o()
  {
    this.j.requestFocus();
    e(60);
    this.m = new CountDown(60);
    this.m.a(this);
    this.m.a(1000);
    this.h.setEnabled(false);
  }
  
  private void p()
  {
    c("");
    ((WifiActivityService)RpcService.getBgRpcProxy(WifiActivityService.class)).wifiActivityPay((String)this.n.get("memberId"), (String)this.n.get("merchantNo"), (String)this.n.get("merchantOrderNo"), (String)this.n.get("amount"), this.j.getText().toString(), (String)this.n.get("requestNo"), (String)this.n.get("trueName"), (String)this.n.get("certNo"), this.s.paymentType, (String)this.n.get("notifyUrl"), (String)this.n.get("mobile"));
  }
  
  public void a(WifiActivityCheckResp paramWifiActivityCheckResp)
  {
    if (ResponseCode.SUCCESS.getCode().equals(paramWifiActivityCheckResp.resultCode)) {
      this.n.put("requestNo", paramWifiActivityCheckResp.resultObject.requestNo);
    }
    for (;;)
    {
      return;
      b(com.wifipay.common.a.f.a(R.string.wifipay_sms_code_note));
      this.m.a();
      onCountDownFinished();
    }
  }
  
  @Subscribe
  public void handleConfrim(WifiActivityPayResp paramWifiActivityPayResp)
  {
    d();
    HashMap localHashMap = new HashMap();
    localHashMap.put("resposeTime", com.wifipay.wallet.common.utils.d.a(System.currentTimeMillis()));
    localHashMap.put("resultCode", paramWifiActivityPayResp.resultCode);
    localHashMap.put("resultMessage", paramWifiActivityPayResp.resultMessage);
    if (paramWifiActivityPayResp.resultObject != null)
    {
      localHashMap.put("bankCode", paramWifiActivityPayResp.resultObject.bankCode);
      localHashMap.put("bankName", paramWifiActivityPayResp.resultObject.bankName);
      localHashMap.put("cardNo", paramWifiActivityPayResp.resultObject.cardNo);
      localHashMap.put("merchantOrderNo", paramWifiActivityPayResp.resultObject.merchantOrderNo);
      localHashMap.put("mobileNo", paramWifiActivityPayResp.resultObject.mobileNo);
      localHashMap.put("payStatus", paramWifiActivityPayResp.resultObject.payStatus);
      localHashMap.put("payStatusDesc", paramWifiActivityPayResp.resultObject.payStatusDesc);
    }
    com.wifipay.wallet.common.utils.a.a(this, "PennyRob", localHashMap);
    if ((ResponseCode.HPS_VALIDCODE_ERROR.getCode().equals(paramWifiActivityPayResp.resultCode)) || (ResponseCode.MAS_CODE_8.getCode().equals(paramWifiActivityPayResp.resultCode)) || (ResponseCode.MAS_CODE_17.getCode().equals(paramWifiActivityPayResp.resultCode))) {
      e(paramWifiActivityPayResp.resultMessage);
    }
    for (;;)
    {
      return;
      if (ResponseCode.SUCCESS.getCode().equals(paramWifiActivityPayResp.resultCode))
      {
        a(-1, paramWifiActivityPayResp);
      }
      else
      {
        a(paramWifiActivityPayResp.resultMessage);
        a(0, paramWifiActivityPayResp);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_sms_btn_get_code)
    {
      BackgroundExecutor.a(new a(this));
      o();
    }
    if (paramView.getId() == R.id.wifipay_unverification_code) {
      l();
    }
    if (paramView.getId() == R.id.wifipay_sms_submit) {
      m();
    }
  }
  
  public void onCountDownFinished()
  {
    this.h.setEnabled(true);
    this.h.setText(R.string.wifipay_verify_code_get);
  }
  
  public void onCountDownRun(int paramInt1, int paramInt2)
  {
    e(paramInt2);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(getString(R.string.wifipay_verify_smsphone));
    setContentView(R.layout.wifipay_activity_sms_validator);
    i();
    j();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.m != null) {
      this.m.a();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/wifiactivity/activity/WifiActivitySMS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */