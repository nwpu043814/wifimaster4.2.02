package cm.pass.sdk.net;

import android.content.Context;
import cm.pass.sdk.utils.e;
import cm.pass.sdk.utils.l;
import cm.pass.sdk.utils.t;

public class c
  extends m
{
  private Context o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u = "0";
  
  public c(Context paramContext, String paramString1, String paramString2, cm.pass.sdk.net.a.h paramh)
  {
    super(paramContext, paramh);
    this.o = paramContext;
    this.p = paramString1;
    this.q = l.a(this.o).d();
    this.r = "0";
    this.s = paramString2;
    this.t = t.b();
    b();
  }
  
  protected void a()
  {
    this.h = e.b;
  }
  
  protected void b()
  {
    try
    {
      this.f.append("ver=");
      this.f.append(this.c);
      this.f.append("&sourceid=");
      this.f.append(this.d);
      this.f.append("&appid=");
      this.f.append(this.p);
      this.f.append("&clientver=");
      this.f.append(this.q);
      this.f.append("&sdkver=");
      this.f.append(this.b);
      this.f.append("&clienttype=");
      this.f.append(this.r);
      this.f.append("&expandparams=");
      this.f.append(this.s);
      this.f.append("&timestamp=");
      this.f.append(this.t);
      this.f.append("&code=");
      StringBuffer localStringBuffer = this.f;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuffer.append(cm.pass.sdk.utils.h.b(this.c + this.d + this.p + this.q + this.b + this.u + this.s + this.t + "BPeaij8db9p6uuXc"));
      this.h = this.f.toString();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */