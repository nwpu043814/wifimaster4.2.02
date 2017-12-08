package com.linksure.apservice.integration.photochoose.b;

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
    String str = ((a.b)localObject).c;
    paramMessage = ((a.b)localObject).b;
    localObject = ((a.b)localObject).a;
    if ((paramMessage == null) || (localObject == null)) {}
    for (;;)
    {
      return;
      if ((!TextUtils.isEmpty(str)) && (str.equals(paramMessage.getTag().toString()))) {
        paramMessage.setImageBitmap((Bitmap)localObject);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */