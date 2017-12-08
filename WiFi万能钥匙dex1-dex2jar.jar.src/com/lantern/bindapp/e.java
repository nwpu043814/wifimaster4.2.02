package com.lantern.bindapp;

import android.content.Intent;
import com.lantern.core.c;

final class e
  implements Runnable
{
  e(Intent paramIntent) {}
  
  public final void run()
  {
    c.getInstance().startActivity(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/bindapp/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */