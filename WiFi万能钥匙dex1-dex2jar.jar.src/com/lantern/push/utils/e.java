package com.lantern.push.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.lantern.push.provider.b.a;
import com.lantern.push.ui.h;

public final class e
  extends Thread
{
  private ContentResolver a;
  private h b;
  private ContentValues c = new ContentValues();
  private String[] d = null;
  private String e = null;
  private Handler f = new Handler(new f(this));
  
  public e(Context paramContext, h paramh, int paramInt)
  {
    this.b = paramh;
    this.a = paramContext.getContentResolver();
    this.c.put("state", Integer.valueOf(1));
    if (paramInt > 0)
    {
      this.d = new String[] { String.valueOf(paramInt) };
      this.e = "_id=?";
    }
    start();
  }
  
  public e(Context paramContext, String paramString)
  {
    this.a = paramContext.getContentResolver();
    this.c.put("state", Integer.valueOf(1));
    if (!TextUtils.isEmpty(paramString))
    {
      this.d = new String[] { paramString };
      this.e = "msgId=?";
      start();
    }
  }
  
  public final void run()
  {
    this.a.update(b.a.a, this.c, this.e, this.d);
    this.f.sendEmptyMessage(0);
    a.a(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */