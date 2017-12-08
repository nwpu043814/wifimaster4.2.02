package ct;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Pair;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.eclipse.jdt.annotation.Nullable;

public class bi
{
  private static volatile bi l;
  public final Context a;
  private final bj b;
  private final ExecutorService c;
  private final HashMap<String, bm> d;
  private final PackageManager e;
  private final TelephonyManager f;
  private final WifiManager g;
  private final LocationManager h;
  private final cf i;
  private final cq j;
  private final CountDownLatch k;
  private List<di> m;
  
  private bi(Context paramContext)
  {
    this.a = paramContext;
    this.e = paramContext.getPackageManager();
    this.f = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.g = ((WifiManager)paramContext.getSystemService("wifi"));
    this.h = ((LocationManager)paramContext.getSystemService("location"));
    this.i = new ce(this);
    Object localObject = new Bundle();
    ((Bundle)localObject).putString("channelId", b.a.d(paramContext.getPackageName()));
    new cr.1();
    this.j = new cd(paramContext, ((Bundle)localObject).getString("channelId"));
    localObject = new ThreadPoolExecutor(1, 5, 60000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    if (Build.VERSION.SDK_INT >= 9) {
      ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    }
    this.c = ((ExecutorService)localObject);
    this.d = new HashMap();
    this.d.put("cell", new bn("cell"));
    this.d.put("so", new bo(paramContext, "so"));
    this.b = new bj(this);
    this.b.h = b(paramContext);
    this.k = new CountDownLatch(1);
    new Thread(new bi.1(this)).start();
  }
  
  public static bi a(Context paramContext)
  {
    if (l == null) {}
    try
    {
      if (l == null)
      {
        bi localbi = new ct/bi;
        localbi.<init>(paramContext);
        l = localbi;
      }
      return l;
    }
    finally {}
  }
  
  private static String b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
        if (paramContext == null) {
          continue;
        }
        if (!paramContext.containsKey("TencentGeoLocationSDK")) {
          continue;
        }
        paramContext = paramContext.getString("TencentGeoLocationSDK");
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext = "";
        continue;
      }
      return paramContext;
      if (paramContext.containsKey("TencentMapSDK")) {
        paramContext = paramContext.getString("TencentMapSDK");
      } else {
        paramContext = "";
      }
    }
  }
  
  private PackageInfo l()
  {
    try
    {
      PackageInfo localPackageInfo1 = this.e.getPackageInfo(this.a.getPackageName(), 0);
      return localPackageInfo1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        PackageInfo localPackageInfo2 = new PackageInfo();
      }
    }
  }
  
  @Nullable
  public final TelephonyManager a()
  {
    return this.f;
  }
  
  public final bm a(String paramString)
  {
    paramString = (bm)this.d.get(paramString);
    if (paramString != null) {}
    for (;;)
    {
      return paramString;
      paramString = bl.a;
    }
  }
  
  public final String a(String paramString, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = this.j.a(paramString, paramArrayOfByte);
    paramString = b.a.c((byte[])paramArrayOfByte.first);
    if (paramString != null) {}
    for (paramString = new String(paramString, (String)paramArrayOfByte.second);; paramString = "{}")
    {
      return paramString;
      b.a.a("AppContext", "postSync: inflate failed");
    }
  }
  
  public final void a(Object paramObject)
  {
    for (;;)
    {
      Object localObject1;
      Class[] arrayOfClass;
      try
      {
        if (this.m == null)
        {
          localObject1 = new java/util/ArrayList;
          ((ArrayList)localObject1).<init>();
          this.m = ((List)localObject1);
        }
        localObject1 = this.m.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label198;
        }
        Object localObject2 = ((di)((Iterator)localObject1).next()).c;
        if (paramObject != localObject2) {
          continue;
        }
        n = 1;
        if (n != 0) {
          return;
        }
        localObject2 = paramObject.getClass().getDeclaredMethods();
        int i1 = localObject2.length;
        n = 0;
        if (n >= i1) {
          continue;
        }
        localObject1 = localObject2[n];
        localObject3 = ((Method)localObject1).getName();
        if ((!((String)localObject3).startsWith("on")) || (!((String)localObject3).endsWith("Event"))) {
          break label192;
        }
        arrayOfClass = ((Method)localObject1).getParameterTypes();
        if (arrayOfClass.length != 1)
        {
          paramObject = new java/lang/IllegalArgumentException;
          ((IllegalArgumentException)paramObject).<init>("EventHandler methods must specify a single Object paramter.");
          throw ((Throwable)paramObject);
        }
      }
      finally {}
      Object localObject3 = new ct/di;
      ((di)localObject3).<init>(arrayOfClass[0], (Method)localObject1, paramObject);
      this.m.add(localObject3);
      label192:
      n++;
      continue;
      label198:
      int n = 0;
    }
  }
  
  @Nullable
  public final WifiManager b()
  {
    return this.g;
  }
  
  public final void b(Object paramObject)
  {
    List localList;
    try
    {
      localList = this.m;
      if (localList == null) {
        break label119;
      }
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        di localdi = (di)localIterator.next();
        Object localObject = localdi.c;
        if ((localObject == null) || (localObject == paramObject)) {
          localArrayList.add(localdi);
        }
      }
      paramObject = localArrayList.iterator();
    }
    finally {}
    while (((Iterator)paramObject).hasNext()) {
      localList.remove((di)((Iterator)paramObject).next());
    }
    label119:
  }
  
  @Nullable
  public final LocationManager c()
  {
    return this.h;
  }
  
  /* Error */
  public final void c(@Nullable Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 275	ct/bi:m	Ljava/util/List;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnull -9 -> 6
    //   18: aload_3
    //   19: invokeinterface 284 1 0
    //   24: astore_3
    //   25: aload_3
    //   26: invokeinterface 290 1 0
    //   31: ifeq -25 -> 6
    //   34: aload_3
    //   35: invokeinterface 294 1 0
    //   40: checkcast 296	ct/di
    //   43: astore 4
    //   45: aload_1
    //   46: invokevirtual 302	java/lang/Object:getClass	()Ljava/lang/Class;
    //   49: aload 4
    //   51: getfield 349	ct/di:a	Ljava/lang/Class;
    //   54: invokevirtual 352	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   57: istore_2
    //   58: iload_2
    //   59: ifeq -34 -> 25
    //   62: aload 4
    //   64: getfield 355	ct/di:b	Ljava/lang/reflect/Method;
    //   67: aload 4
    //   69: getfield 298	ct/di:c	Ljava/lang/Object;
    //   72: iconst_1
    //   73: anewarray 4	java/lang/Object
    //   76: dup
    //   77: iconst_0
    //   78: aload_1
    //   79: aastore
    //   80: invokevirtual 359	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   83: pop
    //   84: goto -59 -> 25
    //   87: astore 4
    //   89: ldc_w 266
    //   92: ldc -40
    //   94: aload 4
    //   96: invokestatic 362	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   99: goto -74 -> 25
    //   102: astore_1
    //   103: aload_0
    //   104: monitorexit
    //   105: aload_1
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	bi
    //   0	107	1	paramObject	Object
    //   57	2	2	bool	boolean
    //   13	22	3	localObject	Object
    //   43	25	4	localdi	di
    //   87	8	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   62	84	87	java/lang/Exception
    //   9	14	102	finally
    //   18	25	102	finally
    //   25	58	102	finally
    //   62	84	102	finally
    //   89	99	102	finally
  }
  
  public final boolean d()
  {
    if (this.f != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean e()
  {
    if (this.g != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean f()
  {
    if (this.h != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final cf g()
  {
    return this.i;
  }
  
  public final bj h()
  {
    return this.b;
  }
  
  public final bj i()
  {
    bj localbj = null;
    if (-1L > 0L) {}
    try
    {
      if (!this.k.await(-1L, TimeUnit.MILLISECONDS)) {}
      for (;;)
      {
        return localbj;
        this.k.await();
        localbj = this.b;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public final ExecutorService j()
  {
    return this.c;
  }
  
  /* Error */
  final void k()
  {
    // Byte code:
    //   0: ldc_w 266
    //   3: ldc_w 384
    //   6: invokestatic 270	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 161	ct/bi:b	Lct/bj;
    //   13: astore 7
    //   15: new 386	java/io/FileInputStream
    //   18: astore 5
    //   20: new 388	java/io/File
    //   23: astore 6
    //   25: aload 6
    //   27: invokestatic 394	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   30: ldc_w 396
    //   33: invokespecial 399	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   36: aload 5
    //   38: aload 6
    //   40: invokespecial 402	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: aload 5
    //   45: ifnonnull +681 -> 726
    //   48: aload_0
    //   49: getfield 39	ct/bi:a	Landroid/content/Context;
    //   52: invokevirtual 406	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   55: ldc_w 396
    //   58: invokevirtual 412	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   61: astore 6
    //   63: aload 6
    //   65: ifnull +710 -> 775
    //   68: sipush 1024
    //   71: newarray <illegal type>
    //   73: astore 5
    //   75: aload 6
    //   77: aload 5
    //   79: invokevirtual 418	java/io/InputStream:read	([B)I
    //   82: istore_1
    //   83: new 258	java/lang/String
    //   86: astore 8
    //   88: aload 8
    //   90: aload 5
    //   92: iconst_0
    //   93: iload_1
    //   94: invokespecial 421	java/lang/String:<init>	([BII)V
    //   97: new 423	org/json/JSONObject
    //   100: astore 5
    //   102: aload 5
    //   104: aload 8
    //   106: invokespecial 424	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   109: aload 6
    //   111: invokestatic 427	ct/b$a:a	(Ljava/io/Closeable;)V
    //   114: aload 5
    //   116: ifnull +162 -> 278
    //   119: aload 5
    //   121: ldc_w 428
    //   124: iconst_0
    //   125: invokevirtual 432	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   128: pop
    //   129: aload 5
    //   131: ldc_w 434
    //   134: iconst_0
    //   135: invokevirtual 432	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   138: pop
    //   139: aload 5
    //   141: ldc_w 436
    //   144: iconst_0
    //   145: invokevirtual 432	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   148: pop
    //   149: aload 5
    //   151: ldc_w 438
    //   154: iconst_0
    //   155: invokevirtual 432	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   158: pop
    //   159: aload 5
    //   161: ldc_w 440
    //   164: iconst_0
    //   165: invokevirtual 432	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   168: pop
    //   169: aload 5
    //   171: ldc_w 442
    //   174: ldc2_w 443
    //   177: invokevirtual 448	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   180: pop2
    //   181: aload 5
    //   183: ldc_w 450
    //   186: ldc2_w 451
    //   189: invokevirtual 448	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   192: pop2
    //   193: aload 7
    //   195: aload 5
    //   197: ldc_w 454
    //   200: iconst_1
    //   201: invokevirtual 432	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   204: putfield 458	ct/bj:r	Z
    //   207: aload 7
    //   209: aload 5
    //   211: ldc_w 460
    //   214: iconst_0
    //   215: invokevirtual 432	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   218: putfield 462	ct/bj:s	Z
    //   221: aload 7
    //   223: aload 5
    //   225: ldc_w 463
    //   228: iconst_1
    //   229: invokevirtual 432	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   232: putfield 466	ct/bj:t	Z
    //   235: aload 5
    //   237: ldc_w 468
    //   240: ldc_w 470
    //   243: invokevirtual 474	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   246: astore 6
    //   248: aload 7
    //   250: aload 6
    //   252: putfield 476	ct/bj:o	Ljava/lang/String;
    //   255: aload 7
    //   257: aload 6
    //   259: putfield 479	ct/bj:q	Ljava/lang/String;
    //   262: aload 7
    //   264: aload 5
    //   266: ldc_w 481
    //   269: ldc_w 483
    //   272: invokevirtual 474	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   275: putfield 486	ct/bj:p	Ljava/lang/String;
    //   278: aload_0
    //   279: invokespecial 488	ct/bi:l	()Landroid/content/pm/PackageInfo;
    //   282: astore 6
    //   284: aload 6
    //   286: getfield 491	android/content/pm/PackageInfo:versionCode	I
    //   289: istore_1
    //   290: aload 7
    //   292: aload 6
    //   294: getfield 494	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   297: putfield 496	ct/bj:i	Ljava/lang/String;
    //   300: aload_0
    //   301: getfield 39	ct/bi:a	Landroid/content/Context;
    //   304: invokevirtual 499	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   307: aload_0
    //   308: getfield 47	ct/bi:e	Landroid/content/pm/PackageManager;
    //   311: invokevirtual 503	android/content/pm/ApplicationInfo:loadLabel	(Landroid/content/pm/PackageManager;)Ljava/lang/CharSequence;
    //   314: astore 5
    //   316: aload 5
    //   318: ifnull +433 -> 751
    //   321: aload 5
    //   323: invokeinterface 508 1 0
    //   328: astore 5
    //   330: aload 7
    //   332: aload 5
    //   334: putfield 510	ct/bj:j	Ljava/lang/String;
    //   337: aload_0
    //   338: getfield 57	ct/bi:f	Landroid/telephony/TelephonyManager;
    //   341: astore 9
    //   343: aload 9
    //   345: ifnull +103 -> 448
    //   348: iconst_2
    //   349: newarray <illegal type>
    //   351: astore 5
    //   353: aload 9
    //   355: aload 5
    //   357: invokestatic 515	ct/db:a	(Landroid/telephony/TelephonyManager;[I)V
    //   360: aload 7
    //   362: aload 5
    //   364: iconst_0
    //   365: iaload
    //   366: putfield 517	ct/bj:k	I
    //   369: aload 7
    //   371: aload 5
    //   373: iconst_1
    //   374: iaload
    //   375: putfield 519	ct/bj:l	I
    //   378: aload 7
    //   380: aload 9
    //   382: invokevirtual 523	android/telephony/TelephonyManager:getPhoneType	()I
    //   385: putfield 525	ct/bj:b	I
    //   388: aload 9
    //   390: invokevirtual 528	android/telephony/TelephonyManager:getDeviceId	()Ljava/lang/String;
    //   393: getstatic 533	ct/dg:a	Ljava/util/regex/Pattern;
    //   396: invokestatic 536	ct/dg:a	(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/String;
    //   399: astore 8
    //   401: aload 9
    //   403: invokevirtual 539	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   406: getstatic 541	ct/dg:b	Ljava/util/regex/Pattern;
    //   409: invokestatic 536	ct/dg:a	(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/String;
    //   412: astore 5
    //   414: aload 9
    //   416: invokevirtual 544	android/telephony/TelephonyManager:getLine1Number	()Ljava/lang/String;
    //   419: getstatic 546	ct/dg:c	Ljava/util/regex/Pattern;
    //   422: invokestatic 536	ct/dg:a	(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/String;
    //   425: astore 9
    //   427: aload 7
    //   429: aload 8
    //   431: putfield 548	ct/bj:c	Ljava/lang/String;
    //   434: aload 7
    //   436: aload 5
    //   438: putfield 550	ct/bj:d	Ljava/lang/String;
    //   441: aload 7
    //   443: aload 9
    //   445: putfield 552	ct/bj:e	Ljava/lang/String;
    //   448: aload 7
    //   450: aload_0
    //   451: invokestatic 557	ct/dh:c	(Lct/bi;)Ljava/lang/String;
    //   454: ldc_w 559
    //   457: ldc -40
    //   459: invokevirtual 562	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   462: getstatic 568	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   465: invokevirtual 572	java/lang/String:toUpperCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   468: getstatic 574	ct/dg:d	Ljava/util/regex/Pattern;
    //   471: invokestatic 536	ct/dg:a	(Ljava/lang/String;Ljava/util/regex/Pattern;)Ljava/lang/String;
    //   474: putfield 576	ct/bj:f	Ljava/lang/String;
    //   477: aload_0
    //   478: getfield 47	ct/bi:e	Landroid/content/pm/PackageManager;
    //   481: astore 5
    //   483: aload 5
    //   485: ldc_w 578
    //   488: invokevirtual 581	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   491: istore_2
    //   492: aload 5
    //   494: ldc_w 583
    //   497: invokevirtual 581	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   500: istore 4
    //   502: aload 5
    //   504: ldc_w 585
    //   507: invokevirtual 581	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   510: istore_3
    //   511: new 587	java/lang/StringBuilder
    //   514: astore 5
    //   516: aload 5
    //   518: ldc_w 589
    //   521: invokespecial 590	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   524: ldc_w 266
    //   527: aload 5
    //   529: iload_2
    //   530: invokevirtual 594	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   533: ldc_w 596
    //   536: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: iload 4
    //   541: invokevirtual 594	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   544: ldc_w 601
    //   547: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: iload_3
    //   551: invokevirtual 594	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   554: invokevirtual 602	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 270	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   560: new 587	java/lang/StringBuilder
    //   563: astore 5
    //   565: aload 5
    //   567: invokespecial 603	java/lang/StringBuilder:<init>	()V
    //   570: aload 5
    //   572: ldc_w 605
    //   575: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: getstatic 610	android/os/Build:MODEL	Ljava/lang/String;
    //   581: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: ldc_w 612
    //   587: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: getstatic 615	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   593: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: ldc_w 612
    //   599: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload 7
    //   604: invokevirtual 617	ct/bj:a	()Ljava/lang/String;
    //   607: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: ldc_w 619
    //   613: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload 7
    //   618: getfield 517	ct/bj:k	I
    //   621: invokevirtual 622	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   624: ldc_w 612
    //   627: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload 7
    //   632: getfield 519	ct/bj:l	I
    //   635: invokevirtual 622	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   638: ldc_w 624
    //   641: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: aload 6
    //   646: getfield 491	android/content/pm/PackageInfo:versionCode	I
    //   649: invokevirtual 622	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   652: ldc_w 612
    //   655: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload 6
    //   660: getfield 494	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   663: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: ldc_w 626
    //   669: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload 7
    //   674: invokevirtual 628	ct/bj:d	()Ljava/lang/String;
    //   677: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: ldc_w 612
    //   683: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload 7
    //   688: invokevirtual 630	ct/bj:e	()Ljava/lang/String;
    //   691: invokevirtual 599	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: ldc_w 266
    //   698: aload 5
    //   700: invokevirtual 602	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 270	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   706: ldc_w 266
    //   709: ldc_w 632
    //   712: invokestatic 270	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   715: return
    //   716: astore 5
    //   718: aconst_null
    //   719: astore 5
    //   721: goto -678 -> 43
    //   724: astore 6
    //   726: aload 5
    //   728: astore 6
    //   730: goto -667 -> 63
    //   733: astore 5
    //   735: ldc_w 266
    //   738: ldc -40
    //   740: aload 5
    //   742: invokestatic 362	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   745: aconst_null
    //   746: astore 5
    //   748: goto -639 -> 109
    //   751: ldc_w 634
    //   754: astore 5
    //   756: goto -426 -> 330
    //   759: astore 5
    //   761: ldc_w 266
    //   764: ldc_w 636
    //   767: aload 5
    //   769: invokestatic 362	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   772: goto -57 -> 715
    //   775: aconst_null
    //   776: astore 5
    //   778: goto -664 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	781	0	this	bi
    //   82	208	1	n	int
    //   491	39	2	bool1	boolean
    //   510	41	3	bool2	boolean
    //   500	40	4	bool3	boolean
    //   18	681	5	localObject1	Object
    //   716	1	5	localFileNotFoundException	java.io.FileNotFoundException
    //   719	8	5	localObject2	Object
    //   733	8	5	localException	Exception
    //   746	9	5	str1	String
    //   759	9	5	localThrowable	Throwable
    //   776	1	5	localObject3	Object
    //   23	636	6	localObject4	Object
    //   724	1	6	localIOException	java.io.IOException
    //   728	1	6	localObject5	Object
    //   13	674	7	localbj	bj
    //   86	344	8	str2	String
    //   341	103	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   15	43	716	java/io/FileNotFoundException
    //   48	63	724	java/io/IOException
    //   75	109	733	java/lang/Exception
    //   0	15	759	java/lang/Throwable
    //   15	43	759	java/lang/Throwable
    //   48	63	759	java/lang/Throwable
    //   68	75	759	java/lang/Throwable
    //   75	109	759	java/lang/Throwable
    //   109	114	759	java/lang/Throwable
    //   119	278	759	java/lang/Throwable
    //   278	316	759	java/lang/Throwable
    //   321	330	759	java/lang/Throwable
    //   330	343	759	java/lang/Throwable
    //   348	448	759	java/lang/Throwable
    //   448	715	759	java/lang/Throwable
    //   735	745	759	java/lang/Throwable
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */