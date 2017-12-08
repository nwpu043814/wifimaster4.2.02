package com.wifipay.wallet.home.widget.image;

import android.graphics.Bitmap;

class d
  extends c.a
{
  d(SmartImageView paramSmartImageView, Integer paramInteger, c.b paramb) {}
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.c.setImageBitmap(paramBitmap);
    }
    for (;;)
    {
      if (this.b != null) {
        this.b.a(paramBitmap);
      }
      return;
      if (this.a != null) {
        this.c.setImageResource(this.a.intValue());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/image/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */