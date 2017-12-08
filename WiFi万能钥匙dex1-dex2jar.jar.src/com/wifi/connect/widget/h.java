package com.wifi.connect.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

final class h
  implements View.OnClickListener
{
  h(g paramg) {}
  
  public final void onClick(View paramView)
  {
    paramView = g.a(this.a);
    boolean bool;
    int j;
    if (!g.a(this.a).isSelected())
    {
      bool = true;
      paramView.setSelected(bool);
      j = g.b(this.a).getSelectionEnd();
      paramView = g.b(this.a);
      if (!g.a(this.a).isSelected()) {
        break label98;
      }
    }
    label98:
    for (int i = 144;; i = 128)
    {
      paramView.setInputType(i | 0x1);
      if (j >= 0) {
        ((EditText)g.b(this.a)).setSelection(j);
      }
      return;
      bool = false;
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */