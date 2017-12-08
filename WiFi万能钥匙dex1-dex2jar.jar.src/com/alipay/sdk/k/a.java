package com.alipay.sdk.k;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public final class a
{
  public static String a = "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";
  public boolean b = false;
  private a c;
  private Activity d;
  private String e;
  
  public a(Activity paramActivity, String paramString)
  {
    this.d = paramActivity;
    this.e = paramString;
  }
  
  public final void a()
  {
    if (this.d != null) {
      this.d.runOnUiThread(new b(this));
    }
  }
  
  public final void b()
  {
    if (this.d != null) {
      this.d.runOnUiThread(new c(this));
    }
  }
  
  public final class a
    extends AlertDialog
  {
    protected a(Context paramContext)
    {
      super();
    }
    
    private static int a(Context paramContext, float paramFloat)
    {
      if (paramContext == null) {}
      for (paramContext = Resources.getSystem();; paramContext = paramContext.getResources()) {
        return (int)(paramContext.getDisplayMetrics().density * paramFloat);
      }
    }
    
    /* Error */
    private static android.graphics.drawable.Drawable a(Context paramContext, String paramString)
    {
      // Byte code:
      //   0: new 45	java/io/ByteArrayInputStream
      //   3: astore_2
      //   4: aload_2
      //   5: aload_1
      //   6: invokestatic 50	com/alipay/sdk/d/a:a	(Ljava/lang/String;)[B
      //   9: invokespecial 53	java/io/ByteArrayInputStream:<init>	([B)V
      //   12: new 55	android/graphics/BitmapFactory$Options
      //   15: astore_1
      //   16: aload_1
      //   17: invokespecial 58	android/graphics/BitmapFactory$Options:<init>	()V
      //   20: aload_1
      //   21: sipush 480
      //   24: putfield 62	android/graphics/BitmapFactory$Options:inDensity	I
      //   27: aload_1
      //   28: aload_0
      //   29: invokevirtual 38	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   32: invokevirtual 27	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
      //   35: getfield 65	android/util/DisplayMetrics:densityDpi	I
      //   38: putfield 68	android/graphics/BitmapFactory$Options:inTargetDensity	I
      //   41: aload_2
      //   42: aconst_null
      //   43: aload_1
      //   44: invokestatic 74	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   47: astore_3
      //   48: new 76	android/graphics/drawable/BitmapDrawable
      //   51: astore_1
      //   52: aload_1
      //   53: aload_0
      //   54: invokevirtual 38	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   57: aload_3
      //   58: invokespecial 79	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
      //   61: aload_2
      //   62: invokevirtual 84	java/io/InputStream:close	()V
      //   65: aload_1
      //   66: astore_0
      //   67: aload_0
      //   68: areturn
      //   69: astore_0
      //   70: aconst_null
      //   71: astore_2
      //   72: aload_2
      //   73: ifnull +13 -> 86
      //   76: aload_2
      //   77: invokevirtual 84	java/io/InputStream:close	()V
      //   80: aconst_null
      //   81: astore_0
      //   82: goto -15 -> 67
      //   85: astore_0
      //   86: aconst_null
      //   87: astore_0
      //   88: goto -21 -> 67
      //   91: astore_0
      //   92: aconst_null
      //   93: astore_2
      //   94: aload_2
      //   95: ifnull +7 -> 102
      //   98: aload_2
      //   99: invokevirtual 84	java/io/InputStream:close	()V
      //   102: aload_0
      //   103: athrow
      //   104: astore_0
      //   105: aload_1
      //   106: astore_0
      //   107: goto -40 -> 67
      //   110: astore_1
      //   111: goto -9 -> 102
      //   114: astore_0
      //   115: goto -21 -> 94
      //   118: astore_0
      //   119: goto -47 -> 72
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	122	0	paramContext	Context
      //   0	122	1	paramString	String
      //   3	96	2	localByteArrayInputStream	java.io.ByteArrayInputStream
      //   47	11	3	localBitmap	android.graphics.Bitmap
      // Exception table:
      //   from	to	target	type
      //   0	12	69	java/lang/Throwable
      //   76	80	85	java/lang/Exception
      //   0	12	91	finally
      //   61	65	104	java/lang/Exception
      //   98	102	110	java/lang/Exception
      //   12	61	114	finally
      //   12	61	118	java/lang/Throwable
    }
    
    protected void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      Context localContext = getContext();
      LinearLayout localLinearLayout = new LinearLayout(localContext);
      paramBundle = new FrameLayout.LayoutParams(-2, a(localContext, 50.0F));
      paramBundle.gravity = 17;
      localLinearLayout.setOrientation(0);
      localLinearLayout.setLayoutParams(paramBundle);
      paramBundle = new GradientDrawable();
      paramBundle.setColor(-450944201);
      paramBundle.setCornerRadius(a(localContext, 5.0F));
      localLinearLayout.setBackgroundDrawable(paramBundle);
      ImageView localImageView = new ImageView(localContext);
      paramBundle = new LinearLayout.LayoutParams(a(localContext, 20.0F), a(localContext, 20.0F));
      paramBundle.gravity = 16;
      paramBundle.setMargins(a(a.a(a.this), 17.0F), a(a.a(a.this), 10.0F), a(a.a(a.this), 8.0F), a(a.a(a.this), 10.0F));
      localImageView.setLayoutParams(paramBundle);
      localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      localImageView.setImageDrawable(a(localContext, a.a));
      paramBundle = new RotateAnimation(0.0F, 359.0F, 1, 0.5F, 1, 0.5F);
      paramBundle.setRepeatCount(-1);
      paramBundle.setDuration(900L);
      paramBundle.setInterpolator(new LinearInterpolator());
      localImageView.startAnimation(paramBundle);
      TextView localTextView = new TextView(localContext);
      if (TextUtils.isEmpty(a.b(a.this))) {}
      for (paramBundle = "正在加载";; paramBundle = a.b(a.this))
      {
        localTextView.setText(paramBundle);
        localTextView.setTextSize(16.0F);
        localTextView.setTextColor(-1);
        paramBundle = new LinearLayout.LayoutParams(-2, -2);
        paramBundle.gravity = 16;
        paramBundle.setMargins(0, 0, a(localContext, 17.0F), 0);
        localTextView.setLayoutParams(paramBundle);
        localLinearLayout.addView(localImageView);
        localLinearLayout.addView(localTextView);
        setContentView(localLinearLayout);
        getWindow().setBackgroundDrawable(new ColorDrawable(17170445));
        return;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/k/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */