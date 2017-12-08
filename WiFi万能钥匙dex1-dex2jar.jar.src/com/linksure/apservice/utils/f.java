package com.linksure.apservice.utils;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;

public final class f
{
  a a;
  
  private f(Activity paramActivity, a parama, View paramView)
  {
    View localView = paramActivity.getWindow().getDecorView();
    if (localView == null) {}
    for (;;)
    {
      return;
      localView.getViewTreeObserver().addOnGlobalLayoutListener(new g(this, localView, paramView));
      this.a = new h(this, paramActivity, parama);
    }
  }
  
  public static void a(Activity paramActivity, a parama)
  {
    new f(paramActivity, parama, null);
  }
  
  public static void a(Activity paramActivity, a parama, View paramView)
  {
    new f(paramActivity, parama, paramView);
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */