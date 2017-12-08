package com.lantern.core.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private Long a;
  private ArrayList<String> b;
  
  public c()
  {
    Object localObject2 = new SimpleDateFormat("yyyy-MM-dd");
    Object localObject1 = null;
    try
    {
      Date localDate = new java/util/Date;
      localDate.<init>();
      localObject2 = ((SimpleDateFormat)localObject2).parse(((SimpleDateFormat)localObject2).format(localDate));
      localObject1 = localObject2;
    }
    catch (ParseException localParseException)
    {
      for (;;) {}
    }
    this.a = Long.valueOf(((Date)localObject1).getTime());
    this.b = new ArrayList();
  }
  
  public c(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      a(localJSONObject);
      return;
    }
    catch (JSONException paramString)
    {
      for (;;) {}
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    this.a = Long.valueOf(paramJSONObject.optLong("mDataTime"));
    this.b = new ArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("mLunchedAppName");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      int j = paramJSONObject.length();
      while (i < j)
      {
        String str = paramJSONObject.optString(i);
        this.b.add(str);
        i++;
      }
    }
  }
  
  public final ArrayList<String> a()
  {
    return this.b;
  }
  
  public final boolean b()
  {
    boolean bool;
    if (this.a == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Object localObject = null;
      try
      {
        Date localDate = new java/util/Date;
        localDate.<init>();
        localDate = localSimpleDateFormat.parse(localSimpleDateFormat.format(localDate));
        localObject = localDate;
      }
      catch (ParseException localParseException)
      {
        long l;
        for (;;) {}
      }
      l = ((Date)localObject).getTime();
      if (this.a.longValue() - Long.valueOf(l).longValue() == 0L) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("mDataTime", this.a);
    localHashMap.put("mLunchedAppName", this.b);
    return new JSONObject(localHashMap).toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/model/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */