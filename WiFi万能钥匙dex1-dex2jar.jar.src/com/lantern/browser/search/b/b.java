package com.lantern.browser.search.b;

import com.bluefay.b.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public final class b
{
  public static List<c> a(String paramString)
  {
    localArrayList = new ArrayList();
    try
    {
      JSONArray localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>(paramString);
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        paramString = new com/lantern/browser/search/b/c;
        paramString.<init>();
        paramString.a = localJSONArray.getString(i);
        localArrayList.add(paramString);
      }
      return localArrayList;
    }
    catch (Exception paramString)
    {
      h.a(paramString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */