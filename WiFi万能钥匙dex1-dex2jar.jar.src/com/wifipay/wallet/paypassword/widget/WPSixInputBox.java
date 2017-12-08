package com.wifipay.wallet.paypassword.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.wifipay.R.drawable;
import com.wifipay.R.styleable;

public class WPSixInputBox
  extends LinearLayout
  implements View.OnTouchListener
{
  private static final int a = R.drawable.wifipay_password_input_mask;
  private static final int b = R.drawable.wifipay_password_input_box_bg;
  private int c = 6;
  private Drawable d;
  private Drawable e;
  private int f;
  private ImageView[] g;
  private int h;
  private int i = 0;
  private onCompletedListener j;
  
  public WPSixInputBox(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WPSixInputBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
    a(paramContext);
  }
  
  public WPSixInputBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setOnTouchListener(this);
    for (int k = 0; k < this.c; k++)
    {
      Object localObject = new FrameLayout(paramContext);
      ((FrameLayout)localObject).setBackgroundDrawable(this.e);
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setImageDrawable(this.d);
      localImageView.setVisibility(4);
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 17;
      ((FrameLayout)localObject).addView(localImageView, localLayoutParams);
      addView((View)localObject, new LinearLayout.LayoutParams(0, -1, 1.0F));
      this.g[k] = localImageView;
      if (k < this.c - 1)
      {
        localObject = new View(paramContext);
        ((View)localObject).setBackgroundColor(this.f);
        addView((View)localObject, new LinearLayout.LayoutParams(this.h, -1));
      }
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WPSixInputBox, paramInt, 0);
    this.c = paramAttributeSet.getInt(R.styleable.WPSixInputBox_wifipay_passwordLength, 6);
    this.d = paramAttributeSet.getDrawable(R.styleable.WPSixInputBox_wifipay_passwordMask);
    if (this.d == null) {
      this.d = paramContext.getResources().getDrawable(a);
    }
    this.e = paramAttributeSet.getDrawable(R.styleable.WPSixInputBox_wifipay_passwordBackground);
    if (this.e == null) {
      this.e = paramContext.getResources().getDrawable(b);
    }
    this.f = paramAttributeSet.getColor(R.styleable.WPSixInputBox_wifipay_spacingColor, 0);
    this.h = paramAttributeSet.getDimensionPixelOffset(R.styleable.WPSixInputBox_wifipay_horizontalSpacing, 1);
    this.g = new ImageView[this.c];
    this.i = 0;
    paramAttributeSet.recycle();
  }
  
  private void a(boolean paramBoolean)
  {
    ImageView localImageView;
    if (paramBoolean)
    {
      if (this.i <= 0) {
        break label86;
      }
      this.i -= 1;
      localImageView = this.g[this.i];
    }
    for (;;)
    {
      if (localImageView != null) {
        if (!paramBoolean) {
          break label81;
        }
      }
      label81:
      for (int k = 4;; k = 0)
      {
        localImageView.setVisibility(k);
        return;
        if (this.i >= this.c) {
          break label86;
        }
        localImageView = this.g[this.i];
        this.i += 1;
        break;
      }
      label86:
      localImageView = null;
    }
  }
  
  public boolean a()
  {
    boolean bool = true;
    if (this.i > 0) {
      a(true);
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public boolean b()
  {
    for (int k = 0; k < this.i; k++)
    {
      ImageView localImageView = this.g[k];
      if (localImageView != null) {
        localImageView.setVisibility(4);
      }
    }
    this.i = 0;
    return false;
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (this.i < this.c)
    {
      a(false);
      bool = true;
    }
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.j.invokeKeyboard();
    return true;
  }
  
  public void setListener(onCompletedListener paramonCompletedListener)
  {
    this.j = paramonCompletedListener;
  }
  
  public static abstract interface onCompletedListener
  {
    public abstract void invokeKeyboard();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/widget/WPSixInputBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */