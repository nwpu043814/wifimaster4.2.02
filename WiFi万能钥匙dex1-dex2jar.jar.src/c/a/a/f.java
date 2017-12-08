package c.a.a;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class f
{
  public static int a(int paramInt)
  {
    if (paramInt == 1) {}
    for (paramInt = 4;; paramInt = 16)
    {
      return paramInt;
      if (paramInt != 2) {
        break;
      }
    }
    throw new IllegalArgumentException("unknown address family");
  }
  
  public static int a(InetAddress paramInetAddress)
  {
    if ((paramInetAddress instanceof Inet4Address)) {}
    for (int i = 1;; i = 2)
    {
      return i;
      if (!(paramInetAddress instanceof Inet6Address)) {
        break;
      }
    }
    throw new IllegalArgumentException("unknown address family");
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) + "." + (paramArrayOfByte[1] & 0xFF) + "." + (paramArrayOfByte[2] & 0xFF) + "." + (paramArrayOfByte[3] & 0xFF);
  }
  
  public static InetAddress a(String paramString)
  {
    return a(paramString, a(paramString, false)[0]);
  }
  
  private static InetAddress a(String paramString, bt parambt)
  {
    if ((parambt instanceof e)) {}
    for (parambt = ((e)parambt).w_();; parambt = ((b)parambt).v_()) {
      return InetAddress.getByAddress(paramString, parambt.getAddress());
    }
  }
  
  public static InetAddress a(InetAddress paramInetAddress, int paramInt)
  {
    int j = 0;
    int i = a(a(paramInetAddress)) * 8;
    if ((paramInt < 0) || (paramInt > i)) {
      throw new IllegalArgumentException("invalid mask length");
    }
    if (paramInt == i) {}
    for (;;)
    {
      return paramInetAddress;
      paramInetAddress = paramInetAddress.getAddress();
      for (i = paramInt / 8 + 1; i < paramInetAddress.length; i++) {
        paramInetAddress[i] = 0;
      }
      int k = 0;
      i = j;
      for (j = k; j < paramInt % 8; j++) {
        i |= 1 << 7 - j;
      }
      paramInt /= 8;
      paramInetAddress[paramInt] = ((byte)(i & paramInetAddress[paramInt]));
      try
      {
        paramInetAddress = InetAddress.getByAddress(paramInetAddress);
      }
      catch (UnknownHostException paramInetAddress)
      {
        throw new IllegalArgumentException("invalid address");
      }
    }
  }
  
  private static bt[] a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      bt[] arrayOfbt;
      try
      {
        localObject = new c/a/a/am;
        ((am)localObject).<init>(paramString, 1);
        arrayOfbt = ((am)localObject).a();
        if (arrayOfbt == null)
        {
          if (((am)localObject).b() == 4)
          {
            localObject = new c/a/a/am;
            ((am)localObject).<init>(paramString, 28);
            localObject = ((am)localObject).a();
            if (localObject != null) {
              return (bt[])localObject;
            }
          }
          paramString = new java/net/UnknownHostException;
          paramString.<init>("unknown host");
          throw paramString;
        }
      }
      catch (cs paramString)
      {
        throw new UnknownHostException("invalid name");
      }
      Object localObject = arrayOfbt;
      if (paramBoolean)
      {
        localObject = new c/a/a/am;
        ((am)localObject).<init>(paramString, 28);
        paramString = ((am)localObject).a();
        localObject = arrayOfbt;
        if (paramString != null)
        {
          localObject = new bt[arrayOfbt.length + paramString.length];
          System.arraycopy(arrayOfbt, 0, localObject, 0, arrayOfbt.length);
          System.arraycopy(paramString, 0, localObject, arrayOfbt.length, paramString.length);
        }
      }
    }
  }
  
  public static InetAddress[] b(String paramString)
  {
    bt[] arrayOfbt = a(paramString, true);
    InetAddress[] arrayOfInetAddress = new InetAddress[arrayOfbt.length];
    for (int i = 0; i < arrayOfbt.length; i++) {
      arrayOfInetAddress[i] = a(paramString, arrayOfbt[i]);
    }
    return arrayOfInetAddress;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */