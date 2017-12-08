package com.b.a;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class z
{
  private static final h a = new h();
  
  protected abstract void a(Appendable paramAppendable, h paramh);
  
  public Number b()
  {
    throw new UnsupportedOperationException();
  }
  
  public String c()
  {
    throw new UnsupportedOperationException();
  }
  
  public double d()
  {
    throw new UnsupportedOperationException();
  }
  
  public BigDecimal e()
  {
    throw new UnsupportedOperationException();
  }
  
  public BigInteger f()
  {
    throw new UnsupportedOperationException();
  }
  
  public float g()
  {
    throw new UnsupportedOperationException();
  }
  
  public long h()
  {
    throw new UnsupportedOperationException();
  }
  
  public int i()
  {
    throw new UnsupportedOperationException();
  }
  
  public byte j()
  {
    throw new UnsupportedOperationException();
  }
  
  public char k()
  {
    throw new UnsupportedOperationException();
  }
  
  public short l()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean m()
  {
    throw new UnsupportedOperationException();
  }
  
  Object n()
  {
    throw new UnsupportedOperationException();
  }
  
  public final ac o()
  {
    if ((this instanceof ac)) {
      return (ac)this;
    }
    throw new IllegalStateException("This is not a JSON Object.");
  }
  
  public final s p()
  {
    if ((this instanceof s)) {
      return (s)this;
    }
    throw new IllegalStateException("This is not a JSON Array.");
  }
  
  public final ag q()
  {
    if ((this instanceof ag)) {
      return (ag)this;
    }
    throw new IllegalStateException("This is not a JSON Primitive.");
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      a((Appendable)localObject, a);
      localObject = ((StringBuilder)localObject).toString();
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */