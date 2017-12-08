package com.lantern.dynamictab.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantern.core.imageloader.c;
import com.lantern.dynamictab.R.drawable;
import com.lantern.dynamictab.R.id;
import com.lantern.dynamictab.R.layout;
import com.lantern.dynamictab.e.e;
import com.lantern.dynamictab.e.f;
import java.util.ArrayList;

public final class a
  extends BaseAdapter
{
  private final String a = "com.zenmen.palmchat";
  private Context b;
  private LayoutInflater c;
  private ArrayList<com.lantern.dynamictab.b.a.a> d = new ArrayList();
  
  public a(Context paramContext)
  {
    this.b = paramContext;
    this.c = LayoutInflater.from(this.b);
    a();
  }
  
  private void a()
  {
    com.lantern.dynamictab.b.a locala1 = com.lantern.dynamictab.e.b.a().c();
    if ((locala1 == null) || (locala1.a == null) || (locala1.a.size() == 0)) {
      this.d.clear();
    }
    for (;;)
    {
      return;
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; i < locala1.a.size(); i++)
      {
        com.lantern.dynamictab.b.a.a locala = (com.lantern.dynamictab.b.a.a)locala1.a.get(i);
        localArrayList.add(locala);
        com.lantern.analytics.a.e().onEvent("dy_" + locala.a);
      }
      this.d = localArrayList;
    }
  }
  
  public final int getCount()
  {
    return this.d.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.d.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = this.c.inflate(R.layout.friends_fragment_item, null);
      paramViewGroup.a = ((ImageView)paramView.findViewById(R.id.iv_icon));
      paramViewGroup.b = ((TextView)paramView.findViewById(R.id.tv_title));
      paramViewGroup.c = ((ImageView)paramView.findViewById(R.id.iv_msg_icon));
      paramViewGroup.d = ((TextView)paramView.findViewById(R.id.tv_msg));
      paramViewGroup.e = paramView.findViewById(R.id.red_dot);
      paramViewGroup.f = paramView.findViewById(R.id.uninstall_red_dot);
      paramViewGroup.g = ((TextView)paramView.findViewById(R.id.dot_count));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      com.lantern.dynamictab.b.a.a locala = (com.lantern.dynamictab.b.a.a)this.d.get(paramInt);
      com.lantern.dynamictab.b.b localb = com.lantern.dynamictab.e.b.a().a.b(locala.a);
      if ("com.zenmen.palmchat".equals(locala.a))
      {
        paramViewGroup.a.setImageResource(R.drawable.icon_peoplenearby);
        label173:
        if (TextUtils.isEmpty(locala.c)) {}
      }
      try
      {
        if ("com.zenmen.palmchat".equals(locala.a))
        {
          c.a(this.b, locala.c, paramViewGroup.a, R.drawable.icon_peoplenearby);
          paramViewGroup.b.setText(locala.d);
          if (localb == null) {
            break label741;
          }
          if (!localb.f) {
            break label609;
          }
          if (!f.a(locala.a)) {
            break label589;
          }
          paramViewGroup.e.setVisibility(0);
          paramViewGroup.f.setVisibility(8);
          if (localb.e <= 0) {
            break label648;
          }
          paramViewGroup.g.setVisibility(0);
          if (localb.e <= 99) {
            break label630;
          }
          paramViewGroup.g.setText("...");
          if (TextUtils.isEmpty(localb.b)) {
            break label675;
          }
          paramViewGroup.c.setVisibility(0);
          paramViewGroup.c.setImageResource(R.drawable.icon_msg_default);
          paramViewGroup.d.setVisibility(8);
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            c.a(this.b, localb.b, paramViewGroup.c, R.drawable.icon_msg_default);
            paramViewGroup = new AbsListView.LayoutParams(-1, -2);
            paramViewGroup.height = ((int)TypedValue.applyDimension(1, 48.0F, this.b.getResources().getDisplayMetrics()));
            paramView.setLayoutParams(paramViewGroup);
            return paramView;
            paramViewGroup = (a)paramView.getTag();
            break;
            if (this.b.getPackageName().equals(locala.a))
            {
              paramViewGroup.a.setImageResource(R.drawable.icon_chatroom);
              break label173;
            }
            paramViewGroup.a.setImageResource(R.drawable.icon_friend_default);
            break label173;
            if (this.b.getPackageName().equals(locala.a))
            {
              c.a(this.b, locala.c, paramViewGroup.a, R.drawable.icon_chatroom);
              continue;
              localException1 = localException1;
              if ("com.zenmen.palmchat".equals(locala.a)) {
                paramViewGroup.a.setImageResource(R.drawable.icon_peoplenearby);
              }
            }
            else
            {
              c.a(this.b, locala.c, paramViewGroup.a, R.drawable.icon_friend_default);
              continue;
            }
            if (this.b.getPackageName().equals(locala.a))
            {
              paramViewGroup.a.setImageResource(R.drawable.icon_chatroom);
              continue;
            }
            paramViewGroup.a.setImageResource(R.drawable.icon_friend_default);
            continue;
            label589:
            paramViewGroup.f.setVisibility(0);
            paramViewGroup.e.setVisibility(8);
            continue;
            label609:
            paramViewGroup.e.setVisibility(8);
            paramViewGroup.f.setVisibility(8);
            continue;
            label630:
            paramViewGroup.g.setText(Integer.toString(localb.e));
            continue;
            label648:
            paramViewGroup.g.setVisibility(8);
          }
          catch (Exception localException2)
          {
            paramViewGroup.c.setImageResource(R.drawable.icon_msg_default);
            continue;
          }
          label675:
          paramViewGroup.c.setVisibility(8);
          if (TextUtils.isEmpty(localb.c))
          {
            paramViewGroup.d.setVisibility(8);
          }
          else
          {
            paramViewGroup.d.setTextSize(2, 11.0F);
            paramViewGroup.d.setVisibility(0);
            paramViewGroup.d.setText(localb.c);
            continue;
            label741:
            paramViewGroup.e.setVisibility(8);
            paramViewGroup.f.setVisibility(8);
            paramViewGroup.c.setVisibility(8);
            paramViewGroup.d.setVisibility(8);
            paramViewGroup.g.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final void notifyDataSetChanged()
  {
    a();
    super.notifyDataSetChanged();
  }
  
  static final class a
  {
    ImageView a;
    TextView b;
    ImageView c;
    TextView d;
    View e;
    View f;
    TextView g;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */