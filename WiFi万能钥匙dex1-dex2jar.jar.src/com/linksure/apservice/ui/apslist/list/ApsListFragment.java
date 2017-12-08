package com.linksure.apservice.ui.apslist.list;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.app.Fragment;
import bluefay.app.k.a;
import bluefay.support.annotation.Nullable;
import com.bluefay.material.SwipeRefreshLayout;
import com.linksure.apservice.R.drawable;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;
import com.linksure.apservice.ui.apslist.ApsListActivity;
import com.linksure.apservice.ui.home.ApServiceActivity;
import java.util.Collections;
import java.util.List;

public class ApsListFragment
  extends Fragment
  implements a.b
{
  a.a g;
  private ListView h;
  private a i;
  private SwipeRefreshLayout j;
  private Dialog k;
  private ProgressBar l;
  private View m = null;
  
  public final void a(com.linksure.apservice.b.a parama)
  {
    Intent localIntent = new Intent(this.e, ApServiceActivity.class);
    localIntent.putExtra("aps_id", parama.k);
    localIntent.putExtra("refer", "list");
    this.e.startActivity(localIntent);
  }
  
  public final void a(String paramString)
  {
    Toast.makeText(this.e, paramString, 0).show();
  }
  
  public final void a(List<com.linksure.apservice.b.a> paramList)
  {
    this.i.a(paramList);
    this.i.notifyDataSetChanged();
    this.l.setVisibility(8);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.k != null)
      {
        this.k.hide();
        this.k.dismiss();
      }
      String str = getString(R.string.aps_unfollowing);
      com.bluefay.material.f localf = new com.bluefay.material.f(this.e);
      localf.a(str);
      localf.setCancelable(false);
      this.k = localf;
      this.k.show();
    }
    for (;;)
    {
      return;
      if ((this.k != null) && ((this.k instanceof com.bluefay.material.f)))
      {
        this.k.hide();
        this.k.dismiss();
      }
    }
  }
  
  public final void a_(int paramInt)
  {
    Toast.makeText(this.e, paramInt, 0).show();
  }
  
  public final void b(com.linksure.apservice.b.a parama)
  {
    if (this.k != null)
    {
      this.k.hide();
      this.k.dismiss();
    }
    Object localObject = getActivity();
    View localView = LayoutInflater.from((Context)localObject).inflate(R.layout.aps_dialog_unfollow_hint, null);
    localObject = new k.a((Context)localObject).a(localView).c();
    localView.findViewById(R.id.aps_dialog_bg).setOnClickListener(new f(this, (Dialog)localObject, parama));
    ((Dialog)localObject).setCancelable(true);
    ((Dialog)localObject).setCanceledOnTouchOutside(true);
    this.k = ((Dialog)localObject);
    this.k.show();
  }
  
  public final void b(boolean paramBoolean)
  {
    ((ApsListActivity)getActivity()).a(paramBoolean);
  }
  
  public final void c()
  {
    this.m.setVisibility(0);
    this.l.setVisibility(8);
  }
  
  public final void f_()
  {
    this.j.a(false);
  }
  
  public final void g_()
  {
    ((ApsListActivity)getActivity()).h();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = new i(getActivity(), this, com.linksure.apservice.a.i.a(getActivity()), com.linksure.apservice.a.i.b(getActivity()));
    this.i = new a(this.e);
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.aps_fragment_apslist, null);
    this.l = ((ProgressBar)paramLayoutInflater.findViewById(R.id.aps_progress_bar));
    this.m = paramLayoutInflater.findViewById(R.id.aps_404);
    this.h = ((ListView)paramLayoutInflater.findViewById(R.id.aps_apslist_list));
    this.h.setAdapter(this.i);
    this.h.setOnItemClickListener(new b(this));
    this.h.setOnItemLongClickListener(new c(this));
    this.j = ((SwipeRefreshLayout)paramLayoutInflater.findViewById(R.id.aps_list_refresh));
    this.j.a(new d(this));
    paramLayoutInflater.findViewById(R.id.aps_404_retry).setOnClickListener(new e(this));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.k != null) && (this.k.isShowing()))
    {
      this.k.hide();
      this.k.dismiss();
    }
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
    if (com.bluefay.a.a.c(this.e)) {
      this.g.c();
    }
    for (;;)
    {
      com.linksure.apservice.utils.b.d("saadshw");
      return;
      this.l.setVisibility(8);
      com.bluefay.a.e.a(R.string.aps_network_failed);
    }
  }
  
  static final class a
    extends BaseAdapter
  {
    private List<com.linksure.apservice.b.a> a = Collections.EMPTY_LIST;
    private Context b;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public final void a(List<com.linksure.apservice.b.a> paramList)
    {
      this.a = paramList;
    }
    
    public final int getCount()
    {
      return this.a.size();
    }
    
    public final Object getItem(int paramInt)
    {
      return this.a.get(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = 0;
      com.linksure.apservice.b.a locala;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(this.b).inflate(R.layout.aps_listitem_apslist, paramViewGroup, false);
        paramViewGroup = new ApsListFragment.b();
        paramViewGroup.a = ((ImageView)paramView.findViewById(R.id.aps_item_aps_logo));
        paramViewGroup.b = ((TextView)paramView.findViewById(R.id.aps_item_aps_title));
        paramViewGroup.c = ((TextView)paramView.findViewById(R.id.aps_item_aps_subtitle));
        paramViewGroup.d = ((TextView)paramView.findViewById(R.id.aps_item_aps_unread));
        paramViewGroup.e = ((TextView)paramView.findViewById(R.id.aps_item_aps_time));
        paramViewGroup.f = paramView.findViewById(R.id.aps_divider);
        paramView.setTag(paramViewGroup);
        locala = (com.linksure.apservice.b.a)this.a.get(paramInt);
        if (!locala.i) {
          break label278;
        }
        paramView.setBackgroundColor(Color.parseColor("#f2f2f2"));
        label149:
        com.linksure.apservice.utils.e.a(paramViewGroup.a, locala.n, R.drawable.aps_dft_logo);
        paramViewGroup.b.setText(locala.l);
        if (TextUtils.isEmpty(locala.j)) {
          break label288;
        }
        paramViewGroup.c.setText(locala.j);
        label199:
        if (locala.b != 0) {
          break label303;
        }
        paramViewGroup.d.setVisibility(8);
        label216:
        paramViewGroup.e.setText(com.linksure.apservice.a.f.f.a(locala.d));
        if (paramInt == this.a.size() - 1) {
          break label343;
        }
        paramInt = 1;
        label248:
        paramViewGroup = paramViewGroup.f;
        if (paramInt == 0) {
          break label348;
        }
      }
      label278:
      label288:
      label303:
      label343:
      label348:
      for (paramInt = i;; paramInt = 4)
      {
        paramViewGroup.setVisibility(paramInt);
        return paramView;
        paramViewGroup = (ApsListFragment.b)paramView.getTag();
        break;
        paramView.setBackgroundResource(R.drawable.aps_listitem_selector);
        break label149;
        paramViewGroup.c.setText(locala.o);
        break label199;
        if (locala.b > 10)
        {
          paramViewGroup.d.setText("..");
          break label216;
        }
        paramViewGroup.d.setText(String.valueOf(locala.b));
        break label216;
        paramInt = 0;
        break label248;
      }
    }
  }
  
  static final class b
  {
    ImageView a;
    TextView b;
    TextView c;
    TextView d;
    TextView e;
    View f;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/list/ApsListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */