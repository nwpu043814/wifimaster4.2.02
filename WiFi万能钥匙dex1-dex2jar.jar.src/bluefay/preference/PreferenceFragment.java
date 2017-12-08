package bluefay.preference;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.ListView;
import bluefay.app.Fragment;
import com.bluefay.framework.R.layout;

public abstract class PreferenceFragment
  extends Fragment
  implements r.d
{
  private r g;
  private ListView h;
  private boolean i;
  private boolean j;
  private Handler k = new l(this);
  private final Runnable l = new m(this);
  private View.OnKeyListener m = new n(this);
  
  private void e()
  {
    PreferenceScreen localPreferenceScreen = d();
    if (localPreferenceScreen != null)
    {
      if (this.h == null)
      {
        View localView = getView();
        if (localView == null) {
          throw new IllegalStateException("Content view not yet created");
        }
        localView = localView.findViewById(16908298);
        if (!(localView instanceof ListView)) {
          throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
        }
        this.h = ((ListView)localView);
        if (this.h == null) {
          throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
        }
        this.h.setOnKeyListener(this.m);
        this.k.post(this.l);
      }
      localPreferenceScreen.a(this.h);
    }
  }
  
  public boolean a(PreferenceScreen paramPreferenceScreen, Preference paramPreference)
  {
    if ((paramPreference.l() != null) && ((getActivity() instanceof a))) {}
    for (boolean bool = ((a)getActivity()).a();; bool = false) {
      return bool;
    }
  }
  
  public final Preference b(CharSequence paramCharSequence)
  {
    if (this.g == null) {}
    for (paramCharSequence = null;; paramCharSequence = this.g.a(paramCharSequence)) {
      return paramCharSequence;
    }
  }
  
  public final r c()
  {
    return this.g;
  }
  
  public final PreferenceScreen d()
  {
    if (this.g != null) {}
    for (PreferenceScreen localPreferenceScreen = this.g.d();; localPreferenceScreen = null) {
      return localPreferenceScreen;
    }
  }
  
  public final void d(int paramInt)
  {
    if (this.g == null) {
      throw new RuntimeException("This should be called after super.onCreate.");
    }
    PreferenceScreen localPreferenceScreen = this.g.a(getActivity(), paramInt, d());
    if ((this.g.a(localPreferenceScreen)) && (localPreferenceScreen != null))
    {
      this.i = true;
      if ((this.j) && (!this.k.hasMessages(1))) {
        this.k.obtainMessage(1).sendToTarget();
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (this.i) {
      e();
    }
    this.j = true;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getBundle("android:preferences");
      if (paramBundle != null)
      {
        PreferenceScreen localPreferenceScreen = d();
        if (localPreferenceScreen != null) {
          localPreferenceScreen.b(paramBundle);
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.g.a(paramInt1, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = new r(getActivity());
    this.g.a(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.framework_preference_list_fragment, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.g.i();
  }
  
  public void onDestroyView()
  {
    this.h = null;
    this.k.removeCallbacks(this.l);
    this.k.removeMessages(1);
    super.onDestroyView();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    PreferenceScreen localPreferenceScreen = d();
    if (localPreferenceScreen != null)
    {
      Bundle localBundle = new Bundle();
      localPreferenceScreen.a(localBundle);
      paramBundle.putBundle("android:preferences", localBundle);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.g.a(this);
  }
  
  public void onStop()
  {
    super.onStop();
    this.g.h();
    this.g.a(null);
  }
  
  public static abstract interface a
  {
    public abstract boolean a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/PreferenceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */