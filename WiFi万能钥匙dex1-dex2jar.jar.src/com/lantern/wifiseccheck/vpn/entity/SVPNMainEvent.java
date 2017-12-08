package com.lantern.wifiseccheck.vpn.entity;

import android.content.ContentValues;
import android.net.Uri;

public class SVPNMainEvent
  extends BaseEntity
{
  public static final int TYPE_APP_START = 5;
  public static final int TYPE_APP_STOP = 6;
  public static final int TYPE_GPRS_START = 3;
  public static final int TYPE_GPRS_STOP = 4;
  public static final int TYPE_WIFI_START = 1;
  public static final int TYPE_WIFI_STOP = 2;
  public static final Uri URI = Uri.parse("content://com.lantern.wifi.sec.provider/t_main_event");
  private String bssid;
  private long createTime;
  private int id;
  private String ssid;
  private String summary;
  private int type;
  
  public String getBssid()
  {
    return this.bssid;
  }
  
  public Uri getContentUri()
  {
    return URI;
  }
  
  public long getCreateTime()
  {
    return this.createTime;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public String getSummary()
  {
    return this.summary;
  }
  
  public String getTableName()
  {
    return "t_main_event";
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setBssid(String paramString)
  {
    this.bssid = paramString;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
  
  public void setSummary(String paramString)
  {
    this.summary = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public ContentValues toContentValues()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("bssid", this.bssid);
    localContentValues.put("ssid", this.ssid);
    localContentValues.put("type", Integer.valueOf(this.type));
    localContentValues.put("create_time", Long.valueOf(this.createTime));
    localContentValues.put("summary", this.summary);
    return localContentValues;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/entity/SVPNMainEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */