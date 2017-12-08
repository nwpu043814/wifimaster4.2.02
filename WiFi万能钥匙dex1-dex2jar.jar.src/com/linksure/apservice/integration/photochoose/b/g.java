package com.linksure.apservice.integration.photochoose.b;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.linksure.apservice.R.string;
import com.linksure.apservice.integration.photochoose.a.a;
import com.linksure.apservice.integration.photochoose.a.b;
import java.io.File;
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
        Object localObject3 = paramContext.getString(paramContext.getColumnIndex("_data"));
        localObject1 = new File((String)localObject3).getParentFile();
        if (localObject1 != null)
        {
          localObject1 = ((File)localObject1).getAbsolutePath();
          Object localObject2;
          if (localHashMap.containsKey(localObject1))
          {
            localObject2 = new a((String)localObject3);
            ((b)localHashMap.get(localObject1)).c().add(localObject2);
            ((b)localHashMap.get(str)).c().add(localObject2);
          }
          else
          {
            b localb = new b();
            localObject2 = new ArrayList();
            localObject3 = new a((String)localObject3);
            ((List)localObject2).add(localObject3);
            localb.a((List)localObject2);
            localb.b((String)localObject1);
            localb.a(((String)localObject1).substring(((String)localObject1).lastIndexOf(File.separator) + 1, ((String)localObject1).length()));
            localHashMap.put(localObject1, localb);
            ((b)localHashMap.get(str)).c().add(localObject3);
          }
        }
      }
      paramContext.close();
    }
    return localHashMap;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */