package com.lantern.feed.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.lantern.feed.R.id;
import com.lantern.feed.R.layout;
import com.lantern.feed.R.style;
import com.lantern.feed.a.m;
import com.lantern.feed.b.b;
import com.lantern.feed.b.k;
import java.util.Iterator;
import java.util.List;

public final class bi
  extends Dialog
{
  private Context a;
  private FrameLayout b;
  private TextView c;
  private ImageView d;
  private ImageView e;
  private CountDownTimer f;
  private k g;
  
  public bi(Context paramContext)
  {
    super(paramContext, R.style.WkFeedFullScreenDialog);
    this.a = paramContext;
  }
  
  public final void a(k paramk)
  {
    h.a("setPopData", new Object[0]);
    this.g = paramk;
    show();
    int j = this.a.getResources().getDisplayMetrics().widthPixels;
    int i = this.a.getResources().getDisplayMetrics().heightPixels;
    int m = this.g.g();
    int n = this.g.c();
    int k = j * 80 / 100;
    j = i * 80 / 100;
    i = j;
    if (m > 0)
    {
      i = j;
      if (n > 0) {
        i = n * k / m;
      }
    }
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(k, i);
    localLayoutParams.gravity = 17;
    this.b.setLayoutParams(localLayoutParams);
    this.d.setImageBitmap(this.g.h());
    if (this.g.a()) {
      if (this.e.getVisibility() != 0) {
        this.e.setVisibility(0);
      }
    }
    label290:
    for (;;)
    {
      if (paramk.b() > 0L)
      {
        if (this.c.getVisibility() != 0) {
          this.c.setVisibility(0);
        }
        this.f = new bj(this, paramk.b() * 1000L);
        this.f.start();
      }
      for (;;)
      {
        return;
        if (this.e.getVisibility() == 8) {
          break label290;
        }
        this.e.setVisibility(8);
        break;
        if (this.f != null) {
          this.f.cancel();
        }
        if (this.c.getVisibility() != 8) {
          this.c.setVisibility(8);
        }
      }
    }
  }
  
  public final void dismiss()
  {
    super.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setCancelable(false);
    setContentView(R.layout.feed_popad_window);
    this.b = ((FrameLayout)findViewById(R.id.pop_content));
    this.d = ((ImageView)findViewById(R.id.pop_image));
    this.d.setOnClickListener(new bk(this));
    this.c = ((TextView)findViewById(R.id.pop_count));
    this.e = ((ImageView)findViewById(R.id.pop_close));
    this.e.setOnClickListener(new bl(this));
  }
  
  public final void show()
  {
    super.show();
    getWindow().setWindowAnimations(R.style.dialogWindowNoAnim);
    a.e().onEvent("nfwshow_ad", String.valueOf(this.g.i()));
    Object localObject = this.g.a(2);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        m.a().onEvent(localb.a());
      }
    }
    m.a().r();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */