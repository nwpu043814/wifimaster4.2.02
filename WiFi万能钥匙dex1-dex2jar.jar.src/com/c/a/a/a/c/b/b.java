package com.c.a.a.a.c.b;

import com.b.b.h;
import com.b.b.m;
import com.b.b.m.a;
import com.b.b.v;
import com.b.b.x;

public final class b
{
  public static final class a
    extends m<a, a>
    implements b.b
  {
    private static final a e;
    private static volatile x<a> f;
    private String d = "";
    
    static
    {
      a locala = new a();
      e = locala;
      locala.e();
    }
    
    public static a a(byte[] paramArrayOfByte)
    {
      return (a)m.a(e, paramArrayOfByte);
    }
    
    /* Error */
    protected final Object a(int paramInt, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 6
      //   3: iconst_0
      //   4: istore 4
      //   6: getstatic 50	com/c/a/a/a/c/b/b$1:a	[I
      //   9: iload_1
      //   10: iconst_1
      //   11: isub
      //   12: iaload
      //   13: tableswitch	default:+47->60, 1:+55->68, 2:+65->78, 3:+72->85, 4:+77->90, 5:+89->102, 6:+170->183, 7:+294->307, 8:+301->314
      //   60: new 52	java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial 53	java/lang/UnsupportedOperationException:<init>	()V
      //   67: athrow
      //   68: new 2	com/c/a/a/a/c/b/b$a
      //   71: dup
      //   72: invokespecial 24	com/c/a/a/a/c/b/b$a:<init>	()V
      //   75: astore_2
      //   76: aload_2
      //   77: areturn
      //   78: getstatic 26	com/c/a/a/a/c/b/b$a:e	Lcom/c/a/a/a/c/b/b$a;
      //   81: astore_2
      //   82: goto -6 -> 76
      //   85: aconst_null
      //   86: astore_2
      //   87: goto -11 -> 76
      //   90: new 12	com/c/a/a/a/c/b/b$a$a
      //   93: dup
      //   94: iconst_0
      //   95: invokespecial 56	com/c/a/a/a/c/b/b$a$a:<init>	(B)V
      //   98: astore_2
      //   99: goto -23 -> 76
      //   102: aload_2
      //   103: checkcast 58	com/b/b/m$j
      //   106: astore_2
      //   107: aload_3
      //   108: checkcast 2	com/c/a/a/a/c/b/b$a
      //   111: astore 7
      //   113: aload_0
      //   114: getfield 34	com/c/a/a/a/c/b/b$a:d	Ljava/lang/String;
      //   117: invokevirtual 64	java/lang/String:isEmpty	()Z
      //   120: ifne +51 -> 171
      //   123: iconst_1
      //   124: istore 5
      //   126: aload_0
      //   127: getfield 34	com/c/a/a/a/c/b/b$a:d	Ljava/lang/String;
      //   130: astore_3
      //   131: aload 7
      //   133: getfield 34	com/c/a/a/a/c/b/b$a:d	Ljava/lang/String;
      //   136: invokevirtual 64	java/lang/String:isEmpty	()Z
      //   139: ifne +38 -> 177
      //   142: aload_0
      //   143: aload_2
      //   144: iload 5
      //   146: aload_3
      //   147: iload 6
      //   149: aload 7
      //   151: getfield 34	com/c/a/a/a/c/b/b$a:d	Ljava/lang/String;
      //   154: invokeinterface 67 5 0
      //   159: putfield 34	com/c/a/a/a/c/b/b$a:d	Ljava/lang/String;
      //   162: getstatic 72	com/b/b/m$h:a	Lcom/b/b/m$h;
      //   165: astore_2
      //   166: aload_0
      //   167: astore_2
      //   168: goto -92 -> 76
      //   171: iconst_0
      //   172: istore 5
      //   174: goto -48 -> 126
      //   177: iconst_0
      //   178: istore 6
      //   180: goto -38 -> 142
      //   183: aload_2
      //   184: checkcast 74	com/b/b/g
      //   187: astore_2
      //   188: iload 4
      //   190: istore_1
      //   191: iload_1
      //   192: ifne +115 -> 307
      //   195: aload_2
      //   196: invokevirtual 77	com/b/b/g:a	()I
      //   199: istore 4
      //   201: iload 4
      //   203: lookupswitch	default:+25->228, 0:+39->242, 10:+44->247
      //   228: aload_2
      //   229: iload 4
      //   231: invokevirtual 81	com/b/b/g:b	(I)Z
      //   234: ifne -43 -> 191
      //   237: iconst_1
      //   238: istore_1
      //   239: goto -48 -> 191
      //   242: iconst_1
      //   243: istore_1
      //   244: goto -53 -> 191
      //   247: aload_0
      //   248: aload_2
      //   249: invokevirtual 85	com/b/b/g:k	()Ljava/lang/String;
      //   252: putfield 34	com/c/a/a/a/c/b/b$a:d	Ljava/lang/String;
      //   255: goto -64 -> 191
      //   258: astore_3
      //   259: new 87	java/lang/RuntimeException
      //   262: astore_2
      //   263: aload_2
      //   264: aload_3
      //   265: aload_0
      //   266: invokevirtual 90	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   269: invokespecial 93	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   272: aload_2
      //   273: athrow
      //   274: astore_2
      //   275: aload_2
      //   276: athrow
      //   277: astore 7
      //   279: new 87	java/lang/RuntimeException
      //   282: astore_3
      //   283: new 43	com/b/b/o
      //   286: astore_2
      //   287: aload_2
      //   288: aload 7
      //   290: invokevirtual 96	java/io/IOException:getMessage	()Ljava/lang/String;
      //   293: invokespecial 99	com/b/b/o:<init>	(Ljava/lang/String;)V
      //   296: aload_3
      //   297: aload_2
      //   298: aload_0
      //   299: invokevirtual 90	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   302: invokespecial 93	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   305: aload_3
      //   306: athrow
      //   307: getstatic 26	com/c/a/a/a/c/b/b$a:e	Lcom/c/a/a/a/c/b/b$a;
      //   310: astore_2
      //   311: goto -235 -> 76
      //   314: getstatic 101	com/c/a/a/a/c/b/b$a:f	Lcom/b/b/x;
      //   317: ifnonnull +30 -> 347
      //   320: ldc 2
      //   322: monitorenter
      //   323: getstatic 101	com/c/a/a/a/c/b/b$a:f	Lcom/b/b/x;
      //   326: ifnonnull +18 -> 344
      //   329: new 103	com/b/b/m$b
      //   332: astore_2
      //   333: aload_2
      //   334: getstatic 26	com/c/a/a/a/c/b/b$a:e	Lcom/c/a/a/a/c/b/b$a;
      //   337: invokespecial 106	com/b/b/m$b:<init>	(Lcom/b/b/m;)V
      //   340: aload_2
      //   341: putstatic 101	com/c/a/a/a/c/b/b$a:f	Lcom/b/b/x;
      //   344: ldc 2
      //   346: monitorexit
      //   347: getstatic 101	com/c/a/a/a/c/b/b$a:f	Lcom/b/b/x;
      //   350: astore_2
      //   351: goto -275 -> 76
      //   354: astore_2
      //   355: ldc 2
      //   357: monitorexit
      //   358: aload_2
      //   359: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	360	0	this	a
      //   0	360	1	paramInt	int
      //   0	360	2	paramObject1	Object
      //   0	360	3	paramObject2	Object
      //   4	226	4	i	int
      //   124	49	5	bool1	boolean
      //   1	178	6	bool2	boolean
      //   111	39	7	locala	a
      //   277	12	7	localIOException	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   195	201	258	com/b/b/o
      //   228	237	258	com/b/b/o
      //   247	255	258	com/b/b/o
      //   195	201	274	finally
      //   228	237	274	finally
      //   247	255	274	finally
      //   259	274	274	finally
      //   279	307	274	finally
      //   195	201	277	java/io/IOException
      //   228	237	277	java/io/IOException
      //   247	255	277	java/io/IOException
      //   323	344	354	finally
      //   344	347	354	finally
      //   355	358	354	finally
    }
    
    public final void a(h paramh)
    {
      if (!this.d.isEmpty()) {
        paramh.a(1, this.d);
      }
    }
    
    public final int k()
    {
      int i = this.c;
      if (i != -1) {}
      for (;;)
      {
        return i;
        i = 0;
        if (!this.d.isEmpty()) {
          i = h.b(1, this.d) + 0;
        }
        this.c = i;
      }
    }
    
    public final String l()
    {
      return this.d;
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
  }
  
  public static abstract interface b
    extends v
  {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/c/a/a/a/c/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */