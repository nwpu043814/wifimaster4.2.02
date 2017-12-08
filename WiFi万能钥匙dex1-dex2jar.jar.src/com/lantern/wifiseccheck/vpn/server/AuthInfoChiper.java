package com.lantern.wifiseccheck.vpn.server;

import com.alibaba.fastjson.JSON;
import com.lantern.safecommand.security.ClientRequest;
import com.lantern.safecommand.security.a;
import com.lantern.wifiseccheck.LogUtils;
import java.io.UnsupportedEncodingException;
import java.security.KeyPair;

public class AuthInfoChiper
{
  private static final String TAG = "Chiper";
  private KeyPair kp = null;
  
  private byte[] string2ByteArray(String paramString)
  {
    for (;;)
    {
      try
      {
        paramString = paramString.getBytes("utf-8");
        localUnsupportedEncodingException1.printStackTrace();
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        try
        {
          LogUtils.d("Chiper", paramString.toString());
          return paramString;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          for (;;) {}
        }
        localUnsupportedEncodingException1 = localUnsupportedEncodingException1;
        paramString = null;
      }
    }
  }
  
  public byte[] getReqeustByteArrayContent(byte[] paramArrayOfByte, int paramInt)
  {
    String str = a.a(this.kp.getPublic());
    printHexString(paramArrayOfByte);
    paramArrayOfByte = JSON.toJSONString(new ClientByteArrayRequest(str, paramArrayOfByte));
    LogUtils.d("Chiper", "get Reqeust Content Byte Array sourceJsonString " + paramArrayOfByte.length() + "=============\n" + paramArrayOfByte);
    return a.a(paramArrayOfByte, paramInt);
  }
  
  public byte[] getReqeustContent(String paramString, int paramInt)
  {
    return a.a(JSON.toJSONString(new ClientRequest(a.a(this.kp.getPublic()), paramString)), paramInt);
  }
  
  public String getResponseString(String paramString)
  {
    return a.a(paramString, this.kp.getPrivate());
  }
  
  public void printHexString(byte[] paramArrayOfByte)
  {
    String str1 = null;
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str2.length() == 1) {}
      for (str1 = str1 + '0' + str2;; str1 = str1 + str2)
      {
        i++;
        break;
      }
    }
    LogUtils.d("Chiper", "sourct===:" + str1);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/server/AuthInfoChiper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */