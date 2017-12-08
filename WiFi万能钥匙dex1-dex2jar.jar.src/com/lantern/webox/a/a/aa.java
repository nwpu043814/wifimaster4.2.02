package com.lantern.webox.a.a;

import android.text.TextUtils;
import android.webkit.WebView;
import com.bluefay.b.h;
import com.lantern.browser.WkBrowserJsInterface;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.z;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.webox.a;
import com.lantern.webox.a.q;
import com.lantern.webox.a.q.a;
import com.lantern.webox.c.b;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aa
  implements q
{
  private static String a(WkBrowserWebView paramWkBrowserWebView, String paramString, Object... paramVarArgs)
  {
    int j = 0;
    localObject2 = null;
    if (paramVarArgs == null) {}
    do
    {
      for (;;)
      {
        try
        {
          localObject1 = new Object[1];
          localObject1[0] = paramWkBrowserWebView;
          paramWkBrowserWebView = new Class[localObject1.length];
          int k = localObject1.length;
          i = j;
          if (i >= k) {
            continue;
          }
          if ((localObject1[i] != null) && (!localObject1[i].equals(null))) {
            continue;
          }
          localObject1[i] = null;
          paramWkBrowserWebView[i] = String.class;
          i++;
        }
        catch (NoSuchMethodException paramWkBrowserWebView)
        {
          Object[] arrayOfObject;
          paramWkBrowserWebView.printStackTrace();
          paramWkBrowserWebView = (WkBrowserWebView)localObject2;
          return paramWkBrowserWebView;
          if (!localObject1[i].getClass().equals(WkBrowserWebView.class)) {
            continue;
          }
          paramWkBrowserWebView[i] = WebView.class;
        }
        catch (IllegalArgumentException paramWkBrowserWebView)
        {
          int i;
          paramWkBrowserWebView.printStackTrace();
          paramWkBrowserWebView = (WkBrowserWebView)localObject2;
          continue;
          paramWkBrowserWebView[i] = localObject1[i].getClass();
        }
        catch (IllegalAccessException paramWkBrowserWebView)
        {
          Object localObject1;
          paramWkBrowserWebView.printStackTrace();
          paramWkBrowserWebView = (WkBrowserWebView)localObject2;
          continue;
          paramWkBrowserWebView = String.valueOf(WkBrowserJsInterface.class.getMethod(paramString, paramWkBrowserWebView).invoke(null, (Object[])localObject1));
        }
        catch (InvocationTargetException paramWkBrowserWebView)
        {
          paramWkBrowserWebView.printStackTrace();
          paramWkBrowserWebView = (WkBrowserWebView)localObject2;
        }
      }
      arrayOfObject = new Object[paramVarArgs.length + 1];
      i = 0;
      localObject1 = arrayOfObject;
    } while (i >= arrayOfObject.length);
    if (i == 0) {
      arrayOfObject[i] = paramWkBrowserWebView;
    }
    for (;;)
    {
      i++;
      break;
      arrayOfObject[i] = paramVarArgs[(i - 1)];
    }
  }
  
  public final void a(WkBrowserWebView paramWkBrowserWebView, Map<String, Object> paramMap, q.a parama)
  {
    try
    {
      paramMap = (String)paramMap.get("data");
      JSONArray localJSONArray1 = new org/json/JSONArray;
      localJSONArray1.<init>(paramMap);
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      int k = localJSONArray1.length();
      paramWkBrowserWebView.f().a();
      for (int i = 0; i < k; i++)
      {
        paramMap = localJSONArray1.optJSONObject(i);
        if (paramMap != null)
        {
          String str1 = paramMap.optString("key");
          String str2 = paramMap.optString("method");
          if (!TextUtils.isEmpty(str2))
          {
            JSONArray localJSONArray2 = paramMap.optJSONArray("params");
            Object[] arrayOfObject = null;
            paramMap = arrayOfObject;
            if (localJSONArray2 != null)
            {
              int m = localJSONArray2.length();
              paramMap = arrayOfObject;
              if (m > 0)
              {
                arrayOfObject = new Object[m];
                for (int j = 0;; j++)
                {
                  paramMap = arrayOfObject;
                  if (j >= m) {
                    break;
                  }
                  arrayOfObject[j] = localJSONArray2.opt(j);
                }
              }
            }
            paramMap = a(paramWkBrowserWebView, str2, paramMap);
            if (paramMap != null) {
              localJSONObject.put(str1, paramMap);
            }
          }
        }
      }
      paramWkBrowserWebView.f().c();
      parama.a(paramWkBrowserWebView.f().a(localJSONObject.toString()));
      return;
    }
    catch (JSONException paramWkBrowserWebView)
    {
      for (;;)
      {
        paramWkBrowserWebView.printStackTrace();
      }
    }
  }
  
  public final void a(String paramString, q.a parama)
  {
    Object localObject1 = "";
    o localo = c.getServer();
    HashMap localHashMap;
    Object localObject2;
    if (localo != null)
    {
      localHashMap = new HashMap();
      localObject1 = localo.s();
      if (((HashMap)localObject1).size() > 0)
      {
        localObject1 = ((HashMap)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext()) {
          try
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject1).next();
            localHashMap.put((String)localEntry.getKey(), (String)localEntry.getValue());
          }
          catch (Exception localException1)
          {
            h.a(localException1);
          }
        }
      }
      localObject1 = "00300305";
      localObject2 = b.a(paramString);
      paramString = (String)localObject1;
      if (localObject2 != null)
      {
        paramString = (String)localObject1;
        if (((Map)localObject2).size() > 0)
        {
          paramString = ((Map)localObject2).get("pid");
          if (!(paramString instanceof String)) {
            break label246;
          }
        }
      }
    }
    label246:
    for (paramString = (String)paramString;; paramString = "00300305")
    {
      localObject1 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        try
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localHashMap.put((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
        }
        catch (Exception localException2)
        {
          h.a(localException2);
        }
      }
      localObject1 = z.b(localo.b(paramString, localHashMap));
      parama.a((String)localObject1);
      return;
    }
  }
  
  public final void b(String paramString, q.a parama)
  {
    Object localObject1 = "";
    o localo = c.getServer();
    HashMap localHashMap;
    Object localObject2;
    if (localo != null)
    {
      localHashMap = new HashMap();
      localObject2 = b.a(paramString);
      localObject1 = "00000000";
      paramString = (String)localObject1;
      if (localObject2 != null)
      {
        paramString = (String)localObject1;
        if (((Map)localObject2).size() > 0)
        {
          paramString = ((Map)localObject2).get("pid");
          if (!(paramString instanceof String)) {
            break label164;
          }
        }
      }
    }
    label164:
    for (paramString = (String)paramString;; paramString = "00000000")
    {
      localObject1 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject1).hasNext()) {
        try
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          localHashMap.put((String)((Map.Entry)localObject2).getKey(), (String)((Map.Entry)localObject2).getValue());
        }
        catch (Exception localException)
        {
          h.a(localException);
        }
      }
      localObject1 = z.b(localo.b(paramString, localHashMap));
      parama.a((String)localObject1);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */