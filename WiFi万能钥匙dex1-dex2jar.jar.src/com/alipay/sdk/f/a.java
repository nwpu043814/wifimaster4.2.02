package com.alipay.sdk.f;

import android.text.TextUtils;

public final class a
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      String[] arrayOfString = paramString.split("&");
      if (arrayOfString.length == 0)
      {
        paramString = "";
      }
      else
      {
        int j = arrayOfString.length;
        int i = 0;
        Object localObject4 = null;
        Object localObject3 = null;
        Object localObject5 = null;
        Object localObject6 = null;
        if (i < j)
        {
          String str = arrayOfString[i];
          paramString = (String)localObject6;
          label84:
          label107:
          Object localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject6))
          {
            if (!str.contains("biz_type")) {
              paramString = null;
            }
          }
          else
          {
            localObject1 = localObject5;
            if (TextUtils.isEmpty((CharSequence)localObject5))
            {
              if (str.contains("biz_no")) {
                break label196;
              }
              localObject1 = null;
            }
            localObject2 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3))
            {
              if ((str.contains("trade_no")) && (!str.startsWith("out_trade_no"))) {
                break label205;
              }
              localObject2 = null;
            }
            label142:
            localObject3 = localObject4;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              if (str.contains("app_userid")) {
                break label215;
              }
            }
          }
          label196:
          label205:
          label215:
          for (localObject3 = null;; localObject3 = b(str))
          {
            i++;
            localObject4 = localObject3;
            localObject6 = paramString;
            localObject5 = localObject1;
            localObject3 = localObject2;
            break;
            paramString = b(str);
            break label84;
            localObject1 = b(str);
            break label107;
            localObject2 = b(str);
            break label142;
          }
        }
        paramString = new StringBuilder();
        if (!TextUtils.isEmpty((CharSequence)localObject6)) {
          paramString.append("biz_type=" + (String)localObject6 + ";");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
          paramString.append("biz_no=" + (String)localObject5 + ";");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          paramString.append("trade_no=" + (String)localObject3 + ";");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          paramString.append("app_userid=" + (String)localObject4 + ";");
        }
        Object localObject1 = paramString.toString();
        paramString = (String)localObject1;
        if (((String)localObject1).endsWith(";")) {
          paramString = ((String)localObject1).substring(0, ((String)localObject1).length() - 1);
        }
      }
    }
  }
  
  private static String b(String paramString)
  {
    Object localObject = paramString.split("=");
    paramString = null;
    if (localObject.length > 1)
    {
      localObject = localObject[1];
      paramString = (String)localObject;
      if (((String)localObject).contains("\"")) {
        paramString = ((String)localObject).replaceAll("\"", "");
      }
    }
    return paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */