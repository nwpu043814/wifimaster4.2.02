package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.lantern.core.c;
import com.lantern.feed.R.color;
import com.lantern.feed.R.id;
import com.lantern.feed.R.layout;
import com.lantern.feed.b.o;
import com.lantern.feed.b.q;
import com.lantern.feed.c.a;
import com.lantern.feed.d.d;

public final class bx
  extends FrameLayout
{
  private o a;
  private q b;
  private boolean c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private View g;
  
  public bx(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, R.layout.feed_tab_item, this);
    this.d = ((TextView)findViewById(R.id.tab_title));
    this.e = ((TextView)findViewById(R.id.tab_reddot_count));
    this.f = ((ImageView)findViewById(R.id.tab_reddot_img));
    this.g = findViewById(R.id.tab_reddot);
  }
  
  public final o a()
  {
    return this.a;
  }
  
  public final void a(o paramo)
  {
    if (paramo == null) {}
    for (;;)
    {
      return;
      this.a = paramo;
      this.d.setText(d.d(this.a.b()), TextView.BufferType.SPANNABLE);
      if (!TextUtils.isEmpty(this.a.a()))
      {
        paramo = a.a("reddot", paramo.a());
        if (!TextUtils.isEmpty(paramo))
        {
          q localq = a.a(paramo);
          if (localq != null)
          {
            paramo = Message.obtain();
            paramo.what = 128402;
            paramo.obj = localq;
            c.dispatch(paramo);
          }
        }
        else
        {
          a(false, null);
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean, q paramq)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      bool = paramBoolean;
      if (paramq == null) {
        bool = false;
      }
    }
    this.c = bool;
    this.b = paramq;
    if (!this.c)
    {
      if (this.e.getVisibility() != 8) {
        this.e.setVisibility(8);
      }
      if (this.f.getVisibility() != 8) {
        this.f.setVisibility(8);
      }
      if (this.g.getVisibility() != 8) {
        this.g.setVisibility(8);
      }
    }
    for (;;)
    {
      return;
      if (this.b.b() > 0)
      {
        if (this.g.getVisibility() != 8) {
          this.g.setVisibility(8);
        }
        if (this.b.b() >= 100)
        {
          if (this.e.getVisibility() != 8) {
            this.e.setVisibility(8);
          }
          if (this.f.getVisibility() != 0) {
            this.f.setVisibility(0);
          }
        }
        else
        {
          if (this.f.getVisibility() != 8) {
            this.f.setVisibility(8);
          }
          if (this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
          }
          this.e.setText(String.valueOf(this.b.b()));
        }
      }
      else
      {
        if (this.e.getVisibility() != 8) {
          this.e.setVisibility(8);
        }
        if (this.g.getVisibility() != 0) {
          this.g.setVisibility(0);
        }
      }
    }
  }
  
  public final q b()
  {
    return this.b;
  }
  
  public final void c()
  {
    a(false, null);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getMeasuredWidth() - this.d.getMeasuredWidth() >> 1;
    paramInt1 = getMeasuredHeight() - this.d.getMeasuredHeight() >> 1;
    this.d.layout(paramInt2, paramInt1, this.d.getMeasuredWidth() + paramInt2, this.d.getMeasuredHeight() + paramInt1);
    if (this.c)
    {
      paramInt2 = this.d.getRight();
      paramInt1 = this.d.getTop();
      if (this.e.getVisibility() != 0) {
        break label142;
      }
      paramInt4 = this.e.getMeasuredWidth();
      paramInt3 = this.e.getMeasuredHeight();
      this.e.layout(paramInt2 - (paramInt4 >> 1), paramInt1 - paramInt3 / 3, paramInt2 + (paramInt4 >> 1), paramInt1 + paramInt3 * 2 / 3);
    }
    for (;;)
    {
      return;
      label142:
      if (this.f.getVisibility() == 0)
      {
        paramInt4 = this.f.getMeasuredWidth();
        paramInt3 = this.f.getMeasuredHeight();
        this.f.layout(paramInt2 - (paramInt4 >> 1), paramInt1 - paramInt3 / 3, paramInt2 + (paramInt4 >> 1), paramInt1 + paramInt3 * 2 / 3);
      }
      else if (this.g.getVisibility() == 0)
      {
        paramInt4 = this.g.getMeasuredWidth();
        paramInt3 = this.g.getMeasuredHeight();
        this.g.layout(paramInt2 - (paramInt4 >> 1) + d.a(getContext(), 2.0F), paramInt1 - paramInt3 / 3, paramInt2 + (paramInt4 >> 1) + d.a(getContext(), 2.0F), paramInt1 + paramInt3 * 2 / 3);
      }
    }
  }
  
  public final void setSelected(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.d.setTextColor(getResources().getColor(R.color.feed_tab_text_select));
    }
    for (;;)
    {
      return;
      this.d.setTextColor(getResources().getColor(R.color.feed_tab_text));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */