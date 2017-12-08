package com.lantern.wifitools.examination;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;

final class c
  implements View.OnClickListener
{
  c(ExamResultFragment paramExamResultFragment) {}
  
  public final void onClick(View paramView)
  {
    r.a(ExamResultFragment.b(this.a), "http://insurance.lianwifi.com/");
    a.e().onEvent("freeins");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */