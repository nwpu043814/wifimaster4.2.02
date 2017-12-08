package com.lantern.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.bluefay.b.h;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private final String a = "config_origin_data";
  private final String b = "_conf_data";
  private final String c = "_update_ts";
  private Context d;
  private HashSet<String> e;
  private HashMap<String, JSONObject> f;
  private HashMap<String, String> g;
  private HashMap<String, a> h;
  private long i;
  private boolean j = false;
  
  public c(Context paramContext)
  {
    this.d = paramContext;
    this.e = new HashSet();
    this.f = new HashMap();
    this.g = new HashMap();
    this.h = new HashMap();
    this.i = d().getLong("last_no_new_config_time", 0L);
  }
  
  private static JSONObject a(SharedPreferences paramSharedPreferences, String paramString)
  {
    JSONObject localJSONObject = null;
    String str = paramSharedPreferences.getString(c(paramString), "");
    if (TextUtils.isEmpty(str)) {
      paramSharedPreferences = localJSONObject;
    }
    for (;;)
    {
      return paramSharedPreferences;
      try
      {
        h.a("config %s,data:%s", new Object[] { paramString, str });
        localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(str);
        paramSharedPreferences = localJSONObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a("parse stored data error:" + str, new Object[0]);
          paramSharedPreferences.edit().putString(c(paramString), "").apply();
          paramSharedPreferences = null;
        }
      }
    }
  }
  
  private void a(String paramString, SharedPreferences paramSharedPreferences)
  {
    JSONObject localJSONObject = a(paramSharedPreferences, paramString);
    if (localJSONObject != null) {
      this.f.put(paramString, localJSONObject);
    }
    a locala = (a)this.h.get(paramString);
    long l;
    if (locala != null)
    {
      l = paramSharedPreferences.getLong(d(paramString), 0L);
      if (localJSONObject != null) {
        break label64;
      }
      locala.a();
    }
    for (;;)
    {
      return;
      label64:
      locala.d = l;
      locala.c = localJSONObject.optLong("cv", 0L);
      try
      {
        locala.a(localJSONObject);
        h.a("loadAll config:%s to Class[%s] is success", new Object[] { paramString, locala.getClass() });
      }
      catch (Exception paramString)
      {
        h.a(paramString);
      }
    }
  }
  
  private static String c(String paramString)
  {
    return paramString + "_conf_data";
  }
  
  private SharedPreferences d()
  {
    return this.d.getSharedPreferences("config_origin_data", 0);
  }
  
  private static String d(String paramString)
  {
    return paramString + "_update_ts";
  }
  
  final long a()
  {
    return this.i;
  }
  
  final <T extends a> T a(Class<T> paramClass)
  {
    paramClass = (String)this.g.get(paramClass.getName());
    a locala = (a)this.h.get(paramClass);
    if (locala == null) {
      h.b("conf is Null: " + paramClass);
    }
    return locala;
  }
  
  final void a(String paramString)
  {
    a(paramString, null);
  }
  
  final void a(String paramString, Class<? extends a> paramClass)
  {
    if (TextUtils.isEmpty(paramString)) {
      h.b("confKey is empty!");
    }
    for (;;)
    {
      return;
      h.a("registered a config:%s", new Object[] { paramString });
      boolean bool = this.e.add(paramString);
      if (paramClass != null) {}
      try
      {
        a locala = (a)paramClass.getDeclaredConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.d });
        if (locala != null)
        {
          locala.a = paramString;
          this.h.put(paramString, locala);
          this.g.put(paramClass.getName(), paramString);
        }
        h.a("registered a config:%s and class:%s", new Object[] { paramString, paramClass.getName() });
        if ((!this.j) || (!bool)) {
          continue;
        }
        h.a("already loaded all configs, now do special load [%s]", new Object[] { paramString });
        a(paramString, d());
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(localException);
          Object localObject = null;
        }
      }
    }
  }
  
  final boolean a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    h.a("------updateConfiguration---------", new Object[0]);
    long l1 = paramJSONObject.optLong("ts", 0L);
    SharedPreferences localSharedPreferences = d();
    Iterator localIterator = this.e.iterator();
    int k = 1;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      JSONObject localJSONObject = paramJSONObject.optJSONObject(str);
      if ((localJSONObject != null) && (localJSONObject.length() > 0))
      {
        h.a("new config for:%s ,data:%s", new Object[] { str, localJSONObject });
        long l2 = localJSONObject.optLong("cv", 0L);
        Object localObject;
        if (l2 == -1L)
        {
          this.f.remove(str);
          localObject = localSharedPreferences.edit();
          ((SharedPreferences.Editor)localObject).putString(c(str), "");
          ((SharedPreferences.Editor)localObject).putLong(d(str), 0L);
          ((SharedPreferences.Editor)localObject).commit();
          h.a("clear local data for:%s", new Object[] { str });
        }
        for (;;)
        {
          localObject = (a)this.h.get(str);
          if (localObject != null) {
            break label310;
          }
          h.a("no Config class for key:%s", new Object[] { str });
          k = 0;
          break;
          this.f.put(str, localJSONObject);
          SharedPreferences.Editor localEditor = localSharedPreferences.edit();
          localObject = localJSONObject.toString();
          localEditor.putString(c(str), (String)localObject);
          localEditor.putLong(d(str), l1);
          localEditor.commit();
          h.a("store local data for:%s", new Object[] { str });
        }
        try
        {
          label310:
          ((a)localObject).d = l1;
          ((a)localObject).c = l2;
          ((a)localObject).b(localJSONObject);
          if (((a)localObject).c == -1L) {
            ((a)localObject).a();
          }
          k = 0;
        }
        catch (Exception localException)
        {
          h.a("update config failed!", localException);
          k = 0;
        }
      }
    }
    if ((k != 0) && (!paramBoolean))
    {
      h.a("not new config", new Object[0]);
      this.i = System.currentTimeMillis();
      localSharedPreferences.edit().putLong("last_no_new_config_time", this.i).commit();
    }
    if (k == 0) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public final JSONObject b()
  {
    JSONObject localJSONObject1 = new JSONObject();
    SharedPreferences localSharedPreferences = d();
    Iterator localIterator = this.e.iterator();
    if (localIterator.hasNext())
    {
      String str3 = (String)localIterator.next();
      Object localObject = (JSONObject)this.f.get(str3);
      String str2;
      if (localObject == null)
      {
        str2 = "0";
        localObject = "0";
      }
      for (;;)
      {
        JSONObject localJSONObject2 = new JSONObject();
        try
        {
          localJSONObject2.put("v", localObject);
          localJSONObject2.put("ts", str2);
          localJSONObject1.put(str3, localJSONObject2);
        }
        catch (JSONException localJSONException)
        {
          h.a(localJSONException);
        }
        break;
        String str1 = localJSONException.optString("cv", "0");
        str2 = String.valueOf(localSharedPreferences.getLong(d(str3), 0L));
      }
    }
    return localJSONObject1;
  }
  
  final JSONObject b(String paramString)
  {
    return (JSONObject)this.f.get(paramString);
  }
  
  final void c()
  {
    h.a("registered config size:%s", new Object[] { Integer.valueOf(this.e.size()) });
    SharedPreferences localSharedPreferences = d();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext()) {
      a((String)localIterator.next(), localSharedPreferences);
    }
    this.j = true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */