package com.wifi.connect.plugin.magickey.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.bluefay.b.h;
import com.lantern.core.model.WkAccessPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class AutoConnectStore
{
  private SharedPreferences a;
  
  public AutoConnectStore(Context paramContext)
  {
    this.a = paramContext.getSharedPreferences("connect_auto", 0);
  }
  
  public final List<WkAccessPoint> a()
  {
    ArrayList localArrayList2;
    label258:
    int j;
    for (;;)
    {
      String str;
      Object localObject4;
      try
      {
        Object localObject1 = this.a.getAll();
        if (localObject1 != null)
        {
          i = ((Map)localObject1).size();
          if (i != 0) {}
        }
        else
        {
          localObject1 = null;
          return (List<WkAccessPoint>)localObject1;
        }
        localArrayList2 = new java/util/ArrayList;
        localArrayList2.<init>();
        localObject1 = ((Map)localObject1).entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label258;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
        if (!(localEntry.getValue() instanceof String)) {
          continue;
        }
        str = (String)localEntry.getValue();
        if ((str != null) && (str.startsWith("{")))
        {
          boolean bool = str.endsWith("}");
          if (bool)
          {
            try
            {
              localObject4 = new org/json/JSONObject;
              ((JSONObject)localObject4).<init>(str);
              str = ((JSONObject)localObject4).optString("bssid");
              WkAccessPointEvent localWkAccessPointEvent = new com/wifi/connect/plugin/magickey/database/AutoConnectStore$WkAccessPointEvent;
              localWkAccessPointEvent.<init>(this, (String)localEntry.getKey(), str);
              localWkAccessPointEvent.e = ((JSONObject)localObject4).optLong("cts");
              localArrayList2.add(localWkAccessPointEvent);
            }
            catch (JSONException localJSONException)
            {
              h.a(localJSONException);
            }
            continue;
          }
        }
        localObject4 = new com/wifi/connect/plugin/magickey/database/AutoConnectStore$WkAccessPointEvent;
      }
      finally {}
      ((WkAccessPointEvent)localObject4).<init>(this, (String)localJSONException.getKey(), str);
      localArrayList2.add(localObject4);
      continue;
      j = localArrayList2.size();
      if (j > 3) {
        break;
      }
      localObject3 = null;
    }
    Object localObject3 = new com/wifi/connect/plugin/magickey/database/c;
    ((c)localObject3).<init>(this);
    Collections.sort(localArrayList2, (Comparator)localObject3);
    ArrayList localArrayList1 = new java/util/ArrayList;
    localArrayList1.<init>();
    for (int i = 3;; i++)
    {
      localObject3 = localArrayList1;
      if (i >= j) {
        break;
      }
      localArrayList1.add(localArrayList2.get(i));
    }
  }
  
  public final boolean a(WkAccessPoint paramWkAccessPoint)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramWkAccessPoint == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      try
      {
        if (paramWkAccessPoint.a == null) {
          continue;
        }
        bool1 = bool2;
        if (paramWkAccessPoint.a.length() == 0) {
          continue;
        }
        SharedPreferences.Editor localEditor = this.a.edit();
        WkAccessPointEvent localWkAccessPointEvent = new com/wifi/connect/plugin/magickey/database/AutoConnectStore$WkAccessPointEvent;
        localWkAccessPointEvent.<init>(this, paramWkAccessPoint);
        localWkAccessPointEvent.e = System.currentTimeMillis();
        localEditor.putString(paramWkAccessPoint.a, localWkAccessPointEvent.toString());
        bool1 = localEditor.commit();
      }
      finally {}
    }
  }
  
  public final boolean b(WkAccessPoint paramWkAccessPoint)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramWkAccessPoint == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      try
      {
        if (paramWkAccessPoint.a == null) {
          continue;
        }
        bool1 = bool2;
        if (paramWkAccessPoint.a.length() == 0) {
          continue;
        }
        SharedPreferences.Editor localEditor = this.a.edit();
        localEditor.remove(paramWkAccessPoint.a);
        bool1 = localEditor.commit();
      }
      finally {}
    }
  }
  
  class WkAccessPointEvent
    extends WkAccessPoint
  {
    public long e = 0L;
    
    public WkAccessPointEvent(WkAccessPoint paramWkAccessPoint)
    {
      super();
    }
    
    public WkAccessPointEvent(String paramString1, String paramString2)
    {
      super(paramString2);
    }
    
    public final JSONObject c()
    {
      JSONObject localJSONObject = super.c();
      try
      {
        localJSONObject.put("cts", this.e);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          h.a(localJSONException);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/database/AutoConnectStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */