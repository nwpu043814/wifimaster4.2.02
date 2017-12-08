package com.lantern.wifiseccheck.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.vpn.utils.ResTool;

public class MyProgressWheel
  extends View
{
  private Bitmap bitmap;
  private Context context;
  private boolean isActStop = false;
  private boolean isChanging = false;
  private OnScoreChangedListener listener;
  private Matrix matrix = new Matrix();
  private int maxProgress;
  private Paint paint;
  private int progress = 100;
  private Bitmap resBitmap;
  private int roundColor;
  private int roundProgressColor;
  private float roundWidth;
  private boolean startDrawableAnim = false;
  private volatile int tProgress = 100;
  private int textColor;
  private float textSize;
  
  public MyProgressWheel(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MyProgressWheel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MyProgressWheel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    this.paint = new Paint();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, new int[] { ResTool.getAttrId("roundColor", paramContext), ResTool.getAttrId("roundProgressColor", paramContext), ResTool.getAttrId("roundWidth", paramContext), ResTool.getAttrId("textColor", paramContext), ResTool.getAttrId("textSize", paramContext), ResTool.getAttrId("maxProgress", paramContext) });
    this.roundColor = paramAttributeSet.getColor(ResTool.getStyleableId("SuperProgressWheel_roundColor", paramContext), getResources().getColor(ResTool.getColorId("round_color", paramContext)));
    this.roundProgressColor = paramAttributeSet.getColor(ResTool.getStyleableId("SuperProgressWheel_roundProgressColor", paramContext), -1);
    this.textColor = paramAttributeSet.getColor(ResTool.getStyleableId("SuperProgressWheel_textColor", paramContext), -16777216);
    this.textSize = paramAttributeSet.getDimension(ResTool.getStyleableId("SuperProgressWheel_textSize", paramContext), 45.0F);
    this.roundWidth = paramAttributeSet.getDimension(ResTool.getStyleableId("SuperProgressWheel_roundWidth", paramContext), 35.0F);
    this.maxProgress = paramAttributeSet.getInteger(ResTool.getStyleableId("SuperProgressWheel_maxProgress", paramContext), 100);
    paramAttributeSet.recycle();
  }
  
  /* Error */
  private void startProgressChanged(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/lantern/wifiseccheck/view/MyProgressWheel:progress	I
    //   6: aload_0
    //   7: getfield 52	com/lantern/wifiseccheck/view/MyProgressWheel:tProgress	I
    //   10: if_icmpne +25 -> 35
    //   13: aload_0
    //   14: iload_1
    //   15: putfield 52	com/lantern/wifiseccheck/view/MyProgressWheel:tProgress	I
    //   18: new 9	com/lantern/wifiseccheck/view/MyProgressWheel$ProgressUpdateThread
    //   21: astore_2
    //   22: aload_2
    //   23: aload_0
    //   24: aconst_null
    //   25: invokespecial 162	com/lantern/wifiseccheck/view/MyProgressWheel$ProgressUpdateThread:<init>	(Lcom/lantern/wifiseccheck/view/MyProgressWheel;Lcom/lantern/wifiseccheck/view/MyProgressWheel$1;)V
    //   28: aload_2
    //   29: invokevirtual 165	com/lantern/wifiseccheck/view/MyProgressWheel$ProgressUpdateThread:start	()V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: iload_1
    //   37: putfield 52	com/lantern/wifiseccheck/view/MyProgressWheel:tProgress	I
    //   40: goto -8 -> 32
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	MyProgressWheel
    //   0	48	1	paramInt	int
    //   21	8	2	localProgressUpdateThread	ProgressUpdateThread
    //   43	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	32	43	finally
    //   32	34	43	finally
    //   35	40	43	finally
    //   44	46	43	finally
  }
  
  public int getMaxProgress()
  {
    return this.maxProgress;
  }
  
  public int getProgress()
  {
    try
    {
      int i = this.progress;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getRoundColor()
  {
    return this.roundColor;
  }
  
  public int getRoundProgressColor()
  {
    return this.roundProgressColor;
  }
  
  public float getRoundWidth()
  {
    return this.roundWidth;
  }
  
  public int getTextColor()
  {
    return this.textColor;
  }
  
  public float getTextSize()
  {
    return this.textSize;
  }
  
  public boolean isStartDrawableAnim()
  {
    return this.startDrawableAnim;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getWidth() / 2;
    int i = (int)(j - this.roundWidth / 2.0F);
    this.paint.setColor(this.roundColor);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(this.roundWidth);
    this.paint.setAntiAlias(true);
    RectF localRectF = new RectF(j - i, j - i, j + i, j + i);
    i = 0;
    float f = 135.0F;
    while (i < this.maxProgress / 2)
    {
      paramCanvas.drawArc(localRectF, f, 1.8243244F, false, this.paint);
      f = (i + 1) * 5.472973F + 135.0F;
      i++;
    }
    this.paint.setColor(this.roundProgressColor);
    f = 135.0F;
    for (i = 0; i < this.progress / 2; i++)
    {
      paramCanvas.drawArc(localRectF, f, 1.8243244F, false, this.paint);
      f = (i + 1) * 5.472973F + 135.0F;
    }
    this.paint.setStrokeWidth(0.0F);
    this.paint.setColor(this.textColor);
    this.paint.setTextSize(this.textSize);
    this.paint.measureText(this.progress);
    if (this.listener != null)
    {
      LogUtils.d("ScoreView", "onScoreChanged  progress");
      this.listener.onScoreChanged(this.progress);
    }
  }
  
  public void setIsActStop(boolean paramBoolean)
  {
    this.isActStop = paramBoolean;
  }
  
  public void setMaxProgress(int paramInt)
  {
    this.maxProgress = paramInt;
  }
  
  public void setOnScoreChangeListener(OnScoreChangedListener paramOnScoreChangedListener)
  {
    this.listener = paramOnScoreChangedListener;
  }
  
  public void setProgress(int paramInt)
  {
    try
    {
      startProgressChanged(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setRoundColor(int paramInt)
  {
    this.roundColor = paramInt;
  }
  
  public void setRoundProgressColor(int paramInt)
  {
    this.roundProgressColor = paramInt;
  }
  
  public void setRoundWidth(float paramFloat)
  {
    this.roundWidth = paramFloat;
  }
  
  public void setStartDrawableAnim(boolean paramBoolean)
  {
    this.startDrawableAnim = paramBoolean;
  }
  
  public void setTextColor(int paramInt)
  {
    this.textColor = paramInt;
  }
  
  public void setTextSize(float paramFloat)
  {
    this.textSize = paramFloat;
  }
  
  public static abstract interface OnScoreChangedListener
  {
    public abstract void onScoreChanged(int paramInt);
  }
  
  private class ProgressUpdateThread
    extends Thread
  {
    private ProgressUpdateThread() {}
    
    public void run()
    {
      synchronized (MyProgressWheel.this)
      {
        for (;;)
        {
          if (MyProgressWheel.this.progress == MyProgressWheel.this.tProgress)
          {
            LogUtils.d("ScoreView", "do finish return!!!");
            return;
          }
          if (MyProgressWheel.this.progress <= MyProgressWheel.this.tProgress) {
            break;
          }
          MyProgressWheel.access$110(MyProgressWheel.this);
          MyProgressWheel.this.postInvalidate();
          if (!MyProgressWheel.this.isActStop) {
            try
            {
              sleep(15L);
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
        MyProgressWheel.access$108(MyProgressWheel.this);
      }
    }
  }
  
  public static abstract interface onProgressListener
  {
    public abstract void onCompleted(View paramView);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/view/MyProgressWheel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */