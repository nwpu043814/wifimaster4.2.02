package cm.pass.sdk.auth;

import cm.pass.sdk.interfaces.i;
import cm.pass.sdk.utils.j;
import cm.pass.sdk.utils.o;

class AuthnHelper$1
  implements i
{
  AuthnHelper$1(AuthnHelper paramAuthnHelper) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt1, int paramInt2, int paramInt3, String paramString9, String paramString10)
  {
    long l = System.currentTimeMillis();
    if (paramBoolean)
    {
      j.c("AuthnHelper", "移动超时时间:" + paramInt1 + " 联通超时时间:" + paramInt2 + " 电信超时时间" + paramInt3);
      o.a().a(AuthnHelper.a(), "LOGINDELAY_CM_TIME", paramInt1);
      o.a().a(AuthnHelper.a(), "LOGINDELAY_CU_TIME", paramInt2);
      o.a().a(AuthnHelper.a(), "LOGINDELAY_CT_TIME", paramInt3);
      o.a().a(AuthnHelper.a(), "KEY_CONFIG_INFO_TIME", l);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/auth/AuthnHelper$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */