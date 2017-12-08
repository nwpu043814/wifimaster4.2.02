package cm.pass.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import cm.pass.sdk.b.b;
import cm.pass.sdk.interfaces.c;
import java.lang.ref.WeakReference;

class RequestBusiness$4
  implements c
{
  RequestBusiness$4(RequestBusiness paramRequestBusiness, c paramc, String paramString1, String paramString2, String paramString3) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    this.a.a(paramBoolean, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12);
    if ((paramBoolean) && (RequestBusiness.access$000(this.e).get() != null)) {
      RequestBusiness.getInstance((Context)RequestBusiness.access$000(this.e).get()).getKsByAccessToken(paramString7, "3", paramString4, paramString3, this.b, paramString5, null);
    }
    if (RequestBusiness.access$000(this.e).get() != null)
    {
      paramString4 = (Context)RequestBusiness.access$000(this.e).get();
      paramString3 = this.c;
      if (!TextUtils.isEmpty(paramString10)) {
        break label162;
      }
      paramString10 = t.a("3");
    }
    label162:
    for (;;)
    {
      b.a(paramString4, paramString3, "2", paramString10, paramString7, this.b, this.d, paramString8, paramString9, "1", paramString1, paramString2);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/RequestBusiness$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */