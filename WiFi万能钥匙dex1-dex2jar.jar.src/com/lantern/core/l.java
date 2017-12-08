package com.lantern.core;

import com.bluefay.b.d;
import com.bluefay.b.d.a;
import com.bluefay.b.d.b;
import com.bluefay.b.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.Principal;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
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

public final class l
  extends d
{
  private static X509Certificate k = null;
  private Map<String, String> a = new HashMap();
  private d.a b;
  private int c = 1;
  private String d;
  private Proxy e;
  private KeyStore f;
  private int g = 30000;
  private int h = 90000;
  private int i = -1;
  private d.b j;
  
  private l(String paramString)
  {
    super(paramString);
    this.d = paramString;
  }
  
  private void a(OutputStream paramOutputStream, InputStream paramInputStream)
  {
    paramInputStream.available();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int m = paramInputStream.read(arrayOfByte, 0, 4096);
      if (m == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, m);
      if (this.b == null) {}
    }
    paramOutputStream.flush();
    paramOutputStream.close();
  }
  
  private byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int m = paramInputStream.read(arrayOfByte);
      if (m == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, m);
      if (this.b == null) {}
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    paramInputStream.close();
    localByteArrayOutputStream.close();
    return arrayOfByte;
  }
  
  private byte[] a(String paramString1, String paramString2, InputStream paramInputStream)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    h.b("%s %s", new Object[] { paramString2, paramString1 });
    URL localURL = new URL(paramString1);
    Object localObject5 = localURL.getProtocol();
    if ((localObject5 == null) || (((String)localObject5).length() == 0)) {
      throw new IOException("protocol is null");
    }
    boolean bool;
    if (((String)localObject5).equals("http"))
    {
      if (this.e != null) {}
      for (paramString1 = (HttpURLConnection)localURL.openConnection(this.e); paramString1 == null; paramString1 = (HttpURLConnection)localURL.openConnection()) {
        throw new IOException("connection is null");
      }
      paramString1.setConnectTimeout(this.g);
      paramString1.setReadTimeout(this.h);
      paramString1.setRequestMethod(paramString2);
      if (this.i != -1) {
        if (this.i != 1) {
          break label257;
        }
      }
      label257:
      for (bool = true;; bool = false)
      {
        paramString1.setUseCaches(bool);
        paramString1.setDoInput(true);
        localObject3 = this.a.keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject1 = (String)((Iterator)localObject3).next();
          localObject4 = (String)this.a.get(localObject1);
          h.b("%s=%s", new Object[] { localObject1, localObject4 });
          paramString1.setRequestProperty((String)localObject1, (String)localObject4);
        }
      }
      if ("POST".equals(paramString2))
      {
        paramString1.setDoOutput(true);
        if (this.j != null) {
          this.j.a(paramString1.getOutputStream());
        }
      }
      else
      {
        paramString1.connect();
        h.b("responseCode:%d responseMessage:%s", new Object[] { Integer.valueOf(paramString1.getResponseCode()), paramString1.getResponseMessage() });
        paramInputStream = paramString1.getInputStream();
        paramString2 = paramInputStream;
        if (paramInputStream == null) {
          paramString2 = paramString1.getErrorStream();
        }
        paramString1.getContentLength();
        localObject1 = a(paramString2);
        paramString1.disconnect();
      }
    }
    while (!((String)localObject5).equals("https")) {
      for (;;)
      {
        return (byte[])localObject1;
        a(paramString1.getOutputStream(), paramInputStream);
        paramInputStream.close();
      }
    }
    if (this.f == null)
    {
      this.f = d(paramString1);
      h.a("sslkey:%s", new Object[] { this.f });
    }
    paramString1 = (String)localObject4;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        localObject3 = SSLContext.getInstance("TLS");
        paramString1 = (String)localObject3;
        localObject1 = localObject3;
        if (this.f == null) {
          continue;
        }
        paramString1 = (String)localObject3;
        localObject1 = localObject3;
        localObject4 = new com/lantern/core/l$b;
        paramString1 = (String)localObject3;
        localObject1 = localObject3;
        ((b)localObject4).<init>(this, k);
        paramString1 = (String)localObject3;
        localObject1 = localObject3;
        ((SSLContext)localObject3).init(null, new TrustManager[] { localObject4 }, null);
        paramString1 = (String)localObject3;
        localObject1 = localObject3;
        SSLContext.setDefault((SSLContext)localObject3);
        paramString1 = (String)localObject3;
        localObject1 = localObject3;
        localObject4 = new com/lantern/core/m;
        paramString1 = (String)localObject3;
        localObject1 = localObject3;
        ((m)localObject4).<init>(this);
        paramString1 = (String)localObject3;
        localObject1 = localObject3;
        HttpsURLConnection.setDefaultHostnameVerifier((HostnameVerifier)localObject4);
        paramString1 = (String)localObject3;
      }
      catch (KeyManagementException localKeyManagementException)
      {
        h.a(localKeyManagementException);
        continue;
      }
      catch (Exception paramString1)
      {
        h.a(paramString1);
        paramString1 = localKeyManagementException;
        continue;
        localObject2 = (HttpsURLConnection)localURL.openConnection();
        continue;
        ((HttpsURLConnection)localObject2).setConnectTimeout(this.g);
        ((HttpsURLConnection)localObject2).setReadTimeout(this.h);
        ((HttpsURLConnection)localObject2).setRequestMethod(paramString2);
        if (this.i == -1) {
          continue;
        }
        if (this.i != 1) {
          continue;
        }
        bool = true;
        ((HttpsURLConnection)localObject2).setUseCaches(bool);
        ((HttpsURLConnection)localObject2).setDoInput(true);
        localObject4 = this.a.keySet().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          continue;
        }
        paramString1 = (String)((Iterator)localObject4).next();
        localObject3 = (String)this.a.get(paramString1);
        h.b("%s=%s", new Object[] { paramString1, localObject3 });
        ((HttpsURLConnection)localObject2).setRequestProperty(paramString1, (String)localObject3);
        continue;
        bool = false;
        continue;
        if (!"POST".equals(paramString2)) {
          break label891;
        }
        ((HttpsURLConnection)localObject2).setDoOutput(true);
        if (this.j == null) {
          break label965;
        }
        this.j.a(((HttpsURLConnection)localObject2).getOutputStream());
      }
      if (this.e == null) {
        continue;
      }
      localObject1 = (HttpsURLConnection)localURL.openConnection(this.e);
      if (paramString1 != null) {
        ((HttpsURLConnection)localObject1).setSSLSocketFactory(paramString1.getSocketFactory());
      }
      if (localObject1 != null) {
        continue;
      }
      throw new IOException("connection is null");
      paramString1 = (String)localObject3;
      localObject1 = localObject3;
      localObject4 = new com/lantern/core/l$a;
      paramString1 = (String)localObject3;
      localObject1 = localObject3;
      ((a)localObject4).<init>((byte)0);
      paramString1 = (String)localObject3;
      localObject1 = localObject3;
      localObject5 = new java/security/SecureRandom;
      paramString1 = (String)localObject3;
      localObject1 = localObject3;
      ((SecureRandom)localObject5).<init>();
      paramString1 = (String)localObject3;
      localObject1 = localObject3;
      ((SSLContext)localObject3).init(new KeyManager[0], new TrustManager[] { localObject4 }, (SecureRandom)localObject5);
    }
    for (;;)
    {
      label891:
      ((HttpsURLConnection)localObject2).connect();
      h.b("responseCode:%d responseMessage:%s", new Object[] { Integer.valueOf(((HttpsURLConnection)localObject2).getResponseCode()), ((HttpsURLConnection)localObject2).getResponseMessage() });
      paramString2 = ((HttpsURLConnection)localObject2).getInputStream();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = ((HttpsURLConnection)localObject2).getErrorStream();
      }
      ((HttpsURLConnection)localObject2).getContentLength();
      paramString1 = a(paramString1);
      ((HttpsURLConnection)localObject2).disconnect();
      Object localObject2 = paramString1;
      break;
      label965:
      a(((HttpsURLConnection)localObject2).getOutputStream(), paramInputStream);
      paramInputStream.close();
    }
  }
  
  public static String b(String paramString, Map<String, String> paramMap)
  {
    paramMap = a(paramMap);
    return new l(paramString).c(paramMap);
  }
  
  private static void b(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    paramOutputStream = new GZIPOutputStream(paramOutputStream);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int m = paramInputStream.read(arrayOfByte, 0, 1024);
      if (m == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, m);
    }
    paramOutputStream.finish();
    paramOutputStream.close();
  }
  
  /* Error */
  private static KeyStore d(String paramString)
  {
    // Byte code:
    //   0: invokestatic 352	com/lantern/core/g/g:a	()Lcom/lantern/core/g/g;
    //   3: aload_0
    //   4: invokevirtual 355	com/lantern/core/g/g:a	(Ljava/lang/String;)Ljava/io/InputStream;
    //   7: astore_0
    //   8: aload_0
    //   9: astore_1
    //   10: ldc_w 357
    //   13: invokestatic 362	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   16: aload_0
    //   17: invokevirtual 366	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   20: checkcast 368	java/security/cert/X509Certificate
    //   23: putstatic 32	com/lantern/core/l:k	Ljava/security/cert/X509Certificate;
    //   26: aload_0
    //   27: astore_1
    //   28: ldc_w 370
    //   31: ldc_w 372
    //   34: invokestatic 377	java/security/KeyStore:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyStore;
    //   37: astore_2
    //   38: aload_0
    //   39: astore_1
    //   40: aload_2
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 381	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   46: aload_0
    //   47: astore_1
    //   48: aload_2
    //   49: ldc_w 383
    //   52: getstatic 32	com/lantern/core/l:k	Ljava/security/cert/X509Certificate;
    //   55: invokevirtual 387	java/security/KeyStore:setCertificateEntry	(Ljava/lang/String;Ljava/security/cert/Certificate;)V
    //   58: aload_2
    //   59: astore_1
    //   60: aload_0
    //   61: ifnull +9 -> 70
    //   64: aload_0
    //   65: invokevirtual 92	java/io/InputStream:close	()V
    //   68: aload_2
    //   69: astore_1
    //   70: aload_1
    //   71: areturn
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   77: aload_2
    //   78: astore_1
    //   79: goto -9 -> 70
    //   82: astore_2
    //   83: aconst_null
    //   84: astore_0
    //   85: aload_0
    //   86: astore_1
    //   87: aload_2
    //   88: invokevirtual 391	java/security/cert/CertificateException:printStackTrace	()V
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 92	java/io/InputStream:close	()V
    //   99: aconst_null
    //   100: astore_1
    //   101: goto -31 -> 70
    //   104: astore_0
    //   105: aload_0
    //   106: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   109: goto -10 -> 99
    //   112: astore_2
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: astore_1
    //   117: aload_2
    //   118: invokevirtual 392	java/security/KeyStoreException:printStackTrace	()V
    //   121: aload_0
    //   122: ifnull -23 -> 99
    //   125: aload_0
    //   126: invokevirtual 92	java/io/InputStream:close	()V
    //   129: goto -30 -> 99
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   137: goto -38 -> 99
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_0
    //   143: aload_0
    //   144: astore_1
    //   145: aload_2
    //   146: invokevirtual 393	java/security/NoSuchProviderException:printStackTrace	()V
    //   149: aload_0
    //   150: ifnull -51 -> 99
    //   153: aload_0
    //   154: invokevirtual 92	java/io/InputStream:close	()V
    //   157: goto -58 -> 99
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   165: goto -66 -> 99
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_0
    //   171: aload_0
    //   172: astore_1
    //   173: aload_2
    //   174: invokevirtual 394	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   177: aload_0
    //   178: ifnull -79 -> 99
    //   181: aload_0
    //   182: invokevirtual 92	java/io/InputStream:close	()V
    //   185: goto -86 -> 99
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   193: goto -94 -> 99
    //   196: astore_2
    //   197: aconst_null
    //   198: astore_0
    //   199: aload_0
    //   200: astore_1
    //   201: aload_2
    //   202: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   205: aload_0
    //   206: ifnull -107 -> 99
    //   209: aload_0
    //   210: invokevirtual 92	java/io/InputStream:close	()V
    //   213: goto -114 -> 99
    //   216: astore_0
    //   217: aload_0
    //   218: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   221: goto -122 -> 99
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_1
    //   227: aload_1
    //   228: ifnull +7 -> 235
    //   231: aload_1
    //   232: invokevirtual 92	java/io/InputStream:close	()V
    //   235: aload_0
    //   236: athrow
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 390	java/io/IOException:printStackTrace	()V
    //   242: goto -7 -> 235
    //   245: astore_0
    //   246: goto -19 -> 227
    //   249: astore_2
    //   250: goto -51 -> 199
    //   253: astore_2
    //   254: goto -83 -> 171
    //   257: astore_2
    //   258: goto -115 -> 143
    //   261: astore_2
    //   262: goto -147 -> 115
    //   265: astore_2
    //   266: goto -181 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramString	String
    //   9	223	1	localObject	Object
    //   237	2	1	localIOException1	IOException
    //   37	41	2	localKeyStore	KeyStore
    //   82	6	2	localCertificateException1	CertificateException
    //   112	6	2	localKeyStoreException1	java.security.KeyStoreException
    //   140	6	2	localNoSuchProviderException1	java.security.NoSuchProviderException
    //   168	6	2	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   196	6	2	localIOException2	IOException
    //   249	1	2	localIOException3	IOException
    //   253	1	2	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   257	1	2	localNoSuchProviderException2	java.security.NoSuchProviderException
    //   261	1	2	localKeyStoreException2	java.security.KeyStoreException
    //   265	1	2	localCertificateException2	CertificateException
    // Exception table:
    //   from	to	target	type
    //   64	68	72	java/io/IOException
    //   0	8	82	java/security/cert/CertificateException
    //   95	99	104	java/io/IOException
    //   0	8	112	java/security/KeyStoreException
    //   125	129	132	java/io/IOException
    //   0	8	140	java/security/NoSuchProviderException
    //   153	157	160	java/io/IOException
    //   0	8	168	java/security/NoSuchAlgorithmException
    //   181	185	188	java/io/IOException
    //   0	8	196	java/io/IOException
    //   209	213	216	java/io/IOException
    //   0	8	224	finally
    //   231	235	237	java/io/IOException
    //   10	26	245	finally
    //   28	38	245	finally
    //   40	46	245	finally
    //   48	58	245	finally
    //   87	91	245	finally
    //   117	121	245	finally
    //   145	149	245	finally
    //   173	177	245	finally
    //   201	205	245	finally
    //   10	26	249	java/io/IOException
    //   28	38	249	java/io/IOException
    //   40	46	249	java/io/IOException
    //   48	58	249	java/io/IOException
    //   10	26	253	java/security/NoSuchAlgorithmException
    //   28	38	253	java/security/NoSuchAlgorithmException
    //   40	46	253	java/security/NoSuchAlgorithmException
    //   48	58	253	java/security/NoSuchAlgorithmException
    //   10	26	257	java/security/NoSuchProviderException
    //   28	38	257	java/security/NoSuchProviderException
    //   40	46	257	java/security/NoSuchProviderException
    //   48	58	257	java/security/NoSuchProviderException
    //   10	26	261	java/security/KeyStoreException
    //   28	38	261	java/security/KeyStoreException
    //   40	46	261	java/security/KeyStoreException
    //   48	58	261	java/security/KeyStoreException
    //   10	26	265	java/security/cert/CertificateException
    //   28	38	265	java/security/cert/CertificateException
    //   40	46	265	java/security/cert/CertificateException
    //   48	58	265	java/security/cert/CertificateException
  }
  
  public final void a(d.b paramb)
  {
    this.j = paramb;
  }
  
  public final byte[] a(byte[] paramArrayOfByte)
  {
    boolean bool;
    if (this.a.containsKey("Content-Encoding"))
    {
      bool = "gzip".equals((String)this.a.get("Content-Encoding"));
      if (!bool) {
        break label251;
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new java/io/ByteArrayInputStream;
        ((ByteArrayInputStream)localObject2).<init>(paramArrayOfByte);
        localObject1 = new java/io/ByteArrayOutputStream;
        ((ByteArrayOutputStream)localObject1).<init>();
        b((InputStream)localObject2, (OutputStream)localObject1);
        arrayOfByte1 = ((ByteArrayOutputStream)localObject1).toByteArray();
        ((ByteArrayOutputStream)localObject1).flush();
        ((ByteArrayOutputStream)localObject1).close();
        ((ByteArrayInputStream)localObject2).close();
        m = 0;
      }
      catch (Exception localException1)
      {
        Object localObject2;
        Object localObject1;
        byte[] arrayOfByte1;
        int n;
        h.a(localException1);
        if (this.b == null) {
          continue;
        }
        this.b.a(4);
        this.a.remove("Content-Encoding");
        m = 4;
        arrayOfByte2 = paramArrayOfByte;
        continue;
        return localException2;
      }
      n = 0;
      paramArrayOfByte = null;
      localObject1 = paramArrayOfByte;
      if (n < this.c)
      {
        try
        {
          localObject2 = this.d;
          localObject1 = new java/io/ByteArrayInputStream;
          ((ByteArrayInputStream)localObject1).<init>(arrayOfByte1);
          localObject1 = a((String)localObject2, "POST", (InputStream)localObject1);
          paramArrayOfByte = (byte[])localObject1;
        }
        catch (IOException localIOException)
        {
          h.a(localIOException);
          m = 1;
          continue;
        }
        catch (Exception localException2)
        {
          h.a(localException2);
          m = 3;
          continue;
        }
        if (this.b != null) {
          this.b.a(m);
        }
        localObject1 = paramArrayOfByte;
        if (m != 0)
        {
          n++;
          continue;
          bool = false;
          break;
        }
      }
      label251:
      int m = 0;
      byte[] arrayOfByte2 = paramArrayOfByte;
    }
  }
  
  public final void b()
  {
    this.c = 1;
  }
  
  public final String c(String paramString)
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
  
  final class b
    implements X509TrustManager
  {
    X509Certificate a;
    
    b(X509Certificate paramX509Certificate)
    {
      this.a = paramX509Certificate;
    }
    
    public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
    
    public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
    {
      if (!paramArrayOfX509Certificate[0].getSubjectDN().equals(this.a.getSubjectDN())) {
        throw new CertificateException("Parent certificate of server was different than expected signing certificate");
      }
      try
      {
        if (!paramArrayOfX509Certificate[0].getPublicKey().toString().equals(this.a.getPublicKey().toString()))
        {
          paramArrayOfX509Certificate = new java/security/cert/CertificateException;
          paramArrayOfX509Certificate.<init>("Parent certificate of server was different than expected signing certificate");
          throw paramArrayOfX509Certificate;
        }
      }
      catch (Exception paramArrayOfX509Certificate)
      {
        h.a(paramArrayOfX509Certificate);
        throw new CertificateException("Parent certificate of server was different than expected signing certificate");
      }
    }
    
    public final X509Certificate[] getAcceptedIssuers()
    {
      return new X509Certificate[0];
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */