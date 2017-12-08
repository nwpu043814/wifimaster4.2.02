package com.lantern.push.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Handler;
import com.lantern.push.provider.b.a;
import com.lantern.push.ui.h;

public final class c
  extends Thread
{
  private ContentResolver a;
  private h b;
  private String[] c;
  private int d;
  private Handler e = new Handler(new d(this));
  
  public c(Context paramContext, h paramh, int paramInt)
  {
    this.b = paramh;
    this.d = paramInt;
    this.a = paramContext.getContentResolver();
    this.c = new String[] { String.valueOf(paramInt) };
    start();
  }
  
  public final void run()
  {
    this.a.delete(b.a.a, "_id=?", this.c);
    this.e.sendEmptyMessage(0);
    a.a(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */