package com.wifipay.wallet.card.a;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.prod.paypassword.PPService;

class b
  extends BackgroundExecutor.a
{
  b(a parama, PPService paramPPService) {}
  
  public void a()
  {
    this.b.a(this.a.queryDigitPwd(String.valueOf(System.currentTimeMillis())));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/card/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */