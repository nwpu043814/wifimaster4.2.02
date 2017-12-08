package com.lantern.core.location;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class WkLocationManager
{
  private static WkLocationManager sInstance;
  private ReentrantLock lock = new ReentrantLock();
  private ApplicationInfo mAppInfo;
  private ArrayList<BaseLocation> mLocationList = new ArrayList();
  private String mProvider = "";
  private String[] mProviders = null;
  
  private WkLocationManager(Context paramContext)
  {
    try
    {
      this.mAppInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      this.mProvider = this.mAppInfo.metaData.get("MAP_PROVIDER").toString();
      if (!TextUtils.isEmpty(this.mProvider))
      {
        if (this.mProvider.contains(" ")) {
          this.mProviders = this.mProvider.split(" ");
        }
      }
      else
      {
        if ((this.mProviders == null) || (this.mProviders.length <= 0)) {
          return;
        }
        for (;;)
        {
          if (i >= this.mProviders.length) {
            return;
          }
          if (!"B".equals(this.mProviders[i])) {
            break;
          }
          addLocationList("com.lantern.location.mapb.WkLocationManagerB", paramContext);
          i++;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        continue;
        this.mProviders = new String[] { this.mProvider };
        continue;
        if ("T".equals(this.mProviders[i])) {
          addLocationList("com.lantern.location.mapt.WkLocationManagerT", paramContext);
        } else if ("A".equals(this.mProviders[i])) {
          addLocationList("com.lantern.location.mapa.WkLocationManagerA", paramContext);
        } else if ("G".equals(this.mProviders[i])) {
          addLocationList("com.lantern.location.mapg.WkLocationManagerG", paramContext);
        } else if ("L".equals(this.mProviders[i])) {
          addLocationList("com.lantern.location.mapl.WkLocationManagerL", paramContext);
        }
      }
    }
  }
  
  private void addLocationList(String paramString, Context paramContext)
  {
    try
    {
      paramString = (BaseLocation)Class.forName(paramString).getConstructor(new Class[] { Context.class }).newInstance(new Object[] { paramContext });
      this.mLocationList.add(paramString);
      return;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (InstantiationException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (InvocationTargetException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static WkLocationManager getInstance(Context paramContext)
  {
    try
    {
      if (sInstance == null)
      {
        WkLocationManager localWkLocationManager = new com/lantern/core/location/WkLocationManager;
        localWkLocationManager.<init>(paramContext);
        sInstance = localWkLocationManager;
      }
      paramContext = sInstance;
      return paramContext;
    }
    finally {}
  }
  
  private LocationType getLocationType(String paramString)
  {
    if ("B".equals(paramString)) {
      paramString = LocationType.Baidu;
    }
    for (;;)
    {
      return paramString;
      if ("A".equals(paramString)) {
        paramString = LocationType.Amap;
      } else if ("T".equals(paramString)) {
        paramString = LocationType.Tencent;
      } else if ("G".equals(paramString)) {
        paramString = LocationType.Google;
      } else {
        paramString = null;
      }
    }
  }
  
  public void addLocationCallBack(LocationCallBack paramLocationCallBack)
  {
    if (this.mLocationList != null) {
      for (int i = 0; i < this.mLocationList.size(); i++) {
        ((BaseLocation)this.mLocationList.get(i)).addLocationCallBack(paramLocationCallBack);
      }
    }
  }
  
  public List<LocationBean> getLocationBeans()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mLocationList != null) {
      for (int i = 0; i < this.mLocationList.size(); i++) {
        localArrayList.add(((BaseLocation)this.mLocationList.get(i)).getLocationBean());
      }
    }
    return localArrayList;
  }
  
  public String getLocationCode(LocationType paramLocationType)
  {
    switch (1.a[paramLocationType.ordinal()])
    {
    default: 
      paramLocationType = "";
    }
    for (;;)
    {
      return paramLocationType;
      paramLocationType = "B";
      continue;
      paramLocationType = "A";
      continue;
      paramLocationType = "T";
      continue;
      paramLocationType = "G";
      continue;
      paramLocationType = "L";
    }
  }
  
  public void removeLocationCallBack(LocationCallBack paramLocationCallBack)
  {
    if (this.mLocationList != null) {
      for (int i = 0; i < this.mLocationList.size(); i++) {
        ((BaseLocation)this.mLocationList.get(i)).removeLocationCallBack(paramLocationCallBack);
      }
    }
  }
  
  public void startLocation(LocationCallBack paramLocationCallBack)
  {
    if ((this.mProviders != null) && (this.mProviders.length > 0)) {
      startLocation(paramLocationCallBack, getLocationType(this.mProviders[0]));
    }
  }
  
  public void startLocation(LocationCallBack paramLocationCallBack, LocationType paramLocationType)
  {
    this.lock.lock();
    if (this.mLocationList != null) {
      for (int i = 0; i < this.mLocationList.size(); i++)
      {
        BaseLocation localBaseLocation = (BaseLocation)this.mLocationList.get(i);
        if ((localBaseLocation != null) && (paramLocationType == localBaseLocation.getLocationType())) {
          localBaseLocation.startLocation(paramLocationCallBack);
        }
      }
    }
    this.lock.unlock();
  }
  
  public void startReportLocation(LocationCallBack paramLocationCallBack)
  {
    this.lock.lock();
    if (this.mLocationList != null) {
      for (int i = 0; i < this.mLocationList.size(); i++)
      {
        BaseLocation localBaseLocation = (BaseLocation)this.mLocationList.get(i);
        if (localBaseLocation != null) {
          localBaseLocation.startLocation(paramLocationCallBack);
        }
      }
    }
    this.lock.unlock();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/location/WkLocationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */