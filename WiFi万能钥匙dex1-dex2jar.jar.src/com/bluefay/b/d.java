package com.bluefay.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class d
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
    return new d(paramString).c(paramMap);
  }
  
  public static String a(String paramString1, Map<String, String> paramMap, String paramString2, String paramString3)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    localArrayList2.add(paramString2);
    localArrayList1.add(paramString3);
    return a(paramString1, paramMap, localArrayList2, localArrayList1);
  }
  
  private static String a(String paramString, Map<String, String> paramMap, List<String> paramList1, List<String> paramList2)
  {
    String str2 = "-----" + UUID.randomUUID().toString() + "-----";
    String str1 = "--" + str2 + "--\r\n";
    paramString = new d(paramString);
    paramString.a("connection", "keep-alive");
    paramString.a("charset", "UTF-8");
    paramString.a("Content-Type", "multipart/form-data;boundary=" + str2);
    paramMap = paramString.b(new g(paramMap, str2, paramList1, paramList2, str1));
    if ((paramMap == null) || (paramMap.length == 0)) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = new java/lang/String;
        paramString.<init>(paramMap, "UTF-8");
      }
      catch (UnsupportedEncodingException paramString)
      {
        h.a(paramString);
        paramString = "";
      }
    }
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
  
  private boolean a(String paramString1, String paramString2, OutputStream paramOutputStream)
  {
    boolean bool2 = false;
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
      Object localObject3;
      Object localObject2;
      if (paramString1 == null)
      {
        throw new IOException("connection is null");
        paramString1 = (HttpURLConnection)paramString1.openConnection();
        continue;
        if (((String)localObject1).equals("https")) {
          try
          {
            localObject1 = SSLContext.getInstance("TLS");
            localObject3 = new com/bluefay/b/d$c;
            ((c)localObject3).<init>((byte)0);
            localObject2 = new java/security/SecureRandom;
            ((SecureRandom)localObject2).<init>();
            ((SSLContext)localObject1).init(new KeyManager[0], new TrustManager[] { localObject3 }, (SecureRandom)localObject2);
            SSLContext.setDefault((SSLContext)localObject1);
            HttpsURLConnection.setDefaultSSLSocketFactory(((SSLContext)localObject1).getSocketFactory());
            localObject1 = new com/bluefay/b/f;
            ((f)localObject1).<init>(this);
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
            break label388;
          }
        }
        label388:
        for (boolean bool1 = true;; bool1 = false)
        {
          paramString1.setUseCaches(bool1);
          paramString1.setDoInput(true);
          localObject3 = this.c.keySet().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject2 = (String)((Iterator)localObject3).next();
            String str = (String)this.c.get(localObject2);
            h.b("%s=%s", new Object[] { localObject2, str });
            paramString1.setRequestProperty((String)localObject2, str);
          }
        }
        if ("POST".equals(paramString2))
        {
          paramString1.setDoOutput(true);
          if (this.i != null) {
            this.i.a(paramString1.getOutputStream());
          }
        }
        paramString1.connect();
        int j = paramString1.getResponseCode();
        h.b("responseCode:%d responseMessage:%s", new Object[] { Integer.valueOf(j), paramString1.getResponseMessage() });
        if (j != 200) {
          bool1 = bool2;
        }
        for (;;)
        {
          return bool1;
          paramString2 = paramString1.getInputStream();
          bool1 = bool2;
          if (paramString2 != null)
          {
            paramString1.getContentLength();
            b(paramString2, paramOutputStream);
            paramString1.disconnect();
            bool1 = true;
          }
        }
      }
      paramString1 = null;
    }
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
    paramString.b();
    return paramString.c();
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
      Object localObject3;
      Object localObject2;
      if (paramString1 == null)
      {
        throw new IOException("connection is null");
        paramString1 = (HttpURLConnection)paramString1.openConnection();
        continue;
        if (((String)localObject1).equals("https")) {
          try
          {
            localObject1 = SSLContext.getInstance("TLS");
            localObject3 = new com/bluefay/b/d$c;
            ((c)localObject3).<init>((byte)0);
            localObject2 = new java/security/SecureRandom;
            ((SecureRandom)localObject2).<init>();
            ((SSLContext)localObject1).init(new KeyManager[0], new TrustManager[] { localObject3 }, (SecureRandom)localObject2);
            SSLContext.setDefault((SSLContext)localObject1);
            HttpsURLConnection.setDefaultSSLSocketFactory(((SSLContext)localObject1).getSocketFactory());
            localObject1 = new com/bluefay/b/e;
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
          localObject2 = this.c.keySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            localObject3 = (String)this.c.get(str);
            h.b("%s=%s", new Object[] { str, localObject3 });
            paramString1.setRequestProperty(str, (String)localObject3);
          }
        }
        if ("POST".equals(paramString2))
        {
          paramString1.setDoOutput(true);
          if (this.i == null) {
            break label490;
          }
          this.i.a(paramString1.getOutputStream());
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
          label490:
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
  
  public static String b(String paramString)
  {
    paramString = new d(paramString);
    paramString.b();
    byte[] arrayOfByte = paramString.c();
    if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = new java/lang/String;
        paramString.<init>(arrayOfByte, "UTF-8");
      }
      catch (UnsupportedEncodingException paramString)
      {
        h.a(paramString);
        paramString = "";
      }
    }
  }
  
  private boolean b(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, j);
      if (this.h == null) {}
    }
    paramInputStream.close();
    paramOutputStream.flush();
    paramOutputStream.close();
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    paramString1 = new d(paramString1);
    paramString1.a(30000, 180000);
    return paramString1.d(paramString2);
  }
  
  private byte[] b(b paramb)
  {
    a(paramb);
    int k = 0;
    int j = 0;
    paramb = null;
    for (;;)
    {
      Object localObject = paramb;
      if (k >= this.f) {
        break label93;
      }
      try
      {
        localObject = a(this.a, "POST", null);
        paramb = (b)localObject;
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
      if (this.h != null) {
        this.h.a(j);
      }
      localObject = paramb;
      if (j == 0) {
        break label93;
      }
      k++;
    }
    label93:
    return localException;
  }
  
  private static void c(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    paramOutputStream = new GZIPOutputStream(paramOutputStream);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int j = paramInputStream.read(arrayOfByte, 0, 1024);
      if (j == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, j);
    }
    paramOutputStream.finish();
    paramOutputStream.close();
  }
  
  private boolean d(String paramString)
  {
    try
    {
      String str = this.a;
      FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
      localFileOutputStream.<init>(paramString);
      bool = a(str, "GET", localFileOutputStream);
      return bool;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        h.a(paramString);
        boolean bool = false;
      }
    }
  }
  
  public final void a()
  {
    this.g = 0;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public final void a(a parama)
  {
    this.h = parama;
  }
  
  public void a(b paramb)
  {
    this.i = paramb;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c.put(paramString1, paramString2);
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    boolean bool;
    if (this.c.containsKey("Content-Encoding"))
    {
      bool = "gzip".equals((String)this.c.get("Content-Encoding"));
      if (!bool) {
        break label252;
      }
    }
    for (;;)
    {
      try
      {
        localByteArrayInputStream = new java/io/ByteArrayInputStream;
        localByteArrayInputStream.<init>(paramArrayOfByte);
        localObject = new java/io/ByteArrayOutputStream;
        ((ByteArrayOutputStream)localObject).<init>();
        c(localByteArrayInputStream, (OutputStream)localObject);
        arrayOfByte1 = ((ByteArrayOutputStream)localObject).toByteArray();
        ((ByteArrayOutputStream)localObject).flush();
        ((ByteArrayOutputStream)localObject).close();
        localByteArrayInputStream.close();
        j = 0;
      }
      catch (Exception localException1)
      {
        ByteArrayInputStream localByteArrayInputStream;
        Object localObject;
        byte[] arrayOfByte1;
        int k;
        h.a(localException1);
        if (this.h == null) {
          continue;
        }
        this.h.a(4);
        this.c.remove("Content-Encoding");
        j = 4;
        arrayOfByte2 = paramArrayOfByte;
        continue;
        return localException2;
      }
      k = 0;
      paramArrayOfByte = null;
      localObject = paramArrayOfByte;
      if (k < this.f)
      {
        try
        {
          localObject = this.a;
          localByteArrayInputStream = new java/io/ByteArrayInputStream;
          localByteArrayInputStream.<init>(arrayOfByte1);
          localObject = a((String)localObject, "POST", localByteArrayInputStream);
          paramArrayOfByte = (byte[])localObject;
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
        if (this.h != null) {
          this.h.a(j);
        }
        localObject = paramArrayOfByte;
        if (j != 0)
        {
          k++;
          continue;
          bool = false;
          break;
        }
      }
      label252:
      int j = 0;
      byte[] arrayOfByte2 = paramArrayOfByte;
    }
  }
  
  public final String b(Map<String, String> paramMap)
  {
    return c(a(paramMap));
  }
  
  public void b()
  {
    this.f = 1;
  }
  
  public String c(String paramString)
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
  
  public byte[] c()
  {
    Object localObject1 = null;
    int k = 0;
    int j = 0;
    for (;;)
    {
      Object localObject2 = localObject1;
      if (k >= this.f) {
        break label71;
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
        break label71;
      }
      k++;
    }
    label71:
    return localException;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void a(OutputStream paramOutputStream);
  }
  
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */