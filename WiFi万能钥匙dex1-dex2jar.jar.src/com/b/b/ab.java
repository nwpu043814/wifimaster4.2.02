package com.b.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class ab
  implements Iterator<Object>
{
  public final boolean hasNext()
  {
    return false;
  }
  
  public final Object next()
  {
    throw new NoSuchElementException();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */