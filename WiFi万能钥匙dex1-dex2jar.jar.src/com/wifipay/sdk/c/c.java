package com.wifipay.sdk.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.wifipay.sdk.a.a.b;
import com.wifipay.sdk.util.f;

class c
  implements View.OnClickListener
{
  c(a parama) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == f.a(this.a.getContext(), a.b.b, a.b.a))
    {
      this.a.dismiss();
      if (a.a(this.a) != null) {
        a.a(this.a).a();
      }
    }
    for (;;)
    {
      return;
      if (i == f.a(this.a.getContext(), a.b.c, a.b.a))
      {
        this.a.dismiss();
        if (a.b(this.a) != null) {
          a.b(this.a).a();
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */