package com.wifipay.wallet.home.widget;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.wifipay.R.drawable;
import com.wifipay.wallet.home.bean.Banner;
import com.wifipay.wallet.home.widget.image.SmartImageView;
import java.util.List;

public class BannerViewPager
  extends ViewPager
  implements Handler.Callback
{
  public long a = 4000L;
  private List<ImageView> b;
  private int c;
  private List<Banner> d;
  private MyViewPagerAdapter e;
  private SmartImageView[] f;
  private com.wifipay.framework.api.d g = new com.wifipay.framework.api.d(this);
  private com.wifipay.framework.api.d h = new com.wifipay.framework.api.d();
  private OnItemClickListener i;
  private int j;
  
  public BannerViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }
  
  public BannerViewPager(Context paramContext, List<ImageView> paramList)
  {
    super(paramContext);
    this.b = paramList;
    d();
  }
  
  private void d()
  {
    setOnPageChangeListener(new b(this));
    setOnTouchListener(new c(this));
  }
  
  public void a()
  {
    this.g.a(null);
  }
  
  public void b()
  {
    this.g.a(null);
    this.g.a(0, this.a);
  }
  
  public void c()
  {
    if (this.e == null)
    {
      this.e = new MyViewPagerAdapter();
      setAdapter(this.e);
      setCurrentItem(this.d.size() * 1000, true);
    }
    for (;;)
    {
      this.g.a(null);
      this.g.a(0, this.a);
      return;
      this.e.notifyDataSetChanged();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 0) && (this.d.size() > 1))
    {
      setCurrentItem(getCurrentItem() + 1, true);
      this.g.a(0, this.a);
    }
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      for (;;)
      {
        paramMotionEvent.printStackTrace();
        boolean bool = false;
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      getParent().requestDisallowInterceptTouchEvent(true);
      bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      for (;;)
      {
        paramMotionEvent.printStackTrace();
        boolean bool = false;
      }
    }
  }
  
  public void setBannerDelayTime(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void setImageDrawable(List<Banner> paramList)
  {
    this.d = paramList;
    if ((this.f == null) || (this.f.length != this.d.size())) {
      this.f = new SmartImageView[this.d.size()];
    }
  }
  
  public void setOnItemClickListener(OnItemClickListener paramOnItemClickListener)
  {
    this.i = paramOnItemClickListener;
  }
  
  public class MyViewPagerAdapter
    extends PagerAdapter
  {
    public MyViewPagerAdapter() {}
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
    }
    
    public int getCount()
    {
      int i = 1;
      if (BannerViewPager.e(BannerViewPager.this).size() == 1) {}
      for (;;)
      {
        return i;
        i = Integer.MAX_VALUE;
      }
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      paramInt %= BannerViewPager.e(BannerViewPager.this).size();
      if (BannerViewPager.f(BannerViewPager.this) == null) {
        BannerViewPager.a(BannerViewPager.this, new SmartImageView[BannerViewPager.e(BannerViewPager.this).size()]);
      }
      SmartImageView localSmartImageView;
      if (BannerViewPager.f(BannerViewPager.this)[paramInt] == null)
      {
        localSmartImageView = new SmartImageView(paramViewGroup.getContext());
        localSmartImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
      for (;;)
      {
        try
        {
          localSmartImageView.setImageUrl(((Banner)BannerViewPager.e(BannerViewPager.this).get(paramInt)).src);
          localSmartImageView.setTag(Integer.valueOf(paramInt));
          BannerViewPager.f(BannerViewPager.this)[paramInt] = localSmartImageView;
          localSmartImageView.setOnClickListener(new d(this));
          paramViewGroup.addView(localSmartImageView);
          return localSmartImageView;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          continue;
        }
        localSmartImageView = BannerViewPager.f(BannerViewPager.this)[paramInt];
      }
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      if (paramView == paramObject) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  public static abstract interface OnItemClickListener
  {
    public abstract void onItemClick(View paramView);
  }
  
  public class a
    implements Runnable
  {
    private int b;
    
    public a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void a(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void run()
    {
      ((ImageView)BannerViewPager.a(BannerViewPager.this).get(BannerViewPager.h(BannerViewPager.this))).setImageResource(R.drawable.wifipay_home_banner_indicator_normal);
      BannerViewPager.b(BannerViewPager.this, this.b % BannerViewPager.a(BannerViewPager.this).size());
      ((ImageView)BannerViewPager.a(BannerViewPager.this).get(this.b % BannerViewPager.e(BannerViewPager.this).size())).setImageResource(R.drawable.wifipay_home_banner_indicator_current);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/BannerViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */