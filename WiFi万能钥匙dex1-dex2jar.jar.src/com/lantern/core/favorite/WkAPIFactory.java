package com.lantern.core.favorite;

import android.content.Context;

public class WkAPIFactory
{
  public static IWkAPI createIWkAPI(Context paramContext)
  {
    return new WkAPIImpl(paramContext);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/favorite/WkAPIFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */