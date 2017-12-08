package com.lantern.feed.ui;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.lantern.feed.b.r;
import com.lantern.feed.d.d;
import java.util.List;

public final class ai
  extends RelativeLayout
{
  private Context a;
  private LinearLayout b;
  private LinearLayout c;
  private boolean d;
  
  public ai(Context paramContext)
  {
    this(paramContext, true);
  }
  
  public ai(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.d = paramBoolean;
    this.a = paramContext;
    this.c = new LinearLayout(this.a);
    this.c.setId(4097);
    paramContext = new RelativeLayout.LayoutParams(-2, -1);
    paramContext.addRule(15);
    paramContext.addRule(11);
    addView(this.c, paramContext);
    this.b = new LinearLayout(this.a);
    paramContext = new RelativeLayout.LayoutParams(-1, -1);
    paramContext.addRule(15);
    paramContext.addRule(0, this.c.getId());
    addView(this.b, paramContext);
  }
  
  public final void a(SparseArray<List<r>> paramSparseArray)
  {
    if ((paramSparseArray != null) && (paramSparseArray.size() > 0))
    {
      Object localObject1 = (List)paramSparseArray.get(1);
      Object localObject2;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.c.setVisibility(0);
        localObject2 = (r)((List)localObject1).get(0);
        if (this.c.getChildCount() > 0) {
          ((cd)this.c.getChildAt(0)).a((r)localObject2);
        }
      }
      int m;
      int k;
      int i;
      for (;;)
      {
        paramSparseArray = (List)paramSparseArray.get(0);
        if ((paramSparseArray == null) || (paramSparseArray.size() <= 0)) {
          break label381;
        }
        this.b.setVisibility(0);
        m = Math.min(paramSparseArray.size(), 3);
        k = this.b.getChildCount();
        i = Math.min(m, k);
        for (j = 0; j < i; j++)
        {
          localObject2 = (r)paramSparseArray.get(j);
          localObject1 = (cd)this.b.getChildAt(j);
          ((cd)localObject1).setVisibility(0);
          ((cd)localObject1).a((r)localObject2);
        }
        localObject1 = new cd(this.a, this.d);
        ((cd)localObject1).a((r)localObject2);
        localObject2 = new LinearLayout.LayoutParams(-2, -1);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.c.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        continue;
        this.c.setVisibility(8);
      }
      for (int j = i; j < m; j++)
      {
        localObject2 = (r)paramSparseArray.get(j);
        localObject1 = new cd(this.a, this.d);
        ((cd)localObject1).a((r)localObject2);
        localObject2 = new LinearLayout.LayoutParams(-2, -1);
        ((LinearLayout.LayoutParams)localObject2).rightMargin = d.a(this.a, 5.0F);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.b.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
      while (i < k)
      {
        this.b.getChildAt(i).setVisibility(8);
        i++;
        continue;
        label381:
        this.b.setVisibility(8);
      }
    }
    for (;;)
    {
      return;
      if (this.c.getVisibility() != 8) {
        this.c.setVisibility(8);
      }
      if (this.b.getVisibility() != 8) {
        this.b.setVisibility(8);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */