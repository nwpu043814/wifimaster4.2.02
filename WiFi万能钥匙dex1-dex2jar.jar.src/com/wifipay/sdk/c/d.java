package com.wifipay.sdk.c;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.wifipay.sdk.a.a.a;
import com.wifipay.sdk.a.a.b;
import com.wifipay.sdk.a.a.c;
import com.wifipay.sdk.a.a.d;
import com.wifipay.sdk.app.g;
import com.wifipay.sdk.util.b;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class d
  extends Dialog
{
  private ImageView a;
  private TextView b;
  private TextView c;
  private Animation d;
  private String e;
  private g f = new g();
  private boolean g = true;
  private int h = 0;
  private final Runnable i = new e(this);
  private final Runnable j = new f(this);
  
  public d(Context paramContext)
  {
    super(paramContext);
  }
  
  private static Drawable a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        localByteArrayInputStream = new java/io/ByteArrayInputStream;
        localByteArrayInputStream.<init>(b.a(paramString));
        Bitmap localBitmap;
        if (paramContext == null) {}
      }
      catch (Exception paramContext)
      {
        try
        {
          paramString = new android/graphics/BitmapFactory$Options;
          paramString.<init>();
          paramString.inDensity = 480;
          paramString.inTargetDensity = paramContext.getResources().getDisplayMetrics().densityDpi;
          localBitmap = BitmapFactory.decodeStream(localByteArrayInputStream, null, paramString);
          paramString = new android/graphics/drawable/BitmapDrawable;
          paramString.<init>(paramContext.getResources(), localBitmap);
          paramContext = paramString;
          return paramContext;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            ByteArrayInputStream localByteArrayInputStream;
            paramContext = localByteArrayInputStream;
          }
        }
        paramContext = paramContext;
        paramContext = null;
      }
      try
      {
        paramContext.close();
        paramContext = null;
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setVisibility(0);
      this.a.setAnimation(this.d);
    }
    for (;;)
    {
      return;
      this.a.setVisibility(8);
    }
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
    if (this.b != null) {
      this.b.setText(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    super.show();
    b(paramBoolean);
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.a.clearAnimation();
    this.f.b(this.i);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawable(new ColorDrawable(0));
    paramBundle.requestFeature(1);
    if (Build.VERSION.SDK_INT >= 14) {
      paramBundle.setDimAmount(0.7F);
    }
    setContentView(com.wifipay.sdk.util.f.a(getContext(), a.c.c, a.c.a));
    View localView = findViewById(com.wifipay.sdk.util.f.a(getContext(), a.b.o, a.b.a));
    paramBundle = new GradientDrawable();
    paramBundle.setCornerRadius(9.0F);
    paramBundle.setColor(-1);
    localView.setBackgroundDrawable(paramBundle);
    this.a = ((ImageView)findViewById(com.wifipay.sdk.util.f.a(getContext(), a.b.m, a.b.a)));
    this.a.setImageDrawable(a(getContext(), a.a.c));
    this.b = ((TextView)findViewById(com.wifipay.sdk.util.f.a(getContext(), a.b.n, a.b.a)));
    if (!com.a.a.a.a.e.a(this.e))
    {
      this.b.setText(this.e);
      if (this.e.equalsIgnoreCase(a.d.b)) {
        this.f.a(this.j, 1000L);
      }
    }
    this.c = ((TextView)findViewById(com.wifipay.sdk.util.f.a(getContext(), a.b.p, a.b.a)));
    this.d = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
    this.d.setDuration(900L);
    this.d.setInterpolator(new LinearInterpolator());
    this.d.setRepeatCount(-1);
    setCanceledOnTouchOutside(false);
    setCancelable(false);
    if (!this.g)
    {
      this.c.setVisibility(0);
      this.f.a(this.i);
    }
    for (;;)
    {
      return;
      this.c.setVisibility(8);
    }
  }
  
  @Deprecated
  public void show()
  {
    super.show();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */