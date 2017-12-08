package cm.pass.sdk.auth;

import cm.pass.sdk.interfaces.b;
import java.util.Map;

class AuthnHelper$6
  implements b
{
  AuthnHelper$6(AuthnHelper paramAuthnHelper, TokenListener paramTokenListener) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Map<String, String> paramMap)
  {
    this.a.onGetTokenComplete(a.a(paramString1, paramString2, paramMap));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/auth/AuthnHelper$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */