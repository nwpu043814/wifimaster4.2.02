package com.wifipay.wallet.paypassword.ui;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard;
import com.wifipay.wallet.prod.paypassword.PPService;

class e
  extends BackgroundExecutor.a
{
  e(ModifyRepeatPPActivity paramModifyRepeatPPActivity) {}
  
  public void a()
  {
    ((PPService)RpcService.getBgRpcProxy(PPService.class)).modifyPayPwd(ModifyRepeatPPActivity.a(this.a), ModifyRepeatPPActivity.b(this.a), ModifyRepeatPPActivity.c(this.a).getPassword(), null);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */