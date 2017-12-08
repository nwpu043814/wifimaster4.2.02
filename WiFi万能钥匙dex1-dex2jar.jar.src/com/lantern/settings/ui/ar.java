package com.lantern.settings.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.bluefay.b.h;
import com.lantern.settings.R.dimen;
import com.lantern.settings.R.drawable;

public final class ar
{
  private Context a;
  
  public ar(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final CharSequence a(String paramString)
  {
    SpannableString localSpannableString = SpannableString.valueOf(paramString + " [new]");
    Context localContext = this.a;
    Object localObject = this.a.getResources().getDrawable(R.drawable.settings_red_dot);
    Bitmap localBitmap;
    if (localObject == null) {
      localBitmap = null;
    }
    for (;;)
    {
      localSpannableString.setSpan(new a(localContext, localBitmap), paramString.length() + 1, paramString.length() + 6, 33);
      return localSpannableString;
      int i = ((Drawable)localObject).getIntrinsicWidth();
      int j = ((Drawable)localObject).getIntrinsicHeight();
      localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      if (localBitmap == null)
      {
        localBitmap = null;
      }
      else
      {
        Canvas localCanvas = new Canvas(localBitmap);
        ((Drawable)localObject).setBounds(0, 0, i, j);
        ((Drawable)localObject).draw(localCanvas);
        h.a("width:%d,height:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        localObject = new Rect();
        Paint localPaint = new Paint(1);
        localPaint.setARGB(255, 255, 255, 255);
        localPaint.setTextAlign(Paint.Align.CENTER);
        localPaint.setTypeface(Typeface.DEFAULT_BOLD);
        localPaint.setTextSize(this.a.getResources().getDimension(R.dimen.framework_text_font_size_small));
        localPaint.getTextBounds("", 0, "".length(), (Rect)localObject);
        h.a("CounterRect.height():%s", new Object[] { Integer.valueOf(((Rect)localObject).height()) });
        float f1 = i / 2.0F;
        float f2 = (j - ((Rect)localObject).height()) / 2.0F;
        f2 = ((Rect)localObject).height() + f2;
        h.a("Draw Text x:%f, y:%f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
        localCanvas.drawText("", f1, f2, localPaint);
      }
    }
  }
  
  private final class a
    extends ImageSpan
  {
    public a(Context paramContext, Bitmap paramBitmap)
    {
      super(paramBitmap);
    }
    
    public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
    {
      paramCharSequence = getDrawable();
      paramCanvas.save();
      paramCanvas.translate(paramFloat, paramInt3);
      paramCharSequence.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */