package com.wifipay.sdk.util;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class g
{
  public static boolean a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    paramString1 = new X509EncodedKeySpec(b.a(paramString1));
    PublicKey localPublicKey = KeyFactory.getInstance("RSA").generatePublic(paramString1);
    paramString1 = Signature.getInstance("SHA1WithRSA");
    paramString1.initVerify(localPublicKey);
    paramString1.update(paramArrayOfByte);
    return paramString1.verify(b.a(paramString2));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/util/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */