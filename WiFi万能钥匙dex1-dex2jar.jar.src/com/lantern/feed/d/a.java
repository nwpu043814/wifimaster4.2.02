package com.lantern.feed.d;

import com.bluefay.b.d;
import com.bluefay.b.h;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class a
  extends d
{
  protected boolean a;
  protected String b;
  private Map<String, String> c = new HashMap();
  private int d = 30000;
  private int e = 90000;
  
  public a(String paramString)
  {
    super(paramString);
    this.b = paramString;
  }
  
  private static byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    paramInputStream.close();
    localByteArrayOutputStream.close();
    return arrayOfByte;
  }
  
  private HttpURLConnection d(String paramString)
  {
    URL localURL = new URL(paramString);
    int i = 0;
    int j = i + 1;
    if (i <= 20)
    {
      paramString = localURL.getProtocol();
      if ((paramString == null) || (paramString.length() == 0)) {
        throw new IOException("protocol is null");
      }
      if (!paramString.equals("http")) {}
    }
    label465:
    for (paramString = (HttpURLConnection)localURL.openConnection();; paramString = null)
    {
      Object localObject2;
      for (;;)
      {
        if (paramString == null)
        {
          throw new IOException("connection is null");
          if (!paramString.equals("https")) {
            break label465;
          }
          try
          {
            paramString = SSLContext.getInstance("TLS");
            localObject1 = new com/lantern/feed/d/a$a;
            ((a)localObject1).<init>((byte)0);
            localObject2 = new java/security/SecureRandom;
            ((SecureRandom)localObject2).<init>();
            paramString.init(new KeyManager[0], new TrustManager[] { localObject1 }, (SecureRandom)localObject2);
            SSLContext.setDefault(paramString);
            HttpsURLConnection.setDefaultSSLSocketFactory(paramString.getSocketFactory());
            paramString = new com/lantern/feed/d/b;
            paramString.<init>(this);
            HttpsURLConnection.setDefaultHostnameVerifier(paramString);
            paramString = (HttpsURLConnection)localURL.openConnection();
          }
          catch (KeyManagementException paramString)
          {
            for (;;)
            {
              h.a(paramString);
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              h.a(paramString);
            }
          }
        }
      }
      paramString.setConnectTimeout(this.d);
      paramString.setReadTimeout(this.e);
      paramString.setRequestMethod("GET");
      paramString.setDoInput(true);
      Object localObject1 = this.c.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        localObject2 = (String)this.c.get(str);
        h.b("%s=%s", new Object[] { str, localObject2 });
        paramString.setRequestProperty(str, (String)localObject2);
      }
      i = paramString.getResponseCode();
      if ((i == 300) || (i == 301) || (i == 302) || (i == 303) || (i == 307) || (i == 308))
      {
        localObject1 = paramString.getHeaderField("Location");
        paramString.disconnect();
        if (localObject1 == null) {
          throw new ProtocolException("Null location redirect");
        }
        localURL = new URL(localURL, (String)localObject1);
        paramString = localURL.getProtocol();
        if ((!"https".equals(paramString)) && (!"http".equals(paramString))) {
          throw new ProtocolException("Unsupported protocol redirect: " + paramString);
        }
        i = j;
        break;
        throw new ProtocolException("Too many redirects: " + j);
      }
      return paramString;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2);
    this.c.put(paramString1, paramString2);
  }
  
  public final byte[] c()
  {
    Object localObject1;
    if (!this.a) {
      localObject1 = super.c();
    }
    for (;;)
    {
      return (byte[])localObject1;
      try
      {
        localObject1 = this.b;
        localObject4 = new java/net/URL;
        ((URL)localObject4).<init>((String)localObject1);
        localObject4 = ((URL)localObject4).getProtocol();
        if ((localObject4 == null) || (((String)localObject4).length() == 0))
        {
          localObject1 = new java/io/IOException;
          ((IOException)localObject1).<init>("protocol is null");
          throw ((Throwable)localObject1);
        }
      }
      catch (IOException localIOException)
      {
        h.a(localIOException);
        Object localObject2 = null;
        continue;
        HttpURLConnection localHttpURLConnection = d((String)localObject2);
        localHttpURLConnection.connect();
        h.b("responseCode:%d responseMessage:%s", new Object[] { Integer.valueOf(localHttpURLConnection.getResponseCode()), localHttpURLConnection.getResponseMessage() });
        Object localObject4 = localHttpURLConnection.getInputStream();
        localObject2 = localObject4;
        if (localObject4 == null) {
          localObject2 = localHttpURLConnection.getErrorStream();
        }
        localObject2 = a((InputStream)localObject2);
        localHttpURLConnection.disconnect();
      }
      catch (Exception localException)
      {
        h.a(localException);
        Object localObject3 = null;
      }
    }
  }
  
  public final void d()
  {
    this.a = true;
  }
  
  private static final class a
    implements X509TrustManager
  {
    public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
    
    public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
    
    public final X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */