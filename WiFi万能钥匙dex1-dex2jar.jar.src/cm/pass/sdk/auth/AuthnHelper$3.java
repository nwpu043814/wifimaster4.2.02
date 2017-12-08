package cm.pass.sdk.auth;

import cm.pass.sdk.interfaces.c;
import cm.pass.sdk.utils.RequestBusiness;

class AuthnHelper$3
  implements c
{
  AuthnHelper$3(AuthnHelper paramAuthnHelper, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12)
  {
    if (!AuthnHelper.a(this.b))
    {
      AuthnHelper.a(this.b, true);
      if (!paramBoolean) {
        break label71;
      }
      paramString2 = "登录成功";
      if (!this.b.a) {
        break label77;
      }
    }
    label71:
    label77:
    for (paramString6 = "-1";; paramString6 = paramString12)
    {
      paramString1 = a.a(paramString1, paramString4, paramString3, paramString5, paramString2, paramString7, paramString6);
      RequestBusiness.getInstance(AuthnHelper.a()).onCallbackTokenListener(paramString1, this.a);
      return;
      paramString2 = "登录失败";
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/auth/AuthnHelper$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */