package com.lantern.browser.comment.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bluefay.app.Fragment;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;
import com.lantern.browser.R.string;
import com.lantern.browser.comment.d.j;
import com.lantern.core.c;
import com.lantern.core.p;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class WkCommentDetailFragment
  extends Fragment
{
  private TextView A;
  private int g;
  private String h;
  private String i;
  private String j;
  private int k = 0;
  private int l = 99;
  private View m;
  private View n;
  private View o;
  private TextView p;
  private PinnedSectionListView q;
  private com.lantern.browser.comment.ui.a.a r;
  private com.lantern.browser.comment.b.b s;
  private com.lantern.browser.comment.d.g t;
  private com.lantern.browser.comment.d.i u;
  private int v = -1;
  private Handler w;
  private String x;
  private com.bluefay.d.b y;
  private String z;
  
  private static void a(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (paramView.getVisibility() != 0) {
        paramView.setVisibility(0);
      }
    }
    for (;;)
    {
      return;
      if (paramView.getVisibility() != 8) {
        paramView.setVisibility(8);
      }
    }
  }
  
  private void c()
  {
    this.k = 1;
    d();
    new com.lantern.browser.comment.e.d(this.h, this.g, new n(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
  
  private void d()
  {
    if (this.k == 0) {
      a(this.m, false);
    }
    for (;;)
    {
      return;
      if (this.k == 2)
      {
        this.p.setText(R.string.comment_load_empty);
        a(this.o, true);
        a(this.n, false);
        a(this.m, true);
      }
      else if (this.k == 3)
      {
        this.p.setText(R.string.comment_load_failed);
        a(this.o, true);
        a(this.n, false);
        a(this.m, true);
      }
      else if (this.k == 1)
      {
        this.p.setText(R.string.comment_load_ing);
        a(this.o, false);
        a(this.n, true);
        a(this.m, true);
      }
    }
  }
  
  public final void a(String paramString)
  {
    this.s.dismiss();
    this.s.a();
    if (this.v >= this.l)
    {
      this.v = -1;
      this.u = null;
    }
    j localj;
    com.lantern.browser.comment.d.i locali;
    int i1;
    for (;;)
    {
      localj = new j();
      localj.f(p.e(this.e));
      localj.b(paramString);
      localj.e(p.b(null));
      localj.d(p.c(null));
      localj.c(p.d(this.e));
      localj.e(2);
      localj.d(-1);
      localj.a(System.currentTimeMillis());
      if ((this.t == null) || (this.u == null) || (this.v < 0)) {
        break label501;
      }
      locali = this.u.f();
      List localList = locali.b();
      if ((localList == null) || (localList.isEmpty())) {
        break;
      }
      for (i1 = localList.size() - 1;; i1--)
      {
        paramString = localList;
        if (i1 <= this.v) {
          break;
        }
        localList.remove(i1);
      }
      if (this.v >= 0) {
        try
        {
          if (this.u.a(this.v).p() == 1)
          {
            this.v = -1;
            this.u = null;
          }
        }
        catch (Exception localException)
        {
          com.bluefay.b.h.a(localException);
        }
      }
    }
    paramString = localException;
    if (localException == null) {
      paramString = new ArrayList();
    }
    Object localObject;
    label307:
    label330:
    label361:
    int i3;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      localObject = (j)paramString.get(paramString.size() - 1);
      if (localObject == null) {
        break label496;
      }
      i1 = ((j)localObject).m();
      paramString.add(localj);
      this.u = null;
      this.v = -1;
      localObject = locali;
      ((com.lantern.browser.comment.d.i)localObject).a(this.h);
      ((com.lantern.browser.comment.d.i)localObject).a(paramString);
      if (this.t == null) {
        break label532;
      }
      this.t.a((com.lantern.browser.comment.d.i)localObject);
      this.r.a(this.t);
      this.r.notifyDataSetChanged();
      i3 = this.q.getFirstVisiblePosition();
      localObject = this.r.a();
      if (localObject == null) {
        break label564;
      }
      i2 = ((com.lantern.browser.comment.d.g)localObject).e();
      label408:
      if (i3 > i2)
      {
        localObject = this.q.getChildAt(0);
        if (localObject == null) {
          break label569;
        }
      }
    }
    label496:
    label501:
    label532:
    label564:
    label569:
    for (int i2 = ((View)localObject).getTop();; i2 = 0)
    {
      this.q.setSelectionFromTop(i3 + 1, i2);
      new com.lantern.browser.comment.e.i(this.h, this.i, this.j, i1, localj, paramString, new f(this)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
      localObject = null;
      break;
      i1 = 0;
      break label307;
      localObject = new com.lantern.browser.comment.d.i();
      paramString = new ArrayList();
      paramString.add(localj);
      i1 = 0;
      break label330;
      this.t = new com.lantern.browser.comment.d.g();
      this.t.a((com.lantern.browser.comment.d.i)localObject);
      this.k = 0;
      d();
      break label361;
      i2 = -1;
      break label408;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(R.layout.browser_comment_detail, null);
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.browser_comment_custome_title, null);
    paramLayoutInflater.setOnClickListener(new h(this));
    this.A = ((TextView)paramLayoutInflater.findViewById(R.id.comment_title));
    this.z = getString(R.string.comment_text);
    this.A.setText(this.z);
    b().a(paramLayoutInflater);
    this.q = ((PinnedSectionListView)paramViewGroup.findViewById(R.id.commentListView));
    this.q.a();
    this.w = new Handler();
    this.m = paramViewGroup.findViewById(R.id.commentLoadTipLayout);
    this.n = this.m.findViewById(R.id.commentLoadProgress);
    this.o = this.m.findViewById(R.id.commentLoadImage);
    this.p = ((TextView)this.m.findViewById(R.id.commentLoadTipTxt));
    this.m.setOnClickListener(new e(this));
    paramViewGroup.findViewById(R.id.commentToolbar).setOnClickListener(new g(this));
    paramLayoutInflater = com.lantern.core.config.d.a(this.e).a("comment");
    if (paramLayoutInflater != null)
    {
      int i1 = paramLayoutInflater.optInt("cmf", 100);
      if (i1 > 0) {
        this.l = (i1 - 1);
      }
    }
    try
    {
      paramLayoutInflater = ((Activity)this.e).getIntent();
      this.h = paramLayoutInflater.getStringExtra("NEWS_ID");
      this.g = paramLayoutInflater.getIntExtra("NEWS_REPLY_COMMENT_SEQUNCE", 0);
      this.i = paramLayoutInflater.getStringExtra("NEWS_TITLE");
      this.j = paramLayoutInflater.getStringExtra("NEWS_URL");
      if (TextUtils.isEmpty(this.h)) {
        a();
      }
      this.r = new com.lantern.browser.comment.ui.a.a(this.e);
      this.r.a(new i(this));
      this.r.a(new l(this));
      this.q.setAdapter(this.r);
      this.q.setOnScrollListener(new m(this));
      c();
      return paramViewGroup;
    }
    catch (Exception paramLayoutInflater)
    {
      for (;;) {}
    }
  }
  
  public void onDestroy()
  {
    if (this.y != null) {
      c.removeListener(this.y);
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
    com.lantern.browser.c.a.b(this.j);
  }
  
  public void onResume()
  {
    super.onResume();
    com.lantern.browser.c.a.a(this.j);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/WkCommentDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */