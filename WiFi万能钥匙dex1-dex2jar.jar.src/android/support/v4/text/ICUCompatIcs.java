package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ICUCompatIcs
{
  private static final String TAG = "ICUCompatIcs";
  private static Method sAddLikelySubtagsMethod;
  private static Method sGetScriptMethod;
  
  static
  {
    try
    {
      Class localClass = Class.forName("libcore.icu.ICU");
      if (localClass != null)
      {
        sGetScriptMethod = localClass.getMethod("getScript", new Class[] { String.class });
        sAddLikelySubtagsMethod = localClass.getMethod("addLikelySubtags", new Class[] { String.class });
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("ICUCompatIcs", localException);
      }
    }
  }
  
  public static String addLikelySubtags(String paramString)
  {
    try
    {
      if (sAddLikelySubtagsMethod == null) {
        break label37;
      }
      String str = (String)sAddLikelySubtagsMethod.invoke(null, new Object[] { paramString });
      paramString = str;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.w("ICUCompatIcs", localIllegalAccessException);
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        label37:
        Log.w("ICUCompatIcs", localInvocationTargetException);
      }
    }
    return paramString;
  }
  
  public static String getScript(String paramString)
  {
    try
    {
      if (sGetScriptMethod != null)
      {
        paramString = (String)sGetScriptMethod.invoke(null, new Object[] { paramString });
        return paramString;
      }
    }
    catch (IllegalAccessException paramString)
    {
      for (;;)
      {
        Log.w("ICUCompatIcs", paramString);
        paramString = null;
      }
    }
    catch (InvocationTargetException paramString)
    {
      for (;;)
      {
        Log.w("ICUCompatIcs", paramString);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/text/ICUCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */