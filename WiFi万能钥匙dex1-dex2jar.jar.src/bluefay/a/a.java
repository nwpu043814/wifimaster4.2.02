package bluefay.a;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.FileNotFoundException;

public final class a
{
  private static byte[] a = { -119, 80, 78, 71, 13, 10, 26, 10 };
  
  private static BitmapFactory.Options a(b paramb)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeStream(paramb.b(), null, localOptions);
      paramb.a();
      paramb = localOptions;
    }
    catch (FileNotFoundException paramb)
    {
      for (;;)
      {
        paramb.printStackTrace();
        paramb = null;
      }
    }
    return paramb;
  }
  
  public static final BitmapFactory.Options a(String paramString)
  {
    return a(new b(paramString));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */