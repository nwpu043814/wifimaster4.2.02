package com.lantern.wifilocating.push.d;

import com.lantern.wifilocating.push.util.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class d
{
  private String a;
  private Proxy b;
  private Map<String, String> c = new HashMap();
  private int d = 30000;
  private int e = 90000;
  private int f = 1;
  private int g = -1;
  private a h;
  private b i;
  
  public d(String paramString)
  {
    this.a = paramString;
  }
  
  public static String a(String paramString, Map<String, String> paramMap)
  {
    paramMap = a(paramMap);
    return new d(paramString).b(paramMap);
  }
  
  public static String a(Map<String, String> paramMap)
  {
    Object localObject = "";
    String str1;
    if (paramMap != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Iterator localIterator = paramMap.keySet().iterator();
      int j = 0;
      while (localIterator.hasNext())
      {
        if (j > 0) {
          localStringBuffer.append("&");
        }
        localObject = (String)localIterator.next();
        String str2 = (String)paramMap.get(localObject);
        try
        {
          String str3 = URLEncoder.encode((String)localObject, "UTF-8");
          localObject = str2;
          if (str2 == null) {
            localObject = "";
          }
          localObject = URLEncoder.encode((String)localObject, "UTF-8");
          localStringBuffer.append(str3);
          localStringBuffer.append("=");
          localStringBuffer.append((String)localObject);
          j++;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            h.a(localUnsupportedEncodingException);
          }
        }
      }
      str1 = localStringBuffer.toString();
    }
    return str1;
  }
  
  private static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(paramOutputStream);
    paramOutputStream = new byte['Ѐ'];
    for (;;)
    {
      int j = paramInputStream.read(paramOutputStream, 0, 1024);
      if (j == -1) {
        break;
      }
      localGZIPOutputStream.write(paramOutputStream, 0, j);
    }
    localGZIPOutputStream.finish();
    localGZIPOutputStream.close();
  }
  
  private void a(OutputStream paramOutputStream, InputStream paramInputStream)
  {
    paramInputStream.available();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte, 0, 4096);
      if (j == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, j);
      if (this.h == null) {}
    }
    paramOutputStream.flush();
    paramOutputStream.close();
  }
  
  private byte[] a()
  {
    Object localObject1 = null;
    int k = 0;
    int j = 0;
    for (;;)
    {
      Object localObject2 = localObject1;
      if (k >= this.f) {
        break label70;
      }
      try
      {
        localObject2 = a(this.a, "GET", null);
        localObject1 = localObject2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          h.a(localIOException);
          j = 1;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(localException);
          j = 3;
        }
      }
      localObject2 = localObject1;
      if (j == 0) {
        break label70;
      }
      k++;
    }
    label70:
    return localException;
  }
  
  private byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, j);
      if (this.h == null) {}
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    paramInputStream.close();
    localByteArrayOutputStream.close();
    return arrayOfByte;
  }
  
  public static byte[] a(String paramString)
  {
    paramString = new d(paramString);
    paramString.f = 1;
    return paramString.a();
  }
  
  private byte[] a(String paramString1, String paramString2, InputStream paramInputStream)
  {
    h.b("%s %s", new Object[] { paramString2, paramString1 });
    paramString1 = new URL(paramString1);
    Object localObject1 = paramString1.getProtocol();
    if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
      throw new IOException("protocol is null");
    }
    if (((String)localObject1).equals("http")) {
      if (this.b != null) {
        paramString1 = (HttpURLConnection)paramString1.openConnection(this.b);
      }
    }
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      if (paramString1 == null)
      {
        throw new IOException("connection is null");
        paramString1 = (HttpURLConnection)paramString1.openConnection();
        continue;
        if (((String)localObject1).equals("https")) {
          try
          {
            localObject2 = SSLContext.getInstance("TLS");
            localObject3 = new com/lantern/wifilocating/push/d/d$c;
            ((c)localObject3).<init>((byte)0);
            localObject1 = new java/security/SecureRandom;
            ((SecureRandom)localObject1).<init>();
            ((SSLContext)localObject2).init(new KeyManager[0], new TrustManager[] { localObject3 }, (SecureRandom)localObject1);
            SSLContext.setDefault((SSLContext)localObject2);
            HttpsURLConnection.setDefaultSSLSocketFactory(((SSLContext)localObject2).getSocketFactory());
            localObject1 = new com/lantern/wifilocating/push/d/e;
            ((e)localObject1).<init>(this);
            HttpsURLConnection.setDefaultHostnameVerifier((HostnameVerifier)localObject1);
            if (this.b != null) {
              paramString1 = (HttpsURLConnection)paramString1.openConnection(this.b);
            }
          }
          catch (KeyManagementException localKeyManagementException)
          {
            for (;;)
            {
              h.a(localKeyManagementException);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              h.a(localException);
            }
            paramString1 = (HttpsURLConnection)paramString1.openConnection();
          }
        }
      }
      else
      {
        paramString1.setConnectTimeout(this.d);
        paramString1.setReadTimeout(this.e);
        paramString1.setRequestMethod(paramString2);
        if (this.g != -1) {
          if (this.g != 1) {
            break label385;
          }
        }
        label385:
        for (boolean bool = true;; bool = false)
        {
          paramString1.setUseCaches(bool);
          paramString1.setDoInput(true);
          localObject3 = this.c.keySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            String str = (String)((Iterator)localObject3).next();
            localObject2 = (String)this.c.get(str);
            h.b("%s=%s", new Object[] { str, localObject2 });
            paramString1.setRequestProperty(str, (String)localObject2);
          }
        }
        if ("POST".equals(paramString2))
        {
          paramString1.setDoOutput(true);
          if (this.i == null) {
            break label482;
          }
          paramString1.getOutputStream();
        }
        for (;;)
        {
          paramString1.connect();
          h.b("responseCode:%d responseMessage:%s", new Object[] { Integer.valueOf(paramString1.getResponseCode()), paramString1.getResponseMessage() });
          paramInputStream = paramString1.getInputStream();
          paramString2 = paramInputStream;
          if (paramInputStream == null) {
            paramString2 = paramString1.getErrorStream();
          }
          paramString1.getContentLength();
          paramString2 = a(paramString2);
          paramString1.disconnect();
          return paramString2;
          label482:
          if (paramInputStream != null)
          {
            a(paramString1.getOutputStream(), paramInputStream);
            paramInputStream.close();
          }
        }
      }
      paramString1 = null;
    }
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    int k = 0;
    boolean bool;
    if (this.c.containsKey("Content-Encoding"))
    {
      bool = "gzip".equals((String)this.c.get("Content-Encoding"));
      if (!bool) {
        break label218;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new java/io/ByteArrayInputStream;
        ((ByteArrayInputStream)localObject1).<init>(paramArrayOfByte);
        localObject2 = new java/io/ByteArrayOutputStream;
        ((ByteArrayOutputStream)localObject2).<init>();
        a((InputStream)localObject1, (OutputStream)localObject2);
        arrayOfByte1 = ((ByteArrayOutputStream)localObject2).toByteArray();
        ((ByteArrayOutputStream)localObject2).flush();
        ((ByteArrayOutputStream)localObject2).close();
        ((ByteArrayInputStream)localObject1).close();
        j = 0;
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject2;
        byte[] arrayOfByte1;
        h.a(localException1);
        j = 4;
        this.c.remove("Content-Encoding");
        arrayOfByte2 = paramArrayOfByte;
        continue;
        return localException2;
      }
      paramArrayOfByte = null;
      localObject1 = paramArrayOfByte;
      if (k < this.f)
      {
        try
        {
          localObject2 = this.a;
          localObject1 = new java/io/ByteArrayInputStream;
          ((ByteArrayInputStream)localObject1).<init>(arrayOfByte1);
          localObject1 = a((String)localObject2, "POST", (InputStream)localObject1);
          paramArrayOfByte = (byte[])localObject1;
        }
        catch (IOException localIOException)
        {
          h.a(localIOException);
          j = 1;
          continue;
        }
        catch (Exception localException2)
        {
          h.a(localException2);
          j = 3;
          continue;
        }
        localObject1 = paramArrayOfByte;
        if (j != 0)
        {
          k++;
          continue;
          bool = false;
          break;
        }
      }
      label218:
      int j = 0;
      byte[] arrayOfByte2 = paramArrayOfByte;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.c.put(paramString1, paramString2);
  }
  
  public final String b(String paramString)
  {
    String str = null;
    try
    {
      paramString = a(paramString.getBytes("UTF-8"));
      if ((paramString == null) || (paramString.length == 0))
      {
        paramString = "";
        return paramString;
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        h.a(paramString);
        paramString = str;
        continue;
        try
        {
          str = new java/lang/String;
          str.<init>(paramString, "UTF-8");
          paramString = str;
        }
        catch (UnsupportedEncodingException paramString)
        {
          h.a(paramString);
          paramString = "";
        }
      }
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
  
  private static final class c
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */