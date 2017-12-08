package com.wifipay.wallet.home.widget;

import android.view.View;
import java.lang.ref.WeakReference;

public class e
  implements Runnable
{
  private WeakReference<View> a;
  
  public e(View paramView)
  {
    this.a = new WeakReference(paramView);
  }
  
  public void a()
  {
    View localView = (View)this.a.get();
    if (localView != null)
    {
      localView.setEnabled(false);
      localView.postDelayed(this, 500L);
    }
  }
  
  public void run()
  {
    View localView = (View)this.a.get();
    if (localView != null) {
      localView.setEnabled(true);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */