package com.wifipay.framework.app.ui;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.wifipay.common.a.g;
import com.wifipay.framework.widget.WPAlertDialog;
import com.wifipay.framework.widget.WPAlertDialog.a;
import com.wifipay.framework.widget.WPAlertDialog.onNegativeListener;
import com.wifipay.framework.widget.WPAlertDialog.onPositiveListener;
import com.wifipay.framework.widget.h;

public class d
{
  Activity a;
  private Dialog b;
  private Runnable c = new e(this);
  
  public d(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.runOnUiThread(this.c);
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, 2000);
  }
  
  public void a(String paramString, int paramInt)
  {
    a();
    if ((this.a != null) && (!this.a.isFinishing())) {
      this.a.runOnUiThread(new c(paramString, paramInt));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, WPAlertDialog.onPositiveListener paramonPositiveListener, String paramString4, WPAlertDialog.onNegativeListener paramonNegativeListener)
  {
    a(paramString1, paramString2, paramString3, paramonPositiveListener, paramString4, paramonNegativeListener, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, WPAlertDialog.onPositiveListener paramonPositiveListener, String paramString4, WPAlertDialog.onNegativeListener paramonNegativeListener, boolean paramBoolean)
  {
    a();
    if ((this.a != null) && (!this.a.isFinishing())) {
      this.a.runOnUiThread(new a(paramString1, paramString2, paramString3, paramonPositiveListener, paramString4, paramonNegativeListener, paramBoolean));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, WPAlertDialog.onPositiveListener paramonPositiveListener, String paramString4, WPAlertDialog.onNegativeListener paramonNegativeListener, boolean paramBoolean, View paramView)
  {
    a();
    if ((this.a != null) && (!this.a.isFinishing())) {
      this.a.runOnUiThread(new a(paramString1, paramString2, paramString3, paramonPositiveListener, paramString4, paramonNegativeListener, paramBoolean, paramView));
    }
  }
  
  public void b()
  {
    a();
    if ((this.a != null) && (!this.a.isFinishing())) {
      this.a.runOnUiThread(new b(null));
    }
  }
  
  private class a
    implements Runnable
  {
    String a;
    String b;
    String c;
    String d;
    WPAlertDialog.onPositiveListener e;
    WPAlertDialog.onNegativeListener f;
    boolean g;
    View h;
    private WindowManager.LayoutParams j;
    
    public a(String paramString1, String paramString2, String paramString3, WPAlertDialog.onPositiveListener paramonPositiveListener, String paramString4, WPAlertDialog.onNegativeListener paramonNegativeListener, boolean paramBoolean)
    {
      this(paramString1, paramString2, paramString3, paramonPositiveListener, paramString4, paramonNegativeListener, paramBoolean, null);
    }
    
    public a(String paramString1, String paramString2, String paramString3, WPAlertDialog.onPositiveListener paramonPositiveListener, String paramString4, WPAlertDialog.onNegativeListener paramonNegativeListener, boolean paramBoolean, View paramView)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramString4;
      this.e = paramonPositiveListener;
      this.f = paramonNegativeListener;
      this.g = paramBoolean;
      this.h = paramView;
    }
    
    public void run()
    {
      WPAlertDialog localWPAlertDialog = new WPAlertDialog.a(d.this.a).a();
      if (!TextUtils.isEmpty(this.a)) {
        localWPAlertDialog.setTitle(this.a);
      }
      if (!TextUtils.isEmpty(this.b)) {
        localWPAlertDialog.a(this.b);
      }
      if (!TextUtils.isEmpty(this.c))
      {
        localWPAlertDialog.b(this.c);
        localWPAlertDialog.a(this.e);
      }
      if (!TextUtils.isEmpty(this.d))
      {
        localWPAlertDialog.c(this.d);
        localWPAlertDialog.a(this.f);
      }
      localWPAlertDialog.setCanceledOnTouchOutside(this.g);
      localWPAlertDialog.setOnKeyListener(new f(this));
      localWPAlertDialog.show();
      if (this.h != null) {
        localWPAlertDialog.b(this.h);
      }
      Window localWindow = localWPAlertDialog.getWindow();
      if (localWindow != null)
      {
        if (this.j == null)
        {
          Display localDisplay = d.this.a.getWindowManager().getDefaultDisplay();
          this.j = localWindow.getAttributes();
          this.j.width = ((int)(localDisplay.getWidth() * 0.8D));
        }
        localWindow.setAttributes(this.j);
      }
      localWPAlertDialog.setCancelable(false);
      d.a(d.this, localWPAlertDialog);
    }
  }
  
  private class b
    implements Runnable
  {
    private b() {}
    
    public void run()
    {
      h localh = new h(d.this.a);
      localh.show();
      d.a(d.this, localh);
    }
  }
  
  private class c
    implements Runnable
  {
    private String b;
    private int c;
    
    public c(String paramString, int paramInt)
    {
      this.b = paramString;
      this.c = paramInt;
    }
    
    public void run()
    {
      if (!g.a(this.b))
      {
        if (!b.a(d.this.a)) {
          break label48;
        }
        Toast.makeText(d.this.a.getApplicationContext(), this.b, this.c).show();
      }
      for (;;)
      {
        return;
        label48:
        b.a(d.this.a.getApplicationContext(), this.b, this.c).a();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/app/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */