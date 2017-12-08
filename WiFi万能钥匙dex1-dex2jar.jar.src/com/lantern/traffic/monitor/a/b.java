package com.lantern.traffic.monitor.a;

import com.lantern.core.g.n;
import com.lantern.core.model.f;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class b
  extends a
{
  private static final b f = new b();
  
  private b()
  {
    this.d = n.a().b;
    this.e = n.a().c;
    this.a = new IvParameterSpec(this.e.getBytes());
    this.b = new SecretKeySpec(this.d.getBytes(), "AES");
    try
    {
      this.c = Cipher.getInstance("AES/CBC/NoPadding");
      return;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        localNoSuchAlgorithmException.printStackTrace();
      }
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      for (;;)
      {
        localNoSuchPaddingException.printStackTrace();
      }
    }
  }
  
  public static final b a()
  {
    return f;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/monitor/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */