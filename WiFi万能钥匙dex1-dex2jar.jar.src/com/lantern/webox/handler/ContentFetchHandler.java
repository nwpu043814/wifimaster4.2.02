package com.lantern.webox.handler;

import android.content.Context;
import android.content.res.Resources;
import com.bluefay.b.h;
import com.lantern.browser.R.raw;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.event.WebEvent;

public class ContentFetchHandler
  extends a
{
  public ContentFetchHandler(WkBrowserWebView paramWkBrowserWebView)
  {
    super(paramWkBrowserWebView);
    paramWkBrowserWebView.a("jsi:wifikey_get_content", new ContentCallback());
  }
  
  private void loadContent()
  {
    try
    {
      String str = com.lantern.webox.c.a.a(this.webox.getContext().getResources().openRawResource(R.raw.get_content));
      WkBrowserWebView localWkBrowserWebView = this.webox;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("javascript:");
      localWkBrowserWebView.loadUrl(str);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  public void onWebEvent(WebEvent paramWebEvent)
  {
    super.onWebEvent(paramWebEvent);
    if (paramWebEvent.getType() == 5) {
      loadContent();
    }
  }
  
  public class ContentCallback
  {
    public ContentCallback() {}
    
    public void onContent(String paramString)
    {
      ContentFetchHandler.this.webox.a("page_content", paramString);
      ContentFetchHandler.this.webox.a(new WebEvent(ContentFetchHandler.this.webox, 6, paramString));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/handler/ContentFetchHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */