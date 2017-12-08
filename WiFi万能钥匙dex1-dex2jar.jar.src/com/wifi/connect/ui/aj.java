package com.wifi.connect.ui;

import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.wifi.connect.model.AccessPoint;

final class aj
  implements AbsListView.OnScrollListener
{
  aj(ConnectFragment paramConnectFragment) {}
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!ConnectFragment.h(this.a)) {}
    for (;;)
    {
      return;
      if ((paramInt2 > 0) && (paramInt1 > 0))
      {
        paramAbsListView = ConnectFragment.d(this.a).b();
        if ((paramAbsListView != null) && (!TextUtils.isEmpty(paramAbsListView.a()))) {
          ConnectFragment.d(this.a, paramAbsListView);
        }
      }
      else
      {
        ConnectFragment.i(this.a);
      }
    }
  }
  
  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */