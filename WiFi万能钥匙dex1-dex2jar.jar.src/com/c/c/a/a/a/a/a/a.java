package com.c.c.a.a.a.a.a;

import com.b.b.h;
import com.b.b.m;
import com.b.b.m.a;
import com.b.b.v;
import com.b.b.x;

public final class a
{
  public static final class a
    extends m<a, a>
    implements a.b
  {
    private static final a g;
    private static volatile x<a> h;
    private String d = "";
    private String e = "";
    private boolean f;
    
    static
    {
      a locala = new a();
      g = locala;
      locala.e();
    }
    
    public static a a(byte[] paramArrayOfByte)
    {
      return (a)m.a(g, paramArrayOfByte);
    }
    
    /* Error */
    protected final Object a(int paramInt, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 7
      //   3: iconst_0
      //   4: istore 4
      //   6: getstatic 55	com/c/c/a/a/a/a/a/a$1:a	[I
      //   9: iload_1
      //   10: iconst_1
      //   11: isub
      //   12: iaload
      //   13: tableswitch	default:+47->60, 1:+55->68, 2:+65->78, 3:+72->85, 4:+77->90, 5:+89->102, 6:+295->308, 7:+461->474, 8:+468->481
      //   60: new 57	java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial 58	java/lang/UnsupportedOperationException:<init>	()V
      //   67: athrow
      //   68: new 2	com/c/c/a/a/a/a/a/a$a
      //   71: dup
      //   72: invokespecial 27	com/c/c/a/a/a/a/a/a$a:<init>	()V
      //   75: astore_2
      //   76: aload_2
      //   77: areturn
      //   78: getstatic 29	com/c/c/a/a/a/a/a/a$a:g	Lcom/c/c/a/a/a/a/a/a$a;
      //   81: astore_2
      //   82: goto -6 -> 76
      //   85: aconst_null
      //   86: astore_2
      //   87: goto -11 -> 76
      //   90: new 12	com/c/c/a/a/a/a/a/a$a$a
      //   93: dup
      //   94: iconst_0
      //   95: invokespecial 61	com/c/c/a/a/a/a/a/a$a$a:<init>	(B)V
      //   98: astore_2
      //   99: goto -23 -> 76
      //   102: aload_2
      //   103: checkcast 63	com/b/b/m$j
      //   106: astore_2
      //   107: aload_3
      //   108: checkcast 2	com/c/c/a/a/a/a/a/a$a
      //   111: astore_3
      //   112: aload_0
      //   113: getfield 37	com/c/c/a/a/a/a/a/a$a:d	Ljava/lang/String;
      //   116: invokevirtual 69	java/lang/String:isEmpty	()Z
      //   119: ifne +153 -> 272
      //   122: iconst_1
      //   123: istore 5
      //   125: aload_0
      //   126: getfield 37	com/c/c/a/a/a/a/a/a$a:d	Ljava/lang/String;
      //   129: astore 9
      //   131: aload_3
      //   132: getfield 37	com/c/c/a/a/a/a/a/a$a:d	Ljava/lang/String;
      //   135: invokevirtual 69	java/lang/String:isEmpty	()Z
      //   138: ifne +140 -> 278
      //   141: iconst_1
      //   142: istore 6
      //   144: aload_0
      //   145: aload_2
      //   146: iload 5
      //   148: aload 9
      //   150: iload 6
      //   152: aload_3
      //   153: getfield 37	com/c/c/a/a/a/a/a/a$a:d	Ljava/lang/String;
      //   156: invokeinterface 72 5 0
      //   161: putfield 37	com/c/c/a/a/a/a/a/a$a:d	Ljava/lang/String;
      //   164: aload_0
      //   165: getfield 39	com/c/c/a/a/a/a/a/a$a:e	Ljava/lang/String;
      //   168: invokevirtual 69	java/lang/String:isEmpty	()Z
      //   171: ifne +113 -> 284
      //   174: iconst_1
      //   175: istore 5
      //   177: aload_0
      //   178: getfield 39	com/c/c/a/a/a/a/a/a$a:e	Ljava/lang/String;
      //   181: astore 9
      //   183: aload_3
      //   184: getfield 39	com/c/c/a/a/a/a/a/a$a:e	Ljava/lang/String;
      //   187: invokevirtual 69	java/lang/String:isEmpty	()Z
      //   190: ifne +100 -> 290
      //   193: iconst_1
      //   194: istore 6
      //   196: aload_0
      //   197: aload_2
      //   198: iload 5
      //   200: aload 9
      //   202: iload 6
      //   204: aload_3
      //   205: getfield 39	com/c/c/a/a/a/a/a/a$a:e	Ljava/lang/String;
      //   208: invokeinterface 72 5 0
      //   213: putfield 39	com/c/c/a/a/a/a/a/a$a:e	Ljava/lang/String;
      //   216: aload_0
      //   217: getfield 74	com/c/c/a/a/a/a/a/a$a:f	Z
      //   220: ifeq +76 -> 296
      //   223: iconst_1
      //   224: istore 5
      //   226: aload_0
      //   227: getfield 74	com/c/c/a/a/a/a/a/a$a:f	Z
      //   230: istore 8
      //   232: aload_3
      //   233: getfield 74	com/c/c/a/a/a/a/a/a$a:f	Z
      //   236: ifeq +66 -> 302
      //   239: iload 7
      //   241: istore 6
      //   243: aload_0
      //   244: aload_2
      //   245: iload 5
      //   247: iload 8
      //   249: iload 6
      //   251: aload_3
      //   252: getfield 74	com/c/c/a/a/a/a/a/a$a:f	Z
      //   255: invokeinterface 77 5 0
      //   260: putfield 74	com/c/c/a/a/a/a/a/a$a:f	Z
      //   263: getstatic 82	com/b/b/m$h:a	Lcom/b/b/m$h;
      //   266: astore_2
      //   267: aload_0
      //   268: astore_2
      //   269: goto -193 -> 76
      //   272: iconst_0
      //   273: istore 5
      //   275: goto -150 -> 125
      //   278: iconst_0
      //   279: istore 6
      //   281: goto -137 -> 144
      //   284: iconst_0
      //   285: istore 5
      //   287: goto -110 -> 177
      //   290: iconst_0
      //   291: istore 6
      //   293: goto -97 -> 196
      //   296: iconst_0
      //   297: istore 5
      //   299: goto -73 -> 226
      //   302: iconst_0
      //   303: istore 6
      //   305: goto -62 -> 243
      //   308: aload_2
      //   309: checkcast 84	com/b/b/g
      //   312: astore_2
      //   313: iload 4
      //   315: istore_1
      //   316: iload_1
      //   317: ifne +157 -> 474
      //   320: aload_2
      //   321: invokevirtual 87	com/b/b/g:a	()I
      //   324: istore 4
      //   326: iload 4
      //   328: lookupswitch	default:+44->372, 0:+58->386, 10:+63->391, 18:+93->421, 24:+135->463
      //   372: aload_2
      //   373: iload 4
      //   375: invokevirtual 91	com/b/b/g:b	(I)Z
      //   378: ifne -62 -> 316
      //   381: iconst_1
      //   382: istore_1
      //   383: goto -67 -> 316
      //   386: iconst_1
      //   387: istore_1
      //   388: goto -72 -> 316
      //   391: aload_0
      //   392: aload_2
      //   393: invokevirtual 95	com/b/b/g:k	()Ljava/lang/String;
      //   396: putfield 37	com/c/c/a/a/a/a/a/a$a:d	Ljava/lang/String;
      //   399: goto -83 -> 316
      //   402: astore_3
      //   403: new 97	java/lang/RuntimeException
      //   406: astore_2
      //   407: aload_2
      //   408: aload_3
      //   409: aload_0
      //   410: invokevirtual 100	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   413: invokespecial 103	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   416: aload_2
      //   417: athrow
      //   418: astore_2
      //   419: aload_2
      //   420: athrow
      //   421: aload_0
      //   422: aload_2
      //   423: invokevirtual 95	com/b/b/g:k	()Ljava/lang/String;
      //   426: putfield 39	com/c/c/a/a/a/a/a/a$a:e	Ljava/lang/String;
      //   429: goto -113 -> 316
      //   432: astore_2
      //   433: new 97	java/lang/RuntimeException
      //   436: astore 9
      //   438: new 48	com/b/b/o
      //   441: astore_3
      //   442: aload_3
      //   443: aload_2
      //   444: invokevirtual 106	java/io/IOException:getMessage	()Ljava/lang/String;
      //   447: invokespecial 109	com/b/b/o:<init>	(Ljava/lang/String;)V
      //   450: aload 9
      //   452: aload_3
      //   453: aload_0
      //   454: invokevirtual 100	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   457: invokespecial 103	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   460: aload 9
      //   462: athrow
      //   463: aload_0
      //   464: aload_2
      //   465: invokevirtual 112	com/b/b/g:i	()Z
      //   468: putfield 74	com/c/c/a/a/a/a/a/a$a:f	Z
      //   471: goto -155 -> 316
      //   474: getstatic 29	com/c/c/a/a/a/a/a/a$a:g	Lcom/c/c/a/a/a/a/a/a$a;
      //   477: astore_2
      //   478: goto -402 -> 76
      //   481: getstatic 114	com/c/c/a/a/a/a/a/a$a:h	Lcom/b/b/x;
      //   484: ifnonnull +30 -> 514
      //   487: ldc 2
      //   489: monitorenter
      //   490: getstatic 114	com/c/c/a/a/a/a/a/a$a:h	Lcom/b/b/x;
      //   493: ifnonnull +18 -> 511
      //   496: new 116	com/b/b/m$b
      //   499: astore_2
      //   500: aload_2
      //   501: getstatic 29	com/c/c/a/a/a/a/a/a$a:g	Lcom/c/c/a/a/a/a/a/a$a;
      //   504: invokespecial 119	com/b/b/m$b:<init>	(Lcom/b/b/m;)V
      //   507: aload_2
      //   508: putstatic 114	com/c/c/a/a/a/a/a/a$a:h	Lcom/b/b/x;
      //   511: ldc 2
      //   513: monitorexit
      //   514: getstatic 114	com/c/c/a/a/a/a/a/a$a:h	Lcom/b/b/x;
      //   517: astore_2
      //   518: goto -442 -> 76
      //   521: astore_2
      //   522: ldc 2
      //   524: monitorexit
      //   525: aload_2
      //   526: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	527	0	this	a
      //   0	527	1	paramInt	int
      //   0	527	2	paramObject1	Object
      //   0	527	3	paramObject2	Object
      //   4	370	4	i	int
      //   123	175	5	bool1	boolean
      //   142	162	6	bool2	boolean
      //   1	239	7	bool3	boolean
      //   230	18	8	bool4	boolean
      //   129	332	9	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   320	326	402	com/b/b/o
      //   372	381	402	com/b/b/o
      //   391	399	402	com/b/b/o
      //   421	429	402	com/b/b/o
      //   463	471	402	com/b/b/o
      //   320	326	418	finally
      //   372	381	418	finally
      //   391	399	418	finally
      //   403	418	418	finally
      //   421	429	418	finally
      //   433	463	418	finally
      //   463	471	418	finally
      //   320	326	432	java/io/IOException
      //   372	381	432	java/io/IOException
      //   391	399	432	java/io/IOException
      //   421	429	432	java/io/IOException
      //   463	471	432	java/io/IOException
      //   490	511	521	finally
      //   511	514	521	finally
      //   522	525	521	finally
    }
    
    public final void a(h paramh)
    {
      if (!this.d.isEmpty()) {
        paramh.a(1, this.d);
      }
      if (!this.e.isEmpty()) {
        paramh.a(2, this.e);
      }
      if (this.f) {
        paramh.a(3, this.f);
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
        if (!this.d.isEmpty()) {
          j = h.b(1, this.d) + 0;
        }
        int i = j;
        if (!this.e.isEmpty()) {
          i = j + h.b(2, this.e);
        }
        j = i;
        if (this.f) {
          j = i + h.f(3);
        }
        this.c = j;
      }
    }
    
    public final String l()
    {
      return this.d;
    }
    
    public final String m()
    {
      return this.e;
    }
    
    public final boolean n()
    {
      return this.f;
    }
    
    public static final class a
      extends m.a<a.a, a>
      implements a.b
    {
      private a()
      {
        super();
      }
    }
  }
  
  public static abstract interface b
    extends v
  {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/c/c/a/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */