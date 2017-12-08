package com.lantern.wifiseccheck;

import android.app.Application;
import android.content.Context;
import android.net.DhcpInfo;
import com.lantern.safecommand.service.SvpnShared;
import com.lantern.wifiseccheck.preferences.ExtraParamsUtils;
import java.util.ArrayList;

public class WifiSecCheck
{
  static final int NET_STATE_CONNECTED = 1;
  static final int NET_STATE_DISCONNECTED = 2;
  private static final String TAG = "WifiSecCheck";
  private JniListener mListener;
  
  public WifiSecCheck(JniListener paramJniListener)
  {
    LogUtils.d("WifiSecCheck", "new WifiSecCheck init_vpn SetLogActive");
    this.mListener = paramJniListener;
    SvpnShared.getInstance().init_vpn();
    SvpnShared.getInstance().SetLogActive(false);
    SvpnShared.getInstance().setWifiSecCheck(this);
  }
  
  public int GetHostByName(String[] paramArrayOfString)
  {
    return SvpnShared.getInstance().JNI_GetHostByName(paramArrayOfString, new HostItem(null, null));
  }
  
  public void arpChkeckCb(int paramInt, String[] paramArrayOfString)
  {
    LogUtils.d("WifiSecCheck", "ARP_CHKECK_CB");
    if (this.mListener != null) {
      this.mListener.arpCheckCallback(paramInt, paramArrayOfString);
    }
  }
  
  public void endArpCheck()
  {
    SvpnShared.getInstance().InstallArpCheckHook(false);
  }
  
  public void getHostByNameCb(ArrayList<HostItem> paramArrayList)
  {
    if (this.mListener != null)
    {
      LogUtils.d("WifiSecCheck", "GET_HOST_BY_NAME_CB");
      paramArrayList = new ArrayList(paramArrayList);
      this.mListener.getHostByNameCallback(paramArrayList);
    }
  }
  
  public void neighbourCb(int paramInt1, ArrayList<NeighbourItem> paramArrayList, int paramInt2)
  {
    LogUtils.d("WifiSecCheck", "NEIGHBOUR_CB");
    if (this.mListener != null)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramArrayList != null) {
        localArrayList = new ArrayList(paramArrayList);
      }
      this.mListener.neighbourCallback(paramInt1, localArrayList, paramInt2);
    }
  }
  
  public void resetJNI()
  {
    LogUtils.d("WifiSecCheck", "resetJNI **************");
    SvpnShared.getInstance().CancellHostByName();
    SvpnShared.getInstance().CancellNeighbours();
  }
  
  public void startCheckFromJNI(Application paramApplication)
  {
    LogUtils.d("WifiSecCheck", "startCheckFromJNI gateway " + WifiUtils.getDhcpInfo(paramApplication).gateway + " getNetmask " + WifiUtils.getNetmask(paramApplication));
    SvpnShared.getInstance().JNI_GetNeighbours(WifiUtils.getDhcpInfo(paramApplication).gateway, WifiUtils.getNetmask(paramApplication), new NeighbourItem(null, 0));
    SvpnShared.getInstance().JNI_GetHostByName(ExtraParamsUtils.getDNSUrls(paramApplication), new HostItem(null, null));
  }
  
  public void startLoadMacFromJNI(Context paramContext)
  {
    int i = SvpnShared.getInstance().JNI_GetNeighbours(WifiUtils.getDhcpInfo(paramContext).gateway, WifiUtils.getNetmask(paramContext), new NeighbourItem(null, 0));
    LogUtils.d("WifiSecCheck", "JNI_GetNeighbours code " + i);
  }
  
  public static abstract interface JniListener
  {
    public abstract void arpCheckCallback(int paramInt, String[] paramArrayOfString);
    
    public abstract void getHostByNameCallback(ArrayList<HostItem> paramArrayList);
    
    public abstract void neighbourCallback(int paramInt1, ArrayList<NeighbourItem> paramArrayList, int paramInt2);
  }
  
  public static enum NEIGHBOUR_FLAG
  {
    NEIGHBOUR_NEXT(1),  NEIGHBOUR_OVER(2);
    
    int value;
    
    private NEIGHBOUR_FLAG(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/WifiSecCheck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */