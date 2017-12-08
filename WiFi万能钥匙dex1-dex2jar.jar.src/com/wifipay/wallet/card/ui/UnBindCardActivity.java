package com.wifipay.wallet.card.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.dimen;
import com.wifipay.R.id;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.paypassword.common.PreRetrievePP;
import com.wifipay.wallet.paypassword.common.PreRetrievePP.onListener;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard.onPasswordChanged;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox.onCompletedListener;
import com.wifipay.wallet.prod.bandcard.BindCardService;
import com.wifipay.wallet.prod.bandcard.dto.BindCardCancelSignResp;
import java.util.HashMap;
import java.util.Map;

public class UnBindCardActivity
  extends BaseActivity
  implements PreRetrievePP.onListener, WPSafeKeyboard.onPasswordChanged, WPSixInputBox.onCompletedListener
{
  private WPSixInputBox h;
  private WPSafeKeyboard i;
  private String j;
  private String k;
  
  static
  {
    StubApp1053578832.interface11(109);
  }
  
  private void e(String paramString)
  {
    a("", paramString, com.wifipay.common.a.f.a(R.string.wifipay_common_repeat), new c(this), com.wifipay.common.a.f.a(R.string.wifipay_forget_pwd), new d(this));
  }
  
  private void f(String paramString)
  {
    a("", paramString, com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_i_know), new f(this), null, null);
  }
  
  private void g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = getString(R.string.wifipay_bankcard_unband_failed);
    }
    for (;;)
    {
      a("", paramString, com.wifipay.common.a.f.a(R.string.wifipay_common_repeat), new g(this), com.wifipay.common.a.f.a(R.string.wifipay_common_cancel), new h(this));
      return;
    }
  }
  
  private void j()
  {
    this.h = ((WPSixInputBox)findViewById(R.id.wifipay_pp_general_safe_edit));
    this.i = ((WPSafeKeyboard)findViewById(R.id.wifipay_pp_general_safe_keyboard));
    String str = com.wifipay.common.a.f.a(R.string.wifipay_verify_pp_note);
    TextView localTextView = (TextView)findViewById(R.id.wifipay_pp_general_note);
    localTextView.setText(str);
    localTextView.setGravity(17);
    localTextView.setPadding(0, getResources().getDimensionPixelSize(R.dimen.wifipay_xxh_space_9px), 0, 0);
    this.i.setListener(this);
    this.h.setListener(this);
  }
  
  private void k()
  {
    setResult(4097);
    finish();
  }
  
  private void l()
  {
    this.i.deletePassword(true);
  }
  
  private void m()
  {
    new PreRetrievePP(this, this).a();
  }
  
  public void addPassword()
  {
    this.h.c();
  }
  
  public void afterCheck()
  {
    finish();
  }
  
  public void deletePassword(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.h.b();
    }
    for (;;)
    {
      return;
      this.h.a();
    }
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handlePPEvent(com.wifipay.wallet.a.g paramg)
  {
    paramg = new Intent(this, UnBindCardActivity.class);
    paramg.putExtra("agreement_id", this.j);
    paramg.putExtra("card_no", this.k);
    startActivity(paramg);
    overridePendingTransition(0, 0);
    finish();
  }
  
  @Subscribe
  public void handleUnbindcard(BindCardCancelSignResp paramBindCardCancelSignResp)
  {
    d();
    HashMap localHashMap = new HashMap();
    localHashMap.put("requestLoginName", com.wifipay.wallet.common.info.b.a().f());
    localHashMap.put("resposeTime", com.wifipay.wallet.common.utils.d.a(System.currentTimeMillis()));
    localHashMap.put("resposeCode", paramBindCardCancelSignResp.resultCode);
    localHashMap.put("resposeMessage", paramBindCardCancelSignResp.resultMessage);
    localHashMap.put("orderCardNo", this.k);
    localHashMap.put("type", "UnBindCard");
    com.wifipay.wallet.common.utils.a.a(this, "UnBindCard", localHashMap);
    if (ResponseCode.PAY_PWD_LOCKED.getCode().equals(paramBindCardCancelSignResp.resultCode)) {
      f(paramBindCardCancelSignResp.resultMessage);
    }
    for (;;)
    {
      return;
      if (ResponseCode.PAY_PWD_ERROR.getCode().equals(paramBindCardCancelSignResp.resultCode))
      {
        e(paramBindCardCancelSignResp.resultMessage);
      }
      else if (ResponseCode.SUCCESS.getCode().equals(paramBindCardCancelSignResp.resultCode))
      {
        runOnUiThread(new b(this));
        k();
      }
      else
      {
        g(paramBindCardCancelSignResp.resultMessage);
      }
    }
  }
  
  protected void i()
  {
    ((BindCardService)RpcService.getBgRpcProxy(BindCardService.class)).cancelSign(this.j, this.i.getPassword());
  }
  
  public void invokeKeyboard()
  {
    this.i.d();
  }
  
  public void onCompleted(boolean paramBoolean)
  {
    d();
    if (paramBoolean)
    {
      c("");
      i();
    }
    for (;;)
    {
      return;
      runOnUiThread(new a(this));
      b(com.wifipay.common.a.f.a(R.string.wifipay_pwd_crypto_error));
    }
  }
  
  public void onCompletedAdd()
  {
    e();
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/card/ui/UnBindCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */