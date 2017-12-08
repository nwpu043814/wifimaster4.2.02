package com.bluefay.preference;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import bluefay.app.p;
import bluefay.preference.Preference;
import bluefay.preference.Preference.b;
import bluefay.preference.PreferenceFragment;
import bluefay.preference.PreferenceScreen;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.bluefay.framework.R.layout;

public class PSPreferenceFragment
  extends PreferenceFragment
  implements Preference.b, a
{
  protected String g;
  protected int h;
  public SettingsDialogFragment i;
  private View.OnClickListener j = new b(this);
  private Handler k = new c(this);
  
  public static void e() {}
  
  public final void a()
  {
    this.k.sendEmptyMessage(100);
  }
  
  protected final void a(int paramInt)
  {
    super.a(paramInt);
    PreferenceScreen localPreferenceScreen = d();
    if (localPreferenceScreen != null) {
      localPreferenceScreen.e(paramInt);
    }
  }
  
  public final void a(Preference paramPreference)
  {
    if (paramPreference != null)
    {
      PreferenceScreen localPreferenceScreen = d();
      if (localPreferenceScreen != null) {
        localPreferenceScreen.c(paramPreference);
      }
    }
  }
  
  protected final void a(CharSequence paramCharSequence)
  {
    super.a(paramCharSequence);
    PreferenceScreen localPreferenceScreen = d();
    if (localPreferenceScreen != null) {
      localPreferenceScreen.b(paramCharSequence);
    }
  }
  
  public final void a(String paramString, Bundle paramBundle)
  {
    ((p)getActivity()).a(paramString, paramBundle);
  }
  
  public boolean a(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    h.a("onPreferenceTreeClick preference:" + paramPreference, new Object[0]);
    if (paramPreference.k() != null)
    {
      paramPreferenceScreen = paramPreference.k();
      e.a(this.e, paramPreferenceScreen);
    }
    for (;;)
    {
      return true;
      if (paramPreference.l() != null) {
        a(paramPreference.l(), paramPreference.m());
      }
    }
  }
  
  public final boolean b_()
  {
    h.a("onPreferenceChange", new Object[0]);
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h.a("onCreate:" + this, new Object[0]);
    this.e = getActivity();
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.h = paramBundle.getInt("requestCode");
      this.g = paramBundle.getString("tag");
      if (this.h > 0) {
        h.a("This fragement is asked to set fragment result, request code:" + this.h + " mRequestTag:" + this.g, new Object[0]);
      }
      paramBundle.getParcelable("intent");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.framework_preference_list_fragment, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    h.a("onDestroy:" + this, new Object[0]);
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    h.a("onDestroyView:" + this, new Object[0]);
  }
  
  public void onDetach()
  {
    if ((isRemoving()) && (this.i != null))
    {
      this.i.dismiss();
      this.i = null;
    }
    super.onDetach();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = d();
    if (paramBundle != null)
    {
      if (!paramBundle.g()) {
        break label105;
      }
      a_(a, 0);
      a(paramBundle.r());
    }
    for (;;)
    {
      paramView.setBackgroundResource(paramBundle.f());
      h.a("onViewCreated:" + this, new Object[0]);
      paramView = (String)e.a(this, Fragment.class, "mWho");
      h.a("who:" + paramView, new Object[0]);
      return;
      label105:
      a_(a, 8);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/preference/PSPreferenceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */