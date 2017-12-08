package com.lantern.wifilocating.push.i;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.lantern.wifilocating.push.util.l;

public final class c
{
  private Context a;
  private String b;
  private String c;
  private a d;
  private a e;
  
  public c(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a()
  {
    int i = l.a(this.a, "push_sdk_alert_dialog");
    Object localObject1;
    if (i == 0)
    {
      localObject1 = new AlertDialog.Builder(this.a);
      ((AlertDialog.Builder)localObject1).setTitle(this.b);
      ((AlertDialog.Builder)localObject1).setMessage(this.c);
      ((AlertDialog.Builder)localObject1).setNegativeButton(17039360, new d(this));
      ((AlertDialog.Builder)localObject1).setNeutralButton(17039370, new e(this));
      localObject1 = ((AlertDialog.Builder)localObject1).create();
    }
    for (;;)
    {
      ((Dialog)localObject1).getWindow().setType(2003);
      ((Dialog)localObject1).setCanceledOnTouchOutside(false);
      ((Dialog)localObject1).setCancelable(true);
      ((Dialog)localObject1).show();
      return;
      Object localObject2 = this.a;
      localObject1 = this.a;
      localObject1 = new Dialog((Context)localObject2, ((Context)localObject1).getResources().getIdentifier("Lt_Dlg_Translucent_NoTitle", "style", ((Context)localObject1).getPackageName()));
      View localView = LayoutInflater.from(this.a).inflate(i, null);
      localObject2 = (TextView)localView.findViewById(l.c(this.a, "tv_title"));
      TextView localTextView = (TextView)localView.findViewById(l.c(this.a, "tv_content"));
      Button localButton2 = (Button)localView.findViewById(l.c(this.a, "btn_cancel"));
      Button localButton1 = (Button)localView.findViewById(l.c(this.a, "btn_ok"));
      ((TextView)localObject2).setText(this.b);
      localTextView.setText(this.c);
      localTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
      localButton2.setOnClickListener(new f(this, (Dialog)localObject1));
      localButton1.setOnClickListener(new g(this, (Dialog)localObject1));
      ((Dialog)localObject1).setContentView(localView);
    }
  }
  
  public final void a(a parama)
  {
    this.d = parama;
  }
  
  public final void a(String paramString)
  {
    this.b = paramString;
  }
  
  public final void b()
  {
    this.e = null;
  }
  
  public final void b(String paramString)
  {
    this.c = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/i/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */