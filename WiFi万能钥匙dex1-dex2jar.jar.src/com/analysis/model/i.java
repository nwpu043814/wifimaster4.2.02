package com.analysis.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.analysis.common.b;
import com.analysis.common.tools.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class i
  implements com.analysis.common.a
{
  private static final String h = "Pages";
  private static final String i = "save_pages";
  public final Map<String, Long> f = new HashMap();
  public final List<j> g = new ArrayList();
  
  private static String a(SharedPreferences paramSharedPreferences, String paramString)
  {
    return paramSharedPreferences.getString(paramString, "");
  }
  
  public static List<g> a(SharedPreferences paramSharedPreferences)
  {
    Object localObject1 = null;
    Object localObject2 = paramSharedPreferences.getString("save_pages", "");
    if (c.a((String)localObject2)) {}
    ArrayList localArrayList;
    for (paramSharedPreferences = (SharedPreferences)localObject1;; paramSharedPreferences = localArrayList) {
      for (;;)
      {
        return paramSharedPreferences;
        paramSharedPreferences.edit().remove("save_pages").commit();
        localArrayList = new ArrayList();
        try
        {
          String[] arrayOfString = ((String)localObject2).split(";");
          for (int j = 0; j < arrayOfString.length; j++)
          {
            String str = arrayOfString[j];
            if (!c.a(str))
            {
              localObject2 = new com/analysis/model/h;
              ((h)localObject2).<init>(str, a(paramSharedPreferences, "session_id"), a(paramSharedPreferences, "login_name"), a(paramSharedPreferences, "app_1d"));
              localArrayList.add(localObject2);
            }
          }
          if (localArrayList.size() <= 0) {}
        }
        catch (Exception paramSharedPreferences)
        {
          paramSharedPreferences.printStackTrace();
          paramSharedPreferences = (SharedPreferences)localObject1;
        }
      }
    }
  }
  
  private void a()
  {
    String str = null;
    long l = 0L;
    for (;;)
    {
      synchronized (this.f)
      {
        Iterator localIterator = this.f.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (((Long)localEntry.getValue()).longValue() > l)
          {
            l = ((Long)localEntry.getValue()).longValue();
            str = (String)localEntry.getKey();
          }
        }
        else
        {
          if (c.b(str)) {
            a(str);
          }
          return;
        }
      }
    }
  }
  
  private void a(Context paramContext)
  {
    Object localObject1 = paramContext.getSharedPreferences("sp_general_config", 0);
    paramContext = ((SharedPreferences)localObject1).edit();
    if (this.g.size() > 0)
    {
      ??? = ((SharedPreferences)localObject1).getString("save_pages", null);
      localObject1 = new b();
      if (c.b((String)???))
      {
        ((b)localObject1).a((String)???);
        ((b)localObject1).a(";");
      }
      synchronized (this.g)
      {
        Iterator localIterator = this.g.iterator();
        if (localIterator.hasNext())
        {
          j localj = (j)localIterator.next();
          ((b)localObject1).a(String.format("[\"%s\",%d,%d]", new Object[] { localj.a, Long.valueOf(localj.b), Long.valueOf(localj.c) }));
          ((b)localObject1).a(";");
        }
      }
      this.g.clear();
      int j = ((b)localObject1).f.length();
      ((b)localObject1).f.deleteCharAt(j - 1);
      paramContext.remove("save_pages");
      paramContext.putString("save_pages", ((b)localObject1).toString());
    }
    paramContext.commit();
  }
  
  private void b(String paramString)
  {
    if (c.b(paramString)) {}
    synchronized (this.f)
    {
      this.f.put(paramString, Long.valueOf(System.currentTimeMillis()));
      return;
    }
  }
  
  public final void a(String paramString)
  {
    if (c.b(paramString)) {}
    for (;;)
    {
      Long localLong;
      synchronized (this.f)
      {
        localLong = (Long)this.f.remove(paramString);
        if (localLong == null)
        {
          com.analysis.common.tools.a.a("Pages", "you should call onPageStart before onPageEnd");
          return;
        }
      }
      long l = System.currentTimeMillis();
      synchronized (this.g)
      {
        List localList = this.g;
        j localj = new com/analysis/model/j;
        localj.<init>(this, paramString, localLong.longValue(), l);
        localList.add(localj);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */