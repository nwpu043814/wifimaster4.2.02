package com.lantern.launcher.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bluefay.app.Fragment;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.core.config.ShareApNewConf;
import com.lantern.core.config.d;
import com.lantern.widget.WkCheckBox;
import java.util.ArrayList;

public class UserGuideFragment
  extends Fragment
{
  private ViewPager g;
  private LinearLayout h;
  private ArrayList<View> i;
  private ArrayList<ImageView> j;
  private boolean k = true;
  private LayoutInflater l;
  private int m;
  private boolean n;
  private Handler o;
  private WkCheckBox p;
  private TextView q;
  private WkCheckBox r;
  private TextView s;
  private boolean t = false;
  private com.bluefay.b.a u = new s(this);
  
  private void c()
  {
    if (this.i == null) {}
    for (;;)
    {
      return;
      int i2 = this.i.size();
      this.j = new ArrayList();
      for (int i1 = 0; i1 < i2; i1++)
      {
        ImageView localImageView = new ImageView(this.e);
        localObject = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject).setMargins(8, 0, 8, 0);
        this.h.addView(localImageView, (ViewGroup.LayoutParams)localObject);
        this.j.add(localImageView);
      }
      Object localObject = ((WindowManager)this.e.getSystemService("window")).getDefaultDisplay();
      i1 = ((Display)localObject).getWidth();
      if (((Display)localObject).getHeight() / i1 < 1.7777778F)
      {
        localObject = (RelativeLayout.LayoutParams)this.h.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = e.a(this.e, 20.0F);
        this.h.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  private void d()
  {
    Object localObject1 = h();
    for (int i1 = 0; i1 < 3; i1++)
    {
      localObject2 = localObject1[i1];
      this.i.add(localObject2);
    }
    localObject1 = com.lantern.bindapp.a.b(this.e);
    if (localObject1 != null) {
      this.i.add(localObject1);
    }
    View localView = this.l.inflate(2130968791, null);
    Button localButton = (Button)localView.findViewById(2131821118);
    Object localObject2 = (TextView)localView.findViewById(2131821111);
    localObject1 = (ImageView)localView.findViewById(2131821119);
    ((TextView)localObject2).setClickable(true);
    ((TextView)localObject2).setOnClickListener(new o(this));
    this.p = ((WkCheckBox)localView.findViewById(2131821115));
    this.p.b();
    this.q = ((TextView)localView.findViewById(2131821116));
    localButton.setOnClickListener(new p(this, localButton, (ImageView)localObject1));
    localView.findViewById(2131821112).setVisibility(0);
    if (localView != null) {
      this.i.add(localView);
    }
  }
  
  private void d(int paramInt)
  {
    int i2 = this.j.size();
    if (paramInt == i2 - 1)
    {
      this.h.setVisibility(8);
      return;
    }
    this.h.setVisibility(0);
    int i1 = 0;
    label35:
    if (i1 < i2)
    {
      if (i1 != paramInt) {
        break label68;
      }
      ((ImageView)this.j.get(i1)).setImageResource(2130838350);
    }
    for (;;)
    {
      i1++;
      break label35;
      break;
      label68:
      ((ImageView)this.j.get(i1)).setImageResource(2130838349);
    }
  }
  
  private void e()
  {
    Object localObject = (ShareApNewConf)d.a(this.e).a(ShareApNewConf.class);
    boolean bool;
    if (localObject != null)
    {
      bool = ((ShareApNewConf)localObject).j();
      if (!bool) {
        break label43;
      }
      com.lantern.core.t.a(this.e, false);
    }
    for (;;)
    {
      return;
      bool = true;
      break;
      label43:
      localObject = com.lantern.core.t.b(this.e);
      if (localObject != null) {
        com.lantern.core.t.a(this.e, ((Boolean)localObject).booleanValue());
      }
    }
  }
  
  private void f()
  {
    View[] arrayOfView = h();
    for (int i1 = 0; i1 < 3; i1++)
    {
      localView = arrayOfView[i1];
      this.i.add(localView);
    }
    View localView = com.lantern.bindapp.a.b(this.e);
    if (localView != null) {
      this.i.add(localView);
    }
    localView = g();
    if (localView != null) {
      this.i.add(localView);
    }
  }
  
  private View g()
  {
    View localView = this.l.inflate(2130968795, null);
    Button localButton = (Button)localView.findViewById(2131821118);
    this.r = ((WkCheckBox)localView.findViewById(2131821115));
    this.r.b();
    this.s = ((TextView)localView.findViewById(2131821116));
    localButton.setOnClickListener(new t(this));
    return localView;
  }
  
  private View[] h()
  {
    ImageView localImageView1 = new ImageView(this.e);
    localImageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ImageView localImageView2 = new ImageView(this.e);
    localImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
    ImageView localImageView3 = new ImageView(this.e);
    localImageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localImageView1.setImageResource(2130838362);
    localImageView2.setImageResource(2130838363);
    localImageView3.setImageResource(2130838364);
    return new ImageView[] { localImageView1, localImageView2, localImageView3 };
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h.a("onCreate", new Object[0]);
    this.l = LayoutInflater.from(this.e);
    this.n = false;
    this.o = new Handler(new m(this));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968789, paramViewGroup, false);
    this.g = ((ViewPager)paramLayoutInflater.findViewById(2131821101));
    this.h = ((LinearLayout)paramLayoutInflater.findViewById(2131821102));
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    h.a("--onDestroy--", new Object[0]);
    this.n = true;
    if (this.o != null) {
      this.o.removeCallbacksAndMessages(null);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a_(a, 8);
    this.k = com.lantern.core.p.i(this.e);
    this.m = getActivity().getIntent().getIntExtra("upgrade_type", 1);
    this.i = new ArrayList();
    if (this.k) {
      d();
    }
    for (;;)
    {
      c();
      paramView = new a(this.i);
      this.g.setAdapter(paramView);
      this.g.setOnPageChangeListener(new n(this, paramView));
      d(0);
      return;
      if (this.m == 2)
      {
        f();
      }
      else
      {
        paramView = new ImageView(this.e);
        paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.setImageResource(2130838370);
        this.i.add(paramView);
        paramView = com.lantern.bindapp.a.b(this.e);
        if (paramView != null) {
          this.i.add(paramView);
        }
        paramView = g();
        if (paramView != null) {
          this.i.add(paramView);
        }
      }
    }
  }
  
  private static final class a
    extends PagerAdapter
  {
    private ArrayList<View> a;
    
    public a(ArrayList<View> paramArrayList)
    {
      this.a = paramArrayList;
    }
    
    public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {}
    
    public final int getCount()
    {
      return this.a.size();
    }
    
    public final int getItemPosition(Object paramObject)
    {
      return super.getItemPosition(paramObject);
    }
    
    public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      h.a("instantiateItem position:" + paramInt, new Object[0]);
      View localView = (View)this.a.get(paramInt);
      if ((localView != null) && (paramViewGroup != null) && (localView.getParent() == null)) {
        paramViewGroup.addView(localView);
      }
      return localView;
    }
    
    public final boolean isViewFromObject(View paramView, Object paramObject)
    {
      if (paramView == paramObject) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/UserGuideFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */