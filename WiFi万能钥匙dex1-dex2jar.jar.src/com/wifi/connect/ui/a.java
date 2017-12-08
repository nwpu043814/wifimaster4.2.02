package com.wifi.connect.ui;

import android.content.Context;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiConfiguration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.lantern.connect.R.layout;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.q;
import com.wifi.connect.a.b;
import com.wifi.connect.a.d;
import com.wifi.connect.a.e;
import com.wifi.connect.a.f;
import com.wifi.connect.model.AccessPoint;
import com.wifi.connect.model.AccessPointAlias;
import com.wifi.connect.model.AccessPointKey;
import com.wifi.connect.model.HttpAuthAp;
import com.wifi.connect.model.PluginAp;
import com.wifi.connect.model.WebAuthAp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public final class a
  extends BaseAdapter
{
  private LayoutInflater a;
  private Context b;
  private ArrayList<AccessPoint> c;
  private WkAccessPoint d;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
    this.c = new ArrayList();
    this.a = LayoutInflater.from(this.b);
  }
  
  private AccessPoint a(String paramString, int paramInt, NetworkInfo.State paramState)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {}
    int i;
    do
    {
      return (AccessPoint)localObject2;
      i = 0;
      localObject2 = localObject1;
    } while (i >= this.c.size());
    localObject2 = (AccessPoint)this.c.get(i);
    if ((paramString.equals(((AccessPoint)localObject2).a)) && (paramInt == ((AccessPoint)localObject2).c))
    {
      ((AccessPoint)localObject2).a(paramState);
      localObject1 = localObject2;
    }
    for (;;)
    {
      i++;
      break;
      if (((AccessPoint)localObject2).j()) {
        ((AccessPoint)localObject2).g();
      } else {
        ((AccessPoint)localObject2).a(NetworkInfo.State.UNKNOWN);
      }
    }
  }
  
  private void a(WkAccessPoint paramWkAccessPoint, NetworkInfo.State paramState)
  {
    String str = paramWkAccessPoint.a;
    int j = paramWkAccessPoint.c;
    int i;
    AccessPoint localAccessPoint;
    if (str != null)
    {
      i = 0;
      if (i < this.c.size())
      {
        localAccessPoint = (AccessPoint)this.c.get(i);
        if ((!str.equals(localAccessPoint.a)) || (j != localAccessPoint.c)) {}
      }
    }
    for (;;)
    {
      if (localAccessPoint != null)
      {
        if ((localAccessPoint.f() == null) || (localAccessPoint.f().networkId == -1))
        {
          paramWkAccessPoint = u.a(this.b, paramWkAccessPoint.a, paramWkAccessPoint.c);
          if (paramWkAccessPoint != null) {
            localAccessPoint.b(paramWkAccessPoint);
          }
        }
        localAccessPoint.a(paramState);
        Collections.sort(this.c);
      }
      return;
      i++;
      break;
      localAccessPoint = null;
    }
  }
  
  public final int a(AccessPoint paramAccessPoint)
  {
    int i;
    if (paramAccessPoint == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      for (int j = 0;; j++)
      {
        if (j >= this.c.size()) {
          break label69;
        }
        AccessPoint localAccessPoint = (AccessPoint)this.c.get(j);
        if (localAccessPoint.a.equals(paramAccessPoint.a))
        {
          i = j;
          if (localAccessPoint.c == paramAccessPoint.c) {
            break;
          }
        }
      }
      label69:
      i = -1;
    }
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint)
  {
    this.d = paramWkAccessPoint;
    a(paramWkAccessPoint.a, paramWkAccessPoint.c, NetworkInfo.State.CONNECTING);
    Collections.sort(this.c);
    notifyDataSetChanged();
  }
  
  public final void a(com.wifi.connect.model.c paramc)
  {
    if (paramc.c())
    {
      Object localObject1 = paramc.k();
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        e.b().a();
        com.wifi.connect.a.a.a().b();
      }
      Object localObject2 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (AccessPointKey)((Iterator)localObject2).next();
        com.bluefay.b.h.a("key:" + localObject1, new Object[0]);
        e.b().a(((AccessPointKey)localObject1).a, (AccessPointKey)localObject1);
        b.b().a(((AccessPointKey)localObject1).a, (AccessPointKey)localObject1);
      }
      localObject1 = paramc.l().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PluginAp)((Iterator)localObject1).next();
        com.bluefay.b.h.a("plugin:" + localObject2, new Object[0]);
        e.b().a(((PluginAp)localObject2).a, new AccessPointKey());
        f.a().a(((PluginAp)localObject2).a, (PluginAp)localObject2);
      }
      localObject1 = paramc.m().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WebAuthAp)((Iterator)localObject1).next();
        com.bluefay.b.h.a("webauth:" + localObject2, new Object[0]);
        com.wifi.connect.a.h.a().a(((WebAuthAp)localObject2).a, (WebAuthAp)localObject2);
      }
      localObject1 = paramc.n();
      if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AccessPointAlias)((Iterator)localObject1).next();
          com.bluefay.b.h.a("alias:" + localObject2, new Object[0]);
          com.wifi.connect.a.a.a().a(((AccessPointAlias)localObject2).a, (AccessPointAlias)localObject2);
        }
      }
      paramc = paramc.o();
      localObject1 = paramc.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HttpAuthAp)((Iterator)localObject1).next();
        com.bluefay.b.h.a("mochui:" + localObject2, new Object[0]);
        d.a().a(((HttpAuthAp)localObject2).a(), (HttpAuthAp)localObject2);
        e.b().a(((HttpAuthAp)localObject2).a, new AccessPointKey());
      }
      if (paramc.size() > 0) {
        com.lantern.analytics.a.e().onEvent("http_show", paramc.size());
      }
      Collections.sort(this.c);
      notifyDataSetChanged();
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    Object localObject;
    if (paramString != null)
    {
      localObject = b();
      if (localObject != null)
      {
        localObject = ((AccessPoint)localObject).a;
        if (!paramString.equals(localObject)) {
          break label32;
        }
      }
    }
    for (;;)
    {
      return;
      localObject = null;
      break;
      label32:
      localObject = a(paramString, paramInt, NetworkInfo.State.CONNECTED);
      if (localObject != null) {
        if ((((AccessPoint)localObject).f() == null) || (((AccessPoint)localObject).f().networkId == -1))
        {
          paramString = u.a(this.b, paramString, paramInt);
          if (paramString != null) {
            ((AccessPoint)localObject).b(paramString);
          }
        }
        else
        {
          Collections.sort(this.c);
          notifyDataSetChanged();
        }
      }
    }
  }
  
  public final void a(ArrayList<AccessPoint> paramArrayList)
  {
    if (paramArrayList != null)
    {
      this.c = paramArrayList;
      if (this.d != null)
      {
        for (int i = 0; i < this.c.size(); i++)
        {
          localObject = (AccessPoint)this.c.get(i);
          if (NetworkInfo.State.CONNECTED.equals(((AccessPoint)localObject).k())) {
            ((AccessPoint)localObject).a(NetworkInfo.State.UNKNOWN);
          }
        }
        a(this.d, NetworkInfo.State.CONNECTING);
      }
      Object localObject = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((ArrayList)localObject).add(new WkAccessPoint((AccessPoint)paramArrayList.next()));
      }
      com.lantern.core.c.getShareValue().a((ArrayList)localObject);
      notifyDataSetChanged();
    }
    for (;;)
    {
      return;
      this.c.clear();
      com.lantern.core.c.getShareValue().a(null);
      notifyDataSetChanged();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    AccessPoint localAccessPoint = b();
    if (localAccessPoint != null)
    {
      localAccessPoint.g();
      if (paramBoolean) {
        notifyDataSetChanged();
      }
    }
  }
  
  public final boolean a()
  {
    if (this.d != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final AccessPoint b()
  {
    Iterator localIterator = this.c.iterator();
    AccessPoint localAccessPoint;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localAccessPoint = (AccessPoint)localIterator.next();
    } while (!localAccessPoint.h());
    for (;;)
    {
      return localAccessPoint;
      localAccessPoint = null;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    WkAccessPoint localWkAccessPoint;
    if (this.d != null)
    {
      localWkAccessPoint = this.d;
      this.d = null;
      if (!paramBoolean) {
        break label34;
      }
      a(localWkAccessPoint, NetworkInfo.State.CONNECTED);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      label34:
      a(localWkAccessPoint, NetworkInfo.State.UNKNOWN);
    }
  }
  
  public final ArrayList<AccessPoint> c()
  {
    return this.c;
  }
  
  public final int getCount()
  {
    return this.c.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.a.inflate(R.layout.connect_list_item, paramViewGroup, false);
    }
    for (;;)
    {
      paramView = (WifiListItemView)paramView;
      paramView.a(paramInt);
      this.c.size();
      WifiListItemView.b();
      paramView.a((AccessPoint)this.c.get(paramInt), this.d);
      return paramView;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */