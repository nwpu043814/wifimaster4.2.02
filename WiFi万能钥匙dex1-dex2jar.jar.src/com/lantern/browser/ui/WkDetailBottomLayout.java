package com.lantern.browser.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.lantern.browser.b.a;
import com.lantern.browser.comment.c.a.b;
import com.lantern.browser.comment.d.a.a;
import com.lantern.browser.comment.d.j;
import com.lantern.browser.comment.d.n;
import com.lantern.browser.comment.ui.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WkDetailBottomLayout
  extends LinearLayout
{
  private Context a;
  private aj b;
  private String c;
  private a.a d;
  private List<n> e;
  private List<List<j>> f;
  private List<a> g;
  private boolean h = false;
  
  public WkDetailBottomLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public WkDetailBottomLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public WkDetailBottomLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(ViewGroup paramViewGroup, int paramInt)
  {
    int m = paramViewGroup.getChildCount();
    int j = 0;
    View localView;
    int i;
    if (j < m)
    {
      localView = paramViewGroup.getChildAt(j);
      if ((localView instanceof ListView)) {
        if (localView.canScrollVertically(paramInt)) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      return i;
      i = -1;
      continue;
      if ((localView instanceof ViewGroup))
      {
        int k = a((ViewGroup)localView, paramInt);
        i = k;
        if (k != 0) {}
      }
      else
      {
        j++;
        break;
        i = 0;
      }
    }
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    setOrientation(1);
    setBackgroundColor(-460552);
    this.b = new aj(this.a);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    addView(this.b, paramContext);
  }
  
  private void e()
  {
    if (this.g == null) {
      this.g = new ArrayList();
    }
    for (;;)
    {
      if ((this.e != null) && (!this.e.isEmpty())) {
        this.g.add(new a(0, this.e));
      }
      if ((this.f == null) || (this.f.isEmpty())) {
        break label175;
      }
      this.g.add(new a(1));
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        this.g.add(new a(2, localObject));
      }
      this.g.clear();
    }
    this.g.add(new a(3));
    for (;;)
    {
      return;
      label175:
      if (this.h) {
        this.g.add(new a(4));
      }
    }
  }
  
  private void f()
  {
    if ((this.g == null) || (this.g.isEmpty())) {
      if (getVisibility() != 8) {
        setVisibility(8);
      }
    }
    for (;;)
    {
      aj localaj = this.b;
      if (this.d == null) {
        this.d = new a((byte)0);
      }
      localaj.a(this.d);
      this.b.a();
      return;
      if (getVisibility() != 0) {
        setVisibility(0);
      }
    }
  }
  
  public final void a()
  {
    this.h = true;
    e();
    f();
  }
  
  public final void a(a.b paramb)
  {
    this.b.a(paramb);
  }
  
  public final void a(String paramString, List<n> paramList)
  {
    this.c = paramString;
    this.e = paramList;
    e();
    f();
  }
  
  public final void b()
  {
    this.c = null;
    this.h = false;
    if (this.e != null)
    {
      this.e.clear();
      this.e = null;
    }
    if (this.f != null)
    {
      this.f.clear();
      this.f = null;
    }
    e();
    f();
  }
  
  public final void b(String paramString, List<List<j>> paramList)
  {
    this.c = paramString;
    this.f = paramList;
    e();
    f();
  }
  
  public final boolean c()
  {
    if ((this.e != null) && (!this.e.isEmpty())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    boolean bool = true;
    int i = a(this, paramInt);
    if (i == 1) {}
    for (;;)
    {
      return bool;
      if (i == -1) {
        bool = false;
      } else {
        bool = super.canScrollVertically(paramInt);
      }
    }
  }
  
  public final boolean d()
  {
    if ((this.f != null) && (!this.f.isEmpty())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean) {}
  
  private final class a
    implements a.a
  {
    private a() {}
    
    public final int a()
    {
      if (WkDetailBottomLayout.a(WkDetailBottomLayout.this) != null) {}
      for (int i = WkDetailBottomLayout.a(WkDetailBottomLayout.this).size();; i = 0) {
        return i;
      }
    }
    
    public final a a(int paramInt)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (WkDetailBottomLayout.a(WkDetailBottomLayout.this) != null)
      {
        localObject1 = localObject2;
        if (paramInt < WkDetailBottomLayout.a(WkDetailBottomLayout.this).size()) {
          localObject1 = (a)WkDetailBottomLayout.a(WkDetailBottomLayout.this).get(paramInt);
        }
      }
      return (a)localObject1;
    }
    
    public final int b(int paramInt)
    {
      a locala = null;
      if (WkDetailBottomLayout.a(WkDetailBottomLayout.this) != null)
      {
        if (paramInt < WkDetailBottomLayout.a(WkDetailBottomLayout.this).size()) {
          locala = (a)WkDetailBottomLayout.a(WkDetailBottomLayout.this).get(paramInt);
        }
        if (locala == null) {}
      }
      for (paramInt = locala.a;; paramInt = 0) {
        return paramInt;
      }
    }
    
    public final String b()
    {
      return WkDetailBottomLayout.b(WkDetailBottomLayout.this);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/WkDetailBottomLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */