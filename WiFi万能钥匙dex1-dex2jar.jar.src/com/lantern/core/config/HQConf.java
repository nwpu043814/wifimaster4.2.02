package com.lantern.core.config;

import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class HQConf
  extends a
{
  private ArrayList<HqAppInfo> e;
  private boolean f;
  
  public HQConf(Context paramContext)
  {
    super(paramContext);
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      this.f = paramJSONObject.optBoolean("backgroundAllowed");
      paramJSONObject = paramJSONObject.optJSONArray("list");
    } while ((paramJSONObject == null) || (paramJSONObject.length() == 0));
    if (this.e == null) {
      this.e = new ArrayList();
    }
    for (;;)
    {
      int i = 0;
      int j = paramJSONObject.length();
      while (i < j)
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
        if ((localJSONObject != null) && (localJSONObject.length() != 0))
        {
          HqAppInfo localHqAppInfo = new HqAppInfo();
          HqAppInfo.access$002(localHqAppInfo, localJSONObject.optString("action", ""));
          HqAppInfo.access$102(localHqAppInfo, localJSONObject.optString("pan", ""));
          HqAppInfo.access$202(localHqAppInfo, localJSONObject.optString("param", ""));
          HqAppInfo.access$302(localHqAppInfo, localJSONObject.optString("service", ""));
          HqAppInfo.access$402(localHqAppInfo, localJSONObject.optString("serviceprocess", ""));
          HqAppInfo.access$502(localHqAppInfo, localJSONObject.optString("level", "1"));
          this.e.add(localHqAppInfo);
        }
        i++;
      }
      break;
      this.e.clear();
    }
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
  }
  
  protected final void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
    com.lantern.analytics.a.e().onEvent("cacon");
  }
  
  public final boolean d()
  {
    return this.f;
  }
  
  public final ArrayList<HqAppInfo> e()
  {
    return this.e;
  }
  
  public static class HqAppInfo
  {
    private String mAction;
    private String mLevel;
    private String mPackageName;
    private String mParam;
    private String mServiceName;
    private String mServiceProcess;
    
    public String getAction()
    {
      return this.mAction;
    }
    
    public String getPackageName()
    {
      return this.mPackageName;
    }
    
    public String getParam()
    {
      return this.mParam;
    }
    
    public String getServiceName()
    {
      return this.mServiceName;
    }
    
    public String getServiceProcess()
    {
      return this.mServiceProcess;
    }
    
    public String getmLevel()
    {
      return this.mLevel;
    }
    
    public void setAction(String paramString)
    {
      this.mAction = paramString;
    }
    
    public void setPackageName(String paramString)
    {
      this.mPackageName = paramString;
    }
    
    public void setParam(String paramString)
    {
      this.mParam = paramString;
    }
    
    public void setServiceName(String paramString)
    {
      this.mServiceName = paramString;
    }
    
    public void setServiceProcess(String paramString)
    {
      this.mServiceProcess = paramString;
    }
    
    public void setmLevel(String paramString)
    {
      this.mLevel = paramString;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/HQConf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */