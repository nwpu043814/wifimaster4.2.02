package com.linksure.apservice.ui.category;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import bluefay.app.Fragment;
import com.linksure.apservice.R.anim;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;
import com.linksure.apservice.ui.category.widget.ApsListView;
import com.linksure.apservice.ui.category.widget.ApsListView.a;
import com.linksure.apservice.ui.common.SearchActivity;
import com.linksure.apservice.ui.home.ApServiceActivity;
import com.linksure.apservice.ui.profile.ProfileActivity;
import java.util.List;

public class CategoryFragment
  extends Fragment
  implements b.b, ApsListView.a
{
  private static final int[] t = { 128500 };
  private ListView g;
  private ApsListView h;
  private a i;
  private k j;
  private b.a k;
  private com.bluefay.material.f l;
  private View m = null;
  private View n = null;
  private com.linksure.apservice.b.c o = null;
  private String p = "top";
  private int q = 1;
  private boolean r = false;
  private ProgressBar s;
  private com.bluefay.d.b u = new c(this, t);
  private View.OnClickListener v = new d(this);
  private AdapterView.OnItemClickListener w = new g(this);
  private AdapterView.OnItemClickListener x = new h(this);
  private k.a y = new i(this);
  
  private void e()
  {
    if (this.l != null)
    {
      this.l.hide();
      this.l.dismiss();
      this.l = null;
    }
  }
  
  final void a(com.linksure.apservice.b.c paramc)
  {
    Intent localIntent = new Intent(getActivity(), ApServiceActivity.class);
    localIntent.putExtra("aps_id", paramc.a);
    localIntent.putExtra("refer", "rcmd");
    com.bluefay.a.e.a(this.e, localIntent);
  }
  
  public final void a(List<com.linksure.apservice.b.b> paramList)
  {
    boolean bool = true;
    e();
    if (paramList.size() > 1)
    {
      this.g.setVisibility(0);
      this.i = new a(this.e, paramList);
      this.g.setAdapter(this.i);
      this.g.setItemChecked(0, true);
    }
    k localk = this.j;
    if (paramList.size() > 1) {
      bool = false;
    }
    localk.a(bool);
    this.k.a(((com.linksure.apservice.b.b)paramList.get(0)).a, this.q);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.o.g = true;
      com.linksure.apservice.b.c localc = this.o;
      localc.f += 1;
      this.j.notifyDataSetChanged();
      com.bluefay.a.e.a(this.e, this.e.getString(R.string.aps_follow_success));
    }
    for (;;)
    {
      return;
      com.bluefay.a.e.a(this.e, this.e.getString(R.string.aps_follow_fail2));
    }
  }
  
  final void b(com.linksure.apservice.b.c paramc)
  {
    this.r = true;
    com.linksure.apservice.b.a locala = new com.linksure.apservice.b.a();
    locala.k = paramc.a;
    locala.n = paramc.c;
    locala.l = paramc.b;
    locala.o = paramc.e;
    locala.e = paramc.g;
    paramc = new Intent(getActivity(), ProfileActivity.class);
    paramc.putExtra("obj", locala);
    paramc.putExtra("refer", "search");
    com.bluefay.a.e.a(this.e, paramc);
  }
  
  public final void b(List<com.linksure.apservice.b.c> paramList)
  {
    this.j.a(paramList, this.p);
    this.q += 1;
    this.h.b();
    this.s.setVisibility(8);
    ApsListView localApsListView = this.h;
    if (paramList.size() < 10) {}
    for (boolean bool = false;; bool = true)
    {
      localApsListView.a(bool);
      return;
    }
  }
  
  public final void c()
  {
    e();
    this.n.setVisibility(0);
    this.m.setVisibility(8);
    this.s.setVisibility(8);
  }
  
  public final void d()
  {
    if (!"top".equals(this.p)) {
      this.k.a(this.p, this.q);
    }
    for (;;)
    {
      return;
      this.h.b();
    }
  }
  
  public final void l_()
  {
    com.bluefay.a.e.a(R.string.aps_black);
  }
  
  public final void m_()
  {
    View localView = LayoutInflater.from(getActivity()).inflate(R.layout.aps_dialog_login, null);
    AlertDialog localAlertDialog = new AlertDialog.Builder(getActivity()).setView(localView).create();
    localView.findViewById(R.id.aps_dialog_cancel).setOnClickListener(new e(this, localAlertDialog));
    localView.findViewById(R.id.aps_dialog_ok).setOnClickListener(new f(this, localAlertDialog));
    localAlertDialog.show();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.lantern.core.c.addListener(this.u);
    paramBundle = new m(this.e, this);
    this.k = paramBundle;
    paramBundle.a();
    paramBundle.c();
    paramBundle = this.e.getString(R.string.aps_category_load_more);
    if ((this.l == null) || (!this.l.isShowing()))
    {
      this.l = new com.bluefay.material.f(this.e);
      this.l.a(paramBundle);
      this.l.setCanceledOnTouchOutside(false);
      this.l.setOnCancelListener(new j(this));
      this.l.show();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.aps_category, paramViewGroup, false);
    paramLayoutInflater.findViewById(R.id.aps_404_retry).setOnClickListener(this.v);
    this.m = paramLayoutInflater.findViewById(R.id.container);
    this.s = ((ProgressBar)paramLayoutInflater.findViewById(R.id.aps_progress_bar));
    this.n = paramLayoutInflater.findViewById(R.id.aps_404);
    this.g = ((ListView)paramLayoutInflater.findViewById(R.id.lv_category));
    this.g.setOnItemClickListener(this.w);
    this.h = ((ApsListView)paramLayoutInflater.findViewById(R.id.aps_category_lists));
    this.h.setOnItemClickListener(this.x);
    this.h.a(paramLayoutInflater.findViewById(R.id.aps_list_loading));
    this.h.a(this);
    this.j = new k(this.e);
    this.h.setAdapter(this.j);
    this.j.a(this.y);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.k.b();
    com.lantern.core.c.removeListener(this.u);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    if (1000 == paramMenuItem.getItemId())
    {
      this.r = true;
      paramMenuItem = new Intent(getActivity(), SearchActivity.class);
      com.bluefay.a.e.a(this.e, paramMenuItem);
      getActivity().overridePendingTransition(R.anim.framework_dialog_open_enter, R.anim.aps_activity_stay);
      com.linksure.apservice.utils.b.d("salssrcli");
    }
    for (;;)
    {
      return bool;
      bool = super.onOptionsItemSelected(paramMenuItem);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.r = false;
    com.linksure.apservice.utils.b.d("salssh");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/category/CategoryFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */