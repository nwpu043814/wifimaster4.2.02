package com.lantern.photochoose.b;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;

final class b
  extends Handler
{
  b(a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    Object localObject = (a.b)paramMessage.obj;
    paramMessage = ((a.b)localObject).c;
    ImageView localImageView = ((a.b)localObject).b;
    localObject = ((a.b)localObject).a;
    if ((localImageView == null) || (localObject == null)) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(paramMessage)) && (paramMessage.equals(localImageView.getTag().toString()))) {
        localImageView.setImageBitmap((Bitmap)localObject);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/photochoose/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */