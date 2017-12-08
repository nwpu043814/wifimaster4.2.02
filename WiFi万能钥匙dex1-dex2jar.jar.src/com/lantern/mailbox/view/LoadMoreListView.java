package com.lantern.mailbox.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.lantern.mailbox.R.layout;

public class LoadMoreListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private View a;
  private boolean b;
  private a c;
  
  public LoadMoreListView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public LoadMoreListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public LoadMoreListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    paramContext = (LinearLayout)localLayoutInflater.inflate(R.layout.mailbox_loading_container, this, false);
    this.a = localLayoutInflater.inflate(R.layout.mailbox_loading_view, paramContext, false);
    paramContext.addView(this.a);
    addFooterView(paramContext);
    setOnScrollListener(this);
  }
  
  public final void a(a parama)
  {
    this.c = parama;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.setVisibility(8);
    }
    for (;;)
    {
      this.b = false;
      return;
      if (this.a.getVisibility() == 8) {
        this.a.setVisibility(0);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 + paramInt2 == paramInt3) && (!this.b) && (this.a.getVisibility() == 0))
    {
      this.b = true;
      if (this.c != null) {
        this.c.a();
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/view/LoadMoreListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */