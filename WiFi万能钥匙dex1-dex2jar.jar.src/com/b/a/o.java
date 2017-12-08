package com.b.a;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class o
{
  private static final ao a = new ao();
  private static final p b = new p();
  private static final j c = new j();
  private static final k d = new k();
  private final Set<i> e = new HashSet();
  private final Set<i> f = new HashSet();
  private double g;
  private as h;
  private boolean i;
  private boolean j;
  private am k;
  private m l;
  private final ay<q<?>> m;
  private final ay<ak<?>> n;
  private final ay<x<?>> o;
  private boolean p;
  private String q;
  private int r;
  private int s;
  private boolean t;
  private boolean u;
  private boolean v;
  private boolean w;
  
  public o()
  {
    this.f.add(n.a);
    this.f.add(n.b);
    this.e.add(n.a);
    this.e.add(n.b);
    this.g = -1.0D;
    this.i = true;
    this.v = false;
    this.u = true;
    this.h = n.c;
    this.j = false;
    this.k = am.a;
    this.l = n.d;
    this.m = new ay();
    this.n = new ay();
    this.o = new ay();
    this.p = false;
    this.r = 2;
    this.s = 2;
    this.t = false;
    this.w = false;
  }
  
  private static <T> void a(Class<?> paramClass, ay<T> paramay, T paramT)
  {
    if (!paramay.b(paramClass)) {
      paramay.a(paramClass, paramT);
    }
  }
  
  public final n a()
  {
    LinkedList localLinkedList1 = new LinkedList(this.f);
    LinkedList localLinkedList2 = new LinkedList(this.e);
    localLinkedList1.add(this.h);
    localLinkedList2.add(this.h);
    if (!this.i)
    {
      localLinkedList1.add(b);
      localLinkedList2.add(b);
    }
    if (this.g != -1.0D)
    {
      localObject1 = new bk(this.g);
      localLinkedList1.add(localObject1);
      localLinkedList2.add(localObject1);
    }
    if (this.j)
    {
      localLinkedList1.add(c);
      localLinkedList2.add(d);
    }
    ay localay2 = f.a.b();
    localay2.b(this.n.b());
    ay localay1 = f.b.b();
    localay1.b(this.o.b());
    Object localObject1 = this.q;
    int i1 = this.r;
    int i2 = this.s;
    Object localObject2 = null;
    if ((localObject1 != null) && (!"".equals(((String)localObject1).trim()))) {
      localObject1 = new f.h((String)localObject1);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        a(java.util.Date.class, localay2, localObject1);
        a(java.util.Date.class, localay1, localObject1);
        a(Timestamp.class, localay2, localObject1);
        a(Timestamp.class, localay1, localObject1);
        a(java.sql.Date.class, localay2, localObject1);
        a(java.sql.Date.class, localay1, localObject1);
      }
      localay2.a(f.a(this.t, this.k));
      localay1.a(f.c());
      localObject1 = this.m.b();
      ((ay)localObject1).a(f.d());
      localay2.a();
      localay1.a();
      this.m.a();
      localObject1 = new aq((ay)localObject1);
      return new n(new g(localLinkedList1), new g(localLinkedList2), this.l, (aq)localObject1, this.p, localay2, localay1, this.w, this.u, this.v);
      localObject1 = localObject2;
      if (i1 != 2)
      {
        localObject1 = localObject2;
        if (i2 != 2) {
          localObject1 = new f.h(i1, i2);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */