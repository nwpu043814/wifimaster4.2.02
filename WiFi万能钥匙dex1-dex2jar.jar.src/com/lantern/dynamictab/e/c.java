package com.lantern.dynamictab.e;

import android.os.Bundle;
import android.os.Message;

final class c
  extends com.bluefay.d.b
{
  c(b paramb, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i != 128400) && (i == 128700)) {
      this.a.a((Bundle)paramMessage.obj, false);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */