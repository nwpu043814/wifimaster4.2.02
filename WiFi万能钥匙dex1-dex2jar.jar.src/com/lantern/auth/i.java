package com.lantern.auth;

import android.content.Context;
import com.bluefay.a.e;
import com.lantern.account.R.string;
import com.lantern.auth.utils.b;
import com.lantern.core.c;
import com.lantern.core.o;

public final class i
{
  private Context a;
  private b b;
  private String c = "";
  private com.bluefay.b.a d = null;
  private com.bluefay.b.a e = new j(this);
  private com.bluefay.b.a f = new k(this);
  
  public i(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.c = paramString;
  }
  
  private void a(int paramInt)
  {
    if (this.b != null) {
      this.b.a();
    }
    if (this.d != null) {
      this.d.a(paramInt, null, null);
    }
  }
  
  public final void a(com.bluefay.b.a parama)
  {
    this.d = parama;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (!com.bluefay.a.a.c(this.a))
    {
      e.a(this.a.getString(R.string.auth_failed_no_network));
      a(0);
    }
    for (;;)
    {
      return;
      this.b = new b(this.a, this.e);
      this.b.a(paramString1, paramString2, this.c, c.getServer().k());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */