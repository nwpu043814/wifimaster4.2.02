package com.wifipay.sdk.c;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.widget.Toast;
import com.a.a.a.a.e;

public final class g
{
  Activity a;
  private Dialog b;
  private Runnable c = new h(this);
  
  public g(Activity paramActivity)
  {
    this.a = paramActivity;
  }
  
  public final void a()
  {
    if (this.a != null) {
      this.a.runOnUiThread(this.c);
    }
  }
  
  public final void a(String paramString)
  {
    a(paramString, true);
  }
  
  public final void a(String paramString, int paramInt)
  {
    a();
    if ((this.a != null) && (!this.a.isFinishing())) {
      this.a.runOnUiThread(new c(paramString, paramInt));
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, a.d paramd, String paramString4, a.c paramc)
  {
    a(paramString1, paramString2, paramString3, paramd, paramString4, paramc, false);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, a.d paramd, String paramString4, a.c paramc, boolean paramBoolean)
  {
    a();
    if ((this.a != null) && (!this.a.isFinishing())) {
      this.a.runOnUiThread(new a(paramString1, paramString2, paramString3, paramd, paramString4, paramc, paramBoolean));
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    a();
    if ((this.a != null) && (!this.a.isFinishing())) {
      this.a.runOnUiThread(new b(paramString, paramBoolean));
    }
  }
  
  public final void b(String paramString)
  {
    a(paramString, 0);
  }
  
  private class a
    implements Runnable
  {
    String a;
    String b;
    String c;
    String d;
    a.d e;
    a.c f;
    boolean g;
    
    public a(String paramString1, String paramString2, String paramString3, a.d paramd, String paramString4, a.c paramc, boolean paramBoolean)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramString4;
      this.e = paramd;
      this.f = paramc;
      this.g = paramBoolean;
    }
    
    public void run()
    {
      a locala = new a.a(g.this.a).a();
      if (!TextUtils.isEmpty(this.a)) {
        locala.setTitle(this.a);
      }
      if (!TextUtils.isEmpty(this.b)) {
        locala.a(this.b);
      }
      if (!TextUtils.isEmpty(this.c))
      {
        locala.b(this.c);
        locala.a(this.e);
      }
      if (!TextUtils.isEmpty(this.d))
      {
        locala.c(this.d);
        locala.a(this.f);
      }
      locala.setCanceledOnTouchOutside(this.g);
      locala.show();
      locala.setCancelable(false);
      g.a(g.this, locala);
    }
  }
  
  private class b
    implements Runnable
  {
    private String b;
    private boolean c;
    
    public b(String paramString, boolean paramBoolean)
    {
      this.b = paramString;
      this.c = paramBoolean;
    }
    
    public void run()
    {
      d locald = new d(g.this.a);
      if (!TextUtils.isEmpty(this.b)) {
        locald.a(this.b);
      }
      locald.a(this.c);
      g.a(g.this, locald);
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
      if (!e.a(this.b)) {
        Toast.makeText(g.this.a.getApplicationContext(), this.b, this.c).show();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */