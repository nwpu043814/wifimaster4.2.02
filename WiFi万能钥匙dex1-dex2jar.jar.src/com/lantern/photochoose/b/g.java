package com.lantern.photochoose.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.lantern.photochoose.a.a;
import com.lantern.photochoose.a.b;
import com.lantern.settings.R.string;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g
{
  private static final Paint a = new Paint(1);
  private static final Paint b;
  
  static
  {
    Paint localPaint = new Paint(1);
    b = localPaint;
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      paramBitmap = null;
      return paramBitmap;
    }
    int k = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (k < j) {}
    for (int i = k;; i = j)
    {
      RectF localRectF = new RectF();
      Object localObject2 = new RectF();
      localRectF.set(0.0F, 0.0F, k, j);
      ((RectF)localObject2).set(0.0F, 0.0F, i, i);
      Object localObject1 = new Matrix();
      ((Matrix)localObject1).setRectToRect(localRectF, (RectF)localObject2, Matrix.ScaleToFit.FILL);
      localObject2 = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
      new Canvas((Bitmap)localObject2).drawBitmap(paramBitmap, (Matrix)localObject1, null);
      paramBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
      localObject1 = new Canvas(paramBitmap);
      i /= 2;
      ((Canvas)localObject1).drawCircle(i, i, i, a);
      ((Canvas)localObject1).drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, b);
      break;
    }
  }
  
  public static Bitmap a(String paramString)
  {
    Object localObject = null;
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      try
      {
        FileInputStream localFileInputStream = new java/io/FileInputStream;
        localFileInputStream.<init>(paramString);
        paramString = a(BitmapFactory.decodeStream(localFileInputStream));
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        paramString = (String)localObject;
      }
      catch (Throwable paramString)
      {
        System.gc();
        paramString = (String)localObject;
      }
    }
  }
  
  public static Map<String, b> a(Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    String str = paramContext.getString(R.string.settings_photo_all_photo);
    Object localObject1 = new b();
    ((b)localObject1).a(str);
    ((b)localObject1).b(str);
    ((b)localObject1).a(new ArrayList());
    localHashMap.put(str, localObject1);
    localObject1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    paramContext = paramContext.getContentResolver().query((Uri)localObject1, null, "(mime_type=? or mime_type=?) and width > 128 and height > 128", new String[] { "image/jpeg", "image/png" }, "date_modified desc");
    if (paramContext != null)
    {
      while (paramContext.moveToNext())
      {
        Object localObject2 = paramContext.getString(paramContext.getColumnIndex("_data"));
        localObject1 = new File((String)localObject2).getParentFile();
        if (localObject1 != null)
        {
          localObject1 = ((File)localObject1).getAbsolutePath();
          if (localHashMap.containsKey(localObject1))
          {
            localObject2 = new a((String)localObject2);
            ((b)localHashMap.get(localObject1)).c().add(localObject2);
            ((b)localHashMap.get(str)).c().add(localObject2);
          }
          else
          {
            b localb = new b();
            ArrayList localArrayList = new ArrayList();
            localObject2 = new a((String)localObject2);
            localArrayList.add(localObject2);
            localb.a(localArrayList);
            localb.b((String)localObject1);
            localb.a(((String)localObject1).substring(((String)localObject1).lastIndexOf(File.separator) + 1, ((String)localObject1).length()));
            localHashMap.put(localObject1, localb);
            ((b)localHashMap.get(str)).c().add(localObject2);
          }
        }
      }
      paramContext.close();
    }
    return localHashMap;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/photochoose/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */