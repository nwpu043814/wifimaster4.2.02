package c.a.a;

import c.a.a.a.d;
import java.util.Date;

public final class cl
  extends bt
{
  private bg a;
  private Date b;
  private Date c;
  private int d;
  private int e;
  private byte[] f;
  private byte[] k;
  
  final bt a()
  {
    return new cl();
  }
  
  final void a(q paramq)
  {
    this.a = new bg(paramq);
    this.b = new Date(paramq.i() * 1000L);
    this.c = new Date(paramq.i() * 1000L);
    this.d = paramq.h();
    this.e = paramq.h();
    int i = paramq.h();
    if (i > 0)
    {
      this.f = paramq.d(i);
      i = paramq.h();
      if (i <= 0) {
        break label111;
      }
    }
    label111:
    for (this.k = paramq.d(i);; this.k = null)
    {
      return;
      this.f = null;
      break;
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    this.a.a(params, null, paramBoolean);
    params.a(this.b.getTime() / 1000L);
    params.a(this.c.getTime() / 1000L);
    params.c(this.d);
    params.c(this.e);
    if (this.f != null)
    {
      params.c(this.f.length);
      params.a(this.f);
      if (this.k == null) {
        break label113;
      }
      params.c(this.k.length);
      params.a(this.k);
    }
    for (;;)
    {
      return;
      params.c(0);
      break;
      label113:
      params.c(0);
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    localStringBuffer.append(" ");
    if (bk.a("multiline")) {
      localStringBuffer.append("(\n\t");
    }
    localStringBuffer.append(y.a(this.b));
    localStringBuffer.append(" ");
    localStringBuffer.append(y.a(this.c));
    localStringBuffer.append(" ");
    String str;
    switch (this.d)
    {
    default: 
      str = Integer.toString(this.d);
      localStringBuffer.append(str);
      localStringBuffer.append(" ");
      localStringBuffer.append(bs.b(this.e));
      if (bk.a("multiline"))
      {
        localStringBuffer.append("\n");
        if (this.f != null)
        {
          localStringBuffer.append(d.a(this.f, "\t", false));
          localStringBuffer.append("\n");
        }
        if (this.k != null) {
          localStringBuffer.append(d.a(this.k, "\t", false));
        }
        localStringBuffer.append(" )");
      }
      break;
    }
    for (;;)
    {
      return localStringBuffer.toString();
      str = "SERVERASSIGNED";
      break;
      str = "DIFFIEHELLMAN";
      break;
      str = "GSSAPI";
      break;
      str = "RESOLVERASSIGNED";
      break;
      str = "DELETE";
      break;
      localStringBuffer.append(" ");
      if (this.f != null)
      {
        localStringBuffer.append(d.a(this.f));
        localStringBuffer.append(" ");
      }
      if (this.k != null) {
        localStringBuffer.append(d.a(this.k));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */