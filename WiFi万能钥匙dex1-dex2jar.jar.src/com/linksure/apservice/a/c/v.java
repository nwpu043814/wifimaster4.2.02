package com.linksure.apservice.a.c;

import android.content.Context;
import com.linksure.apservice.a.a.f;
import com.linksure.apservice.a.b.b.a;
import com.linksure.apservice.a.b.c;
import com.linksure.apservice.a.d;
import com.linksure.apservice.a.d.a;
import com.linksure.apservice.a.h;
import com.linksure.apservice.a.j;
import java.io.File;

public final class v
  implements d
{
  private static final String a = a.a + File.separator + "tmp";
  private f b;
  private c c;
  private Context d;
  
  public v(Context paramContext, f paramf, c paramc)
  {
    this.d = paramContext;
    this.b = paramf;
    this.c = paramc;
    com.linksure.apservice.a.f.b.class.getSimpleName();
  }
  
  public final String a(String paramString)
  {
    return this.c.c(paramString);
  }
  
  public final void a(String paramString, d.a<String> parama)
  {
    com.linksure.apservice.a.f.b.b(new w(this, paramString, new a(parama)));
  }
  
  public final void a(String paramString, h<Long> paramh)
  {
    com.linksure.apservice.a.f.b.b(new x(this, paramString, new j(paramh)));
  }
  
  static final class a<T>
    implements d.a<T>
  {
    private d.a a;
    
    public a(d.a parama)
    {
      this.a = parama;
    }
    
    public final void a(int paramInt)
    {
      if (this.a != null) {
        com.linksure.apservice.a.f.b.c(new z(this, paramInt));
      }
    }
    
    public final void a(com.linksure.apservice.a.d.a.b paramb)
    {
      if (this.a != null) {
        com.linksure.apservice.a.f.b.c(new ab(this, paramb));
      }
    }
    
    public final void a(T paramT)
    {
      if (this.a != null) {
        com.linksure.apservice.a.f.b.c(new aa(this, paramT));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/c/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */