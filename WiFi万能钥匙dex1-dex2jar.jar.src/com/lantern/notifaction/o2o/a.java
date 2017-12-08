package com.lantern.notifaction.o2o;

import android.text.TextUtils;
import com.bluefay.b.d;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.g;
import com.lantern.core.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  public static String a()
  {
    HashMap localHashMap = b();
    localHashMap.put("sign", g.a(localHashMap, "werr#$%adfssf@ss"));
    h.a("params:%s", new Object[] { a(localHashMap) });
    return d.a("http://api.o2o.lianwifi.com/client/status.do", localHashMap);
  }
  
  static String a(HashMap<String, String> paramHashMap)
  {
    if (paramHashMap == null) {}
    StringBuilder localStringBuilder;
    for (paramHashMap = "";; paramHashMap = localStringBuilder.toString())
    {
      return paramHashMap;
      localStringBuilder = new StringBuilder();
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        localStringBuilder.append("&");
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        localStringBuilder.append((String)localEntry.getValue());
      }
      if (localStringBuilder.length() > 0) {
        localStringBuilder.deleteCharAt(0);
      }
    }
  }
  
  public static HashMap<String, String> b()
  {
    HashMap localHashMap2 = c.getServer().s();
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("capBssid", localHashMap2.get("capBssid"));
    localHashMap1.put("capSsid", localHashMap2.get("capSsid"));
    String str2 = (String)localHashMap2.get("dhid");
    String str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      str1 = str2.trim();
    }
    localHashMap1.put("dhid", str1);
    localHashMap1.put("uhid", localHashMap2.get("uhid"));
    localHashMap1.put("chanId", localHashMap2.get("chanId"));
    localHashMap1.put("longi", localHashMap2.get("longi"));
    localHashMap1.put("lati", localHashMap2.get("lati"));
    localHashMap1.put("imei", localHashMap2.get("imei"));
    localHashMap1.put("mapSP", localHashMap2.get("mapSP"));
    localHashMap1.put("verCode", localHashMap2.get("verCode"));
    localHashMap1.put("sourceFrom", "1");
    localHashMap1.put("ts", String.valueOf(System.currentTimeMillis()));
    h.a("%s", new Object[] { a(localHashMap1) });
    return localHashMap1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/notifaction/o2o/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */