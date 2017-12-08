package com.linksure.apservice.ui.home.keyboard;

import android.view.View;
import android.view.View.OnClickListener;
import com.linksure.apservice.b.h;

final class d
  implements View.OnClickListener
{
  d(KeyboardFragment paramKeyboardFragment) {}
  
  public final void onClick(View paramView)
  {
    KeyboardFragment.a(this.a).b((h)paramView.getTag());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/keyboard/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */