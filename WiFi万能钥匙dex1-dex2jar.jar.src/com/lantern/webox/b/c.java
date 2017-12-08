package com.lantern.webox.b;

import android.util.Base64;
import android.webkit.WebView;
import com.lantern.webox.c.b;

public final class c
{
  private boolean a = false;
  private e b = new e(getClass());
  
  private String a(Object paramObject)
  {
    if (paramObject == null) {
      paramObject = "null";
    }
    for (;;)
    {
      return (String)paramObject;
      if (paramObject.getClass().isPrimitive()) {
        paramObject = String.valueOf(paramObject);
      } else if (Integer.class.isInstance(paramObject)) {
        paramObject = String.valueOf(paramObject);
      } else if (Long.class.isInstance(paramObject)) {
        paramObject = String.valueOf(paramObject);
      } else if (Boolean.class.isInstance(paramObject)) {
        paramObject = String.valueOf(paramObject);
      } else if (Character.class.isInstance(paramObject)) {
        paramObject = String.valueOf(paramObject);
      } else if ((paramObject instanceof String)) {
        paramObject = "'" + a((String)paramObject) + "'";
      } else {
        paramObject = "'" + a(b.a(paramObject)) + "'";
      }
    }
  }
  
  private String a(String paramString)
  {
    if (!this.a) {}
    for (;;)
    {
      return paramString;
      try
      {
        byte[] arrayOfByte = Base64.encode(paramString.getBytes("utf-8"), 0);
        paramString = new java/lang/String;
        paramString.<init>(arrayOfByte, "utf-8");
        paramString = paramString.replaceAll("\n", "");
      }
      catch (Exception paramString)
      {
        throw new RuntimeException("encode param error", paramString);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public final boolean a(WebView paramWebView, Object paramObject1, Object paramObject2)
  {
    return a(paramWebView, paramObject1, paramObject2, 0L);
  }
  
  public final boolean a(WebView paramWebView, Object paramObject1, Object paramObject2, long paramLong)
  {
    boolean bool1;
    if ((paramObject1 == null) || (paramObject1.equals("undefined")) || (paramObject1.equals("null"))) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      boolean bool2 = paramWebView.postDelayed(new d(this, paramObject1, paramWebView, paramObject2), paramLong);
      bool1 = bool2;
      if (!bool2)
      {
        new StringBuilder("can not post js invoke to ui thread.@").append(paramWebView.getUrl());
        bool1 = bool2;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */