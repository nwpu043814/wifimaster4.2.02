package com.lantern.favorite;

import android.os.Message;

final class b
  extends com.bluefay.d.b
{
  b(SyncService paramSyncService, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 128202) {
      new SyncService.a(this.a.getApplication(), (byte)0).start();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */