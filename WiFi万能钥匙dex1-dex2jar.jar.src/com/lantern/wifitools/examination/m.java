package com.lantern.wifitools.examination;

import android.os.Bundle;
import com.bluefay.b.a;

final class m
  implements a
{
  m(ExaminationFragment paramExaminationFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    ExaminationFragment.a(this.a).putInt("status", ((Integer)paramObject).intValue());
    if (this.a.getActivity() != null)
    {
      if (((Integer)paramObject).intValue() != 1) {
        break label48;
      }
      ExaminationFragment.c(this.a);
    }
    for (;;)
    {
      return;
      label48:
      r.a(this.a.getActivity(), ExaminationFragment.a(this.a), ExamResultFragment.class.getName(), true);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */