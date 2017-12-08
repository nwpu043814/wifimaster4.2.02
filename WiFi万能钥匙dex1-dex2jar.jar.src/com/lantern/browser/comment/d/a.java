package com.lantern.browser.comment.d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import com.bluefay.b.h;
import com.lantern.browser.R.layout;
import com.lantern.browser.comment.c.a.b;
import com.lantern.browser.comment.ui.WkCommentHeader;
import com.lantern.browser.comment.ui.WkCommentItemView;
import java.util.List;

public final class a
  extends BaseAdapter
{
  private a a;
  private a.b b;
  private Context c;
  private LayoutInflater d;
  private int e = 0;
  
  public a(Context paramContext)
  {
    this.c = paramContext;
    this.d = LayoutInflater.from(this.c);
    this.e = com.bluefay.a.e.a(paramContext, 45.0F);
  }
  
  private static j a(com.lantern.browser.b.a parama)
  {
    try
    {
      parama = (List)parama.b;
      if ((parama != null) && (!parama.isEmpty()))
      {
        parama = (j)parama.get(0);
        return parama;
      }
    }
    catch (Exception parama)
    {
      for (;;)
      {
        parama = null;
        continue;
        parama = null;
      }
    }
  }
  
  private static List<n> b(com.lantern.browser.b.a parama)
  {
    try
    {
      parama = (List)parama.b;
      return parama;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        parama = null;
      }
    }
  }
  
  public final void a(a.b paramb)
  {
    this.b = paramb;
  }
  
  public final void a(a parama)
  {
    this.a = parama;
  }
  
  public final int getCount()
  {
    int i = 0;
    if (this.a != null) {
      i = this.a.a();
    }
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    if (this.a != null) {}
    for (com.lantern.browser.b.a locala = this.a.a(paramInt);; locala = null) {
      return locala;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (this.a != null) {}
    for (paramInt = this.a.b(paramInt);; paramInt = 0) {
      return paramInt;
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = null;
    int i = getItemViewType(paramInt);
    Object localObject;
    if (paramView == null) {
      switch (i)
      {
      default: 
        localObject = this.a.a(paramInt);
        if (localObject == null) {
          h.c("WkCommentAdapter model is null");
        }
        break;
      }
    }
    for (;;)
    {
      return paramView;
      paramView = new com.lantern.browser.ui.j(this.c);
      paramView.a(this.b);
      paramViewGroup = paramView;
      break;
      paramView = new WkCommentItemView(this.c);
      paramView.setOnClickListener(new b(this));
      paramViewGroup = paramView;
      break;
      paramView = new WkCommentHeader(this.c);
      paramView.setOnClickListener(new c(this));
      break;
      paramView = this.d.inflate(R.layout.browser_news_comment_loadmore, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, this.e));
      paramView.setOnClickListener(new d(this));
      break;
      paramView = this.d.inflate(R.layout.browser_news_comment_empty, null);
      paramView.setOnClickListener(new e(this));
      break;
      switch (i)
      {
      case 1: 
      default: 
        break;
      case 0: 
        paramViewGroup = paramView;
        break;
      case 2: 
        paramViewGroup = paramView;
        break;
        if (paramViewGroup != null) {
          switch (i)
          {
          case 1: 
          default: 
            break;
          case 0: 
            localObject = b((com.lantern.browser.b.a)localObject);
            ((com.lantern.browser.ui.j)paramViewGroup).a(this.a.b(), (List)localObject);
            break;
          case 2: 
            ((WkCommentItemView)paramViewGroup).a(a((com.lantern.browser.b.a)localObject));
          }
        }
        break;
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    if (this.a != null) {}
    for (int i = 5;; i = 1) {
      return i;
    }
  }
  
  public static abstract interface a
  {
    public abstract int a();
    
    public abstract com.lantern.browser.b.a a(int paramInt);
    
    public abstract int b(int paramInt);
    
    public abstract String b();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */