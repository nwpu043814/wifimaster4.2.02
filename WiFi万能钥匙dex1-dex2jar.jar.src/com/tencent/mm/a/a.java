package com.tencent.mm.a;

import android.util.Base64;
import javax.crypto.Cipher;

public final class a
{
  private Cipher j;
  
  public final String h(String paramString)
  {
    try
    {
      Object localObject = Base64.decode(paramString, 0);
      byte[] arrayOfByte = this.j.doFinal((byte[])localObject);
      localObject = new java/lang/String;
      ((String)localObject).<init>(arrayOfByte, "UTF8");
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = "[des]" + paramString + "|" + localException.toString();
      }
    }
    return paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/mm/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */