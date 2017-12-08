package com.lantern.wifitools.examination;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

final class a
  implements View.OnClickListener
{
  a(ExamDeviceFragment.a parama, ExamDeviceFragment.b paramb, ExamDeviceFragment.a.a parama1) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString("mac", this.a.a);
    paramView.putString("default_value", this.a.d);
    paramView.putString("display_value", this.b.a.getText().toString());
    r.a(this.c.a.getActivity(), paramView, ExamRemarkFragment.class.getName(), false);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */