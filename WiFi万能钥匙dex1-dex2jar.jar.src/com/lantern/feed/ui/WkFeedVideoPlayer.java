package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.app.k.a;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.lantern.core.imageloader.WkImageView;
import com.lantern.feed.R.color;
import com.lantern.feed.R.drawable;
import com.lantern.feed.R.layout;
import com.lantern.feed.R.string;
import com.lantern.feed.a.m;
import com.lantern.feed.a.z;
import com.lantern.feed.a.z.a;
import com.lantern.feed.b.b;
import com.lantern.feed.b.g;
import com.lantern.feed.d.c;
import com.lantern.feed.d.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class WkFeedVideoPlayer
  extends FrameLayout
  implements View.OnClickListener, View.OnTouchListener, SeekBar.OnSeekBarChangeListener, z.a
{
  private int A;
  private Handler B = new Handler(Looper.getMainLooper(), new cf(this));
  private WkImageView a;
  private FrameLayout b;
  private ImageView c;
  private LinearLayout d;
  private TextView e;
  private ProgressBar f;
  private TextView g;
  private TextView h;
  private LinearLayout i;
  private TextView j;
  private TextView k;
  private SeekBar l;
  private ImageView m;
  private ProgressBar n;
  private Context o;
  private ImageView p;
  private int q;
  private g r;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private int v = -1;
  private int w = -1;
  private String x;
  private String y;
  private boolean z = false;
  
  public WkFeedVideoPlayer(Context paramContext)
  {
    super(paramContext);
    this.o = paramContext;
    j();
  }
  
  public WkFeedVideoPlayer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.o = paramContext;
    j();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.q = paramInt2;
    if (!this.u)
    {
      this.l.setProgress(paramInt1);
      this.n.setProgress(paramInt1);
    }
    this.j.setText(c.c(paramInt2));
    this.k.setText(c.c(paramInt3));
  }
  
  private void g(int paramInt)
  {
    if (this.t)
    {
      this.d.setVisibility(paramInt);
      if ((!this.s) && (this.c.getVisibility() != 8)) {
        this.c.setVisibility(8);
      }
    }
    for (;;)
    {
      return;
      if (this.s)
      {
        this.d.setVisibility(paramInt);
        if (this.c.getVisibility() != 0) {
          this.c.setVisibility(0);
        }
      }
      else
      {
        this.d.setVisibility(4);
      }
    }
  }
  
  private void h(int paramInt)
  {
    this.a.setVisibility(paramInt);
    this.h.setVisibility(paramInt);
  }
  
  private void i(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.l.setSecondaryProgress(paramInt);
      this.n.setSecondaryProgress(paramInt);
    }
  }
  
  private void j()
  {
    float f1 = this.o.getResources().getDisplayMetrics().density;
    setBackgroundColor(getResources().getColor(R.color.feed_img_bg));
    this.b = new FrameLayout(this.o);
    this.b.setId(6);
    this.b.setBackgroundColor(getResources().getColor(R.color.black));
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    addView(this.b, (ViewGroup.LayoutParams)localObject);
    this.a = new WkImageView(this.o, R.drawable.feed_video_thumb_bg);
    this.a.setId(2);
    this.a.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.a, (ViewGroup.LayoutParams)localObject);
    this.f = ((ProgressBar)LayoutInflater.from(this.o).inflate(R.layout.feed_video_loading_layout, null));
    this.f.setVisibility(8);
    localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    addView(this.f, (ViewGroup.LayoutParams)localObject);
    this.p = new ImageView(this.o);
    this.p.setId(3);
    this.p.setVisibility(8);
    this.p.setScaleType(ImageView.ScaleType.CENTER);
    this.p.setPadding((int)(16.0F * f1), (int)(16.0F * f1), (int)(16.0F * f1), (int)(16.0F * f1));
    addView(this.p, (ViewGroup.LayoutParams)localObject);
    this.g = new TextView(this.o);
    this.g.setId(4);
    this.g.setText(R.string.feed_video_play_failed1);
    this.g.setTextColor(getResources().getColor(R.color.white));
    this.g.setTextSize(14.0F);
    this.g.setVisibility(8);
    this.g.setGravity(17);
    this.g.setBackgroundColor(getResources().getColor(R.color.black));
    localObject = new FrameLayout.LayoutParams(-1, -1);
    addView(this.g, (ViewGroup.LayoutParams)localObject);
    this.h = new TextView(this.o);
    this.h.setTextSize(10.0F);
    this.h.setTextColor(-1);
    this.h.setGravity(17);
    this.h.setVisibility(8);
    this.h.setBackgroundResource(R.drawable.feed_video_time_bg);
    this.h.setPadding(d.a(this.o, 7.0F), 0, d.a(this.o, 7.0F), 0);
    localObject = new FrameLayout.LayoutParams(-2, d.a(this.o, 20.0F));
    ((FrameLayout.LayoutParams)localObject).gravity = 85;
    ((FrameLayout.LayoutParams)localObject).rightMargin = d.a(this.o, 4.0F);
    ((FrameLayout.LayoutParams)localObject).bottomMargin = d.a(this.o, 4.0F);
    addView(this.h, (ViewGroup.LayoutParams)localObject);
    this.n = ((ProgressBar)LayoutInflater.from(this.o).inflate(R.layout.feed_video_progressbar, null));
    this.n.setVisibility(8);
    localObject = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    addView(this.n, (ViewGroup.LayoutParams)localObject);
    this.i = new LinearLayout(this.o);
    this.i.setId(5);
    this.i.setOrientation(0);
    this.i.setBackgroundColor(-1895825408);
    this.i.setVisibility(8);
    localObject = new FrameLayout.LayoutParams(-1, (int)(36.0F * f1));
    ((FrameLayout.LayoutParams)localObject).gravity = 80;
    addView(this.i, (ViewGroup.LayoutParams)localObject);
    this.j = new TextView(this.o);
    this.j.setIncludeFontPadding(false);
    this.j.setTextSize(15.0F);
    this.j.setTextColor(-1);
    this.j.setMaxLines(1);
    this.j.setText("00:00");
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).leftMargin = ((int)(10.0F * f1));
    this.i.addView(this.j, (ViewGroup.LayoutParams)localObject);
    this.l = ((SeekBar)LayoutInflater.from(this.o).inflate(R.layout.feed_video_seekbar, null));
    this.l.setId(7);
    this.l.setPadding((int)(10.0F * f1), (int)(8.0F * f1), (int)(10.0F * f1), (int)(f1 * 8.0F));
    localObject = new LinearLayout.LayoutParams(0, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    this.i.addView(this.l, (ViewGroup.LayoutParams)localObject);
    this.k = new TextView(this.o);
    this.k.setIncludeFontPadding(false);
    this.k.setTextSize(15.0F);
    this.k.setTextColor(-1);
    this.k.setMaxLines(1);
    this.k.setText("00:00");
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).rightMargin = d.a(this.o, 10.0F);
    this.i.addView(this.k, (ViewGroup.LayoutParams)localObject);
    this.m = new ImageView(this.o);
    this.m.setId(8);
    this.m.setImageResource(R.drawable.feed_video_enlarge);
    this.m.setScaleType(ImageView.ScaleType.CENTER);
    this.m.setPadding(d.a(this.o, 10.0F), 0, d.a(this.o, 10.0F), 0);
    localObject = new LinearLayout.LayoutParams(-2, -1);
    ((LinearLayout.LayoutParams)localObject).leftMargin = d.a(this.o, -10.0F);
    this.i.addView(this.m, (ViewGroup.LayoutParams)localObject);
    this.d = new LinearLayout(this.o);
    this.d.setOrientation(0);
    this.d.setBackgroundResource(R.drawable.feed_video_title_bg);
    this.d.setVisibility(8);
    localObject = new FrameLayout.LayoutParams(-1, d.a(this.o, 91.0F));
    ((FrameLayout.LayoutParams)localObject).gravity = 48;
    addView(this.d, (ViewGroup.LayoutParams)localObject);
    this.c = new ImageView(this.o);
    this.c.setId(1);
    this.c.setImageResource(R.drawable.feed_video_back);
    this.c.setScaleType(ImageView.ScaleType.CENTER);
    this.c.setPadding(d.a(this.o, 15.0F), d.a(this.o, 15.0F), 0, d.a(this.o, 15.0F));
    localObject = new LinearLayout.LayoutParams(-2, -2);
    this.d.addView(this.c, (ViewGroup.LayoutParams)localObject);
    this.e = new TextView(this.o);
    this.e.setIncludeFontPadding(false);
    this.e.setTextSize(16.0F);
    this.e.setTextColor(-1);
    this.e.setMaxLines(2);
    this.e.setGravity(16);
    this.e.setEllipsize(TextUtils.TruncateAt.END);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).leftMargin = d.a(this.o, 15.0F);
    ((LinearLayout.LayoutParams)localObject).topMargin = d.a(this.o, 15.0F);
    ((LinearLayout.LayoutParams)localObject).rightMargin = d.a(this.o, 15.0F);
    this.d.addView(this.e, (ViewGroup.LayoutParams)localObject);
    this.b.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.l.setOnSeekBarChangeListener(this);
    this.i.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.l.setOnTouchListener(this);
  }
  
  private void k()
  {
    h.a("play video", new Object[0]);
    this.u = false;
    if ((z.a().g() != null) && (z.a().g() != this)) {
      z.a().g().a(2);
    }
    z.a().a(this);
    this.v = 0;
    r();
    this.i.setVisibility(4);
    this.d.setVisibility(4);
    a(0, 0, 0);
    i(0);
    h.a("initTextureView", new Object[0]);
    h.a("removeTextureViewAndClearTexture", new Object[0]);
    z.a().k();
    Object localObject1 = z.a().l();
    if ((localObject1 != null) && (((WkFeedTextureView)localObject1).getParent() != null)) {
      ((ViewGroup)((WkFeedTextureView)localObject1).getParent()).removeView((View)localObject1);
    }
    z.a().a(new WkFeedTextureView(this.o));
    e();
    h.a("playingVideo WkFeedMediaManager prepareToPlay", new Object[0]);
    z.a().a(this.r.k());
    this.y = UUID.randomUUID().toString().replace("-", "");
    Object localObject2 = this.r.i(7);
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      if (this.r.c() == 108) {
        localObject1 = String.format(Locale.getDefault(), "&vstat=1&vtime=0", new Object[0]);
      }
    }
    for (;;)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (b)localIterator.next();
          if (!TextUtils.isEmpty(((b)localObject2).a()))
          {
            m.a().onEvent(d.a(((b)localObject2).a() + (String)localObject1, this.r));
            continue;
            if (this.r.c() != 114) {
              break label532;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("&uuid=" + this.y);
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
          }
        }
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("dataType", String.valueOf(this.r.b()));
      ((HashMap)localObject1).put("id", this.r.r());
      ((HashMap)localObject1).put("pageNo", String.valueOf(this.r.o()));
      ((HashMap)localObject1).put("pos", String.valueOf(this.r.p()));
      ((HashMap)localObject1).put("template", String.valueOf(this.r.c()));
      ((HashMap)localObject1).put("fv", "1018");
      if (!TextUtils.isEmpty(this.x)) {
        ((HashMap)localObject1).put("tabId", this.x);
      }
      a.e().onEvent("dvsta", new JSONObject((Map)localObject1).toString());
      return;
      label532:
      localObject1 = "";
    }
  }
  
  private void l()
  {
    h.a("resume video", new Object[0]);
    f(2);
    Object localObject1 = z.a().l();
    if (localObject1 != null) {
      ((WkFeedTextureView)localObject1).setKeepScreenOn(true);
    }
    z.a().c();
    if (this.r.c() == 108)
    {
      Object localObject2 = this.r.i(7);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = String.format(Locale.getDefault(), "&vstat=1&vtime=0", new Object[0]);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          b localb = (b)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(localb.a())) {
            m.a().onEvent(d.a(localb.a() + (String)localObject1, this.r));
          }
        }
      }
    }
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("dataType", String.valueOf(this.r.b()));
    ((HashMap)localObject1).put("id", this.r.r());
    ((HashMap)localObject1).put("pageNo", String.valueOf(this.r.o()));
    ((HashMap)localObject1).put("pos", String.valueOf(this.r.p()));
    ((HashMap)localObject1).put("template", String.valueOf(this.r.c()));
    ((HashMap)localObject1).put("fv", "1018");
    if (!TextUtils.isEmpty(this.x)) {
      ((HashMap)localObject1).put("tabId", this.x);
    }
    a.e().onEvent("dvrep", new JSONObject((Map)localObject1).toString());
  }
  
  private void m()
  {
    h.a("pause video", new Object[0]);
    f(1);
    Object localObject1 = z.a().l();
    if (localObject1 != null) {
      ((WkFeedTextureView)localObject1).setKeepScreenOn(false);
    }
    h.a("pauseVideo meidiaplayer pause", new Object[0]);
    z.a().d();
    if (this.r.c() == 108)
    {
      Object localObject2 = this.r.i(8);
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject1 = String.format(Locale.getDefault(), "&vstat=2&vtime=%d", new Object[] { Integer.valueOf(this.q) });
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          b localb = (b)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(localb.a())) {
            m.a().onEvent(d.a(localb.a() + (String)localObject1, this.r));
          }
        }
      }
    }
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("dataType", String.valueOf(this.r.b()));
    ((HashMap)localObject1).put("id", this.r.r());
    ((HashMap)localObject1).put("pageNo", String.valueOf(this.r.o()));
    ((HashMap)localObject1).put("pos", String.valueOf(this.r.p()));
    ((HashMap)localObject1).put("template", String.valueOf(this.r.c()));
    ((HashMap)localObject1).put("fv", "1018");
    if (!TextUtils.isEmpty(this.x)) {
      ((HashMap)localObject1).put("tabId", this.x);
    }
    a.e().onEvent("dvpau", new JSONObject((Map)localObject1).toString());
  }
  
  private void n()
  {
    h.a("startDismissControlViewTimer", new Object[0]);
    this.B.removeMessages(1);
    this.B.sendEmptyMessageDelayed(1, 3000L);
  }
  
  private void o()
  {
    h.a("cancelDismissControlViewTimer", new Object[0]);
    this.B.removeMessages(1);
  }
  
  private void p()
  {
    h.a("onClickUiToggle", new Object[0]);
    if (this.v == 0) {
      if (this.i.getVisibility() == 0)
      {
        h.a("changeUiToClearUiPrepareing", new Object[0]);
        g(4);
        this.i.setVisibility(4);
        this.p.setVisibility(4);
        h(4);
        this.n.setVisibility(4);
      }
    }
    for (;;)
    {
      return;
      r();
      continue;
      if (this.v == 2)
      {
        if (this.i.getVisibility() == 0)
        {
          h.a("changeUiToClearUiPlaying", new Object[0]);
          u();
          this.n.setVisibility(0);
        }
        else
        {
          s();
        }
      }
      else if (this.v == 1) {
        if (this.i.getVisibility() == 0)
        {
          h.a("changeUiToClearUiPause", new Object[0]);
          u();
          this.n.setVisibility(0);
        }
        else
        {
          t();
        }
      }
    }
  }
  
  private void q()
  {
    h.a("changeUiToNormal", new Object[0]);
    setBackgroundColor(getResources().getColor(R.color.feed_img_bg));
    g(0);
    this.i.setVisibility(4);
    this.p.setVisibility(0);
    this.f.setVisibility(4);
    h(0);
    this.n.setVisibility(4);
    x();
  }
  
  private void r()
  {
    h.a("changeUiToShowUiPrepareing", new Object[0]);
    g(0);
    setBackgroundColor(getResources().getColor(R.color.black));
    this.i.setVisibility(0);
    this.p.setVisibility(4);
    this.g.setVisibility(8);
    this.f.setVisibility(0);
    h(4);
    this.n.setVisibility(4);
  }
  
  private void s()
  {
    h.a("changeUiToShowUiPlaying", new Object[0]);
    g(0);
    this.i.setVisibility(0);
    this.p.setVisibility(0);
    this.f.setVisibility(4);
    h(4);
    this.n.setVisibility(4);
    x();
  }
  
  private void t()
  {
    h.a("changeUiToShowUiPause", new Object[0]);
    g(0);
    this.i.setVisibility(0);
    this.p.setVisibility(0);
    this.f.setVisibility(4);
    h(4);
    this.n.setVisibility(4);
    x();
  }
  
  private void u()
  {
    h.a("changeUiToClearUi", new Object[0]);
    g(4);
    this.i.setVisibility(4);
    this.p.setVisibility(4);
    this.f.setVisibility(4);
    h(4);
    this.n.setVisibility(4);
  }
  
  private void v()
  {
    h.a("startProgressTimer", new Object[0]);
    this.B.removeMessages(2);
    this.B.sendEmptyMessageDelayed(2, 300L);
  }
  
  private void w()
  {
    h.a("cancelProgressTimer", new Object[0]);
    this.B.removeMessages(2);
  }
  
  private void x()
  {
    h.a("updateStartImage", new Object[0]);
    this.p.setVisibility(0);
    this.g.setVisibility(8);
    if (this.v == 2) {
      this.p.setImageResource(R.drawable.feed_video_pause);
    }
    for (;;)
    {
      return;
      if (this.v == 5)
      {
        this.p.setVisibility(8);
        int i1 = this.A % 3;
        if (i1 == 0) {
          this.g.setText(R.string.feed_video_play_failed1);
        }
        for (;;)
        {
          this.g.setVisibility(0);
          break;
          if (i1 == 1) {
            this.g.setText(R.string.feed_video_play_failed2);
          } else {
            this.g.setText(R.string.feed_video_play_failed3);
          }
        }
      }
      this.p.setImageResource(R.drawable.feed_video_play);
    }
  }
  
  /* Error */
  private void y()
  {
    // Byte code:
    //   0: invokestatic 421	com/lantern/feed/a/z:a	()Lcom/lantern/feed/a/z;
    //   3: invokevirtual 711	com/lantern/feed/a/z:e	()I
    //   6: istore_2
    //   7: invokestatic 421	com/lantern/feed/a/z:a	()Lcom/lantern/feed/a/z;
    //   10: invokevirtual 713	com/lantern/feed/a/z:f	()I
    //   13: istore_1
    //   14: iload_2
    //   15: iload_1
    //   16: if_icmpgt +22 -> 38
    //   19: iload_1
    //   20: ifne +39 -> 59
    //   23: iconst_1
    //   24: istore_3
    //   25: aload_0
    //   26: iload_2
    //   27: bipush 100
    //   29: imul
    //   30: iload_3
    //   31: idiv
    //   32: iload_2
    //   33: iload_1
    //   34: invokespecial 433	com/lantern/feed/ui/WkFeedVideoPlayer:a	(III)V
    //   37: return
    //   38: iload_1
    //   39: istore_2
    //   40: goto -21 -> 19
    //   43: astore 4
    //   45: iconst_0
    //   46: istore_1
    //   47: aload 4
    //   49: invokevirtual 716	java/lang/Exception:printStackTrace	()V
    //   52: iload_1
    //   53: istore_2
    //   54: iconst_0
    //   55: istore_1
    //   56: goto -37 -> 19
    //   59: iload_1
    //   60: istore_3
    //   61: goto -36 -> 25
    //   64: astore 4
    //   66: iload_2
    //   67: istore_1
    //   68: goto -21 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	WkFeedVideoPlayer
    //   13	55	1	i1	int
    //   6	61	2	i2	int
    //   24	37	3	i3	int
    //   43	5	4	localException1	Exception
    //   64	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	7	43	java/lang/Exception
    //   7	14	64	java/lang/Exception
  }
  
  public final void a()
  {
    h.a("onPrepared", new Object[0]);
    if (this.v != 0) {}
    for (;;)
    {
      return;
      this.v = 2;
      s();
      this.p.setVisibility(4);
      n();
      v();
      HashMap localHashMap = new HashMap();
      localHashMap.put("dataType", String.valueOf(this.r.b()));
      localHashMap.put("id", this.r.r());
      localHashMap.put("pageNo", String.valueOf(this.r.o()));
      localHashMap.put("pos", String.valueOf(this.r.p()));
      localHashMap.put("template", String.valueOf(this.r.c()));
      localHashMap.put("fv", "1018");
      if (!TextUtils.isEmpty(this.x)) {
        localHashMap.put("tabId", this.x);
      }
      a.e().onEvent("dvplay1", new JSONObject(localHashMap).toString());
    }
  }
  
  public final void a(int paramInt)
  {
    h.a("onCompletion", new Object[0]);
    if ((this.v == 5) && (paramInt == 0)) {}
    for (;;)
    {
      return;
      if (e.c(this.o)) {
        break;
      }
      f(5);
    }
    f(4);
    w();
    if ((getContext() instanceof WkFeedVideoFullScreenActivity)) {
      ((WkFeedVideoFullScreenActivity)getContext()).finish();
    }
    if ((this.s) && (z.a().h() != null)) {
      z.a().h().a(1);
    }
    Object localObject1;
    Object localObject2;
    if ((this.s) || (paramInt != 1))
    {
      localObject1 = z.a().l();
      if (localObject1 != null) {
        ((WkFeedTextureView)localObject1).setKeepScreenOn(false);
      }
      localObject2 = this.r.i(8);
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        if (this.r.c() == 108) {
          localObject1 = String.format(Locale.getDefault(), "&vstat=3&vtime=%d", new Object[] { Integer.valueOf(this.q) });
        }
      }
    }
    for (;;)
    {
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          b localb = (b)((Iterator)localObject2).next();
          if (!TextUtils.isEmpty(localb.a()))
          {
            m.a().onEvent(d.a(localb.a() + (String)localObject1, this.r));
            continue;
            if (this.r.c() != 114) {
              break label523;
            }
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("&uuid=" + this.y);
            ((StringBuilder)localObject1).append("&vtime=" + this.q / 1000);
            localObject1 = ((StringBuilder)localObject1).toString();
            break;
          }
        }
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("dataType", String.valueOf(this.r.b()));
      ((HashMap)localObject1).put("id", this.r.r());
      ((HashMap)localObject1).put("pageNo", String.valueOf(this.r.o()));
      ((HashMap)localObject1).put("pos", String.valueOf(this.r.p()));
      ((HashMap)localObject1).put("template", String.valueOf(this.r.c()));
      ((HashMap)localObject1).put("fv", "1018");
      ((HashMap)localObject1).put("time", String.valueOf(this.q));
      if (!TextUtils.isEmpty(this.x)) {
        ((HashMap)localObject1).put("tabId", this.x);
      }
      a.e().onEvent("dvstp", new JSONObject((Map)localObject1).toString());
      z.a().a(null);
      z.a().b(null);
      break;
      label523:
      localObject1 = "";
    }
  }
  
  public final void a(g paramg, String paramString)
  {
    h.a("setDataForFullscreen", new Object[0]);
    this.r = paramg;
    this.x = paramString;
    this.t = true;
    this.s = true;
    this.m.setImageResource(R.drawable.feed_video_shrink);
    this.c.setVisibility(0);
    this.e.setText(this.r.g());
    q();
    y();
  }
  
  public final void a(g paramg, boolean paramBoolean, String paramString)
  {
    h.a("setData title:" + paramg.g() + " videoSrc:" + paramg.k(), new Object[0]);
    this.t = paramBoolean;
    this.r = paramg;
    this.x = paramString;
    this.s = false;
    this.z = false;
    this.A = 0;
    this.v = 4;
    this.m.setImageResource(R.drawable.feed_video_enlarge);
    this.c.setVisibility(8);
    this.e.setText(this.r.g());
    if (this.r.j() > 0)
    {
      this.h.setVisibility(0);
      this.h.setText(c.c(this.r.j()));
    }
    for (;;)
    {
      q();
      if (z.a().g() == this)
      {
        h.a("setData meidiaplayer release", new Object[0]);
        z.a().b();
      }
      return;
      this.h.setVisibility(8);
    }
  }
  
  public final void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.a(paramString, getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  public final void b()
  {
    h.a("onSeekComplete", new Object[0]);
    if ((this.w != -1) && (this.w != 3) && (this.w != 6))
    {
      f(this.w);
      this.w = -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("dataType", String.valueOf(this.r.b()));
    localHashMap.put("id", this.r.r());
    localHashMap.put("pageNo", String.valueOf(this.r.o()));
    localHashMap.put("pos", String.valueOf(this.r.p()));
    localHashMap.put("template", String.valueOf(this.r.c()));
    localHashMap.put("fv", "1018");
    if (!TextUtils.isEmpty(this.x)) {
      localHashMap.put("tabId", this.x);
    }
    a.e().onEvent("dvdrag", new JSONObject(localHashMap).toString());
  }
  
  public final void b(int paramInt)
  {
    h.a("onBufferingUpdate", new Object[0]);
    if ((this.v != 4) && (this.v != 0)) {
      i(paramInt);
    }
  }
  
  public final void c()
  {
    if (z.a().l() != null) {
      z.a().m();
    }
  }
  
  public final void c(int paramInt)
  {
    h.a("onError what:" + paramInt, new Object[0]);
    if ((paramInt != -38) && (this.v != 5))
    {
      this.A += 1;
      f(5);
      Object localObject1 = z.a().l();
      if (localObject1 != null) {
        ((WkFeedTextureView)localObject1).setKeepScreenOn(false);
      }
      if (this.r.c() == 114)
      {
        Object localObject2 = this.r.i(8);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("&uuid=" + this.y);
          ((StringBuilder)localObject1).append("&vtime=" + this.q / 1000);
          ((StringBuilder)localObject1).append("&status=playerror");
          localObject1 = ((StringBuilder)localObject1).toString();
          Iterator localIterator = ((List)localObject2).iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (b)localIterator.next();
            if (!TextUtils.isEmpty(((b)localObject2).a())) {
              m.a().onEvent(d.a(((b)localObject2).a() + (String)localObject1, this.r));
            }
          }
        }
      }
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("dataType", String.valueOf(this.r.b()));
      ((HashMap)localObject1).put("id", this.r.r());
      ((HashMap)localObject1).put("pageNo", String.valueOf(this.r.o()));
      ((HashMap)localObject1).put("pos", String.valueOf(this.r.p()));
      ((HashMap)localObject1).put("template", String.valueOf(this.r.c()));
      ((HashMap)localObject1).put("fv", "1018");
      ((HashMap)localObject1).put("errCd", String.valueOf(paramInt));
      if (!TextUtils.isEmpty(this.x)) {
        ((HashMap)localObject1).put("tabId", this.x);
      }
      a.e().onEvent("dvplay0", new JSONObject((Map)localObject1).toString());
    }
  }
  
  public final void d()
  {
    h.a("onQuitFullscreen", new Object[0]);
    if (z.a().g() == this)
    {
      this.v = z.a().i();
      this.w = z.a().j();
      h.a("onQuitFullscreen addTextureView mCurrentState:" + this.v, new Object[0]);
      f(this.v);
      e();
    }
    for (;;)
    {
      return;
      h.a("onQuitFullscreen releaseAllVideos", new Object[0]);
      g();
    }
  }
  
  public final void d(int paramInt)
  {
    if (paramInt == 701)
    {
      if (this.v == 2)
      {
        this.w = this.v;
        f(3);
      }
      h.a("MEDIA_INFO_BUFFERING_START", new Object[0]);
    }
    for (;;)
    {
      return;
      if (paramInt == 702)
      {
        if ((this.w != -1) && (this.w != 3) && (this.w != 6))
        {
          f(this.w);
          this.w = -1;
        }
        h.a("MEDIA_INFO_BUFFERING_END", new Object[0]);
      }
    }
  }
  
  public final void e()
  {
    h.a("addTextureView", new Object[0]);
    h.a("removeTextureView", new Object[0]);
    Object localObject = z.a().l();
    if ((localObject != null) && (((WkFeedTextureView)localObject).getParent() != null)) {
      ((ViewGroup)((WkFeedTextureView)localObject).getParent()).removeView((View)localObject);
    }
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.b.addView(z.a().l(), (ViewGroup.LayoutParams)localObject);
  }
  
  public final void e(int paramInt)
  {
    this.w = paramInt;
  }
  
  public final void f()
  {
    h.a("quitFullScreen", new Object[0]);
    WkFeedVideoFullScreenActivity.c = true;
    z.a().b(this.v);
    z.a().c(this.w);
    w();
    o();
    if ((getContext() instanceof WkFeedVideoFullScreenActivity)) {
      ((WkFeedVideoFullScreenActivity)getContext()).finish();
    }
    if (z.a().h() != null)
    {
      z.a().a(z.a().h());
      z.a().g().d();
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("dataType", String.valueOf(this.r.b()));
    localHashMap.put("id", this.r.r());
    localHashMap.put("pageNo", String.valueOf(this.r.o()));
    localHashMap.put("pos", String.valueOf(this.r.p()));
    localHashMap.put("template", String.valueOf(this.r.c()));
    localHashMap.put("fv", "1018");
    if (!TextUtils.isEmpty(this.x)) {
      localHashMap.put("tabId", this.x);
    }
    a.e().onEvent("dvfscr0", new JSONObject(localHashMap).toString());
  }
  
  public final void f(int paramInt)
  {
    h.a("setState state:" + paramInt, new Object[0]);
    this.v = paramInt;
    if (this.v == 0)
    {
      r();
      a(0, 0, 0);
      i(0);
    }
    for (;;)
    {
      return;
      if (this.v == 2)
      {
        s();
        n();
        v();
      }
      else if (this.v == 1)
      {
        t();
        o();
      }
      else if (this.v == 4)
      {
        q();
        h.a("setState startDismissControlViewTimer", new Object[0]);
        o();
        w();
      }
      else if (this.v == 5)
      {
        h.a("CURRENT_STATE_ERROR meidiaplayer release", new Object[0]);
        z.a().b();
        h.a("changeUiToError", new Object[0]);
        g(4);
        this.i.setVisibility(4);
        this.p.setVisibility(0);
        this.f.setVisibility(4);
        h(4);
        this.n.setVisibility(4);
        x();
        o();
        w();
      }
      else if (this.v == 3)
      {
        o();
        h.a("changeUiToBuffering", new Object[0]);
        g(4);
        this.i.setVisibility(4);
        this.p.setVisibility(4);
        this.f.setVisibility(0);
        h(4);
        this.n.setVisibility(4);
      }
      else if (this.v == 6)
      {
        o();
        h.a("changeUiToSeeking", new Object[0]);
        g(4);
        this.p.setVisibility(4);
        this.f.setVisibility(0);
        h(4);
        this.n.setVisibility(4);
      }
    }
  }
  
  public final void g()
  {
    h.a("releaseAllVideos", new Object[0]);
    h.a("releaseAllVideos meidiaplayer release", new Object[0]);
    z.a().b();
    if (z.a().g() != null) {
      z.a().g().a(2);
    }
    w();
  }
  
  public final void h()
  {
    h.a("onMovedToScrapHeap", new Object[0]);
    this.a.setImageDrawable(null);
    if (((this.v == 2) || (this.v == 0) || (this.v == 1)) && (z.a().g() == this))
    {
      h.a("onMovedToScrapHeap releaseAllVideos", new Object[0]);
      g();
    }
  }
  
  public final void i()
  {
    h.a("onPause", new Object[0]);
    if (((this.v == 2) || (this.v == 0) || (this.v == 1)) && (z.a().g() == this))
    {
      h.a("onPause releaseAllVideos", new Object[0]);
      g();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 == 3) || (i1 == 2)) {
      if (TextUtils.isEmpty(this.r.k())) {
        Toast.makeText(getContext(), R.string.feed_video_play_failed1, 0).show();
      }
    }
    for (;;)
    {
      return;
      if ((i1 == 2) && (this.v != 4) && (this.w != 3) && (this.w != 6))
      {
        p();
      }
      else
      {
        h.a("mCurrentState " + this.v, new Object[0]);
        if ((this.v == 4) || (this.v == 5))
        {
          if (e.b(getContext()))
          {
            paramView = new k.a(this.o);
            paramView.a(R.string.feed_video_play_title);
            paramView.b(R.string.feed_video_play_msg);
            paramView.a(R.string.feed_video_play_continue, new cg(this));
            paramView.b(R.string.feed_video_play_cancel, new ch(this));
            paramView.c();
            paramView.d();
          }
          else
          {
            k();
          }
        }
        else if (this.v == 2) {
          m();
        } else if (this.v == 1) {
          if ((e.b(getContext())) && (!this.z))
          {
            paramView = new k.a(this.o);
            paramView.a(R.string.feed_video_play_title);
            paramView.b(R.string.feed_video_play_msg);
            paramView.a(R.string.feed_video_play_continue, new ci(this));
            paramView.b(R.string.feed_video_play_cancel, new cj(this));
            paramView.c();
            paramView.d();
          }
          else
          {
            l();
            continue;
            if (i1 == 8)
            {
              if ((this.v != 3) && (this.v != 6)) {
                if (this.s)
                {
                  f();
                }
                else
                {
                  h.a("ID_FULLSCREEN toFullScreen", new Object[0]);
                  z.a().b(this);
                  z.a().a(null);
                  w();
                  o();
                  WkFeedVideoFullScreenActivity.a(getContext(), this.v, this.w, this.r, this.x);
                  paramView = new HashMap();
                  paramView.put("dataType", String.valueOf(this.r.b()));
                  paramView.put("id", this.r.r());
                  paramView.put("pageNo", String.valueOf(this.r.o()));
                  paramView.put("pos", String.valueOf(this.r.p()));
                  paramView.put("template", String.valueOf(this.r.c()));
                  paramView.put("fv", "1018");
                  if (!TextUtils.isEmpty(this.x)) {
                    paramView.put("tabId", this.x);
                  }
                  a.e().onEvent("dvfscr1", new JSONObject(paramView).toString());
                }
              }
            }
            else if (i1 == 6)
            {
              if ((this.v != 0) && (this.v != 3) && (this.v != 6)) {
                if (this.v == 5)
                {
                  this.p.performClick();
                }
                else
                {
                  p();
                  n();
                }
              }
            }
            else if (i1 == 1) {
              f();
            }
          }
        }
      }
    }
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean) {}
  
  public void onStartTrackingTouch(SeekBar paramSeekBar)
  {
    h.a("onStartTrackingTouch", new Object[0]);
    o();
    w();
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    h.a("onStopTrackingTouch", new Object[0]);
    if (this.v != 1) {
      n();
    }
    v();
    if ((this.v == 2) || (this.v == 1))
    {
      int i1 = paramSeekBar.getProgress() * z.a().f() / 100;
      z.a().a(i1);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      this.u = true;
      o();
      continue;
      w();
      continue;
      this.u = false;
      if (this.v == 2)
      {
        n();
        v();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedVideoPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */