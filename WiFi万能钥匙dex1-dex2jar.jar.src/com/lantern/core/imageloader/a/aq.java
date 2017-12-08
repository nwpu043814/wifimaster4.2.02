package com.lantern.core.imageloader.a;

import android.content.Context;
import android.net.Uri;
import com.bluefay.b.h;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public final class aq
  implements r
{
  static volatile Object a;
  private static final Object b = new Object();
  private static final ThreadLocal<StringBuilder> c = new ar();
  private final Context d;
  
  public aq(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
  }
  
  private HttpURLConnection a(Uri paramUri)
  {
    URL localURL = new URL(paramUri.toString());
    Object localObject = localURL.getProtocol();
    if ((localObject == null) || (((String)localObject).length() == 0)) {
      throw new IOException("protocol is null");
    }
    paramUri = (HttpURLConnection)new URL(paramUri.toString()).openConnection();
    if (((String)localObject).equals("http")) {
      paramUri = (HttpURLConnection)localURL.openConnection();
    }
    for (;;)
    {
      if (paramUri == null)
      {
        throw new IOException("connection is null");
        if (!((String)localObject).equals("https")) {
          continue;
        }
        try
        {
          SSLContext localSSLContext = SSLContext.getInstance("TLS");
          paramUri = new com/lantern/core/imageloader/a/aq$a;
          paramUri.<init>((byte)0);
          localObject = new java/security/SecureRandom;
          ((SecureRandom)localObject).<init>();
          localSSLContext.init(new KeyManager[0], new TrustManager[] { paramUri }, (SecureRandom)localObject);
          SSLContext.setDefault(localSSLContext);
          HttpsURLConnection.setDefaultSSLSocketFactory(localSSLContext.getSocketFactory());
          paramUri = new com/lantern/core/imageloader/a/as;
          paramUri.<init>(this);
          HttpsURLConnection.setDefaultHostnameVerifier(paramUri);
          paramUri = (HttpsURLConnection)localURL.openConnection();
        }
        catch (KeyManagementException paramUri)
        {
          for (;;)
          {
            h.a(paramUri);
          }
        }
        catch (Exception paramUri)
        {
          for (;;)
          {
            h.a(paramUri);
          }
        }
      }
    }
    paramUri.setConnectTimeout(15000);
    paramUri.setReadTimeout(20000);
    return paramUri;
  }
  
  /* Error */
  public final r.a a(Uri paramUri, int paramInt)
  {
    // Byte code:
    //   0: getstatic 148	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 14
    //   5: if_icmplt +70 -> 75
    //   8: aload_0
    //   9: getfield 38	com/lantern/core/imageloader/a/aq:d	Landroid/content/Context;
    //   12: astore 7
    //   14: getstatic 150	com/lantern/core/imageloader/a/aq:a	Ljava/lang/Object;
    //   17: ifnonnull +58 -> 75
    //   20: getstatic 23	com/lantern/core/imageloader/a/aq:b	Ljava/lang/Object;
    //   23: astore 9
    //   25: aload 9
    //   27: monitorenter
    //   28: getstatic 150	com/lantern/core/imageloader/a/aq:a	Ljava/lang/Object;
    //   31: ifnonnull +41 -> 72
    //   34: aload 7
    //   36: invokestatic 155	com/lantern/core/imageloader/a/at:b	(Landroid/content/Context;)Ljava/io/File;
    //   39: astore 10
    //   41: invokestatic 161	android/net/http/HttpResponseCache:getInstalled	()Landroid/net/http/HttpResponseCache;
    //   44: astore 8
    //   46: aload 8
    //   48: astore 7
    //   50: aload 8
    //   52: ifnonnull +15 -> 67
    //   55: aload 10
    //   57: aload 10
    //   59: invokestatic 164	com/lantern/core/imageloader/a/at:a	(Ljava/io/File;)J
    //   62: invokestatic 168	android/net/http/HttpResponseCache:install	(Ljava/io/File;J)Landroid/net/http/HttpResponseCache;
    //   65: astore 7
    //   67: aload 7
    //   69: putstatic 150	com/lantern/core/imageloader/a/aq:a	Ljava/lang/Object;
    //   72: aload 9
    //   74: monitorexit
    //   75: aload_0
    //   76: aload_1
    //   77: invokespecial 170	com/lantern/core/imageloader/a/aq:a	(Landroid/net/Uri;)Ljava/net/HttpURLConnection;
    //   80: astore 7
    //   82: aload 7
    //   84: iconst_1
    //   85: invokevirtual 174	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   88: iload_2
    //   89: ifeq +21 -> 110
    //   92: iload_2
    //   93: invokestatic 179	com/lantern/core/imageloader/a/y:c	(I)Z
    //   96: ifeq +82 -> 178
    //   99: ldc -75
    //   101: astore_1
    //   102: aload 7
    //   104: ldc -73
    //   106: aload_1
    //   107: invokevirtual 187	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 7
    //   112: invokevirtual 190	java/net/HttpURLConnection:getResponseCode	()I
    //   115: istore_3
    //   116: iload_3
    //   117: sipush 300
    //   120: if_icmplt +123 -> 243
    //   123: aload 7
    //   125: invokevirtual 193	java/net/HttpURLConnection:disconnect	()V
    //   128: new 195	com/lantern/core/imageloader/a/r$b
    //   131: dup
    //   132: new 197	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   139: iload_3
    //   140: invokevirtual 202	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   143: ldc -52
    //   145: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 7
    //   150: invokevirtual 210	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   153: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: iload_2
    //   160: iload_3
    //   161: invokespecial 214	com/lantern/core/imageloader/a/r$b:<init>	(Ljava/lang/String;II)V
    //   164: athrow
    //   165: astore 7
    //   167: aload 9
    //   169: monitorexit
    //   170: aload 7
    //   172: athrow
    //   173: astore 7
    //   175: goto -100 -> 75
    //   178: getstatic 28	com/lantern/core/imageloader/a/aq:c	Ljava/lang/ThreadLocal;
    //   181: invokevirtual 220	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   184: checkcast 197	java/lang/StringBuilder
    //   187: astore_1
    //   188: aload_1
    //   189: iconst_0
    //   190: invokevirtual 223	java/lang/StringBuilder:setLength	(I)V
    //   193: iload_2
    //   194: invokestatic 225	com/lantern/core/imageloader/a/y:a	(I)Z
    //   197: ifne +10 -> 207
    //   200: aload_1
    //   201: ldc -29
    //   203: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: iload_2
    //   208: invokestatic 229	com/lantern/core/imageloader/a/y:b	(I)Z
    //   211: ifne +24 -> 235
    //   214: aload_1
    //   215: invokevirtual 230	java/lang/StringBuilder:length	()I
    //   218: ifle +10 -> 228
    //   221: aload_1
    //   222: bipush 44
    //   224: invokevirtual 233	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload_1
    //   229: ldc -21
    //   231: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_1
    //   236: invokevirtual 211	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: astore_1
    //   240: goto -138 -> 102
    //   243: aload 7
    //   245: ldc -19
    //   247: iconst_m1
    //   248: invokevirtual 241	java/net/HttpURLConnection:getHeaderFieldInt	(Ljava/lang/String;I)I
    //   251: i2l
    //   252: lstore 5
    //   254: aload 7
    //   256: ldc -13
    //   258: invokevirtual 247	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   261: invokestatic 250	com/lantern/core/imageloader/a/at:a	(Ljava/lang/String;)Z
    //   264: istore 4
    //   266: new 252	com/lantern/core/imageloader/a/r$a
    //   269: dup
    //   270: aload 7
    //   272: invokevirtual 256	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   275: iload 4
    //   277: lload 5
    //   279: invokespecial 259	com/lantern/core/imageloader/a/r$a:<init>	(Ljava/io/InputStream;ZJ)V
    //   282: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	aq
    //   0	283	1	paramUri	Uri
    //   0	283	2	paramInt	int
    //   115	46	3	i	int
    //   264	12	4	bool	boolean
    //   252	26	5	l	long
    //   12	137	7	localObject1	Object
    //   165	6	7	localObject2	Object
    //   173	98	7	localIOException	IOException
    //   44	7	8	localHttpResponseCache	android.net.http.HttpResponseCache
    //   39	19	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   28	46	165	finally
    //   55	67	165	finally
    //   67	72	165	finally
    //   72	75	165	finally
    //   167	170	165	finally
    //   20	28	173	java/io/IOException
    //   170	173	173	java/io/IOException
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */