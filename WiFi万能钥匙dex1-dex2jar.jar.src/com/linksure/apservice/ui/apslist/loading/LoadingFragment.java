package com.linksure.apservice.ui.apslist.loading;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import bluefay.app.Fragment;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.a.i;
import com.linksure.apservice.ui.apslist.ApsListActivity;

public class LoadingFragment
  extends Fragment
  implements View.OnClickListener, a.b
{
  a.a g;
  private View h;
  private View i;
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.i.setVisibility(0);
    }
    for (;;)
    {
      return;
      this.i.setVisibility(4);
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.h.setVisibility(0);
    }
    for (;;)
    {
      return;
      this.h.setVisibility(4);
    }
  }
  
  public final void h_()
  {
    ApsListActivity localApsListActivity = (ApsListActivity)getActivity();
    if (localApsListActivity != null) {
      localApsListActivity.h();
    }
  }
  
  public final void i_()
  {
    ApsListActivity localApsListActivity = (ApsListActivity)getActivity();
    if (localApsListActivity != null) {
      localApsListActivity.g();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.aps_404_retry)
    {
      paramView = this.g;
      getActivity();
      paramView.c();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = new b(this, i.a(getActivity()));
    paramBundle = this.g;
    getActivity();
    paramBundle.c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.aps_fragment_loading, null);
    this.h = paramLayoutInflater.findViewById(R.id.aps_404);
    this.i = paramLayoutInflater.findViewById(R.id.aps_progress_bar);
    paramLayoutInflater.findViewById(R.id.aps_404_retry).setOnClickListener(this);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    this.g.b();
  }
  
  public void onResume()
  {
    super.onResume();
    this.g.a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/loading/LoadingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */