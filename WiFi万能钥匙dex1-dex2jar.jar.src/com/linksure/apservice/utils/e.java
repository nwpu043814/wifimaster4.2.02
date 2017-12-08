package com.linksure.apservice.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.lantern.core.imageloader.a.aa;
import com.lantern.core.imageloader.a.ah;
import com.lantern.core.imageloader.a.an;

public final class e
{
  private static aa a;
  
  public static void a(Context paramContext)
  {
    if (a == null) {
      a = aa.a(paramContext.getApplicationContext());
    }
  }
  
  public static void a(ImageView paramImageView, String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a.a(paramString).a(paramInt).a().a(paramImageView);
    }
  }
  
  public static void a(String paramString, an paraman)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a.a(paramString).a(paraman);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */