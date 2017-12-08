package cm.pass.sdk.utils;

import android.content.Context;
import cm.pass.sdk.interfaces.c;
import cm.pass.sdk.interfaces.f;
import java.lang.ref.WeakReference;

class RequestBusiness$7
  implements f
{
  RequestBusiness$7(RequestBusiness paramRequestBusiness, String paramString1, String paramString2, int paramInt, c paramc) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    if (paramBoolean) {
      new d().a((Context)RequestBusiness.access$000(this.e).get(), "000", paramString8, "3", this.a, this.b, "http://dev.10086.cn", this.c, this.d);
    }
    for (;;)
    {
      return;
      this.d.a(paramBoolean, paramString1, "登录失败", "", "", "", "", "", "", "", "", paramString13, "4");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/RequestBusiness$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */