package com.wifipay.wallet.home.widget.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

public class c
  implements Runnable
{
  private boolean a = false;
  private a b;
  private SmartImage c;
  private Context d;
  
  public c(Context paramContext, SmartImage paramSmartImage)
  {
    this.c = paramSmartImage;
    this.d = paramContext;
  }
  
  public void a()
  {
    this.a = true;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if ((this.b != null) && (!this.a)) {
      this.b.sendMessage(this.b.obtainMessage(0, paramBitmap));
    }
  }
  
  public void a(a parama)
  {
    this.b = parama;
  }
  
  public void run()
  {
    if (this.c != null)
    {
      a(this.c.getBitmap(this.d));
      this.d = null;
    }
  }
  
  public static class a
    extends Handler
  {
    public void a(Bitmap paramBitmap) {}
    
    public void handleMessage(Message paramMessage)
    {
      a((Bitmap)paramMessage.obj);
    }
  }
  
  public static abstract class b
  {
    public abstract void a();
    
    public void a(Bitmap paramBitmap)
    {
      a();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/image/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */