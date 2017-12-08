package com.linksure.apservice.ui.home.list;

import android.util.Log;
import android.view.View;
import com.linksure.apservice.b.e;
import com.linksure.apservice.b.e.a;
import com.linksure.apservice.b.j;
import com.linksure.apservice.b.k;
import com.linksure.apservice.ui.common.interceptor.h;
import java.util.List;

public final class l
  extends h
  implements com.linksure.apservice.a.e.b, d.a
{
  com.linksure.apservice.a.a a;
  com.linksure.apservice.a.f b;
  com.linksure.apservice.a.g c;
  d.b d;
  a e = new a();
  String f;
  boolean g;
  int h = 0;
  long i = 0L;
  double j = -1.0D;
  
  public l(d.b paramb, com.linksure.apservice.a.a parama, com.linksure.apservice.a.f paramf, com.linksure.apservice.a.g paramg)
  {
    super(paramb, paramg, parama);
    this.d = ((d.b)com.linksure.apservice.utils.i.a(d.b.class, paramb));
    this.a = parama;
    this.b = paramf;
    this.c = paramg;
  }
  
  public final void a()
  {
    super.a();
    com.linksure.apservice.utils.i.a(this.d).a();
    ((com.linksure.apservice.a.e.a)this.b).a(this);
    ((com.linksure.apservice.a.e.a)this.a).a(this);
    Object localObject1 = this.a.a();
    if (localObject1 != null) {
      this.d.a((com.linksure.apservice.b.a)localObject1);
    }
    Object localObject2 = this.c.a();
    if ((localObject1 != null) || (localObject2 != null))
    {
      if (localObject1 != null) {
        break label157;
      }
      localObject1 = null;
      if (localObject2 != null) {
        break label165;
      }
    }
    label157:
    label165:
    for (localObject2 = null;; localObject2 = ((k)localObject2).b)
    {
      this.d.a((String)localObject1, (String)localObject2);
      this.e.a();
      if (this.b.a() != null) {
        this.d.a(this.b.a(), this.e.a, this.e.b);
      }
      return;
      localObject1 = ((com.linksure.apservice.b.a)localObject1).n;
      break;
    }
  }
  
  public final void a(int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public final void a(long paramLong)
  {
    this.b.a(paramLong, new p(this));
  }
  
  public final void a(View paramView, com.linksure.apservice.b.i parami)
  {
    if (parami.g == 1) {
      this.d.a(paramView, parami);
    }
  }
  
  public final void a(com.linksure.apservice.b.i parami)
  {
    if (parami.h) {
      if (parami.g == 2) {
        this.d.a((com.linksure.apservice.b.f)parami);
      }
    }
    for (;;)
    {
      return;
      if (parami.g == 2)
      {
        this.d.a((com.linksure.apservice.b.f)parami);
      }
      else if (parami.g == 5)
      {
        this.d.b(((com.linksure.apservice.b.g)parami).c);
        com.linksure.apservice.utils.b.a("saidaccli", this.f, ((com.linksure.apservice.b.g)parami).d);
      }
      else if (parami.g == 14)
      {
        parami = ((e)parami).b;
        this.d.b(parami[0].a);
      }
      else if (parami.g == 7)
      {
        e locale = (e)parami;
        parami = locale.b;
        this.d.b(parami[locale.a].a);
      }
      else if (parami.g == 8)
      {
        parami = (j)parami;
        if ((parami.d != null) && (parami.d.length() > 0)) {
          this.d.b(parami.d);
        }
      }
    }
  }
  
  public final void a(String paramString)
  {
    if ("message".equals(paramString))
    {
      paramString = this.b.a();
      this.e.a(paramString);
      if (paramString != null) {
        this.d.a(paramString, this.e.a, this.e.b);
      }
    }
    for (;;)
    {
      return;
      if ("account".equals(paramString)) {
        this.d.a(this.a.a());
      }
    }
  }
  
  public final void a_(com.linksure.apservice.b.a parama)
  {
    Log.i("king", "---------->MessageListPresenter");
    this.f = parama.k;
    this.g = parama.e;
    this.b.a(parama.k, 0L, new m(this));
    this.a.c(parama.k, new n(this));
  }
  
  public final void b()
  {
    super.b();
    com.linksure.apservice.utils.i.a(this.d).b();
    ((com.linksure.apservice.a.e.a)this.b).b(this);
    ((com.linksure.apservice.a.e.a)this.a).b(this);
  }
  
  public final void b(long paramLong)
  {
    this.b.a(paramLong);
  }
  
  public final void b(com.linksure.apservice.b.i parami)
  {
    this.d.a(parami.e);
  }
  
  public final void c()
  {
    this.b.b();
    this.e = new a();
  }
  
  public final void d()
  {
    if ((this.h == 2) || (this.h == 1)) {}
    for (;;)
    {
      return;
      if (this.i != 0L)
      {
        this.h = 1;
        this.b.a(this.f, this.i, new o(this));
      }
    }
  }
  
  public final void g()
  {
    this.d.r_();
  }
  
  public final void s_()
  {
    com.linksure.apservice.b.a locala = this.a.a();
    if (locala.e) {}
    for (;;)
    {
      return;
      f();
      if (!a(locala)) {
        super.e();
      }
    }
  }
  
  static final class a
  {
    public boolean a;
    public int b;
    private int c;
    private int d = 0;
    private com.linksure.apservice.b.i e;
    private com.linksure.apservice.b.i f;
    private boolean g = true;
    
    public final void a()
    {
      if (this.g) {
        this.g = false;
      }
      for (;;)
      {
        return;
        this.a = false;
        this.b = -1;
      }
    }
    
    public final void a(int paramInt)
    {
      this.c = paramInt;
    }
    
    public final void a(List<com.linksure.apservice.b.i> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty())) {
        return;
      }
      int j = paramList.size();
      com.linksure.apservice.b.i locali1 = (com.linksure.apservice.b.i)paramList.get(0);
      com.linksure.apservice.b.i locali2 = (com.linksure.apservice.b.i)paramList.get(paramList.size() - 1);
      int i;
      if ((this.d == 0) && (j > 0))
      {
        i = 1;
        label65:
        if (i == 0) {
          break label109;
        }
        this.a = false;
        this.b = paramList.size();
      }
      for (;;)
      {
        this.d = j;
        this.e = locali1;
        this.f = locali2;
        break;
        i = 0;
        break label65;
        label109:
        if ((this.e != null) && (this.e.e != locali1.e)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label166;
          }
          this.a = false;
          this.b = (paramList.size() - this.d);
          break;
        }
        label166:
        if ((this.f != null) && (this.f.e != locali2.e))
        {
          i = 1;
          label191:
          if (i == 0) {
            break label270;
          }
          if (locali2.h) {
            break label232;
          }
        }
        label232:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label237;
          }
          this.a = true;
          this.b = paramList.size();
          break;
          i = 0;
          break label191;
        }
        label237:
        if (paramList.size() - this.c <= 4)
        {
          this.a = true;
          this.b = paramList.size();
        }
        else
        {
          label270:
          this.a = false;
          this.b = -1;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/list/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */