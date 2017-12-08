package c.a.a;

import c.a.a.a.a;
import java.io.PrintStream;
import java.util.Date;

public final class cn
{
  public static final bg a;
  public static final bg b;
  public static final bg c = bg.b("hmac-sha1.");
  public static final bg d = bg.b("hmac-sha224.");
  public static final bg e = bg.b("hmac-sha256.");
  public static final bg f = bg.b("hmac-sha384.");
  public static final bg g = bg.b("hmac-sha512.");
  private bg h;
  private bg i;
  private String j;
  private int k;
  private byte[] l;
  
  static
  {
    bg localbg = bg.b("HMAC-MD5.SIG-ALG.REG.INT.");
    a = localbg;
    b = localbg;
  }
  
  public final int a()
  {
    return this.h.b() + 10 + this.i.b() + 8 + 18 + 4 + 8;
  }
  
  public final int a(au paramau, byte[] paramArrayOfByte, co paramco)
  {
    paramau.b = 4;
    co localco = paramau.c();
    a locala = new a(this.j, this.k, this.l);
    int m;
    if (localco == null) {
      m = 1;
    }
    for (;;)
    {
      return m;
      if ((!localco.f().equals(this.h)) || (!localco.d().equals(this.i)))
      {
        if (bk.a("verbose")) {
          System.err.println("BADKEY failure");
        }
        m = 17;
      }
      else
      {
        long l2 = System.currentTimeMillis();
        long l3 = localco.e().getTime();
        long l1 = localco.l();
        if (Math.abs(l2 - l3) > 1000L * l1)
        {
          if (bk.a("verbose")) {
            System.err.println("BADTIME failure");
          }
          m = 18;
        }
        else
        {
          if ((paramco != null) && (localco.n() != 17) && (localco.n() != 16))
          {
            s locals = new s((byte)0);
            locals.c(paramco.m().length);
            locala.a(locals.b());
            locala.a(paramco.m());
          }
          paramau.a().f();
          paramco = paramau.a().a();
          paramau.a().c(3);
          locala.a(paramco);
          int n = paramau.a;
          m = paramco.length;
          locala.a(paramArrayOfByte, paramco.length, n - m);
          paramArrayOfByte = new s((byte)0);
          localco.f().a(paramArrayOfByte);
          paramArrayOfByte.c(localco.i);
          paramArrayOfByte.a(localco.j);
          localco.d().a(paramArrayOfByte);
          l1 = localco.e().getTime() / 1000L;
          paramArrayOfByte.c((int)(l1 >> 32));
          paramArrayOfByte.a(l1 & 0xFFFFFFFF);
          paramArrayOfByte.c(localco.l());
          paramArrayOfByte.c(localco.n());
          if (localco.o() != null)
          {
            paramArrayOfByte.c(localco.o().length);
            paramArrayOfByte.a(localco.o());
            label399:
            locala.a(paramArrayOfByte.b());
            paramArrayOfByte = localco.m();
            n = locala.c();
            if (!this.j.equals("md5")) {
              break label475;
            }
          }
          label475:
          for (m = 10;; m = n / 2)
          {
            if (paramArrayOfByte.length <= n) {
              break label484;
            }
            if (bk.a("verbose")) {
              System.err.println("BADSIG: signature too long");
            }
            m = 16;
            break;
            paramArrayOfByte.c(0);
            break label399;
          }
          label484:
          if (paramArrayOfByte.length < m)
          {
            if (bk.a("verbose")) {
              System.err.println("BADSIG: signature too short");
            }
            m = 16;
          }
          else if (!locala.a(paramArrayOfByte, true))
          {
            if (bk.a("verbose")) {
              System.err.println("BADSIG: signature verification");
            }
            m = 16;
          }
          else
          {
            paramau.b = 1;
            m = 0;
          }
        }
      }
    }
  }
  
  public final co a(au paramau, byte[] paramArrayOfByte, int paramInt, co paramco)
  {
    Date localDate;
    a locala;
    int m;
    long l1;
    if (paramInt != 18)
    {
      localDate = new Date();
      locala = null;
      if ((paramInt == 0) || (paramInt == 18)) {
        locala = new a(this.j, this.k, this.l);
      }
      int n = bk.b("tsigfudge");
      if (n >= 0)
      {
        m = n;
        if (n <= 32767) {}
      }
      else
      {
        m = 300;
      }
      if (paramco != null)
      {
        s locals = new s((byte)0);
        locals.c(paramco.m().length);
        if (locala != null)
        {
          locala.a(locals.b());
          locala.a(paramco.m());
        }
      }
      if (locala != null) {
        locala.a(paramArrayOfByte);
      }
      paramArrayOfByte = new s((byte)0);
      this.h.a(paramArrayOfByte);
      paramArrayOfByte.c(255);
      paramArrayOfByte.a(0L);
      this.i.a(paramArrayOfByte);
      l1 = localDate.getTime() / 1000L;
      paramArrayOfByte.c((int)(l1 >> 32));
      paramArrayOfByte.a(l1 & 0xFFFFFFFF);
      paramArrayOfByte.c(m);
      paramArrayOfByte.c(paramInt);
      paramArrayOfByte.c(0);
      if (locala != null) {
        locala.a(paramArrayOfByte.b());
      }
      if (locala == null) {
        break label354;
      }
    }
    label354:
    for (paramArrayOfByte = locala.a();; paramArrayOfByte = new byte[0])
    {
      paramco = null;
      if (paramInt == 18)
      {
        paramco = new s((byte)0);
        l1 = new Date().getTime() / 1000L;
        paramco.c((int)(l1 >> 32));
        paramco.a(l1 & 0xFFFFFFFF);
        paramco = paramco.b();
      }
      return new co(this.h, this.i, localDate, m, paramArrayOfByte, paramau.a().b(), paramInt, paramco);
      localDate = paramco.e();
      break;
    }
  }
  
  public final void a(au paramau)
  {
    paramau.a(a(paramau, paramau.g(), 0, null), 3);
    paramau.b = 3;
  }
  
  public static final class a
  {
    private cn a;
    private a b;
    private int c;
    private int d;
    private co e;
    
    public a(cn paramcn, co paramco)
    {
      this.a = paramcn;
      this.b = new a(cn.a(this.a), cn.b(this.a), cn.c(this.a));
      this.c = 0;
      this.e = paramco;
    }
    
    public final int a(au paramau, byte[] paramArrayOfByte)
    {
      co localco = paramau.c();
      this.c += 1;
      int i;
      if (this.c == 1)
      {
        i = this.a.a(paramau, paramArrayOfByte, this.e);
        if (i == 0)
        {
          paramArrayOfByte = localco.m();
          paramau = new s((byte)0);
          paramau.c(paramArrayOfByte.length);
          this.b.a(paramau.b());
          this.b.a(paramArrayOfByte);
        }
        this.e = localco;
      }
      for (;;)
      {
        return i;
        if (localco != null) {
          paramau.a().f();
        }
        byte[] arrayOfByte = paramau.a().a();
        if (localco != null) {
          paramau.a().c(3);
        }
        this.b.a(arrayOfByte);
        if (localco == null) {}
        for (i = paramArrayOfByte.length - arrayOfByte.length;; i = paramau.a - arrayOfByte.length)
        {
          this.b.a(paramArrayOfByte, arrayOfByte.length, i);
          if (localco == null) {
            break label251;
          }
          this.d = this.c;
          this.e = localco;
          if ((localco.f().equals(cn.d(this.a))) && (localco.d().equals(cn.e(this.a)))) {
            break label296;
          }
          if (bk.a("verbose")) {
            System.err.println("BADKEY failure");
          }
          paramau.b = 4;
          i = 17;
          break;
        }
        label251:
        if (this.c - this.d >= 100) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label286;
          }
          paramau.b = 4;
          i = 1;
          break;
        }
        label286:
        paramau.b = 2;
        i = 0;
        continue;
        label296:
        paramArrayOfByte = new s((byte)0);
        long l = localco.e().getTime() / 1000L;
        paramArrayOfByte.c((int)(l >> 32));
        paramArrayOfByte.a(l & 0xFFFFFFFF);
        paramArrayOfByte.c(localco.l());
        this.b.a(paramArrayOfByte.b());
        if (!this.b.a(localco.m(), false))
        {
          if (bk.a("verbose")) {
            System.err.println("BADSIG failure");
          }
          paramau.b = 4;
          i = 16;
        }
        else
        {
          this.b.b();
          paramArrayOfByte = new s((byte)0);
          paramArrayOfByte.c(localco.m().length);
          this.b.a(paramArrayOfByte.b());
          this.b.a(localco.m());
          paramau.b = 1;
          i = 0;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */