package cm.pass.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import cm.pass.sdk.b.b;
import cm.pass.sdk.interfaces.c;
import java.lang.ref.WeakReference;

class RequestBusiness$6
  implements c
{
  RequestBusiness$6(RequestBusiness paramRequestBusiness, String paramString1, c paramc, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    if (paramBoolean) {
      RequestBusiness.getInstance((Context)RequestBusiness.access$000(this.e).get()).getKsByAccessToken(paramString7, "4", paramString4, paramString3, this.a, paramString5, null);
    }
    this.b.a(paramBoolean, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, "4");
    j.c("BusinessInternal", "successAuthType value is" + paramString10);
    paramString5 = (Context)RequestBusiness.access$000(this.e).get();
    paramString4 = this.c;
    if (TextUtils.isEmpty(paramString10)) {}
    for (paramString3 = t.a("4");; paramString3 = "2")
    {
      b.a(paramString5, paramString4, "2", paramString3, paramString7, this.a, this.d, paramString8, paramString9, "1", paramString1, paramString2);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/RequestBusiness$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */