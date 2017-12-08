package com.bluefay.widget;

import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import bluefay.app.b;

final class d
  implements View.OnClickListener
{
  d(ActionTopBarView paramActionTopBarView) {}
  
  public final void onClick(View paramView)
  {
    if (ActionTopBarView.a(this.a) != null)
    {
      Context localContext = paramView.getContext();
      if (((localContext instanceof b)) && ((paramView.getTag() instanceof Menu))) {
        ((b)localContext).a((Menu)paramView.getTag(), paramView);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */