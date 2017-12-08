package com.wifipay.wallet.home.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public class a
  extends Scroller
{
  private int a = 300;
  
  public a(Context paramContext, Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */