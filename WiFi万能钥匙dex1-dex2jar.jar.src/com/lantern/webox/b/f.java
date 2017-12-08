package com.lantern.webox.b;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.a;
import com.lantern.webox.c.d;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public final class f
{
  private static final Collection<String> a = Arrays.asList(new String[] { "getClass", "hashCode", "notify", "notifyAll", "equals", "toString", "wait" });
  private e b = new e(getClass());
  
  public static Object a(WkBrowserWebView paramWkBrowserWebView, Map<String, Object> paramMap)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramMap == null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      return localObject1;
      Object localObject4 = paramMap.get("service");
      localObject1 = localObject2;
      if (localObject4 == null) {
        continue;
      }
      Object localObject3 = paramWkBrowserWebView.a("jsi:" + localObject4);
      if (localObject3 == null)
      {
        new StringBuilder("can not find service named ").append(localObject4);
        localObject1 = localObject2;
        continue;
      }
      localObject4 = paramMap.get("method");
      localObject1 = localObject2;
      if (localObject4 == null) {
        continue;
      }
      localObject1 = localObject2;
      if (a.contains(localObject4)) {
        continue;
      }
      localObject1 = localObject2;
      if (!a.a(paramWkBrowserWebView.getContext(), paramWkBrowserWebView.getUrl(), (String)localObject4)) {
        continue;
      }
      try
      {
        paramWkBrowserWebView = localObject3.getClass();
        localObject1 = localObject4.toString();
        paramMap = paramMap.get("param");
        paramWkBrowserWebView = d.a(localObject3, paramWkBrowserWebView, (String)localObject1, new Class[] { String.class }, new Object[] { paramMap });
        localObject1 = paramWkBrowserWebView;
      }
      catch (Exception paramWkBrowserWebView)
      {
        for (;;)
        {
          paramWkBrowserWebView = null;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */