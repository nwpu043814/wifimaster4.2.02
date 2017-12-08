package com.lantern.dm.task;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import com.lantern.core.g.j;

final class c
  implements com.bluefay.b.a
{
  c(DownloadReceiver paramDownloadReceiver, Context paramContext) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if ((paramInt == 1) && (j.b(((Integer)paramObject).intValue())))
    {
      paramString = new ContentValues();
      paramString.put("numfailed", "0");
      paramString.put("control", Integer.valueOf(0));
      paramString.put("status", Integer.valueOf(190));
      this.a.getContentResolver().update(com.lantern.core.model.a.a, paramString, " status != '200' ", null);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/task/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */