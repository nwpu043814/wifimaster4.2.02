package com.lantern.webox.a.a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.a.u;
import com.lantern.webox.a.u.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ai
  implements u
{
  public final void a(WkBrowserWebView paramWkBrowserWebView, u.a parama)
  {
    LinkedList localLinkedList = new LinkedList();
    paramWkBrowserWebView = ((WifiManager)paramWkBrowserWebView.getContext().getSystemService("wifi")).getScanResults();
    if ((paramWkBrowserWebView != null) && (paramWkBrowserWebView.size() > 0))
    {
      paramWkBrowserWebView = paramWkBrowserWebView.iterator();
      while (paramWkBrowserWebView.hasNext())
      {
        ScanResult localScanResult = (ScanResult)paramWkBrowserWebView.next();
        HashMap localHashMap = new HashMap();
        if ((!TextUtils.isEmpty(localScanResult.SSID)) && (!TextUtils.isEmpty(localScanResult.BSSID)))
        {
          localHashMap.put("ssid", localScanResult.SSID);
          localHashMap.put("bssid", localScanResult.BSSID);
          localLinkedList.add(localHashMap);
        }
      }
    }
    parama.a(localLinkedList);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */