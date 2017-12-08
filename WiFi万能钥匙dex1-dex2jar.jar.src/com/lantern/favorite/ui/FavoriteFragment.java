package com.lantern.favorite.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import bluefay.app.Fragment;
import bluefay.app.u;
import com.bluefay.a.e;
import com.lantern.core.favorite.WkSceneFavorite;
import com.lantern.favorite.R.array;
import com.lantern.favorite.R.drawable;
import com.lantern.favorite.R.id;
import com.lantern.favorite.R.layout;
import com.lantern.favorite.R.string;
import com.lantern.favorite.a;
import com.lantern.favorite.widget.PullToRefreshLayout;
import com.lantern.favorite.widget.PullToRefreshLayout.a;
import com.lantern.favorite.widget.WkListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FavoriteFragment
  extends Fragment
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, PullToRefreshLayout.a
{
  private WkListView g;
  private d h;
  private ArrayList<WkSceneFavorite> i;
  private PullToRefreshLayout j;
  private int k = 1;
  private boolean l;
  private a m;
  private WkSceneFavorite n;
  private final a o = new a(this);
  
  private void b(int paramInt1, int paramInt2)
  {
    new Thread(new j(this, paramInt1, paramInt2)).start();
  }
  
  public final void a(ArrayList<WkSceneFavorite> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.o.postDelayed(new i(this, paramArrayList), 200L);
    }
  }
  
  public final void e_()
  {
    if (this.i.size() < 10)
    {
      this.j.a();
      e.a(this.e.getString(R.string.load_complete));
    }
    for (;;)
    {
      return;
      b(this.k, 1000);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      switch (paramInt2)
      {
      default: 
        break;
      case 1001: 
      case 1003: 
        this.k = 1;
        this.h.a().clear();
        b(this.k, 0);
        break;
      case 1002: 
        paramIntent = paramIntent.getStringExtra("tag");
        if ((this.n != null) && (!com.lantern.favorite.c.d.a(paramIntent).equals(this.n.tags)))
        {
          this.n.tags = paramIntent;
          this.h.notifyDataSetChanged();
        }
        break;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(R.string.fav_title);
    int i1 = a;
    paramBundle = new u(this.e);
    paramBundle.add(101, 1001, 0, "Search").setIcon(R.drawable.fav_hdrawable_search);
    a(i1, paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.fav_list, paramViewGroup, false);
    this.j = ((PullToRefreshLayout)paramLayoutInflater.findViewById(R.id.refresh_view));
    this.g = ((WkListView)paramLayoutInflater.findViewById(R.id.favorite_list));
    this.h = new d(this.e, this.j);
    this.g.setAdapter(this.h);
    this.m = ((FavoriteActivity)getActivity()).j;
    this.g.setOnItemClickListener(this);
    this.g.setOnItemLongClickListener(this);
    this.j.a(this);
    b(this.k, 200);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    if (((FavoriteActivity)getActivity()).f)
    {
      this.m.c();
      this.m = null;
    }
    this.l = true;
    this.j = null;
    super.onDestroy();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.h.a(paramInt);
    if (("text".equals(paramAdapterView.category)) || ("image".equals(paramAdapterView.category)))
    {
      this.n = paramAdapterView;
      paramView = new Intent(this.e, FavoriteDetails.class);
      paramView.putExtra("favId", paramAdapterView.favId);
      startActivityForResult(paramView, 0);
    }
    for (;;)
    {
      return;
      if (("news".equals(paramAdapterView.category)) || ("url".equals(paramAdapterView.category)))
      {
        paramView = new Intent("wifi.intent.action.BROWSER", Uri.parse(paramAdapterView.contentSrc));
        paramView.setPackage(this.e.getPackageName());
        paramView.addFlags(268435456);
        paramAdapterView = new Bundle();
        paramAdapterView.putBoolean("showclose", false);
        paramView.putExtras(paramAdapterView);
        e.a(this.e, paramView);
      }
      else
      {
        paramView = new Intent();
        paramView.setPackage(this.e.getPackageName());
        paramView.setData(Uri.parse("wkchat://" + paramAdapterView.authorId + "/0"));
        paramView.setFlags(268435456);
        e.a(this.e, paramView);
      }
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.n = this.h.a(paramInt);
    paramView = this.e.getResources().getStringArray(R.array.dialog);
    paramAdapterView = new bluefay.app.k(this.e, 0);
    WkListView localWkListView = new WkListView(this.e, new k(this, paramAdapterView));
    localWkListView.a(R.layout.layout_dialog, R.id.fav_item_view, paramView);
    paramAdapterView.a(localWkListView);
    paramAdapterView.show();
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 1001) {
      startActivityForResult(new Intent(this.e, FavoriteSearch.class), 0);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  private static final class a
    extends Handler
  {
    private final WeakReference<FavoriteFragment> a;
    
    public a(FavoriteFragment paramFavoriteFragment)
    {
      this.a = new WeakReference(paramFavoriteFragment);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      paramMessage = (FavoriteFragment)this.a.get();
      if (paramMessage != null) {
        FavoriteFragment.a(paramMessage);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/FavoriteFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */