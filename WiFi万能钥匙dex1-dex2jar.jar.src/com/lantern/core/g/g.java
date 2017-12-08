package com.lantern.core.g;

import android.content.Context;
import android.text.TextUtils;
import com.bluefay.d.a;
import com.lantern.core.c;
import com.lantern.core.config.Crty5Conf;
import com.lantern.core.config.d;
import com.lantern.core.d.b;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public final class g
{
  private static g a = null;
  private String b = "-----BEGIN CERTIFICATE-----\nMIIFJDCCBAygAwIBAgIJAMHB6qYfQMSHMA0GCSqGSIb3DQEBCwUAMIG0MQswCQYD\nVQQGEwJVUzEQMA4GA1UECBMHQXJpem9uYTETMBEGA1UEBxMKU2NvdHRzZGFsZTEa\nMBgGA1UEChMRR29EYWRkeS5jb20sIEluYy4xLTArBgNVBAsTJGh0dHA6Ly9jZXJ0\ncy5nb2RhZGR5LmNvbS9yZXBvc2l0b3J5LzEzMDEGA1UEAxMqR28gRGFkZHkgU2Vj\ndXJlIENlcnRpZmljYXRlIEF1dGhvcml0eSAtIEcyMB4XDTE3MDMwNjEyMzAwMFoX\nDTIwMDQwNDA0MjUxN1owODEhMB8GA1UECxMYRG9tYWluIENvbnRyb2wgVmFsaWRh\ndGVkMRMwEQYDVQQDDAoqLjUxeTUubmV0MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8A\nMIIBCgKCAQEA6huu9DXBQmBsSwJmz8+6WsUfqaaYwYbTsanThaAK6f4LOvwfl9GK\nOHfj4ltEFQDCgt+6CACnGdDoFxZfqR3ZDfruOK7oA79ekxpVYPiw41tiQ4FiBTIl\nklV0N8jhVLQXxweoqXp0bfH3Ks/Cye6Y62rUA9/O62DLeqBzXFivmKeWteH/VX27\nzVwNSUw4Wg4VHpWAqzsdq7XSSLk8hCnlyjXB4aJazzo3rMFvbXuaGn1EF2wOARVw\ngHktRbbpiuUUCiJWh8ByGowY/Vfevi0a5/c61mq77To0IYsjQ2fLISqF5UNp+T0W\n0cVShdt4pld7yIxFNsz3gOyzlFiWOxkPswIDAQABo4IBsjCCAa4wDAYDVR0TAQH/\nBAIwADAdBgNVHSUEFjAUBggrBgEFBQcDAQYIKwYBBQUHAwIwDgYDVR0PAQH/BAQD\nAgWgMDcGA1UdHwQwMC4wLKAqoCiGJmh0dHA6Ly9jcmwuZ29kYWRkeS5jb20vZ2Rp\nZzJzMS00MzEuY3JsMF0GA1UdIARWMFQwSAYLYIZIAYb9bQEHFwEwOTA3BggrBgEF\nBQcCARYraHR0cDovL2NlcnRpZmljYXRlcy5nb2RhZGR5LmNvbS9yZXBvc2l0b3J5\nLzAIBgZngQwBAgEwdgYIKwYBBQUHAQEEajBoMCQGCCsGAQUFBzABhhhodHRwOi8v\nb2NzcC5nb2RhZGR5LmNvbS8wQAYIKwYBBQUHMAKGNGh0dHA6Ly9jZXJ0aWZpY2F0\nZXMuZ29kYWRkeS5jb20vcmVwb3NpdG9yeS9nZGlnMi5jcnQwHwYDVR0jBBgwFoAU\nQMK9J47MNIMwojPX+2yz8LQsgM4wHwYDVR0RBBgwFoIKKi41MXk1Lm5ldIIINTF5\nNS5uZXQwHQYDVR0OBBYEFF14Wf0rO/5JcLPI/7cIO6K/+Y0RMA0GCSqGSIb3DQEB\nCwUAA4IBAQC3l4DDkwC0RKvaknO359zNFpFXi76Yjl1kibWWcYCLGE1/Ce2joiVx\njrt9/D0IosfyIR6boTj23xkAuE1Zr/8gQF2kKhJ/UveDdeS6c09GrfkPwBJud7YL\n+Jkvb3fzzD9JcRQdvyilaQXwGcztxv1OtgW8HFQA1zU6a1noK0UKfk52XXvhA6ia\ns4j8HbUm9nXbzJwrCjesqBdrckovHguBB8T84883Naig2F69siolNJJm8Knc4Wgj\nPkR7cwi8RXWUw5vWnFLc2Wxltg6Q5+85qz+ovBh1mXKD0Vx4XB7wJMgJGetF806c\nW/d7zPaBpoSSXADZFk1i35UsmdQMgViI\n-----END CERTIFICATE-----";
  
  public static g a()
  {
    if (a == null) {
      a = new g();
    }
    return a;
  }
  
  private void a(String paramString1, String paramString2)
  {
    try
    {
      String str = a.getAppContext().getFilesDir().getPath();
      h localh = new com/lantern/core/g/h;
      localh.<init>(this, paramString2);
      b.a(paramString1, str, localh);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        com.bluefay.b.h.a("download image failed", paramString1);
      }
    }
  }
  
  private static boolean b(File paramFile, String paramString)
  {
    if ((paramFile == null) || (TextUtils.isEmpty(paramString))) {}
    for (boolean bool = false;; bool = paramString.equalsIgnoreCase(com.lantern.core.g.a(paramFile))) {
      return bool;
    }
  }
  
  public final InputStream a(String paramString)
  {
    Object localObject = null;
    if (!paramString.contains("51y5.net")) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      paramString = (Crty5Conf)d.a(c.getInstance()).a(Crty5Conf.class);
      try
      {
        File localFile = new java/io/File;
        localFile.<init>(a.getAppContext().getFilesDir(), "android.crt");
        if (localFile.exists())
        {
          if ((paramString != null) && (b(localFile, paramString.e())))
          {
            paramString = new java/io/FileInputStream;
            paramString.<init>(localFile);
            label77:
            continue;
          }
          if ((paramString == null) || (TextUtils.isEmpty(paramString.d())) || (TextUtils.isEmpty(paramString.e()))) {
            break label222;
          }
          a(paramString.d(), paramString.e());
          paramString = (String)localObject;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          paramString = null;
          for (;;)
          {
            com.bluefay.b.h.a(localException1);
            break label77;
            if ((paramString != null) && (!TextUtils.isEmpty(paramString.d())) && (!TextUtils.isEmpty(paramString.e())))
            {
              a(paramString.d(), paramString.e());
              paramString = localException1;
              break;
            }
            paramString = new ByteArrayInputStream(this.b.getBytes());
            try
            {
              StringBuilder localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>("crt ");
              com.bluefay.b.h.a(this.b, new Object[0]);
            }
            catch (Exception localException2) {}
          }
          label222:
          paramString = null;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */