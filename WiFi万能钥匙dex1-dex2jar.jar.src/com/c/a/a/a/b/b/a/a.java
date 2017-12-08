package com.c.a.a.a.b.b.a;

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
    private static final a e;
    private static volatile x<a> f;
    private String d = "";
    
    static
    {
      a locala = new a();
      e = locala;
      locala.e();
    }
    
    public static a l()
    {
      return (a)e.g();
    }
    
    /* Error */
    protected final Object a(int paramInt, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 6
      //   3: iconst_0
      //   4: istore 4
      //   6: getstatic 56	com/c/a/a/a/b/b/a/a$1:a	[I
      //   9: iload_1
      //   10: iconst_1
      //   11: isub
      //   12: iaload
      //   13: tableswitch	default:+47->60, 1:+55->68, 2:+65->78, 3:+72->85, 4:+77->90, 5:+89->102, 6:+169->182, 7:+295->308, 8:+302->315
      //   60: new 58	java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial 59	java/lang/UnsupportedOperationException:<init>	()V
      //   67: athrow
      //   68: new 2	com/c/a/a/a/b/b/a/a$a
      //   71: dup
      //   72: invokespecial 24	com/c/a/a/a/b/b/a/a$a:<init>	()V
      //   75: astore_2
      //   76: aload_2
      //   77: areturn
      //   78: getstatic 26	com/c/a/a/a/b/b/a/a$a:e	Lcom/c/a/a/a/b/b/a/a$a;
      //   81: astore_2
      //   82: goto -6 -> 76
      //   85: aconst_null
      //   86: astore_2
      //   87: goto -11 -> 76
      //   90: new 12	com/c/a/a/a/b/b/a/a$a$a
      //   93: dup
      //   94: iconst_0
      //   95: invokespecial 62	com/c/a/a/a/b/b/a/a$a$a:<init>	(B)V
      //   98: astore_2
      //   99: goto -23 -> 76
      //   102: aload_2
      //   103: checkcast 64	com/b/b/m$j
      //   106: astore_2
      //   107: aload_3
      //   108: checkcast 2	com/c/a/a/a/b/b/a/a$a
      //   111: astore_3
      //   112: aload_0
      //   113: getfield 34	com/c/a/a/a/b/b/a/a$a:d	Ljava/lang/String;
      //   116: invokevirtual 70	java/lang/String:isEmpty	()Z
      //   119: ifne +51 -> 170
      //   122: iconst_1
      //   123: istore 5
      //   125: aload_0
      //   126: getfield 34	com/c/a/a/a/b/b/a/a$a:d	Ljava/lang/String;
      //   129: astore 7
      //   131: aload_3
      //   132: getfield 34	com/c/a/a/a/b/b/a/a$a:d	Ljava/lang/String;
      //   135: invokevirtual 70	java/lang/String:isEmpty	()Z
      //   138: ifne +38 -> 176
      //   141: aload_0
      //   142: aload_2
      //   143: iload 5
      //   145: aload 7
      //   147: iload 6
      //   149: aload_3
      //   150: getfield 34	com/c/a/a/a/b/b/a/a$a:d	Ljava/lang/String;
      //   153: invokeinterface 73 5 0
      //   158: putfield 34	com/c/a/a/a/b/b/a/a$a:d	Ljava/lang/String;
      //   161: getstatic 78	com/b/b/m$h:a	Lcom/b/b/m$h;
      //   164: astore_2
      //   165: aload_0
      //   166: astore_2
      //   167: goto -91 -> 76
      //   170: iconst_0
      //   171: istore 5
      //   173: goto -48 -> 125
      //   176: iconst_0
      //   177: istore 6
      //   179: goto -38 -> 141
      //   182: aload_2
      //   183: checkcast 80	com/b/b/g
      //   186: astore_2
      //   187: iload 4
      //   189: istore_1
      //   190: iload_1
      //   191: ifne +117 -> 308
      //   194: aload_2
      //   195: invokevirtual 83	com/b/b/g:a	()I
      //   198: istore 4
      //   200: iload 4
      //   202: lookupswitch	default:+26->228, 0:+40->242, 10:+45->247
      //   228: aload_2
      //   229: iload 4
      //   231: invokevirtual 87	com/b/b/g:b	(I)Z
      //   234: ifne -44 -> 190
      //   237: iconst_1
      //   238: istore_1
      //   239: goto -49 -> 190
      //   242: iconst_1
      //   243: istore_1
      //   244: goto -54 -> 190
      //   247: aload_0
      //   248: aload_2
      //   249: invokevirtual 91	com/b/b/g:k	()Ljava/lang/String;
      //   252: putfield 34	com/c/a/a/a/b/b/a/a$a:d	Ljava/lang/String;
      //   255: goto -65 -> 190
      //   258: astore_2
      //   259: new 93	java/lang/RuntimeException
      //   262: astore_3
      //   263: aload_3
      //   264: aload_2
      //   265: aload_0
      //   266: invokevirtual 96	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   269: invokespecial 99	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   272: aload_3
      //   273: athrow
      //   274: astore_2
      //   275: aload_2
      //   276: athrow
      //   277: astore_3
      //   278: new 93	java/lang/RuntimeException
      //   281: astore_2
      //   282: new 49	com/b/b/o
      //   285: astore 7
      //   287: aload 7
      //   289: aload_3
      //   290: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
      //   293: invokespecial 105	com/b/b/o:<init>	(Ljava/lang/String;)V
      //   296: aload_2
      //   297: aload 7
      //   299: aload_0
      //   300: invokevirtual 96	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   303: invokespecial 99	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   306: aload_2
      //   307: athrow
      //   308: getstatic 26	com/c/a/a/a/b/b/a/a$a:e	Lcom/c/a/a/a/b/b/a/a$a;
      //   311: astore_2
      //   312: goto -236 -> 76
      //   315: getstatic 107	com/c/a/a/a/b/b/a/a$a:f	Lcom/b/b/x;
      //   318: ifnonnull +30 -> 348
      //   321: ldc 2
      //   323: monitorenter
      //   324: getstatic 107	com/c/a/a/a/b/b/a/a$a:f	Lcom/b/b/x;
      //   327: ifnonnull +18 -> 345
      //   330: new 109	com/b/b/m$b
      //   333: astore_2
      //   334: aload_2
      //   335: getstatic 26	com/c/a/a/a/b/b/a/a$a:e	Lcom/c/a/a/a/b/b/a/a$a;
      //   338: invokespecial 112	com/b/b/m$b:<init>	(Lcom/b/b/m;)V
      //   341: aload_2
      //   342: putstatic 107	com/c/a/a/a/b/b/a/a$a:f	Lcom/b/b/x;
      //   345: ldc 2
      //   347: monitorexit
      //   348: getstatic 107	com/c/a/a/a/b/b/a/a$a:f	Lcom/b/b/x;
      //   351: astore_2
      //   352: goto -276 -> 76
      //   355: astore_2
      //   356: ldc 2
      //   358: monitorexit
      //   359: aload_2
      //   360: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	361	0	this	a
      //   0	361	1	paramInt	int
      //   0	361	2	paramObject1	Object
      //   0	361	3	paramObject2	Object
      //   4	226	4	i	int
      //   123	49	5	bool1	boolean
      //   1	177	6	bool2	boolean
      //   129	169	7	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   194	200	258	com/b/b/o
      //   228	237	258	com/b/b/o
      //   247	255	258	com/b/b/o
      //   194	200	274	finally
      //   228	237	274	finally
      //   247	255	274	finally
      //   259	274	274	finally
      //   278	308	274	finally
      //   194	200	277	java/io/IOException
      //   228	237	277	java/io/IOException
      //   247	255	277	java/io/IOException
      //   324	345	355	finally
      //   345	348	355	finally
      //   356	359	355	finally
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
    
    public static final class a
      extends m.a<a.a, a>
      implements a.b
    {
      private a()
      {
        super();
      }
      
      public final a a(String paramString)
      {
        b();
        a.a.a((a.a)this.a, paramString);
        return this;
      }
    }
  }
  
  public static abstract interface b
    extends v
  {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/c/a/a/a/b/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */