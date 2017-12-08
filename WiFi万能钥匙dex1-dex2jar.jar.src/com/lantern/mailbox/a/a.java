package com.lantern.mailbox.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantern.mailbox.R.color;
import com.lantern.mailbox.R.dimen;
import com.lantern.mailbox.R.drawable;
import com.lantern.mailbox.R.id;
import com.lantern.mailbox.R.layout;
import com.lantern.mailbox.R.string;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class a
  extends BaseAdapter
{
  private List<com.lantern.mailbox.d.a> a = new ArrayList();
  private Context b;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private SpannableStringBuilder a(com.lantern.mailbox.d.a parama, int paramInt)
  {
    Object localObject = parama.r();
    if (parama.d() > 3) {
      localObject = String.format(this.b.getString(R.string.mailbox_names), new Object[] { parama.r(), Integer.valueOf(parama.d()) });
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append((CharSequence)localObject);
    localSpannableStringBuilder.append(" ");
    localSpannableStringBuilder.append(new SpannableString(parama.b()));
    localObject = new SpannableString(parama.k());
    ((SpannableString)localObject).setSpan(new ForegroundColorSpan(paramInt), 0, ((SpannableString)localObject).length(), 33);
    ((SpannableString)localObject).setSpan(new AbsoluteSizeSpan(this.b.getResources().getDimensionPixelSize(R.dimen.mailbox_text_size_16)), 0, ((SpannableString)localObject).length(), 33);
    if (("2".equals(parama.o())) || ("1".equals(parama.o()))) {
      localSpannableStringBuilder.append("\n");
    }
    for (;;)
    {
      localSpannableStringBuilder.append((CharSequence)localObject);
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(new SpannableString(parama.c()));
      return localSpannableStringBuilder;
      localSpannableStringBuilder.append(" ");
    }
  }
  
  private com.lantern.mailbox.d.a a(int paramInt)
  {
    return (com.lantern.mailbox.d.a)this.a.get(paramInt);
  }
  
  private String a(long paramLong)
  {
    paramLong -= b(paramLong);
    String str;
    if (paramLong < 18000000L) {
      str = this.b.getString(R.string.mailbox_morning);
    }
    for (;;)
    {
      return str;
      if ((paramLong >= 18000000L) && (paramLong < 43200000L)) {
        str = this.b.getString(R.string.mailbox_noon);
      } else if ((paramLong >= 43200000L) && (paramLong < 86400000L)) {
        str = this.b.getString(R.string.mailbox_afternoon);
      } else {
        str = "";
      }
    }
  }
  
  private void a(com.lantern.mailbox.d.a parama, ImageView paramImageView)
  {
    paramImageView.setImageBitmap(null);
    int j = parama.d();
    Object localObject1 = parama.n().split(",");
    int i;
    Object localObject2;
    if (localObject1.length != j)
    {
      i = j;
      if (j > 3) {
        i = 3;
      }
      localObject2 = new String[i];
      switch (localObject1.length)
      {
      default: 
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      int k = localObject1.length;
      ArrayList localArrayList = new ArrayList();
      Bitmap localBitmap = BitmapFactory.decodeResource(this.b.getResources(), R.drawable.mailbox_default);
      j = localObject1.length;
      i = 0;
      label116:
      if (i < j)
      {
        CharSequence localCharSequence = localObject1[i];
        if (TextUtils.isEmpty(localCharSequence))
        {
          localArrayList.add(localBitmap);
          if (localArrayList.size() == k) {
            b(parama, paramImageView, localArrayList);
          }
        }
        for (;;)
        {
          i++;
          break label116;
          localObject2[0] = localObject1[0];
          break;
          localObject2[0] = localObject1[0];
          localObject2[1] = localObject1[1];
          break;
          localObject2[0] = localObject1[0];
          localObject2[1] = localObject1[1];
          localObject2[2] = localObject1[2];
          break;
          localObject2 = new ImageView(this.b);
          com.lantern.core.imageloader.c.a(this.b, localCharSequence, (ImageView)localObject2, new c(this, (ImageView)localObject2, localArrayList, localBitmap, k, parama, paramImageView), null);
        }
      }
      return;
    }
  }
  
  private static long b(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  private static void b(com.lantern.mailbox.d.a parama, ImageView paramImageView, List<Bitmap> paramList)
  {
    switch (paramList.size())
    {
    }
    for (;;)
    {
      return;
      Bitmap localBitmap2 = (Bitmap)paramList.get(0);
      int i = localBitmap2.getWidth();
      int j = localBitmap2.getHeight();
      Bitmap localBitmap1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Object localObject1 = new Paint();
      ((Paint)localObject1).setAntiAlias(true);
      paramList = new Canvas(localBitmap1);
      paramList.drawCircle(i / 2, j / 2, i / 2, (Paint)localObject1);
      ((Paint)localObject1).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      paramList.drawBitmap(localBitmap2, 0.0F, 0.0F, (Paint)localObject1);
      paramImageView.setImageBitmap(localBitmap1);
      com.lantern.mailbox.c.a.a().a(parama, localBitmap1);
      continue;
      paramList = com.lantern.mailbox.e.b.a((Bitmap)paramList.get(0), (Bitmap)paramList.get(1), 1.0F);
      paramImageView.setImageBitmap(paramList);
      com.lantern.mailbox.c.a.a().a(parama, paramList);
      continue;
      localBitmap2 = (Bitmap)paramList.get(0);
      Bitmap localBitmap3 = (Bitmap)paramList.get(1);
      Object localObject2 = (Bitmap)paramList.get(2);
      i = localBitmap2.getWidth();
      int n = localBitmap2.getHeight();
      localBitmap1 = Bitmap.createBitmap(i, n, Bitmap.Config.ARGB_8888);
      paramList = new Paint();
      paramList.setAntiAlias(true);
      paramList.setColor(com.lantern.core.c.getAppContext().getResources().getColor(R.color.mailbox_avatar));
      paramList.setStrokeWidth(2.0F);
      localObject1 = new Canvas(localBitmap1);
      ((Canvas)localObject1).drawBitmap(com.lantern.mailbox.e.b.a(localBitmap2, localBitmap3, 0.78866667F), 0.0F, 0.0F, paramList);
      ((Canvas)localObject1).drawArc(new RectF(0.0F, 0.0F, i, n), 30.0F, 120.0F, true, paramList);
      j = ((Bitmap)localObject2).getWidth();
      int m = ((Bitmap)localObject2).getHeight();
      int k = (int)(j * 0.78866667F);
      int i1 = (int)(m * 0.78866667F);
      localBitmap2 = Bitmap.createBitmap(j, m, Bitmap.Config.ARGB_8888);
      localBitmap3 = Bitmap.createScaledBitmap((Bitmap)localObject2, k, i1, true);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localObject2 = new Canvas(localBitmap2);
      ((Canvas)localObject2).drawArc(new RectF(0.0F, 0.0F, j, m), 30.0F, 120.0F, true, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      ((Canvas)localObject2).drawBitmap(localBitmap3, (j - k) / 2, m / 2 - (m - i1) / 2, localPaint);
      ((Canvas)localObject1).drawBitmap(localBitmap2, 0.0F, 0.0F, paramList);
      float f = n * 0.78866667F;
      paramList.setColor(-1);
      ((Canvas)localObject1).drawLine(i / 2, i / 2, 0.0F, f, paramList);
      ((Canvas)localObject1).drawLine(i / 2, i / 2, i, f, paramList);
      paramImageView.setImageBitmap(localBitmap1);
      com.lantern.mailbox.c.a.a().a(parama, localBitmap1);
    }
  }
  
  public final void a()
  {
    if ((this.a != null) && (!this.a.isEmpty()))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        com.lantern.mailbox.d.a locala = (com.lantern.mailbox.d.a)localIterator.next();
        if (locala.h()) {
          locala.c(false);
        }
      }
      notifyDataSetChanged();
    }
  }
  
  public final void a(List<com.lantern.mailbox.d.a> paramList, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.addAll(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.a = paramList;
    }
  }
  
  public final int getCount()
  {
    return this.a.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    com.lantern.mailbox.d.a locala;
    label151:
    label171:
    Object localObject2;
    long l1;
    long l2;
    Object localObject1;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(R.layout.mailbox_list_item, paramViewGroup, false);
      paramViewGroup = new a((byte)0);
      paramViewGroup.a = ((ImageView)paramView.findViewById(R.id.icon));
      paramViewGroup.b = ((TextView)paramView.findViewById(R.id.content));
      paramViewGroup.c = ((TextView)paramView.findViewById(R.id.quote));
      paramViewGroup.d = ((TextView)paramView.findViewById(R.id.time));
      paramViewGroup.e = paramView.findViewById(R.id.unread);
      paramView.setTag(paramViewGroup);
      locala = a(paramInt);
      if (!locala.h()) {
        break label370;
      }
      paramViewGroup.e.setVisibility(0);
      paramViewGroup.b.setText(a(locala, this.b.getResources().getColor(R.color.mailbox_black)));
      if (!TextUtils.isEmpty(locala.l())) {
        break label408;
      }
      paramViewGroup.c.setVisibility(8);
      localObject2 = paramViewGroup.d;
      l1 = locala.i();
      l2 = b(System.currentTimeMillis()) - l1;
      localObject1 = new StringBuilder();
      if (l2 > 0L) {
        break label431;
      }
      ((StringBuilder)localObject1).append(this.b.getString(R.string.mailbox_today));
      ((StringBuilder)localObject1).append(a(l1));
      label239:
      ((StringBuilder)localObject1).append(new SimpleDateFormat(this.b.getString(R.string.mailbox_time), Locale.CHINA).format(new Date(l1)));
      ((TextView)localObject2).setText(((StringBuilder)localObject1).toString());
      localObject1 = paramViewGroup.d;
      localObject2 = locala.o();
      if (!"12".equals(localObject2)) {
        break label589;
      }
      paramInt = R.drawable.mailbox_at;
      label315:
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(paramInt, 0, 0, 0);
      if (locala.e() != null) {
        break label641;
      }
      a(locala, paramViewGroup.a);
    }
    for (;;)
    {
      paramView.setOnClickListener(new b(this, locala, paramViewGroup));
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label370:
      paramViewGroup.e.setVisibility(8);
      paramViewGroup.b.setText(a(locala, this.b.getResources().getColor(R.color.mailbox_gray)));
      break label151;
      label408:
      paramViewGroup.c.setText(locala.l());
      paramViewGroup.c.setVisibility(0);
      break label171;
      label431:
      if ((l2 > 0L) && (l2 <= 86400000L))
      {
        ((StringBuilder)localObject1).append(this.b.getString(R.string.mailbox_yesterday));
        ((StringBuilder)localObject1).append(a(l1));
        break label239;
      }
      if ((l2 > 86400000L) && (l2 <= 172800000L))
      {
        ((StringBuilder)localObject1).append(this.b.getString(R.string.mailbox_before_yesterday));
        ((StringBuilder)localObject1).append(a(l1));
        break label239;
      }
      if (l2 <= 172800000L) {
        break label239;
      }
      ((StringBuilder)localObject1).append(new SimpleDateFormat(this.b.getString(R.string.mailbox_date), Locale.CHINA).format(new Date(l1)));
      ((StringBuilder)localObject1).append(a(l1));
      break label239;
      label589:
      if (!"1".equals(localObject2))
      {
        if ("2".equals(localObject2))
        {
          paramInt = R.drawable.mailbox_like;
          break label315;
        }
        if ("11".equals(localObject2))
        {
          paramInt = R.drawable.mailbox_reply;
          break label315;
        }
      }
      paramInt = R.drawable.mailbox_comment;
      break label315;
      label641:
      paramViewGroup.a.setImageBitmap(locala.e());
    }
  }
  
  private final class a
  {
    ImageView a;
    TextView b;
    TextView c;
    TextView d;
    View e;
    
    private a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */