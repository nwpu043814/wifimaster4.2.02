package com.bluefay.widget;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class HeaderGridView
  extends GridView
{
  private ArrayList<a> a = new ArrayList();
  
  public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setClipChildren(false);
  }
  
  public HeaderGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    super.setClipChildren(false);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    ListAdapter localListAdapter = getAdapter();
    if ((localListAdapter != null) && ((localListAdapter instanceof b))) {
      ((b)localListAdapter).a(getNumColumns());
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (this.a.size() > 0)
    {
      paramListAdapter = new b(this.a, paramListAdapter);
      int i = getNumColumns();
      if (i > 1) {
        paramListAdapter.a(i);
      }
      super.setAdapter(paramListAdapter);
    }
    for (;;)
    {
      return;
      super.setAdapter(paramListAdapter);
    }
  }
  
  public void setClipChildren(boolean paramBoolean) {}
  
  private static final class a
  {
    public ViewGroup a;
    public Object b;
    public boolean c;
  }
  
  private static final class b
    implements Filterable, WrapperListAdapter
  {
    ArrayList<HeaderGridView.a> a;
    boolean b;
    private final DataSetObservable c = new DataSetObservable();
    private final ListAdapter d;
    private int e = 1;
    private final boolean f;
    
    public b(ArrayList<HeaderGridView.a> paramArrayList, ListAdapter paramListAdapter)
    {
      this.d = paramListAdapter;
      this.f = (paramListAdapter instanceof Filterable);
      if (paramArrayList == null) {
        throw new IllegalArgumentException("headerViewInfos cannot be null");
      }
      this.a = paramArrayList;
      this.b = a(this.a);
    }
    
    private static boolean a(ArrayList<HeaderGridView.a> paramArrayList)
    {
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.iterator();
        do
        {
          if (!paramArrayList.hasNext()) {
            break;
          }
        } while (((HeaderGridView.a)paramArrayList.next()).c);
      }
      for (boolean bool = false;; bool = true) {
        return bool;
      }
    }
    
    public final void a(int paramInt)
    {
      if (paramInt <= 0) {
        throw new IllegalArgumentException("Number of columns must be 1 or more");
      }
      if (this.e != paramInt)
      {
        this.e = paramInt;
        this.c.notifyChanged();
      }
    }
    
    public final boolean areAllItemsEnabled()
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (this.d != null) {
        if ((!this.b) || (!this.d.areAllItemsEnabled())) {
          break label34;
        }
      }
      label34:
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
    }
    
    public final int getCount()
    {
      if (this.d != null) {}
      for (int i = this.a.size() * this.e + this.d.getCount();; i = this.a.size() * this.e) {
        return i;
      }
    }
    
    public final Filter getFilter()
    {
      if (this.f) {}
      for (Filter localFilter = ((Filterable)this.d).getFilter();; localFilter = null) {
        return localFilter;
      }
    }
    
    public final Object getItem(int paramInt)
    {
      int i = this.a.size() * this.e;
      Object localObject;
      if (paramInt < i) {
        if (paramInt % this.e == 0) {
          localObject = ((HeaderGridView.a)this.a.get(paramInt / this.e)).b;
        }
      }
      for (;;)
      {
        return localObject;
        localObject = null;
        continue;
        i = paramInt - i;
        if ((this.d == null) || (i >= this.d.getCount())) {
          break;
        }
        localObject = this.d.getItem(i);
      }
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      int i = this.a.size() * this.e;
      if ((this.d != null) && (paramInt >= i))
      {
        paramInt -= i;
        if (paramInt >= this.d.getCount()) {}
      }
      for (long l = this.d.getItemId(paramInt);; l = -1L) {
        return l;
      }
    }
    
    public final int getItemViewType(int paramInt)
    {
      int i = this.a.size() * this.e;
      if ((paramInt < i) && (paramInt % this.e != 0)) {
        if (this.d != null) {
          paramInt = this.d.getViewTypeCount();
        }
      }
      for (;;)
      {
        return paramInt;
        paramInt = 1;
        continue;
        if ((this.d != null) && (paramInt >= i))
        {
          paramInt -= i;
          if (paramInt < this.d.getCount())
          {
            paramInt = this.d.getItemViewType(paramInt);
            continue;
          }
        }
        paramInt = -2;
      }
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = this.a.size() * this.e;
      ViewGroup localViewGroup;
      Object localObject;
      if (paramInt < i)
      {
        localViewGroup = ((HeaderGridView.a)this.a.get(paramInt / this.e)).a;
        if (paramInt % this.e == 0) {
          localObject = localViewGroup;
        }
      }
      for (;;)
      {
        return (View)localObject;
        localObject = paramView;
        if (paramView == null) {
          localObject = new View(paramViewGroup.getContext());
        }
        ((View)localObject).setVisibility(4);
        ((View)localObject).setMinimumHeight(localViewGroup.getHeight());
        continue;
        i = paramInt - i;
        if ((this.d == null) || (i >= this.d.getCount())) {
          break;
        }
        localObject = this.d.getView(i, paramView, paramViewGroup);
      }
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    
    public final int getViewTypeCount()
    {
      if (this.d != null) {}
      for (int i = this.d.getViewTypeCount() + 1;; i = 2) {
        return i;
      }
    }
    
    public final ListAdapter getWrappedAdapter()
    {
      return this.d;
    }
    
    public final boolean hasStableIds()
    {
      if (this.d != null) {}
      for (boolean bool = this.d.hasStableIds();; bool = false) {
        return bool;
      }
    }
    
    public final boolean isEmpty()
    {
      if (((this.d == null) || (this.d.isEmpty())) && (this.a.size() == 0)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      int i = this.a.size() * this.e;
      boolean bool;
      if (paramInt < i) {
        if ((paramInt % this.e == 0) && (((HeaderGridView.a)this.a.get(paramInt / this.e)).c)) {
          bool = true;
        }
      }
      for (;;)
      {
        return bool;
        bool = false;
        continue;
        i = paramInt - i;
        if ((this.d == null) || (i >= this.d.getCount())) {
          break;
        }
        bool = this.d.isEnabled(i);
      }
      throw new ArrayIndexOutOfBoundsException(paramInt);
    }
    
    public final void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      this.c.registerObserver(paramDataSetObserver);
      if (this.d != null) {
        this.d.registerDataSetObserver(paramDataSetObserver);
      }
    }
    
    public final void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
      this.c.unregisterObserver(paramDataSetObserver);
      if (this.d != null) {
        this.d.unregisterDataSetObserver(paramDataSetObserver);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/HeaderGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */