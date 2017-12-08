package com.lantern.core.config;

import android.content.Context;
import android.text.TextUtils;
import com.bluefay.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public class StandbyIPConf
  extends a
{
  private HashMap<String, ArrayList<String>> e = new HashMap();
  private String f;
  private String g;
  
  public StandbyIPConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.f = paramJSONObject.optString("domain", "");
      this.g = paramJSONObject.optString("ips", "");
    }
  }
  
  private void d()
  {
    if ((TextUtils.isEmpty(this.g)) || (TextUtils.isEmpty(this.f))) {
      h.a("data is empty!", new Object[0]);
    }
    for (;;)
    {
      return;
      String[] arrayOfString2 = this.f.split("#");
      String[] arrayOfString1 = this.g.split("#");
      if (arrayOfString2.length != arrayOfString1.length)
      {
        h.a("length is not equals", new Object[0]);
      }
      else
      {
        this.e.clear();
        int k = arrayOfString2.length;
        for (int i = 0; i < k; i++)
        {
          String str = arrayOfString2[i];
          Object localObject = arrayOfString1[i];
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            localObject = ((String)localObject).split(",");
            ArrayList localArrayList = new ArrayList();
            int m = localObject.length;
            for (int j = 0; j < m; j++) {
              localArrayList.add(localObject[j]);
            }
            this.e.put(str, localArrayList);
          }
        }
      }
    }
  }
  
  public final ArrayList<String> a(String paramString)
  {
    return (ArrayList)this.e.get(paramString);
  }
  
  protected final void a()
  {
    this.e = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("120.132.58.121");
    localArrayList.add("120.132.58.122");
    this.e.put("wifiapi02.51y5.net", localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add("123.59.53.70");
    localArrayList.add("123.59.53.79");
    this.e.put("ap.51y5.net", localArrayList);
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
    d();
  }
  
  protected final void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
    d();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/StandbyIPConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */