package com.lantern.wifitools.examination;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;

final class g
  implements View.OnClickListener
{
  g(ExamResultFragment paramExamResultFragment) {}
  
  public final void onClick(View paramView)
  {
    this.a.getActivity().finish();
    a.e().onEvent("switchwifi1");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */