package com.lantern.wifiseccheck;

import android.app.Application;
import android.os.AsyncTask;
import com.alibaba.fastjson.JSON;
import com.lantern.wifiseccheck.protocol.ApInfoFromClient;
import com.lantern.wifiseccheck.protocol.AppBaseAttr;
import com.lantern.wifiseccheck.protocol.TreatmentRecommendations;
import com.lantern.wifiseccheck.protocol.WifiSecInfoReq;
import com.lantern.wifiseccheck.protocol.WifiSecInfoRes;
import java.util.Map;

public class WifiSecLevelImpl
{
  private static final String TAG = "WifiSecLevelImpl";
  private Application context;
  private GetSecLevelAsyncTask mGetSecLevelAsyncTask;
  private WifiSecCheckManager.BatchWifiSecCheckListener mListener;
  private long startSecLevelRequestTime;
  
  public WifiSecLevelImpl(Application paramApplication)
  {
    this.context = paramApplication;
  }
  
  public WifiSecCheckManager.BatchWifiSecCheckListener getBatchWifiSecCheckListener()
  {
    return this.mListener;
  }
  
  public void startSecLevelRequest(WifiSecCheckManager.BatchWifiSecCheckListener paramBatchWifiSecCheckListener, Map<String, String> paramMap)
  {
    this.mListener = paramBatchWifiSecCheckListener;
    this.startSecLevelRequestTime = System.currentTimeMillis();
    WifiSecInfoReq localWifiSecInfoReq = new WifiSecInfoReq();
    AppBaseAttr localAppBaseAttr = Utils.getAppBaseAttr(paramBatchWifiSecCheckListener, this.context);
    localAppBaseAttr.setDhid(paramBatchWifiSecCheckListener.getDhid());
    localAppBaseAttr.setLang(paramBatchWifiSecCheckListener.getLang());
    localWifiSecInfoReq.setAppBaseAttr(localAppBaseAttr);
    localWifiSecInfoReq.setWifiMap(paramMap);
    localWifiSecInfoReq.setProtocolVer(ApInfoFromClient.PROTOCOL_VER);
    localWifiSecInfoReq.setGpsCoordinate(paramBatchWifiSecCheckListener.getLocation());
    new Thread(new WifiSecLevelImpl.1(this, localWifiSecInfoReq, paramBatchWifiSecCheckListener)).start();
  }
  
  public void stopSecLevelCurrent()
  {
    LogUtils.d("WifiSecLevelImpl", "STOP stopSecLevelCurrent");
    try
    {
      if ((this.mGetSecLevelAsyncTask != null) && (this.mGetSecLevelAsyncTask.cancel(true))) {
        LogUtils.d("WifiSecLevelImpl", "STOP stopSecLevelCurrent mGetSecLevelAsyncTask");
      }
      return;
    }
    finally {}
  }
  
  private class GetSecLevelAsyncTask
    extends AsyncTask<WifiSecInfoReq, Object, WifiSecInfoRes>
  {
    private WifiSecCheckManager.BatchWifiSecCheckListener listener;
    
    protected GetSecLevelAsyncTask(WifiSecCheckManager.BatchWifiSecCheckListener paramBatchWifiSecCheckListener)
    {
      this.listener = paramBatchWifiSecCheckListener;
    }
    
    protected WifiSecInfoRes doInBackground(WifiSecInfoReq... paramVarArgs)
    {
      paramVarArgs = paramVarArgs[0];
      if (paramVarArgs == null) {
        paramVarArgs = null;
      }
      for (;;)
      {
        return paramVarArgs;
        paramVarArgs = SecCheckHttpApi.getWifiSecLevel(paramVarArgs);
        if (paramVarArgs.getRecommand() == null) {
          paramVarArgs.setRecommand(TreatmentRecommendations.JUST_SHOW);
        }
        LogUtils.d("WifiSecLevelImpl", "doInBackground WifiSecInfoRes response= \n" + JSON.toJSONString(paramVarArgs));
        LogUtils.d("WifiSecLevelImpl", "get wifi SecLevel Request Time " + (System.currentTimeMillis() - WifiSecLevelImpl.this.startSecLevelRequestTime));
      }
    }
    
    protected void onPostExecute(WifiSecInfoRes paramWifiSecInfoRes)
    {
      if (this.listener == null) {}
      for (;;)
      {
        return;
        if (paramWifiSecInfoRes == null) {
          this.listener.onCheckError(0);
        } else {
          this.listener.onCheckFinish(paramWifiSecInfoRes);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/WifiSecLevelImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */