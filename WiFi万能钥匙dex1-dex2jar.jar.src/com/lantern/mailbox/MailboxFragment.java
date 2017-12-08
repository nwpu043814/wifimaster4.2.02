package com.lantern.mailbox;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import bluefay.app.Fragment;
import bluefay.app.u;
import com.bluefay.material.SwipeRefreshLayout;
import com.bluefay.material.f;
import com.lantern.mailbox.view.LoadMoreListView;
import java.util.List;
import java.util.concurrent.Executors;

public class MailboxFragment
  extends Fragment
{
  private String g = "-1";
  private LoadMoreListView h;
  private com.lantern.mailbox.a.a i;
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    a(R.string.mailbox_title);
    paramBundle = new u(this.e);
    paramBundle.add(101, 1001, 0, "Help").setTitle(R.string.mailbox_unread_btn);
    a(a, paramBundle);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.mailbox_list_view, paramViewGroup, false);
    paramBundle = (SwipeRefreshLayout)paramLayoutInflater.findViewById(R.id.refresh);
    paramViewGroup = paramLayoutInflater.findViewById(R.id.empty_view);
    this.h = ((LoadMoreListView)paramLayoutInflater.findViewById(R.id.list));
    this.i = new com.lantern.mailbox.a.a(getActivity());
    this.h.setAdapter(this.i);
    paramBundle.a(new c(this, paramBundle, paramViewGroup));
    this.h.a(new d(this));
    paramBundle = new f(this.e);
    paramBundle.a(getString(R.string.mailbox_loading));
    paramBundle.setCanceledOnTouchOutside(false);
    paramBundle.setOnCancelListener(new g(this));
    paramBundle.show();
    new a(paramBundle, null, paramViewGroup).executeOnExecutor(Executors.newCachedThreadPool(), new Void[0]);
    return paramLayoutInflater;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 1001) {
      a(R.string.mailbox_unread_title, R.string.mailbox_unread_msg, new a(this));
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  private final class a
    extends AsyncTask<Void, Void, List<com.lantern.mailbox.d.a>>
  {
    private f b;
    private SwipeRefreshLayout c;
    private View d;
    
    public a(f paramf, SwipeRefreshLayout paramSwipeRefreshLayout, View paramView)
    {
      this.b = paramf;
      this.c = paramSwipeRefreshLayout;
      this.d = paramView;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/MailboxFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */