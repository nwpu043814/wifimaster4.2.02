package c.a.a;

import java.net.InetAddress;
import java.net.UnknownHostException;

public final class k
  extends u
{
  private int a;
  private int b;
  private int c;
  private InetAddress d;
  
  k()
  {
    super(8);
  }
  
  final String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.d.getHostAddress());
    localStringBuffer.append("/");
    localStringBuffer.append(this.b);
    localStringBuffer.append(", scope netmask ");
    localStringBuffer.append(this.c);
    return localStringBuffer.toString();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.h();
    if ((this.a != 1) && (this.a != 2)) {
      throw new db("unknown address family");
    }
    this.b = paramq.g();
    if (this.b > f.a(this.a) * 8) {
      throw new db("invalid source netmask");
    }
    this.c = paramq.g();
    if (this.c > f.a(this.a) * 8) {
      throw new db("invalid scope netmask");
    }
    paramq = paramq.j();
    if (paramq.length != (this.b + 7) / 8) {
      throw new db("invalid address");
    }
    byte[] arrayOfByte = new byte[f.a(this.a)];
    System.arraycopy(paramq, 0, arrayOfByte, 0, paramq.length);
    try
    {
      this.d = InetAddress.getByAddress(arrayOfByte);
      if (!f.a(this.d, this.b).equals(this.d)) {
        throw new db("invalid padding");
      }
    }
    catch (UnknownHostException paramq)
    {
      throw new db("invalid address", paramq);
    }
  }
  
  final void a(s params)
  {
    params.c(this.a);
    params.b(this.b);
    params.b(this.c);
    params.a(this.d.getAddress(), 0, (this.b + 7) / 8);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */