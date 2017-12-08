package com.lantern.favorite.flowlayout;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.lantern.favorite.R.styleable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TagFlowLayout
  extends FlowLayout
  implements a.a
{
  private a d;
  private boolean e = true;
  private int f = -1;
  private MotionEvent g;
  private Set<Integer> h = new HashSet();
  private a i;
  private b j;
  
  public TagFlowLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TagFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TagFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TagFlowLayout);
    this.e = paramContext.getBoolean(0, true);
    this.f = paramContext.getInt(1, -1);
    paramContext.recycle();
    if (this.e) {
      setClickable(true);
    }
  }
  
  private static int a(Context paramContext)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * 5.0F + 0.5F);
  }
  
  private int a(View paramView)
  {
    int m = getChildCount();
    int k = 0;
    if (k < m) {
      if (getChildAt(k) != paramView) {}
    }
    for (;;)
    {
      return k;
      k++;
      break;
      k = -1;
    }
  }
  
  private void c()
  {
    removeAllViews();
    a locala = this.d;
    HashSet localHashSet = this.d.a();
    int k = 0;
    if (k < locala.b())
    {
      View localView = locala.a(this, k, locala.a(k));
      b localb = new b(getContext());
      localView.setDuplicateParentStateEnabled(true);
      if (localView.getLayoutParams() != null) {
        localb.setLayoutParams(localView.getLayoutParams());
      }
      for (;;)
      {
        localb.addView(localView);
        addView(localb);
        if (localHashSet.contains(Integer.valueOf(k))) {
          localb.setChecked(true);
        }
        locala.a(k);
        k++;
        break;
        ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        localMarginLayoutParams.setMargins(a(getContext()), a(getContext()), a(getContext()), a(getContext()));
        localb.setLayoutParams(localMarginLayoutParams);
      }
    }
    this.h.addAll(localHashSet);
  }
  
  public final void a()
  {
    this.h.clear();
    c();
  }
  
  public final void a(b paramb)
  {
    this.j = paramb;
    setClickable(true);
  }
  
  public final void a(a parama)
  {
    this.d = parama;
    this.d.a(this);
    this.h.clear();
    c();
  }
  
  public final Set<Integer> b()
  {
    return new HashSet(this.h);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = getChildCount();
    for (int k = 0; k < m; k++)
    {
      b localb = (b)getChildAt(k);
      if ((localb.getVisibility() != 8) && (localb.getChildAt(0).getVisibility() == 8)) {
        localb.setVisibility(8);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      Object localObject = paramParcelable.getString("key_choose_pos");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        String[] arrayOfString = ((String)localObject).split("\\|");
        int m = arrayOfString.length;
        for (int k = 0; k < m; k++)
        {
          int n = Integer.parseInt(arrayOfString[k]);
          this.h.add(Integer.valueOf(n));
          localObject = (b)getChildAt(n);
          if (localObject != null) {
            ((b)localObject).setChecked(true);
          }
        }
      }
      super.onRestoreInstanceState(paramParcelable.getParcelable("key_default"));
    }
    for (;;)
    {
      return;
      super.onRestoreInstanceState(paramParcelable);
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_default", super.onSaveInstanceState());
    String str = "";
    if (this.h.size() > 0)
    {
      Iterator localIterator = this.h.iterator();
      int k;
      for (str = ""; localIterator.hasNext(); str = str + k + "|") {
        k = ((Integer)localIterator.next()).intValue();
      }
      str = str.substring(0, str.length() - 1);
    }
    localBundle.putString("key_choose_pos", str);
    return localBundle;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    performClick();
    if (paramMotionEvent.getAction() == 1) {
      this.g = MotionEvent.obtain(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    boolean bool;
    if (this.g == null) {
      bool = super.performClick();
    }
    for (;;)
    {
      return bool;
      int i1 = (int)this.g.getX();
      int m = (int)this.g.getY();
      this.g = null;
      int n = getChildCount();
      int k = 0;
      label47:
      b localb;
      if (k < n)
      {
        localb = (b)getChildAt(k);
        if (localb.getVisibility() != 8)
        {
          Object localObject = new Rect();
          localb.getHitRect((Rect)localObject);
          if (((Rect)localObject).contains(i1, m))
          {
            label99:
            k = a(localb);
            if (localb == null) {
              break label342;
            }
            if (this.e)
            {
              if (localb.isChecked()) {
                break label319;
              }
              if ((this.f != 1) || (this.h.size() != 1)) {
                break label273;
              }
              localObject = (Integer)this.h.iterator().next();
              ((b)getChildAt(((Integer)localObject).intValue())).setChecked(false);
              localb.setChecked(true);
              this.h.remove(localObject);
              this.h.add(Integer.valueOf(k));
            }
          }
        }
      }
      for (;;)
      {
        if (this.i != null) {
          new HashSet(this.h);
        }
        label273:
        do
        {
          if (this.j == null) {
            break label342;
          }
          bool = this.j.a(localb.getChildAt(0), k);
          break;
          k++;
          break label47;
          localb = null;
          break label99;
        } while ((this.f > 0) && (this.h.size() >= this.f));
        localb.setChecked(true);
        this.h.add(Integer.valueOf(k));
        continue;
        label319:
        localb.setChecked(false);
        this.h.remove(Integer.valueOf(k));
      }
      label342:
      bool = true;
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract boolean a(View paramView, int paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/flowlayout/TagFlowLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */