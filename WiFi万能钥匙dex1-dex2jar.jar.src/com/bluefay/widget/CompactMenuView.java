package com.bluefay.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bluefay.b.h;
import com.bluefay.framework.R.drawable;
import com.bluefay.framework.R.layout;

public class CompactMenuView
  extends LinearLayout
{
  private b a;
  private View.OnClickListener b = new e(this);
  
  public CompactMenuView(Context paramContext)
  {
    super(paramContext);
    setBackgroundResource(R.drawable.framework_popup_window_bg);
    setOrientation(1);
  }
  
  public CompactMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBackgroundResource(R.drawable.framework_popup_window_bg);
    setOrientation(1);
  }
  
  public final void a(Menu paramMenu)
  {
    removeAllViews();
    if (paramMenu != null)
    {
      int k = paramMenu.size();
      int i = 0;
      if (i < k)
      {
        if (i > 0) {
          addView(LayoutInflater.from(getContext()).inflate(R.layout.framework_compact_menu_divider, this, false));
        }
        MenuItem localMenuItem = paramMenu.getItem(i);
        h.a("item:" + localMenuItem, new Object[0]);
        LinearLayout localLinearLayout = (LinearLayout)LayoutInflater.from(getContext()).inflate(R.layout.framework_compact_menu_button, this, false);
        Object localObject = (TextView)localLinearLayout.findViewById(16908310);
        ((TextView)localObject).setText(localMenuItem.getTitle());
        ((TextView)localObject).setEnabled(localMenuItem.isEnabled());
        localObject = (ImageView)localLinearLayout.findViewById(16908294);
        ((ImageView)localObject).setImageDrawable(localMenuItem.getIcon());
        ((ImageView)localObject).setEnabled(localMenuItem.isEnabled());
        if (localMenuItem.isEnabled())
        {
          ((ImageView)localObject).setAlpha(1.0F);
          label188:
          localLinearLayout.setTag(localMenuItem);
          localLinearLayout.setEnabled(localMenuItem.isEnabled());
          if (!localMenuItem.isVisible()) {
            break label256;
          }
        }
        label256:
        for (int j = 0;; j = 8)
        {
          localLinearLayout.setVisibility(j);
          localLinearLayout.setOnClickListener(this.b);
          addView(localLinearLayout);
          i++;
          break;
          ((ImageView)localObject).setAlpha(0.5F);
          break label188;
        }
      }
    }
  }
  
  public final void a(b paramb)
  {
    this.a = paramb;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/CompactMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */