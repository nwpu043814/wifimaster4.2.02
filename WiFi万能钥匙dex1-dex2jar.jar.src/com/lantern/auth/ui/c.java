package com.lantern.auth.ui;

import com.bluefay.b.a;

final class c
  implements a
{
  c(AuthActivity paramAuthActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if ((paramInt == 1) && (paramObject != null))
    {
      paramString = (String)paramObject;
      AuthActivity.f(this.a).a(200, paramString, Boolean.valueOf(true));
    }
    for (;;)
    {
      return;
      AuthActivity.f(this.a).a(1001, paramString, Boolean.valueOf(true));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */