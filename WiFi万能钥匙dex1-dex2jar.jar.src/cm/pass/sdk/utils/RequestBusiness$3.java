package cm.pass.sdk.utils;

import android.content.Context;
import cm.pass.sdk.account.UserInfo;
import cm.pass.sdk.b.b;
import cm.pass.sdk.interfaces.a;
import cm.pass.sdk.interfaces.c;
import java.lang.ref.WeakReference;

class RequestBusiness$3
  implements cm.pass.sdk.interfaces.d
{
  RequestBusiness$3(RequestBusiness paramRequestBusiness, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, a parama, c paramc, String paramString7, String paramString8, UserInfo paramUserInfo, String paramString9) {}
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, boolean paramBoolean3, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, boolean paramBoolean4)
  {
    if (paramBoolean2)
    {
      paramString1 = t.b(paramString7);
      paramString3 = new d();
      paramString2 = this.a;
      if (RequestBusiness.access$100(this.n)) {
        paramString3.a(paramString8, paramString2, paramString6, paramString1, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
      }
    }
    for (;;)
    {
      return;
      paramString1 = "";
      break;
      this.i.a(paramBoolean1, paramString1, paramString2, paramString3, paramString4, paramString5, paramString9, paramString8, paramString10, paramString11, "8", paramString12, "");
      j.a("BusinessInternal", "getAccessTokenByUserInfo ksCallback");
      b.a((Context)RequestBusiness.access$000(this.n).get(), this.j, this.k, "5", this.l.getPassid(), this.a, this.m, paramString10, paramString11, "1", paramString1, paramString2);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/RequestBusiness$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */