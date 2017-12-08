package c.a.a;

import java.io.IOException;
import java.io.PrintStream;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;

public final class de
{
  private bg a;
  private int b;
  private int c;
  private long d;
  private boolean e;
  private c f;
  private SocketAddress g;
  private SocketAddress h;
  private ck i;
  private cn j;
  private cn.a k;
  private long l = 900000L;
  private int m;
  private long n;
  private long o;
  private bt p;
  private int q;
  
  private de() {}
  
  private de(bg parambg, SocketAddress paramSocketAddress, cn paramcn)
  {
    this.h = paramSocketAddress;
    this.j = paramcn;
    if (parambg.a()) {
      this.a = parambg;
    }
    for (;;)
    {
      this.b = 252;
      this.c = 1;
      this.d = 0L;
      this.e = false;
      this.m = 0;
      return;
      try
      {
        this.a = bg.a(parambg, bg.a);
      }
      catch (bh parambg)
      {
        throw new IllegalArgumentException("ZoneTransferIn: name too long");
      }
    }
  }
  
  private static au a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new au(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      if ((paramArrayOfByte instanceof db)) {
        throw ((db)paramArrayOfByte);
      }
      throw new db("Error parsing message");
    }
  }
  
  public static de a(bg parambg, SocketAddress paramSocketAddress, cn paramcn)
  {
    return new de(parambg, paramSocketAddress, paramcn);
  }
  
  private void a(String paramString)
  {
    if (bk.a("verbose")) {
      System.out.println(this.a + ": " + paramString);
    }
  }
  
  private void b()
  {
    if (!this.e) {
      b("server doesn't support IXFR");
    }
    a("falling back to AXFR");
    this.b = 252;
    this.m = 0;
  }
  
  private static void b(String paramString)
  {
    throw new dd(paramString);
  }
  
  private void c()
  {
    try
    {
      if (this.i != null) {
        this.i.a();
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public final List a()
  {
    if ((this.f instanceof a)) {
      return a.a((a)this.f);
    }
    throw new IllegalArgumentException("ZoneTransferIn used callback interface");
  }
  
  public final void a(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("timeout cannot be negative");
    }
    this.l = (1000L * paramInt);
  }
  
  public final void a(c paramc)
  {
    this.f = paramc;
    for (;;)
    {
      long l2;
      long l1;
      Object localObject;
      int i1;
      try
      {
        l2 = System.currentTimeMillis();
        l1 = this.l;
        paramc = new c/a/a/ck;
        paramc.<init>(l2 + l1);
        this.i = paramc;
        if (this.g != null) {
          this.i.a(this.g);
        }
        this.i.b(this.h);
        localObject = bt.a(this.a, this.b, this.c);
        paramc = new c/a/a/au;
        paramc.<init>();
        paramc.a().d();
        paramc.a((bt)localObject, 0);
        if (this.b == 251)
        {
          localObject = new c/a/a/cb;
          ((cb)localObject).<init>(this.a, this.c, bg.a, bg.a, this.d);
          paramc.a((bt)localObject, 2);
        }
        if (this.j != null)
        {
          this.j.a(paramc);
          localObject = new c/a/a/cn$a;
          ((cn.a)localObject).<init>(this.j, paramc.c());
          this.k = ((cn.a)localObject);
        }
        paramc = paramc.h();
        this.i.a(paramc);
        if (this.m == 7) {
          break;
        }
        localObject = this.i.b();
        paramc = a((byte[])localObject);
        if ((paramc.a().c() == 0) && (this.k != null))
        {
          paramc.c();
          if (this.k.a(paramc, (byte[])localObject) != 0) {
            b("TSIG failure");
          }
        }
        localObject = paramc.a(1);
        if (this.m != 0) {
          break label373;
        }
        i1 = paramc.f();
        if (i1 != 0)
        {
          if ((this.b == 251) && (i1 == 4))
          {
            b();
            continue;
          }
          b(bs.a(i1));
        }
      }
      finally
      {
        c();
      }
      bt localbt = paramc.b();
      if ((localbt != null) && (localbt.g() != this.b)) {
        b("invalid question section");
      }
      if ((localObject.length == 0) && (this.b == 251))
      {
        b();
      }
      else
      {
        label373:
        i1 = 0;
        if (i1 < localObject.length)
        {
          localbt = localObject[i1];
          label388:
          int i2 = localbt.g();
          switch (this.m)
          {
          default: 
            b("invalid state");
          }
          for (;;)
          {
            i1++;
            break;
            if (i2 != 6) {
              b("missing initial SOA");
            }
            this.p = localbt;
            this.n = ((cb)localbt).d();
            if (this.b == 251)
            {
              l2 = this.n;
              l1 = this.d;
              if ((l2 < 0L) || (l2 > 4294967295L))
              {
                paramc = new java/lang/IllegalArgumentException;
                localObject = new java/lang/StringBuilder;
                ((StringBuilder)localObject).<init>();
                paramc.<init>(l2 + " out of range");
                throw paramc;
              }
              if ((l1 < 0L) || (l1 > 4294967295L))
              {
                localObject = new java/lang/IllegalArgumentException;
                paramc = new java/lang/StringBuilder;
                paramc.<init>();
                ((IllegalArgumentException)localObject).<init>(l1 + " out of range");
                throw ((Throwable)localObject);
              }
              l2 -= l1;
              if (l2 >= 4294967295L) {
                l1 = l2 - 4294967296L;
              }
              for (;;)
              {
                if ((int)l1 > 0) {
                  break label680;
                }
                a("up to date");
                this.m = 7;
                break;
                l1 = l2;
                if (l2 < -4294967295L) {
                  l1 = l2 + 4294967296L;
                }
              }
            }
            label680:
            this.m = 1;
            continue;
            if ((this.b == 251) && (i2 == 6) && (((cb)localbt).d() == this.d))
            {
              this.q = 251;
              this.f.b();
              a("got incremental response");
              this.m = 2;
              break label388;
            }
            this.q = 252;
            this.f.a();
            this.f.c(this.p);
            a("got nonincremental response");
            this.m = 6;
            break label388;
            this.f.a(localbt);
            this.m = 3;
            continue;
            if (i2 == 6)
            {
              this.o = ((cb)localbt).d();
              this.m = 4;
              break label388;
            }
            this.f.c(localbt);
            continue;
            this.f.b(localbt);
            this.m = 5;
            continue;
            if (i2 == 6)
            {
              l1 = ((cb)localbt).d();
              if (l1 == this.n)
              {
                this.m = 7;
                continue;
              }
              if (l1 != this.o)
              {
                StringBuilder localStringBuilder = new java/lang/StringBuilder;
                localStringBuilder.<init>("IXFR out of sync: expected serial ");
                b(this.o + " , got " + l1);
              }
            }
            else
            {
              this.f.c(localbt);
              continue;
            }
            this.m = 2;
            break label388;
            if ((i2 != 1) || (localbt.i() == this.c))
            {
              this.f.c(localbt);
              if (i2 == 6)
              {
                this.m = 7;
                continue;
                b("extra data");
              }
            }
          }
        }
        if ((this.m == 7) && (this.k != null) && (!paramc.d())) {
          b("last message must be signed");
        }
      }
    }
    c();
  }
  
  public final void a(SocketAddress paramSocketAddress)
  {
    this.g = paramSocketAddress;
  }
  
  private static final class a
    implements de.c
  {
    private List a;
    private List b;
    
    public final void a()
    {
      this.a = new ArrayList();
    }
    
    public final void a(bt parambt)
    {
      de.b localb = new de.b((byte)0);
      localb.d.add(parambt);
      localb.a = ((cb)parambt).d();
      this.b.add(localb);
    }
    
    public final void b()
    {
      this.b = new ArrayList();
    }
    
    public final void b(bt parambt)
    {
      de.b localb = (de.b)this.b.get(this.b.size() - 1);
      localb.c.add(parambt);
      localb.b = ((cb)parambt).d();
    }
    
    public final void c(bt parambt)
    {
      Object localObject;
      if (this.b != null)
      {
        localObject = (de.b)this.b.get(this.b.size() - 1);
        if (((de.b)localObject).c.size() > 0) {
          localObject = ((de.b)localObject).c;
        }
      }
      for (;;)
      {
        ((List)localObject).add(parambt);
        return;
        localObject = ((de.b)localObject).d;
        continue;
        localObject = this.a;
      }
    }
  }
  
  public static final class b
  {
    public long a;
    public long b;
    public List c = new ArrayList();
    public List d = new ArrayList();
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void a(bt parambt);
    
    public abstract void b();
    
    public abstract void b(bt parambt);
    
    public abstract void c(bt parambt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */