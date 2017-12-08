package c.a.a;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class e
  extends bt
{
  private int a;
  
  private static final byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt >>> 24 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  final bt a()
  {
    return new e();
  }
  
  final void a(q paramq)
  {
    paramq = paramq.d(4);
    int k = paramq[0];
    int j = paramq[1];
    int i = paramq[2];
    this.a = (paramq[3] & 0xFF | (k & 0xFF) << 24 | (j & 0xFF) << 16 | (i & 0xFF) << 8);
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.a(this.a & 0xFFFFFFFF);
  }
  
  final String b()
  {
    return f.a(a(this.a));
  }
  
  public final InetAddress w_()
  {
    try
    {
      if (this.g == null) {}
      for (InetAddress localInetAddress = InetAddress.getByAddress(a(this.a));; localInetAddress = InetAddress.getByAddress(this.g.toString(), a(this.a))) {
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */