package com.lantern.push.ui;

import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import bluefay.app.Fragment;
import bluefay.app.k.a;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;

public class MessageFragment
  extends Fragment
{
  private com.bluefay.material.f g;
  private h h;
  private RelativeLayout i;
  private NotificationManager j;
  private AdapterView.OnItemLongClickListener k = new e(this);
  private AdapterView.OnItemClickListener l = new f(this);
  private com.bluefay.b.a m = new g(this);
  
  private void d()
  {
    if (this.g == null)
    {
      this.g = new com.bluefay.material.f(this.e);
      this.g.a(getString(R.string.pull_to_refresh_footer_refreshing_label));
      this.g.setCanceledOnTouchOutside(false);
      this.g.setOnCancelListener(new a(this));
    }
    this.g.show();
    new com.lantern.push.c.a(this.e, this.m).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
  }
  
  public final void c()
  {
    d();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.h = new h(this.e);
    this.j = ((NotificationManager)this.e.getSystemService("notification"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(R.layout.settings_push_message_list, null);
    this.i = ((RelativeLayout)paramViewGroup.findViewById(R.id.settings_empty_message));
    paramLayoutInflater = (ListView)paramViewGroup.findViewById(R.id.settings_lv_push);
    paramLayoutInflater.setOnItemClickListener(this.l);
    paramLayoutInflater.setOnItemLongClickListener(this.k);
    paramLayoutInflater.setAdapter(this.h);
    d();
    return paramViewGroup;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 1)
    {
      com.lantern.analytics.a.e().onEvent("msgrd");
      if (this.h.getCount() != 0)
      {
        k.a locala = new k.a(this.e);
        locala.a(R.string.settings_push_mark_readed);
        locala.b(R.string.settings_push_mark_readed_confirm);
        locala.a(17039370, new b(this));
        locala.b(17039360, new c(this));
        locala.d();
        com.lantern.analytics.a.e().onEvent("msgrdshow");
      }
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = b();
    if (paramView != null)
    {
      paramView.d(1);
      paramView.c(8);
    }
    a(R.string.settings_pref_message_title);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/ui/MessageFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */