package com.lantern.wifiseccheck.vpn.connection;

import android.content.pm.PackageManager.NameNotFoundException;
import android.net.VpnService;
import android.net.VpnService.Builder;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.Log;
import com.lantern.safecommand.service.DnsTrigger;
import com.lantern.safecommand.service.SafeVpnService;
import com.lantern.safecommand.service.SafeVpnService.StartVpnParam;
import com.lantern.safecommand.service.SvpnShared;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.protocol.AuthProtocolResult;
import com.lantern.wifiseccheck.vpn.utils.ResTool;
import java.io.IOException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class VpnConnector
{
  public static final int CONNECTED = 3;
  public static final int CONNECTING = 2;
  public static final int INIT = 0;
  public static final int PREPARED = 1;
  public static final int STOPPED = 5;
  public static final int STOPPED_DIS_PERMISSION = 7;
  public static final int STOPPED_ESTABLISH = 6;
  public static final int STOPPING = 4;
  private static final String TAG = "CONN";
  static final int VPN_NET_STATE_CELL_CONNECTED = 2;
  static final int VPN_NET_STATE_DISCONNECTED = 3;
  static final int VPN_NET_STATE_WIFI_CONNECTED = 1;
  private static VpnConnector instance = new VpnConnector();
  public String PRIVATE_VLAN = "1.1.1.%s";
  public int VPN_MTU = 1400;
  private VpnConnectorObserver observer = null;
  private SafeVpnService service = null;
  private boolean suspendByNoInternet = false;
  private int vpnState = 0;
  
  private void addPackageName(VpnService.Builder paramBuilder, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfString[i];
        try
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("item start::::");
          LogUtils.d("CONN", str);
          paramBuilder.addDisallowedApplication(str);
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("item finish:::");
          LogUtils.d("CONN", str);
          i++;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          for (;;)
          {
            localNameNotFoundException.printStackTrace();
          }
        }
      }
    }
  }
  
  private void addroute(VpnService.Builder paramBuilder)
  {
    try
    {
      paramBuilder.addRoute("1.0.0.0", 8);
      try
      {
        paramBuilder.addRoute("2.0.0.0", 7);
        try
        {
          paramBuilder.addRoute("4.0.0.0", 6);
          try
          {
            paramBuilder.addRoute("8.0.0.0", 7);
            try
            {
              paramBuilder.addRoute("11.0.0.0", 8);
              try
              {
                paramBuilder.addRoute("12.0.0.0", 6);
                try
                {
                  paramBuilder.addRoute("16.0.0.0", 4);
                  try
                  {
                    paramBuilder.addRoute("32.0.0.0", 3);
                    try
                    {
                      paramBuilder.addRoute("64.0.0.0", 2);
                      try
                      {
                        paramBuilder.addRoute("128.0.0.0", 3);
                        try
                        {
                          paramBuilder.addRoute("160.0.0.0", 5);
                          try
                          {
                            paramBuilder.addRoute("168.0.0.0", 8);
                            try
                            {
                              paramBuilder.addRoute("169.1.0.0", 16);
                              try
                              {
                                paramBuilder.addRoute("169.2.0.0", 15);
                                try
                                {
                                  paramBuilder.addRoute("169.4.0.0", 14);
                                  try
                                  {
                                    paramBuilder.addRoute("169.8.0.0", 13);
                                    try
                                    {
                                      paramBuilder.addRoute("169.16.0.0", 12);
                                      try
                                      {
                                        paramBuilder.addRoute("169.32.0.0", 11);
                                        try
                                        {
                                          paramBuilder.addRoute("169.64.0.0", 10);
                                          try
                                          {
                                            paramBuilder.addRoute("169.128.0.0", 10);
                                            try
                                            {
                                              paramBuilder.addRoute("169.192.0.0", 11);
                                              try
                                              {
                                                paramBuilder.addRoute("169.224.0.0", 12);
                                                try
                                                {
                                                  paramBuilder.addRoute("169.240.0.0", 13);
                                                  try
                                                  {
                                                    paramBuilder.addRoute("169.248.0.0", 14);
                                                    try
                                                    {
                                                      paramBuilder.addRoute("169.252.0.0", 15);
                                                      try
                                                      {
                                                        paramBuilder.addRoute("170.0.0.0", 7);
                                                        try
                                                        {
                                                          paramBuilder.addRoute("172.16.0.0", 12);
                                                          try
                                                          {
                                                            paramBuilder.addRoute("172.32.0.0", 11);
                                                            try
                                                            {
                                                              paramBuilder.addRoute("172.64.0.0", 10);
                                                              try
                                                              {
                                                                paramBuilder.addRoute("172.128.0.0", 10);
                                                                try
                                                                {
                                                                  paramBuilder.addRoute("172.192.0.0", 11);
                                                                  try
                                                                  {
                                                                    paramBuilder.addRoute("172.224.0.0", 12);
                                                                    try
                                                                    {
                                                                      paramBuilder.addRoute("172.240.0.0", 13);
                                                                      try
                                                                      {
                                                                        paramBuilder.addRoute("172.248.0.0", 14);
                                                                        try
                                                                        {
                                                                          paramBuilder.addRoute("172.252.0.0", 15);
                                                                          try
                                                                          {
                                                                            paramBuilder.addRoute("172.254.0.0", 16);
                                                                            try
                                                                            {
                                                                              paramBuilder.addRoute("173.0.0.0", 8);
                                                                              try
                                                                              {
                                                                                paramBuilder.addRoute("174.0.0.0", 7);
                                                                                try
                                                                                {
                                                                                  paramBuilder.addRoute("176.0.0.0", 4);
                                                                                  try
                                                                                  {
                                                                                    paramBuilder.addRoute("192.1.0.0", 16);
                                                                                    try
                                                                                    {
                                                                                      paramBuilder.addRoute("192.2.0.0", 15);
                                                                                      try
                                                                                      {
                                                                                        paramBuilder.addRoute("192.4.0.0", 14);
                                                                                        try
                                                                                        {
                                                                                          paramBuilder.addRoute("192.8.0.0", 13);
                                                                                          try
                                                                                          {
                                                                                            paramBuilder.addRoute("192.16.0.0", 12);
                                                                                            try
                                                                                            {
                                                                                              paramBuilder.addRoute("192.32.0.0", 11);
                                                                                              try
                                                                                              {
                                                                                                paramBuilder.addRoute("192.64.0.0", 10);
                                                                                                try
                                                                                                {
                                                                                                  paramBuilder.addRoute("192.128.0.0", 11);
                                                                                                  try
                                                                                                  {
                                                                                                    paramBuilder.addRoute("192.160.0.0", 13);
                                                                                                    try
                                                                                                    {
                                                                                                      paramBuilder.addRoute("192.169.0.0", 16);
                                                                                                      try
                                                                                                      {
                                                                                                        paramBuilder.addRoute("192.170.0.0", 15);
                                                                                                        try
                                                                                                        {
                                                                                                          paramBuilder.addRoute("192.172.0.0", 14);
                                                                                                          try
                                                                                                          {
                                                                                                            paramBuilder.addRoute("192.176.0.0", 12);
                                                                                                            try
                                                                                                            {
                                                                                                              paramBuilder.addRoute("192.192.0.0", 11);
                                                                                                              try
                                                                                                              {
                                                                                                                paramBuilder.addRoute("192.224.0.0", 12);
                                                                                                                try
                                                                                                                {
                                                                                                                  paramBuilder.addRoute("192.240.0.0", 13);
                                                                                                                  try
                                                                                                                  {
                                                                                                                    paramBuilder.addRoute("192.248.0.0", 14);
                                                                                                                    try
                                                                                                                    {
                                                                                                                      paramBuilder.addRoute("192.252.0.0", 15);
                                                                                                                      try
                                                                                                                      {
                                                                                                                        paramBuilder.addRoute("192.254.0.0", 16);
                                                                                                                        try
                                                                                                                        {
                                                                                                                          paramBuilder.addRoute("193.0.0.0", 8);
                                                                                                                          try
                                                                                                                          {
                                                                                                                            paramBuilder.addRoute("194.0.0.0", 7);
                                                                                                                            try
                                                                                                                            {
                                                                                                                              paramBuilder.addRoute("196.0.0.0", 6);
                                                                                                                              try
                                                                                                                              {
                                                                                                                                paramBuilder.addRoute("200.0.0.0", 5);
                                                                                                                                try
                                                                                                                                {
                                                                                                                                  paramBuilder.addRoute("208.0.0.0", 4);
                                                                                                                                  try
                                                                                                                                  {
                                                                                                                                    paramBuilder.addRoute("225.0.0.0", 8);
                                                                                                                                    try
                                                                                                                                    {
                                                                                                                                      paramBuilder.addRoute("226.0.0.0", 7);
                                                                                                                                      try
                                                                                                                                      {
                                                                                                                                        paramBuilder.addRoute("228.0.0.0", 6);
                                                                                                                                        try
                                                                                                                                        {
                                                                                                                                          paramBuilder.addRoute("232.0.0.0", 5);
                                                                                                                                          try
                                                                                                                                          {
                                                                                                                                            paramBuilder.addRoute("240.0.0.0", 5);
                                                                                                                                            try
                                                                                                                                            {
                                                                                                                                              paramBuilder.addRoute("248.0.0.0", 6);
                                                                                                                                              try
                                                                                                                                              {
                                                                                                                                                paramBuilder.addRoute("252.0.0.0", 7);
                                                                                                                                                try
                                                                                                                                                {
                                                                                                                                                  paramBuilder.addRoute("254.0.0.0", 8);
                                                                                                                                                  return;
                                                                                                                                                }
                                                                                                                                                catch (Exception paramBuilder)
                                                                                                                                                {
                                                                                                                                                  for (;;) {}
                                                                                                                                                }
                                                                                                                                              }
                                                                                                                                              catch (Exception localException1)
                                                                                                                                              {
                                                                                                                                                for (;;) {}
                                                                                                                                              }
                                                                                                                                            }
                                                                                                                                            catch (Exception localException2)
                                                                                                                                            {
                                                                                                                                              for (;;) {}
                                                                                                                                            }
                                                                                                                                          }
                                                                                                                                          catch (Exception localException3)
                                                                                                                                          {
                                                                                                                                            for (;;) {}
                                                                                                                                          }
                                                                                                                                        }
                                                                                                                                        catch (Exception localException4)
                                                                                                                                        {
                                                                                                                                          for (;;) {}
                                                                                                                                        }
                                                                                                                                      }
                                                                                                                                      catch (Exception localException5)
                                                                                                                                      {
                                                                                                                                        for (;;) {}
                                                                                                                                      }
                                                                                                                                    }
                                                                                                                                    catch (Exception localException6)
                                                                                                                                    {
                                                                                                                                      for (;;) {}
                                                                                                                                    }
                                                                                                                                  }
                                                                                                                                  catch (Exception localException7)
                                                                                                                                  {
                                                                                                                                    for (;;) {}
                                                                                                                                  }
                                                                                                                                }
                                                                                                                                catch (Exception localException8)
                                                                                                                                {
                                                                                                                                  for (;;) {}
                                                                                                                                }
                                                                                                                              }
                                                                                                                              catch (Exception localException9)
                                                                                                                              {
                                                                                                                                for (;;) {}
                                                                                                                              }
                                                                                                                            }
                                                                                                                            catch (Exception localException10)
                                                                                                                            {
                                                                                                                              for (;;) {}
                                                                                                                            }
                                                                                                                          }
                                                                                                                          catch (Exception localException11)
                                                                                                                          {
                                                                                                                            for (;;) {}
                                                                                                                          }
                                                                                                                        }
                                                                                                                        catch (Exception localException12)
                                                                                                                        {
                                                                                                                          for (;;) {}
                                                                                                                        }
                                                                                                                      }
                                                                                                                      catch (Exception localException13)
                                                                                                                      {
                                                                                                                        for (;;) {}
                                                                                                                      }
                                                                                                                    }
                                                                                                                    catch (Exception localException14)
                                                                                                                    {
                                                                                                                      for (;;) {}
                                                                                                                    }
                                                                                                                  }
                                                                                                                  catch (Exception localException15)
                                                                                                                  {
                                                                                                                    for (;;) {}
                                                                                                                  }
                                                                                                                }
                                                                                                                catch (Exception localException16)
                                                                                                                {
                                                                                                                  for (;;) {}
                                                                                                                }
                                                                                                              }
                                                                                                              catch (Exception localException17)
                                                                                                              {
                                                                                                                for (;;) {}
                                                                                                              }
                                                                                                            }
                                                                                                            catch (Exception localException18)
                                                                                                            {
                                                                                                              for (;;) {}
                                                                                                            }
                                                                                                          }
                                                                                                          catch (Exception localException19)
                                                                                                          {
                                                                                                            for (;;) {}
                                                                                                          }
                                                                                                        }
                                                                                                        catch (Exception localException20)
                                                                                                        {
                                                                                                          for (;;) {}
                                                                                                        }
                                                                                                      }
                                                                                                      catch (Exception localException21)
                                                                                                      {
                                                                                                        for (;;) {}
                                                                                                      }
                                                                                                    }
                                                                                                    catch (Exception localException22)
                                                                                                    {
                                                                                                      for (;;) {}
                                                                                                    }
                                                                                                  }
                                                                                                  catch (Exception localException23)
                                                                                                  {
                                                                                                    for (;;) {}
                                                                                                  }
                                                                                                }
                                                                                                catch (Exception localException24)
                                                                                                {
                                                                                                  for (;;) {}
                                                                                                }
                                                                                              }
                                                                                              catch (Exception localException25)
                                                                                              {
                                                                                                for (;;) {}
                                                                                              }
                                                                                            }
                                                                                            catch (Exception localException26)
                                                                                            {
                                                                                              for (;;) {}
                                                                                            }
                                                                                          }
                                                                                          catch (Exception localException27)
                                                                                          {
                                                                                            for (;;) {}
                                                                                          }
                                                                                        }
                                                                                        catch (Exception localException28)
                                                                                        {
                                                                                          for (;;) {}
                                                                                        }
                                                                                      }
                                                                                      catch (Exception localException29)
                                                                                      {
                                                                                        for (;;) {}
                                                                                      }
                                                                                    }
                                                                                    catch (Exception localException30)
                                                                                    {
                                                                                      for (;;) {}
                                                                                    }
                                                                                  }
                                                                                  catch (Exception localException31)
                                                                                  {
                                                                                    for (;;) {}
                                                                                  }
                                                                                }
                                                                                catch (Exception localException32)
                                                                                {
                                                                                  for (;;) {}
                                                                                }
                                                                              }
                                                                              catch (Exception localException33)
                                                                              {
                                                                                for (;;) {}
                                                                              }
                                                                            }
                                                                            catch (Exception localException34)
                                                                            {
                                                                              for (;;) {}
                                                                            }
                                                                          }
                                                                          catch (Exception localException35)
                                                                          {
                                                                            for (;;) {}
                                                                          }
                                                                        }
                                                                        catch (Exception localException36)
                                                                        {
                                                                          for (;;) {}
                                                                        }
                                                                      }
                                                                      catch (Exception localException37)
                                                                      {
                                                                        for (;;) {}
                                                                      }
                                                                    }
                                                                    catch (Exception localException38)
                                                                    {
                                                                      for (;;) {}
                                                                    }
                                                                  }
                                                                  catch (Exception localException39)
                                                                  {
                                                                    for (;;) {}
                                                                  }
                                                                }
                                                                catch (Exception localException40)
                                                                {
                                                                  for (;;) {}
                                                                }
                                                              }
                                                              catch (Exception localException41)
                                                              {
                                                                for (;;) {}
                                                              }
                                                            }
                                                            catch (Exception localException42)
                                                            {
                                                              for (;;) {}
                                                            }
                                                          }
                                                          catch (Exception localException43)
                                                          {
                                                            for (;;) {}
                                                          }
                                                        }
                                                        catch (Exception localException44)
                                                        {
                                                          for (;;) {}
                                                        }
                                                      }
                                                      catch (Exception localException45)
                                                      {
                                                        for (;;) {}
                                                      }
                                                    }
                                                    catch (Exception localException46)
                                                    {
                                                      for (;;) {}
                                                    }
                                                  }
                                                  catch (Exception localException47)
                                                  {
                                                    for (;;) {}
                                                  }
                                                }
                                                catch (Exception localException48)
                                                {
                                                  for (;;) {}
                                                }
                                              }
                                              catch (Exception localException49)
                                              {
                                                for (;;) {}
                                              }
                                            }
                                            catch (Exception localException50)
                                            {
                                              for (;;) {}
                                            }
                                          }
                                          catch (Exception localException51)
                                          {
                                            for (;;) {}
                                          }
                                        }
                                        catch (Exception localException52)
                                        {
                                          for (;;) {}
                                        }
                                      }
                                      catch (Exception localException53)
                                      {
                                        for (;;) {}
                                      }
                                    }
                                    catch (Exception localException54)
                                    {
                                      for (;;) {}
                                    }
                                  }
                                  catch (Exception localException55)
                                  {
                                    for (;;) {}
                                  }
                                }
                                catch (Exception localException56)
                                {
                                  for (;;) {}
                                }
                              }
                              catch (Exception localException57)
                              {
                                for (;;) {}
                              }
                            }
                            catch (Exception localException58)
                            {
                              for (;;) {}
                            }
                          }
                          catch (Exception localException59)
                          {
                            for (;;) {}
                          }
                        }
                        catch (Exception localException60)
                        {
                          for (;;) {}
                        }
                      }
                      catch (Exception localException61)
                      {
                        for (;;) {}
                      }
                    }
                    catch (Exception localException62)
                    {
                      for (;;) {}
                    }
                  }
                  catch (Exception localException63)
                  {
                    for (;;) {}
                  }
                }
                catch (Exception localException64)
                {
                  for (;;) {}
                }
              }
              catch (Exception localException65)
              {
                for (;;) {}
              }
            }
            catch (Exception localException66)
            {
              for (;;) {}
            }
          }
          catch (Exception localException67)
          {
            for (;;) {}
          }
        }
        catch (Exception localException68)
        {
          for (;;) {}
        }
      }
      catch (Exception localException69)
      {
        for (;;) {}
      }
    }
    catch (Exception localException70)
    {
      for (;;) {}
    }
  }
  
  private boolean doReOpenVPN(int paramInt)
  {
    boolean bool = false;
    if (this.suspendByNoInternet)
    {
      if (!startVpnFun())
      {
        LogUtils.e("CONN", "restart vpn failed from jni");
        ConnectionManager.getInstance().getService().sendMessage(19);
      }
      this.suspendByNoInternet = false;
    }
    for (;;)
    {
      return bool;
      if (paramInt != 0) {
        bool = true;
      }
    }
  }
  
  public static VpnConnector getInstance()
  {
    return instance;
  }
  
  private boolean startVpnFun()
  {
    return startVpnFun(null);
  }
  
  private boolean startVpnFun(SafeVpnService.StartVpnParam paramStartVpnParam)
  {
    boolean bool = false;
    String[] arrayOfString = null;
    ParcelFileDescriptor localParcelFileDescriptor;
    if (paramStartVpnParam != null)
    {
      Object localObject1 = this.service;
      localObject1.getClass();
      VpnService.Builder localBuilder = new VpnService.Builder((VpnService)localObject1);
      localBuilder.setSession(this.service.getString(ResTool.getStringId("vpn_authorise_fail_opendiabled", this.service))).setMtu(this.VPN_MTU).addAddress(String.format(Locale.ENGLISH, this.PRIVATE_VLAN, new Object[] { "2" }), 31);
      Object localObject2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        localObject2 = this.service.getmParamsResult();
        localObject1 = arrayOfString;
        if (localObject2 == null) {}
      }
      try
      {
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("AuthProtocolResult result");
        LogUtils.d("CONN", ((AuthProtocolResult)localObject2).getDisallowedApplication());
        localObject2 = ((AuthProtocolResult)localObject2).getDisallowedApplication();
        localObject1 = arrayOfString;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = Pattern.compile("\\s*|\t|\r|\n").matcher((CharSequence)localObject2).replaceAll("").split(";");
        }
        if (localObject1 != null) {
          addPackageName(localBuilder, (String[])localObject1);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        localParcelFileDescriptor = localBuilder.establish();
        if (localParcelFileDescriptor != null) {
          break label356;
        }
      }
      if (this.service.isLollipopOrAbove()) {
        localBuilder.allowFamily(OsConstants.AF_INET6);
      }
      addroute(localBuilder);
      LogUtils.d("CONN", "-----establish-----");
      if (!TextUtils.isEmpty(this.service.getmParamsResult().getDnsList())) {
        for (localObject1 : this.service.getmParamsResult().getDnsList().split(";"))
        {
          LogUtils.d("CONN", "set dns from server " + (String)localObject1);
          localBuilder.addDnsServer((String)localObject1);
        }
      }
      LogUtils.d("CONN", "tun_fd == null");
      return bool;
      label356:
      LogUtils.d("CONN", "get tun_fd: " + localParcelFileDescriptor.getFd());
      paramStartVpnParam.setTunfd(localParcelFileDescriptor.getFd());
      ??? = SvpnShared.getInstance().start_vpn(paramStartVpnParam);
    }
    for (;;)
    {
      try
      {
        localParcelFileDescriptor.close();
        if (??? != 0) {
          break label445;
        }
        Log.d("CONN", "start vpn native success");
        if (??? != 0) {
          break;
        }
        bool = true;
      }
      catch (IOException paramStartVpnParam)
      {
        paramStartVpnParam.printStackTrace();
        continue;
      }
      ??? = SvpnShared.getInstance().RestartTunFd();
      continue;
      label445:
      Log.e("CONN", "start vpn native faild");
    }
  }
  
  private void stopVpnFun()
  {
    SvpnShared.getInstance().notify_netstate(3);
    SvpnShared.getInstance().stop_vpn();
    Log.e("CONN", "stop vpn native done.");
  }
  
  public void VpnConnected()
  {
    LogUtils.d("CONN", "VPN CONNECTED!!! Oh Yeah...");
    this.service.removeMessage(25);
    doReOpenVPN(NetUtils.getNetSp(this.service));
    this.vpnState = 3;
    this.observer.vpnConnected();
  }
  
  public void VpnTestTimeout()
  {
    this.vpnState = 2;
    LogUtils.d("CONN", "do SuspendTunFd");
    this.suspendByNoInternet = true;
    this.observer.vpnDisconnected();
  }
  
  public int getVpnErrCode()
  {
    int i = 2;
    if (this.vpnState == 6) {}
    for (;;)
    {
      return i;
      if (this.vpnState == 7) {
        i = 3;
      } else if ((this.vpnState == 3) || (this.vpnState == 2)) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public void init(SafeVpnService paramSafeVpnService)
  {
    if (this.vpnState == 0)
    {
      this.vpnState = 5;
      this.observer = ConnectionManager.getInstance();
      this.service = paramSafeVpnService;
    }
    for (;;)
    {
      return;
      LogUtils.e("CONN", "VpnConnector init with state == " + this.vpnState);
    }
  }
  
  public boolean isVPNStarted()
  {
    if ((this.vpnState == 2) || (this.vpnState == 3)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void notifyJniWifiDisconnected()
  {
    LogUtils.d("CONN", "notify_netstate: VPN_NET_STATE_DISCONNECTED");
    SvpnShared.getInstance().notify_netstate(3);
  }
  
  public boolean prepare()
  {
    LogUtils.d("CONN", "prepare start vpn");
    if (this.vpnState >= 5)
    {
      this.vpnState = 1;
      LogUtils.d("CONN", "prepare start vpn true");
    }
    for (;;)
    {
      return true;
      LogUtils.d("CONN", "prepare start vpn false");
    }
  }
  
  public boolean startVpn(SafeVpnService.StartVpnParam paramStartVpnParam)
  {
    if (startVpnFun(paramStartVpnParam))
    {
      this.vpnState = 2;
      new DnsTrigger(this.service.getmParamsResult().getClientDnsHelper()).start();
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      this.vpnState = 6;
      stopVpnFun();
    }
  }
  
  public void stopVpn(boolean paramBoolean)
  {
    if (this.vpnState >= 4)
    {
      LogUtils.d("CONN", "stopVpn() received, but it's already stopped.");
      return;
    }
    this.vpnState = 4;
    stopVpnFun();
    if (paramBoolean) {}
    for (this.vpnState = 7;; this.vpnState = 5)
    {
      this.suspendByNoInternet = false;
      this.observer.vpnDisconnected();
      break;
    }
  }
  
  public boolean vpnStarted()
  {
    if ((this.vpnState == 2) || (this.vpnState == 3)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void wifiMissed()
  {
    LogUtils.d("CONN", "WIFI lost。");
    notifyJniWifiDisconnected();
    if (isVPNStarted())
    {
      LogUtils.d("CONN", "wifi missed need suspend tun0");
      this.suspendByNoInternet = true;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/connection/VpnConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */