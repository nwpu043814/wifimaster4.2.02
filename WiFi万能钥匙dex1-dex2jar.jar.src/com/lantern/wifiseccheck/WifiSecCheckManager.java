package com.lantern.wifiseccheck;

import android.app.Application;
import com.lantern.wifiseccheck.protocol.ApMarkResult;
import com.lantern.wifiseccheck.protocol.ApNeighbourRes;
import com.lantern.wifiseccheck.protocol.GpsCoordinate;
import com.lantern.wifiseccheck.protocol.WifiSecInfoRes;
import com.lantern.wifiseccheck.vpn.utils.VpnUtils;
import com.lantern.wifiseccheck.warningmsg.WifiSecCheckCollectWarningmsg;
import java.util.Map;

public class WifiSecCheckManager
{
  private static final String TAG = "WifiSecCheckManager";
  private static WifiSecCheckManager instance;
  private Application app;
  private WifiSecCheckImpl checkImpl;
  private FIFOList<WifiCheckListener> mListenerQuene = new FIFOList();
  private String remoteBaseUrl;
  private WifiSecLevelImpl secLevelImpl;
  
  public static WifiSecCheckManager getInstance()
  {
    try
    {
      if (instance == null)
      {
        WifiSecCheckManager localWifiSecCheckManager = new com/lantern/wifiseccheck/WifiSecCheckManager;
        localWifiSecCheckManager.<init>();
        instance = localWifiSecCheckManager;
      }
      return instance;
    }
    finally {}
  }
  
  public String getRemoteBaseUrl()
  {
    return this.remoteBaseUrl;
  }
  
  public void init(Application paramApplication)
  {
    this.app = paramApplication;
    if (this.checkImpl == null) {
      this.checkImpl = new WifiSecCheckImpl(this, paramApplication);
    }
    if (this.secLevelImpl == null) {
      this.secLevelImpl = new WifiSecLevelImpl(paramApplication);
    }
    VpnUtils.getInstance().setApp(paramApplication);
  }
  
  protected WifiCheckListener loopNext()
  {
    return (WifiCheckListener)this.mListenerQuene.getItem();
  }
  
  public void setCheckTimeOut(long paramLong)
  {
    if (this.app == null) {
      throw new NoInitException("please init first");
    }
    if (paramLong < 15000L) {
      throw new RuntimeException("please set the time >= 15 seconds");
    }
    this.checkImpl.setTimeout(paramLong);
  }
  
  public void setRemoteBaseUrl(String paramString)
  {
    this.remoteBaseUrl = paramString;
  }
  
  public void startBatchGetWifiSecLevel(BatchWifiSecCheckListener paramBatchWifiSecCheckListener, Map<String, String> paramMap)
  {
    this.secLevelImpl.startSecLevelRequest(paramBatchWifiSecCheckListener, paramMap);
  }
  
  public void startCheck(WifiCheckListener paramWifiCheckListener)
  {
    if (this.app == null) {
      throw new NoInitException("please init first");
    }
    if ((this.checkImpl.getListener() != null) && (paramWifiCheckListener == this.checkImpl.getListener())) {
      LogUtils.e("WifiSecCheckManager", "is the same command return it");
    }
    for (;;)
    {
      return;
      this.mListenerQuene.put(paramWifiCheckListener);
      if (!this.checkImpl.isChecking()) {
        this.checkImpl.startCheck();
      }
    }
  }
  
  public void stopCheck(WifiCheckListener paramWifiCheckListener)
  {
    LogUtils.d("WifiSecCheckManager", "STOP CURRENT");
    if (paramWifiCheckListener == null) {}
    for (;;)
    {
      return;
      if (this.mListenerQuene.contains(paramWifiCheckListener))
      {
        this.mListenerQuene.remove(paramWifiCheckListener);
      }
      else if ((this.checkImpl.getListener() != null) && (paramWifiCheckListener == this.checkImpl.getListener()))
      {
        LogUtils.e("WifiSecCheckManager", "is the same command need stop current");
        this.checkImpl.stopCheckCurrent();
      }
    }
  }
  
  public void stopSecLevel(BatchWifiSecCheckListener paramBatchWifiSecCheckListener)
  {
    LogUtils.d("WifiSecCheckManager", "STOP stopSecLevel");
    if (paramBatchWifiSecCheckListener == null) {}
    for (;;)
    {
      return;
      if ((this.secLevelImpl.getBatchWifiSecCheckListener() != null) && (paramBatchWifiSecCheckListener == this.secLevelImpl.getBatchWifiSecCheckListener()))
      {
        LogUtils.e("WifiSecCheckManager", "is the same command need stop stopSecLevel");
        this.secLevelImpl.stopSecLevelCurrent();
      }
    }
  }
  
  public static abstract class BatchWifiSecCheckListener
    implements WifiSecCheckManager.CheckListener
  {
    public String getAppId()
    {
      return null;
    }
    
    public String getConnChanid()
    {
      return null;
    }
    
    public String getLang()
    {
      return "default";
    }
    
    public int getSource()
    {
      return -1;
    }
    
    public abstract void onCheckFinish(WifiSecInfoRes paramWifiSecInfoRes);
  }
  
  public static abstract interface CheckListener
  {
    public abstract String getAppId();
    
    public abstract String getConnChanid();
    
    public abstract String getDhid();
    
    public abstract String getLang();
    
    public abstract GpsCoordinate getLocation();
    
    public abstract int getSource();
    
    public abstract void onCheckError(int paramInt);
  }
  
  public static final class Error
  {
    public static final int ERROR_DUPLICATE_CHECK = 2;
    public static final int ERROR_JNI_INIT = 1;
    public static final int ERROR_UNKNOW = 3;
  }
  
  public class NoInitException
    extends RuntimeException
  {
    public NoInitException(String paramString)
    {
      super();
    }
  }
  
  public static abstract class WifiCheckListener
    implements WifiSecCheckManager.CheckListener
  {
    private WifiSecCheckImpl.CheckModel model;
    WifiSecCheckCollectWarningmsg wifiSecCheckCollectWarningmsg;
    
    public WifiCheckListener(WifiSecCheckImpl.CheckModel paramCheckModel)
    {
      this.model = paramCheckModel;
      this.wifiSecCheckCollectWarningmsg = new WifiSecCheckCollectWarningmsg();
    }
    
    public abstract void detectCount(int paramInt1, int paramInt2, int paramInt3);
    
    public String getAppId()
    {
      return null;
    }
    
    protected WifiSecCheckImpl.CheckModel getCheckModel()
    {
      return this.model;
    }
    
    public String getConnChanid()
    {
      return null;
    }
    
    public String getLang()
    {
      return "default";
    }
    
    public abstract Integer getNetWorkSpeed();
    
    public int getSource()
    {
      return -1;
    }
    
    public abstract void onCheckError(int paramInt);
    
    public abstract void onCheckFinish(ApMarkResult paramApMarkResult, ExtraInfo paramExtraInfo);
    
    public abstract void onLoadCallback(ApNeighbourRes paramApNeighbourRes);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/WifiSecCheckManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */