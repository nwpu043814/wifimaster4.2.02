package com.lantern.wifitools.examination;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantern.analytics.a;
import com.lantern.wifitools.R.drawable;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.string;
import java.util.HashMap;
import java.util.Map;

final class q
  implements Runnable
{
  q(ExaminationFragment paramExaminationFragment) {}
  
  public final void run()
  {
    if (this.a.getActivity() == null) {
      return;
    }
    Object localObject = (TextView)ExaminationFragment.g(this.a).findViewById(R.id.exam_result_title);
    TextView localTextView = (TextView)ExaminationFragment.g(this.a).findViewById(R.id.exam_result_tip);
    ImageView localImageView = (ImageView)ExaminationFragment.g(this.a).findViewById(R.id.exam_result_icon);
    int i = ExaminationFragment.a(this.a).getInt("status", 0);
    if (i == 1)
    {
      ExaminationFragment.a(this.a).getInt("speed");
      localTextView.setText(this.a.getActivity().getString(R.string.exam_result_tip_normal_300));
      if (ExaminationFragment.a(this.a).getInt("security", -1) == 0)
      {
        ((TextView)localObject).setText(this.a.getString(R.string.exam_result_title_security_none));
        localImageView.setImageResource(R.drawable.wifi_unusual);
      }
    }
    for (;;)
    {
      ExaminationFragment.a(this.a).putBoolean("showInsurance", ExaminationFragment.h(this.a));
      r.a(this.a.getActivity(), ExaminationFragment.a(this.a), ExamResultFragment.class.getName(), true);
      localObject = new HashMap();
      ((Map)localObject).put("speed", String.valueOf(ExaminationFragment.a(this.a).getInt("speed") * 1024));
      ((Map)localObject).put("device", String.valueOf(ExaminationFragment.a(this.a).getInt("neighbors")));
      a.e().onEvent("exampage", (Map)localObject);
      break;
      ((TextView)localObject).setText(this.a.getString(R.string.exam_result_title_normal));
      localImageView.setImageResource(R.drawable.wifi_normal);
      continue;
      localImageView.setImageResource(R.drawable.wifi_broken);
      if (i == 0)
      {
        ((TextView)localObject).setText(this.a.getString(R.string.exam_result_title_offline));
        localTextView.setText(this.a.getString(R.string.exam_result_tip_offline));
      }
      else if (i == 256)
      {
        ((TextView)localObject).setText(this.a.getString(R.string.exam_result_title_security_web));
        localTextView.setText(this.a.getString(R.string.exam_result_tip_security_web));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */