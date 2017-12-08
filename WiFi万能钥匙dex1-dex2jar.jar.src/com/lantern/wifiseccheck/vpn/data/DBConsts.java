package com.lantern.wifiseccheck.vpn.data;

public final class DBConsts
{
  public static final String DB_NAME = "svpn_sdk.db";
  public static final int DB_VERSION = 2;
  public static final int DB_VERSION_1 = 1;
  public static final int DB_VERSION_2 = 2;
  
  public static final class Columns_DetailEvent
  {
    public static final String CREATE_TIME = "create_time";
    public static final String ID = "id";
    public static final String SUMMARY = "summary";
    public static final String TABLE_NAME = "t_detail_event";
    public static final String TYPE = "type";
  }
  
  public static final class Columns_MainEvent
  {
    public static final String BSSID = "bssid";
    public static final String CREATE_TIME = "create_time";
    public static final String ID = "id";
    public static final String SSID = "ssid";
    public static final String SUMMARY = "summary";
    public static final String TABLE_NAME = "t_main_event";
    public static final String TYPE = "type";
  }
  
  public static final class Columns_Preference
  {
    public static final String ID = "id";
    public static final String KEY = "key";
    public static final String TABLE_NAME = "t_preference";
    public static final String VALUE = "value";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/data/DBConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */