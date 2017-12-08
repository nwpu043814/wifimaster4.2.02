package com.linksure.apservice.utils.text;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;

public class ApsURLSpan
  extends URLSpan
{
  public ApsURLSpan(String paramString)
  {
    super(paramString);
  }
  
  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    paramView = new Intent("wifi.intent.action.BROWSER", Uri.parse(getURL()));
    paramView.setPackage(localContext.getPackageName());
    try
    {
      localContext.startActivity(paramView);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        Log.w("URLSpan", "Actvity was not found for intent, " + paramView.toString());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/utils/text/ApsURLSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */