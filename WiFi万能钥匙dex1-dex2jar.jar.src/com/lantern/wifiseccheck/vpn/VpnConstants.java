package com.lantern.wifiseccheck.vpn;

public class VpnConstants
{
  public static final String ACTION_BROWSER = "wifi.intent.action.BROWSER";
  public static final int CODE_REQUEST_CONNECT_PREPARE = 1;
  public static final int CODE_REQUEST_START_REGIST = 3;
  public static final String PREF_KEY_LATITUDE = "pref_key_latitude";
  public static final String PREF_KEY_LONGITUDE = "pref_key_longitude";
  public static final String PREF_KEY_VPN_CONNECTED_LIFE = "vpn_connected_life";
  public static final String PREF_KEY_VPN_FIRST_DISCONNECTION = "vpn_first_disconnection";
  public static final String REMOTE_GET_BASE_URL = "http://vpn.swaqds.com:8080";
  public static final String REMOTE_GET_PARAMS = "http://conf.swaqds.com:8080/SafeVpnConfiguration/app-config/get_v2";
  public static final String REMOTE_GET_PARAMS_URL = "http://vpn.swaqds.com:8080/vpn/auth";
  public static final String REMOTE_REQUEST_SERVER_BASE_URL = "http://conf.swaqds.com:8080/";
  public static final String VPN_RULE_NAME = "vpn_rule";
  
  public static class Action
  {
    public static String ACTION_CLOSE_VPN_CLOSE;
    public static String ACTION_MAIN_PARAMS_CHANGED;
    public static String ACTION_REPEAT;
    public static String ACTION_START_GLOBAL_SERVICE_EX;
    public static String ACTION_START_VPN_SERVICE = "com.lantern.safecommand.VPN_SERVICE";
    public static String ACTION_TOGGLE_FLOAT_WINDOW;
    public static String ACTION_UPDATE_FRAGMENT;
    public static String ACTION_UPDATE_PREFS;
    public static String ACTION_UPDATE_VPN_STATE;
    public static String EXTRA_APPLIST_CHANGE;
    public static String EXTRA_AUTO_RESTART;
    public static String EXTRA_FILTER_RULE_CHANGE = "filter_rule_change";
    public static String EXTRA_IS_SHOW_BUTTON_CHANGE;
    public static final String LOG_OFF = "com.notifications.intent.action.LogSwitchOff";
    public static final String LOG_ON = "com.notifications.intent.action.LogSwitchOn";
    
    static
    {
      ACTION_CLOSE_VPN_CLOSE = "com.lantern.safecommand.VPN_CLOSE";
      ACTION_UPDATE_FRAGMENT = "com.lantern.safecommand.ACTION_UPDATE_FRAGMENT";
      ACTION_UPDATE_PREFS = "com.lantern.safecommand.ACTION_UPDATE_PREFS";
      ACTION_UPDATE_VPN_STATE = "com.lantern.safecoommand.ACTION_VPN_STATE";
      ACTION_TOGGLE_FLOAT_WINDOW = "com.lantern.safecoommand.TOGGLE_FLOAT_WINDOW_ACTION";
      ACTION_REPEAT = "com.lantern.safecoommand.REPEAT_START";
      EXTRA_AUTO_RESTART = "auto_restart";
      ACTION_MAIN_PARAMS_CHANGED = "com.lantern.safecommand.PARAMS_CHANGED";
      ACTION_START_GLOBAL_SERVICE_EX = "com.lantern.safecommand.START_VPN_SERVICE";
      EXTRA_APPLIST_CHANGE = "app_list_change";
      EXTRA_IS_SHOW_BUTTON_CHANGE = "is_show_button_change";
    }
  }
  
  public static class PrefKeyUser
  {
    public static final String PREF_CONNECTING_STRING = "connecting_string";
    public static final String PREF_KEY_ANTO_START_ACTIVITY = "anto_start_activity";
    public static final String PREF_KEY_APP_PARAMS = "app_params";
    public static final String PREF_KEY_DHID = "dhid";
    public static final String PREF_KEY_FIRST_STARTED_VPN = "first_started_vpn";
    public static final String PREF_KEY_FLOW_SAVEisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAutoisVpnStartAuto = "flow_save";
    public static final String PREF_KEY_INVITE = "invite";
    public static final String PREF_KEY_ISVPNSTART = "is_vpn_start";
    public static final String PREF_KEY_ISVPNSTART_AUTO = "is_vpn_start_auto";
    public static final String PREF_KEY_IS_NO_DISTRUB_TIME_END = "no_distrub_time_end";
    public static final String PREF_KEY_IS_NO_DISTRUB_TIME_START = "no_distrub_time_start";
    public static final String PREF_KEY_IS_SETTING_AUTO_START_Permission = "is_setting_auto_start_Permission";
    public static final String PREF_KEY_LOG = "log";
    public static final String PREF_KEY_PACKAGE_NAME = "package_name";
    public static final String PREF_KEY_PHONENUM = "phone";
    public static final String PREF_KEY_Permission_IS_PASS = "Permission_is_pass";
    public static final String PREF_KEY_RED_PACKETS_HELP_OPEN = "red_packets_help_open";
    public static final String PREF_KEY_RED_RED_PACKETS_COUNT = "red_packets_count";
    public static final String PREF_KEY_RED_RED_PACKETS_NO_DISTURB_SETTING = "red_packets_no_disturb_setting";
    public static final String PREF_KEY_RED_RED_PACKETS_VIBRATOR = "red_packets_vibrator";
    public static final String PREF_KEY_RED_RED_PACKETS_VOICE_CLOSE = "red_packets_voice_close";
    public static final String PREF_KEY_RED_RED_PACKETS_VOICE_QHB = "red_packets_voice_qhb";
    public static final String PREF_KEY_RED_RED_PACKETS_VOICE_SKJ = "red_packets_voice_skj";
    public static final String PREF_KEY_RED_RED_PACKETS_WARNING_AUTO_OPEN_APP = "red_packets_warning_auto_open_app";
    public static final String PREF_KEY_RED_RED_PACKETS_WARNING_LOCK_SCREEN = "red_packets_warning_lock_screen";
    public static final String PREF_KEY_SERVICE_USER_STATE = "service_user_state";
    public static final String PREF_KEY_SSID = "ssid";
    public static final String PREF_KEY_SYSTEM_PARAMS = "system_params";
    public static final String PREF_KEY_UHID = "uhid";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/VpnConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */