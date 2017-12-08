package com.lantern.core.imageloader;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.lantern.core.imageloader.a.aa;
import com.lantern.core.imageloader.a.ah;
import com.lantern.core.imageloader.a.an;

public final class c
{
  public static void a(Context paramContext, int paramInt, ImageView paramImageView)
  {
    if (paramInt > 0) {
      aa.a(paramContext).a(paramInt).a(com.lantern.core.c.getAppContext()).a(paramImageView, null);
    }
  }
  
  public static void a(Context paramContext, String paramString, ImageView paramImageView)
  {
    a(paramContext, paramString, paramImageView, null, null, 0, 0);
  }
  
  public static void a(Context paramContext, String paramString, ImageView paramImageView, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      paramContext = aa.a(paramContext).a(paramString).a(com.lantern.core.c.getAppContext());
      paramContext.a(paramInt);
      paramContext.a(paramImageView, null);
    }
  }
  
  public static void a(Context paramContext, String paramString, ImageView paramImageView, b paramb, d paramd)
  {
    a(paramContext, paramString, paramImageView, paramb, paramd, 0, 0);
  }
  
  public static void a(Context paramContext, String paramString, ImageView paramImageView, b paramb, d paramd, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (paramb != null) {
        paramb.b();
      }
    }
    for (;;)
    {
      return;
      paramContext = aa.a(paramContext).a(paramString).a(com.lantern.core.c.getAppContext());
      if (paramd != null) {
        paramContext.a(paramd);
      }
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        paramContext.d().a(paramInt1, paramInt2);
      }
      paramContext.a(paramImageView, paramb);
    }
  }
  
  public static void a(Context paramContext, String paramString, ImageView paramImageView, d paramd)
  {
    a(paramContext, paramString, paramImageView, null, paramd);
  }
  
  public static void a(Context paramContext, String paramString, ImageView paramImageView, d paramd, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      paramContext = aa.a(paramContext).a(paramString).a(com.lantern.core.c.getAppContext());
      if (paramd != null) {
        paramContext.a(paramd);
      }
      if (paramInt != 0) {
        paramContext.a(paramInt);
      }
      paramContext.a(paramImageView, null);
    }
  }
  
  private static void a(Context paramContext, String paramString, an paraman, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      paramContext = aa.a(paramContext).a(paramString);
      if ((paramInt1 > 0) && (paramInt2 > 0)) {
        paramContext.a(paramInt1, paramInt2);
      }
      paramContext.a(paraman);
    }
  }
  
  public static void a(Context paramContext, String paramString, f paramf)
  {
    a(paramContext, paramString, paramf, 0, 0);
  }
  
  public static void a(Context paramContext, String paramString, f paramf, int paramInt1, int paramInt2)
  {
    a(paramContext, paramString, paramf, paramInt1, paramInt2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */