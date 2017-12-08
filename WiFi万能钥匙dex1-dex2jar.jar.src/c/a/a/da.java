package c.a.a;

import java.util.ArrayList;
import java.util.List;

public final class da
  extends bt
{
  private byte[] a;
  private int b;
  private int[] c;
  
  final bt a()
  {
    return new da();
  }
  
  final void a(q paramq)
  {
    int k = 0;
    this.a = paramq.d(4);
    this.b = paramq.g();
    paramq = paramq.j();
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramq.length; i++) {
      for (int j = 0; j < 8; j++) {
        if ((paramq[i] & 0xFF & 1 << 7 - j) != 0) {
          localArrayList.add(new Integer(i * 8 + j));
        }
      }
    }
    this.c = new int[localArrayList.size()];
    for (i = k; i < localArrayList.size(); i++) {
      this.c[i] = ((Integer)localArrayList.get(i)).intValue();
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.a(this.a);
    params.b(this.b);
    paraml = new byte[this.c[(this.c.length - 1)] / 8 + 1];
    for (int i = 0; i < this.c.length; i++)
    {
      int k = this.c[i];
      int j = k / 8;
      paraml[j] = ((byte)(1 << 7 - k % 8 | paraml[j]));
    }
    params.a(paraml);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(f.a(this.a));
    localStringBuffer.append(" ");
    localStringBuffer.append(this.b);
    for (int i = 0; i < this.c.length; i++) {
      localStringBuffer.append(" " + this.c[i]);
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/da.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */