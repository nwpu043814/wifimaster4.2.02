package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import com.bluefay.b.h;
import com.lantern.feed.R.color;
import com.lantern.feed.a.m;
import com.lantern.feed.b.f;
import com.lantern.feed.b.g;
import com.lantern.feed.d.d;
import java.util.List;

public class WkFeedListView
  extends ListView
{
  private WkFeedSearchLayout a;
  private ab b;
  private int c = 0;
  private boolean d = false;
  private f e;
  private String f;
  private Context g;
  
  public WkFeedListView(Context paramContext)
  {
    super(paramContext);
    this.g = paramContext;
    c();
  }
  
  public WkFeedListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = paramContext;
    c();
  }
  
  public WkFeedListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.g = paramContext;
    c();
  }
  
  private void c()
  {
    setVerticalScrollBarEnabled(false);
    this.b = new ab(this.g, this.f);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, d.a(this.g, 43.0F));
    this.b.setLayoutParams(localLayoutParams);
    setDivider(new ColorDrawable(getResources().getColor(R.color.translucent)));
    addFooterView(this.b);
    setOnScrollListener(new z(this));
    setRecyclerListener(new aa(this));
  }
  
  private void d()
  {
    if (this.d) {}
    label100:
    for (;;)
    {
      return;
      int i = getChildCount();
      if (i != 0)
      {
        i--;
        for (;;)
        {
          if (i < 0) {
            break label100;
          }
          Object localObject = getChildAt(i);
          if ((localObject instanceof a))
          {
            localObject = (a)localObject;
            if (TextUtils.isEmpty(this.f))
            {
              if (!m.a().c(((a)localObject).a())) {
                break;
              }
              m.a().h();
              break;
            }
            if (!com.lantern.feed.channel.a.a.a().c(((a)localObject).a())) {
              break;
            }
            com.lantern.feed.channel.a.a.a().c();
            break;
          }
          i--;
        }
      }
    }
  }
  
  public final void a()
  {
    this.d = true;
    this.b.a();
  }
  
  public final void a(int paramInt)
  {
    if (this.a != null)
    {
      if (paramInt != 2) {
        break label46;
      }
      if (getHeaderViewsCount() == 0)
      {
        addHeaderView(this.a, null, false);
        setAdapter(this.e);
      }
      this.a.setVisibility(0);
    }
    for (;;)
    {
      return;
      label46:
      if (getHeaderViewsCount() > 0) {
        removeHeaderView(this.a);
      }
    }
  }
  
  public final void a(g paramg)
  {
    int j = getChildCount();
    for (int i = 0;; i++) {
      if (i < j)
      {
        Object localObject = getChildAt(i);
        if ((localObject instanceof a))
        {
          localObject = (a)localObject;
          if (((a)localObject).a().a().equals(paramg.a())) {
            ((a)localObject).b(paramg);
          }
        }
      }
      else
      {
        return;
      }
    }
  }
  
  public final void a(String paramString)
  {
    this.f = paramString;
    if (TextUtils.isEmpty(this.f))
    {
      this.a = new WkFeedSearchLayout(this.g);
      this.a.setVisibility(8);
      paramString = new AbsListView.LayoutParams(-1, d.a(getContext(), 50.0F));
      this.a.setLayoutParams(paramString);
      addHeaderView(this.a, null, false);
    }
    for (this.e = m.a().o();; this.e = com.lantern.feed.channel.a.a.a().e())
    {
      setAdapter(this.e);
      return;
    }
  }
  
  public final void a(List<g> paramList)
  {
    h.a("onNewsDataChanged models.size():" + paramList.size(), new Object[0]);
    setSelection(0);
    if ((paramList.size() > 0) && (((g)paramList.get(0)).o() != 0))
    {
      if (!TextUtils.isEmpty(this.f)) {
        break label76;
      }
      m.a().a(paramList);
    }
    for (;;)
    {
      return;
      label76:
      com.lantern.feed.channel.a.a.a().a(paramList);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
    this.d = false;
  }
  
  public final void b()
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if ((localView instanceof bh)) {
        ((bh)localView).f();
      }
      for (;;)
      {
        i++;
        break;
        if ((localView instanceof bg)) {
          ((bg)localView).f();
        }
      }
    }
  }
  
  public final void b(List<g> paramList)
  {
    h.a("onLastestNewsReceived models.size():" + paramList.size(), new Object[0]);
    setSelection(0);
    if (TextUtils.isEmpty(this.f))
    {
      m.a().a(paramList);
      m.a().onEvent("up", ((g)paramList.get(0)).o());
    }
    for (;;)
    {
      return;
      com.lantern.feed.channel.a.a.a().a(paramList);
      com.lantern.feed.channel.a.a.a().onEvent("up", ((g)paramList.get(0)).o());
    }
  }
  
  public final void c(List<g> paramList)
  {
    h.a("onMoreNewsReceived models.size():" + paramList.size(), new Object[0]);
    this.d = false;
    d();
    if (TextUtils.isEmpty(this.f))
    {
      m.a().onEvent("down", ((g)paramList.get(0)).o());
      m.a().a(paramList);
    }
    for (;;)
    {
      return;
      com.lantern.feed.channel.a.a.a().onEvent("down", ((g)paramList.get(0)).o());
      com.lantern.feed.channel.a.a.a().a(paramList);
    }
  }
  
  public final void d(List<String> paramList)
  {
    if (this.a != null) {
      this.a.a(paramList);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */