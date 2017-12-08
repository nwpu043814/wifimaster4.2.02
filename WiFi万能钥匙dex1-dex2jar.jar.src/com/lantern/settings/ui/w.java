package com.lantern.settings.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lantern.settings.R.drawable;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;

public final class w
  extends BaseAdapter
{
  private Context a;
  private LayoutInflater b;
  private final int[][] c = { { 0, R.drawable.settings_invite_wechat, R.string.settings_more_share_weixin_title }, { 1, R.drawable.settings_invite_group, R.string.settings_more_share_friend_title }, { 2, R.drawable.settings_invite_more, R.string.settings_more_share_share_as } };
  
  public w(Context paramContext)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
  }
  
  public final int getCount()
  {
    return this.c.length;
  }
  
  public final Object getItem(int paramInt)
  {
    if (paramInt < this.c.length) {}
    for (int[] arrayOfInt = this.c[paramInt];; arrayOfInt = null) {
      return arrayOfInt;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt >= this.c.length) {
      paramView = null;
    }
    for (;;)
    {
      return paramView;
      if (paramView == null)
      {
        paramViewGroup = this.b.inflate(R.layout.settings_invite_item, null);
        TextView localTextView = (TextView)paramViewGroup;
        paramView = paramViewGroup;
        if (localTextView != null)
        {
          localTextView.setText(this.a.getString(this.c[paramInt][2]));
          localTextView.setCompoundDrawablesWithIntrinsicBounds(null, this.a.getResources().getDrawable(this.c[paramInt][1]), null, null);
          localTextView.setTag(Integer.valueOf(this.c[paramInt][0]));
          paramView = paramViewGroup;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */