package com.lantern.e.a;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;
import com.lantern.safecommand.aidl.ConnectionStateNotify;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.vpn.utils.ResTool;
import com.lantern.wifiseccheck.vpn.utils.UIUtils;
import com.lantern.wifiseccheck.vpn.utils.UserUtils;

final class h
  extends Handler
{
  h(b paramb) {}
  
  public final void handleMessage(Message paramMessage)
  {
    LogUtils.d("HomeSdkAct", "get message " + paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      b.d(this.a);
      b.a(this.a, (ConnectionStateNotify)paramMessage.obj);
      continue;
      b.e(this.a).setVisibility(0);
      continue;
      UserUtils.setVpnStartAuto(false, this.a);
      b.f(this.a);
      b.g(this.a);
      continue;
      b.a(this.a, this.a.getString(ResTool.getStringId("wifisafechecking", b.h(this.a))), this.a.getResources().getColor(ResTool.getColorId("button_start_text", b.h(this.a))));
      Toast.makeText(this.a, ResTool.getStringId("vpn_authorise_fail_cancel", b.h(this.a)), 1).show();
      b.i(this.a);
      continue;
      if (b.j(this.a) != null)
      {
        b.j(this.a).show();
      }
      else
      {
        b.a(this.a, UIUtils.createLoadingDialog(this.a, this.a.getResources().getString(ResTool.getStringId("starting_vpn", b.h(this.a)))));
        b.j(this.a).show();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/e/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */