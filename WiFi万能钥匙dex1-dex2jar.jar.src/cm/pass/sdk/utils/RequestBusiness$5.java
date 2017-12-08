package cm.pass.sdk.utils;

import android.content.Context;
import cm.pass.sdk.b.b;
import cm.pass.sdk.interfaces.c;
import cm.pass.sdk.interfaces.f;
import java.lang.ref.WeakReference;

class RequestBusiness$5
  implements f
{
  RequestBusiness$5(RequestBusiness paramRequestBusiness, String paramString1, String paramString2, int paramInt, c paramc1, String paramString3, c paramc2, String paramString4) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    if (RequestBusiness.access$000(this.h).get() != null)
    {
      if (!paramBoolean) {
        break label65;
      }
      new d().a((Context)RequestBusiness.access$000(this.h).get(), "000", paramString8, "3", this.a, this.b, "http://dev.10086.cn", this.c, this.d);
    }
    for (;;)
    {
      return;
      label65:
      if (t.f((Context)RequestBusiness.access$000(this.h).get())) {
        try
        {
          Thread.sleep(500L);
          this.h.implicitSMSLogin(this.e, this.a, this.b, this.c, this.f);
          b.a((Context)RequestBusiness.access$000(this.h).get(), this.e, "2", t.a("3"), "", this.a, this.g, paramString5, paramString6, paramString13, paramString1, paramString2);
        }
        catch (Exception paramString3)
        {
          for (;;)
          {
            paramString3.printStackTrace();
          }
        }
      } else {
        this.d.a(paramBoolean, paramString1, "登录失败", "", "", "", "", "", "", "", "", "", "3");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/RequestBusiness$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */