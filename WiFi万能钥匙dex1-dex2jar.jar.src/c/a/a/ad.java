package c.a.a;

import c.a.a.a.d;
import java.net.InetAddress;

public final class ad
  extends bt
{
  private int a;
  private int b;
  private int c;
  private Object d;
  private byte[] e;
  
  final bt a()
  {
    return new ad();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.g();
    this.b = paramq.g();
    this.c = paramq.g();
    switch (this.b)
    {
    default: 
      throw new db("invalid gateway type");
    case 0: 
      this.d = null;
    }
    for (;;)
    {
      if (paramq.b() > 0) {
        this.e = paramq.j();
      }
      return;
      this.d = InetAddress.getByAddress(paramq.d(4));
      continue;
      this.d = InetAddress.getByAddress(paramq.d(16));
      continue;
      this.d = new bg(paramq);
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.b(this.a);
    params.b(this.b);
    params.b(this.c);
    switch (this.b)
    {
    }
    for (;;)
    {
      if (this.e != null) {
        params.a(this.e);
      }
      return;
      params.a(((InetAddress)this.d).getAddress());
      continue;
      ((bg)this.d).a(params, null, paramBoolean);
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.b);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.c);
    localStringBuffer.append(" ");
    switch (this.b)
    {
    }
    for (;;)
    {
      if (this.e != null)
      {
        localStringBuffer.append(" ");
        localStringBuffer.append(d.a(this.e));
      }
      return localStringBuffer.toString();
      localStringBuffer.append(".");
      continue;
      localStringBuffer.append(((InetAddress)this.d).getHostAddress());
      continue;
      localStringBuffer.append(this.d);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */