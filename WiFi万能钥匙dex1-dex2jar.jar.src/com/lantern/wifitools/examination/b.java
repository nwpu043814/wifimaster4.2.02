package com.lantern.wifitools.examination;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;

final class b
  implements View.OnClickListener
{
  b(ExamResultFragment paramExamResultFragment) {}
  
  public final void onClick(View paramView)
  {
    r.a(this.a.getActivity(), ExamResultFragment.a(this.a), ExamDeviceFragment.class.getName(), false);
    a.e().onEvent("checkmore");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */