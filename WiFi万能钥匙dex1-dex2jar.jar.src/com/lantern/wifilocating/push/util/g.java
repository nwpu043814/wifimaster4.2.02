package com.lantern.wifilocating.push.util;

import android.content.Context;
import com.lantern.wifilocating.push.c;
import org.json.JSONException;
import org.json.JSONObject;

public class g
{
  private static g a;
  private JSONObject b;
  
  /* Error */
  private g(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: invokespecial 15	java/lang/Object:<init>	()V
    //   8: aload_1
    //   9: invokevirtual 21	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   12: ldc 23
    //   14: invokevirtual 29	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore 4
    //   19: new 31	java/io/ByteArrayOutputStream
    //   22: astore_1
    //   23: aload_1
    //   24: invokespecial 32	java/io/ByteArrayOutputStream:<init>	()V
    //   27: aload 4
    //   29: aload_1
    //   30: invokestatic 37	com/lantern/wifilocating/push/util/c:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   33: pop
    //   34: new 39	java/lang/String
    //   37: astore 4
    //   39: aload 4
    //   41: aload_1
    //   42: invokevirtual 43	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   45: ldc 45
    //   47: invokespecial 48	java/lang/String:<init>	([BLjava/lang/String;)V
    //   50: aload_1
    //   51: invokestatic 53	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   54: aload 4
    //   56: astore_1
    //   57: aload_0
    //   58: aload_1
    //   59: invokespecial 56	com/lantern/wifilocating/push/util/g:b	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: ldc 58
    //   65: iconst_0
    //   66: invokevirtual 61	com/lantern/wifilocating/push/util/g:a	(Ljava/lang/String;Z)Z
    //   69: ifeq +70 -> 139
    //   72: new 63	java/io/File
    //   75: astore_1
    //   76: aload_1
    //   77: invokestatic 69	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   80: invokevirtual 73	java/io/File:getPath	()Ljava/lang/String;
    //   83: ldc 23
    //   85: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: new 78	java/io/FileInputStream
    //   91: astore 4
    //   93: aload 4
    //   95: aload_1
    //   96: invokespecial 81	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   99: new 31	java/io/ByteArrayOutputStream
    //   102: astore_1
    //   103: aload_1
    //   104: invokespecial 32	java/io/ByteArrayOutputStream:<init>	()V
    //   107: aload 4
    //   109: aload_1
    //   110: invokestatic 37	com/lantern/wifilocating/push/util/c:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)Z
    //   113: pop
    //   114: new 39	java/lang/String
    //   117: astore_3
    //   118: aload_3
    //   119: aload_1
    //   120: invokevirtual 43	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   123: ldc 45
    //   125: invokespecial 48	java/lang/String:<init>	([BLjava/lang/String;)V
    //   128: aload_1
    //   129: invokestatic 53	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   132: aload_3
    //   133: astore_1
    //   134: aload_0
    //   135: aload_1
    //   136: invokespecial 56	com/lantern/wifilocating/push/util/g:b	(Ljava/lang/String;)V
    //   139: return
    //   140: astore_1
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_1
    //   144: invokestatic 53	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   147: aconst_null
    //   148: astore_1
    //   149: goto -92 -> 57
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: invokestatic 53	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   159: aload_2
    //   160: athrow
    //   161: astore_1
    //   162: aconst_null
    //   163: astore_1
    //   164: aload_1
    //   165: invokestatic 53	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   168: aload_2
    //   169: astore_1
    //   170: goto -36 -> 134
    //   173: astore_2
    //   174: aload_3
    //   175: astore_1
    //   176: aload_1
    //   177: invokestatic 53	com/lantern/wifilocating/push/util/j:a	(Ljava/io/Closeable;)V
    //   180: aload_2
    //   181: athrow
    //   182: astore_2
    //   183: goto -7 -> 176
    //   186: astore_3
    //   187: goto -23 -> 164
    //   190: astore_2
    //   191: goto -36 -> 155
    //   194: astore 4
    //   196: goto -53 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	g
    //   0	199	1	paramContext	Context
    //   3	1	2	localObject1	Object
    //   152	17	2	localObject2	Object
    //   173	8	2	localObject3	Object
    //   182	1	2	localObject4	Object
    //   190	1	2	localObject5	Object
    //   1	174	3	str	String
    //   186	1	3	localThrowable1	Throwable
    //   17	91	4	localObject6	Object
    //   194	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   8	27	140	java/lang/Throwable
    //   8	27	152	finally
    //   72	107	161	java/lang/Throwable
    //   72	107	173	finally
    //   107	128	182	finally
    //   107	128	186	java/lang/Throwable
    //   27	50	190	finally
    //   27	50	194	java/lang/Throwable
  }
  
  public static g a()
  {
    return a(c.a());
  }
  
  private static g a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        g localg = new com/lantern/wifilocating/push/util/g;
        localg.<init>(paramContext);
        a = localg;
      }
      return a;
    }
    finally {}
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (this.b != null) {
      str = this.b.optString(paramString1, paramString2);
    }
    return str;
  }
  
  private void b(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        this.b = localJSONObject;
      }
      catch (JSONException paramString)
      {
        h.a(paramString);
      }
    }
  }
  
  public static boolean b()
  {
    return a(c.a()).a("push-debug", false);
  }
  
  public static String c()
  {
    return a(c.a()).a("push-login", null);
  }
  
  public static String d()
  {
    return a(c.a()).a("push-socket", null);
  }
  
  public static String e()
  {
    return a(c.a()).a("push-sync", null);
  }
  
  public static String f()
  {
    return a(c.a()).a("push-dc", null);
  }
  
  public static String g()
  {
    return a(c.a()).a("wk-pkg", "com.snda.wifilocating");
  }
  
  public static String h()
  {
    return a(c.a()).a("wk-bro-act", "wifi.intent.action.BROWSER");
  }
  
  public final String a(String paramString)
  {
    return a(paramString, null);
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (this.b != null) {
      bool = this.b.optBoolean(paramString, paramBoolean);
    }
    return bool;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */