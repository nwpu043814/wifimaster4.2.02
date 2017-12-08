package com.wifipay.sdk.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.wifipay.sdk.util.f;

public class a
  extends Dialog
{
  private CharSequence a;
  private CharSequence b;
  private CharSequence c;
  private CharSequence d;
  private CharSequence e;
  private View f;
  private TextView g;
  private TextView h;
  private Button i;
  private Button j;
  private d k;
  private c l;
  private DialogInterface.OnKeyListener m = new b(this);
  private View.OnClickListener n = new c(this);
  
  private a(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    View localView = findViewById(f.a(getContext(), com.wifipay.sdk.a.a.b.j, com.wifipay.sdk.a.a.b.a));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(-1);
    localGradientDrawable.setCornerRadius(f.a(getContext(), 5.0F));
    localView.setBackgroundDrawable(localGradientDrawable);
    this.g = ((TextView)findViewById(f.a(getContext(), com.wifipay.sdk.a.a.b.l, com.wifipay.sdk.a.a.b.a)));
    this.g.setVisibility(8);
    this.h = ((TextView)findViewById(f.a(getContext(), com.wifipay.sdk.a.a.b.i, com.wifipay.sdk.a.a.b.a)));
    this.j = ((Button)findViewById(f.a(getContext(), com.wifipay.sdk.a.a.b.b, com.wifipay.sdk.a.a.b.a)));
    this.i = ((Button)findViewById(f.a(getContext(), com.wifipay.sdk.a.a.b.c, com.wifipay.sdk.a.a.b.a)));
    this.f = findViewById(f.a(getContext(), com.wifipay.sdk.a.a.b.g, com.wifipay.sdk.a.a.b.a));
    this.e = com.wifipay.sdk.a.a.d.c;
  }
  
  private void b()
  {
    this.i.setOnClickListener(this.n);
    this.j.setOnClickListener(this.n);
    if (!TextUtils.isEmpty(this.a))
    {
      this.g.setVisibility(0);
      this.g.setText(this.a);
    }
    this.h.setText(this.b);
    c();
    setOnKeyListener(this.m);
  }
  
  private void c()
  {
    int i1 = f.a(getContext(), 5.0F);
    Object localObject;
    if ((this.c != null) && (this.d != null))
    {
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setColor(-1);
      ((GradientDrawable)localObject).setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, i1, i1, 0.0F, 0.0F });
      this.i.setBackgroundDrawable((Drawable)localObject);
      this.i.setText(this.c);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setColor(-1);
      ((GradientDrawable)localObject).setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, i1, i1 });
      this.j.setBackgroundDrawable((Drawable)localObject);
      this.j.setText(this.d);
      return;
    }
    if (this.c != null) {
      localObject = this.c;
    }
    for (;;)
    {
      this.c = ((CharSequence)localObject);
      this.j.setVisibility(8);
      this.f.setVisibility(8);
      this.i.setText(this.c);
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setColor(-1);
      ((GradientDrawable)localObject).setCornerRadii(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, i1, i1, i1, i1 });
      this.i.setBackgroundDrawable((Drawable)localObject);
      localObject = (LinearLayout.LayoutParams)this.i.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).weight = 0.5F;
      this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
      break;
      if (this.d != null) {
        localObject = this.d;
      } else {
        localObject = this.e;
      }
    }
  }
  
  public void a(c paramc)
  {
    this.l = paramc;
  }
  
  public void a(d paramd)
  {
    this.k = paramd;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    if (this.h != null) {
      this.h.setText(paramCharSequence);
    }
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
  }
  
  public void c(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.requestFeature(1);
    paramBundle.setBackgroundDrawable(new ColorDrawable(0));
    setContentView(f.a(getContext(), com.wifipay.sdk.a.a.c.b, com.wifipay.sdk.a.a.c.a));
    setCanceledOnTouchOutside(false);
    a();
    b();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
    if (this.g != null)
    {
      this.g.setVisibility(0);
      this.g.setText(paramCharSequence);
    }
  }
  
  public static class a
  {
    private a.b a = new a.b(null);
    private Context b;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public a a()
    {
      a locala = new a(this.b, null);
      this.a.a(locala);
      return locala;
    }
  }
  
  private static class b
  {
    private CharSequence a;
    private CharSequence b;
    private CharSequence c;
    private CharSequence d;
    private a.d e;
    private a.c f;
    
    public void a(a parama)
    {
      if (this.a != null) {
        parama.setTitle(this.a);
      }
      if (this.b != null) {
        parama.a(this.b);
      }
      if (this.d != null) {
        parama.c(this.d);
      }
      if (this.c != null) {
        parama.b(this.c);
      }
      parama.a(this.e);
      parama.a(this.f);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
  }
  
  public static abstract interface d
  {
    public abstract void a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */