package com.lantern.browser.search.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.bluefay.a.e;
import com.lantern.browser.R.color;
import com.lantern.browser.search.b.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class WkSearchHotWordView
  extends ViewGroup
  implements View.OnClickListener
{
  private Context a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public WkSearchHotWordView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public WkSearchHotWordView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  public WkSearchHotWordView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    setBackgroundColor(getResources().getColor(R.color.search_hotword_bg));
    this.b = e.a(this.a, 30.0F);
    this.c = e.a(this.a, 10.0F);
    this.d = e.a(this.a, 15.0F);
    this.e = e.a(this.a, 15.0F);
    this.f = e.a(this.a, 10.0F);
  }
  
  public final void a(List<d> paramList)
  {
    removeAllViews();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        d locald = (d)paramList.next();
        WkSearchHotWordItem localWkSearchHotWordItem = new WkSearchHotWordItem(this.a);
        localWkSearchHotWordItem.a(locald);
        addView(localWkSearchHotWordItem, new ViewGroup.LayoutParams(-2, -1));
        localWkSearchHotWordItem.setOnClickListener(this);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((!(paramView instanceof WkSearchHotWordItem)) || (indexOfChild(paramView) < 0)) {}
    for (;;)
    {
      return;
      d locald = ((WkSearchHotWordItem)paramView).a();
      com.lantern.browser.search.a.a.a().a(locald.a());
      paramView = new HashMap();
      paramView.put("kw", locald.a());
      com.lantern.analytics.a.e().onEvent("hotqrcli", new JSONObject(paramView).toString());
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = getMeasuredWidth() - this.d - this.e;
    int n = getChildCount();
    paramInt1 = this.d;
    int j = 0;
    paramInt4 = 0;
    int i = 0;
    paramInt3 = 0;
    if ((i < n) && (paramInt4 < 4))
    {
      View localView = getChildAt(i);
      int m = localView.getMeasuredWidth();
      int i1 = localView.getMeasuredHeight();
      paramInt2 = m;
      if (m > k) {
        paramInt2 = k;
      }
      j += paramInt2;
      if (j > k)
      {
        paramInt1 = this.f + paramInt2;
        paramInt4++;
        j = this.d;
        paramInt3 = paramInt3 + i1 + this.c;
        localView.layout(j, paramInt3, j + paramInt2, i1 + paramInt3);
        paramInt2 = paramInt2 + j + this.f;
      }
      for (;;)
      {
        i++;
        j = paramInt1;
        paramInt1 = paramInt2;
        break;
        if (this.f + j > k)
        {
          j = 0;
          paramInt4++;
          localView.layout(paramInt1, paramInt3, paramInt2 + paramInt1, paramInt3 + i1);
          paramInt2 = this.d;
          paramInt3 = paramInt3 + i1 + this.c;
          paramInt1 = j;
        }
        else
        {
          j += this.f;
          localView.layout(paramInt1, paramInt3, paramInt1 + paramInt2, i1 + paramInt3);
          paramInt2 = paramInt2 + paramInt1 + this.f;
          paramInt1 = j;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i2 = i4 - this.d - this.e;
    int i3 = getChildCount();
    int j = 0;
    paramInt2 = 0;
    int k = 0;
    int i1;
    int i5;
    if ((j < i3) && (k < 4))
    {
      View localView = getChildAt(j);
      measureChild(localView, paramInt1, View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
      i1 = localView.getMeasuredWidth();
      i5 = localView.getMeasuredHeight();
      if (i1 <= i2) {
        break label243;
      }
      i1 = i2;
    }
    label243:
    for (;;)
    {
      int i = paramInt2 + i1;
      int n;
      if (i > i2)
      {
        m += i5;
        k++;
        paramInt2 = m;
        n = k;
        if (k < 4)
        {
          i1 = this.f + i1;
          paramInt2 = m;
          i = i1;
          n = k;
          if (j != i3 - 1)
          {
            paramInt2 = m + this.c;
            n = k;
            i = i1;
          }
        }
      }
      for (;;)
      {
        j++;
        m = paramInt2;
        k = n;
        paramInt2 = i;
        break;
        i1 = i + this.f;
        paramInt2 = m;
        i = i1;
        n = k;
        if (j == i3 - 1)
        {
          paramInt2 = m + i5;
          i = i1;
          n = k;
        }
      }
      setMeasuredDimension(i4, m);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/WkSearchHotWordView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */