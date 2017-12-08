package com.lantern.location.mapt;

import android.content.Context;
import com.bluefay.b.h;
import com.lantern.core.g.j;
import com.lantern.core.location.BaseLocation;
import com.lantern.core.location.LocationBean;
import com.lantern.core.location.LocationCallBack;
import com.lantern.core.location.LocationType;
import com.lantern.core.model.WkAccessPoint;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class WkLocationManagerT
  extends BaseLocation
{
  private Context mAppContext;
  private HashMap<WkAccessPoint, LocationBean> mCaches;
  private ArrayList<LocationCallBack> mHookCb = new ArrayList();
  private TencentLocation mLocData = null;
  private long mLocTime = 0L;
  private TencentLocationManager mLocationManager;
  private ReentrantLock mLock = new ReentrantLock();
  private volatile boolean mSaveData = true;
  private TencentLocationListener mTListener = new a(this);
  
  public WkLocationManagerT(Context paramContext)
  {
    this.mAppContext = paramContext.getApplicationContext();
    this.mCaches = new HashMap();
    try
    {
      this.mLocationManager = TencentLocationManager.getInstance(paramContext.getApplicationContext());
      this.mLocationManager.setCoordinateType(1);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  private void clearCallBack()
  {
    this.mHookCb = new ArrayList();
  }
  
  private static LocationBean convert(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {}
    LocationBean localLocationBean;
    for (paramTencentLocation = null;; paramTencentLocation = localLocationBean)
    {
      return paramTencentLocation;
      localLocationBean = new LocationBean();
      localLocationBean.setLat(paramTencentLocation.getLatitude());
      localLocationBean.setLon(paramTencentLocation.getLongitude());
      localLocationBean.setAddress(paramTencentLocation.getAddress());
      localLocationBean.setType(LocationType.Tencent);
    }
  }
  
  private LocationBean findCache(LocationCallBack paramLocationCallBack)
  {
    Object localObject = null;
    paramLocationCallBack = null;
    WkAccessPoint localWkAccessPoint = j.b(this.mAppContext);
    if (localWkAccessPoint == null) {}
    for (;;)
    {
      return paramLocationCallBack;
      this.mLock.lock();
      paramLocationCallBack = (LocationCallBack)localObject;
      if (this.mCaches.containsKey(localWkAccessPoint))
      {
        paramLocationCallBack = (LocationBean)this.mCaches.get(localWkAccessPoint);
        h.b("found cache ap:%s, loc:%s", new Object[] { localWkAccessPoint, paramLocationCallBack });
      }
      this.mLock.unlock();
    }
  }
  
  private void locationChanged(TencentLocation paramTencentLocation)
  {
    this.mLock.lock();
    if ((this.mSaveData) && (paramTencentLocation != null) && (paramTencentLocation.getLatitude() > 1.0D) && (paramTencentLocation.getLongitude() > 1.0D))
    {
      this.mLocTime = System.currentTimeMillis();
      this.mLocData = paramTencentLocation;
      this.mSaveData = false;
    }
    if (this.mHookCb != null)
    {
      int j = this.mHookCb.size();
      if (j > 0)
      {
        if (paramTencentLocation == null) {
          for (i = 0; i < j; i++) {
            ((LocationCallBack)this.mHookCb.get(i)).callback(null);
          }
        }
        LocationBean localLocationBean = new LocationBean();
        localLocationBean.setLat(paramTencentLocation.getLatitude());
        localLocationBean.setLon(paramTencentLocation.getLongitude());
        localLocationBean.setAddress(paramTencentLocation.getAddress());
        localLocationBean.setType(LocationType.Tencent);
        for (int i = 0; i < j; i++) {
          ((LocationCallBack)this.mHookCb.get(i)).callback(localLocationBean);
        }
        clearCallBack();
      }
    }
    this.mLock.unlock();
  }
  
  private void putCache(LocationBean paramLocationBean)
  {
    WkAccessPoint localWkAccessPoint = j.b(this.mAppContext);
    if (localWkAccessPoint == null) {}
    for (;;)
    {
      return;
      if (paramLocationBean != null)
      {
        this.mLock.lock();
        this.mCaches.put(localWkAccessPoint, paramLocationBean);
        this.mLock.unlock();
      }
    }
  }
  
  public void addCallBack(LocationCallBack paramLocationCallBack)
  {
    int j = 0;
    if (paramLocationCallBack == null) {}
    for (;;)
    {
      return;
      this.mLock.lock();
      int k = this.mHookCb.size();
      for (int i = 0; i < k; i++) {
        if (this.mHookCb.get(i) == paramLocationCallBack) {
          j = 1;
        }
      }
      if (j == 0) {
        this.mHookCb.add(paramLocationCallBack);
      }
      this.mLock.unlock();
    }
  }
  
  public void addLocationCallBack(LocationCallBack paramLocationCallBack)
  {
    int j = 0;
    if (paramLocationCallBack == null) {}
    for (;;)
    {
      return;
      this.mLock.lock();
      int k = this.mHookCb.size();
      for (int i = 0; i < k; i++) {
        if (this.mHookCb.get(i) == paramLocationCallBack) {
          j = 1;
        }
      }
      if (j == 0) {
        this.mHookCb.add(paramLocationCallBack);
      }
      this.mLock.unlock();
    }
  }
  
  public LocationBean getLocationBean()
  {
    LocationBean localLocationBean = new LocationBean();
    if (this.mLocData != null)
    {
      localLocationBean.setLat(this.mLocData.getLatitude());
      localLocationBean.setLon(this.mLocData.getLongitude());
      localLocationBean.setAddress(this.mLocData.getAddress());
    }
    localLocationBean.setType(LocationType.Tencent);
    return localLocationBean;
  }
  
  public LocationType getLocationType()
  {
    return LocationType.Tencent;
  }
  
  public void removeCallBack(LocationCallBack paramLocationCallBack)
  {
    if (paramLocationCallBack == null) {}
    for (;;)
    {
      return;
      this.mLock.lock();
      int j = this.mHookCb.size();
      for (int i = 0; i < j; i++) {
        if (this.mHookCb.get(i) == paramLocationCallBack) {
          this.mHookCb.remove(i);
        }
      }
      this.mLock.unlock();
    }
  }
  
  public void removeLocationCallBack(LocationCallBack paramLocationCallBack)
  {
    if (paramLocationCallBack == null) {}
    for (;;)
    {
      return;
      this.mLock.lock();
      int k = this.mHookCb.size();
      int i = 0;
      int j = -1;
      while (i < k)
      {
        if (this.mHookCb.get(i) == paramLocationCallBack) {
          j = i;
        }
        i++;
      }
      if (j != -1) {
        this.mHookCb.remove(j);
      }
      this.mLock.unlock();
    }
  }
  
  public void startLocation(LocationCallBack paramLocationCallBack)
  {
    LocationBean localLocationBean = findCache(paramLocationCallBack);
    if (localLocationBean != null) {
      paramLocationCallBack.callback(localLocationBean);
    }
    for (;;)
    {
      return;
      addCallBack(paramLocationCallBack);
      if ((this.mLocData != null) && (System.currentTimeMillis() - this.mLocTime < 30000L))
      {
        this.mSaveData = false;
        locationChanged(this.mLocData);
      }
      else
      {
        this.mSaveData = true;
        paramLocationCallBack = TencentLocationRequest.create();
        paramLocationCallBack.setInterval(5000L);
        this.mLocationManager.requestLocationUpdates(paramLocationCallBack, this.mTListener);
      }
    }
  }
  
  public void stopLocation()
  {
    this.mLocationManager.removeUpdates(this.mTListener);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/location/mapt/WkLocationManagerT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */