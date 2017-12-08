package c.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class bi
  extends bt
{
  private List a;
  
  final bt a()
  {
    return new bi();
  }
  
  final void a(q paramq)
  {
    if (paramq.b() > 0) {
      this.a = new ArrayList();
    }
    if (paramq.b() > 0)
    {
      int k = paramq.h();
      int i = paramq.h();
      if (paramq.b() < i) {
        throw new db("truncated option");
      }
      int j = paramq.d();
      paramq.a(i);
      Object localObject;
      switch (k)
      {
      default: 
        localObject = new aa(k);
      }
      for (;;)
      {
        ((u)localObject).a(paramq);
        paramq.b(j);
        this.a.add(localObject);
        break;
        localObject = new bc();
        continue;
        localObject = new k();
      }
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      paraml = this.a.iterator();
      while (paraml.hasNext()) {
        ((u)paraml.next()).b(params);
      }
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (this.a != null)
    {
      localStringBuffer.append(this.a);
      localStringBuffer.append(" ");
    }
    localStringBuffer.append(" ; payload ");
    localStringBuffer.append(this.i);
    localStringBuffer.append(", xrcode ");
    localStringBuffer.append(e());
    localStringBuffer.append(", version ");
    localStringBuffer.append((int)(this.j >>> 16 & 0xFF));
    localStringBuffer.append(", flags ");
    localStringBuffer.append((int)(this.j & 0xFFFF));
    return localStringBuffer.toString();
  }
  
  public final int d()
  {
    return this.i;
  }
  
  public final int e()
  {
    return (int)(this.j >>> 24);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((super.equals(paramObject)) && (this.j == ((bi)paramObject).j)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */