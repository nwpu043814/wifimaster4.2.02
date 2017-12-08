package com.b.a;

import com.b.a.b.b;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.UUID;

final class f
{
  private static final z A;
  private static final y B;
  private static final r C;
  private static final ay<ak<?>> D;
  private static final ay<x<?>> E;
  private static final ay<q<?>> F;
  static final ay<ak<?>> a;
  static final ay<x<?>> b;
  private static final h c = new h();
  private static final j d = new j();
  private static final k e = new k();
  private static final l f = new l();
  private static final o g = new o((byte)0);
  private static final ac h = new ac((byte)0);
  private static final ab i = new ab((byte)0);
  private static final ad j = new ad((byte)0);
  private static final t k = new t((byte)0);
  private static final i l = new i();
  private static final f m = new f((byte)0);
  private static final ap n = new ap();
  private static final a o = new a((byte)0);
  private static final b p = new b((byte)0);
  private static final c q = new c((byte)0);
  private static final d r = new d((byte)0);
  private static final e s = new e((byte)0);
  private static final m t = new m((byte)0);
  private static final p u = new p((byte)0);
  private static final s v = new s((byte)0);
  private static final u w = new u((byte)0);
  private static final w x = new w((byte)0);
  private static final x y = new x((byte)0);
  private static final aa z = new aa((byte)0);
  
  static
  {
    A = new z((byte)0);
    B = new y((byte)0);
    C = new r((byte)0);
    ay localay = new ay();
    localay.a(URL.class, h);
    localay.a(URI.class, i);
    localay.a(UUID.class, j);
    localay.a(Locale.class, k);
    localay.a(java.util.Date.class, c);
    localay.a(java.sql.Date.class, d);
    localay.a(Timestamp.class, c);
    localay.a(Time.class, e);
    localay.a(Calendar.class, C);
    localay.a(GregorianCalendar.class, C);
    localay.a(BigDecimal.class, o);
    localay.a(BigInteger.class, p);
    localay.a(Boolean.class, q);
    localay.a(Boolean.TYPE, q);
    localay.a(Byte.class, r);
    localay.a(Byte.TYPE, r);
    localay.a(Character.class, s);
    localay.a(Character.TYPE, s);
    localay.a(Integer.class, v);
    localay.a(Integer.TYPE, v);
    localay.a(Number.class, x);
    localay.a(Short.class, y);
    localay.a(Short.TYPE, y);
    localay.a(String.class, z);
    localay.a(StringBuilder.class, A);
    localay.a(StringBuffer.class, B);
    localay.a();
    D = localay;
    localay = new ay();
    localay.a(Enum.class, g);
    localay.a(InetAddress.class, l);
    localay.a(Collection.class, m);
    localay.a(Map.class, n);
    localay.a();
    a = localay;
    localay = new ay();
    localay.a(URL.class, a(h));
    localay.a(URI.class, a(i));
    localay.a(UUID.class, a(j));
    localay.a(Locale.class, a(k));
    localay.a(java.util.Date.class, a(c));
    localay.a(java.sql.Date.class, a(d));
    localay.a(Timestamp.class, a(f));
    localay.a(Time.class, a(e));
    localay.a(Calendar.class, C);
    localay.a(GregorianCalendar.class, C);
    localay.a(BigDecimal.class, o);
    localay.a(BigInteger.class, p);
    localay.a(Boolean.class, q);
    localay.a(Boolean.TYPE, q);
    localay.a(Byte.class, r);
    localay.a(Byte.TYPE, r);
    localay.a(Character.class, a(s));
    localay.a(Character.TYPE, a(s));
    localay.a(Double.class, t);
    localay.a(Double.TYPE, t);
    localay.a(Float.class, u);
    localay.a(Float.TYPE, u);
    localay.a(Integer.class, v);
    localay.a(Integer.TYPE, v);
    localay.a(Long.class, w);
    localay.a(Long.TYPE, w);
    localay.a(Number.class, x);
    localay.a(Short.class, y);
    localay.a(Short.TYPE, y);
    localay.a(String.class, a(z));
    localay.a(StringBuilder.class, a(A));
    localay.a(StringBuffer.class, a(B));
    localay.a();
    E = localay;
    localay = new ay();
    localay.a(Enum.class, a(g));
    localay.a(InetAddress.class, a(l));
    localay.a(Collection.class, a(m));
    localay.a(Map.class, a(n));
    localay.a();
    b = localay;
    localay = new ay();
    Object localObject = new e(50);
    localay.a(Map.class, new g(LinkedHashMap.class, (e)localObject));
    g localg3 = new g(ArrayList.class, (e)localObject);
    g localg1 = new g(LinkedList.class, (e)localObject);
    g localg2 = new g(HashSet.class, (e)localObject);
    localObject = new g(TreeSet.class, (e)localObject);
    localay.a(Collection.class, localg3);
    localay.a(Queue.class, localg1);
    localay.a(Set.class, localg2);
    localay.a(SortedSet.class, localObject);
    localay.a();
    F = localay;
  }
  
  static ay<ak<?>> a()
  {
    ay localay = a(false, am.a);
    localay.b(a);
    return localay;
  }
  
  static ay<ak<?>> a(boolean paramBoolean, am paramam)
  {
    ay localay = new ay();
    Object localObject = new n(paramBoolean);
    localay.b(Double.class, localObject);
    localay.b(Double.TYPE, localObject);
    localObject = new q(paramBoolean);
    localay.b(Float.class, localObject);
    localay.b(Float.TYPE, localObject);
    paramam = new v(paramam, (byte)0);
    localay.b(Long.class, paramam);
    localay.b(Long.TYPE, paramam);
    localay.a(D);
    return localay;
  }
  
  private static x<?> a(x<?> paramx)
  {
    return new y(paramx);
  }
  
  static ay<x<?>> b()
  {
    ay localay = E.b();
    localay.b(b);
    return localay;
  }
  
  static ay<x<?>> c()
  {
    return E;
  }
  
  static ay<q<?>> d()
  {
    return F;
  }
  
  private static final class a
    implements ak<BigDecimal>, x<BigDecimal>
  {
    private static BigDecimal a(z paramz)
    {
      try
      {
        paramz = paramz.e();
        return paramz;
      }
      catch (NumberFormatException paramz)
      {
        throw new al(paramz);
      }
      catch (UnsupportedOperationException paramz)
      {
        throw new al(paramz);
      }
      catch (IllegalStateException paramz)
      {
        throw new al(paramz);
      }
    }
    
    public final String toString()
    {
      return a.class.getSimpleName();
    }
  }
  
  private static final class aa
    implements ak<String>, x<String>
  {
    public final String toString()
    {
      return aa.class.getSimpleName();
    }
  }
  
  private static final class ab
    implements ak<URI>, x<URI>
  {
    private static URI a(z paramz)
    {
      try
      {
        paramz = new URI(paramz.c());
        return paramz;
      }
      catch (URISyntaxException paramz)
      {
        throw new al(paramz);
      }
    }
    
    public final String toString()
    {
      return ab.class.getSimpleName();
    }
  }
  
  private static final class ac
    implements ak<URL>, x<URL>
  {
    private static URL a(z paramz)
    {
      try
      {
        paramz = new URL(paramz.c());
        return paramz;
      }
      catch (MalformedURLException paramz)
      {
        throw new al(paramz);
      }
    }
    
    public final String toString()
    {
      return ac.class.getSimpleName();
    }
  }
  
  private static final class ad
    implements ak<UUID>, x<UUID>
  {
    public final String toString()
    {
      return ad.class.getSimpleName();
    }
  }
  
  private static final class b
    implements ak<BigInteger>, x<BigInteger>
  {
    private static BigInteger a(z paramz)
    {
      try
      {
        paramz = paramz.f();
        return paramz;
      }
      catch (NumberFormatException paramz)
      {
        throw new al(paramz);
      }
      catch (UnsupportedOperationException paramz)
      {
        throw new al(paramz);
      }
      catch (IllegalStateException paramz)
      {
        throw new al(paramz);
      }
    }
    
    public final String toString()
    {
      return b.class.getSimpleName();
    }
  }
  
  private static final class c
    implements ak<Boolean>, x<Boolean>
  {
    private static Boolean a(z paramz)
    {
      try
      {
        boolean bool = paramz.m();
        return Boolean.valueOf(bool);
      }
      catch (UnsupportedOperationException paramz)
      {
        throw new al(paramz);
      }
      catch (IllegalStateException paramz)
      {
        throw new al(paramz);
      }
    }
    
    public final String toString()
    {
      return c.class.getSimpleName();
    }
  }
  
  private static final class d
    implements ak<Byte>, x<Byte>
  {
    private static Byte a(z paramz)
    {
      try
      {
        byte b = paramz.j();
        return Byte.valueOf(b);
      }
      catch (NumberFormatException paramz)
      {
        throw new al(paramz);
      }
      catch (UnsupportedOperationException paramz)
      {
        throw new al(paramz);
      }
      catch (IllegalStateException paramz)
      {
        throw new al(paramz);
      }
    }
    
    public final String toString()
    {
      return d.class.getSimpleName();
    }
  }
  
  private static final class e
    implements ak<Character>, x<Character>
  {
    public final String toString()
    {
      return e.class.getSimpleName();
    }
  }
  
  private static final class f
    implements ak<Collection>, x<Collection>
  {}
  
  private static final class g<T>
    implements q<T>
  {
    private final Class<? extends T> a;
    private final e b;
    
    public g(Class<? extends T> paramClass, e parame)
    {
      this.a = paramClass;
      this.b = parame;
    }
    
    public final T a(Type paramType)
    {
      paramType = b.b(paramType);
      try
      {
        Object localObject = this.b.a(paramType);
        paramType = (Type)localObject;
        if (localObject == null) {
          paramType = this.b.a(this.a);
        }
        return paramType;
      }
      catch (Exception paramType)
      {
        throw new aa(paramType);
      }
    }
    
    public final String toString()
    {
      return g.class.getSimpleName();
    }
  }
  
  static final class h
    implements ak<java.util.Date>, x<java.util.Date>
  {
    private final DateFormat a;
    private final DateFormat b;
    private final DateFormat c;
    
    h()
    {
      this(DateFormat.getDateTimeInstance(2, 2, Locale.US), DateFormat.getDateTimeInstance(2, 2));
    }
    
    public h(int paramInt1, int paramInt2)
    {
      this(DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US), DateFormat.getDateTimeInstance(paramInt1, paramInt2));
    }
    
    h(String paramString)
    {
      this(new SimpleDateFormat(paramString, Locale.US), new SimpleDateFormat(paramString));
    }
    
    private h(DateFormat paramDateFormat1, DateFormat paramDateFormat2)
    {
      this.a = paramDateFormat1;
      this.b = paramDateFormat2;
      this.c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
      this.c.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
    
    private z a(java.util.Date paramDate)
    {
      synchronized (this.b)
      {
        String str = this.a.format(paramDate);
        paramDate = new com/b/a/ag;
        paramDate.<init>(str);
        return paramDate;
      }
    }
    
    private java.util.Date a(z paramz)
    {
      for (;;)
      {
        synchronized (this.b)
        {
          try
          {
            java.util.Date localDate1 = this.b.parse(paramz.c());
            paramz = localDate1;
            return paramz;
          }
          catch (ParseException localParseException1) {}
        }
        try
        {
          java.util.Date localDate2 = this.a.parse(paramz.c());
          paramz = localDate2;
          continue;
          paramz = finally;
          throw paramz;
        }
        catch (ParseException localParseException2)
        {
          try
          {
            localObject = this.c.parse(paramz.c());
            paramz = (z)localObject;
          }
          catch (ParseException localParseException3)
          {
            Object localObject = new com/b/a/al;
            ((al)localObject).<init>(paramz.c(), localParseException3);
            throw ((Throwable)localObject);
          }
        }
      }
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(h.class.getSimpleName());
      localStringBuilder.append('(').append(this.b.getClass().getSimpleName()).append(')');
      return localStringBuilder.toString();
    }
  }
  
  static final class i
    implements ak<InetAddress>, x<InetAddress>
  {
    private static InetAddress a(z paramz)
    {
      try
      {
        paramz = InetAddress.getByName(paramz.c());
        return paramz;
      }
      catch (UnknownHostException paramz)
      {
        throw new ae(paramz);
      }
    }
  }
  
  static final class j
    implements ak<java.sql.Date>, x<java.sql.Date>
  {
    private final DateFormat a = new SimpleDateFormat("MMM d, yyyy");
    
    private z a(java.sql.Date paramDate)
    {
      synchronized (this.a)
      {
        String str = this.a.format(paramDate);
        paramDate = new com/b/a/ag;
        paramDate.<init>(str);
        return paramDate;
      }
    }
    
    /* Error */
    private java.sql.Date a(z paramz)
    {
      // Byte code:
      //   0: aload_1
      //   1: instanceof 37
      //   4: ifne +13 -> 17
      //   7: new 43	com/b/a/ae
      //   10: dup
      //   11: ldc 45
      //   13: invokespecial 46	com/b/a/ae:<init>	(Ljava/lang/String;)V
      //   16: athrow
      //   17: aload_0
      //   18: getfield 27	com/b/a/f$j:a	Ljava/text/DateFormat;
      //   21: astore_2
      //   22: aload_2
      //   23: monitorenter
      //   24: aload_0
      //   25: getfield 27	com/b/a/f$j:a	Ljava/text/DateFormat;
      //   28: aload_1
      //   29: invokevirtual 52	com/b/a/z:c	()Ljava/lang/String;
      //   32: invokevirtual 56	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
      //   35: astore_3
      //   36: new 58	java/sql/Date
      //   39: astore_1
      //   40: aload_1
      //   41: aload_3
      //   42: invokevirtual 64	java/util/Date:getTime	()J
      //   45: invokespecial 67	java/sql/Date:<init>	(J)V
      //   48: aload_2
      //   49: monitorexit
      //   50: aload_1
      //   51: areturn
      //   52: astore_1
      //   53: aload_2
      //   54: monitorexit
      //   55: aload_1
      //   56: athrow
      //   57: astore_1
      //   58: new 69	com/b/a/al
      //   61: dup
      //   62: aload_1
      //   63: invokespecial 72	com/b/a/al:<init>	(Ljava/lang/Throwable;)V
      //   66: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	67	0	this	j
      //   0	67	1	paramz	z
      //   35	7	3	localDate	java.util.Date
      // Exception table:
      //   from	to	target	type
      //   24	50	52	finally
      //   53	55	52	finally
      //   17	24	57	java/text/ParseException
      //   55	57	57	java/text/ParseException
    }
  }
  
  static final class k
    implements ak<Time>, x<Time>
  {
    private final DateFormat a = new SimpleDateFormat("hh:mm:ss a");
    
    private z a(Time paramTime)
    {
      synchronized (this.a)
      {
        String str = this.a.format(paramTime);
        paramTime = new com/b/a/ag;
        paramTime.<init>(str);
        return paramTime;
      }
    }
    
    /* Error */
    private Time a(z paramz)
    {
      // Byte code:
      //   0: aload_1
      //   1: instanceof 37
      //   4: ifne +13 -> 17
      //   7: new 43	com/b/a/ae
      //   10: dup
      //   11: ldc 45
      //   13: invokespecial 46	com/b/a/ae:<init>	(Ljava/lang/String;)V
      //   16: athrow
      //   17: aload_0
      //   18: getfield 27	com/b/a/f$k:a	Ljava/text/DateFormat;
      //   21: astore_2
      //   22: aload_2
      //   23: monitorenter
      //   24: aload_0
      //   25: getfield 27	com/b/a/f$k:a	Ljava/text/DateFormat;
      //   28: aload_1
      //   29: invokevirtual 52	com/b/a/z:c	()Ljava/lang/String;
      //   32: invokevirtual 56	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
      //   35: astore_1
      //   36: new 58	java/sql/Time
      //   39: astore_3
      //   40: aload_3
      //   41: aload_1
      //   42: invokevirtual 64	java/util/Date:getTime	()J
      //   45: invokespecial 67	java/sql/Time:<init>	(J)V
      //   48: aload_2
      //   49: monitorexit
      //   50: aload_3
      //   51: areturn
      //   52: astore_1
      //   53: aload_2
      //   54: monitorexit
      //   55: aload_1
      //   56: athrow
      //   57: astore_1
      //   58: new 69	com/b/a/al
      //   61: dup
      //   62: aload_1
      //   63: invokespecial 72	com/b/a/al:<init>	(Ljava/lang/Throwable;)V
      //   66: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	67	0	this	k
      //   0	67	1	paramz	z
      //   39	12	3	localTime	Time
      // Exception table:
      //   from	to	target	type
      //   24	50	52	finally
      //   53	55	52	finally
      //   17	24	57	java/text/ParseException
      //   55	57	57	java/text/ParseException
    }
  }
  
  static final class l
    implements x<Timestamp>
  {}
  
  private static final class m
    implements x<Double>
  {
    private static Double a(z paramz)
    {
      try
      {
        double d = paramz.d();
        return Double.valueOf(d);
      }
      catch (NumberFormatException paramz)
      {
        throw new al(paramz);
      }
      catch (UnsupportedOperationException paramz)
      {
        throw new al(paramz);
      }
      catch (IllegalStateException paramz)
      {
        throw new al(paramz);
      }
    }
    
    public final String toString()
    {
      return m.class.getSimpleName();
    }
  }
  
  static final class n
    implements ak<Double>
  {
    private final boolean a;
    
    n(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
  }
  
  private static final class o<T extends Enum<T>>
    implements ak<T>, x<T>
  {
    public final String toString()
    {
      return o.class.getSimpleName();
    }
  }
  
  private static final class p
    implements x<Float>
  {
    private static Float a(z paramz)
    {
      try
      {
        float f = paramz.g();
        return Float.valueOf(f);
      }
      catch (NumberFormatException paramz)
      {
        throw new al(paramz);
      }
      catch (UnsupportedOperationException paramz)
      {
        throw new al(paramz);
      }
      catch (IllegalStateException paramz)
      {
        throw new al(paramz);
      }
    }
    
    public final String toString()
    {
      return p.class.getSimpleName();
    }
  }
  
  static final class q
    implements ak<Float>
  {
    private final boolean a;
    
    q(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
  }
  
  private static final class r
    implements ak<GregorianCalendar>, x<GregorianCalendar>
  {
    public final String toString()
    {
      return r.class.getSimpleName();
    }
  }
  
  private static final class s
    implements ak<Integer>, x<Integer>
  {
    private static Integer a(z paramz)
    {
      try
      {
        int i = paramz.i();
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramz)
      {
        throw new al(paramz);
      }
      catch (UnsupportedOperationException paramz)
      {
        throw new al(paramz);
      }
      catch (IllegalStateException paramz)
      {
        throw new al(paramz);
      }
    }
    
    public final String toString()
    {
      return s.class.getSimpleName();
    }
  }
  
  private static final class t
    implements ak<Locale>, x<Locale>
  {
    public final String toString()
    {
      return t.class.getSimpleName();
    }
  }
  
  private static final class u
    implements x<Long>
  {
    private static Long a(z paramz)
    {
      try
      {
        long l = paramz.h();
        return Long.valueOf(l);
      }
      catch (NumberFormatException paramz)
      {
        throw new al(paramz);
      }
      catch (UnsupportedOperationException paramz)
      {
        throw new al(paramz);
      }
      catch (IllegalStateException paramz)
      {
        throw new al(paramz);
      }
    }
    
    public final String toString()
    {
      return u.class.getSimpleName();
    }
  }
  
  private static final class v
    implements ak<Long>
  {
    private final am a;
    
    private v(am paramam)
    {
      this.a = paramam;
    }
    
    public final String toString()
    {
      return v.class.getSimpleName();
    }
  }
  
  private static final class w
    implements ak<Number>, x<Number>
  {
    private static Number a(z paramz)
    {
      try
      {
        paramz = paramz.b();
        return paramz;
      }
      catch (NumberFormatException paramz)
      {
        throw new al(paramz);
      }
      catch (UnsupportedOperationException paramz)
      {
        throw new al(paramz);
      }
      catch (IllegalStateException paramz)
      {
        throw new al(paramz);
      }
    }
    
    public final String toString()
    {
      return w.class.getSimpleName();
    }
  }
  
  private static final class x
    implements ak<Short>, x<Short>
  {
    private static Short a(z paramz)
    {
      try
      {
        short s = paramz.l();
        return Short.valueOf(s);
      }
      catch (NumberFormatException paramz)
      {
        throw new al(paramz);
      }
      catch (UnsupportedOperationException paramz)
      {
        throw new al(paramz);
      }
      catch (IllegalStateException paramz)
      {
        throw new al(paramz);
      }
    }
    
    public final String toString()
    {
      return x.class.getSimpleName();
    }
  }
  
  private static final class y
    implements ak<StringBuffer>, x<StringBuffer>
  {
    public final String toString()
    {
      return y.class.getSimpleName();
    }
  }
  
  private static final class z
    implements ak<StringBuilder>, x<StringBuilder>
  {
    public final String toString()
    {
      return z.class.getSimpleName();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */