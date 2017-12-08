package com.lantern.dynamictab.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import bluefay.app.ViewPagerFragment;
import bluefay.app.u;
import bluefay.app.w;
import com.bluefay.b.h;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.core.c;
import com.lantern.dynamictab.R.drawable;
import com.lantern.dynamictab.R.layout;
import com.lantern.dynamictab.R.string;
import com.lantern.dynamictab.b.a.a;
import com.lantern.dynamictab.e.e;

public class FriendFragment
  extends ViewPagerFragment
  implements AdapterView.OnItemClickListener
{
  private com.lantern.dynamictab.a.a g;
  private int[] h = { 128710 };
  private com.bluefay.d.b i = new a(this, this.h);
  
  private static void a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = new Intent();
      localIntent.setAction("wifi.intent.action.BROWSER");
      localIntent.setData(Uri.parse(paramString));
      localIntent.setPackage(paramContext.getPackageName());
      paramContext.startActivity(localIntent);
      h.a("Friend %s", new Object[] { "h5 scheme success!" });
    }
  }
  
  private void c()
  {
    if (((w)getActivity()).a("TAB_TAG_FRIEND") == 0) {
      com.lantern.analytics.a.e().onEvent("dyTabC_n");
    }
    for (;;)
    {
      com.lantern.dynamictab.e.b.a().d();
      return;
      com.lantern.analytics.a.e().onEvent("dyTabC_y");
    }
  }
  
  public final void a(Context paramContext)
  {
    a(this.e.getString(R.string.friends_actionbar_title));
    a(a, new u(this.e));
    b().f(R.drawable.common_actionbar_logo);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = (ListView)paramLayoutInflater.inflate(R.layout.friend_fragment_main, paramViewGroup, false);
    this.g = new com.lantern.dynamictab.a.a(getActivity());
    paramLayoutInflater.setAdapter(this.g);
    paramLayoutInflater.setOnItemClickListener(this);
    c.addListener(this.i);
    c();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    c.removeListener(this.i);
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean) {
      c();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a.a locala = (a.a)this.g.getItem(paramInt);
    Object localObject = com.lantern.dynamictab.e.b.a().a.b(locala.a);
    if (localObject != null)
    {
      paramView = "";
      if (!TextUtils.isEmpty(((com.lantern.dynamictab.b.b)localObject).b)) {
        paramView = "" + "_i";
      }
      paramAdapterView = paramView;
      if (TextUtils.isEmpty(((com.lantern.dynamictab.b.b)localObject).b))
      {
        paramAdapterView = paramView;
        if (!TextUtils.isEmpty(((com.lantern.dynamictab.b.b)localObject).c)) {
          paramAdapterView = paramView + "_m";
        }
      }
      paramView = paramAdapterView;
      if (((com.lantern.dynamictab.b.b)localObject).f) {
        paramView = paramAdapterView + "_n";
      }
      paramAdapterView = paramView;
      if (((com.lantern.dynamictab.b.b)localObject).e > 0) {
        paramAdapterView = paramView + "_c";
      }
      com.lantern.analytics.a.e().onEvent("dy_" + locala.a + "_cs" + paramAdapterView);
    }
    com.lantern.dynamictab.e.b.a().a.c(locala.a);
    if (!TextUtils.isEmpty(locala.h)) {}
    for (;;)
    {
      try
      {
        Activity localActivity = getActivity();
        String str = locala.a;
        paramView = locala.h;
        if (localObject == null)
        {
          paramAdapterView = null;
          localObject = new android/content/Intent;
          ((Intent)localObject).<init>("android.intent.action.VIEW");
          ((Intent)localObject).setPackage(str);
          ((Intent)localObject).setFlags(335544320);
          ((Intent)localObject).setData(Uri.parse(paramView));
          if (!TextUtils.isEmpty(paramAdapterView)) {
            ((Intent)localObject).putExtra("DATA", paramAdapterView);
          }
          localActivity.startActivity((Intent)localObject);
          h.a("Friend %s", new Object[] { "native scheme success!" });
          paramView = com.lantern.analytics.a.e();
          paramAdapterView = new java/lang/StringBuilder;
          paramAdapterView.<init>("dy_");
          paramView.onEvent(locala.a + "_c_n");
          return;
        }
      }
      catch (Exception paramAdapterView)
      {
        h.a("Friend %s", new Object[] { "native scheme failed!" });
        if (TextUtils.isEmpty(locala.g)) {
          continue;
        }
        a(getActivity(), locala.g);
        com.lantern.analytics.a.e().onEvent("dy_" + locala.a + "_c_h");
        continue;
      }
      paramAdapterView = ((com.lantern.dynamictab.b.b)localObject).d;
      continue;
      if (!TextUtils.isEmpty(locala.g))
      {
        a(getActivity(), locala.g);
        com.lantern.analytics.a.e().onEvent("dy_" + locala.a + "_c_h");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/ui/FriendFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */