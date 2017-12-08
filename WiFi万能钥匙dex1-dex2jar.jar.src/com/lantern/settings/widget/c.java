package com.lantern.settings.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import bluefay.app.k;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;

public final class c
  extends k
{
  private Context a;
  private View b;
  private a c;
  private View.OnClickListener d = new d(this);
  
  public c(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    setCancelable(true);
    setCanceledOnTouchOutside(true);
    paramContext = LayoutInflater.from(this.a).inflate(R.layout.settings_save_picture_dialog, null);
    this.b = paramContext.findViewById(R.id.savePicture);
    this.b.setOnClickListener(this.d);
    a(paramContext);
  }
  
  public final void a(a parama)
  {
    this.c = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */