package com.c.d.a.a.a;

import com.b.b.ak.a;
import com.b.b.h;
import com.b.b.m;
import com.b.b.m.a;
import com.b.b.r;
import com.b.b.t;
import com.b.b.v;
import com.b.b.x;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  public static final class a
    extends m<a, a>
    implements b.b
  {
    private static final a h;
    private static volatile x<a> i;
    private int d;
    private String e = "";
    private String f = "";
    private t<String, String> g = t.a();
    
    static
    {
      a locala = new a();
      h = locala;
      locala.e();
    }
    
    public static a a(byte[] paramArrayOfByte)
    {
      return (a)m.a(h, paramArrayOfByte);
    }
    
    /* Error */
    protected final Object a(int paramInt, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 7
      //   3: iconst_0
      //   4: istore 4
      //   6: getstatic 68	com/c/d/a/a/a/b$1:a	[I
      //   9: iload_1
      //   10: iconst_1
      //   11: isub
      //   12: iaload
      //   13: tableswitch	default:+47->60, 1:+55->68, 2:+65->78, 3:+72->85, 4:+84->97, 5:+96->109, 6:+281->294, 7:+474->487, 8:+481->494
      //   60: new 70	java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial 71	java/lang/UnsupportedOperationException:<init>	()V
      //   67: athrow
      //   68: new 2	com/c/d/a/a/a/b$a
      //   71: dup
      //   72: invokespecial 33	com/c/d/a/a/a/b$a:<init>	()V
      //   75: astore_2
      //   76: aload_2
      //   77: areturn
      //   78: getstatic 35	com/c/d/a/a/a/b$a:h	Lcom/c/d/a/a/a/b$a;
      //   81: astore_2
      //   82: goto -6 -> 76
      //   85: aload_0
      //   86: getfield 46	com/c/d/a/a/a/b$a:g	Lcom/b/b/t;
      //   89: invokevirtual 74	com/b/b/t:c	()V
      //   92: aconst_null
      //   93: astore_2
      //   94: goto -18 -> 76
      //   97: new 12	com/c/d/a/a/a/b$a$a
      //   100: dup
      //   101: iconst_0
      //   102: invokespecial 77	com/c/d/a/a/a/b$a$a:<init>	(B)V
      //   105: astore_2
      //   106: goto -30 -> 76
      //   109: aload_2
      //   110: checkcast 79	com/b/b/m$j
      //   113: astore 8
      //   115: aload_3
      //   116: checkcast 2	com/c/d/a/a/a/b$a
      //   119: astore_3
      //   120: aload_0
      //   121: getfield 50	com/c/d/a/a/a/b$a:e	Ljava/lang/String;
      //   124: invokevirtual 85	java/lang/String:isEmpty	()Z
      //   127: ifne +143 -> 270
      //   130: iconst_1
      //   131: istore 5
      //   133: aload_0
      //   134: getfield 50	com/c/d/a/a/a/b$a:e	Ljava/lang/String;
      //   137: astore_2
      //   138: aload_3
      //   139: getfield 50	com/c/d/a/a/a/b$a:e	Ljava/lang/String;
      //   142: invokevirtual 85	java/lang/String:isEmpty	()Z
      //   145: ifne +131 -> 276
      //   148: iconst_1
      //   149: istore 6
      //   151: aload_0
      //   152: aload 8
      //   154: iload 5
      //   156: aload_2
      //   157: iload 6
      //   159: aload_3
      //   160: getfield 50	com/c/d/a/a/a/b$a:e	Ljava/lang/String;
      //   163: invokeinterface 88 5 0
      //   168: putfield 50	com/c/d/a/a/a/b$a:e	Ljava/lang/String;
      //   171: aload_0
      //   172: getfield 52	com/c/d/a/a/a/b$a:f	Ljava/lang/String;
      //   175: invokevirtual 85	java/lang/String:isEmpty	()Z
      //   178: ifne +104 -> 282
      //   181: iconst_1
      //   182: istore 5
      //   184: aload_0
      //   185: getfield 52	com/c/d/a/a/a/b$a:f	Ljava/lang/String;
      //   188: astore_2
      //   189: aload_3
      //   190: getfield 52	com/c/d/a/a/a/b$a:f	Ljava/lang/String;
      //   193: invokevirtual 85	java/lang/String:isEmpty	()Z
      //   196: ifne +92 -> 288
      //   199: iload 7
      //   201: istore 6
      //   203: aload_0
      //   204: aload 8
      //   206: iload 5
      //   208: aload_2
      //   209: iload 6
      //   211: aload_3
      //   212: getfield 52	com/c/d/a/a/a/b$a:f	Ljava/lang/String;
      //   215: invokeinterface 88 5 0
      //   220: putfield 52	com/c/d/a/a/a/b$a:f	Ljava/lang/String;
      //   223: aload_0
      //   224: aload 8
      //   226: aload_0
      //   227: getfield 46	com/c/d/a/a/a/b$a:g	Lcom/b/b/t;
      //   230: aload_3
      //   231: getfield 46	com/c/d/a/a/a/b$a:g	Lcom/b/b/t;
      //   234: invokeinterface 91 3 0
      //   239: putfield 46	com/c/d/a/a/a/b$a:g	Lcom/b/b/t;
      //   242: aload_0
      //   243: astore_2
      //   244: aload 8
      //   246: getstatic 96	com/b/b/m$h:a	Lcom/b/b/m$h;
      //   249: if_acmpne -173 -> 76
      //   252: aload_0
      //   253: aload_0
      //   254: getfield 98	com/c/d/a/a/a/b$a:d	I
      //   257: aload_3
      //   258: getfield 98	com/c/d/a/a/a/b$a:d	I
      //   261: ior
      //   262: putfield 98	com/c/d/a/a/a/b$a:d	I
      //   265: aload_0
      //   266: astore_2
      //   267: goto -191 -> 76
      //   270: iconst_0
      //   271: istore 5
      //   273: goto -140 -> 133
      //   276: iconst_0
      //   277: istore 6
      //   279: goto -128 -> 151
      //   282: iconst_0
      //   283: istore 5
      //   285: goto -101 -> 184
      //   288: iconst_0
      //   289: istore 6
      //   291: goto -88 -> 203
      //   294: aload_2
      //   295: checkcast 100	com/b/b/g
      //   298: astore_2
      //   299: aload_3
      //   300: checkcast 102	com/b/b/j
      //   303: astore_3
      //   304: iload 4
      //   306: istore_1
      //   307: iload_1
      //   308: ifne +179 -> 487
      //   311: aload_2
      //   312: invokevirtual 105	com/b/b/g:a	()I
      //   315: istore 4
      //   317: iload 4
      //   319: lookupswitch	default:+41->360, 0:+55->374, 10:+60->379, 18:+90->409, 26:+132->451
      //   360: aload_2
      //   361: iload 4
      //   363: invokevirtual 108	com/b/b/g:b	(I)Z
      //   366: ifne -59 -> 307
      //   369: iconst_1
      //   370: istore_1
      //   371: goto -64 -> 307
      //   374: iconst_1
      //   375: istore_1
      //   376: goto -69 -> 307
      //   379: aload_0
      //   380: aload_2
      //   381: invokevirtual 112	com/b/b/g:k	()Ljava/lang/String;
      //   384: putfield 50	com/c/d/a/a/a/b$a:e	Ljava/lang/String;
      //   387: goto -80 -> 307
      //   390: astore_3
      //   391: new 114	java/lang/RuntimeException
      //   394: astore_2
      //   395: aload_2
      //   396: aload_3
      //   397: aload_0
      //   398: invokevirtual 117	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   401: invokespecial 120	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   404: aload_2
      //   405: athrow
      //   406: astore_2
      //   407: aload_2
      //   408: athrow
      //   409: aload_0
      //   410: aload_2
      //   411: invokevirtual 112	com/b/b/g:k	()Ljava/lang/String;
      //   414: putfield 52	com/c/d/a/a/a/b$a:f	Ljava/lang/String;
      //   417: goto -110 -> 307
      //   420: astore_2
      //   421: new 114	java/lang/RuntimeException
      //   424: astore_3
      //   425: new 61	com/b/b/o
      //   428: astore 8
      //   430: aload 8
      //   432: aload_2
      //   433: invokevirtual 123	java/io/IOException:getMessage	()Ljava/lang/String;
      //   436: invokespecial 126	com/b/b/o:<init>	(Ljava/lang/String;)V
      //   439: aload_3
      //   440: aload 8
      //   442: aload_0
      //   443: invokevirtual 117	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   446: invokespecial 120	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   449: aload_3
      //   450: athrow
      //   451: aload_0
      //   452: getfield 46	com/c/d/a/a/a/b$a:g	Lcom/b/b/t;
      //   455: invokevirtual 128	com/b/b/t:d	()Z
      //   458: ifne +14 -> 472
      //   461: aload_0
      //   462: aload_0
      //   463: getfield 46	com/c/d/a/a/a/b$a:g	Lcom/b/b/t;
      //   466: invokevirtual 130	com/b/b/t:b	()Lcom/b/b/t;
      //   469: putfield 46	com/c/d/a/a/a/b$a:g	Lcom/b/b/t;
      //   472: getstatic 133	com/c/d/a/a/a/b$a$b:a	Lcom/b/b/r;
      //   475: aload_0
      //   476: getfield 46	com/c/d/a/a/a/b$a:g	Lcom/b/b/t;
      //   479: aload_2
      //   480: aload_3
      //   481: invokevirtual 138	com/b/b/r:a	(Lcom/b/b/t;Lcom/b/b/g;Lcom/b/b/j;)V
      //   484: goto -177 -> 307
      //   487: getstatic 35	com/c/d/a/a/a/b$a:h	Lcom/c/d/a/a/a/b$a;
      //   490: astore_2
      //   491: goto -415 -> 76
      //   494: getstatic 140	com/c/d/a/a/a/b$a:i	Lcom/b/b/x;
      //   497: ifnonnull +30 -> 527
      //   500: ldc 2
      //   502: monitorenter
      //   503: getstatic 140	com/c/d/a/a/a/b$a:i	Lcom/b/b/x;
      //   506: ifnonnull +18 -> 524
      //   509: new 142	com/b/b/m$b
      //   512: astore_2
      //   513: aload_2
      //   514: getstatic 35	com/c/d/a/a/a/b$a:h	Lcom/c/d/a/a/a/b$a;
      //   517: invokespecial 145	com/b/b/m$b:<init>	(Lcom/b/b/m;)V
      //   520: aload_2
      //   521: putstatic 140	com/c/d/a/a/a/b$a:i	Lcom/b/b/x;
      //   524: ldc 2
      //   526: monitorexit
      //   527: getstatic 140	com/c/d/a/a/a/b$a:i	Lcom/b/b/x;
      //   530: astore_2
      //   531: goto -455 -> 76
      //   534: astore_2
      //   535: ldc 2
      //   537: monitorexit
      //   538: aload_2
      //   539: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	540	0	this	a
      //   0	540	1	paramInt	int
      //   0	540	2	paramObject1	Object
      //   0	540	3	paramObject2	Object
      //   4	358	4	j	int
      //   131	153	5	bool1	boolean
      //   149	141	6	bool2	boolean
      //   1	199	7	bool3	boolean
      //   113	328	8	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   311	317	390	com/b/b/o
      //   360	369	390	com/b/b/o
      //   379	387	390	com/b/b/o
      //   409	417	390	com/b/b/o
      //   451	472	390	com/b/b/o
      //   472	484	390	com/b/b/o
      //   311	317	406	finally
      //   360	369	406	finally
      //   379	387	406	finally
      //   391	406	406	finally
      //   409	417	406	finally
      //   421	451	406	finally
      //   451	472	406	finally
      //   472	484	406	finally
      //   311	317	420	java/io/IOException
      //   360	369	420	java/io/IOException
      //   379	387	420	java/io/IOException
      //   409	417	420	java/io/IOException
      //   451	472	420	java/io/IOException
      //   472	484	420	java/io/IOException
      //   503	524	534	finally
      //   524	527	534	finally
      //   535	538	534	finally
    }
    
    public final void a(h paramh)
    {
      if (!this.e.isEmpty()) {
        paramh.a(1, this.e);
      }
      if (!this.f.isEmpty()) {
        paramh.a(2, this.f);
      }
      Iterator localIterator = this.g.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        b.a.a(paramh, 3, localEntry.getKey(), localEntry.getValue());
      }
    }
    
    public final int k()
    {
      int j = this.c;
      if (j != -1) {}
      for (;;)
      {
        return j;
        j = 0;
        if (!this.e.isEmpty()) {
          j = h.b(1, this.e) + 0;
        }
        int k = j;
        if (!this.f.isEmpty()) {
          k = j + h.b(2, this.f);
        }
        Iterator localIterator = this.g.entrySet().iterator();
        Map.Entry localEntry;
        for (j = k; localIterator.hasNext(); j = b.a.a(3, localEntry.getKey(), localEntry.getValue()) + j) {
          localEntry = (Map.Entry)localIterator.next();
        }
        this.c = j;
      }
    }
    
    public final String l()
    {
      return this.e;
    }
    
    public final String m()
    {
      return this.f;
    }
    
    public static final class a
      extends m.a<b.a, a>
      implements b.b
    {
      private a()
      {
        super();
      }
    }
    
    private static final class b
    {
      static final r<String, String> a = r.a(ak.a.i, "", ak.a.i, "");
    }
  }
  
  public static abstract interface b
    extends v
  {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/c/d/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */