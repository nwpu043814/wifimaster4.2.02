package com.lantern.core.imageloader.a;

final class i
  implements Runnable
{
  i(ap paramap) {}
  
  public final void run()
  {
    throw new IllegalStateException("Transformation " + this.a.a() + " mutated input Bitmap but failed to recycle the original.");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */