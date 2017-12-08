package c.a.a;

import java.util.BitSet;

public final class bf
  extends bt
{
  private bg a;
  private BitSet b;
  
  final bt a()
  {
    return new bf();
  }
  
  final void a(q paramq)
  {
    this.a = new bg(paramq);
    this.b = new BitSet();
    int k = paramq.b();
    for (int i = 0; i < k; i++)
    {
      int m = paramq.g();
      for (int j = 0; j < 8; j++) {
        if ((1 << 7 - j & m) != 0) {
          this.b.set(i * 8 + j);
        }
      }
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    this.a.a(params, null, paramBoolean);
    int m = this.b.length();
    int i = 0;
    int j = 0;
    if (j < m)
    {
      if (this.b.get(j)) {}
      for (int k = 1 << 7 - j % 8;; k = 0)
      {
        k |= i;
        if (j % 8 != 7)
        {
          i = k;
          if (j != m - 1) {}
        }
        else
        {
          params.b(k);
          i = 0;
        }
        j++;
        break;
      }
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    int j = this.b.length();
    for (int i = 0; i < j; i = (short)(i + 1)) {
      if (this.b.get(i))
      {
        localStringBuffer.append(" ");
        localStringBuffer.append(ct.b(i));
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */