package com.wifi.connect.widget;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;
import com.lantern.core.p;
import com.lantern.core.t;
import com.wifi.connect.model.AccessPoint;

public final class l
  extends bluefay.app.k
  implements k
{
  private final a a;
  private final AccessPoint b;
  private View c;
  private g d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private Context j;
  private DialogInterface.OnClickListener k = new m(this);
  
  public l(Context paramContext, a parama, AccessPoint paramAccessPoint, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    this.j = paramContext;
    this.e = true;
    this.a = parama;
    this.b = paramAccessPoint;
    this.f = paramBoolean1;
    this.i = paramBoolean2;
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    a(-1, paramCharSequence, this.k);
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    a(-3, paramCharSequence, this.k);
  }
  
  public final void c(CharSequence paramCharSequence)
  {
    a(-2, paramCharSequence, this.k);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    int n = 1;
    boolean bool;
    if (Build.VERSION.SDK_INT <= 16)
    {
      this.c = getLayoutInflater().inflate(R.layout.connect_wifi_dialog_sp, null);
      this.c.setLayerType(2, null);
      a(this.c);
      Object localObject = (CheckBox)this.c.findViewById(R.id.share_password);
      this.g = t.a(getContext());
      if (!this.g) {
        break label343;
      }
      bool = true;
      label78:
      ((CheckBox)localObject).setChecked(bool);
      localObject = this.c.findViewById(R.id.share_password_layout);
      if ((!this.g) && (!this.f)) {
        break label349;
      }
      m = 8;
      label114:
      ((View)localObject).setVisibility(m);
      this.h = t.c(getContext());
      localObject = p.c("");
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!"a0000000000000000000000000000001".equals(localObject))) {
        break label354;
      }
      m = 1;
      label158:
      localObject = (CheckBox)this.c.findViewById(R.id.backup_password);
      if (!this.h) {
        break label359;
      }
      bool = true;
      label183:
      ((CheckBox)localObject).setChecked(bool);
      if (m != 0) {
        ((CheckBox)localObject).setChecked(false);
      }
      localObject = this.c.findViewById(R.id.backup_password_layout);
      if ((!this.h) && (m == 0)) {
        break label365;
      }
      m = 8;
      label226:
      ((View)localObject).setVisibility(m);
      if (this.c.findViewById(R.id.share_password_layout).getVisibility() != 0) {
        break label370;
      }
    }
    label343:
    label349:
    label354:
    label359:
    label365:
    label370:
    for (int m = n;; m = 0)
    {
      if ((m == 0) && (!this.f)) {
        this.c.findViewById(R.id.show_password_tip_layout).setVisibility(8);
      }
      b();
      this.d = new g(this, this.c, this.b, this.e, this.f, this.i);
      super.onCreate(paramBundle);
      this.d.a();
      return;
      this.c = getLayoutInflater().inflate(R.layout.connect_wifi_dialog, null);
      break;
      bool = false;
      break label78;
      m = 0;
      break label114;
      m = 0;
      break label158;
      bool = false;
      break label183;
      m = 0;
      break label226;
    }
  }
  
  public final Button u_()
  {
    return a();
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, AccessPoint paramAccessPoint);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/widget/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */