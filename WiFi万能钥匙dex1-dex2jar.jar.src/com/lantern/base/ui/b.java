package com.lantern.base.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

public abstract class b<T>
  extends BaseAdapter
{
  private List<T> a;
  private Activity b;
  private LayoutInflater c;
  
  public b(Activity paramActivity)
  {
    ArrayList localArrayList = new ArrayList();
    this.b = paramActivity;
    this.a = localArrayList;
    this.c = LayoutInflater.from(paramActivity);
  }
  
  public final LayoutInflater a()
  {
    return this.c;
  }
  
  public final void a(List<T> paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.a = ((List)localObject);
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public T getItem(int paramInt)
  {
    return (T)this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/base/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */