package com.lantern.core.g;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.model.WkAccessPoint;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public final class j
{
  private static j c;
  private HashMap<WkAccessPoint, Integer> a = new HashMap();
  private boolean b = true;
  private String d = "http://check02.51y5.net/cp.a";
  private String e = "c.51y5.net";
  private boolean f;
  private boolean g;
  private ExecutorService h = Executors.newFixedThreadPool(3);
  
  private j()
  {
    Object localObject = com.lantern.core.config.d.a(c.getAppContext()).a("netmonitor");
    if (localObject != null)
    {
      this.f = ((JSONObject)localObject).optBoolean("apple");
      this.g = ((JSONObject)localObject).optBoolean("isupload");
      String str = ((JSONObject)localObject).optString("checkurl");
      localObject = ((JSONObject)localObject).optString("serverurl");
      h.a("apple:%s,checkurl:%s,serverurl:%s", new Object[] { Boolean.valueOf(this.f), str, localObject });
      if ((!TextUtils.isEmpty(str)) && (str.startsWith("http"))) {
        this.d = str;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.e = ((String)localObject);
      }
    }
  }
  
  public static j a()
  {
    if (c == null) {
      c = new j();
    }
    return c;
  }
  
  public static WkAccessPoint a(Context paramContext)
  {
    paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
    String str2;
    if (paramContext != null)
    {
      String str1 = paramContext.getSSID();
      str2 = paramContext.getBSSID();
      paramContext = str1;
      if (str1 != null)
      {
        paramContext = str1;
        if (str1.length() > 2)
        {
          paramContext = str1;
          if (str1.startsWith("\""))
          {
            paramContext = str1;
            if (str1.endsWith("\"")) {
              paramContext = str1.substring(1, str1.length() - 1);
            }
          }
        }
      }
    }
    for (paramContext = new WkAccessPoint(paramContext, str2);; paramContext = null) {
      return paramContext;
    }
  }
  
  private static InetAddress a(String paramString)
  {
    try
    {
      arrayOfInetAddress = InetAddress.getAllByName(paramString);
      j = arrayOfInetAddress.length;
      i = 0;
    }
    catch (UnknownHostException paramString)
    {
      for (;;)
      {
        InetAddress[] arrayOfInetAddress;
        int j;
        paramString = null;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i;
        paramString = null;
        continue;
        i++;
        continue;
        paramString = null;
      }
    }
    if (i < j)
    {
      paramString = arrayOfInetAddress[i];
      if ((paramString instanceof Inet4Address)) {
        return paramString;
      }
    }
  }
  
  private static void a(int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return;
      Object localObject = new String(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
      if (((String)localObject).length() >= 250) {
        paramArrayOfByte = ((String)localObject).substring(0, 250);
      }
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("type", String.valueOf(paramInt));
        ((JSONObject)localObject).put("html", paramArrayOfByte);
        h.a("networkomnitor " + ((JSONObject)localObject).toString(), new Object[0]);
        com.lantern.analytics.a.e().b("005060", (JSONObject)localObject);
      }
      catch (JSONException paramArrayOfByte)
      {
        for (;;)
        {
          h.a(paramArrayOfByte);
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 256) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static WkAccessPoint b(Context paramContext)
  {
    WifiInfo localWifiInfo;
    if (com.bluefay.a.a.a(paramContext))
    {
      localWifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if ((localWifiInfo == null) || (localWifiInfo.getSSID() == null)) {
        paramContext = null;
      }
    }
    for (;;)
    {
      return paramContext;
      paramContext = u.a(localWifiInfo.getSSID());
      if ((paramContext == null) || (paramContext.length() == 0))
      {
        paramContext = null;
      }
      else
      {
        paramContext = new WkAccessPoint(paramContext, localWifiInfo.getBSSID());
        continue;
        paramContext = null;
      }
    }
  }
  
  public static boolean b(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  /* Error */
  private int f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: new 197	java/lang/StringBuilder
    //   12: dup
    //   13: ldc -10
    //   15: invokespecial 202	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: aload_0
    //   19: getfield 53	com/lantern/core/g/j:e	Ljava/lang/String;
    //   22: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc -8
    //   27: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: astore 8
    //   35: aload 8
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokestatic 104	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: iconst_m1
    //   45: istore_1
    //   46: aload 4
    //   48: astore_3
    //   49: new 250	java/net/URL
    //   52: astore 5
    //   54: aload 4
    //   56: astore_3
    //   57: aload 5
    //   59: aload 8
    //   61: invokespecial 251	java/net/URL:<init>	(Ljava/lang/String;)V
    //   64: aload 4
    //   66: astore_3
    //   67: aload 5
    //   69: invokevirtual 255	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   72: checkcast 257	java/net/HttpURLConnection
    //   75: astore 4
    //   77: aload 4
    //   79: iconst_0
    //   80: invokevirtual 261	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   83: aload 4
    //   85: sipush 8000
    //   88: invokevirtual 265	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   91: aload 4
    //   93: sipush 8000
    //   96: invokevirtual 268	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   99: aload 4
    //   101: iconst_0
    //   102: invokevirtual 271	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   105: aload 4
    //   107: invokevirtual 275	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   110: pop
    //   111: aload 4
    //   113: invokevirtual 278	java/net/HttpURLConnection:getResponseCode	()I
    //   116: istore_2
    //   117: iload_2
    //   118: istore_1
    //   119: aload 4
    //   121: ifnull +158 -> 279
    //   124: aload 4
    //   126: invokevirtual 281	java/net/HttpURLConnection:disconnect	()V
    //   129: iload_2
    //   130: istore_1
    //   131: iload_1
    //   132: ireturn
    //   133: astore 5
    //   135: aload 6
    //   137: astore 4
    //   139: aload 4
    //   141: astore_3
    //   142: new 197	java/lang/StringBuilder
    //   145: astore 6
    //   147: aload 4
    //   149: astore_3
    //   150: aload 6
    //   152: ldc_w 283
    //   155: invokespecial 202	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload 4
    //   160: astore_3
    //   161: aload 6
    //   163: aload 5
    //   165: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 288	com/bluefay/b/h:c	(Ljava/lang/String;)V
    //   174: aload 4
    //   176: ifnull +103 -> 279
    //   179: aload 4
    //   181: invokevirtual 281	java/net/HttpURLConnection:disconnect	()V
    //   184: iconst_m1
    //   185: istore_1
    //   186: goto -55 -> 131
    //   189: astore 5
    //   191: aload 7
    //   193: astore 4
    //   195: aload 4
    //   197: astore_3
    //   198: new 197	java/lang/StringBuilder
    //   201: astore 6
    //   203: aload 4
    //   205: astore_3
    //   206: aload 6
    //   208: ldc_w 290
    //   211: invokespecial 202	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload 4
    //   216: astore_3
    //   217: aload 6
    //   219: aload 5
    //   221: invokevirtual 286	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 288	com/bluefay/b/h:c	(Ljava/lang/String;)V
    //   230: aload 4
    //   232: ifnull +47 -> 279
    //   235: aload 4
    //   237: invokevirtual 281	java/net/HttpURLConnection:disconnect	()V
    //   240: iconst_m1
    //   241: istore_1
    //   242: goto -111 -> 131
    //   245: astore 5
    //   247: aload_3
    //   248: astore 4
    //   250: aload 5
    //   252: astore_3
    //   253: aload 4
    //   255: ifnull +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 281	java/net/HttpURLConnection:disconnect	()V
    //   263: aload_3
    //   264: athrow
    //   265: astore_3
    //   266: goto -13 -> 253
    //   269: astore 5
    //   271: goto -76 -> 195
    //   274: astore 5
    //   276: goto -137 -> 139
    //   279: goto -148 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	j
    //   45	197	1	i	int
    //   116	14	2	j	int
    //   48	216	3	localObject1	Object
    //   265	1	3	localObject2	Object
    //   4	255	4	localObject3	Object
    //   52	16	5	localURL	java.net.URL
    //   133	31	5	localIOException1	java.io.IOException
    //   189	31	5	localException1	Exception
    //   245	6	5	localObject4	Object
    //   269	1	5	localException2	Exception
    //   274	1	5	localIOException2	java.io.IOException
    //   7	211	6	localStringBuilder	StringBuilder
    //   1	191	7	localObject5	Object
    //   33	27	8	str	String
    // Exception table:
    //   from	to	target	type
    //   49	54	133	java/io/IOException
    //   57	64	133	java/io/IOException
    //   67	77	133	java/io/IOException
    //   49	54	189	java/lang/Exception
    //   57	64	189	java/lang/Exception
    //   67	77	189	java/lang/Exception
    //   49	54	245	finally
    //   57	64	245	finally
    //   67	77	245	finally
    //   142	147	245	finally
    //   150	158	245	finally
    //   161	174	245	finally
    //   198	203	245	finally
    //   206	214	245	finally
    //   217	230	245	finally
    //   77	117	265	finally
    //   77	117	269	java/lang/Exception
    //   77	117	274	java/io/IOException
  }
  
  /* Error */
  public final int a(WkAccessPoint paramWkAccessPoint)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/lantern/core/g/j:a	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 295	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifeq +22 -> 32
    //   13: aload_0
    //   14: getfield 45	com/lantern/core/g/j:a	Ljava/util/HashMap;
    //   17: aload_1
    //   18: invokevirtual 299	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 301	java/lang/Integer
    //   24: invokevirtual 304	java/lang/Integer:intValue	()I
    //   27: istore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_2
    //   31: ireturn
    //   32: iconst_m1
    //   33: istore_2
    //   34: aload_0
    //   35: monitorexit
    //   36: goto -6 -> 30
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	j
    //   0	44	1	paramWkAccessPoint	WkAccessPoint
    //   27	7	2	i	int
    // Exception table:
    //   from	to	target	type
    //   2	30	39	finally
    //   34	36	39	finally
    //   40	42	39	finally
  }
  
  public final void a(com.bluefay.b.a parama)
  {
    WkAccessPoint localWkAccessPoint = a(c.getAppContext());
    parama = new d(Looper.getMainLooper(), localWkAccessPoint, parama);
    h.a("check network threads:" + localWkAccessPoint);
    if ((this.b) && (this.a.containsKey(localWkAccessPoint)))
    {
      int i = ((Integer)this.a.get(localWkAccessPoint)).intValue();
      if (i == 1)
      {
        h.a("found cache status online");
        parama.obtainMessage(300, i, 0).sendToTarget();
      }
    }
    for (;;)
    {
      return;
      parama.sendEmptyMessageDelayed(400, 8000L);
      this.h.execute(new b(localWkAccessPoint, parama));
      this.h.execute(new a(localWkAccessPoint, parama));
      if (this.f) {
        this.h.execute(new c(localWkAccessPoint, parama));
      }
    }
  }
  
  public final boolean a(WkAccessPoint paramWkAccessPoint, int paramInt)
  {
    boolean bool2 = false;
    h.a("Current ap:" + paramWkAccessPoint + " value:" + paramInt);
    boolean bool1 = bool2;
    if (paramWkAccessPoint != null)
    {
      int i = a(paramWkAccessPoint);
      bool1 = bool2;
      if (i != paramInt) {
        h.a("status diff:" + i);
      }
    }
    try
    {
      this.a.put(paramWkAccessPoint, Integer.valueOf(paramInt));
      bool1 = true;
      return bool1;
    }
    finally {}
  }
  
  public final void b()
  {
    try
    {
      if (this.a != null) {
        this.a.clear();
      }
      return;
    }
    finally {}
  }
  
  public final int c()
  {
    Object localObject = new com.bluefay.b.d("http://captive.apple.com");
    ((com.bluefay.b.d)localObject).a(8000, 8000);
    ((com.bluefay.b.d)localObject).a();
    localObject = ((com.bluefay.b.d)localObject).c();
    int i;
    if ((localObject == null) || (localObject.length == 0))
    {
      h.c("network error");
      i = 0;
    }
    for (;;)
    {
      return i;
      if ((localObject.length > 0) && (new String((byte[])localObject).startsWith("<HTML><HEAD><TITLE>Success</TITLE></HEAD><BODY>Success</BODY></HTML>")))
      {
        h.a("check successfully");
        i = 1;
      }
      else
      {
        int j = 256;
        i = j;
        if (this.g)
        {
          a(2, (byte[])localObject);
          i = j;
        }
      }
    }
  }
  
  public final int d()
  {
    int j = 0;
    int i;
    if (a("c.51y5.net") == null)
    {
      h.c("lookupHost failed c.51y5.net");
      i = j;
    }
    for (;;)
    {
      return i;
      int k = f();
      if (k == 204)
      {
        i = 1;
      }
      else
      {
        i = j;
        if (k >= 200)
        {
          i = j;
          if (k <= 399) {
            i = 256;
          }
        }
      }
    }
  }
  
  public final int e()
  {
    int i = 1;
    Object localObject = new com.bluefay.b.d(this.d + "?time=" + System.currentTimeMillis());
    ((com.bluefay.b.d)localObject).a(8000, 8000);
    ((com.bluefay.b.d)localObject).a();
    localObject = ((com.bluefay.b.d)localObject).c();
    if ((localObject == null) || (localObject.length == 0))
    {
      h.c("network error");
      i = 0;
    }
    for (;;)
    {
      return i;
      if ((localObject.length == 1) && (localObject[0] == 48))
      {
        h.a("check successfully");
      }
      else
      {
        int j = 256;
        i = j;
        if (this.g)
        {
          a(0, (byte[])localObject);
          i = j;
        }
      }
    }
  }
  
  private final class a
    implements Runnable
  {
    private WkAccessPoint b;
    private Handler c;
    
    public a(WkAccessPoint paramWkAccessPoint, Handler paramHandler)
    {
      this.b = paramWkAccessPoint;
      this.c = paramHandler;
    }
    
    public final void run()
    {
      int i = j.this.d();
      this.c.obtainMessage(200, i, 1).sendToTarget();
    }
  }
  
  private final class b
    implements Runnable
  {
    private WkAccessPoint b;
    private Handler c;
    
    public b(WkAccessPoint paramWkAccessPoint, Handler paramHandler)
    {
      this.b = paramWkAccessPoint;
      this.c = paramHandler;
    }
    
    public final void run()
    {
      int i = j.this.e();
      this.c.obtainMessage(200, i, 0).sendToTarget();
    }
  }
  
  private final class c
    implements Runnable
  {
    private WkAccessPoint b;
    private Handler c;
    
    public c(WkAccessPoint paramWkAccessPoint, Handler paramHandler)
    {
      this.b = paramWkAccessPoint;
      this.c = paramHandler;
    }
    
    public final void run()
    {
      int i = j.this.c();
      this.c.obtainMessage(200, i, 2).sendToTarget();
    }
  }
  
  final class d
    extends Handler
  {
    private WkAccessPoint b;
    private com.bluefay.b.a c;
    private boolean d;
    private int[] e = new int[3];
    
    public d(Looper paramLooper, WkAccessPoint paramWkAccessPoint, com.bluefay.b.a parama)
    {
      super();
      this.b = paramWkAccessPoint;
      this.c = parama;
      this.e[0] = -1;
      this.e[1] = -1;
      this.e[2] = -1;
    }
    
    private int a()
    {
      int i = 0;
      int j = Math.max(Math.max(this.e[0], this.e[1]), this.e[2]);
      if (j < 0) {}
      for (;;)
      {
        return i;
        i = j;
      }
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int j = paramMessage.what;
      int i = paramMessage.arg1;
      int k = paramMessage.arg2;
      h.b("what:%d, result:%d,src:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(k) });
      if ((j != 200) && (j != 400) && (j != 300)) {}
      label335:
      label412:
      for (;;)
      {
        return;
        if (j == 300)
        {
          this.c.a(1, j.c(i), Integer.valueOf(i));
        }
        else if ((k >= 0) && (k <= 2))
        {
          if (j == 200) {
            this.e[paramMessage.arg2] = paramMessage.arg1;
          }
          if (!this.d) {
            if (j == 400)
            {
              h.b("Checking ap %s timout", new Object[] { this.b });
              this.d = true;
              i = a();
              this.c.a(1, j.c(i), Integer.valueOf(i));
            }
            else
            {
              j = 0;
              i = 0;
              while (i < 3)
              {
                k = j;
                if (this.e[i] != -1) {
                  k = j + 1;
                }
                i++;
                j = k;
              }
              if (j >= 2) {}
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label335;
                }
                this.d = true;
                removeMessages(400);
                i = a();
                if ((j.a(j.this)) && (this.b != null) && (i == 1) && (j.this.a(this.b, i)))
                {
                  paramMessage = Message.obtain();
                  paramMessage.what = 128036;
                  paramMessage.arg1 = i;
                  c.dispatch(paramMessage);
                }
                this.c.a(1, j.c(i), Integer.valueOf(i));
                break;
              }
              if ((this.e[0] != -1) && (this.e[1] != -1) && (this.e[2] != -1)) {}
              for (i = 1;; i = 0)
              {
                if (i == 0) {
                  break label412;
                }
                this.d = true;
                removeMessages(400);
                i = a();
                this.c.a(1, j.c(i), Integer.valueOf(i));
                break;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */