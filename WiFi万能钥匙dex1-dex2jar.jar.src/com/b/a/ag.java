package com.b.a;

import com.b.a.b.a;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class ag
  extends z
{
  private static final Class<?>[] a = { Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
  private static final BigInteger b = BigInteger.valueOf(2147483647L);
  private static final BigInteger c = BigInteger.valueOf(Long.MAX_VALUE);
  private Object d;
  
  public ag(Boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  public ag(Character paramCharacter)
  {
    a(paramCharacter);
  }
  
  public ag(Number paramNumber)
  {
    a(paramNumber);
  }
  
  ag(Object paramObject)
  {
    a(paramObject);
  }
  
  public ag(String paramString)
  {
    a(paramString);
  }
  
  static Number a(String paramString)
  {
    for (;;)
    {
      try
      {
        l = Long.parseLong(paramString);
        if ((l < -2147483648L) || (l > 2147483647L)) {
          continue;
        }
        Integer localInteger = Integer.valueOf((int)l);
        paramString = localInteger;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          long l;
          BigDecimal localBigDecimal = new java/math/BigDecimal;
          localBigDecimal.<init>(paramString);
          paramString = localBigDecimal;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          paramString = Double.valueOf(Double.parseDouble(paramString));
        }
        continue;
      }
      return paramString;
      paramString = Long.valueOf(l);
    }
  }
  
  private void a(Object paramObject)
  {
    boolean bool = false;
    if ((paramObject instanceof Character))
    {
      this.d = String.valueOf(((Character)paramObject).charValue());
      return;
    }
    int i;
    if (!(paramObject instanceof Number))
    {
      if (!(paramObject instanceof String)) {
        break label61;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        bool = true;
      }
      a.a(bool);
      this.d = paramObject;
      break;
      label61:
      Class localClass = paramObject.getClass();
      Class[] arrayOfClass = a;
      int j = arrayOfClass.length;
      for (i = 0;; i++)
      {
        if (i >= j) {
          break label106;
        }
        if (arrayOfClass[i].isAssignableFrom(localClass))
        {
          i = 1;
          break;
        }
      }
      label106:
      i = 0;
    }
  }
  
  private static boolean a(ag paramag)
  {
    boolean bool;
    if ((paramag.d instanceof Number))
    {
      paramag = (Number)paramag.d;
      if (((paramag instanceof BigInteger)) || ((paramag instanceof Long)) || ((paramag instanceof Integer)) || ((paramag instanceof Short)) || ((paramag instanceof Byte))) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  private static boolean b(ag paramag)
  {
    boolean bool;
    if ((paramag.d instanceof Number))
    {
      paramag = (Number)paramag.d;
      if (((paramag instanceof BigDecimal)) || ((paramag instanceof Double)) || ((paramag instanceof Float))) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  protected final void a(Appendable paramAppendable, h paramh)
  {
    if ((this.d instanceof String))
    {
      paramAppendable.append('"');
      paramAppendable.append(paramh.a(this.d.toString()));
      paramAppendable.append('"');
    }
    for (;;)
    {
      return;
      paramAppendable.append(this.d.toString());
    }
  }
  
  public final boolean a()
  {
    return this.d instanceof Boolean;
  }
  
  public final Number b()
  {
    if ((this.d instanceof String)) {}
    for (Number localNumber = a((String)this.d);; localNumber = (Number)this.d) {
      return localNumber;
    }
  }
  
  public final String c()
  {
    String str;
    if ((this.d instanceof Number)) {
      str = b().toString();
    }
    for (;;)
    {
      return str;
      if ((this.d instanceof Boolean)) {
        str = ((Boolean)this.d).toString();
      } else {
        str = (String)this.d;
      }
    }
  }
  
  public final double d()
  {
    if ((this.d instanceof Number)) {}
    for (double d1 = b().doubleValue();; d1 = Double.parseDouble(c())) {
      return d1;
    }
  }
  
  public final BigDecimal e()
  {
    if ((this.d instanceof BigDecimal)) {}
    for (BigDecimal localBigDecimal = (BigDecimal)this.d;; localBigDecimal = new BigDecimal(this.d.toString())) {
      return localBigDecimal;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this == paramObject) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        bool1 = false;
      }
      else
      {
        paramObject = (ag)paramObject;
        if (this.d == null)
        {
          bool1 = bool2;
          if (((ag)paramObject).d != null) {
            bool1 = false;
          }
        }
        else if ((a(this)) && (a((ag)paramObject)))
        {
          bool1 = bool2;
          if (b().longValue() != ((ag)paramObject).b().longValue()) {
            bool1 = false;
          }
        }
        else if ((b(this)) && (b((ag)paramObject)))
        {
          double d1 = b().doubleValue();
          double d2 = ((ag)paramObject).b().doubleValue();
          bool1 = bool2;
          if (d1 != d2) {
            if (Double.isNaN(d1))
            {
              bool1 = bool2;
              if (Double.isNaN(d2)) {}
            }
            else
            {
              bool1 = false;
            }
          }
        }
        else
        {
          bool1 = this.d.equals(((ag)paramObject).d);
        }
      }
    }
  }
  
  public final BigInteger f()
  {
    if ((this.d instanceof BigInteger)) {}
    for (BigInteger localBigInteger = (BigInteger)this.d;; localBigInteger = new BigInteger(this.d.toString())) {
      return localBigInteger;
    }
  }
  
  public final float g()
  {
    if ((this.d instanceof Number)) {}
    for (float f = b().floatValue();; f = Float.parseFloat(c())) {
      return f;
    }
  }
  
  public final long h()
  {
    if ((this.d instanceof Number)) {}
    for (long l = b().longValue();; l = Long.parseLong(c())) {
      return l;
    }
  }
  
  public final int hashCode()
  {
    int i;
    if (this.d == null) {
      i = 31;
    }
    for (;;)
    {
      return i;
      long l;
      if (a(this))
      {
        l = b().longValue();
        i = (int)(l ^ l >>> 32);
      }
      else if (b(this))
      {
        l = Double.doubleToLongBits(b().doubleValue());
        i = (int)(l ^ l >>> 32);
      }
      else
      {
        i = this.d.hashCode();
      }
    }
  }
  
  public final int i()
  {
    if ((this.d instanceof Number)) {}
    for (int i = b().intValue();; i = Integer.parseInt(c())) {
      return i;
    }
  }
  
  public final byte j()
  {
    if ((this.d instanceof Number)) {}
    for (byte b1 = b().byteValue();; b1 = Byte.parseByte(c())) {
      return b1;
    }
  }
  
  public final char k()
  {
    return c().charAt(0);
  }
  
  public final short l()
  {
    if ((this.d instanceof Number)) {}
    for (short s = b().shortValue();; s = Short.parseShort(c())) {
      return s;
    }
  }
  
  public final boolean m()
  {
    if ((this.d instanceof Boolean)) {}
    for (boolean bool = ((Boolean)this.d).booleanValue();; bool = Boolean.parseBoolean(c())) {
      return bool;
    }
  }
  
  final Object n()
  {
    Object localObject;
    if ((this.d instanceof BigInteger))
    {
      localObject = (BigInteger)this.d;
      if (((BigInteger)localObject).compareTo(b) < 0) {
        localObject = Integer.valueOf(((BigInteger)localObject).intValue());
      }
    }
    for (;;)
    {
      return localObject;
      if (((BigInteger)localObject).compareTo(c) < 0) {
        localObject = Long.valueOf(((BigInteger)localObject).longValue());
      } else {
        localObject = this.d;
      }
    }
  }
  
  public final boolean r()
  {
    return this.d instanceof Number;
  }
  
  public final boolean s()
  {
    return this.d instanceof String;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */