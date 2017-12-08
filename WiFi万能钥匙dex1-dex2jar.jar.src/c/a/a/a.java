package c.a.a;

import java.net.InetAddress;

public final class a
  extends bt
{
  private int a;
  private InetAddress b;
  private bg c;
  
  final bt a()
  {
    return new a();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.g();
    int i = (128 - this.a + 7) / 8;
    if (this.a < 128)
    {
      byte[] arrayOfByte = new byte[16];
      paramq.a(arrayOfByte, 16 - i, i);
      this.b = InetAddress.getByAddress(arrayOfByte);
    }
    if (this.a > 0) {
      this.c = new bg(paramq);
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.b(this.a);
    if (this.b != null)
    {
      int i = (128 - this.a + 7) / 8;
      params.a(this.b.getAddress(), 16 - i, i);
    }
    if (this.c != null) {
      this.c.a(params, null, paramBoolean);
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    if (this.b != null)
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(this.b.getHostAddress());
    }
    if (this.c != null)
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(this.c);
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */