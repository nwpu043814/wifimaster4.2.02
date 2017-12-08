package bluefay.app;

import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

final class j
  implements AdapterView.OnItemClickListener
{
  j(e.a parama, ListView paramListView, e parame) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.c.B != null) {
      this.c.B[paramInt] = this.a.isItemChecked(paramInt);
    }
    this.c.F.onClick(e.g(this.b), paramInt, this.a.isItemChecked(paramInt));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */