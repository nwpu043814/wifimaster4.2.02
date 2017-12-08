package bluefay.app;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

final class g
  extends ArrayAdapter<CharSequence>
{
  g(e.a parama, Context paramContext, int paramInt, CharSequence[] paramArrayOfCharSequence, ListView paramListView)
  {
    super(paramContext, paramInt, 16908308, paramArrayOfCharSequence);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    if ((this.b.B != null) && (this.b.B[paramInt] != 0)) {
      this.a.setItemChecked(paramInt, true);
    }
    return paramView;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */