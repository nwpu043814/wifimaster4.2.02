package com.lantern.favorite.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.bluefay.a.e;
import com.lantern.core.favorite.WkSceneFavorite;
import com.lantern.favorite.R.string;
import com.lantern.favorite.widget.PullToRefreshLayout;
import com.lantern.favorite.widget.PullToRefreshLayout.a;
import com.lantern.favorite.widget.WkListView;
import com.qihoo.util.StubApp1053578832;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FavoriteSearch
  extends bluefay.app.m
  implements AdapterView.OnItemClickListener, TextView.OnEditorActionListener, PullToRefreshLayout.a
{
  private EditText e;
  private WkListView f;
  private d g;
  private PullToRefreshLayout h;
  private int i = 1;
  private boolean j;
  private boolean k;
  private String l;
  private com.lantern.favorite.a m;
  private WkSceneFavorite n;
  private ArrayList<WkSceneFavorite> o;
  private final a p = new a(this);
  
  static
  {
    StubApp1053578832.interface11(20);
  }
  
  private void a(int paramInt, String paramString)
  {
    new Thread(new m(this, paramInt, paramString)).start();
  }
  
  private void f()
  {
    if (this.k) {
      setResult(1003, new Intent());
    }
    finish();
  }
  
  public final void e_()
  {
    this.h.a();
    if (this.o.size() < 10) {
      e.a(getString(R.string.load_complete));
    }
    for (;;)
    {
      return;
      String str = this.e.getText().toString().trim();
      if (TextUtils.isEmpty(str)) {
        e.a(getString(R.string.search_condition));
      } else {
        a(this.i, str);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      this.k = false;
      switch (paramInt2)
      {
      default: 
        break;
      case 1001: 
        this.k = true;
        paramIntent = this.e.getText().toString().trim();
        this.i = 1;
        this.g.a().clear();
        a(this.i, paramIntent);
        break;
      case 1002: 
        paramIntent = paramIntent.getStringExtra("tag");
        if ((this.n != null) && (!com.lantern.favorite.c.d.a(paramIntent).equals(this.n.tags)))
        {
          this.k = true;
          this.n.tags = paramIntent;
          this.g.notifyDataSetChanged();
        }
        break;
      }
    }
  }
  
  public native void onCreate(Bundle paramBundle);
  
  public void onDestroy()
  {
    this.j = true;
    this.m.c();
    super.onDestroy();
  }
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramTextView = this.e.getText().toString().trim();
    boolean bool;
    if (TextUtils.isEmpty(paramTextView))
    {
      e.a(getString(R.string.search_condition));
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (paramTextView.equals(this.l))
      {
        e.a(getString(R.string.search_exit));
        bool = false;
      }
      else
      {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.e.getWindowToken(), 0);
        this.i = 1;
        this.l = paramTextView;
        this.g.a().clear();
        a(this.i, paramTextView);
        com.lantern.analytics.a.e().onEvent("favse");
        bool = true;
      }
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.g.a(paramInt);
    if (("text".equals(paramAdapterView.category)) || ("image".equals(paramAdapterView.category)))
    {
      this.n = paramAdapterView;
      paramView = new Intent(this, FavoriteDetails.class);
      paramView.putExtra("favId", paramAdapterView.favId);
      startActivityForResult(paramView, 0);
    }
    for (;;)
    {
      return;
      if (("news".equals(paramAdapterView.category)) || ("url".equals(paramAdapterView.category)))
      {
        paramAdapterView = new Intent("wifi.intent.action.BROWSER", Uri.parse(paramAdapterView.contentSrc));
        paramAdapterView.setPackage(getPackageName());
        paramAdapterView.addFlags(268435456);
        paramView = new Bundle();
        paramView.putBoolean("showclose", false);
        paramAdapterView.putExtras(paramView);
        e.a(this, paramAdapterView);
      }
      else
      {
        paramView = new Intent();
        paramView.setPackage(getPackageName());
        paramView.setData(Uri.parse("wkchat://" + paramAdapterView.authorId + "/0"));
        paramView.setFlags(268435456);
        e.a(getApplication(), paramView);
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      f();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    f();
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.p.postDelayed(new l(this), 300L);
  }
  
  private static final class a
    extends Handler
  {
    private final WeakReference<FavoriteSearch> a;
    
    public a(FavoriteSearch paramFavoriteSearch)
    {
      this.a = new WeakReference(paramFavoriteSearch);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      paramMessage = (FavoriteSearch)this.a.get();
      if (paramMessage != null) {
        FavoriteSearch.b(paramMessage);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/FavoriteSearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */