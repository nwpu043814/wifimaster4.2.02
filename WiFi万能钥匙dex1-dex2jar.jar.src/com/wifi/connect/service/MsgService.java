package com.wifi.connect.service;

import android.content.Context;
import android.content.Intent;
import com.bluefay.b.h;
import com.bluefay.e.a;
import com.lantern.analytics.b.b;
import com.qihoo.util.StubApp1053578832;

public class MsgService
  extends a
{
  static
  {
    StubApp1053578832.interface11(93);
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent("wifi.intent.action.STICKY_SERVICE");
    localIntent.setPackage(paramContext.getPackageName());
    try
    {
      paramContext.startService(localIntent);
      return;
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    b.a(this).a();
  }
  
  /* Error */
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 64	com/bluefay/e/a:onStartCommand	(Landroid/content/Intent;II)I
    //   7: istore_2
    //   8: aload_1
    //   9: ifnull +211 -> 220
    //   12: aload_1
    //   13: ldc 66
    //   15: invokevirtual 70	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_1
    //   19: new 72	java/lang/StringBuilder
    //   22: astore 4
    //   24: aload 4
    //   26: ldc 74
    //   28: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   31: aload 4
    //   33: aload_1
    //   34: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: iconst_0
    //   41: anewarray 84	java/lang/Object
    //   44: invokestatic 87	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload_1
    //   48: ifnull +39 -> 87
    //   51: iload_3
    //   52: iconst_1
    //   53: if_icmpne +169 -> 222
    //   56: invokestatic 93	com/lantern/analytics/a:e	()Lcom/lantern/analytics/a;
    //   59: astore 4
    //   61: new 72	java/lang/StringBuilder
    //   64: astore 5
    //   66: aload 5
    //   68: ldc 95
    //   70: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload 4
    //   75: aload 5
    //   77: aload_1
    //   78: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokevirtual 98	com/lantern/analytics/a:onEvent	(Ljava/lang/String;)V
    //   87: aload_0
    //   88: invokestatic 103	com/lantern/core/config/d:a	(Landroid/content/Context;)Lcom/lantern/core/config/d;
    //   91: ldc 105
    //   93: invokevirtual 108	com/lantern/core/config/d:a	(Ljava/lang/Class;)Lcom/lantern/core/config/a;
    //   96: checkcast 105	com/lantern/core/config/PushConf
    //   99: astore 4
    //   101: invokestatic 114	com/lantern/core/c:getServer	()Lcom/lantern/core/o;
    //   104: astore_1
    //   105: aload 4
    //   107: invokevirtual 118	com/lantern/core/config/PushConf:d	()Z
    //   110: ifeq +110 -> 220
    //   113: aload_1
    //   114: invokevirtual 123	com/lantern/core/o:i	()Z
    //   117: ifeq +103 -> 220
    //   120: new 125	com/lantern/wifilocating/push/f
    //   123: astore 5
    //   125: aload 5
    //   127: invokespecial 126	com/lantern/wifilocating/push/f:<init>	()V
    //   130: invokestatic 131	com/lantern/core/g/n:a	()Lcom/lantern/core/model/f;
    //   133: astore 4
    //   135: aload 5
    //   137: aload 4
    //   139: getfield 137	com/lantern/core/model/f:c	Ljava/lang/String;
    //   142: invokevirtual 139	com/lantern/wifilocating/push/f:e	(Ljava/lang/String;)V
    //   145: aload 5
    //   147: aload 4
    //   149: getfield 142	com/lantern/core/model/f:b	Ljava/lang/String;
    //   152: invokevirtual 144	com/lantern/wifilocating/push/f:d	(Ljava/lang/String;)V
    //   155: aload 5
    //   157: aload 4
    //   159: getfield 146	com/lantern/core/model/f:d	Ljava/lang/String;
    //   162: invokevirtual 149	com/lantern/wifilocating/push/f:f	(Ljava/lang/String;)V
    //   165: aload 5
    //   167: aload 4
    //   169: getfield 151	com/lantern/core/model/f:a	Ljava/lang/String;
    //   172: invokevirtual 153	com/lantern/wifilocating/push/f:a	(Ljava/lang/String;)V
    //   175: aload 5
    //   177: aload_1
    //   178: invokevirtual 155	com/lantern/core/o:b	()Ljava/lang/String;
    //   181: invokevirtual 157	com/lantern/wifilocating/push/f:b	(Ljava/lang/String;)V
    //   184: aload 5
    //   186: aload_1
    //   187: invokevirtual 159	com/lantern/core/o:c	()Ljava/lang/String;
    //   190: invokevirtual 161	com/lantern/wifilocating/push/f:c	(Ljava/lang/String;)V
    //   193: aload 5
    //   195: aload_1
    //   196: invokevirtual 164	com/lantern/core/o:g	()Ljava/lang/String;
    //   199: invokevirtual 166	com/lantern/wifilocating/push/f:g	(Ljava/lang/String;)V
    //   202: aload 5
    //   204: aload_1
    //   205: invokevirtual 169	com/lantern/core/o:h	()Ljava/lang/String;
    //   208: invokevirtual 171	com/lantern/wifilocating/push/f:h	(Ljava/lang/String;)V
    //   211: aload_0
    //   212: invokevirtual 175	com/wifi/connect/service/MsgService:getApplicationContext	()Landroid/content/Context;
    //   215: aload 5
    //   217: invokestatic 180	com/lantern/wifilocating/push/b:a	(Landroid/content/Context;Lcom/lantern/wifilocating/push/e;)V
    //   220: iload_2
    //   221: ireturn
    //   222: invokestatic 93	com/lantern/analytics/a:e	()Lcom/lantern/analytics/a;
    //   225: astore 5
    //   227: new 72	java/lang/StringBuilder
    //   230: astore 4
    //   232: aload 4
    //   234: ldc -74
    //   236: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   239: aload 5
    //   241: aload 4
    //   243: aload_1
    //   244: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokevirtual 98	com/lantern/analytics/a:onEvent	(Ljava/lang/String;)V
    //   253: goto -166 -> 87
    //   256: astore_1
    //   257: iconst_1
    //   258: istore_2
    //   259: goto -39 -> 220
    //   262: astore_1
    //   263: aload_1
    //   264: invokestatic 46	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   267: goto -47 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	this	MsgService
    //   0	270	1	paramIntent	Intent
    //   0	270	2	paramInt1	int
    //   0	270	3	paramInt2	int
    //   22	220	4	localObject1	Object
    //   64	176	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	256	java/lang/Throwable
    //   12	47	256	java/lang/Throwable
    //   56	87	256	java/lang/Throwable
    //   87	220	256	java/lang/Throwable
    //   222	253	256	java/lang/Throwable
    //   263	267	256	java/lang/Throwable
    //   87	220	262	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/service/MsgService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */