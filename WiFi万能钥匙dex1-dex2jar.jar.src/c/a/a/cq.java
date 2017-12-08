package c.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class cq
  extends bt
{
  protected List a;
  
  final void a(q paramq)
  {
    this.a = new ArrayList(2);
    while (paramq.b() > 0)
    {
      byte[] arrayOfByte = paramq.k();
      this.a.add(arrayOfByte);
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    paraml = this.a.iterator();
    while (paraml.hasNext()) {
      params.b((byte[])paraml.next());
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(a((byte[])localIterator.next(), true));
      if (localIterator.hasNext()) {
        localStringBuffer.append(" ");
      }
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */