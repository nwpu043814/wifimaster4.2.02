package bluefay.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bluefay.framework.R.layout;
import java.util.ArrayList;

public final class t
  extends BaseAdapter
{
  private ArrayList<MenuItem> a;
  private Context b;
  
  public t(Context paramContext, Menu paramMenu)
  {
    this.b = paramContext;
    this.a = new ArrayList();
    for (int i = 0; i < paramMenu.size(); i++)
    {
      paramContext = paramMenu.getItem(i);
      this.a.add(paramContext);
    }
  }
  
  public final MenuItem a(int paramInt)
  {
    return (MenuItem)this.a.get(paramInt);
  }
  
  public final void a(Menu paramMenu)
  {
    if (paramMenu != null)
    {
      this.a.clear();
      for (int i = 0; i < paramMenu.size(); i++)
      {
        MenuItem localMenuItem = paramMenu.getItem(i);
        this.a.add(localMenuItem);
      }
      notifyDataSetChanged();
    }
  }
  
  public final int getCount()
  {
    return this.a.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = LayoutInflater.from(this.b).inflate(R.layout.framework_select_dialog_item, paramViewGroup, false);
    }
    for (;;)
    {
      paramViewGroup = a(paramInt);
      ((TextView)paramView).setText(paramViewGroup.getTitle());
      paramView.setEnabled(paramViewGroup.isEnabled());
      if (paramViewGroup.isVisible()) {}
      for (paramInt = 0;; paramInt = 8)
      {
        paramView.setVisibility(paramInt);
        return paramView;
      }
    }
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return a(paramInt).isEnabled();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */