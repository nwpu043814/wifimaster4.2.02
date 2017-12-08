package com.lantern.webox.domain;

import com.bluefay.b.h;
import java.util.Map;

public class AppStoreQuery
{
  private String apkURL;
  private String appHid;
  private String completedURL;
  private String dPos;
  private String icon;
  private String installedURL;
  private String packageName;
  private int pageIndex;
  private int position;
  private String readableId;
  private String storeId;
  private int tab;
  private String title;
  
  public AppStoreQuery() {}
  
  public AppStoreQuery(Map<String, Object> paramMap)
  {
    this.title = getStr(paramMap, new String[] { "title" });
    this.storeId = getStr(paramMap, new String[] { "storeId" });
    this.readableId = getStr(paramMap, new String[] { "readableId" });
    this.pageIndex = getInt(paramMap, "pageIndex");
    this.position = getInt(paramMap, "position");
    this.dPos = getStr(paramMap, new String[] { "dPos" });
    this.appHid = getStr(paramMap, new String[] { "hid", "appHid" });
    this.packageName = getStr(paramMap, new String[] { "packageName", "pkgName", "pkg" });
    this.icon = getStr(paramMap, new String[] { "icon" });
    this.tab = getInt(paramMap, "tab");
    this.apkURL = getStr(paramMap, new String[] { "apkURL" });
    this.completedURL = getStr(paramMap, new String[] { "completedURL" });
    this.installedURL = getStr(paramMap, new String[] { "installedURL" });
  }
  
  private int getInt(Map<String, Object> paramMap, String paramString)
  {
    for (int i = 0;; i = j)
    {
      try
      {
        paramMap = paramMap.get(paramString);
        if (paramMap != null) {
          break label16;
        }
      }
      catch (Exception paramMap)
      {
        for (;;)
        {
          label16:
          int j;
          h.a(paramMap);
        }
      }
      return i;
      j = Integer.parseInt(paramMap.toString());
    }
  }
  
  private String getStr(Map<String, Object> paramMap, String... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        int j = paramVarArgs.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        Object localObject = paramMap.get(paramVarArgs[i]);
        if (localObject == null) {
          continue;
        }
        paramMap = localObject.toString();
      }
      catch (Exception paramMap)
      {
        int i;
        h.a(paramMap);
        paramMap = "";
        continue;
      }
      return paramMap;
      i++;
    }
  }
  
  public String getApkURL()
  {
    return this.apkURL;
  }
  
  public String getAppHid()
  {
    return this.appHid;
  }
  
  public String getCompletedURL()
  {
    return this.completedURL;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public String getInstalledURL()
  {
    return this.installedURL;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public int getPageIndex()
  {
    return this.pageIndex;
  }
  
  public int getPosition()
  {
    return this.position;
  }
  
  public String getReadableId()
  {
    return this.readableId;
  }
  
  public String getStoreId()
  {
    return this.storeId;
  }
  
  public int getTab()
  {
    return this.tab;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getdPos()
  {
    return this.dPos;
  }
  
  public void setApkURL(String paramString)
  {
    this.apkURL = paramString;
  }
  
  public void setAppHid(String paramString)
  {
    this.appHid = paramString;
  }
  
  public void setCompletedURL(String paramString)
  {
    this.completedURL = paramString;
  }
  
  public void setIcon(String paramString)
  {
    this.icon = paramString;
  }
  
  public void setInstalledURL(String paramString)
  {
    this.installedURL = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setPageIndex(int paramInt)
  {
    this.pageIndex = paramInt;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void setReadableId(String paramString)
  {
    this.readableId = paramString;
  }
  
  public void setStoreId(String paramString)
  {
    this.storeId = paramString;
  }
  
  public void setTab(int paramInt)
  {
    this.tab = paramInt;
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
  }
  
  public void setdPos(String paramString)
  {
    this.dPos = paramString;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "[hid=" + this.appHid + ",pkg=" + this.packageName + "]";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/domain/AppStoreQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */