package com.lantern.safecommand.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.net.VpnService;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.Utils;
import com.lantern.wifiseccheck.WifiSecCheckManager;
import com.lantern.wifiseccheck.protocol.AuthProtocolResult;
import com.lantern.wifiseccheck.protocol.AuthProtocolResult.AuthResult;
import com.lantern.wifiseccheck.vpn.VpnConstants.Action;
import com.lantern.wifiseccheck.vpn.connection.ConnectionManager;
import com.lantern.wifiseccheck.vpn.server.SafeAuthServer;
import com.lantern.wifiseccheck.vpn.utils.ResTool;
import com.lantern.wifiseccheck.vpn.utils.UserUtils;
import com.lantern.wifiseccheck.vpn.utils.VpnUtils;
import java.io.File;
import java.util.Locale;

public class SafeVpnService
  extends BaseVpnService
{
  private static final String AUTO_OPEN = "start when service startCommand";
  private static final String TAG = "SafeVpnService";
  static final int VPN_EVENT_DISCONNECT = 1;
  static final int VPN_EVENT_DISCONNECT_AUTH = 2;
  static final int VPN_EVENT_RECONECTED = 4;
  static final int VPN_EVENT_UNREACHABLECONNECT = 3;
  static final int VPN_NET_STATE_CONNECTED = 1;
  static final int VPN_NET_STATE_DISCONNECTED = 2;
  public String PRIVATE_VLAN = "1.1.1.%s";
  public int VPN_MTU = 1400;
  private AudioManager am = null;
  private int getParamsRetryTime = 0;
  private boolean isDiscardFirstEvent;
  private ServiceHandler mHandler = new ServiceHandler();
  private boolean mIsEstablishOver = true;
  private SafeAuthServer mParamsUtil = new SafeVpnService.1(this);
  private String openReason;
  private boolean vpnDefaultSate = true;
  
  static
  {
    LogUtils.d("SafeVpnService", "load lib svpn_shared so");
    System.loadLibrary("svpn_shared");
  }
  
  private StartVpnParam getStartParam(String paramString)
  {
    StartVpnParam localStartVpnParam = new StartVpnParam();
    localStartVpnParam.cryptMethod = this.mParamsResult.getCryptMethod();
    localStartVpnParam.cryptoPassword = this.mParamsResult.getCryptoPassword();
    localStartVpnParam.mtu = this.VPN_MTU;
    localStartVpnParam.token = this.mParamsResult.getToken();
    LogUtils.d("SafeVpnService", "token =========" + localStartVpnParam.token);
    localStartVpnParam.tunfd = -1;
    localStartVpnParam.tunGwIp = Utils.ipToInt(String.format(Locale.ENGLISH, this.PRIVATE_VLAN, new Object[] { "1" }));
    localStartVpnParam.tunIp = Utils.ipToInt(String.format(Locale.ENGLISH, this.PRIVATE_VLAN, new Object[] { "2" }));
    localStartVpnParam.vpn_rule_path = paramString;
    LogUtils.d("SafeVpnService", "mParamsResult.getVpnServer() =" + this.mParamsResult.getVpnServer());
    paramString = this.mParamsResult.getVpnServer().split(":");
    localStartVpnParam.vpnserver = paramString[0];
    LogUtils.d("SafeVpnService", "vpnserver ==" + localStartVpnParam.vpnserver);
    localStartVpnParam.port = Integer.parseInt(paramString[1]);
    LogUtils.d("SafeVpnService", "vpnport ==" + localStartVpnParam.port);
    return localStartVpnParam;
  }
  
  private void mergeParams(AuthProtocolResult paramAuthProtocolResult)
  {
    if (this.mParamsResult == null)
    {
      this.mParamsResult = paramAuthProtocolResult;
      UserUtils.setAuthResult(this.mParamsResult, this);
    }
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramAuthProtocolResult.getClientDnsHelper())) {
        paramAuthProtocolResult.setClientDnsHelper(this.mParamsResult.getClientDnsHelper());
      }
      if (TextUtils.isEmpty(paramAuthProtocolResult.getVpnRule())) {
        paramAuthProtocolResult.setVpnRule(this.mParamsResult.getVpnRule());
      }
      if (TextUtils.isEmpty(paramAuthProtocolResult.getDisallowedApplication())) {
        paramAuthProtocolResult.setDisallowedApplication(this.mParamsResult.getDisallowedApplication());
      }
      if (TextUtils.isEmpty(paramAuthProtocolResult.getAdContent())) {
        paramAuthProtocolResult.setAdContent(this.mParamsResult.getAdContent());
      }
      this.mParamsResult = paramAuthProtocolResult;
      UserUtils.setAuthResult(this.mParamsResult, this);
    }
  }
  
  private void sendGetParamsResultMessage(AuthProtocolResult paramAuthProtocolResult)
  {
    Message localMessage = this.mHandler.obtainMessage(2);
    if (paramAuthProtocolResult != null) {
      localMessage.obj = paramAuthProtocolResult.getResult();
    }
    this.mHandler.sendMessage(localMessage);
  }
  
  private void startConnect()
  {
    new Thread(new SafeVpnService.2(this)).start();
  }
  
  private void startParamsRequest()
  {
    this.getParamsRetryTime += 1;
    this.mParamsUtil.setAppVersion(VpnUtils.getInstance().getLocalAppVersionCode());
    this.mParamsUtil.setChannel(VpnUtils.getInstance().getChannelId());
    LogUtils.d("SafeVpnService", "get auth String http://vpn.swaqds.com:8080/vpn/auth");
    this.mParamsUtil.setRequestServerAddr("http://vpn.swaqds.com:8080/vpn/auth");
    this.mParamsUtil.setBaseAttr(VpnUtils.getInstance().getAppBaseAttr(this));
    if (this.mParamsResult != null)
    {
      this.mParamsUtil.setVpnRuleVer(this.mParamsResult.getVpnRuleVer());
      LogUtils.d("SafeVpnService", "mParamsResult.getClientDnsHelperVer() " + this.mParamsResult.getClientDnsHelperVer());
      this.mParamsUtil.setClientDnsHelperVer(this.mParamsResult.getClientDnsHelperVer());
      this.mParamsUtil.setAdContentVer(this.mParamsResult.getAdContentVer());
      this.mParamsUtil.setDisallowedApplicationVer(this.mParamsResult.getDisallowedApplicationVer());
    }
    try
    {
      this.mParamsUtil.request(UserUtils.getUhid(this), UserUtils.getDhid(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void vpn_notify_java(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      LogUtils.d("SafeVpnService", "VPN_EVENT_BUTT");
    }
    for (;;)
    {
      return;
      LogUtils.d("SafeVpnService", "VPN_EVENT_DISCONNECT");
      ConnectionManager.getInstance().stopVpn(false);
      Toast.makeText(this, ResTool.getStringId("spirit_connect_invalid", this), 1).show();
      continue;
      LogUtils.d("SafeVpnService", "VPN_EVENT_DISCONNECT_AUTH");
      ConnectionManager.getInstance().stopVpn(false);
      startRunner(null);
      continue;
      this.isDiscardFirstEvent = true;
      ConnectionManager.getInstance().vpnConnectedReceived();
    }
  }
  
  public Context getContext()
  {
    return getApplicationContext();
  }
  
  public int getServiceMode()
  {
    return 0;
  }
  
  public String getTag()
  {
    return null;
  }
  
  public boolean isLollipopOrAbove()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    LogUtils.d("aaa", "service onBind");
    String str = paramIntent.getAction();
    LogUtils.i("SafeVpnService", "--onBind ------action---: " + str);
    if ("android.net.VpnService".equals(str)) {
      paramIntent = super.onBind(paramIntent);
    }
    for (;;)
    {
      return paramIntent;
      if (VpnConstants.Action.ACTION_START_VPN_SERVICE.equals(str)) {
        paramIntent = this.binder;
      } else {
        paramIntent = this.binder;
      }
    }
  }
  
  public void onCreate()
  {
    this.mHandler.sendEmptyMessageDelayed(10, 1000L);
    ConnectionManager.getInstance().init(this, com.lantern.wifiseccheck.item.CheckItemWebMd5.CHECK_DOMAINS[0]);
    WifiSecCheckManager.getInstance().init(getApplication());
    this.am = ((AudioManager)getSystemService("audio"));
  }
  
  public void onDestroy()
  {
    LogUtils.e("SafeVpnService", "--vpnService--onDestroy---");
    super.onDestroy();
  }
  
  public void onRevoke()
  {
    LogUtils.d("SafeVpnService", "onRevoke");
    this.mHandler.removeMessages(29);
    Message localMessage = this.mHandler.obtainMessage(29);
    this.mHandler.sendMessage(localMessage);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    boolean bool = ConnectionManager.getInstance().isVPNStarted();
    LogUtils.d("SafeVpnService", "--vpnService--- onStartCommand--  isVPNStarted---" + bool);
    if ((UserUtils.isVpnStart(this)) && (VpnService.prepare(this) == null) && (!bool))
    {
      LogUtils.d("SafeVpnService", "user state is open");
      UserUtils.setVpnStartAuto(true, this);
      this.mHandler.obtainMessage(18, "start when service startCommand").sendToTarget();
    }
    return 1;
  }
  
  public void removeMessage(int paramInt)
  {
    this.mHandler.removeMessages(paramInt);
  }
  
  public void sendMessage(int paramInt)
  {
    this.mHandler.removeMessages(paramInt);
    this.mHandler.sendEmptyMessage(paramInt);
  }
  
  public void sendMessageToSelf(int paramInt1, int paramInt2, int paramInt3, Object paramObject, long paramLong)
  {
    Message localMessage = this.mHandler.obtainMessage(paramInt1);
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    localMessage.obj = paramObject;
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    this.mHandler.sendMessageDelayed(localMessage, l);
  }
  
  public void setAllByPass(boolean paramBoolean)
  {
    LogUtils.d("SafeVpnService", "set all by pass " + paramBoolean);
    SvpnShared.getInstance().SetAllByPass(paramBoolean);
  }
  
  public void startRunner(String paramString)
  {
    LogUtils.d("SafeVpnService", "startRunner");
    if (ConnectionManager.getInstance().prepareVpn())
    {
      LogUtils.d("SafeVpnService", "ConnectionManager start prepare success. and reason is " + paramString);
      this.openReason = paramString;
      startParamsRequest();
    }
  }
  
  public String vpnFillPakageNameByUid(int paramInt)
  {
    String str = getPackageManager().getNameForUid(paramInt);
    LogUtils.d("SafeVpnService", "packageName =" + str + " uid=" + paramInt);
    return getPackageManager().getNameForUid(paramInt);
  }
  
  public void vpnNotify(int paramInt)
  {
    LogUtils.d("SafeVpnService", "get jni event " + paramInt);
    Message localMessage = this.mHandler.obtainMessage();
    localMessage.what = 4;
    localMessage.arg1 = paramInt;
    this.mHandler.sendMessage(localMessage);
  }
  
  public int vpnProtect(int paramInt)
  {
    boolean bool = protect(paramInt);
    if (!bool) {
      LogUtils.e("SafeVpnService", "****************protect error!**************");
    }
    if (bool) {}
    for (paramInt = 0;; paramInt = -1) {
      return paramInt;
    }
  }
  
  public class ServiceHandler
    extends Handler
  {
    public static final int MSG_API_TOKEN_FINISHED = 2;
    public static final int MSG_CHECK_SHOW_TOAST = 10;
    public static final int MSG_DO_VPN_NOTITY = 4;
    public static final int MSG_PLAN_UI_NOTIFY = 27;
    public static final int MSG_REFRESH_STATE = 31;
    public static final int MSG_START_VPN = 18;
    public static final int MSG_STOP_VPN = 19;
    public static final int MSG_UI_BACK_TO_FRONT = 30;
    public static final int MSG_UI_CALLBACK_REGISTERED = 26;
    public static final int MSG_VPN_AUTH_REVOKED = 29;
    public static final int MSG_VPN_RULEFILE_READY = 23;
    public static final int MSG_VPN_TEST_TIMEOUT = 25;
    public static final int STACK_TIME_DEVIDER = 5000;
    
    public ServiceHandler() {}
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool2 = true;
      LogUtils.d("SafeVpnService", "get message " + paramMessage.what);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return;
        String str = null;
        if (paramMessage.obj != null)
        {
          str = (String)paramMessage.obj;
          LogUtils.d("SafeVpnService", " reason is " + str);
        }
        SafeVpnService.this.startRunner(str);
        continue;
        ConnectionManager.getInstance().stopVpn(false);
        ConnectionManager.getInstance().refreshState();
        continue;
        ConnectionManager.getInstance().uiReinited();
        if (ConnectionManager.getInstance().isStateStable())
        {
          ConnectionManager.getInstance().notifyUI();
          continue;
          LogUtils.d("SafeVpnService", "receive MSG_REFRESH_STATE ");
          ConnectionManager.getInstance().refreshState();
          continue;
          if ((paramMessage.obj != null) && ((AuthProtocolResult.AuthResult)paramMessage.obj == AuthProtocolResult.AuthResult.AUTH_RESULT_OK))
          {
            SafeVpnService.this.startConnect();
          }
          else if (!TextUtils.isEmpty(SafeVpnService.this.openReason))
          {
            if (SafeVpnService.this.mParamsResult != null)
            {
              SafeVpnService.this.startConnect();
            }
            else
            {
              ConnectionManager.getInstance().stopVpn(false);
              Toast.makeText(SafeVpnService.this, ResTool.getStringId("vpn_authorise_fail_opendiabled", SafeVpnService.this), 1).show();
              ConnectionManager.getInstance().refreshState();
            }
          }
          else
          {
            ConnectionManager.getInstance().stopVpn(false);
            Toast.makeText(SafeVpnService.this, ResTool.getStringId("vpn_authorise_fail_opendiabled", SafeVpnService.this), 1).show();
            ConnectionManager.getInstance().refreshState();
            continue;
            ConnectionManager.getInstance().startVpn(SafeVpnService.this.getStartParam(SafeVpnService.this.getFileStreamPath("vpn_rule").getAbsolutePath()));
            continue;
            LogUtils.d("SafeVpnService", "get message MSG_VPN_TEST_TIMEOUT");
            ConnectionManager.getInstance().vpnTestTimeout();
            continue;
            LogUtils.d("SafeVpnService", "get message MSG_PLAN_UI_NOTIFY");
            if (ConnectionManager.getInstance().isStateStable())
            {
              ConnectionManager.getInstance().notifyUI();
            }
            else
            {
              LogUtils.d("SafeVpnService", "can NOT plan a UI notify since the state is not stable");
              continue;
              if (ConnectionManager.getInstance().isVPNStarted())
              {
                boolean bool4 = SafeVpnService.this.am.isMusicActive();
                boolean bool3 = UserUtils.isScreenOriatationLandscape(SafeVpnService.this.getApplicationContext());
                LogUtils.d("SafeVpnService", "music is active " + bool4 + " isLandscape " + bool3);
                if ((!bool4) && (!bool3)) {}
                for (bool1 = true;; bool1 = false)
                {
                  if (bool1 != SafeVpnService.this.vpnDefaultSate) {
                    break label573;
                  }
                  LogUtils.d("SafeVpnService", "the same vpn default state return");
                  sendEmptyMessageDelayed(10, 5000L);
                  break;
                }
                label573:
                paramMessage = SafeVpnService.this;
                if ((bool4) || (bool3)) {
                  break label623;
                }
              }
              label623:
              for (boolean bool1 = bool2;; bool1 = false)
              {
                SafeVpnService.access$802(paramMessage, bool1);
                SvpnShared.getInstance().SetDefaultVpn(SafeVpnService.this.vpnDefaultSate);
                sendEmptyMessageDelayed(10, 5000L);
                break;
              }
              SafeVpnService.this.vpn_notify_java(paramMessage.arg1);
              continue;
              LogUtils.d("SafeVpnService", "receive MSG_VPN_AUTH_REVOKED ");
              ConnectionManager.getInstance().stopVpn(true);
            }
          }
        }
      }
    }
  }
  
  public class StartVpnParam
  {
    String cryptMethod;
    String cryptoPassword;
    int mtu;
    int port;
    String token;
    int tunGwIp;
    int tunIp;
    int tunfd;
    String vpn_rule_path;
    String vpnserver;
    
    public StartVpnParam() {}
    
    public int getTunfd()
    {
      return this.tunfd;
    }
    
    public void setTunfd(int paramInt)
    {
      this.tunfd = paramInt;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/service/SafeVpnService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */