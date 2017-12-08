package ct;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class i
{
  public static boolean a = true;
  private static final Lock b = new ReentrantLock();
  private static a c = null;
  
  public static a a()
  {
    a locala;
    if (c != null) {
      locala = c;
    }
    for (;;)
    {
      return locala;
      try
      {
        if (p.a() != null) {
          c = a(p.a(), p.b(), p.g(), p.e());
        }
        locala = c;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  public static a a(android.content.Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 46
    //   2: new 48	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 50
    //   8: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   15: ldc 59
    //   17: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc 64
    //   26: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_2
    //   30: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 66
    //   35: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 74	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_0
    //   49: ifnull +10 -> 59
    //   52: aload_1
    //   53: invokestatic 79	ct/bc:a	(Ljava/lang/String;)Z
    //   56: ifeq +41 -> 97
    //   59: new 81	ct/m
    //   62: dup
    //   63: new 48	java/lang/StringBuilder
    //   66: dup
    //   67: ldc 83
    //   69: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   72: aload_1
    //   73: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 85
    //   78: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_0
    //   82: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: ldc 87
    //   87: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokespecial 88	ct/m:<init>	(Ljava/lang/String;)V
    //   96: athrow
    //   97: getstatic 21	ct/i:b	Ljava/util/concurrent/locks/Lock;
    //   100: invokeinterface 93 1 0
    //   105: getstatic 23	ct/i:c	Lct/a;
    //   108: ifnonnull +191 -> 299
    //   111: aload_3
    //   112: invokestatic 79	ct/bc:a	(Ljava/lang/String;)Z
    //   115: ifne +18 -> 133
    //   118: aload_3
    //   119: astore 5
    //   121: aload_3
    //   122: invokevirtual 98	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   125: ldc 100
    //   127: invokevirtual 104	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   130: ifeq +97 -> 227
    //   133: aload_0
    //   134: ldc 106
    //   136: iconst_0
    //   137: invokevirtual 112	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   140: astore 6
    //   142: aload_3
    //   143: astore 5
    //   145: aload 6
    //   147: ifnull +80 -> 227
    //   150: aload 6
    //   152: ldc 114
    //   154: ldc 116
    //   156: invokeinterface 122 3 0
    //   161: astore_3
    //   162: aload_3
    //   163: astore 5
    //   165: aload_3
    //   166: invokestatic 79	ct/bc:a	(Ljava/lang/String;)Z
    //   169: ifeq +58 -> 227
    //   172: new 48	java/lang/StringBuilder
    //   175: astore_3
    //   176: aload_3
    //   177: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   180: aload_3
    //   181: aload_0
    //   182: invokestatic 126	ct/bc:a	(Landroid/content/Context;)Ljava/lang/String;
    //   185: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: ldc -128
    //   190: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_0
    //   194: invokestatic 130	ct/bc:b	(Landroid/content/Context;)Ljava/lang/String;
    //   197: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: astore 5
    //   205: aload 6
    //   207: invokeinterface 134 1 0
    //   212: ldc 114
    //   214: aload 5
    //   216: invokeinterface 140 3 0
    //   221: invokeinterface 144 1 0
    //   226: pop
    //   227: aload_2
    //   228: astore_3
    //   229: aload_2
    //   230: invokestatic 79	ct/bc:a	(Ljava/lang/String;)Z
    //   233: ifeq +6 -> 239
    //   236: ldc -110
    //   238: astore_3
    //   239: aload_0
    //   240: aload_1
    //   241: aload_3
    //   242: aload 5
    //   244: invokestatic 149	ct/p:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload_0
    //   248: invokestatic 154	ct/ba:a	(Landroid/content/Context;)V
    //   251: new 156	ct/f
    //   254: astore_0
    //   255: aload_0
    //   256: aload_1
    //   257: aload_3
    //   258: aload 5
    //   260: invokespecial 159	ct/f:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_0
    //   264: putstatic 23	ct/i:c	Lct/a;
    //   267: new 161	java/lang/Thread
    //   270: astore_0
    //   271: aload_0
    //   272: getstatic 23	ct/i:c	Lct/a;
    //   275: checkcast 163	java/lang/Runnable
    //   278: ldc -91
    //   280: invokespecial 168	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   283: aload_0
    //   284: invokevirtual 171	java/lang/Thread:start	()V
    //   287: getstatic 21	ct/i:b	Ljava/util/concurrent/locks/Lock;
    //   290: invokeinterface 174 1 0
    //   295: getstatic 23	ct/i:c	Lct/a;
    //   298: areturn
    //   299: getstatic 23	ct/i:c	Lct/a;
    //   302: checkcast 156	ct/f
    //   305: astore_0
    //   306: aload_0
    //   307: getfield 177	ct/f:a	Ljava/lang/String;
    //   310: aload_1
    //   311: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   314: ifeq +99 -> 413
    //   317: aload_0
    //   318: getfield 183	ct/f:b	Ljava/lang/String;
    //   321: aload_2
    //   322: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   325: ifeq +88 -> 413
    //   328: aload_0
    //   329: getfield 185	ct/f:c	Ljava/lang/String;
    //   332: aload_3
    //   333: invokevirtual 181	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   336: ifeq +77 -> 413
    //   339: iconst_1
    //   340: istore 4
    //   342: iload 4
    //   344: ifne -57 -> 287
    //   347: getstatic 23	ct/i:c	Lct/a;
    //   350: checkcast 156	ct/f
    //   353: astore_0
    //   354: new 81	ct/m
    //   357: astore_2
    //   358: new 48	java/lang/StringBuilder
    //   361: astore_1
    //   362: aload_1
    //   363: ldc -69
    //   365: invokespecial 53	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   368: aload_2
    //   369: aload_1
    //   370: aload_0
    //   371: getfield 177	ct/f:a	Ljava/lang/String;
    //   374: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: ldc -67
    //   379: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_0
    //   383: getfield 185	ct/f:c	Ljava/lang/String;
    //   386: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: ldc -65
    //   391: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokespecial 88	ct/m:<init>	(Ljava/lang/String;)V
    //   400: aload_2
    //   401: athrow
    //   402: astore_0
    //   403: getstatic 21	ct/i:b	Ljava/util/concurrent/locks/Lock;
    //   406: invokeinterface 174 1 0
    //   411: aload_0
    //   412: athrow
    //   413: iconst_0
    //   414: istore 4
    //   416: goto -74 -> 342
    //   419: astore_0
    //   420: goto -133 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	paramContext	android.content.Context
    //   0	423	1	paramString1	String
    //   0	423	2	paramString2	String
    //   0	423	3	paramString3	String
    //   340	75	4	i	int
    //   119	140	5	str	String
    //   140	66	6	localSharedPreferences	android.content.SharedPreferences
    // Exception table:
    //   from	to	target	type
    //   105	118	402	finally
    //   121	133	402	finally
    //   133	142	402	finally
    //   150	162	402	finally
    //   165	227	402	finally
    //   229	236	402	finally
    //   239	287	402	finally
    //   299	339	402	finally
    //   347	402	402	finally
    //   239	287	419	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */