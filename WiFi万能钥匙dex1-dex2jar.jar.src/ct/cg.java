package ct;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.tencentmap.lbssdk.service.e;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

final class cg
{
  final LinkedBlockingQueue<a> a;
  final bi b;
  long c;
  long d;
  long e;
  long f;
  volatile boolean g;
  final cf h;
  
  cg(bi parambi)
  {
    this.b = parambi;
    this.a = new LinkedBlockingQueue(3);
    this.h = parambi.g();
  }
  
  final void a(a parama)
  {
    Object localObject1 = null;
    Object localObject3;
    Object localObject2;
    if (a.c(parama) == 1)
    {
      localObject3 = (cm)parama.a;
      if ((((cm)localObject3).d()) && ((((cm)localObject3).e()) || (((cm)localObject3).f())))
      {
        localObject2 = this.b.a;
        parama = ((cm)localObject3).a();
        if (parama == null) {
          break label215;
        }
      }
    }
    label215:
    for (parama = parama.a;; parama = null)
    {
      Object localObject4 = ((cm)localObject3).c();
      if (localObject4 != null) {
        localObject1 = ((co)localObject4).a();
      }
      localObject4 = ((cm)localObject3).b();
      localObject3 = bi.a((Context)localObject2).h();
      localObject2 = ((bj)localObject3).a();
      parama = b.a.a(parama, ",");
      localObject1 = b.a.a((List)localObject1, ",", ";");
      String str = b.a.a((ck)localObject4, ",", ";");
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(((bj)localObject3).e()).append("|");
      ((StringBuilder)localObject4).append((String)localObject2).append("|").append(parama).append("|").append((String)localObject1).append("|").append(str).append("\n");
      parama = ((StringBuilder)localObject4).toString();
      this.h.b(parama);
      return;
    }
  }
  
  public final void a(String paramString, cm paramcm, int paramInt)
  {
    boolean bool = false;
    int i = this.a.size();
    SystemClock.elapsedRealtime();
    b.a.a("TxRequestSender", "postLocationRequest: size=" + i);
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = b.a.b(paramString.getBytes("GBK"));
        if ((arrayOfByte == null) || (e.o(arrayOfByte) < 0))
        {
          str = bw.a(paramInt, 0);
          a locala = new ct/cg$a;
          locala.<init>(arrayOfByte, str, paramcm);
          locala.b = paramString;
          if (a.a(locala) != null) {
            bool = this.a.offer(locala);
          }
          if (!bool) {
            b.a.b("TxRequestSender", "postLocationRequest: failed to add request");
          }
          return;
        }
      }
      catch (UnsupportedEncodingException paramString)
      {
        String str;
        b.a.a("TxRequestSender", "", paramString);
        continue;
      }
      str = bw.a(paramInt, 1);
    }
  }
  
  static final class a
  {
    public static final a d = new a();
    final Object a;
    public String b;
    public long c;
    private final int e;
    private final byte[] f;
    private final String g;
    private int h = 1;
    
    private a()
    {
      this.e = 0;
      this.f = null;
      this.g = null;
      this.a = null;
    }
    
    a(byte[] paramArrayOfByte, String paramString, Object paramObject)
    {
      this.e = 1;
      this.f = paramArrayOfByte;
      this.g = paramString;
      this.a = paramObject;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */