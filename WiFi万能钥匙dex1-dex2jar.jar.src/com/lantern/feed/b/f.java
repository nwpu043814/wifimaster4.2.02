package com.lantern.feed.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.bluefay.b.h;
import com.lantern.feed.d.d;
import com.lantern.feed.ui.a;
import com.lantern.feed.ui.x;
import java.util.List;

public final class f
  extends BaseAdapter
{
  private e a;
  private AbsListView.LayoutParams b;
  
  public f(e parame)
  {
    this.a = parame;
  }
  
  private AbsListView.LayoutParams a(Context paramContext)
  {
    if (this.b == null) {
      this.b = new AbsListView.LayoutParams(-1, d.a(paramContext, 40.0F));
    }
    return this.b;
  }
  
  public final int getCount()
  {
    int i = 0;
    if (this.a != null) {
      i = this.a.d().size();
    }
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    if ((this.a != null) && (this.a.d().size() > 0)) {}
    for (Object localObject = this.a.d().get(paramInt);; localObject = null) {
      return localObject;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    int j = 0;
    int i = j;
    if (this.a != null)
    {
      i = j;
      if (this.a.d().size() > 0) {
        i = ((g)this.a.d().get(paramInt)).X() - 1;
      }
    }
    return i;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramInt < 0) || (paramInt > this.a.d().size() - 1)) {
      paramView = null;
    }
    for (;;)
    {
      return paramView;
      g localg = (g)this.a.d().get(paramInt);
      if (paramView == null)
      {
        if (localg.c() == 1)
        {
          paramView = new x(paramViewGroup.getContext(), this.a.i());
          paramView.a(localg.d(0));
          paramView.setLayoutParams(a(paramViewGroup.getContext()));
        }
        else
        {
          paramView = a.a(paramViewGroup.getContext(), localg.X(), localg.d(0));
        }
      }
      else
      {
        for (;;)
        {
          if (paramView == null)
          {
            h.a("itemView == null " + localg.c(), new Object[0]);
            paramView = null;
            break;
            if ((paramView instanceof a))
            {
              locala = (a)paramView;
              paramView = locala;
              if (localg == locala.a()) {
                break;
              }
              locala.d();
              if (localg.c() == 1)
              {
                paramView = new x(paramViewGroup.getContext(), this.a.i());
                paramView.a(localg.d(0));
                paramView.setLayoutParams(a(paramViewGroup.getContext()));
                break;
              }
              paramView = locala;
              if (locala.a().X() == localg.X()) {
                continue;
              }
            }
            while (localg.c() != 1)
            {
              a locala;
              paramView = a.a(paramViewGroup.getContext(), localg.X(), localg.d(0));
              break;
            }
            if ((paramView instanceof x))
            {
              paramView = (x)paramView;
              paramView.a(localg.d(0));
              paramView.setLayoutParams(a(paramViewGroup.getContext()));
              break;
            }
            paramView = new x(paramViewGroup.getContext(), this.a.i());
            paramView.a(localg.d(0));
            paramView.setLayoutParams(a(paramViewGroup.getContext()));
            break;
          }
        }
        paramView.e();
        paramView.a(this.a.i());
        paramView.a(localg);
        paramView.a(0);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return g.a.t - 1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */