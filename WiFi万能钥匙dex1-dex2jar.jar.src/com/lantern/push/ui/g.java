package com.lantern.push.ui;

import android.widget.RelativeLayout;
import com.bluefay.b.a;
import java.util.List;

final class g
  implements a
{
  g(MessageFragment paramMessageFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    paramString = (List)paramObject;
    if ((paramString == null) || (paramString.size() == 0)) {
      MessageFragment.g(this.a).setVisibility(0);
    }
    for (;;)
    {
      MessageFragment.i(this.a);
      return;
      MessageFragment.g(this.a).setVisibility(8);
      MessageFragment.b(this.a).a(paramString);
      MessageFragment.b(this.a).a(MessageFragment.g(this.a));
      MessageFragment.b(this.a);
      if (!h.b(paramString)) {
        MessageFragment.h(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/ui/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */