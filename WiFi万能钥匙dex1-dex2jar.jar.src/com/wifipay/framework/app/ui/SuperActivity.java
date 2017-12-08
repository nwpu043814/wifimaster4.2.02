package com.wifipay.framework.app.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.analysis.analytics.ALInterface;
import com.wifipay.R.anim;
import com.wifipay.R.color;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.net.UnifyDispose;
import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.framework.app.b;
import com.wifipay.framework.service.IFragmentSwitchListener;
import com.wifipay.framework.service.ITitleBarListener;
import com.wifipay.framework.widget.WPAlertDialog.onNegativeListener;
import com.wifipay.framework.widget.WPAlertDialog.onPositiveListener;
import com.wifipay.framework.widget.WPTitleBar;
import java.util.List;

public class SuperActivity
  extends FragmentActivity
{
  private static boolean s = true;
  protected FragmentManager a;
  protected Animation b;
  protected Animation c;
  public final int d = 10201;
  public final int e = 10202;
  public final int f = R.color.wifipay_color_0286EE;
  protected b g;
  private a h;
  private LayoutInflater i;
  private FrameLayout j;
  private WPTitleBar k;
  private ITitleBarListener l = new g(this);
  private boolean m = false;
  private int n = -1;
  private SparseArray<a> o;
  private a p;
  private int q;
  private IFragmentSwitchListener r = new h(this);
  
  private FragmentTransaction a(int paramInt, FragmentTransaction paramFragmentTransaction)
  {
    a locala = (a)this.o.get(paramInt);
    if (locala == null) {
      throw new IllegalStateException("No fragment known for tag " + paramInt);
    }
    FragmentTransaction localFragmentTransaction = paramFragmentTransaction;
    if (locala != this.p)
    {
      localFragmentTransaction = paramFragmentTransaction;
      if (paramFragmentTransaction == null) {
        localFragmentTransaction = this.a.beginTransaction();
      }
      if ((this.p != null) && (a.a(this.p) != null)) {
        localFragmentTransaction.hide(a.a(this.p));
      }
      if (locala != null)
      {
        if (a.a(locala) != null) {
          break label177;
        }
        a.a(locala, (BaseFragment)Fragment.instantiate(this, a.b(locala).getName(), a.c(locala)));
        a.a(locala).a(this.r);
        localFragmentTransaction.add(this.q, a.a(locala), String.valueOf(a.d(locala)));
      }
    }
    for (;;)
    {
      this.p = locala;
      return localFragmentTransaction;
      label177:
      localFragmentTransaction.show(a.a(locala));
    }
  }
  
  private View a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.j == null) {
      i();
    }
    for (;;)
    {
      this.j.addView(paramView, paramLayoutParams);
      return (View)this.j.getParent();
      this.j.removeAllViews();
    }
  }
  
  private void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    a locala = (a)this.o.get(paramInt);
    if (locala == null) {
      throw new IllegalStateException("No fragment known for tag " + paramInt);
    }
    this.n = paramInt;
    if (paramBoolean)
    {
      a.a(locala, paramBundle);
      if (a.a(locala) != null) {
        a.a(locala).a(paramBundle);
      }
    }
    if (this.m)
    {
      paramBundle = a(paramInt, null);
      if (paramBundle != null) {
        paramBundle.commit();
      }
    }
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    a(paramInt, true, paramBundle);
  }
  
  private View e(int paramInt)
  {
    if (this.j == null) {
      i();
    }
    for (;;)
    {
      this.i.inflate(paramInt, this.j);
      return (View)this.j.getParent();
      this.j.removeAllViews();
    }
  }
  
  private void f(int paramInt)
  {
    a(paramInt, false, null);
  }
  
  private void i()
  {
    View localView = this.i.inflate(R.layout.wifipay_framework_activity_base, null);
    super.setContentView(localView);
    this.j = ((FrameLayout)localView.findViewById(R.id.wifipay_c_content));
    this.k = ((WPTitleBar)localView.findViewById(R.id.wifipay_title_bar));
    this.k.setTitleClickListener(this.l);
    a(true);
    b(R.id.wifipay_c_content);
  }
  
  private ActivityManager.RunningTaskInfo j()
  {
    Object localObject = ((ActivityManager)getSystemService("activity")).getRunningTasks(1);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {}
    for (localObject = (ActivityManager.RunningTaskInfo)((List)localObject).get(0);; localObject = null) {
      return (ActivityManager.RunningTaskInfo)localObject;
    }
  }
  
  private boolean k()
  {
    Object localObject = j();
    if (localObject != null)
    {
      localObject = ((ActivityManager.RunningTaskInfo)localObject).topActivity;
      if ((localObject == null) || (!((ComponentName)localObject).getPackageName().equals(getPackageName())) || (!((ComponentName)localObject).getClassName().equals(getClass().getName()))) {}
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.k != null) {
      this.k.setVisibility(paramInt);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (paramBundle != null) {
      b(paramInt, paramBundle);
    }
    for (;;)
    {
      return;
      if ((f() != -1) && (paramInt != f())) {
        f(paramInt);
      }
    }
  }
  
  public void a(int paramInt, Class<?> paramClass, Bundle paramBundle)
  {
    if (this.o == null) {
      this.o = new SparseArray(2);
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new a(paramInt, paramClass, localBundle);
    if (this.m)
    {
      a.a(paramBundle, (BaseFragment)this.a.findFragmentByTag(String.valueOf(paramInt)));
      if ((a.a(paramBundle) != null) && (!a.a(paramBundle).isDetached()))
      {
        paramClass = this.a.beginTransaction();
        paramClass.detach(a.a(paramBundle));
        paramClass.commit();
      }
    }
    this.o.put(paramInt, paramBundle);
    if (this.n == -1) {
      f(paramInt);
    }
  }
  
  protected void a(Intent paramIntent) {}
  
  protected void a(UnifyDispose paramUnifyDispose) {}
  
  public void a(CharSequence paramCharSequence)
  {
    if (this.k != null) {
      this.k.setContent(paramCharSequence);
    }
  }
  
  public void a(String paramString)
  {
    this.h.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, WPAlertDialog.onPositiveListener paramonPositiveListener)
  {
    a(null, paramString1, paramString2, paramonPositiveListener, null, null);
  }
  
  public void a(String paramString1, String paramString2, WPAlertDialog.onPositiveListener paramonPositiveListener, View paramView)
  {
    a(paramString1, null, paramString2, paramonPositiveListener, null, null, false, paramView);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, WPAlertDialog.onPositiveListener paramonPositiveListener, String paramString4, WPAlertDialog.onNegativeListener paramonNegativeListener)
  {
    this.h.a(paramString1, paramString2, paramString3, paramonPositiveListener, paramString4, paramonNegativeListener);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, WPAlertDialog.onPositiveListener paramonPositiveListener, String paramString4, WPAlertDialog.onNegativeListener paramonNegativeListener, boolean paramBoolean, View paramView)
  {
    this.h.a(paramString1, paramString2, paramString3, paramonPositiveListener, paramString4, paramonNegativeListener, paramBoolean, paramView);
  }
  
  protected void a(boolean paramBoolean)
  {
    String str = getClass().getSimpleName();
    if ((com.wifipay.common.a.g.a(str, "SelectCardActivity")) || (com.wifipay.common.a.g.a(str, "TakePhotoActivity"))) {}
    for (;;)
    {
      return;
      a(paramBoolean, "0");
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      b(paramBoolean);
      this.g = new b(this);
      this.g.a(true);
      if (!com.wifipay.common.a.g.a("0", paramString)) {
        break label55;
      }
      this.g.b(this.f);
    }
    for (;;)
    {
      return;
      label55:
      this.g.a(Color.parseColor(paramString));
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b(int paramInt)
  {
    if ((FrameLayout)findViewById(paramInt) == null) {
      throw new IllegalStateException("No content FrameLayout found for id " + paramInt);
    }
    this.q = paramInt;
  }
  
  protected void b(UnifyDispose paramUnifyDispose)
  {
    com.wifipay.common.a.a.a(this, getClass().getSimpleName(), "null", "null");
    d(10202);
  }
  
  public void b(String paramString)
  {
    this.h.a(null, paramString, getString(R.string.wifipay_confirm_no_space), null, null, null);
  }
  
  protected void b(boolean paramBoolean)
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    if (paramBoolean) {}
    for (localLayoutParams.flags |= 0x4000000;; localLayoutParams.flags &= 0xFBFFFFFF)
    {
      localWindow.setAttributes(localLayoutParams);
      return;
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public BaseFragment c(int paramInt)
  {
    return (BaseFragment)this.a.findFragmentByTag(String.valueOf(paramInt));
  }
  
  public void c()
  {
    if (this.k != null) {
      this.k.a();
    }
  }
  
  public void c(String paramString)
  {
    this.h.e();
  }
  
  public void d()
  {
    this.h.d();
  }
  
  public void d(int paramInt)
  {
    ALInterface.onResume(this, "WifiLogin@wifiWallet");
    ALInterface.onPause(this, "WifiLogin@wifiWallet");
    h();
    Intent localIntent = new Intent("wifi.intent.action.ADD_ACCOUNT_MAIN");
    localIntent.setPackage("com.snda.wifilocating");
    localIntent.putExtra("srcReq", "2");
    localIntent.putExtra("login_result", true);
    localIntent.putExtra("fromSource", "app_wallet");
    try
    {
      startActivityForResult(localIntent, paramInt);
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
  
  public void d(String paramString)
  {
    paramString = new Intent("wifi.intent.action.BROWSER", Uri.parse(paramString));
    paramString.setPackage("com.snda.wifilocating");
    paramString.addFlags(268435456);
    try
    {
      startActivity(paramString);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void e()
  {
    this.h.e();
  }
  
  public int f()
  {
    return this.n;
  }
  
  public void finish()
  {
    if (EventBus.getDefault().isRegistered(this)) {
      EventBus.getDefault().unregister(this);
    }
    super.finish();
    this.h.c();
  }
  
  public void g()
  {
    d(10201);
  }
  
  protected void h() {}
  
  @Subscribe
  public void handleTokenFailure(UnifyDispose paramUnifyDispose)
  {
    if ((k()) && (s))
    {
      s = false;
      a(paramUnifyDispose.getResponse().resultMessage, "去登录", new i(this, paramUnifyDispose));
    }
    for (;;)
    {
      return;
      a(paramUnifyDispose);
    }
  }
  
  @Subscribe
  public void handlerNullSubscribe(com.wifipay.framework.a.a parama) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 10202)) {
      a(paramIntent);
    }
    boolean bool1;
    if ((paramInt1 == 10201) || (paramInt1 == 10202))
    {
      if (paramInt2 != -1) {
        break label65;
      }
      bool1 = true;
      if (paramInt1 != 10202) {
        break label71;
      }
    }
    for (;;)
    {
      com.wifipay.common.a.a.a(this, bool1, bool2);
      return;
      label65:
      bool1 = false;
      break;
      label71:
      bool2 = false;
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    int i2 = f();
    Object localObject1;
    a locala;
    Object localObject2;
    if (i2 != -1)
    {
      localObject1 = null;
      int i1 = 0;
      while (i1 < this.o.size())
      {
        locala = (a)this.o.valueAt(i1);
        a.a(locala, (BaseFragment)this.a.findFragmentByTag(String.valueOf(a.d(locala))));
        localObject2 = localObject1;
        if (a.a(locala) != null)
        {
          localObject2 = localObject1;
          if (!a.a(locala).isDetached())
          {
            if (a.d(locala) != i2) {
              break label118;
            }
            this.p = locala;
            localObject2 = localObject1;
          }
        }
        i1++;
        localObject1 = localObject2;
        continue;
        label118:
        if (localObject1 != null) {
          break label176;
        }
        localObject1 = this.a.beginTransaction();
      }
    }
    label176:
    for (;;)
    {
      ((FragmentTransaction)localObject1).detach(a.a(locala));
      localObject2 = localObject1;
      break;
      this.m = true;
      localObject1 = a(i2, (FragmentTransaction)localObject1);
      if (localObject1 != null)
      {
        ((FragmentTransaction)localObject1).commit();
        this.a.executePendingTransactions();
      }
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    this.h = new a(this);
    this.i = LayoutInflater.from(this);
    i();
    paramBundle = getTheme().obtainStyledAttributes(new int[] { 16842926 });
    int i1 = paramBundle.getResourceId(0, 0);
    paramBundle.recycle();
    getTheme().obtainStyledAttributes(i1, new int[] { 16842938, 16842939 }).recycle();
    this.a = getSupportFragmentManager();
    this.b = AnimationUtils.loadAnimation(this, R.anim.wifipay_anim_up);
    this.c = AnimationUtils.loadAnimation(this, R.anim.wifipay_anim_down);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.h.a();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.m = false;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.h.a(paramIntent);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
  
  protected void onStart()
  {
    super.onStart();
    ALInterface.onResume(this, getClass().getSimpleName() + "@wifiWallet");
    this.h.b();
  }
  
  protected void onStop()
  {
    super.onStop();
    ALInterface.onPause(this, getClass().getSimpleName() + "@wifiWallet");
  }
  
  public void setContentView(int paramInt)
  {
    e(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    a(paramView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a(paramView, paramLayoutParams);
  }
  
  @Deprecated
  public void setTitle(int paramInt)
  {
    super.setTitle(paramInt);
  }
  
  @Deprecated
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
  
  @Deprecated
  public void setTitleColor(int paramInt)
  {
    super.setTitleColor(paramInt);
  }
  
  static final class a
  {
    private final int a;
    private final Class<?> b;
    private Bundle c;
    private BaseFragment d;
    
    a(int paramInt, Class<?> paramClass, Bundle paramBundle)
    {
      this.a = paramInt;
      this.b = paramClass;
      this.c = paramBundle;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/app/ui/SuperActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */