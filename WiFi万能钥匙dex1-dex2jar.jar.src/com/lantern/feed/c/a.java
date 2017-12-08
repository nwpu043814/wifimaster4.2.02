package com.lantern.feed.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.c;
import org.json.JSONObject;

public final class a
{
  /* Error */
  public static com.lantern.feed.b.q a(String paramString)
  {
    // Byte code:
    //   0: new 10	org/json/JSONObject
    //   3: astore_3
    //   4: aload_3
    //   5: aload_0
    //   6: invokespecial 14	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   9: aload_3
    //   10: ldc 16
    //   12: invokevirtual 20	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   15: astore 4
    //   17: aload 4
    //   19: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   22: ifne +67 -> 89
    //   25: aload_3
    //   26: ldc 28
    //   28: invokevirtual 32	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   31: istore_1
    //   32: new 34	com/lantern/feed/b/q
    //   35: astore_0
    //   36: aload_0
    //   37: invokespecial 37	com/lantern/feed/b/q:<init>	()V
    //   40: aload_0
    //   41: aload 4
    //   43: invokevirtual 39	com/lantern/feed/b/q:a	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: iload_1
    //   48: invokevirtual 42	com/lantern/feed/b/q:a	(I)V
    //   51: aload_3
    //   52: ldc 44
    //   54: invokevirtual 32	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   57: iconst_1
    //   58: if_icmpne +12 -> 70
    //   61: iconst_1
    //   62: istore_2
    //   63: aload_0
    //   64: iload_2
    //   65: invokevirtual 47	com/lantern/feed/b/q:a	(Z)V
    //   68: aload_0
    //   69: areturn
    //   70: iconst_0
    //   71: istore_2
    //   72: goto -9 -> 63
    //   75: astore_3
    //   76: aconst_null
    //   77: astore_0
    //   78: aload_3
    //   79: invokestatic 52	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   82: goto -14 -> 68
    //   85: astore_3
    //   86: goto -8 -> 78
    //   89: aconst_null
    //   90: astore_0
    //   91: goto -23 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramString	String
    //   31	17	1	i	int
    //   62	10	2	bool	boolean
    //   3	49	3	localJSONObject	JSONObject
    //   75	4	3	localException1	Exception
    //   85	1	3	localException2	Exception
    //   15	27	4	str	String
    // Exception table:
    //   from	to	target	type
    //   0	40	75	java/lang/Exception
    //   40	61	85	java/lang/Exception
    //   63	68	85	java/lang/Exception
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = c.getAppContext().getSharedPreferences("wkfeed", 0).getString("transfer_" + paramString1, "");
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(str))) {}
    for (paramString1 = "";; paramString1 = str)
    {
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(str);
        paramString2 = localJSONObject.optString(paramString2);
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          h.a(paramString2);
        }
      }
      return paramString1;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences localSharedPreferences = c.getAppContext().getSharedPreferences("wkfeed", 0);
    Object localObject;
    if (!TextUtils.isEmpty(paramString3)) {
      localObject = localSharedPreferences.getString("transfer_" + paramString1, "");
    }
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>();
          ((JSONObject)localObject).put(paramString3, paramString2);
          paramString2 = localSharedPreferences.edit();
          paramString3 = new java/lang/StringBuilder;
          paramString3.<init>("transfer_");
          paramString2.putString(paramString1, ((JSONObject)localObject).toString()).apply();
          paramString2 = new java/lang/StringBuilder;
          paramString2.<init>("updateTransferMsg ");
          paramString3 = new java/lang/StringBuilder;
          paramString3.<init>("transfer_");
          h.a(localSharedPreferences.getString(paramString3.append(paramString1).toString(), ""), new Object[0]);
          return;
        }
      }
      catch (Exception paramString1)
      {
        h.a(paramString1);
        continue;
      }
      localObject = new JSONObject((String)localObject);
      continue;
      localSharedPreferences.edit().putString("transfer_" + paramString1, paramString2).apply();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */