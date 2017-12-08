package com.lantern.wifitools.examination;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.app.Fragment;
import com.lantern.core.c;
import com.lantern.core.g.u;
import com.lantern.wifiseccheck.WifiSecCheckManager;
import com.lantern.wifiseccheck.WifiSecCheckManager.WifiCheckListener;
import com.lantern.wifitools.R.drawable;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.layout;
import com.lantern.wifitools.R.string;
import com.lantern.wifitools.a.h;
import com.lantern.wifitools.view.CustomTextView;
import java.lang.ref.WeakReference;

public class ExaminationFragment
  extends Fragment
{
  private ImageView g;
  private ImageView h;
  private ImageView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private TextView m;
  private View n;
  private View o;
  private CustomTextView p;
  private Bundle q;
  private long r;
  private Handler s = new b(this);
  private WifiSecCheckManager.WifiCheckListener t;
  private boolean u = false;
  
  private void a(ImageView paramImageView, long paramLong)
  {
    this.s.postAtTime(new j(this, paramImageView, paramLong), paramLong);
  }
  
  private void b(ImageView paramImageView, long paramLong)
  {
    this.s.postAtTime(new k(this, paramImageView, paramLong), paramLong);
  }
  
  private static Animation c()
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setInterpolator(new LinearInterpolator());
    localRotateAnimation.setRepeatCount(-1);
    localRotateAnimation.setFillAfter(true);
    localRotateAnimation.setDuration(1200L);
    return localRotateAnimation;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    new a((byte)0).execute(new View[0]);
    a(R.string.exam_title);
    this.q = getActivity().getIntent().getExtras();
    if ((this.q == null) || (this.q.getInt("security", -1) == -1))
    {
      this.q = new Bundle();
      paramBundle = u.b(c.getInstance());
      if ((paramBundle != null) && (paramBundle.allowedKeyManagement != null))
      {
        this.q.putString("ssid", h.a(paramBundle.SSID));
        this.q.putString("bssid", paramBundle.BSSID);
        this.q.putInt("security", u.a(paramBundle));
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.wifitools_exam_view, paramViewGroup, false);
    this.g = ((ImageView)paramLayoutInflater.findViewById(R.id.safe_icon));
    this.h = ((ImageView)paramLayoutInflater.findViewById(R.id.speed_icon));
    this.i = ((ImageView)paramLayoutInflater.findViewById(R.id.device_icon));
    this.j = ((TextView)paramLayoutInflater.findViewById(R.id.safe_text));
    this.k = ((TextView)paramLayoutInflater.findViewById(R.id.speed_text));
    this.l = ((TextView)paramLayoutInflater.findViewById(R.id.device_text));
    this.m = ((TextView)paramLayoutInflater.findViewById(R.id.wifi_name));
    this.n = paramLayoutInflater.findViewById(R.id.anim_view);
    this.o = paramLayoutInflater.findViewById(R.id.result_view);
    this.p = ((CustomTextView)paramLayoutInflater.findViewById(R.id.percent));
    paramViewGroup = ((ConnectivityManager)this.e.getSystemService("connectivity")).getNetworkInfo(1);
    if ((paramViewGroup != null) && (paramViewGroup.isConnected()))
    {
      long l1 = SystemClock.uptimeMillis();
      a((ImageView)paramLayoutInflater.findViewById(R.id.boom_1), l1 + 600L + 300L);
      a((ImageView)paramLayoutInflater.findViewById(R.id.boom_2), l1 + 600L + 450L);
      a((ImageView)paramLayoutInflater.findViewById(R.id.boom_3), l1 + 600L + 750L);
      a((ImageView)paramLayoutInflater.findViewById(R.id.boom_4), l1 + 600L + 900L);
      a((ImageView)paramLayoutInflater.findViewById(R.id.boom_5), l1 + 600L + 1200L);
      b((ImageView)paramLayoutInflater.findViewById(R.id.rotate), l1 + 600L);
      this.p.a(40, 4000);
      this.r = System.currentTimeMillis();
      this.m.setText(this.q.getString("ssid"));
      this.h.setImageResource(R.drawable.checking);
      this.h.startAnimation(c());
      com.lantern.core.g.j.a().a(new l(this));
    }
    for (;;)
    {
      return paramLayoutInflater;
      Toast.makeText(this.e, R.string.speed_test_nowifi, 0).show();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.t != null) {
      WifiSecCheckManager.getInstance().stopCheck(this.t);
    }
  }
  
  private final class a
    extends AsyncTask<View, Void, String>
  {
    private a() {}
    
    private void a()
    {
      ExaminationFragment.i(ExaminationFragment.this);
    }
  }
  
  private static final class b
    extends Handler
  {
    private final WeakReference<ExaminationFragment> a;
    
    b(ExaminationFragment paramExaminationFragment)
    {
      this.a = new WeakReference(paramExaminationFragment);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      ExaminationFragment localExaminationFragment = (ExaminationFragment)this.a.get();
      if (localExaminationFragment != null) {
        ExaminationFragment.a(localExaminationFragment, paramMessage);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/ExaminationFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */