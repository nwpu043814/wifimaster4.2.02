package com.lantern.core.config;

import android.content.Context;
import com.bluefay.b.h;
import java.util.ArrayList;
import org.json.JSONObject;

public class TrafficMonitorConfig
  extends a
{
  private ArrayList<MonApp> e;
  
  public TrafficMonitorConfig(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a(JSONObject paramJSONObject) {}
  
  protected final void b(JSONObject paramJSONObject)
  {
    if (this.e == null) {}
    for (paramJSONObject = "is null";; paramJSONObject = Integer.valueOf(this.e.size()))
    {
      h.b("updated apps size:%s", new Object[] { paramJSONObject });
      if ((this.e != null) && (this.e.size() > 0)) {
        h.b("the first app packageName:%s", new Object[] { ((MonApp)this.e.get(0)).getPkgName() });
      }
      return;
    }
  }
  
  public final ArrayList<MonApp> d()
  {
    return this.e;
  }
  
  public static class MonApp
  {
    private String endTime;
    private long interval;
    private long minTraffic;
    private String pkgName;
    private String startTime;
    private int warnTimes;
    
    public String getEndTime()
    {
      return this.endTime;
    }
    
    public long getInterval()
    {
      return this.interval;
    }
    
    public long getMinTraffic()
    {
      return this.minTraffic;
    }
    
    public String getPkgName()
    {
      return this.pkgName;
    }
    
    public String getStartTime()
    {
      return this.startTime;
    }
    
    public int getWarnTimes()
    {
      return this.warnTimes;
    }
    
    public void setEndTime(String paramString)
    {
      this.endTime = paramString;
    }
    
    public void setInterval(long paramLong)
    {
      this.interval = paramLong;
    }
    
    public void setMinTraffic(long paramLong)
    {
      this.minTraffic = paramLong;
    }
    
    public void setPkgName(String paramString)
    {
      this.pkgName = paramString;
    }
    
    public void setStartTime(String paramString)
    {
      this.startTime = paramString;
    }
    
    public void setWarnTimes(int paramInt)
    {
      this.warnTimes = paramInt;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/TrafficMonitorConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */