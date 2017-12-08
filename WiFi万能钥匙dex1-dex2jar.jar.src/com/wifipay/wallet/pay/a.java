package com.wifipay.wallet.pay;

import com.wifipay.common.logging.Logger;
import com.wifipay.common.security.Base64;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.prod.pay.WifiPayReq;
import java.net.URLDecoder;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class a
{
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (paramString.length() != 0) {
        break label19;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label19:
      int i = paramString.lastIndexOf("&");
      bool1 = bool2;
      if (paramString.length() > i)
      {
        String str = paramString.substring(0, i + 1);
        paramString = paramString.substring(i + 1);
        try
        {
          bool1 = a(str.getBytes("UTF-8"), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCigSSLnWRyc+aGRzN9Rzp8XIjYk8rcAfbBhTS6zOSIf7S8YP7SCQI/346JkYuyyhrxcej50X/i1QnXG7GO1jq96Fd0/szYBb/K0yhmof46Na0z4f1M9ZCQxYYeGY5Vi+mQKMam1ku+rd8KzfdkXTxOI28QCvN4tDJihgVtSB9tlwIDAQAB", URLDecoder.decode(paramString, "UTF-8"));
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          bool1 = bool2;
        }
      }
    }
  }
  
  private static boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    paramString1 = new X509EncodedKeySpec(Base64.decode(paramString1));
    paramString1 = KeyFactory.getInstance("RSA").generatePublic(paramString1);
    Signature localSignature = Signature.getInstance("SHA1WithRSA");
    localSignature.initVerify(paramString1);
    localSignature.update(paramArrayOfByte);
    return localSignature.verify(Base64.decode(paramString2));
  }
  
  public static WifiPayReq b(String paramString)
  {
    String[] arrayOfString = paramString.split("&");
    WifiPayReq localWifiPayReq = new WifiPayReq();
    try
    {
      paramString = new java/lang/StringBuilder;
      paramString.<init>("array = ");
      Logger.v("kyo", new Object[] { arrayOfString.length });
      localWifiPayReq.merchantOrderNo = arrayOfString[0];
      localWifiPayReq.merchantNo = arrayOfString[1];
      localWifiPayReq.goodsName = arrayOfString[2];
      String str = arrayOfString[3];
      paramString = str;
      if (str != null)
      {
        paramString = str;
        if (str.length() != 0)
        {
          paramString = new java/lang/StringBuilder;
          paramString.<init>();
          paramString = Float.valueOf(str).floatValue() / 100.0F;
        }
      }
      localWifiPayReq.orderAmount = paramString;
      localWifiPayReq.notifyUrl = arrayOfString[4];
      localWifiPayReq.merchantName = arrayOfString[5];
      localWifiPayReq.wifi_token = b.a().l();
      localWifiPayReq.uhId = b.a().m();
      paramString = localWifiPayReq;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
    return paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/pay/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */