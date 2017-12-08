package com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import java.util.LinkedList;
import java.util.List;

class a
  extends BaseAdapter
  implements StickyListHeadersAdapter
{
  StickyListHeadersAdapter a;
  private final List<View> b = new LinkedList();
  private final Context c;
  private Drawable d;
  private int e;
  private a f;
  private DataSetObserver g = new b(this);
  
  a(Context paramContext, StickyListHeadersAdapter paramStickyListHeadersAdapter)
  {
    this.c = paramContext;
    this.a = paramStickyListHeadersAdapter;
    paramStickyListHeadersAdapter.registerDataSetObserver(this.g);
  }
  
  private View a()
  {
    if (this.b.size() > 0) {}
    for (View localView = (View)this.b.remove(0);; localView = null) {
      return localView;
    }
  }
  
  private View a(j paramj, int paramInt)
  {
    if (paramj.d == null) {}
    for (View localView = a();; localView = paramj.d)
    {
      paramj = this.a.getHeaderView(paramInt, localView, paramj);
      if (paramj != null) {
        break;
      }
      throw new NullPointerException("Header view must not be null.");
    }
    paramj.setClickable(true);
    paramj.setOnClickListener(new c(this, paramInt));
    return paramj;
  }
  
  private void a(j paramj)
  {
    paramj = paramj.d;
    if (paramj != null)
    {
      paramj.setVisibility(0);
      this.b.add(paramj);
    }
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt != 0) && (this.a.getHeaderId(paramInt) == this.a.getHeaderId(paramInt - 1))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public j a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView2;
    View localView1;
    if (paramView == null)
    {
      paramView = new j(this.c);
      localView2 = this.a.getView(paramInt, paramView.a, paramViewGroup);
      localView1 = null;
      if (!a(paramInt)) {
        break label102;
      }
      a(paramView);
      label49:
      if ((!(localView2 instanceof Checkable)) || ((paramView instanceof d))) {
        break label113;
      }
      paramViewGroup = new d(this.c);
    }
    for (;;)
    {
      paramViewGroup.a(localView2, localView1, this.d, this.e);
      return paramViewGroup;
      paramView = (j)paramView;
      break;
      label102:
      localView1 = a(paramView, paramInt);
      break label49;
      label113:
      paramViewGroup = paramView;
      if (!(localView2 instanceof Checkable))
      {
        paramViewGroup = paramView;
        if ((paramView instanceof d)) {
          paramViewGroup = new j(this.c);
        }
      }
    }
  }
  
  void a(Drawable paramDrawable, int paramInt)
  {
    this.d = paramDrawable;
    this.e = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(a parama)
  {
    this.f = parama;
  }
  
  public boolean areAllItemsEnabled()
  {
    return this.a.areAllItemsEnabled();
  }
  
  public boolean equals(Object paramObject)
  {
    return this.a.equals(paramObject);
  }
  
  public int getCount()
  {
    return this.a.getCount();
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return ((BaseAdapter)this.a).getDropDownView(paramInt, paramView, paramViewGroup);
  }
  
  public long getHeaderId(int paramInt)
  {
    return this.a.getHeaderId(paramInt);
  }
  
  public View getHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return this.a.getHeaderView(paramInt, paramView, paramViewGroup);
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.getItem(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.a.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    return this.a.getItemViewType(paramInt);
  }
  
  public int getViewTypeCount()
  {
    return this.a.getViewTypeCount();
  }
  
  public boolean hasStableIds()
  {
    return this.a.hasStableIds();
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }
  
  public boolean isEnabled(int paramInt)
  {
    return this.a.isEnabled(paramInt);
  }
  
  public void notifyDataSetChanged()
  {
    ((BaseAdapter)this.a).notifyDataSetChanged();
  }
  
  public void notifyDataSetInvalidated()
  {
    ((BaseAdapter)this.a).notifyDataSetInvalidated();
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  static abstract interface a
  {
    public abstract void a(View paramView, int paramInt, long paramLong);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/se/emilsjolander/stickylistheaders/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */