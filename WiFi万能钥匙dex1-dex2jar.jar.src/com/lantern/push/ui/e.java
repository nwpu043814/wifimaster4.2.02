package com.lantern.push.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.lantern.push.b.a;

final class e
  implements AdapterView.OnItemLongClickListener
{
  e(MessageFragment paramMessageFragment) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (a)MessageFragment.b(this.a).getItem(paramInt);
    if (paramAdapterView != null) {
      MessageFragment.a(this.a, paramAdapterView.a());
    }
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */