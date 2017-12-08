package c.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public final class w
  implements bw
{
  private List a = new ArrayList();
  private boolean b = false;
  private int c = 0;
  private int d = 3;
  
  public w()
  {
    String[] arrayOfString = bx.e().a();
    if (arrayOfString != null) {
      while (i < arrayOfString.length)
      {
        ch localch = new ch(arrayOfString[i]);
        localch.a();
        this.a.add(localch);
        i++;
      }
    }
    this.a.add(new ch());
  }
  
  public final au a(au paramau)
  {
    return new a(this, paramau).a();
  }
  
  public final Object a(au paramau, by paramby)
  {
    paramau = new a(this, paramau);
    paramau.j = paramby;
    paramau.a(0);
    return paramau;
  }
  
  public final void a()
  {
    a(5, 0);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    for (int i = 0; i < this.a.size(); i++) {
      ((bw)this.a.get(i)).a(paramInt1, paramInt2);
    }
  }
  
  private static final class a
    implements by
  {
    bw[] a;
    int[] b;
    Object[] c;
    int d;
    int e;
    boolean f;
    au g;
    au h;
    Throwable i;
    by j;
    
    public a(w paramw, au paramau)
    {
      Object localObject = w.a(paramw);
      this.a = ((bw[])((List)localObject).toArray(new bw[((List)localObject).size()]));
      if (w.b(paramw))
      {
        int n = this.a.length;
        int m = w.c(paramw) % n;
        if (w.d(paramw) > n) {
          w.a(paramw, w.d(paramw) % n);
        }
        if (m > 0)
        {
          localObject = new bw[n];
          for (int k = 0; k < n; k++) {
            localObject[k] = this.a[((k + m) % n)];
          }
          this.a = ((bw[])localObject);
        }
      }
      this.b = new int[this.a.length];
      this.c = new Object[this.a.length];
      this.d = w.e(paramw);
      this.g = paramau;
    }
    
    public final au a()
    {
      try
      {
        localObject1 = this.b;
        localObject1[0] += 1;
        this.e += 1;
        Object[] arrayOfObject = this.c;
        localObject1 = new java/lang/Object;
        localObject1.<init>();
        arrayOfObject[0] = localObject1;
        localObject1 = this.a[0].a(this.g);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          a(this.c[0], localException);
          try
          {
            for (;;)
            {
              boolean bool = this.f;
              if (bool) {
                break;
              }
              try
              {
                wait();
              }
              catch (InterruptedException localInterruptedException) {}
            }
            if (this.h != null) {
              au localau = this.h;
            }
          }
          finally {}
        }
        if (!(this.i instanceof IOException)) {
          break label132;
        }
        throw ((IOException)this.i);
        label132:
        if (!(this.i instanceof RuntimeException)) {
          break label150;
        }
        throw ((RuntimeException)this.i);
        label150:
        if (!(this.i instanceof Error)) {
          break label168;
        }
        throw ((Error)this.i);
        label168:
        throw new IllegalStateException("ExtendedResolver failure");
      }
      return (au)localObject1;
    }
    
    public final void a(int paramInt)
    {
      int[] arrayOfInt = this.b;
      arrayOfInt[paramInt] += 1;
      this.e += 1;
      try
      {
        this.c[paramInt] = this.a[paramInt].a(this.g, this);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          try
          {
            this.i = localThrowable;
            this.f = true;
            if (this.j == null)
            {
              notifyAll();
              continue;
            }
          }
          finally {}
        }
      }
    }
    
    public final void a(au paramau)
    {
      if (bk.a("verbose")) {
        System.err.println("ExtendedResolver: received message");
      }
      for (;;)
      {
        try
        {
          if (this.f) {
            return;
          }
          this.h = paramau;
          this.f = true;
          if (this.j == null)
          {
            notifyAll();
            continue;
          }
        }
        finally {}
        this.j.a(this.h);
      }
    }
    
    public final void a(Object paramObject, Exception paramException)
    {
      int m = 1;
      if (bk.a("verbose")) {
        System.err.println("ExtendedResolver: got " + paramException);
      }
      int k;
      try
      {
        this.e -= 1;
        if (this.f) {}
        for (;;)
        {
          return;
          for (k = 0; (k < this.c.length) && (this.c[k] != paramObject); k++) {}
          if (k != this.c.length) {
            break;
          }
        }
        if (this.b[k] != 1) {
          break label317;
        }
      }
      finally {}
      if (k < this.a.length - 1) {}
      for (;;)
      {
        if ((paramException instanceof InterruptedIOException))
        {
          if (this.b[k] < this.d) {
            a(k);
          }
          if (this.i != null) {}
        }
        label154:
        for (this.i = paramException;; this.i = paramException) {
          do
          {
            if (!this.f) {
              break label203;
            }
            break;
            if (!(paramException instanceof SocketException)) {
              break label154;
            }
          } while ((this.i != null) && (!(this.i instanceof InterruptedIOException)));
        }
        label203:
        if (m != 0) {
          a(k + 1);
        }
        if (this.f) {
          break;
        }
        if (this.e == 0)
        {
          this.f = true;
          if (this.j == null)
          {
            notifyAll();
            break;
          }
        }
        if (!this.f) {
          break;
        }
        if (!(this.i instanceof Exception)) {
          this.i = new RuntimeException(this.i.getMessage());
        }
        this.j.a(this, (Exception)this.i);
        break;
        label317:
        m = 0;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */