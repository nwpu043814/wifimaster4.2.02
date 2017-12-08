package android.support.v4.print;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;

public final class PrintHelper
{
  public static final int COLOR_MODE_COLOR = 2;
  public static final int COLOR_MODE_MONOCHROME = 1;
  public static final int ORIENTATION_LANDSCAPE = 1;
  public static final int ORIENTATION_PORTRAIT = 2;
  public static final int SCALE_MODE_FILL = 2;
  public static final int SCALE_MODE_FIT = 1;
  PrintHelperVersionImpl mImpl;
  
  public PrintHelper(Context paramContext)
  {
    if (systemSupportsPrint()) {}
    for (this.mImpl = new PrintHelperKitkatImpl(paramContext);; this.mImpl = new PrintHelperStubImpl(null)) {
      return;
    }
  }
  
  public static boolean systemSupportsPrint()
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int getColorMode()
  {
    return this.mImpl.getColorMode();
  }
  
  public final int getOrientation()
  {
    return this.mImpl.getOrientation();
  }
  
  public final int getScaleMode()
  {
    return this.mImpl.getScaleMode();
  }
  
  public final void printBitmap(String paramString, Bitmap paramBitmap)
  {
    this.mImpl.printBitmap(paramString, paramBitmap);
  }
  
  public final void printBitmap(String paramString, Uri paramUri)
  {
    this.mImpl.printBitmap(paramString, paramUri);
  }
  
  public final void setColorMode(int paramInt)
  {
    this.mImpl.setColorMode(paramInt);
  }
  
  public final void setOrientation(int paramInt)
  {
    this.mImpl.setOrientation(paramInt);
  }
  
  public final void setScaleMode(int paramInt)
  {
    this.mImpl.setScaleMode(paramInt);
  }
  
  private static final class PrintHelperKitkatImpl
    implements PrintHelper.PrintHelperVersionImpl
  {
    private final PrintHelperKitkat mPrintHelper;
    
    PrintHelperKitkatImpl(Context paramContext)
    {
      this.mPrintHelper = new PrintHelperKitkat(paramContext);
    }
    
    public final int getColorMode()
    {
      return this.mPrintHelper.getColorMode();
    }
    
    public final int getOrientation()
    {
      return this.mPrintHelper.getOrientation();
    }
    
    public final int getScaleMode()
    {
      return this.mPrintHelper.getScaleMode();
    }
    
    public final void printBitmap(String paramString, Bitmap paramBitmap)
    {
      this.mPrintHelper.printBitmap(paramString, paramBitmap);
    }
    
    public final void printBitmap(String paramString, Uri paramUri)
    {
      this.mPrintHelper.printBitmap(paramString, paramUri);
    }
    
    public final void setColorMode(int paramInt)
    {
      this.mPrintHelper.setColorMode(paramInt);
    }
    
    public final void setOrientation(int paramInt)
    {
      this.mPrintHelper.setOrientation(paramInt);
    }
    
    public final void setScaleMode(int paramInt)
    {
      this.mPrintHelper.setScaleMode(paramInt);
    }
  }
  
  private static final class PrintHelperStubImpl
    implements PrintHelper.PrintHelperVersionImpl
  {
    int mColorMode = 2;
    int mOrientation = 1;
    int mScaleMode = 2;
    
    public final int getColorMode()
    {
      return this.mColorMode;
    }
    
    public final int getOrientation()
    {
      return this.mOrientation;
    }
    
    public final int getScaleMode()
    {
      return this.mScaleMode;
    }
    
    public final void printBitmap(String paramString, Bitmap paramBitmap) {}
    
    public final void printBitmap(String paramString, Uri paramUri) {}
    
    public final void setColorMode(int paramInt)
    {
      this.mColorMode = paramInt;
    }
    
    public final void setOrientation(int paramInt)
    {
      this.mOrientation = paramInt;
    }
    
    public final void setScaleMode(int paramInt)
    {
      this.mScaleMode = paramInt;
    }
  }
  
  static abstract interface PrintHelperVersionImpl
  {
    public abstract int getColorMode();
    
    public abstract int getOrientation();
    
    public abstract int getScaleMode();
    
    public abstract void printBitmap(String paramString, Bitmap paramBitmap);
    
    public abstract void printBitmap(String paramString, Uri paramUri);
    
    public abstract void setColorMode(int paramInt);
    
    public abstract void setOrientation(int paramInt);
    
    public abstract void setScaleMode(int paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/print/PrintHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */