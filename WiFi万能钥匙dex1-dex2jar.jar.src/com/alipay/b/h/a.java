package com.alipay.b.h;

import android.content.Context;
import com.alipay.c.a.a.a.a.c;
import com.alipay.c.a.a.d.d;
import java.util.HashMap;
import java.util.Map;

public class a
{
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramContext != null)
    {
      localObject1 = localObject2;
      if (!com.alipay.c.a.a.a.a.a(paramString1))
      {
        if (!com.alipay.c.a.a.a.a.a(paramString2)) {
          break label32;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      return (String)localObject1;
      try
      {
        label32:
        paramContext = d.a(paramContext, paramString1, paramString2, "");
        localObject1 = localObject2;
        if (!com.alipay.c.a.a.a.a.a(paramContext)) {
          localObject1 = c.b(c.a(), paramContext);
        }
      }
      catch (Throwable paramContext)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   9: ifne +10 -> 19
    //   12: aload_1
    //   13: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   16: ifeq +10 -> 26
    //   19: ldc 2
    //   21: monitorexit
    //   22: aload_3
    //   23: astore_0
    //   24: aload_0
    //   25: areturn
    //   26: aload_0
    //   27: invokestatic 39	com/alipay/c/a/a/d/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 4
    //   32: aload 4
    //   34: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   37: istore_2
    //   38: iload_2
    //   39: ifeq +17 -> 56
    //   42: ldc 2
    //   44: monitorexit
    //   45: aload_3
    //   46: astore_0
    //   47: goto -23 -> 24
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    //   56: new 41	org/json/JSONObject
    //   59: astore_0
    //   60: aload_0
    //   61: aload 4
    //   63: invokespecial 44	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   66: aload_0
    //   67: aload_1
    //   68: invokevirtual 47	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_0
    //   72: aload_0
    //   73: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   76: istore_2
    //   77: iload_2
    //   78: ifeq +11 -> 89
    //   81: ldc 2
    //   83: monitorexit
    //   84: aload_3
    //   85: astore_0
    //   86: goto -62 -> 24
    //   89: invokestatic 30	com/alipay/c/a/a/a/a/c:a	()Ljava/lang/String;
    //   92: aload_0
    //   93: invokestatic 34	com/alipay/c/a/a/a/a/c:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: astore_0
    //   97: ldc 2
    //   99: monitorexit
    //   100: goto -76 -> 24
    //   103: astore_0
    //   104: ldc 2
    //   106: monitorexit
    //   107: aload_3
    //   108: astore_0
    //   109: goto -85 -> 24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramString1	String
    //   0	112	1	paramString2	String
    //   37	41	2	bool	boolean
    //   1	107	3	localObject	Object
    //   30	32	4	str	String
    // Exception table:
    //   from	to	target	type
    //   5	19	50	finally
    //   19	22	50	finally
    //   26	38	50	finally
    //   42	45	50	finally
    //   56	77	50	finally
    //   81	84	50	finally
    //   89	97	50	finally
    //   97	100	50	finally
    //   26	38	103	java/lang/Throwable
    //   56	77	103	java/lang/Throwable
    //   89	97	103	java/lang/Throwable
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((com.alipay.c.a.a.a.a.a(paramString1)) || (com.alipay.c.a.a.a.a.a(paramString2)) || (paramContext == null)) {}
    for (;;)
    {
      return;
      try
      {
        paramString3 = c.a(c.a(), paramString3);
        HashMap localHashMap = new java/util/HashMap;
        localHashMap.<init>();
        localHashMap.put(paramString2, paramString3);
        d.a(paramContext, paramString1, localHashMap);
      }
      catch (Throwable paramContext) {}
    }
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   7: ifne +10 -> 17
    //   10: aload_1
    //   11: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   14: ifeq +7 -> 21
    //   17: ldc 2
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: invokestatic 39	com/alipay/c/a/a/d/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 5
    //   27: new 41	org/json/JSONObject
    //   30: astore 4
    //   32: aload 4
    //   34: invokespecial 68	org/json/JSONObject:<init>	()V
    //   37: aload 5
    //   39: invokestatic 70	com/alipay/c/a/a/a/a:b	(Ljava/lang/String;)Z
    //   42: istore_3
    //   43: iload_3
    //   44: ifeq +15 -> 59
    //   47: new 41	org/json/JSONObject
    //   50: astore 4
    //   52: aload 4
    //   54: aload 5
    //   56: invokespecial 44	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   59: aload 4
    //   61: aload_1
    //   62: invokestatic 30	com/alipay/c/a/a/a/a/c:a	()Ljava/lang/String;
    //   65: aload_2
    //   66: invokestatic 50	com/alipay/c/a/a/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   69: invokevirtual 73	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   72: pop
    //   73: aload 4
    //   75: invokevirtual 76	org/json/JSONObject:toString	()Ljava/lang/String;
    //   78: astore_2
    //   79: aload_2
    //   80: invokestatic 18	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   83: ifne +9 -> 92
    //   86: aload_0
    //   87: aload_2
    //   88: invokestatic 81	java/lang/System:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   91: pop
    //   92: invokestatic 86	com/alipay/c/a/a/d/c:a	()Z
    //   95: ifeq +99 -> 194
    //   98: new 88	java/lang/StringBuilder
    //   101: astore_1
    //   102: aload_1
    //   103: ldc 90
    //   105: invokespecial 91	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: getstatic 97	java/io/File:separator	Ljava/lang/String;
    //   112: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_0
    //   116: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: astore_0
    //   123: invokestatic 86	com/alipay/c/a/a/d/c:a	()Z
    //   126: ifeq +68 -> 194
    //   129: new 93	java/io/File
    //   132: astore_1
    //   133: aload_1
    //   134: invokestatic 108	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   137: aload_0
    //   138: invokespecial 111	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   141: aload_1
    //   142: invokevirtual 114	java/io/File:exists	()Z
    //   145: ifne +11 -> 156
    //   148: aload_1
    //   149: invokevirtual 117	java/io/File:getParentFile	()Ljava/io/File;
    //   152: invokevirtual 120	java/io/File:mkdirs	()Z
    //   155: pop
    //   156: aload_1
    //   157: invokevirtual 123	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   160: astore_0
    //   161: new 93	java/io/File
    //   164: astore 4
    //   166: aload 4
    //   168: aload_0
    //   169: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   172: aconst_null
    //   173: astore_1
    //   174: new 126	java/io/FileWriter
    //   177: astore_0
    //   178: aload_0
    //   179: aload 4
    //   181: iconst_0
    //   182: invokespecial 129	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   185: aload_0
    //   186: aload_2
    //   187: invokevirtual 132	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   190: aload_0
    //   191: invokevirtual 135	java/io/FileWriter:close	()V
    //   194: ldc 2
    //   196: monitorexit
    //   197: goto -177 -> 20
    //   200: astore_0
    //   201: ldc 2
    //   203: monitorexit
    //   204: aload_0
    //   205: athrow
    //   206: astore 4
    //   208: new 41	org/json/JSONObject
    //   211: dup
    //   212: invokespecial 68	org/json/JSONObject:<init>	()V
    //   215: astore 4
    //   217: goto -158 -> 59
    //   220: astore_0
    //   221: goto -27 -> 194
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_0
    //   227: aload_0
    //   228: ifnull -34 -> 194
    //   231: aload_0
    //   232: invokevirtual 135	java/io/FileWriter:close	()V
    //   235: goto -41 -> 194
    //   238: astore_0
    //   239: goto -45 -> 194
    //   242: astore_0
    //   243: aload_1
    //   244: ifnull +7 -> 251
    //   247: aload_1
    //   248: invokevirtual 135	java/io/FileWriter:close	()V
    //   251: aload_0
    //   252: athrow
    //   253: astore_0
    //   254: goto -60 -> 194
    //   257: astore_0
    //   258: goto -64 -> 194
    //   261: astore_1
    //   262: goto -11 -> 251
    //   265: astore_2
    //   266: aload_0
    //   267: astore_1
    //   268: aload_2
    //   269: astore_0
    //   270: goto -27 -> 243
    //   273: astore_1
    //   274: goto -47 -> 227
    //   277: astore_1
    //   278: goto -186 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramString1	String
    //   0	281	1	paramString2	String
    //   0	281	2	paramString3	String
    //   42	2	3	bool	boolean
    //   30	150	4	localObject	Object
    //   206	1	4	localException	Exception
    //   215	1	4	localJSONObject	org.json.JSONObject
    //   25	30	5	str	String
    // Exception table:
    //   from	to	target	type
    //   3	17	200	finally
    //   17	20	200	finally
    //   21	43	200	finally
    //   47	59	200	finally
    //   59	79	200	finally
    //   79	92	200	finally
    //   92	123	200	finally
    //   123	156	200	finally
    //   156	172	200	finally
    //   190	194	200	finally
    //   194	197	200	finally
    //   208	217	200	finally
    //   231	235	200	finally
    //   247	251	200	finally
    //   251	253	200	finally
    //   47	59	206	java/lang/Exception
    //   21	43	220	java/lang/Throwable
    //   47	59	220	java/lang/Throwable
    //   59	79	220	java/lang/Throwable
    //   92	123	220	java/lang/Throwable
    //   123	156	220	java/lang/Throwable
    //   156	172	220	java/lang/Throwable
    //   190	194	220	java/lang/Throwable
    //   208	217	220	java/lang/Throwable
    //   231	235	220	java/lang/Throwable
    //   247	251	220	java/lang/Throwable
    //   251	253	220	java/lang/Throwable
    //   174	185	224	java/lang/Exception
    //   231	235	238	java/io/IOException
    //   174	185	242	finally
    //   123	156	253	java/lang/Exception
    //   156	172	253	java/lang/Exception
    //   190	194	253	java/lang/Exception
    //   231	235	253	java/lang/Exception
    //   247	251	253	java/lang/Exception
    //   251	253	253	java/lang/Exception
    //   190	194	257	java/io/IOException
    //   247	251	261	java/io/IOException
    //   185	190	265	finally
    //   185	190	273	java/lang/Exception
    //   79	92	277	java/lang/Throwable
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */