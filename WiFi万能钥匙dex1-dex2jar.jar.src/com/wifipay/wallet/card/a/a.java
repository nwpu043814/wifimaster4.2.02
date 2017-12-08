package com.wifipay.wallet.card.a;

import android.content.Intent;
import com.wifipay.R.string;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.ui.PasswordSingleVerifyActivity;
import com.wifipay.wallet.common.info.AppInfo;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.paypassword.PPService;
import com.wifipay.wallet.prod.paypassword.QueryDigitPwdResp;
import java.util.HashMap;

public class a
{
  private SuperActivity a;
  private HashMap<String, String> b;
  
  public a(SuperActivity paramSuperActivity)
  {
    this.a = paramSuperActivity;
  }
  
  private void a()
  {
    Intent localIntent = new Intent("com.wifipay.action.BIND_CARD");
    localIntent.putExtra("local_data", this.b);
    this.a.startActivity(localIntent);
  }
  
  private void a(int paramInt, String paramString)
  {
    com.wifipay.wallet.common.info.b.a().c().setWalletState(paramInt);
    if (paramInt == 2)
    {
      a();
      return;
    }
    paramString = new Intent("com.wifipay.action.BIND_CARD");
    paramString.putExtra("local_data", this.b);
    AppInfo.INSTANCE.setNextIntent(paramString);
    if (com.wifipay.wallet.common.utils.f.a(this.b))
    {
      paramString = (String)this.b.get("bindcardsource");
      if (CashierType.BINDCARD.getType().equals(paramString)) {}
    }
    for (boolean bool = true;; bool = false)
    {
      paramString = new Intent(this.a, PasswordSingleVerifyActivity.class);
      paramString.putExtra("save_ped", bool);
      paramString.putExtra("title", com.wifipay.common.a.f.a(R.string.wifipay_add_new_card));
      this.a.startActivity(paramString);
      break;
    }
  }
  
  public void a(QueryDigitPwdResp paramQueryDigitPwdResp)
  {
    String str = paramQueryDigitPwdResp.resultCode;
    int i;
    if (ResponseCode.ACCOUNT_NOT_EXISTS.getCode().equals(str)) {
      i = 1;
    }
    for (;;)
    {
      if (i == -1) {
        this.a.a(paramQueryDigitPwdResp.resultMessage);
      }
      for (;;)
      {
        return;
        if (ResponseCode.NO_DIGIT_PWD.getCode().equals(str))
        {
          i = 2;
          break;
        }
        if (!ResponseCode.SUCCESS.getCode().equals(str)) {
          break label85;
        }
        i = 3;
        break;
        a(i, paramQueryDigitPwdResp.resultMessage);
      }
      label85:
      i = -1;
    }
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.b = paramHashMap;
    int i = com.wifipay.wallet.common.info.b.a().j();
    if (i == -1) {
      BackgroundExecutor.a(new b(this, (PPService)RpcService.getRpcProxy(PPService.class)));
    }
    for (;;)
    {
      return;
      a(i, null);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/card/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */