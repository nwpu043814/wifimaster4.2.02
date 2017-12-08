package com.lantern.safecommand.service;

import android.content.Context;
import android.net.VpnService;
import android.os.Handler;
import android.os.RemoteCallbackList;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.lantern.safecommand.aidl.ConnectionStateNotify;
import com.lantern.safecommand.aidl.IVpnServiceCallback;
import com.lantern.safecommand.aidl.VpnServiceInterface.Stub;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.protocol.AuthProtocolResult;
import com.lantern.wifiseccheck.protocol.appconf.AppConfRes;
import com.lantern.wifiseccheck.vpn.net.ProtectedAppListJSON;
import com.lantern.wifiseccheck.vpn.net.SignAppInfo;
import com.lantern.wifiseccheck.vpn.utils.UserUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class BaseVpnService
  extends VpnService
{
  private static final String TAG = "BaseVpnService";
  ProtectedAppListJSON appListJSON;
  Map<String, SignAppInfo> appMap = new HashMap();
  protected VpnServiceInterface.Stub binder = new BaseVpnService.3(this);
  private Handler handler;
  final RemoteCallbackList<IVpnServiceCallback> mCallbackList = new RemoteCallbackList();
  AuthProtocolResult mParamsResult;
  AppConfRes mRes;
  int mVpnEventState = 1;
  
  public void changeState(ConnectionStateNotify paramConnectionStateNotify)
  {
    this.handler = new Handler(getBaseContext().getMainLooper());
    this.handler.post(new BaseVpnService.1(this, paramConnectionStateNotify));
  }
  
  public abstract Context getContext();
  
  public abstract int getServiceMode();
  
  public abstract String getTag();
  
  protected int getVpnEventState()
  {
    return this.mVpnEventState;
  }
  
  public AuthProtocolResult getmParamsResult()
  {
    return this.mParamsResult;
  }
  
  protected void initAppMap()
  {
    Object localObject;
    if ((this.mRes != null) && (this.mRes.getProtectAppList() != null))
    {
      localObject = this.mRes.getProtectAppList();
      LogUtils.d("BaseVpnService", "get app list from server " + (String)localObject);
    }
    while (!TextUtils.isEmpty((CharSequence)localObject))
    {
      LogUtils.d("BaseVpnService", "get app list " + (String)localObject);
      this.appListJSON = ((ProtectedAppListJSON)JSON.parseObject((String)localObject, ProtectedAppListJSON.class));
      this.appMap.clear();
      Iterator localIterator = this.appListJSON.getResData().iterator();
      while (localIterator.hasNext())
      {
        localObject = (SignAppInfo)localIterator.next();
        this.appMap.put(((SignAppInfo)localObject).getPackageName(), localObject);
      }
      localObject = CopyAssets.getFromAssets("applist", this);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mParamsResult = UserUtils.getAuthResult(this);
    this.mRes = UserUtils.getAppParams(this);
    initAppMap();
  }
  
  public void refreshStateDone()
  {
    this.handler = new Handler(getBaseContext().getMainLooper());
    this.handler.post(new BaseVpnService.2(this));
  }
  
  public abstract void sendMessage(int paramInt);
  
  public abstract void startRunner(String paramString);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/service/BaseVpnService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */