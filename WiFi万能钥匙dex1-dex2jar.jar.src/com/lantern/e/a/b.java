package com.lantern.e.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import com.lantern.safecommand.aidl.ConnectionStateNotify;
import com.lantern.safecommand.aidl.IVpnServiceCallback.Stub;
import com.lantern.safecommand.aidl.VpnServiceInterface;
import com.lantern.safecommand.aidl.VpnServiceInterface.Stub;
import com.lantern.safecommand.service.SafeVpnService;
import com.lantern.safecommand.service.SvpnShared;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.protocol.appconf.AppConfRes;
import com.lantern.wifiseccheck.protocol.appconf.AppConfRes.ReturnCode;
import com.lantern.wifiseccheck.view.CustomDialog;
import com.lantern.wifiseccheck.view.CustomDialog.Builder;
import com.lantern.wifiseccheck.view.ScoreView;
import com.lantern.wifiseccheck.vpn.VpnConstants.Action;
import com.lantern.wifiseccheck.vpn.WifiSecCheckVpnImpl;
import com.lantern.wifiseccheck.vpn.WifiSecCheckVpnManager.StartVpnListener;
import com.lantern.wifiseccheck.vpn.utils.ResTool;
import com.lantern.wifiseccheck.vpn.utils.UserUtils;
import com.lantern.wifiseccheck.vpn.utils.VpnUtils;

public class b
  extends a
  implements ServiceConnection, View.OnClickListener
{
  public ScoreView d;
  private VpnServiceInterface e;
  private Button f;
  private ImageView g;
  private Intent h = null;
  private View i;
  private boolean j = false;
  private boolean k = false;
  private ConnectionStateNotify l;
  private boolean m = true;
  private IVpnServiceCallback.Stub n = new c(this);
  private CustomDialog o;
  private Dialog p;
  private Dialog q;
  private Handler r = new h(this);
  private ImageView s;
  private Integer t;
  private View u;
  private View v;
  private View w;
  private View x;
  private Context y;
  
  private void a(int paramInt)
  {
    LogUtils.d("HomeSdkAct", "score---" + paramInt);
    this.d.setProgress(paramInt);
    this.f.setEnabled(true);
  }
  
  private void b(int paramInt)
  {
    this.u.setVisibility(paramInt);
    this.v.setVisibility(paramInt);
    this.w.setVisibility(paramInt);
    this.x.setVisibility(paramInt);
  }
  
  private void c()
  {
    if ((this.o != null) && (this.o.isShowing())) {
      this.o.dismiss();
    }
    if ((this.p != null) && (this.p.isShowing())) {
      this.p.dismiss();
    }
    if ((this.q != null) && (this.q.isShowing())) {
      this.q.dismiss();
    }
  }
  
  private void d()
  {
    LogUtils.d("HomeSdkAct", "fadeOutOnVpnClose onAnimation DO");
    b(0);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.u, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.v, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.w, "alpha", new float[] { 1.0F, 0.0F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.x, "alpha", new float[] { 1.0F, 0.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator3, localObjectAnimator1, localObjectAnimator4 });
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.start();
  }
  
  protected final void a()
  {
    View localView2 = findViewById(ResTool.getViewId("title_header_home", this.y));
    View localView1 = findViewById(ResTool.getViewId("title_header_score", this.y));
    if (Build.VERSION.SDK_INT >= 19)
    {
      LogUtils.d("HomeSdkAct", "set title header VISIBLE");
      localView2.setVisibility(0);
      localView1.setVisibility(0);
    }
    for (;;)
    {
      return;
      LogUtils.d("HomeSdkAct", "set title header GONE");
      localView2.setVisibility(8);
      localView1.setVisibility(8);
    }
  }
  
  public final void b()
  {
    if (this.e != null) {}
    try
    {
      this.e.stopVpn();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        localRemoteException.printStackTrace();
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      if (paramInt2 == -1)
      {
        LogUtils.i("HomeSdkAct", "onActivityResult--resultCode--RESULT_OK");
        if (this.h != null) {
          LogUtils.d("HomeSdkAct", "----CONNTECT_VPN_CLICK_SURE--");
        }
        this.r.sendEmptyMessage(13);
        this.r.sendEmptyMessage(11);
      }
      else
      {
        LogUtils.i("HomeSdkAct", "onActivityResult--resultCode--RESULT_Not_OK");
        this.f.setEnabled(true);
        this.r.sendEmptyMessage(12);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == ResTool.getViewId("button_start_vpn", this.y)) {
      if (UserUtils.isVpnStart(this))
      {
        if (this.o == null)
        {
          paramView = new CustomDialog.Builder(this);
          paramView.setTitle(getResources().getString(ResTool.getStringId("dialog_title", this.y)));
          paramView.setPositiveButton(getResources().getString(ResTool.getStringId("dialog_positive_button", this.y)), new d(this));
          paramView.setNegativeButton(getResources().getString(ResTool.getStringId("dialog_negative_button", this.y)), new e(this));
          this.o = paramView.create();
        }
        this.o.show();
      }
    }
    for (;;)
    {
      return;
      new Thread(new g(this)).start();
      continue;
      if (paramView.getId() == ResTool.getViewId("guide_button", this.y))
      {
        this.i.setVisibility(8);
        startActivityForResult(this.h, 1);
      }
      else if (paramView.getId() == ResTool.getViewId("act_title", this.y))
      {
        finish();
      }
      else if (paramView.getId() == ResTool.getViewId("tv_safe_title_text", this.y))
      {
        finish();
      }
      else if (paramView.getId() == ResTool.getViewId("button_download_vpn_app", this.y))
      {
        paramView = new Intent("wifi.intent.action.BROWSER", Uri.parse("http://vpn.lianwifi.com:8080/VpnDownloadPage/vpn_page/vpn_download.jsp"));
        paramView.setPackage(getPackageName());
        paramView.addFlags(268435456);
        startActivity(paramView);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    LogUtils.d("aaa", "home onCreate");
    setIntent(getIntent());
    if (this.e == null)
    {
      Intent localIntent = new Intent(this, SafeVpnService.class);
      String str = UserUtils.getDhid(this);
      paramBundle = UserUtils.getUhid(this);
      LogUtils.d("HomeSdkAct", "dhid:" + str + ";;;;uhid:" + paramBundle);
      localIntent.setAction(VpnConstants.Action.ACTION_START_VPN_SERVICE);
      bindService(localIntent, this, 1);
      startService(new Intent(this, SafeVpnService.class));
    }
    this.y = getApplicationContext();
    setContentView(ResTool.getLayoutId("sc_act_vpn_home", this.y));
    this.d = ((ScoreView)findViewById(ResTool.getViewId("score_view", this.y)));
    this.f = ((Button)findViewById(ResTool.getViewId("button_start_vpn", this.y)));
    this.g = ((ImageView)findViewById(ResTool.getViewId("button_download_vpn_app", this.y)));
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.f.setEnabled(true);
    this.u = findViewById(ResTool.getViewId("vpn_protected_shop_cover", this.y));
    this.v = findViewById(ResTool.getViewId("vpn_protected_game_cover", this.y));
    this.w = findViewById(ResTool.getViewId("vpn_protected_chat_cover", this.y));
    this.x = findViewById(ResTool.getViewId("vpn_protected_email_cover", this.y));
    this.s = ((ImageView)findViewById(ResTool.getViewId("tv_safe_title_text", this.y)));
    this.s.setOnClickListener(this);
    this.i = findViewById(ResTool.getViewId("guide_layout", this.y));
    ((ImageView)findViewById(ResTool.getViewId("act_title", this.y))).setOnClickListener(this);
    findViewById(ResTool.getViewId("guide_button", this.y)).setOnClickListener(this);
    this.t = WifiSecCheckVpnImpl.getInstance().getmStartVpnListener().getWifiCheckScore();
    if (this.t != null)
    {
      LogUtils.d("HomeSdkAct", "mStartVpnListener WifiCheckScore:" + this.t);
      a(this.t.intValue());
      paramBundle = VpnUtils.getInstance().getAppConfRes();
      if ((paramBundle != null) && (paramBundle.getReturnCode() == AppConfRes.ReturnCode.SUCC))
      {
        if (!paramBundle.isNeedShowAppDownloadButton()) {
          break label516;
        }
        this.g.setVisibility(0);
      }
    }
    for (;;)
    {
      if ((UserUtils.isVpnStart(this.y)) && (SvpnShared.getInstance().isVpnStarted())) {
        d();
      }
      return;
      this.t = Integer.valueOf(66);
      a(66);
      break;
      label516:
      this.g.setVisibility(8);
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    LogUtils.d("HomeSdkAct", "home destroy");
    LogUtils.d("HomeSdkAct", "deattachService");
    if (this.e != null) {
      LogUtils.d("HomeSdkAct", "bgService != null do deattachService");
    }
    try
    {
      this.e.unregisterCallback(this.n);
      this.e = null;
      unbindService(this);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        LogUtils.d("HomeSdkAct", "deattachService got exception");
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    LogUtils.d("HomeSdkAct", "serviceConnected ==" + paramIBinder);
    this.e = VpnServiceInterface.Stub.asInterface(paramIBinder);
    try
    {
      this.e.registerCallback(this.n);
      return;
    }
    catch (RemoteException paramComponentName)
    {
      for (;;)
      {
        paramComponentName.printStackTrace();
      }
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
  
  protected void onStart()
  {
    super.onStart();
    this.d.onActStart();
  }
  
  protected void onStop()
  {
    super.onStop();
    this.d.onActStop();
    LogUtils.d("aaa", "home onStop");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/e/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */