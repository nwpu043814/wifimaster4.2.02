package com.b.b;

import java.io.IOException;

public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>>
  implements u
{
  protected int a = 0;
  
  private String a(String paramString)
  {
    return "Serializing " + getClass().getName() + " to a " + paramString + " threw an IOException (should never happen).";
  }
  
  public final e a()
  {
    try
    {
      Object localObject = e.c(k());
      a(((e.e)localObject).b());
      localObject = ((e.e)localObject).a();
      return (e)localObject;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(a("ByteString"), localIOException);
    }
  }
  
  public final byte[] b()
  {
    try
    {
      byte[] arrayOfByte = new byte[k()];
      h localh = h.a(arrayOfByte);
      a(localh);
      localh.i();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(a("byte array"), localIOException);
    }
  }
  
  public static abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>>
    implements u.a
  {
    public abstract BuilderType a();
    
    public abstract BuilderType a(g paramg, j paramj);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */