package com.linksure.apservice.ui.common.search;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.linksure.apservice.R.color;
import com.linksure.apservice.R.drawable;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;
import com.linksure.apservice.b.a;
import com.linksure.apservice.ui.common.interceptor.InterceptorFragment;
import java.util.Collections;
import java.util.List;

public class SearchFragment
  extends InterceptorFragment
  implements a.b
{
  o g;
  private View i;
  private View j;
  private ListView k;
  private b l;
  private View m;
  private EditText n;
  private ImageView o;
  private ImageView p;
  private View[] q = new View[3];
  private Dialog r;
  private a.a s;
  
  private void d(int paramInt)
  {
    int i1 = 0;
    if (i1 < this.q.length)
    {
      if (i1 == paramInt) {
        this.q[i1].setVisibility(0);
      }
      for (;;)
      {
        i1++;
        break;
        this.q[i1].setVisibility(4);
      }
    }
  }
  
  public final Dialog a(String paramString)
  {
    com.bluefay.material.f localf = new com.bluefay.material.f(this.e);
    localf.a(paramString);
    localf.setCancelable(false);
    return localf;
  }
  
  public final void a(List<a> paramList)
  {
    this.g.b();
    d(2);
    this.l.a(paramList);
    this.l.notifyDataSetChanged();
  }
  
  public final void a(boolean paramBoolean)
  {
    View localView = this.m;
    if (paramBoolean) {}
    for (int i1 = 0;; i1 = 8)
    {
      localView.setVisibility(i1);
      return;
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if ((this.r != null) && (this.r.isShowing()))
    {
      this.r.hide();
      this.r.dismiss();
    }
    if (paramBoolean)
    {
      this.r = a(getString(R.string.aps_following));
      this.r.show();
    }
  }
  
  public final void e_(int paramInt)
  {
    Toast.makeText(getActivity(), paramInt, 0).show();
  }
  
  public final void h()
  {
    this.g.b();
    d(1);
  }
  
  final void i()
  {
    String str = this.n.getText().toString();
    if ((str == null) || (str.trim().length() == 0)) {}
    for (;;)
    {
      return;
      this.g.a();
      ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.n.getWindowToken(), 0);
      this.s.a(this.n.getText().toString());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.l = new b(getActivity());
    paramBundle = new k(this, com.linksure.apservice.a.i.d(getActivity()), com.linksure.apservice.a.i.a(getActivity()));
    super.a(paramBundle);
    this.s = paramBundle;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.aps_fragment_search, null);
    this.i = paramLayoutInflater.findViewById(R.id.aps_search_empty);
    this.j = paramLayoutInflater.findViewById(R.id.aps_search_retry);
    this.k = ((ListView)paramLayoutInflater.findViewById(R.id.aps_search_list));
    this.j.findViewById(R.id.aps_search_retry_txt).setOnClickListener(new b(this));
    this.k.setAdapter(this.l);
    this.q[0] = this.i;
    this.q[1] = this.j;
    this.q[2] = this.k;
    this.n = ((EditText)getActivity().findViewById(R.id.aps_search_text));
    this.p = ((ImageView)getActivity().findViewById(R.id.aps_search_del_button));
    this.p.setOnClickListener(new c(this));
    this.o = ((ImageView)getActivity().findViewById(R.id.aps_search_button));
    this.o.setOnClickListener(new d(this));
    this.n.addTextChangedListener(new e(this));
    this.n.setOnEditorActionListener(new f(this));
    this.m = paramLayoutInflater.findViewById(R.id.aps_list_loading);
    this.m.setVisibility(8);
    this.k.setOnScrollListener(new g(this));
    this.k.setOnItemClickListener(new h(this));
    this.l.a(new i(this));
    this.g = new o((ProgressBar)paramLayoutInflater.findViewById(R.id.aps_search_head_progressbar));
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    com.linksure.apservice.utils.b.d("sasrsh");
  }
  
  public final void p_()
  {
    this.g.b();
    d(0);
  }
  
  static abstract interface a
  {
    public abstract void a(a parama);
  }
  
  static final class b
    extends BaseAdapter
  {
    private List<a> a = Collections.EMPTY_LIST;
    private SearchFragment.a b;
    private Context c;
    
    public b(Context paramContext)
    {
      this.c = paramContext;
    }
    
    public final void a(SearchFragment.a parama)
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
        localView = LayoutInflater.from(this.c).inflate(R.layout.aps_listitem_search, paramViewGroup, false);
        paramView = SearchFragment.c.a(localView);
        localView.setTag(paramView);
        paramView.a(this.b);
      }
      ((SearchFragment.c)localView.getTag()).a((a)this.a.get(paramInt));
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
    
    public final void a(SearchFragment.a parama)
    {
      this.e.setOnClickListener(new j(this, parama));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/search/SearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */