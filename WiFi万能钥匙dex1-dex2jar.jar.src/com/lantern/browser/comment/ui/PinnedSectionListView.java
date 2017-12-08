package com.lantern.browser.comment.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

public class PinnedSectionListView
  extends ListView
{
  AbsListView.OnScrollListener a;
  a b;
  a c;
  int d;
  private final Rect e = new Rect();
  private final PointF f = new PointF();
  private int g;
  private View h;
  private MotionEvent i;
  private GradientDrawable j;
  private int k;
  private int l;
  private final AbsListView.OnScrollListener m = new a(this);
  private final DataSetObserver n = new b(this);
  
  public PinnedSectionListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public PinnedSectionListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.j == null)
      {
        this.j = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { Color.parseColor("#ffa0a0a0"), Color.parseColor("#50a0a0a0"), Color.parseColor("#00a0a0a0") });
        this.l = ((int)(8.0F * getResources().getDisplayMetrics().density));
      }
    }
    for (;;)
    {
      return;
      if (this.j != null)
      {
        this.j = null;
        this.l = 0;
      }
    }
  }
  
  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    paramView.getHitRect(this.e);
    paramView = this.e;
    paramView.top += this.d;
    paramView = this.e;
    paramView.bottom += this.d + getPaddingTop();
    paramView = this.e;
    paramView.left += getPaddingLeft();
    paramView = this.e;
    paramView.right -= getPaddingRight();
    return this.e.contains((int)paramFloat1, (int)paramFloat2);
  }
  
  public static boolean a(ListAdapter paramListAdapter, int paramInt)
  {
    if ((paramListAdapter instanceof HeaderViewListAdapter)) {
      paramListAdapter = ((HeaderViewListAdapter)paramListAdapter).getWrappedAdapter();
    }
    for (;;)
    {
      return ((b)paramListAdapter).a(paramInt);
    }
  }
  
  private void d()
  {
    setOnScrollListener(this.m);
    this.g = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    a(true);
  }
  
  private void e()
  {
    this.h = null;
    if (this.i != null)
    {
      this.i.recycle();
      this.i = null;
    }
  }
  
  final int a(int paramInt)
  {
    ListAdapter localListAdapter = getAdapter();
    int i1;
    if (paramInt >= localListAdapter.getCount()) {
      i1 = -1;
    }
    for (;;)
    {
      return i1;
      if ((localListAdapter instanceof SectionIndexer))
      {
        SectionIndexer localSectionIndexer = (SectionIndexer)localListAdapter;
        int i2 = localSectionIndexer.getPositionForSection(localSectionIndexer.getSectionForPosition(paramInt));
        i1 = i2;
        if (a(localListAdapter, localListAdapter.getItemViewType(i2))) {}
      }
      else
      {
        for (;;)
        {
          if (paramInt < 0) {
            break label98;
          }
          i1 = paramInt;
          if (a(localListAdapter, localListAdapter.getItemViewType(paramInt))) {
            break;
          }
          paramInt--;
        }
        label98:
        i1 = -1;
      }
    }
  }
  
  public final void a()
  {
    a(false);
    if (this.c != null)
    {
      View localView = this.c.a;
      invalidate(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom() + this.l);
    }
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.c != null) && (this.c.b != paramInt1)) {
      b();
    }
    Object localObject1;
    View localView;
    int i1;
    int i2;
    if (this.c == null)
    {
      Object localObject2 = this.b;
      this.b = null;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new a();
      }
      localView = getAdapter().getView(paramInt1, ((a)localObject1).a, this);
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localObject2 = localLayoutParams;
      if (localLayoutParams == null)
      {
        localObject2 = generateDefaultLayoutParams();
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      i1 = View.MeasureSpec.getMode(((ViewGroup.LayoutParams)localObject2).height);
      i2 = View.MeasureSpec.getSize(((ViewGroup.LayoutParams)localObject2).height);
      if (i1 != 0) {
        break label440;
      }
      i1 = 1073741824;
    }
    label345:
    label403:
    label409:
    label414:
    label422:
    label440:
    for (;;)
    {
      int i3 = getHeight() - getListPaddingTop() - getListPaddingBottom();
      if (i2 > i3) {
        i2 = i3;
      }
      for (;;)
      {
        localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth() - getListPaddingLeft() - getListPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec(i2, i1));
        localView.layout(0, 0, localView.getMeasuredWidth(), localView.getMeasuredHeight());
        this.d = 0;
        ((a)localObject1).a = localView;
        ((a)localObject1).b = paramInt1;
        ((a)localObject1).c = getAdapter().getItemId(paramInt1);
        this.c = ((a)localObject1);
        i2 = paramInt1 + 1;
        if (i2 < getCount())
        {
          paramInt3 -= i2 - paramInt2;
          localObject1 = getAdapter();
          i1 = ((ListAdapter)localObject1).getCount();
          if (getLastVisiblePosition() >= i1) {
            break label409;
          }
          paramInt1 = paramInt3;
          if (i2 + paramInt3 >= i1) {
            paramInt1 = i1 - i2;
          }
          paramInt3 = 0;
          if (paramInt3 >= paramInt1) {
            break label409;
          }
          i1 = i2 + paramInt3;
          if (!a((ListAdapter)localObject1, ((ListAdapter)localObject1).getItemViewType(i1))) {
            break label403;
          }
          paramInt1 = i1;
          if (paramInt1 < 0) {
            break label422;
          }
          localObject1 = getChildAt(paramInt1 - paramInt2);
          paramInt2 = this.c.a.getBottom();
          paramInt1 = getPaddingTop();
          this.k = (((View)localObject1).getTop() - (paramInt2 + paramInt1));
          if (this.k >= 0) {
            break label414;
          }
          this.d = this.k;
        }
        for (;;)
        {
          return;
          paramInt3++;
          break;
          paramInt1 = -1;
          break label345;
          this.d = 0;
          continue;
          this.d = 0;
          this.k = Integer.MAX_VALUE;
        }
      }
    }
  }
  
  final void b()
  {
    if (this.c != null)
    {
      this.b = this.c;
      this.c = null;
    }
  }
  
  final void c()
  {
    b();
    ListAdapter localListAdapter = getAdapter();
    int i1;
    int i2;
    if ((localListAdapter != null) && (localListAdapter.getCount() > 0))
    {
      i1 = getFirstVisiblePosition();
      i2 = a(i1);
      if (i2 != -1) {
        break label39;
      }
    }
    for (;;)
    {
      return;
      label39:
      a(i2, i1, getLastVisiblePosition() - i1);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int i4;
    int i3;
    View localView;
    int i2;
    if (this.c != null)
    {
      i4 = getListPaddingLeft();
      i3 = getListPaddingTop();
      localView = this.c.a;
      paramCanvas.save();
      i2 = localView.getHeight();
      if (this.j != null) {
        break label187;
      }
    }
    label187:
    for (int i1 = 0;; i1 = Math.min(this.l, this.k))
    {
      paramCanvas.clipRect(i4, i3, localView.getWidth() + i4, i1 + i2 + i3);
      paramCanvas.translate(i4, this.d + i3);
      drawChild(paramCanvas, this.c.a, getDrawingTime());
      if ((this.j != null) && (this.k > 0))
      {
        this.j.setBounds(this.c.a.getLeft(), this.c.a.getBottom(), this.c.a.getRight(), this.c.a.getBottom() + this.l);
        this.j.draw(paramCanvas);
      }
      paramCanvas.restore();
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f2 = paramMotionEvent.getX();
    float f1 = paramMotionEvent.getY();
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 0) && (this.h == null) && (this.c != null) && (a(this.c.a, f2, f1)))
    {
      this.h = this.c.a;
      this.f.x = f2;
      this.f.y = f1;
      this.i = MotionEvent.obtain(paramMotionEvent);
    }
    Object localObject;
    if (this.h != null)
    {
      if (a(this.h, f2, f1)) {
        this.h.dispatchTouchEvent(paramMotionEvent);
      }
      if (i1 == 1)
      {
        super.dispatchTouchEvent(paramMotionEvent);
        if (this.c != null)
        {
          localObject = getOnItemClickListener();
          if ((localObject != null) && (getAdapter().isEnabled(this.c.b)))
          {
            paramMotionEvent = this.c.a;
            playSoundEffect(0);
            if (paramMotionEvent != null) {
              paramMotionEvent.sendAccessibilityEvent(1);
            }
            ((AdapterView.OnItemClickListener)localObject).onItemClick(this, paramMotionEvent, this.c.b, this.c.c);
          }
        }
        e();
      }
    }
    for (boolean bool = true;; bool = super.dispatchTouchEvent(paramMotionEvent))
    {
      return bool;
      if (i1 == 3)
      {
        e();
        break;
      }
      if ((i1 != 2) || (Math.abs(f1 - this.f.y) <= this.g)) {
        break;
      }
      localObject = MotionEvent.obtain(paramMotionEvent);
      ((MotionEvent)localObject).setAction(3);
      this.h.dispatchTouchEvent((MotionEvent)localObject);
      ((MotionEvent)localObject).recycle();
      super.dispatchTouchEvent(this.i);
      super.dispatchTouchEvent(paramMotionEvent);
      e();
      break;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.c != null) && (paramInt3 - paramInt1 - getPaddingLeft() - getPaddingRight() != this.c.a.getWidth())) {
      c();
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(paramParcelable);
    post(new c(this));
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    ListAdapter localListAdapter = getAdapter();
    if (localListAdapter != null) {
      localListAdapter.unregisterDataSetObserver(this.n);
    }
    if (paramListAdapter != null) {
      paramListAdapter.registerDataSetObserver(this.n);
    }
    if (localListAdapter != paramListAdapter) {
      b();
    }
    super.setAdapter(paramListAdapter);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if (paramOnScrollListener == this.m) {
      super.setOnScrollListener(paramOnScrollListener);
    }
    for (;;)
    {
      return;
      this.a = paramOnScrollListener;
    }
  }
  
  static final class a
  {
    public View a;
    public int b;
    public long c;
  }
  
  public static abstract interface b
    extends ListAdapter
  {
    public abstract boolean a(int paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/PinnedSectionListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */