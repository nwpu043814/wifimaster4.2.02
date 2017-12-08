package com.lantern.auth.service;

import android.os.Message;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.account.R.string;
import com.lantern.core.c;

final class a
  implements com.bluefay.b.a
{
  a(AuthService paramAuthService) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (1 != paramInt) {
      e.a(this.a.getString(R.string.auth_auto_failed));
    }
    h.a("=================send sendAutoRegFinishMSG " + paramInt + " fc " + AuthService.a(this.a), new Object[0]);
    paramString = AuthService.a(this.a);
    paramObject = Message.obtain();
    ((Message)paramObject).what = 128802;
    ((Message)paramObject).arg1 = paramInt;
    ((Message)paramObject).obj = paramString;
    c.dispatch((Message)paramObject);
    this.a.stopSelf();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/service/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */