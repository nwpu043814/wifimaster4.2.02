package bluefay.preference;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ListView;

final class n
  implements View.OnKeyListener
{
  n(PreferenceFragment paramPreferenceFragment) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = PreferenceFragment.b(this.a).getSelectedItem();
    if ((localObject instanceof Preference)) {
      paramView = PreferenceFragment.b(this.a).getSelectedView();
    }
    for (boolean bool = ((Preference)localObject).onKey(paramView, paramInt, paramKeyEvent);; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */