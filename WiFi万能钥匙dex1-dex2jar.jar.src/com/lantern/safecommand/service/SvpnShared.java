package com.lantern.safecommand.service;

import com.lantern.wifiseccheck.HostItem;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.NeighbourItem;
import com.lantern.wifiseccheck.WifiSecCheck;
import com.lantern.wifiseccheck.vpn.connection.ConnectionManager;
import java.io.PrintStream;
import java.util.ArrayList;

public class SvpnShared
{
  private static SvpnShared instance;
  private WifiSecCheck wifiSecCheck;
  
  static
  {
    LogUtils.d("SvpnShared", "load lib svpn_shared so");
    System.loadLibrary("svpn_shared");
  }
  
  private native void SetStaticActive(boolean paramBoolean);
  
  public static SvpnShared getInstance()
  {
    if (instance == null) {
      instance = new SvpnShared();
    }
    return instance;
  }
  
  private SafeVpnService getService()
  {
    return ConnectionManager.getInstance().getService();
  }
  
  public void ARP_CHKECK_CB(int paramInt, String[] paramArrayOfString)
  {
    this.wifiSecCheck.arpChkeckCb(paramInt, paramArrayOfString);
  }
  
  public native void CancellHostByName();
  
  public native void CancellNeighbours();
  
  public void DETECT_INTERNET_CB(String paramString)
  {
    System.out.println("java DETECT_INTERNET_CB ....." + paramString);
  }
  
  public void GET_HOST_BY_NAME_CB(ArrayList<HostItem> paramArrayList)
  {
    this.wifiSecCheck.getHostByNameCb(paramArrayList);
  }
  
  public native int InstallArpCheckHook(boolean paramBoolean);
  
  public native int JNI_GetHostByName(String[] paramArrayOfString, HostItem paramHostItem);
  
  public native int JNI_GetNeighbours(int paramInt1, int paramInt2, NeighbourItem paramNeighbourItem);
  
  public void NEIGHBOUR_CB(int paramInt1, ArrayList<NeighbourItem> paramArrayList, int paramInt2)
  {
    this.wifiSecCheck.neighbourCb(paramInt1, paramArrayList, paramInt2);
  }
  
  public native int RestartTunFd();
  
  public native void SetAllByPass(boolean paramBoolean);
  
  public native int SetDefaultVpn(boolean paramBoolean);
  
  public native void SetLogActive(boolean paramBoolean);
  
  public native void SuspendTunFd();
  
  public native String encryptConfPostBody(byte[] paramArrayOfByte);
  
  public native byte[] encryptPostBody(byte[] paramArrayOfByte);
  
  public native int init_vpn();
  
  public native boolean isVpnStarted();
  
  public native int notify_netstate(int paramInt);
  
  public native byte[] rsaUploadDataEncrypt(byte[] paramArrayOfByte);
  
  public native String rsaVpnAuthEncrypt(String paramString);
  
  public void setWifiSecCheck(WifiSecCheck paramWifiSecCheck)
  {
    this.wifiSecCheck = paramWifiSecCheck;
  }
  
  public native int start_vpn(SafeVpnService.StartVpnParam paramStartVpnParam);
  
  public native void stop_vpn();
  
  public String vpn_fillPakageNameByUid(int paramInt)
  {
    return getService().vpnFillPakageNameByUid(paramInt);
  }
  
  public String vpn_get_ad_head()
  {
    return "HTTP/1.1 302 Moved Temporarily\r\nContent-Type: text/html\r\nContent-Length: 0\r\nConnection: Keep-Alive\r\nLocation: http://ad.swaqds.com:8080/vpn/error.jsp?%s\r\n\r\n";
  }
  
  public void vpn_notify(int paramInt)
  {
    getService().vpnNotify(paramInt);
  }
  
  public int vpn_protect(int paramInt)
  {
    return getService().vpnProtect(paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/service/SvpnShared.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */