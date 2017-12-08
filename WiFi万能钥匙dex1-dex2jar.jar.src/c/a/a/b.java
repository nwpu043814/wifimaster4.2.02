package c.a.a;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class b
  extends bt
{
  private byte[] a;
  
  final bt a()
  {
    return new b();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.d(16);
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.a(this.a);
  }
  
  final String b()
  {
    for (Object localObject = null;; localObject = localInetAddress.getHostAddress())
    {
      try
      {
        localInetAddress = InetAddress.getByAddress(null, this.a);
        if (localInetAddress.getAddress().length != 4) {
          continue;
        }
        localObject = new StringBuffer("0:0:0:0:0:ffff:");
        int j = this.a[12];
        int k = this.a[13];
        int m = this.a[14];
        int i = this.a[15];
        ((StringBuffer)localObject).append(Integer.toHexString(((j & 0xFF) << 8) + (k & 0xFF)));
        ((StringBuffer)localObject).append(':');
        ((StringBuffer)localObject).append(Integer.toHexString(((m & 0xFF) << 8) + (i & 0xFF)));
        localObject = ((StringBuffer)localObject).toString();
      }
      catch (UnknownHostException localUnknownHostException)
      {
        InetAddress localInetAddress;
        for (;;) {}
      }
      return (String)localObject;
    }
  }
  
  public final InetAddress v_()
  {
    try
    {
      if (this.g == null) {}
      for (InetAddress localInetAddress = InetAddress.getByAddress(this.a);; localInetAddress = InetAddress.getByAddress(this.g.toString(), this.a)) {
        return localInetAddress;
      }
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */