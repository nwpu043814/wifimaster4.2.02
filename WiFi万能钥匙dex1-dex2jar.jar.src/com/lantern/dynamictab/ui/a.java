package com.lantern.dynamictab.ui;

import android.os.Message;
import com.bluefay.b.h;
import com.bluefay.d.b;

final class a
  extends b
{
  a(FriendFragment paramFriendFragment, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 128710)
    {
      h.a("Friend %s", new Object[] { "FriendFragment DYNAMIC_FRIENDS_REFRESH_FREGMENT_UI" });
      FriendFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */