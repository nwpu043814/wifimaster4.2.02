package com.wifipay.framework.widget;

import android.view.View;
import java.lang.ref.WeakReference;

public class a
  implements Runnable
{
  private WeakReference<View> a;
  
  a(View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  void a()
  {
    View localView = (View)this.a.get();
    if (localView != null)
    {
      localView.setClickable(false);
      localView.postDelayed(this, 500L);
    }
  }
  
  public void run()
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.setClickable(true);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */