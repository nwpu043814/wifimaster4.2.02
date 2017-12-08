package c.a.a;

import c.a.a.a.d;
import java.security.PublicKey;

abstract class ai
  extends bt
{
  protected int a;
  protected int b;
  protected int c;
  protected byte[] d;
  protected int e = -1;
  protected PublicKey f = null;
  
  final void a(q paramq)
  {
    this.a = paramq.h();
    this.b = paramq.g();
    this.c = paramq.g();
    if (paramq.b() > 0) {
      this.d = paramq.j();
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.c(this.a);
    params.b(this.b);
    params.b(this.c);
    if (this.d != null) {
      params.a(this.d);
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
    if (this.d != null)
    {
      if (!bk.a("multiline")) {
        break label107;
      }
      localStringBuffer.append(" (\n");
      localStringBuffer.append(d.a(this.d, "\t", true));
      localStringBuffer.append(" ; key_tag = ");
      localStringBuffer.append(z_());
    }
    for (;;)
    {
      return localStringBuffer.toString();
      label107:
      localStringBuffer.append(" ");
      localStringBuffer.append(d.a(this.d));
    }
  }
  
  public int z_()
  {
    int j = 0;
    if (this.e >= 0)
    {
      i = this.e;
      return i;
    }
    Object localObject = new s((byte)0);
    a((s)localObject, null, false);
    localObject = ((s)localObject).b();
    if (this.c == 1) {}
    int k;
    for (int i = ((localObject[(localObject.length - 3)] & 0xFF) << 8) + (localObject[(localObject.length - 2)] & 0xFF);; i = (k >> 16 & 0xFFFF) + k)
    {
      this.e = (i & 0xFFFF);
      i = this.e;
      break;
      i = 0;
      while (j < localObject.length - 1)
      {
        i += ((localObject[j] & 0xFF) << 8) + (localObject[(j + 1)] & 0xFF);
        j += 2;
      }
      k = i;
      if (j < localObject.length) {
        k = i + ((localObject[j] & 0xFF) << 8);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */