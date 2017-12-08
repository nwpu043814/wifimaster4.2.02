package bluefay.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import com.bluefay.b.h;
import com.bluefay.framework.R.styleable;

public class SeekBar
  extends android.widget.SeekBar
{
  protected int a;
  protected int b;
  protected Drawable c;
  protected int d;
  private Rect e;
  private Bitmap f;
  private Drawable g;
  private Bitmap h;
  private Drawable i;
  private Drawable j;
  private Bitmap k;
  
  public SeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842875);
  }
  
  public SeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BLProgressBar, paramInt, 0);
    this.g = paramContext.getDrawable(0);
    this.j = paramContext.getDrawable(1);
    h.a("mProgressBar:" + this.g, new Object[0]);
    h.a("mProgressMask:" + this.j, new Object[0]);
    paramContext.recycle();
    this.d = getThumbOffset();
    this.i = getProgressDrawable();
  }
  
  private Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
    }
    for (;;)
    {
      return paramDrawable;
      if ((paramDrawable instanceof NinePatchDrawable))
      {
        Bitmap localBitmap = Bitmap.createBitmap(this.b, this.a, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, this.b, this.a);
        paramDrawable.draw(localCanvas);
        paramDrawable = localBitmap;
      }
      else
      {
        paramDrawable = null;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      int m;
      try
      {
        if (this.i != null)
        {
          paramCanvas.save();
          paramCanvas.translate(getPaddingLeft(), getPaddingTop());
          this.i.draw(paramCanvas);
          paramCanvas.restore();
        }
        if ((this.b <= 0) || (this.a <= 0))
        {
          if (this.c != null)
          {
            paramCanvas.save();
            paramCanvas.translate(getPaddingLeft() - this.d, getPaddingTop());
            this.c.draw(paramCanvas);
            paramCanvas.restore();
          }
          return;
        }
        paramCanvas.save();
        Rect localRect;
        if (this.e == null)
        {
          localRect = new android/graphics/Rect;
          localRect.<init>();
          this.e = localRect;
          this.e.left = getPaddingLeft();
          this.e.top = getPaddingTop();
          this.e.bottom = (getHeight() - getPaddingTop());
        }
        if (getMax() <= 0)
        {
          l = 0L;
          localRect = this.e;
          m = this.e.left;
          localRect.right = ((int)l + m);
          paramCanvas.clipRect(this.e);
          paramCanvas.drawBitmap(this.f, getPaddingLeft(), getPaddingTop(), null);
          paramCanvas.restore();
          continue;
        }
        m = getProgress() * this.b / getMax();
      }
      finally {}
      long l = m;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
    {
      this.b = (getWidth() - getPaddingLeft() - getPaddingRight());
      this.a = (getHeight() - getPaddingTop() - getPaddingBottom());
      if ((this.b > 0) && (this.a > 0)) {
        break label66;
      }
    }
    for (;;)
    {
      return;
      label66:
      if (this.h != null) {
        this.h.recycle();
      }
      this.h = a(this.g);
      if (this.k != null) {
        this.k.recycle();
      }
      this.k = a(this.j);
      if ((this.i instanceof NinePatchDrawable)) {
        this.i.setBounds(0, 0, this.b, this.a);
      }
      if (this.f != null) {
        this.f.recycle();
      }
      Object localObject = this.h;
      Bitmap localBitmap2 = this.k;
      Bitmap localBitmap1 = Bitmap.createBitmap(this.b, this.a, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap1);
      localCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      if (localObject != null) {
        localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 0.0F, null);
      }
      if (localBitmap2 != null)
      {
        localObject = new Paint();
        ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, (Paint)localObject);
      }
      this.f = localBitmap1;
    }
  }
  
  public void setProgress(int paramInt)
  {
    try
    {
      super.setProgress(paramInt);
      postInvalidate();
      return;
    }
    finally {}
  }
  
  public void setThumb(Drawable paramDrawable)
  {
    super.setThumb(paramDrawable);
    this.c = paramDrawable;
    this.d = getThumbOffset();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/widget/SeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */