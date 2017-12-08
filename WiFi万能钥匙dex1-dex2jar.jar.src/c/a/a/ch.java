package c.a.a;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.List;

public final class ch
  implements bw
{
  private static String h = "localhost";
  private static int i = 0;
  private InetSocketAddress a;
  private InetSocketAddress b;
  private boolean c;
  private boolean d;
  private bi e;
  private cn f;
  private long g = 10000L;
  
  public ch()
  {
    this(null);
  }
  
  public ch(String paramString)
  {
    String str = paramString;
    if (paramString == null)
    {
      paramString = bx.e().b();
      str = paramString;
      if (paramString == null) {
        str = h;
      }
    }
    if (str.equals("0")) {}
    for (paramString = InetAddress.getLocalHost();; paramString = InetAddress.getByName(str))
    {
      this.a = new InetSocketAddress(paramString, 53);
      return;
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
      if (bk.a("verbose")) {
        paramArrayOfByte.printStackTrace();
      }
      Object localObject = paramArrayOfByte;
      if (!(paramArrayOfByte instanceof db)) {
        localObject = new db("Error parsing message");
      }
      throw ((db)localObject);
    }
  }
  
  private au b(au paramau)
  {
    localObject1 = de.a(paramau.b().f(), this.a, this.f);
    ((de)localObject1).a((int)(this.g / 1000L));
    ((de)localObject1).a(this.b);
    try
    {
      Object localObject2 = new c/a/a/de$a;
      ((de.a)localObject2).<init>((byte)0);
      ((de)localObject1).a((de.c)localObject2);
      localObject2 = ((de)localObject1).a();
      localObject1 = new au(paramau.a().b());
      ((au)localObject1).a().a(5);
      ((au)localObject1).a().a(0);
      ((au)localObject1).a(paramau.b(), 0);
      paramau = ((List)localObject2).iterator();
      while (paramau.hasNext()) {
        ((au)localObject1).a((bt)paramau.next(), 1);
      }
      return (au)localObject1;
    }
    catch (dd paramau)
    {
      throw new db(paramau.getMessage());
    }
  }
  
  public final au a(au paramau)
  {
    if (bk.a("verbose")) {
      System.err.println("Sending to " + this.a.getAddress().getHostAddress() + ":" + this.a.getPort());
    }
    Object localObject;
    if (paramau.a().e() == 0)
    {
      localObject = paramau.b();
      if ((localObject != null) && (((bt)localObject).g() == 252))
      {
        paramau = b(paramau);
        return paramau;
      }
    }
    au localau = (au)paramau.clone();
    byte[] arrayOfByte;
    int k;
    label155:
    long l;
    int j;
    if ((this.e == null) || (localau.e() != null))
    {
      if (this.f != null) {
        this.f.a(localau);
      }
      arrayOfByte = localau.h();
      paramau = localau.e();
      if (paramau != null) {
        break label237;
      }
      k = 512;
      l = System.currentTimeMillis();
      l = this.g + l;
      j = 0;
      label171:
      if ((!this.c) && (arrayOfByte.length <= k)) {
        break label466;
      }
      j = 1;
    }
    label237:
    label265:
    label463:
    label466:
    for (;;)
    {
      if (j != 0) {}
      for (paramau = ck.a(this.b, this.a, arrayOfByte, l);; paramau = cw.a(this.b, this.a, arrayOfByte, k, l))
      {
        if (paramau.length >= 12) {
          break label265;
        }
        throw new db("invalid DNS header - too short");
        localau.a(this.e, 3);
        break;
        k = paramau.d();
        break label155;
      }
      int n = ((paramau[0] & 0xFF) << 8) + (paramau[1] & 0xFF);
      int m = localau.a().b();
      if (n != m)
      {
        paramau = "invalid message id: expected " + m + "; got id " + n;
        if (j != 0) {
          throw new db(paramau);
        }
        if (!bk.a("verbose")) {
          break label463;
        }
        System.err.println(paramau);
        break label171;
      }
      localObject = a(paramau);
      cn localcn = this.f;
      if (localcn != null)
      {
        m = localcn.a((au)localObject, paramau, localau.c());
        if (bk.a("verbose")) {
          System.err.println("TSIG verify: " + bs.b(m));
        }
      }
      if ((j == 0) && (!this.d) && (((au)localObject).a().b(6)))
      {
        j = 1;
        break label171;
      }
      paramau = (au)localObject;
      break;
      break label171;
    }
  }
  
  public final Object a(au paramau, by paramby)
  {
    for (;;)
    {
      try
      {
        Integer localInteger = new java/lang/Integer;
        int j = i;
        i = j + 1;
        localInteger.<init>(j);
        localObject = paramau.b();
        if (localObject != null)
        {
          localObject = ((bt)localObject).f().toString();
          localObject = getClass() + ": " + (String)localObject;
          paramau = new bv(this, paramau, localInteger, paramby);
          paramau.setName((String)localObject);
          paramau.setDaemon(true);
          paramau.start();
          return localInteger;
        }
      }
      finally {}
      Object localObject = "(none)";
    }
  }
  
  public final void a()
  {
    a(5, 0);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.g = (paramInt1 * 1000L + paramInt2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */