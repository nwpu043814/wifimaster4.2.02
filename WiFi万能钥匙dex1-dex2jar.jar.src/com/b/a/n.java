package com.b.a;

import com.b.a.c.c;
import com.b.a.c.e;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.LinkedList;
import java.util.List;

public final class n
{
  static final a a = new a();
  static final be b = new be();
  static final as c = new as(new int[] { 128, 8 });
  static final m d = new bc(new r());
  private static final i e;
  private final i f;
  private final i g;
  private final m h;
  private final aq i;
  private final ay<ak<?>> j;
  private final ay<x<?>> k;
  private final boolean l;
  private final boolean m;
  private final boolean n;
  private final boolean o;
  
  static
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(a);
    localLinkedList.add(b);
    localLinkedList.add(c);
    e = new g(localLinkedList);
  }
  
  public n()
  {
    this(e, e, d, new aq(f.d()), false, f.a(), f.b(), false, true, false);
  }
  
  n(i parami1, i parami2, m paramm, aq paramaq, boolean paramBoolean1, ay<ak<?>> paramay, ay<x<?>> paramay1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.f = parami1;
    this.g = parami2;
    this.h = paramm;
    this.i = paramaq;
    this.l = paramBoolean1;
    this.j = paramay;
    this.k = paramay1;
    this.n = paramBoolean2;
    this.m = paramBoolean3;
    this.o = paramBoolean4;
  }
  
  /* Error */
  private <T> T a(com.b.a.c.a parama, Type paramType)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 123	com/b/a/c/a:a	()Z
    //   4: istore_3
    //   5: aload_1
    //   6: iconst_1
    //   7: invokevirtual 126	com/b/a/c/a:a	(Z)V
    //   10: aload_1
    //   11: invokestatic 131	com/b/a/bd:a	(Lcom/b/a/c/a;)Lcom/b/a/z;
    //   14: astore 4
    //   16: aload 4
    //   18: ifnonnull +12 -> 30
    //   21: aconst_null
    //   22: astore_2
    //   23: aload_1
    //   24: iload_3
    //   25: invokevirtual 126	com/b/a/c/a:a	(Z)V
    //   28: aload_2
    //   29: areturn
    //   30: new 133	com/b/a/v
    //   33: astore 5
    //   35: new 135	com/b/a/av
    //   38: astore 6
    //   40: aload 6
    //   42: aload_0
    //   43: getfield 97	com/b/a/n:f	Lcom/b/a/i;
    //   46: invokespecial 138	com/b/a/av:<init>	(Lcom/b/a/i;)V
    //   49: aload 5
    //   51: aload 6
    //   53: aload_0
    //   54: getfield 101	com/b/a/n:h	Lcom/b/a/m;
    //   57: aload_0
    //   58: getfield 109	com/b/a/n:k	Lcom/b/a/ay;
    //   61: aload_0
    //   62: getfield 103	com/b/a/n:i	Lcom/b/a/aq;
    //   65: invokespecial 141	com/b/a/v:<init>	(Lcom/b/a/av;Lcom/b/a/m;Lcom/b/a/ay;Lcom/b/a/aq;)V
    //   68: aload 5
    //   70: aload 4
    //   72: aload_2
    //   73: invokeinterface 146 3 0
    //   78: astore_2
    //   79: goto -56 -> 23
    //   82: astore_2
    //   83: aload_1
    //   84: iload_3
    //   85: invokevirtual 126	com/b/a/c/a:a	(Z)V
    //   88: aload_2
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	n
    //   0	90	1	parama	com.b.a.c.a
    //   0	90	2	paramType	Type
    //   4	81	3	bool	boolean
    //   14	57	4	localz	z
    //   33	36	5	localv	v
    //   38	14	6	localav	av
    // Exception table:
    //   from	to	target	type
    //   10	16	82	finally
    //   30	79	82	finally
  }
  
  /* Error */
  private void a(z paramz, Appendable paramAppendable)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 111	com/b/a/n:n	Z
    //   4: ifeq +12 -> 16
    //   7: aload_2
    //   8: ldc -104
    //   10: invokeinterface 158 2 0
    //   15: pop
    //   16: new 160	com/b/a/c/d
    //   19: astore 5
    //   21: aload 5
    //   23: aload_2
    //   24: checkcast 162	java/io/Writer
    //   27: invokespecial 165	com/b/a/c/d:<init>	(Ljava/io/Writer;)V
    //   30: aload_0
    //   31: getfield 115	com/b/a/n:o	Z
    //   34: ifeq +10 -> 44
    //   37: aload 5
    //   39: ldc -89
    //   41: invokevirtual 170	com/b/a/c/d:a	(Ljava/lang/String;)V
    //   44: aload 5
    //   46: invokevirtual 171	com/b/a/c/d:a	()Z
    //   49: istore 4
    //   51: aload 5
    //   53: iconst_1
    //   54: invokevirtual 172	com/b/a/c/d:a	(Z)V
    //   57: aload 5
    //   59: invokevirtual 174	com/b/a/c/d:b	()Z
    //   62: istore_3
    //   63: aload 5
    //   65: aload_0
    //   66: getfield 113	com/b/a/n:m	Z
    //   69: invokevirtual 176	com/b/a/c/d:b	(Z)V
    //   72: aload_1
    //   73: aload_0
    //   74: getfield 105	com/b/a/n:l	Z
    //   77: aload 5
    //   79: invokestatic 179	com/b/a/bd:a	(Lcom/b/a/z;ZLcom/b/a/c/d;)V
    //   82: aload 5
    //   84: iload 4
    //   86: invokevirtual 172	com/b/a/c/d:a	(Z)V
    //   89: aload 5
    //   91: iload_3
    //   92: invokevirtual 176	com/b/a/c/d:b	(Z)V
    //   95: return
    //   96: astore_2
    //   97: new 181	com/b/a/aa
    //   100: astore_1
    //   101: aload_1
    //   102: aload_2
    //   103: invokespecial 184	com/b/a/aa:<init>	(Ljava/lang/Throwable;)V
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload 5
    //   111: iload 4
    //   113: invokevirtual 172	com/b/a/c/d:a	(Z)V
    //   116: aload 5
    //   118: iload_3
    //   119: invokevirtual 176	com/b/a/c/d:b	(Z)V
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: new 186	java/lang/RuntimeException
    //   128: dup
    //   129: aload_1
    //   130: invokespecial 187	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	n
    //   0	134	1	paramz	z
    //   0	134	2	paramAppendable	Appendable
    //   62	57	3	bool1	boolean
    //   49	63	4	bool2	boolean
    //   19	98	5	locald	com.b.a.c.d
    // Exception table:
    //   from	to	target	type
    //   72	82	96	java/io/IOException
    //   72	82	108	finally
    //   97	108	108	finally
    //   0	16	124	java/io/IOException
    //   16	44	124	java/io/IOException
    //   44	72	124	java/io/IOException
    //   82	95	124	java/io/IOException
    //   109	124	124	java/io/IOException
  }
  
  public final <T> T a(String paramString, Type paramType)
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      com.b.a.c.a locala = new com.b.a.c.a(new StringReader(paramString));
      paramType = a(locala, paramType);
      paramString = paramType;
      if (paramType == null) {
        continue;
      }
      paramString = paramType;
      try
      {
        if (locala.g() == c.j) {
          continue;
        }
        paramString = new com/b/a/aa;
        paramString.<init>("JSON document was not fully consumed.");
        throw paramString;
      }
      catch (e paramString)
      {
        throw new al(paramString);
      }
      catch (IOException paramString)
      {
        throw new aa(paramString);
      }
    }
  }
  
  public final String a(Object paramObject)
  {
    Object localObject;
    if (paramObject == null)
    {
      localObject = ab.a();
      paramObject = new StringWriter();
      a((z)localObject, (Appendable)paramObject);
    }
    for (paramObject = ((StringWriter)paramObject).toString();; paramObject = ((StringWriter)localObject).toString())
    {
      return (String)paramObject;
      Class localClass = paramObject.getClass();
      localObject = new StringWriter();
      a(new ai(new av(this.g), this.h, this.l, this.j).a(paramObject, localClass), (Appendable)localObject);
    }
  }
  
  public final String toString()
  {
    return "{serializeNulls:" + this.l + ",serializers:" + this.j + ",deserializers:" + this.k + ",instanceCreators:" + this.i + "}";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */