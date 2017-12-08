package com.wifi.connect.b;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import bluefay.app.b;
import bluefay.app.k.a;
import com.bluefay.b.h;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;
import com.lantern.connect.R.string;
import com.lantern.connect.R.style;
import com.lantern.core.model.WkAccessPoint;

public final class v
{
  private Context a;
  private com.bluefay.b.a b;
  private WkAccessPoint c;
  private String d;
  private com.bluefay.b.a e = new w(this);
  
  public v(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint)
  {
    if ((this.a != null) && ((this.a instanceof b)) && (!((b)this.a).c()))
    {
      com.lantern.analytics.a.e().onEvent("keysh3");
      k.a locala = new k.a(this.a, R.style.BL_Theme_Light_Dialog_Alert_Transparent_Custom);
      View localView = LayoutInflater.from(this.a).inflate(R.layout.connect_share_prompt_dialog, null);
      ((TextView)localView.findViewById(R.id.share_title)).setText(this.a.getString(R.string.share_prompt_title, new Object[] { paramWkAccessPoint.a }));
      locala.a(localView);
      locala.a(R.string.wifi_share_password, new aa(this));
      locala.b(R.string.share_prompt_dlg_mind, new ab(this));
      locala.a(new ac(this));
      locala.d();
    }
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint, String paramString, int paramInt1, int paramInt2, com.bluefay.b.a parama)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      h.c("pwd is null, shared ap failed");
    }
    for (;;)
    {
      return;
      new Handler().postDelayed(new y(this, paramWkAccessPoint, paramString, paramInt1, paramInt2, parama), 500L);
    }
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint, String paramString, com.bluefay.b.a parama)
  {
    this.b = parama;
    this.c = paramWkAccessPoint;
    this.d = paramString;
    new Handler().postDelayed(new x(this, paramWkAccessPoint, paramString), 500L);
  }
  
  public final void a(boolean paramBoolean, WkAccessPoint paramWkAccessPoint, String paramString, com.bluefay.b.a parama)
  {
    if (paramBoolean) {
      a(paramWkAccessPoint, paramString, 10, 0, parama);
    }
    for (;;)
    {
      return;
      a(paramWkAccessPoint, paramString, 0, 100, parama);
    }
  }
  
  public final void a(boolean paramBoolean1, WkAccessPoint paramWkAccessPoint, String paramString, boolean paramBoolean2, com.bluefay.b.a parama)
  {
    int i;
    if (paramBoolean1)
    {
      i = 101;
      if ((paramString != null) && (paramString.length() != 0)) {
        break label32;
      }
      h.c("pwd is null, shared ap failed");
    }
    for (;;)
    {
      return;
      i = 102;
      break;
      label32:
      new Handler().postDelayed(new z(this, paramWkAccessPoint, paramString, i, paramBoolean2, parama), 500L);
    }
  }
  
  public final void b(boolean paramBoolean, WkAccessPoint paramWkAccessPoint, String paramString, com.bluefay.b.a parama)
  {
    if (paramBoolean) {}
    for (int i = 101;; i = 102)
    {
      a(paramWkAccessPoint, paramString, 0, i, parama);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */