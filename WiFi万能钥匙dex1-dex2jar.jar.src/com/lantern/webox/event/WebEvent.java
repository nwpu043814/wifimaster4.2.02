package com.lantern.webox.event;

import android.webkit.WebView;

public class WebEvent
{
  public static final int TYPE_APP_CONFIG_LOADED = 8;
  public static final int TYPE_AUTHZ_AUTO = 105;
  public static final int TYPE_AUTHZ_CODE_RECEIVED = 104;
  public static final int TYPE_AUTHZ_ERROR = 102;
  public static final int TYPE_AUTHZ_MANUAL = 105;
  public static final int TYPE_AUTHZ_MSG = 103;
  public static final int TYPE_AUTHZ_SUCCESS = 101;
  public static final int TYPE_CLOSE_WINDOW = 10;
  public static final String TYPE_FEED_COMPLETED = "feedCompleted";
  public static final int TYPE_HTML_LOAD = 6;
  public static final int TYPE_JS_EVENT = 200;
  public static final int TYPE_LOAD = 0;
  public static final int TYPE_PAGE_FINISHED = 5;
  public static final int TYPE_PAGE_STARTED = 4;
  public static final int TYPE_PROGRESS = 1;
  public static final int TYPE_RECEIVED_ERROR = 9;
  public static final int TYPE_RECEIVED_HTTPCODE_ERROR = 12;
  public static final int TYPE_RECEIVED_ICON = 2;
  public static final int TYPE_RECEIVED_TITLE = 3;
  public static final int TYPE_S2J_EVENT = 300;
  public static final String TYPE_STATUS_CHANGE = "appChange";
  public static final int TYPE_UPDATE_HISTORY = 11;
  public static final int TYPE_VIEW_DESTROY = 7;
  private Object data;
  private int type;
  private WebView view;
  
  public WebEvent(WebView paramWebView, int paramInt)
  {
    this(paramWebView, paramInt, null);
  }
  
  public WebEvent(WebView paramWebView, int paramInt, Object paramObject)
  {
    this.view = paramWebView;
    this.type = paramInt;
    this.data = paramObject;
  }
  
  public Object getData()
  {
    return this.data;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public WebView getView()
  {
    return this.view;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/event/WebEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */