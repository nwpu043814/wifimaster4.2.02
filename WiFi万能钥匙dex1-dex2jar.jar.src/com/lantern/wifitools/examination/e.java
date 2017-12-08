package com.lantern.wifitools.examination;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;

final class e
  implements View.OnClickListener
{
  e(ExamResultFragment paramExamResultFragment, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (!ExamResultFragment.a(this.b.getActivity(), "com.lantern.safecommand")) {
      r.a(this.b.getActivity(), "http://vpn.lianwifi.com:8080/VpnDownloadPage/vpn_page/vpn_download.jsp?ssid=" + ExamResultFragment.a(this.b).getString("ssid") + "&&secLevel=" + this.a + "&&neighbours=" + ExamResultFragment.a(this.b).getInt("neighbors"));
    }
    a.e().onEvent("protecton");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */