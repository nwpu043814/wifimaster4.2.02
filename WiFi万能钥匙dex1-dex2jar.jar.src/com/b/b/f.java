package com.b.b;

import java.util.NoSuchElementException;

final class f
  implements e.d
{
  private int b = 0;
  private final int c = this.a.b();
  
  f(e parame) {}
  
  private byte a()
  {
    try
    {
      e locale = this.a;
      int i = this.b;
      this.b = (i + 1);
      byte b1 = locale.a(i);
      return b1;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new NoSuchElementException(localIndexOutOfBoundsException.getMessage());
    }
  }
  
  public final boolean hasNext()
  {
    if (this.b < this.c) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */