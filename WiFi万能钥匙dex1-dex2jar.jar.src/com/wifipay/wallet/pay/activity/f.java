package com.wifipay.wallet.pay.activity;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.cert.CertService;
import com.wifipay.wallet.prod.cert.RSARes;
import com.wifipay.wallet.prod.cert.RSARes.ResultObject;

class f
  extends BackgroundExecutor.a
{
  f(WifiPayEntryActivity paramWifiPayEntryActivity) {}
  
  public void a()
  {
    RSARes localRSARes = ((CertService)RpcService.getRpcProxy(CertService.class)).getRSACert("1");
    if ((localRSARes != null) && (localRSARes.resultObject != null))
    {
      UserInfo localUserInfo = b.a().c();
      localUserInfo.setCert(localRSARes.resultObject.cert);
      localUserInfo.setCertSerialNo(localRSARes.resultObject.certSerialNo);
      WifiPayEntryActivity.d(this.a);
    }
    for (;;)
    {
      return;
      WifiPayEntryActivity.a(this.a, localRSARes.resultMessage);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/pay/activity/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */