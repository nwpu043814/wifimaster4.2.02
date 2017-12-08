package com.wifipay.wallet;

import android.content.Intent;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.home.ui.HomeActivity;
import com.wifipay.wallet.prod.user.ThirdLoginResp;
import com.wifipay.wallet.prod.user.ThirdLoginResp.ResultObject;

public class SecondLogin
{
  private SuperActivity a;
  private Intent b;
  private onSaveAfter c;
  
  public SecondLogin(SuperActivity paramSuperActivity, Intent paramIntent)
  {
    this.a = paramSuperActivity;
    this.b = paramIntent;
  }
  
  private void a(ThirdLoginResp paramThirdLoginResp)
  {
    if ((paramThirdLoginResp != null) && (paramThirdLoginResp.resultObject != null) && (paramThirdLoginResp.resultCode.equals(ResponseCode.SUCCESS.getCode())))
    {
      b.a().c().setAccessToken(paramThirdLoginResp.resultObject.thirdToken);
      b.a().c().setLoginName(paramThirdLoginResp.resultObject.loginName);
      b.a().c().setMemberId(paramThirdLoginResp.resultObject.memberId);
      if (this.c != null) {
        this.c.success();
      }
      for (;;)
      {
        return;
        this.a.startActivity(new Intent(this.a, HomeActivity.class));
        com.wifipay.framework.app.a.b();
      }
    }
    SuperActivity localSuperActivity = this.a;
    if (paramThirdLoginResp != null) {}
    for (paramThirdLoginResp = paramThirdLoginResp.resultMessage;; paramThirdLoginResp = "登录失败")
    {
      localSuperActivity.a(paramThirdLoginResp, "退出", new c(this));
      break;
    }
  }
  
  public void a(onSaveAfter paramonSaveAfter)
  {
    this.c = paramonSaveAfter;
    if ((this.b == null) || (this.a == null)) {}
    for (;;)
    {
      return;
      String str2 = this.b.getStringExtra("uhid");
      String str1 = this.b.getStringExtra("userToken");
      paramonSaveAfter = b.a().c();
      paramonSaveAfter.setOutToken(str1);
      paramonSaveAfter.setUhId(str2);
      BackgroundExecutor.a(new a(this, str1, str2));
    }
  }
  
  public static abstract interface onSaveAfter
  {
    public abstract void success();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/SecondLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */