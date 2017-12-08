package com.wifipay.wallet.home.widget.image;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract.Contacts;
import java.io.InputStream;

public class a
  implements SmartImage
{
  private long a;
  
  public a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public Bitmap getBitmap(Context paramContext)
  {
    localObject = null;
    paramContext = paramContext.getContentResolver();
    try
    {
      InputStream localInputStream = ContactsContract.Contacts.openContactPhotoInputStream(paramContext, ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, this.a));
      paramContext = (Context)localObject;
      if (localInputStream != null) {
        paramContext = BitmapFactory.decodeStream(localInputStream);
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = (Context)localObject;
      }
    }
    return paramContext;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/image/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */