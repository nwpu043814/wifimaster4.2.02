package com.wifipay.wallet.cashier.b;

import android.content.Intent;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.common.logging.Logger;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.a.d;
import com.wifipay.wallet.authentication.activity.TakePhotoActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.cashier.ui.PasswordActivity;
import com.wifipay.wallet.cashier.ui.SMSValidatorActivity;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.paypassword.PPService;
import com.wifipay.wallet.prod.paypassword.QueryDigitPwdResp;
import java.util.HashMap;

public abstract class a
{
  protected int a = -1;
  protected SuperActivity b;
  protected StartPayParams c;
  private PayListener d;
  
  protected a(SuperActivity paramSuperActivity, PayListener paramPayListener)
  {
    this.b = paramSuperActivity;
    this.d = paramPayListener;
  }
  
  public a a(StartPayParams paramStartPayParams)
  {
    this.c = paramStartPayParams;
    return this;
  }
  
  public void a()
  {
    if (!EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().register(this);
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    com.wifipay.wallet.common.info.b.a().c().setWalletState(paramInt);
  }
  
  protected void a(Intent paramIntent)
  {
    this.b.startActivity(paramIntent);
  }
  
  public void a(QueryDigitPwdResp paramQueryDigitPwdResp)
  {
    String str = paramQueryDigitPwdResp.resultCode;
    if (ResponseCode.ACCOUNT_NOT_EXISTS.getCode().equals(str))
    {
      this.a = 1;
      if (this.a != -1) {
        break label100;
      }
      this.b.d();
      this.b.a(paramQueryDigitPwdResp.resultMessage);
    }
    for (;;)
    {
      return;
      if (ResponseCode.NO_DIGIT_PWD.getCode().equals(str))
      {
        this.a = 2;
        break;
      }
      if (ResponseCode.SUCCESS.getCode().equals(str))
      {
        this.a = 3;
        break;
      }
      this.a = -1;
      break;
      label100:
      a(this.a, paramQueryDigitPwdResp.resultMessage);
    }
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      this.b.a(com.wifipay.common.a.f.a(R.string.wifipay_remindertitle), paramString, com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_upload_now), new b(this), com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_upload_delay), new c(this));
    }
    for (;;)
    {
      return;
      if (paramInt == 1) {
        this.b.a(com.wifipay.common.a.f.a(R.string.wifipay_remindertitle), paramString, com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_upload_now), new e(this), null, null);
      } else if (paramInt == 2) {
        this.b.a(com.wifipay.common.a.f.a(R.string.wifipay_remindertitle), paramString, com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_add_now), new f(this), com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_i_know), null);
      } else {
        this.b.a(com.wifipay.common.a.f.a(R.string.wifipay_remindertitle), paramString, com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_i_know), null, null, null);
      }
    }
  }
  
  protected void a(String paramString1, String paramString2) {}
  
  public void b()
  {
    EventBus.getDefault().unregister(this);
  }
  
  protected void c()
  {
    if (com.wifipay.wallet.common.utils.f.b(this.b)) {
      throw new IllegalArgumentException("AbstractPayPlugin-mActivity is null");
    }
    if (com.wifipay.wallet.common.utils.f.b(this.c)) {
      throw new IllegalArgumentException("AbstractPayPlugin-mPayParams is null");
    }
  }
  
  public abstract void d();
  
  protected void e()
  {
    this.a = com.wifipay.wallet.common.info.b.a().j();
    if (this.a == -1) {
      a(((PPService)RpcService.getRpcProxy(PPService.class)).queryDigitPwd(String.valueOf(System.currentTimeMillis())));
    }
    for (;;)
    {
      return;
      a(this.a, null);
    }
  }
  
  public void f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bindcardsource", this.c.type);
    new com.wifipay.wallet.card.a.a(this.b).a(localHashMap);
  }
  
  public void g()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bindcardsource", CashierType.BINDCARD.getType());
    new com.wifipay.wallet.card.a.a(this.b).a(localHashMap);
  }
  
  public void h()
  {
    Intent localIntent = new Intent(this.b, PasswordActivity.class);
    localIntent.putExtra("pay_params", this.c);
    a(localIntent);
  }
  
  @Subscribe(sticky=true)
  public void handleBindCardEvent(com.wifipay.wallet.a.b paramb)
  {
    Logger.v("zhao BindCardEvent mPayParams.type == %s", new Object[] { this.c.type });
    Logger.v("zhao BindCardEvent mPayParams.type== %s", new Object[] { this.c.type });
    if (this.c.type.equals(paramb.a))
    {
      EventBus.getDefault().removeStickyEvent(paramb);
      a(paramb.b, paramb.c);
    }
  }
  
  @Subscribe(priority=1, sticky=true, threadMode=ThreadMode.MAIN)
  public void handlePayCompleteEvent(d paramd)
  {
    Logger.v("zhao mPayParams.type == %s", new Object[] { this.c.type });
    Logger.v("zhao event.cashierType == %s", new Object[] { paramd.a });
    if (this.c.type.equals(paramd.a))
    {
      EventBus.getDefault().removeStickyEvent(paramd);
      if (com.wifipay.wallet.common.utils.f.a(this.d)) {
        this.d.payFinish(paramd.b, paramd.c);
      }
    }
  }
  
  public void i()
  {
    Intent localIntent = new Intent(this.b, SMSValidatorActivity.class);
    localIntent.putExtra("pay_params", this.c);
    a(localIntent);
  }
  
  protected void j()
  {
    a(new Intent(this.b, TakePhotoActivity.class));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */