package com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.wifipay.R.attr;
import com.wifipay.R.color;
import com.wifipay.R.id;
import com.wifipay.R.styleable;
import com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders.views.OnRefreshListener;

public class StickyListHeadersListView
  extends FrameLayout
{
  private boolean A = false;
  private k a;
  private View b;
  private Long c;
  private Integer d;
  private Integer e;
  private AbsListView.OnScrollListener f;
  private a g;
  private boolean h = true;
  private boolean i = true;
  private boolean j = true;
  private int k = 0;
  private int l = 0;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private float p;
  private boolean q;
  private float r = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private OnHeaderClickListener s;
  private OnStickyHeaderOffsetChangedListener t;
  private OnStickyHeaderChangedListener u;
  private a v;
  private Drawable w;
  private int x;
  private View y;
  private LoadMoreListener z;
  
  public StickyListHeadersListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StickyListHeadersListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.wifipay_stickyListHeadersListViewStyle);
  }
  
  public StickyListHeadersListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new k(paramContext);
    this.w = this.a.getDivider();
    this.x = this.a.getDividerHeight();
    this.a.setDivider(null);
    this.a.setDividerHeight(0);
    this.a.setCacheColorHint(getResources().getColor(R.color.wifipay_transparent));
    Drawable localDrawable = getResources().getDrawable(R.color.wifipay_transparent);
    this.a.setSelector(localDrawable);
    if (paramAttributeSet != null) {
      paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.WPStickyListHeadersListView, paramInt, 0);
    }
    for (;;)
    {
      try
      {
        paramInt = paramContext.getDimensionPixelSize(R.styleable.WPStickyListHeadersListView_android_padding, 0);
        this.l = paramContext.getDimensionPixelSize(R.styleable.WPStickyListHeadersListView_android_paddingLeft, paramInt);
        this.m = paramContext.getDimensionPixelSize(R.styleable.WPStickyListHeadersListView_android_paddingTop, paramInt);
        this.n = paramContext.getDimensionPixelSize(R.styleable.WPStickyListHeadersListView_android_paddingRight, paramInt);
        this.o = paramContext.getDimensionPixelSize(R.styleable.WPStickyListHeadersListView_android_paddingBottom, paramInt);
        setPadding(this.l, this.m, this.n, this.o);
        this.i = paramContext.getBoolean(R.styleable.WPStickyListHeadersListView_android_clipToPadding, true);
        super.setClipToPadding(true);
        this.a.setClipToPadding(this.i);
        paramInt = paramContext.getInt(R.styleable.WPStickyListHeadersListView_android_scrollbars, 512);
        paramAttributeSet = this.a;
        if ((paramInt & 0x200) != 0)
        {
          bool1 = true;
          paramAttributeSet.setVerticalScrollBarEnabled(bool1);
          paramAttributeSet = this.a;
          if ((paramInt & 0x100) != 0)
          {
            bool1 = bool2;
            paramAttributeSet.setHorizontalScrollBarEnabled(bool1);
            if (Build.VERSION.SDK_INT >= 9) {
              this.a.setOverScrollMode(paramContext.getInt(R.styleable.WPStickyListHeadersListView_android_overScrollMode, 0));
            }
            this.a.setFadingEdgeLength(paramContext.getDimensionPixelSize(R.styleable.WPStickyListHeadersListView_android_fadingEdgeLength, this.a.getVerticalFadingEdgeLength()));
            paramInt = paramContext.getInt(R.styleable.WPStickyListHeadersListView_android_requiresFadingEdge, 0);
            if (paramInt != 4096) {
              continue;
            }
            this.a.setVerticalFadingEdgeEnabled(false);
            this.a.setHorizontalFadingEdgeEnabled(true);
            this.a.setCacheColorHint(paramContext.getColor(R.styleable.WPStickyListHeadersListView_android_cacheColorHint, this.a.getCacheColorHint()));
            if (Build.VERSION.SDK_INT >= 11) {
              this.a.setChoiceMode(paramContext.getInt(R.styleable.WPStickyListHeadersListView_android_choiceMode, this.a.getChoiceMode()));
            }
            this.a.setDrawSelectorOnTop(paramContext.getBoolean(R.styleable.WPStickyListHeadersListView_android_drawSelectorOnTop, false));
            this.a.setFastScrollEnabled(paramContext.getBoolean(R.styleable.WPStickyListHeadersListView_android_fastScrollEnabled, this.a.isFastScrollEnabled()));
            if (Build.VERSION.SDK_INT >= 11) {
              this.a.setFastScrollAlwaysVisible(paramContext.getBoolean(R.styleable.WPStickyListHeadersListView_android_fastScrollAlwaysVisible, this.a.isFastScrollAlwaysVisible()));
            }
            if (paramContext.hasValue(R.styleable.WPStickyListHeadersListView_android_listSelector)) {
              this.a.setSelector(paramContext.getDrawable(R.styleable.WPStickyListHeadersListView_android_listSelector));
            }
            this.a.setScrollingCacheEnabled(paramContext.getBoolean(R.styleable.WPStickyListHeadersListView_android_scrollingCache, this.a.isScrollingCacheEnabled()));
            if (paramContext.hasValue(R.styleable.WPStickyListHeadersListView_android_divider)) {
              this.w = paramContext.getDrawable(R.styleable.WPStickyListHeadersListView_android_divider);
            }
            this.a.setStackFromBottom(paramContext.getBoolean(R.styleable.WPStickyListHeadersListView_android_stackFromBottom, false));
            this.x = paramContext.getDimensionPixelSize(R.styleable.WPStickyListHeadersListView_android_dividerHeight, this.x);
            this.a.setTranscriptMode(paramContext.getInt(R.styleable.WPStickyListHeadersListView_android_transcriptMode, 0));
            this.h = paramContext.getBoolean(R.styleable.WPStickyListHeadersListView_hasStickyHeaders, true);
            this.j = paramContext.getBoolean(R.styleable.WPStickyListHeadersListView_isDrawingListUnderStickyHeader, true);
            paramContext.recycle();
            this.a.a(new d(null));
            this.a.setOnScrollListener(new c(null));
            addView(this.a);
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        boolean bool1 = false;
        continue;
        if (paramInt == 8192)
        {
          this.a.setVerticalFadingEdgeEnabled(true);
          this.a.setHorizontalFadingEdgeEnabled(false);
          continue;
        }
        this.a.setVerticalFadingEdgeEnabled(false);
      }
      finally
      {
        paramContext.recycle();
      }
      this.a.setHorizontalFadingEdgeEnabled(false);
    }
  }
  
  private void a(int paramInt)
  {
    int i4 = 0;
    int i1;
    if (this.g == null)
    {
      i1 = 0;
      if ((i1 != 0) && (this.h)) {
        break label35;
      }
    }
    for (;;)
    {
      return;
      i1 = this.g.getCount();
      break;
      label35:
      int i2 = paramInt - this.a.getHeaderViewsCount();
      paramInt = i2;
      if (this.a.getChildCount() > 0)
      {
        paramInt = i2;
        if (this.a.getChildAt(0).getBottom() < g()) {
          paramInt = i2 + 1;
        }
      }
      if (this.a.getChildCount() != 0)
      {
        i2 = 1;
        label93:
        if ((i2 == 0) || (this.a.getFirstVisiblePosition() != 0) || (this.a.getChildAt(0).getTop() < g())) {
          break label169;
        }
      }
      label169:
      for (int i3 = 1;; i3 = 0)
      {
        if (paramInt <= i1 - 1)
        {
          i1 = i4;
          if (paramInt >= 0) {}
        }
        else
        {
          i1 = 1;
        }
        if ((i2 != 0) && (i1 == 0) && (i3 == 0)) {
          break label175;
        }
        c();
        break;
        i2 = 0;
        break label93;
      }
      label175:
      b(paramInt);
    }
  }
  
  private void b(int paramInt)
  {
    View localView;
    if ((this.d == null) || (this.d.intValue() != paramInt))
    {
      this.d = Integer.valueOf(paramInt);
      long l1 = this.g.getHeaderId(paramInt);
      if ((this.c == null) || (this.c.longValue() != l1))
      {
        this.c = Long.valueOf(l1);
        localView = this.g.getHeaderView(this.d.intValue(), this.b, this);
        if (this.b != localView)
        {
          if (localView == null) {
            throw new NullPointerException("header may not be null");
          }
          d(localView);
        }
        b(this.b);
        c(this.b);
        if (this.u != null) {
          this.u.onStickyHeaderChanged(this, this.b, paramInt, this.c.longValue());
        }
        this.e = null;
      }
    }
    int i2 = g();
    paramInt = 0;
    int i1;
    if (paramInt < this.a.getChildCount())
    {
      localView = this.a.getChildAt(paramInt);
      if (((localView instanceof j)) && (((j)localView).a()))
      {
        i1 = 1;
        label216:
        boolean bool = this.a.a(localView);
        if ((localView.getTop() < g()) || ((i1 == 0) && (!bool))) {
          break label310;
        }
      }
    }
    for (paramInt = Math.min(localView.getTop() - this.b.getMeasuredHeight(), i2);; paramInt = i2)
    {
      setHeaderOffet(paramInt);
      if (!this.j) {
        this.a.a(this.b.getMeasuredHeight() + this.e.intValue());
      }
      d();
      return;
      i1 = 0;
      break label216;
      label310:
      paramInt++;
      break;
    }
  }
  
  private void b(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams == null) {
      paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }
    for (;;)
    {
      return;
      if ((localLayoutParams.height == -1) || (localLayoutParams.width == -2))
      {
        localLayoutParams.height = -2;
        localLayoutParams.width = -1;
        paramView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  private void c()
  {
    if (this.b != null)
    {
      removeView(this.b);
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = null;
      this.a.a(0);
      d();
    }
  }
  
  private void c(View paramView)
  {
    if (paramView != null) {
      measureChild(paramView, View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - this.l - this.n, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
  }
  
  private boolean c(int paramInt)
  {
    if (Build.VERSION.SDK_INT < paramInt) {
      Log.e("StickyListHeaders", "Api lvl must be at least " + paramInt + " to call this method");
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private void d()
  {
    int i3 = g();
    int i2 = this.a.getChildCount();
    int i1 = 0;
    if (i1 < i2)
    {
      Object localObject = this.a.getChildAt(i1);
      View localView;
      if ((localObject instanceof j))
      {
        localObject = (j)localObject;
        if (((j)localObject).a())
        {
          localView = ((j)localObject).d;
          if (((j)localObject).getTop() >= i3) {
            break label90;
          }
          if (localView.getVisibility() != 4) {
            localView.setVisibility(4);
          }
        }
      }
      for (;;)
      {
        i1++;
        break;
        label90:
        if (localView.getVisibility() != 0) {
          localView.setVisibility(0);
        }
      }
    }
  }
  
  private void d(View paramView)
  {
    if (this.b != null) {
      removeView(this.b);
    }
    this.b = paramView;
    addView(this.b);
    if (this.s != null) {
      this.b.setOnClickListener(new f(this));
    }
    this.b.setClickable(true);
  }
  
  private void e()
  {
    if (this.y != null) {
      this.y.findViewById(R.id.wifipay_item_bill_foot_view).setVisibility(0);
    }
  }
  
  private void f()
  {
    Log.i("Sticky", "--loadMore--" + this.z);
    if (this.z != null) {
      this.z.loadingMore();
    }
  }
  
  private int g()
  {
    int i2 = this.k;
    if (this.i) {}
    for (int i1 = this.m;; i1 = 0) {
      return i1 + i2;
    }
  }
  
  private void setHeaderOffet(int paramInt)
  {
    if ((this.e == null) || (this.e.intValue() != paramInt))
    {
      this.e = Integer.valueOf(paramInt);
      if (Build.VERSION.SDK_INT < 11) {
        break label79;
      }
      this.b.setTranslationY(this.e.intValue());
    }
    for (;;)
    {
      if (this.t != null) {
        this.t.onStickyHeaderOffsetChanged(this, this.b, -this.e.intValue());
      }
      return;
      label79:
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.b.getLayoutParams();
      localMarginLayoutParams.topMargin = this.e.intValue();
      this.b.setLayoutParams(localMarginLayoutParams);
    }
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(View paramView)
  {
    this.a.addFooterView(paramView);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.y != null) {
      this.y.findViewById(R.id.wifipay_item_bill_foot_view).setVisibility(8);
    }
    this.A = paramBoolean;
  }
  
  public boolean b()
  {
    return this.h;
  }
  
  public boolean canScrollVertically(int paramInt)
  {
    return this.a.canScrollVertically(paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.a.getVisibility() == 0) || (this.a.getAnimation() != null)) {
      drawChild(paramCanvas, this.a, 0L);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool;
    if ((paramMotionEvent.getAction() & 0xFF) == 0)
    {
      this.p = paramMotionEvent.getY();
      if ((this.b != null) && (this.p <= this.b.getHeight() + this.e.intValue()))
      {
        bool = true;
        this.q = bool;
      }
    }
    else
    {
      if (!this.q) {
        break label191;
      }
      if ((this.b == null) || (Math.abs(this.p - paramMotionEvent.getY()) > this.r)) {
        break label107;
      }
      bool = this.b.dispatchTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      return bool;
      bool = false;
      break;
      label107:
      if (this.b != null)
      {
        MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
        localMotionEvent.setAction(3);
        this.b.dispatchTouchEvent(localMotionEvent);
        localMotionEvent.recycle();
      }
      paramMotionEvent = MotionEvent.obtain(paramMotionEvent.getDownTime(), paramMotionEvent.getEventTime(), paramMotionEvent.getAction(), paramMotionEvent.getX(), this.p, paramMotionEvent.getMetaState());
      paramMotionEvent.setAction(0);
      bool = this.a.dispatchTouchEvent(paramMotionEvent);
      paramMotionEvent.recycle();
      this.q = false;
      continue;
      label191:
      bool = this.a.dispatchTouchEvent(paramMotionEvent);
    }
  }
  
  public StickyListHeadersAdapter getAdapter()
  {
    if (this.g == null) {}
    for (StickyListHeadersAdapter localStickyListHeadersAdapter = null;; localStickyListHeadersAdapter = this.g.a) {
      return localStickyListHeadersAdapter;
    }
  }
  
  @Deprecated
  public boolean getAreHeadersSticky()
  {
    return b();
  }
  
  public int getCheckedItemCount()
  {
    if (c(11)) {}
    for (int i1 = this.a.getCheckedItemCount();; i1 = 0) {
      return i1;
    }
  }
  
  public long[] getCheckedItemIds()
  {
    return null;
  }
  
  public int getCheckedItemPosition()
  {
    return this.a.getCheckedItemPosition();
  }
  
  public SparseBooleanArray getCheckedItemPositions()
  {
    return this.a.getCheckedItemPositions();
  }
  
  public int getCount()
  {
    return this.a.getCount();
  }
  
  public Drawable getDivider()
  {
    return this.w;
  }
  
  public int getDividerHeight()
  {
    return this.x;
  }
  
  public View getEmptyView()
  {
    return this.a.getEmptyView();
  }
  
  public int getFirstVisiblePosition()
  {
    return this.a.getFirstVisiblePosition();
  }
  
  public int getFooterViewsCount()
  {
    return this.a.getFooterViewsCount();
  }
  
  public int getHeaderViewsCount()
  {
    return this.a.getHeaderViewsCount();
  }
  
  public int getLastVisiblePosition()
  {
    return this.a.getLastVisiblePosition();
  }
  
  public int getListChildCount()
  {
    return this.a.getChildCount();
  }
  
  public int getOverScrollMode()
  {
    if (c(9)) {}
    for (int i1 = this.a.getOverScrollMode();; i1 = 0) {
      return i1;
    }
  }
  
  public int getPaddingBottom()
  {
    return this.o;
  }
  
  public int getPaddingLeft()
  {
    return this.l;
  }
  
  public int getPaddingRight()
  {
    return this.n;
  }
  
  public int getPaddingTop()
  {
    return this.m;
  }
  
  public int getScrollBarStyle()
  {
    return this.a.getScrollBarStyle();
  }
  
  public int getStickyHeaderTopOffset()
  {
    return this.k;
  }
  
  public ListView getWrappedList()
  {
    return this.a;
  }
  
  public boolean isHorizontalScrollBarEnabled()
  {
    return this.a.isHorizontalScrollBarEnabled();
  }
  
  public boolean isVerticalScrollBarEnabled()
  {
    return this.a.isVerticalScrollBarEnabled();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.layout(0, 0, this.a.getMeasuredWidth(), getHeight());
    if (this.b != null)
    {
      paramInt1 = ((ViewGroup.MarginLayoutParams)this.b.getLayoutParams()).topMargin;
      this.b.layout(this.l, paramInt1, this.b.getMeasuredWidth() + this.l, this.b.getMeasuredHeight() + paramInt1);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    c(this.b);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    super.onRestoreInstanceState(View.BaseSavedState.EMPTY_STATE);
    this.a.onRestoreInstanceState(paramParcelable);
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (super.onSaveInstanceState() != View.BaseSavedState.EMPTY_STATE) {
      throw new IllegalStateException("Handling non empty state of parent class is not implemented");
    }
    return this.a.onSaveInstanceState();
  }
  
  public void setAdapter(StickyListHeadersAdapter paramStickyListHeadersAdapter)
  {
    if (paramStickyListHeadersAdapter == null)
    {
      if ((this.g instanceof e)) {
        ((e)this.g).b = null;
      }
      if (this.g != null) {
        this.g.a = null;
      }
      this.a.setAdapter(null);
      c();
      return;
    }
    if (this.g != null) {
      this.g.unregisterDataSetObserver(this.v);
    }
    if ((paramStickyListHeadersAdapter instanceof SectionIndexer))
    {
      this.g = new e(getContext(), paramStickyListHeadersAdapter);
      label94:
      this.v = new a(null);
      this.g.registerDataSetObserver(this.v);
      if (this.s == null) {
        break label193;
      }
      this.g.a(new b(null));
    }
    for (;;)
    {
      this.g.a(this.w, this.x);
      this.a.setAdapter(this.g);
      c();
      break;
      this.g = new a(getContext(), paramStickyListHeadersAdapter);
      break label94;
      label193:
      this.g.a(null);
    }
  }
  
  public void setAreHeadersSticky(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (!paramBoolean) {
      c();
    }
    for (;;)
    {
      this.a.invalidate();
      return;
      a(this.a.b());
    }
  }
  
  public void setBlockLayoutChildren(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public void setChoiceMode(int paramInt)
  {
    this.a.setChoiceMode(paramInt);
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.setClipToPadding(paramBoolean);
    }
    this.i = paramBoolean;
  }
  
  public void setDivider(Drawable paramDrawable)
  {
    this.w = paramDrawable;
    if (this.g != null) {
      this.g.a(this.w, this.x);
    }
  }
  
  public void setDividerHeight(int paramInt)
  {
    this.x = paramInt;
    if (this.g != null) {
      this.g.a(this.w, this.x);
    }
  }
  
  public void setDrawingListUnderStickyHeader(boolean paramBoolean)
  {
    this.j = paramBoolean;
    this.a.a(0);
  }
  
  public void setEmptyView(View paramView)
  {
    this.a.setEmptyView(paramView);
  }
  
  public void setFastScrollAlwaysVisible(boolean paramBoolean)
  {
    if (c(11)) {
      this.a.setFastScrollAlwaysVisible(paramBoolean);
    }
  }
  
  public void setFastScrollEnabled(boolean paramBoolean)
  {
    this.a.setFastScrollEnabled(paramBoolean);
  }
  
  public void setFooterView(View paramView)
  {
    this.y = paramView;
    a(this.y);
    a(this.A);
  }
  
  public void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    this.a.setHorizontalScrollBarEnabled(paramBoolean);
  }
  
  public void setLoadMoreListener(LoadMoreListener paramLoadMoreListener)
  {
    this.z = paramLoadMoreListener;
  }
  
  public void setMultiChoiceModeListener(AbsListView.MultiChoiceModeListener paramMultiChoiceModeListener)
  {
    if (c(11)) {
      this.a.setMultiChoiceModeListener(paramMultiChoiceModeListener);
    }
  }
  
  public void setOnCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.a.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
  }
  
  public void setOnHeaderClickListener(OnHeaderClickListener paramOnHeaderClickListener)
  {
    this.s = paramOnHeaderClickListener;
    if (this.g != null)
    {
      if (this.s == null) {
        break label58;
      }
      this.g.a(new b(null));
      if (this.b != null) {
        this.b.setOnClickListener(new g(this));
      }
    }
    for (;;)
    {
      return;
      label58:
      this.g.a(null);
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.a.setOnItemClickListener(paramOnItemClickListener);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    this.a.setOnItemLongClickListener(paramOnItemLongClickListener);
  }
  
  public void setOnRefreshListener(OnRefreshListener paramOnRefreshListener)
  {
    this.a.setOnRefreshListener(paramOnRefreshListener);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.f = paramOnScrollListener;
  }
  
  public void setOnStickyHeaderChangedListener(OnStickyHeaderChangedListener paramOnStickyHeaderChangedListener)
  {
    this.u = paramOnStickyHeaderChangedListener;
  }
  
  public void setOnStickyHeaderOffsetChangedListener(OnStickyHeaderOffsetChangedListener paramOnStickyHeaderOffsetChangedListener)
  {
    this.t = paramOnStickyHeaderOffsetChangedListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    if (paramOnTouchListener != null) {
      this.a.setOnTouchListener(new h(this, paramOnTouchListener));
    }
    for (;;)
    {
      return;
      this.a.setOnTouchListener(null);
    }
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if ((c(9)) && (this.a != null)) {
      this.a.setOverScrollMode(paramInt);
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.l = paramInt1;
    this.m = paramInt2;
    this.n = paramInt3;
    this.o = paramInt4;
    if (this.a != null) {
      this.a.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    super.setPadding(0, 0, 0, 0);
    requestLayout();
  }
  
  public void setScrollBarStyle(int paramInt)
  {
    this.a.setScrollBarStyle(paramInt);
  }
  
  public void setSelection(int paramInt) {}
  
  public void setSelector(int paramInt)
  {
    this.a.setSelector(paramInt);
  }
  
  public void setSelector(Drawable paramDrawable)
  {
    this.a.setSelector(paramDrawable);
  }
  
  public void setStackFromBottom(boolean paramBoolean)
  {
    this.a.setStackFromBottom(paramBoolean);
  }
  
  public void setStickyHeaderTopOffset(int paramInt)
  {
    this.k = paramInt;
    a(this.a.b());
  }
  
  public void setTranscriptMode(int paramInt)
  {
    this.a.setTranscriptMode(paramInt);
  }
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    this.a.setVerticalScrollBarEnabled(paramBoolean);
  }
  
  public boolean showContextMenu()
  {
    return this.a.showContextMenu();
  }
  
  public static abstract interface OnHeaderClickListener
  {
    public abstract void onHeaderClick(StickyListHeadersListView paramStickyListHeadersListView, View paramView, int paramInt, long paramLong, boolean paramBoolean);
  }
  
  public static abstract interface OnStickyHeaderChangedListener
  {
    public abstract void onStickyHeaderChanged(StickyListHeadersListView paramStickyListHeadersListView, View paramView, int paramInt, long paramLong);
  }
  
  public static abstract interface OnStickyHeaderOffsetChangedListener
  {
    public abstract void onStickyHeaderOffsetChanged(StickyListHeadersListView paramStickyListHeadersListView, View paramView, int paramInt);
  }
  
  private class a
    extends DataSetObserver
  {
    private a() {}
    
    public void onChanged()
    {
      StickyListHeadersListView.e(StickyListHeadersListView.this);
    }
    
    public void onInvalidated()
    {
      StickyListHeadersListView.e(StickyListHeadersListView.this);
    }
  }
  
  private class b
    implements a.a
  {
    private b() {}
    
    public void a(View paramView, int paramInt, long paramLong)
    {
      StickyListHeadersListView.d(StickyListHeadersListView.this).onHeaderClick(StickyListHeadersListView.this, paramView, paramInt, paramLong, false);
    }
  }
  
  private class c
    implements AbsListView.OnScrollListener
  {
    private c() {}
    
    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramInt1 == 0) {
        StickyListHeadersListView.f(StickyListHeadersListView.this).setRefreshable(true);
      }
      for (;;)
      {
        if (StickyListHeadersListView.g(StickyListHeadersListView.this) != null) {
          StickyListHeadersListView.g(StickyListHeadersListView.this).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
        }
        StickyListHeadersListView.a(StickyListHeadersListView.this, StickyListHeadersListView.f(StickyListHeadersListView.this).b());
        return;
        StickyListHeadersListView.f(StickyListHeadersListView.this).setRefreshable(false);
      }
    }
    
    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      if (StickyListHeadersListView.g(StickyListHeadersListView.this) != null) {
        StickyListHeadersListView.g(StickyListHeadersListView.this).onScrollStateChanged(paramAbsListView, paramInt);
      }
      if ((paramInt != 2) && ((paramInt == 1) || (paramInt == 0)) && (StickyListHeadersListView.this.getLastVisiblePosition() == StickyListHeadersListView.this.getCount() - 1) && (!StickyListHeadersListView.h(StickyListHeadersListView.this)))
      {
        paramInt = StickyListHeadersListView.f(StickyListHeadersListView.this).getState();
        StickyListHeadersListView.f(StickyListHeadersListView.this);
        if (paramInt == 3)
        {
          StickyListHeadersListView.a(StickyListHeadersListView.this, true);
          StickyListHeadersListView.i(StickyListHeadersListView.this);
          StickyListHeadersListView.j(StickyListHeadersListView.this);
        }
      }
    }
  }
  
  private class d
    implements k.a
  {
    private d() {}
    
    public void a(Canvas paramCanvas)
    {
      if (Build.VERSION.SDK_INT < 8) {
        StickyListHeadersListView.a(StickyListHeadersListView.this, StickyListHeadersListView.f(StickyListHeadersListView.this).b());
      }
      if (StickyListHeadersListView.a(StickyListHeadersListView.this) != null)
      {
        if (!StickyListHeadersListView.k(StickyListHeadersListView.this)) {
          break label99;
        }
        paramCanvas.save();
        paramCanvas.clipRect(0, StickyListHeadersListView.l(StickyListHeadersListView.this), StickyListHeadersListView.this.getRight(), StickyListHeadersListView.this.getBottom());
        StickyListHeadersListView.a(StickyListHeadersListView.this, paramCanvas, StickyListHeadersListView.a(StickyListHeadersListView.this), 0L);
        paramCanvas.restore();
      }
      for (;;)
      {
        return;
        label99:
        StickyListHeadersListView.b(StickyListHeadersListView.this, paramCanvas, StickyListHeadersListView.a(StickyListHeadersListView.this), 0L);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/se/emilsjolander/stickylistheaders/StickyListHeadersListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */