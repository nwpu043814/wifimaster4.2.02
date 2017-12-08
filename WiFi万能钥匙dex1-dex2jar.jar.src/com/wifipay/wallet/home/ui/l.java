package com.wifipay.wallet.home.ui;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.security.query.QueryService;

class l
  extends BackgroundExecutor.a
{
  l(HomeActivity paramHomeActivity) {}
  
  public void a()
  {
    ((QueryService)RpcService.getBgRpcProxy(QueryService.class)).queryWalletBalance(String.valueOf(System.currentTimeMillis()));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */