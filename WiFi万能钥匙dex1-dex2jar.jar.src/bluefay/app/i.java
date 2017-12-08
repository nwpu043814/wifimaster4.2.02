package bluefay.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class i
  implements AdapterView.OnItemClickListener
{
  i(e.a parama, e parame) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b.u.onClick(e.g(this.a), paramInt);
    if (!this.b.D) {
      e.g(this.a).dismiss();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */