package com.wifipay.wallet.paypassword.common;

import android.content.Intent;
import com.wifipay.R.id;
import com.wifipay.common.logging.Logger;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.paypassword.ui.RetrievePPActivity;
import com.wifipay.wallet.prod.security.account.AccountManagerService;

class d
  extends BackgroundExecutor.a
{
  d(PreRetrievePP paramPreRetrievePP) {}
  
  public void a()
  {
    Object localObject = (AccountManagerService)RpcService.getRpcProxy(AccountManagerService.class);
    if (!PreRetrievePP.a(this.a, ((AccountManagerService)localObject).queryRealName(String.valueOf(System.currentTimeMillis()))))
    {
      Logger.v("zhao == %s", new Object[] { "未实名" });
      if (b.a().j() == 2) {
        PreRetrievePP.a(this.a);
      }
    }
    for (;;)
    {
      return;
      if (com.wifipay.wallet.common.utils.d.a(b.a().k(), "0") <= 0)
      {
        localObject = new Intent(PreRetrievePP.b(this.a), RetrievePPActivity.class);
        ((Intent)localObject).putExtra("which_fragment", R.id.wifipay_fragment_pp_sms);
        PreRetrievePP.b(this.a).startActivity((Intent)localObject);
      }
      else
      {
        PreRetrievePP.c(this.a);
        continue;
        Logger.v("zhao == %s", new Object[] { "实名" });
        BackgroundExecutor.a(new e(this));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/common/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */