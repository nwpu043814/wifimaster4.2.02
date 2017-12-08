package com.lantern.wifitools.examination;

import android.os.Bundle;
import android.os.Handler;
import com.bluefay.b.a;
import com.lantern.core.g.j;

final class l
  implements a
{
  l(ExaminationFragment paramExaminationFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    ExaminationFragment.a(this.a).putInt("status", ((Integer)paramObject).intValue());
    if ((paramInt == 1) && (j.b(((Integer)paramObject).intValue()))) {
      ExaminationFragment.b(this.a).sendEmptyMessageDelayed(2, 4000L);
    }
    for (;;)
    {
      return;
      r.a(this.a.getActivity(), ExaminationFragment.a(this.a), ExamResultFragment.class.getName(), true);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */