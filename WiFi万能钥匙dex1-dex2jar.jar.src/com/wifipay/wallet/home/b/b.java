package com.wifipay.wallet.home.b;

import android.content.Context;
import android.text.TextUtils;
import com.shengpay.crypto.JNICrypto;
import com.wifipay.common.a.d;
import com.wifipay.wallet.common.info.AppInfo;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.home.net.HomeInfoService;
import com.wifipay.wallet.home.net.dto.HomeInfoResp;
import com.wifipay.wallet.prod.cert.CertService;
import com.wifipay.wallet.prod.cert.RSARes;
import com.wifipay.wallet.prod.cert.RSARes.ResultObject;
import java.io.File;

public class b
{
  public static final b a = new b();
  private Context b;
  
  public static b a()
  {
    return a;
  }
  
  private void b()
  {
    if (TextUtils.isEmpty(com.wifipay.wallet.common.info.b.a().u()))
    {
      localObject = ((CertService)RpcService.getRpcProxy(CertService.class)).getRSACert("1");
      if ((localObject != null) && (((RSARes)localObject).resultObject != null))
      {
        UserInfo localUserInfo = com.wifipay.wallet.common.info.b.a().c();
        localUserInfo.setCert(((RSARes)localObject).resultObject.cert);
        localUserInfo.setCertSerialNo(((RSARes)localObject).resultObject.certSerialNo);
      }
    }
    Object localObject = AppInfo.INSTANCE.getAppVersion();
    ((HomeInfoService)RpcService.getBgRpcProxy(HomeInfoService.class)).queryHomeInfo(com.wifipay.wallet.common.a.a, (String)localObject);
  }
  
  public HomeInfoResp a(String paramString)
  {
    Object localObject = null;
    File localFile = null;
    if (!d.a(this.b))
    {
      localObject = localFile;
      if (new File(a.b, JNICrypto.sdpEnc1(paramString)).exists()) {
        localObject = a.a().a(paramString);
      }
    }
    for (;;)
    {
      return (HomeInfoResp)localObject;
      localFile = new File(a.b, JNICrypto.sdpEnc1(paramString));
      if (localFile.exists())
      {
        if (a.a(localFile, a.a)) {
          localObject = a.a().a(paramString);
        }
      }
      else
      {
        b();
        continue;
      }
      localObject = a.a().a(paramString);
    }
  }
  
  public void a(Context paramContext)
  {
    this.b = paramContext;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */