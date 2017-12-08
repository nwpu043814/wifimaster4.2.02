package com.b.a;

import com.b.a.b.a;
import java.lang.reflect.Type;

final class y<T>
  implements x<T>
{
  private final x<T> a;
  
  y(x<T> paramx)
  {
    this.a = ((x)a.a(paramx));
  }
  
  public final T a(z paramz, Type paramType, u paramu)
  {
    try
    {
      paramu = this.a.a(paramz, paramType, paramu);
      return paramu;
    }
    catch (ae paramz)
    {
      throw paramz;
    }
    catch (Exception paramu)
    {
      throw new ae("The JsonDeserializer " + this.a + " failed to deserialized json object " + paramz + " given the type " + paramType, paramu);
    }
  }
  
  public final String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */