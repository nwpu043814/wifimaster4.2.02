package com.wifipay.wallet.widget.virtualkeyboard;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.wifipay.common.logging.Logger;

class b
  implements AdapterView.OnItemClickListener
{
  b(VirtualKeyboardView paramVirtualKeyboardView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramInt < 11) && (paramInt != 9)) {
      VirtualKeyboardView.a(this.a, (String)VirtualKeyboardView.a(this.a).get(paramInt));
    }
    label118:
    label140:
    for (;;)
    {
      return;
      if (paramInt == 9)
      {
        paramAdapterView = VirtualKeyboardView.b(this.a);
        if ((!paramAdapterView.contains(VirtualKeyBoardFlag.DECIMAL.getFlag())) && (!paramAdapterView.contains(VirtualKeyBoardFlag.ID.getFlag()))) {
          break label118;
        }
        Logger.i("VirtualKeyboardView == %s", new Object[] { " 9 amount=" + paramAdapterView });
      }
      for (;;)
      {
        if (paramInt != 11) {
          break label140;
        }
        VirtualKeyboardView.c(this.a);
        break;
        VirtualKeyboardView.a(this.a, (String)VirtualKeyboardView.a(this.a).get(paramInt));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/widget/virtualkeyboard/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */