package com.lantern.wifiseccheck.vpn.entity;

import android.content.ContentValues;
import android.net.Uri;

public class SVPNDetailEvent
  extends BaseEntity
{
  public static final int TYPE_APP_KILLED = 1;
  public static final int TYPE_GPRS_START = 7;
  public static final int TYPE_GPRS_STOP = 8;
  public static final int TYPE_PROTECT_GAME = 2;
  public static final int TYPE_PROTECT_PAY = 3;
  public static final int TYPE_VPN_START = 5;
  public static final int TYPE_VPN_STOP = 4;
  public static final int TYPE_WIFI_START = 5;
  public static final int TYPE_WIFI_STOP = 6;
  public static final Uri URI = Uri.parse("content://com.lantern.wifi.sec.provider/t_detail_event");
  private long createTime;
  private int id;
  private long parentCreateTime;
  private int parentID;
  private String parentSummary;
  private String summary;
  private int type;
  
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
  
  public long getParentCreateTime()
  {
    return this.parentCreateTime;
  }
  
  public int getParentID()
  {
    return this.parentID;
  }
  
  public String getParentSummary()
  {
    return this.parentSummary;
  }
  
  public String getSummary()
  {
    return this.summary;
  }
  
  public String getTableName()
  {
    return "t_detail_event";
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public void setCreateTime(long paramLong)
  {
    this.createTime = paramLong;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setParentCreateTime(long paramLong)
  {
    this.parentCreateTime = paramLong;
  }
  
  public void setParentID(int paramInt)
  {
    this.parentID = paramInt;
  }
  
  public void setParentSummary(String paramString)
  {
    this.parentSummary = paramString;
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
    localContentValues.put("summary", this.summary);
    localContentValues.put("type", Integer.valueOf(this.type));
    localContentValues.put("create_time", Long.valueOf(this.createTime));
    return localContentValues;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/entity/SVPNDetailEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */