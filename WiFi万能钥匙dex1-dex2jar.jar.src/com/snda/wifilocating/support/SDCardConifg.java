package com.snda.wifilocating.support;

import android.os.Environment;
import android.text.TextUtils;
import com.lantern.core.c;
import com.lantern.core.k;
import java.io.Serializable;

public class SDCardConifg
{
  private static final String WIFI_MASTER_SDCARD_CONF_PATH = Environment.getExternalStorageDirectory() + "/.android_lt_conf";
  private static SDCardConifg sInstance;
  private Conf mConf;
  
  private SDCardConifg()
  {
    load();
    if (this.mConf == null) {
      this.mConf = new Conf(null);
    }
  }
  
  public static SDCardConifg getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null)
      {
        SDCardConifg localSDCardConifg = new com/snda/wifilocating/support/SDCardConifg;
        localSDCardConifg.<init>();
        sInstance = localSDCardConifg;
      }
      return sInstance;
    }
    finally {}
  }
  
  /* Error */
  private void load()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: new 64	java/io/File
    //   9: astore_1
    //   10: aload_1
    //   11: getstatic 43	com/snda/wifilocating/support/SDCardConifg:WIFI_MASTER_SDCARD_CONF_PATH	Ljava/lang/String;
    //   14: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: aload_1
    //   18: invokevirtual 71	java/io/File:exists	()Z
    //   21: ifne +4 -> 25
    //   24: return
    //   25: new 73	java/io/FileInputStream
    //   28: astore_2
    //   29: aload_2
    //   30: aload_1
    //   31: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: new 78	java/io/ObjectInputStream
    //   37: astore 4
    //   39: aload 4
    //   41: aload_2
    //   42: invokespecial 81	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: aload 4
    //   47: invokevirtual 85	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   50: checkcast 87	java/lang/String
    //   53: ldc 89
    //   55: ldc 91
    //   57: invokestatic 97	com/lantern/core/n:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: iconst_0
    //   61: invokestatic 103	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   64: astore_1
    //   65: new 105	java/io/ByteArrayInputStream
    //   68: astore_3
    //   69: aload_3
    //   70: aload_1
    //   71: invokespecial 108	java/io/ByteArrayInputStream:<init>	([B)V
    //   74: new 78	java/io/ObjectInputStream
    //   77: astore_1
    //   78: aload_1
    //   79: aload_3
    //   80: invokespecial 81	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   83: aload_0
    //   84: aload_1
    //   85: invokevirtual 85	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   88: checkcast 8	com/snda/wifilocating/support/SDCardConifg$Conf
    //   91: putfield 50	com/snda/wifilocating/support/SDCardConifg:mConf	Lcom/snda/wifilocating/support/SDCardConifg$Conf;
    //   94: new 19	java/lang/StringBuilder
    //   97: astore 5
    //   99: aload 5
    //   101: ldc 110
    //   103: invokespecial 111	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   106: aload 5
    //   108: aload_0
    //   109: getfield 50	com/snda/wifilocating/support/SDCardConifg:mConf	Lcom/snda/wifilocating/support/SDCardConifg$Conf;
    //   112: invokevirtual 114	com/snda/wifilocating/support/SDCardConifg$Conf:getDhid	()Ljava/lang/String;
    //   115: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 120	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_2
    //   129: invokevirtual 123	java/io/FileInputStream:close	()V
    //   132: aload 4
    //   134: invokevirtual 124	java/io/ObjectInputStream:close	()V
    //   137: aload_3
    //   138: invokevirtual 125	java/io/ByteArrayInputStream:close	()V
    //   141: aload_1
    //   142: invokevirtual 124	java/io/ObjectInputStream:close	()V
    //   145: goto -121 -> 24
    //   148: astore_1
    //   149: goto -125 -> 24
    //   152: astore 4
    //   154: aconst_null
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_3
    //   160: ldc 127
    //   162: aload 4
    //   164: invokestatic 130	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   167: aload_3
    //   168: ifnull +7 -> 175
    //   171: aload_3
    //   172: invokevirtual 123	java/io/FileInputStream:close	()V
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 124	java/io/ObjectInputStream:close	()V
    //   183: aload 5
    //   185: ifnull +8 -> 193
    //   188: aload 5
    //   190: invokevirtual 125	java/io/ByteArrayInputStream:close	()V
    //   193: aload_1
    //   194: ifnull -170 -> 24
    //   197: aload_1
    //   198: invokevirtual 124	java/io/ObjectInputStream:close	()V
    //   201: goto -177 -> 24
    //   204: astore_1
    //   205: goto -181 -> 24
    //   208: astore_1
    //   209: aconst_null
    //   210: astore_3
    //   211: aconst_null
    //   212: astore 4
    //   214: aconst_null
    //   215: astore_2
    //   216: aload 6
    //   218: astore 5
    //   220: aload_2
    //   221: ifnull +7 -> 228
    //   224: aload_2
    //   225: invokevirtual 123	java/io/FileInputStream:close	()V
    //   228: aload 4
    //   230: ifnull +8 -> 238
    //   233: aload 4
    //   235: invokevirtual 124	java/io/ObjectInputStream:close	()V
    //   238: aload_3
    //   239: ifnull +7 -> 246
    //   242: aload_3
    //   243: invokevirtual 125	java/io/ByteArrayInputStream:close	()V
    //   246: aload 5
    //   248: ifnull +8 -> 256
    //   251: aload 5
    //   253: invokevirtual 124	java/io/ObjectInputStream:close	()V
    //   256: aload_1
    //   257: athrow
    //   258: astore_2
    //   259: goto -127 -> 132
    //   262: astore_2
    //   263: goto -126 -> 137
    //   266: astore_2
    //   267: goto -126 -> 141
    //   270: astore_3
    //   271: goto -96 -> 175
    //   274: astore_2
    //   275: goto -92 -> 183
    //   278: astore_2
    //   279: goto -86 -> 193
    //   282: astore_2
    //   283: goto -55 -> 228
    //   286: astore_2
    //   287: goto -49 -> 238
    //   290: astore_2
    //   291: goto -45 -> 246
    //   294: astore_2
    //   295: goto -39 -> 256
    //   298: astore_1
    //   299: aconst_null
    //   300: astore_3
    //   301: aconst_null
    //   302: astore 4
    //   304: aload 6
    //   306: astore 5
    //   308: goto -88 -> 220
    //   311: astore_1
    //   312: aconst_null
    //   313: astore_3
    //   314: aload 6
    //   316: astore 5
    //   318: goto -98 -> 220
    //   321: astore_1
    //   322: aload 6
    //   324: astore 5
    //   326: goto -106 -> 220
    //   329: astore 5
    //   331: aload_1
    //   332: astore 6
    //   334: aload 5
    //   336: astore_1
    //   337: aload 6
    //   339: astore 5
    //   341: goto -121 -> 220
    //   344: astore 4
    //   346: aload_3
    //   347: astore 6
    //   349: aload 5
    //   351: astore_3
    //   352: aload_1
    //   353: astore 5
    //   355: aload 4
    //   357: astore_1
    //   358: aload_2
    //   359: astore 4
    //   361: aload 6
    //   363: astore_2
    //   364: goto -144 -> 220
    //   367: astore 4
    //   369: aconst_null
    //   370: astore_1
    //   371: aconst_null
    //   372: astore 6
    //   374: aload_2
    //   375: astore_3
    //   376: aload 6
    //   378: astore_2
    //   379: goto -219 -> 160
    //   382: astore_1
    //   383: aconst_null
    //   384: astore 7
    //   386: aload 4
    //   388: astore 6
    //   390: aload_2
    //   391: astore_3
    //   392: aload_1
    //   393: astore 4
    //   395: aload 7
    //   397: astore_1
    //   398: aload 6
    //   400: astore_2
    //   401: goto -241 -> 160
    //   404: astore_1
    //   405: aconst_null
    //   406: astore 5
    //   408: aload 4
    //   410: astore 6
    //   412: aload_2
    //   413: astore 7
    //   415: aload_1
    //   416: astore 4
    //   418: aload 5
    //   420: astore_1
    //   421: aload_3
    //   422: astore 5
    //   424: aload 6
    //   426: astore_2
    //   427: aload 7
    //   429: astore_3
    //   430: goto -270 -> 160
    //   433: astore 7
    //   435: aload_3
    //   436: astore 5
    //   438: aload 4
    //   440: astore 6
    //   442: aload_2
    //   443: astore_3
    //   444: aload 7
    //   446: astore 4
    //   448: aload 6
    //   450: astore_2
    //   451: goto -291 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	SDCardConifg
    //   9	133	1	localObject1	Object
    //   148	1	1	localIOException1	java.io.IOException
    //   155	43	1	localObject2	Object
    //   204	1	1	localIOException2	java.io.IOException
    //   208	49	1	localObject3	Object
    //   298	1	1	localObject4	Object
    //   311	1	1	localObject5	Object
    //   321	11	1	localObject6	Object
    //   336	35	1	localObject7	Object
    //   382	11	1	localException1	Exception
    //   397	1	1	localObject8	Object
    //   404	12	1	localException2	Exception
    //   420	1	1	localObject9	Object
    //   28	197	2	localFileInputStream	java.io.FileInputStream
    //   258	1	2	localIOException3	java.io.IOException
    //   262	1	2	localIOException4	java.io.IOException
    //   266	1	2	localIOException5	java.io.IOException
    //   274	1	2	localIOException6	java.io.IOException
    //   278	1	2	localIOException7	java.io.IOException
    //   282	1	2	localIOException8	java.io.IOException
    //   286	1	2	localIOException9	java.io.IOException
    //   290	1	2	localIOException10	java.io.IOException
    //   294	65	2	localIOException11	java.io.IOException
    //   363	88	2	localObject10	Object
    //   68	175	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   270	1	3	localIOException12	java.io.IOException
    //   300	144	3	localObject11	Object
    //   37	96	4	localObjectInputStream	java.io.ObjectInputStream
    //   152	11	4	localException3	Exception
    //   212	91	4	localObject12	Object
    //   344	12	4	localObject13	Object
    //   359	1	4	localIOException13	java.io.IOException
    //   367	20	4	localException4	Exception
    //   393	54	4	localObject14	Object
    //   4	321	5	localObject15	Object
    //   329	6	5	localObject16	Object
    //   339	98	5	localObject17	Object
    //   1	448	6	localObject18	Object
    //   384	44	7	localObject19	Object
    //   433	12	7	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   141	145	148	java/io/IOException
    //   6	24	152	java/lang/Exception
    //   25	34	152	java/lang/Exception
    //   197	201	204	java/io/IOException
    //   6	24	208	finally
    //   25	34	208	finally
    //   128	132	258	java/io/IOException
    //   132	137	262	java/io/IOException
    //   137	141	266	java/io/IOException
    //   171	175	270	java/io/IOException
    //   179	183	274	java/io/IOException
    //   188	193	278	java/io/IOException
    //   224	228	282	java/io/IOException
    //   233	238	286	java/io/IOException
    //   242	246	290	java/io/IOException
    //   251	256	294	java/io/IOException
    //   34	45	298	finally
    //   45	74	311	finally
    //   74	83	321	finally
    //   83	128	329	finally
    //   160	167	344	finally
    //   34	45	367	java/lang/Exception
    //   45	74	382	java/lang/Exception
    //   74	83	404	java/lang/Exception
    //   83	128	433	java/lang/Exception
  }
  
  public String getDhid()
  {
    String str2 = this.mConf.getDhid();
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      if (!this.mConf.validateDhid()) {
        break label31;
      }
    }
    label31:
    for (str1 = str2;; str1 = "") {
      return str1;
    }
  }
  
  private static final class Conf
    implements Serializable
  {
    private static final long serialVersionUID = 4508437838377285462L;
    private String dhid;
    private String imei;
    private String mac;
    
    public final String getDhid()
    {
      return this.dhid;
    }
    
    public final void setDhid(String paramString)
    {
      this.dhid = paramString;
    }
    
    public final void setImei(String paramString)
    {
      this.imei = paramString;
    }
    
    public final void setMac(String paramString)
    {
      this.mac = paramString;
    }
    
    public final boolean validateDhid()
    {
      boolean bool2 = false;
      boolean bool1;
      if (this.dhid == null) {
        bool1 = bool2;
      }
      for (;;)
      {
        return bool1;
        String str1 = k.c(c.getInstance());
        String str2 = k.e(c.getInstance());
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(this.imei)))
        {
          bool1 = bool2;
          if (!str1.equalsIgnoreCase(this.imei)) {}
        }
        else if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(this.mac)))
        {
          bool1 = bool2;
          if (!str2.equalsIgnoreCase(this.mac)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/snda/wifilocating/support/SDCardConifg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */