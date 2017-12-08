package com.linksure.apservice.ui.home.list;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import bluefay.app.k.a;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.style;

final class a
{
  private Context a;
  private int b;
  private DialogInterface.OnClickListener c;
  private Dialog d;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final a a()
  {
    View localView = LayoutInflater.from(this.a).inflate(R.layout.aps_msglist_list_dialog, null, false);
    k.a locala = new k.a(this.a, R.style.BL_Theme_Light_Dialog_Alert);
    localView.findViewById(R.id.aps_btn_retry).setOnClickListener(new b(this));
    localView.findViewById(R.id.aps_btn_del).setOnClickListener(new c(this));
    this.d = locala.a(localView).c();
    this.d.setCancelable(true);
    this.d.setCanceledOnTouchOutside(true);
    return this;
  }
  
  public final a a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.b = paramInt;
    this.c = paramOnClickListener;
    return this;
  }
  
  public final a b()
  {
    if (this.d != null) {
      this.d.show();
    }
    return this;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/list/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */