package cm.pass.sdk.utils;

import android.content.Context;
import cm.pass.sdk.account.UserInfo;
import cm.pass.sdk.b.b;
import cm.pass.sdk.interfaces.a;
import cm.pass.sdk.interfaces.c;
import java.lang.ref.WeakReference;

class RequestBusiness$2
  implements a
{
  RequestBusiness$2(RequestBusiness paramRequestBusiness, c paramc, UserInfo paramUserInfo, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.a.a(paramBoolean, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, this.b.getPassid(), paramString7, paramString8, "8", "", "");
    j.a("BusinessInternal", "getAccessTokenByUserInfo bindCallback");
    b.a((Context)RequestBusiness.access$000(this.g).get(), this.c, this.d, "5", this.b.getPassid(), this.e, this.f, paramString7, paramString8, "1", paramString1, paramString2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/RequestBusiness$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */