package com.analysis.common.http;

import android.text.TextUtils;
import com.analysis.common.tools.a;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.entity.BasicHttpEntity;

public abstract class c
{
  private static final String a = "ALHttp";
  
  private static String a()
  {
    return "application/x-www-form-urlencoded; charset=UTF-8";
  }
  
  private static String a(InputStream paramInputStream)
  {
    Object localObject4 = null;
    int i;
    if (paramInputStream == null) {
      i = 0;
    }
    for (;;)
    {
      Object localObject1 = localObject4;
      BufferedReader localBufferedReader;
      if (i != 0)
      {
        localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 8192);
        localObject1 = new StringBuilder();
      }
      try
      {
        for (;;)
        {
          String str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          ((StringBuilder)localObject1).append(str + "\n");
        }
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        for (;;)
        {
          try
          {
            paramInputStream.close();
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
            localObject1 = localObject4;
            continue;
          }
          return (String)localObject1;
          i = 1;
          break;
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
            localObject1 = localObject4;
          }
        }
      }
      finally
      {
        for (;;)
        {
          try
          {
            paramInputStream.close();
            throw ((Throwable)localObject2);
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
            Object localObject3 = localObject4;
          }
        }
      }
    }
  }
  
  private static String a(String paramString)
  {
    Object localObject1 = null;
    int i = new Random().nextInt(1000);
    if ((com.analysis.common.tools.c.a(paramString)) || (paramString.length() <= 1))
    {
      a.a("ALHttp", i + ":\tInvalid baseUrl.");
      paramString = (String)localObject1;
      return paramString;
    }
    label127:
    for (;;)
    {
      try
      {
        Object localObject2 = new java/net/URL;
        ((URL)localObject2).<init>(paramString);
        localObject2 = a((URL)localObject2, 1);
        paramString = (String)localObject1;
        if (((HttpURLConnection)localObject2).getResponseCode() != 200) {
          break;
        }
        paramString = ((HttpURLConnection)localObject2).getInputStream();
        if (!b((HttpURLConnection)localObject2)) {
          break label127;
        }
        localObject2 = new java/util/zip/GZIPInputStream;
        ((GZIPInputStream)localObject2).<init>(paramString);
        paramString = (String)localObject2;
        paramString = a(paramString);
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        paramString = (String)localObject1;
      }
      break;
    }
  }
  
  private static HttpURLConnection a(URL paramURL, int paramInt)
  {
    d locald;
    if (paramURL.getProtocol().toLowerCase().equals("https")) {
      locald = new d();
    }
    for (;;)
    {
      try
      {
        SSLContext localSSLContext = SSLContext.getInstance("TLS");
        SecureRandom localSecureRandom = new java/security/SecureRandom;
        localSecureRandom.<init>();
        localSSLContext.init(null, new TrustManager[] { locald }, localSecureRandom);
        HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
        paramURL = (HttpsURLConnection)paramURL.openConnection();
        paramURL.setHostnameVerifier(new e((byte)0));
        paramURL.setConnectTimeout(10000);
        paramURL.setReadTimeout(30000);
        paramURL.setUseCaches(false);
        paramURL.setDoInput(true);
        switch (paramInt)
        {
        default: 
          return paramURL;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      paramURL = (HttpURLConnection)paramURL.openConnection();
      continue;
      paramURL.setRequestMethod("GET");
      continue;
      paramURL.setDoOutput(true);
      paramURL.setRequestMethod("POST");
    }
  }
  
  private static HttpEntity a(HttpURLConnection paramHttpURLConnection)
  {
    BasicHttpEntity localBasicHttpEntity = new BasicHttpEntity();
    try
    {
      InputStream localInputStream1 = paramHttpURLConnection.getInputStream();
      localBasicHttpEntity.setContent(localInputStream1);
      localBasicHttpEntity.setContentLength(paramHttpURLConnection.getContentLength());
      localBasicHttpEntity.setContentEncoding(paramHttpURLConnection.getContentEncoding());
      localBasicHttpEntity.setContentType(paramHttpURLConnection.getContentType());
      return localBasicHttpEntity;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        InputStream localInputStream2 = paramHttpURLConnection.getErrorStream();
      }
    }
  }
  
  public static boolean a(String paramString, Map<String, String> paramMap)
  {
    boolean bool = true;
    a.b("ALHttp", "httpPost  start ");
    int i = new Random().nextInt(1000);
    if ((com.analysis.common.tools.c.a(paramString)) || (paramString.length() <= 1))
    {
      a.a("ALHttp", i + ":\tInvalid baseUrl.");
      bool = false;
      return bool;
    }
    label286:
    for (;;)
    {
      try
      {
        Object localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>("httpPost  start-url ");
        a.b("ALHttp", paramString);
        localObject = new java/net/URL;
        ((URL)localObject).<init>(paramString);
        localObject = a((URL)localObject, 2);
        paramMap = a(paramMap, "UTF-8");
        if (paramMap != null)
        {
          ((HttpURLConnection)localObject).setDoOutput(true);
          ((HttpURLConnection)localObject).addRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
          paramString = new java/io/DataOutputStream;
          paramString.<init>(((HttpURLConnection)localObject).getOutputStream());
          paramString.write(paramMap);
          paramString.close();
        }
        paramString = new java/lang/StringBuilder;
        paramString.<init>("connection.getResponseCode() ");
        a.b("ALHttp", ((HttpURLConnection)localObject).getResponseCode());
        if (((HttpURLConnection)localObject).getResponseCode() == 200)
        {
          paramString = ((HttpURLConnection)localObject).getInputStream();
          if (!b((HttpURLConnection)localObject)) {
            break label286;
          }
          paramMap = new java/util/zip/GZIPInputStream;
          paramMap.<init>(paramString);
          paramString = paramMap;
          paramMap = new java/lang/StringBuilder;
          paramMap.<init>("streamToString: ");
          a.b("ALHttp", a(paramString));
        }
      }
      catch (Exception paramString)
      {
        a.b("ALHttp", "IOException " + paramString.getMessage());
        paramString.printStackTrace();
        bool = false;
      }
      break;
    }
  }
  
  private static byte[] a(Map<String, String> paramMap, String paramString)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    StringBuilder localStringBuilder;
    for (paramMap = null;; paramMap = localStringBuilder.toString().getBytes(paramString))
    {
      return paramMap;
      a.b("ALHttp", "params: " + paramMap.toString());
      localStringBuilder = new StringBuilder();
      try
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          paramMap = (Map.Entry)localIterator.next();
          localStringBuilder.append((String)paramMap.getKey());
          localStringBuilder.append('=');
          localStringBuilder.append(URLEncoder.encode((String)paramMap.getValue(), paramString));
          localStringBuilder.append('&');
        }
        if (localStringBuilder.length() <= 1) {
          continue;
        }
      }
      catch (UnsupportedEncodingException paramMap)
      {
        throw new RuntimeException("Encoding not supported: " + paramString, paramMap);
      }
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
  }
  
  private static void b()
  {
    d locald = new d();
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      SecureRandom localSecureRandom = new java/security/SecureRandom;
      localSecureRandom.<init>();
      localSSLContext.init(null, new TrustManager[] { locald }, localSecureRandom);
      HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private static boolean b(HttpURLConnection paramHttpURLConnection)
  {
    return TextUtils.equals(paramHttpURLConnection.getHeaderField("Content-Encoding"), "gzip");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/http/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */