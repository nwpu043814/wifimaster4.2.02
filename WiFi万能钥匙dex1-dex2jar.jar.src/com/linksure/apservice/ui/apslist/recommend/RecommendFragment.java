package com.linksure.apservice.ui.apslist.recommend;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.support.annotation.Nullable;
import com.linksure.apservice.R.color;
import com.linksure.apservice.R.drawable;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;
import com.linksure.apservice.a.g;
import com.linksure.apservice.a.i;
import com.linksure.apservice.b.a;
import com.linksure.apservice.ui.apslist.ApsListActivity;
import com.linksure.apservice.ui.common.interceptor.InterceptorFragment;
import java.util.Collections;
import java.util.List;

public class RecommendFragment
  extends InterceptorFragment
  implements a.b
{
  a.a g;
  private b i;
  private View j;
  private View k;
  private ImageView l;
  private ObjectAnimator m;
  private a n = new d(this);
  
  public final void a(List<a> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      this.k.setVisibility(8);
    }
    for (;;)
    {
      return;
      this.k.setVisibility(0);
      this.i.a(paramList);
      this.i.notifyDataSetChanged();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    View localView = this.j;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    Log.e("--->", "show refreshing..");
    if (paramBoolean) {
      this.m.start();
    }
    for (;;)
    {
      return;
      float f1 = ((Float)this.m.getAnimatedValue()).floatValue();
      float f2 = (360.0F - f1) * 300.0F / 360.0F;
      this.m.cancel();
      ObjectAnimator.ofFloat(this.l, "rotation", new float[] { f1, 360.0F }).setDuration(f2).start();
    }
  }
  
  public final void b_(int paramInt)
  {
    Toast.makeText(getActivity(), paramInt, 0).show();
  }
  
  public final void c(boolean paramBoolean)
  {
    ((ApsListActivity)getActivity()).a(paramBoolean);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = i.a(getActivity());
    g localg = i.d(getActivity());
    paramBundle = new f(getActivity(), this, paramBundle, localg);
    super.a(paramBundle);
    this.g = paramBundle;
    this.g.c();
    this.i = new b(getActivity());
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.aps_fragment_recommend, null);
    this.k = paramLayoutInflater.findViewById(R.id.aps_refresh_layout);
    this.k.setVisibility(8);
    this.j = paramLayoutInflater.findViewById(R.id.aps_loading);
    paramViewGroup = (ListView)paramLayoutInflater.findViewById(R.id.aps_apslist_reco);
    paramViewGroup.setAdapter(this.i);
    this.i.a(this.n);
    paramViewGroup.setOnItemClickListener(new b(this));
    paramLayoutInflater.findViewById(R.id.aps_refresh).setOnClickListener(new c(this));
    this.l = ((ImageView)paramLayoutInflater.findViewById(R.id.aps_refreshing_indicator));
    this.m = ObjectAnimator.ofFloat(this.l, "rotation", new float[] { 0.0F, 360.0F });
    this.m.setRepeatMode(1);
    this.m.setRepeatCount(-1);
    this.m.setDuration(1000L);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    com.linksure.apservice.utils.b.d("saadnshw");
  }
  
  static abstract interface a
  {
    public abstract void a(a parama);
  }
  
  static final class b
    extends BaseAdapter
  {
    private List<a> a = Collections.EMPTY_LIST;
    private RecommendFragment.a b;
    private Context c;
    
    public b(Context paramContext)
    {
      this.c = paramContext;
    }
    
    public final void a(RecommendFragment.a parama)
    {
      this.b = parama;
    }
    
    public final void a(List<a> paramList)
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
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.c).inflate(R.layout.aps_listitem_recommend, paramViewGroup, false);
        paramView = RecommendFragment.c.a(localView);
        localView.setTag(paramView);
        paramView.a(this.b);
      }
      ((RecommendFragment.c)localView.getTag()).a((a)this.a.get(paramInt));
      return localView;
    }
  }
  
  static final class c
  {
    private Resources a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private a f;
    
    public static c a(View paramView)
    {
      c localc = new c();
      localc.a = paramView.getResources();
      localc.b = ((ImageView)paramView.findViewById(R.id.aps_item_aps_logo));
      localc.c = ((TextView)paramView.findViewById(R.id.aps_item_aps_title));
      localc.d = ((TextView)paramView.findViewById(R.id.aps_item_aps_subtitle));
      localc.e = ((TextView)paramView.findViewById(R.id.aps_item_follow));
      return localc;
    }
    
    public final void a(a parama)
    {
      this.f = parama;
      com.linksure.apservice.utils.e.a(this.b, parama.n, R.drawable.aps_dft_logo);
      this.c.setText(parama.l);
      this.d.setText(this.a.getString(R.string.aps_follow_count, new Object[] { Integer.valueOf(parama.c) }));
      if (!parama.e)
      {
        this.e.setTextColor(this.a.getColor(R.color.aps_white));
        this.e.setSelected(false);
        this.e.setText(R.string.aps_stat_unfollow);
        this.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.aps_white_jia, 0, 0, 0);
      }
      for (;;)
      {
        return;
        this.e.setTextColor(this.a.getColor(R.color.colorPrimary));
        this.e.setSelected(true);
        this.e.setText(R.string.aps_stat_follow);
        this.e.setCompoundDrawablesWithIntrinsicBounds(R.drawable.aps_blue_gougou, 0, 0, 0);
      }
    }
    
    public final void a(RecommendFragment.a parama)
    {
      this.e.setOnClickListener(new e(this, parama));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/recommend/RecommendFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */