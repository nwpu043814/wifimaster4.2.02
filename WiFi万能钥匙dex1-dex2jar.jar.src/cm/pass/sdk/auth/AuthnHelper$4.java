package cm.pass.sdk.auth;

import cm.pass.sdk.interfaces.c;
import cm.pass.sdk.utils.RequestBusiness;
import cm.pass.sdk.utils.t;

class AuthnHelper$4
  implements c
{
  AuthnHelper$4(AuthnHelper paramAuthnHelper, c paramc, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    this.g.a = paramBoolean;
    if (paramBoolean) {
      this.a.a(paramBoolean, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, "");
    }
    for (;;)
    {
      return;
      if (paramString1.startsWith("70")) {
        this.a.a(false, paramString1, "登录失败", "", "", "", "", "", "", "", "", "", this.b);
      } else if (this.b.equals("3")) {
        RequestBusiness.getInstance(AuthnHelper.a()).implicitWapLogin(this.c, this.d, this.e, this.f, true, this.a);
      } else if ((this.b.equals("4")) && (t.f(AuthnHelper.a()))) {
        RequestBusiness.getInstance(AuthnHelper.a()).implicitSMSLogin(this.c, this.d, this.e, this.f, this.a);
      } else {
        this.a.a(false, "102122", "未检测到SIM卡，请使用短信验证码登录", "", "", "", "", "", "", "", "", "", this.b);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/auth/AuthnHelper$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */