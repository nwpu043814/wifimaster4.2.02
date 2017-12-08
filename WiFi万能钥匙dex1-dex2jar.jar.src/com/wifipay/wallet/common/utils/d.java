package com.wifipay.wallet.common.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.wifipay.R.drawable;
import com.wifipay.common.a.g;
import com.wifipay.common.security.Base64;
import com.wifipay.wallet.home.widget.image.SmartImageView;
import com.wifipay.wallet.prod.core.model.PayCard;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class d
{
  public static int a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (g.a(paramString1)) {
      str = "0";
    }
    paramString1 = paramString2;
    if (g.a(paramString2)) {
      paramString1 = "0";
    }
    if ((!a(str)) || (!a(paramString1))) {
      throw new IllegalArgumentException("compareNumberString argument error");
    }
    float f1 = Float.valueOf(str).floatValue();
    float f2 = Float.valueOf(paramString1).floatValue();
    int i;
    if (f1 < f2) {
      i = -1;
    }
    for (;;)
    {
      return i;
      if (f1 > f2) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public static SpannableString a(SpannableString paramSpannableString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= 0) && (paramInt2 > paramInt1)) {
      paramSpannableString.setSpan(new ForegroundColorSpan(paramInt3), paramInt1, paramInt1 + paramInt2, 33);
    }
    return paramSpannableString;
  }
  
  public static SpannableString a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(new SpannableString(paramString), paramInt1, paramInt2, paramInt3);
  }
  
  public static String a(int paramInt, String paramString)
  {
    return new BigDecimal(paramString).setScale(paramInt, 4).toPlainString();
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, "yyyy-MM-dd HH:mm:ss:SSS");
  }
  
  public static String a(long paramLong, String paramString)
  {
    Date localDate = new Date();
    paramString = new SimpleDateFormat(paramString);
    long l = paramLong;
    if (paramLong < 1000000000000L) {
      l = paramLong * 1000L;
    }
    localDate.setTime(l);
    return paramString.format(localDate);
  }
  
  public static void a(EditText paramEditText)
  {
    paramEditText.addTextChangedListener(new e(paramEditText));
  }
  
  public static void a(PayCard paramPayCard, ImageView paramImageView, TextView paramTextView)
  {
    int i = paramPayCard.getLogo();
    if (i != 0)
    {
      paramImageView.setVisibility(0);
      if (i == 1) {
        ((SmartImageView)paramImageView).a(h(paramPayCard.bankCode), R.drawable.wifipay_banklogo_default);
      }
    }
    for (;;)
    {
      paramTextView.setText(paramPayCard.getName());
      return;
      paramImageView.setImageResource(paramPayCard.getLogo());
      continue;
      paramImageView.setVisibility(8);
    }
  }
  
  public static boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean a(String paramString)
  {
    if ((b(paramString)) || (c(paramString))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      Long.parseLong(paramString);
      bool = true;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return bool;
  }
  
  public static boolean c(String paramString)
  {
    boolean bool1 = false;
    try
    {
      Double.parseDouble(paramString);
      boolean bool2 = paramString.contains(".");
      if (bool2) {
        bool1 = true;
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
    return bool1;
  }
  
  public static String d(String paramString)
  {
    String str = paramString;
    if (f.c(paramString)) {
      str = paramString.replaceAll("(.)(.*)(@.*)", "$1*$3");
    }
    return str;
  }
  
  public static String e(String paramString)
  {
    return a(2, paramString);
  }
  
  public static Bitmap f(String paramString)
  {
    Object localObject = null;
    if (g.a(paramString)) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      byte[] arrayOfByte = Base64.decode(paramString);
      paramString = (String)localObject;
      if (arrayOfByte != null)
      {
        paramString = (String)localObject;
        if (arrayOfByte.length != 0) {
          paramString = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
        }
      }
    }
  }
  
  public static String g(String paramString)
  {
    String str = paramString;
    if (f.b(paramString)) {
      str = paramString.replaceAll("(\\d{3})(\\d{4})", "$1****");
    }
    return str;
  }
  
  public static String h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = "http://ebinfonew.shengpay.com/bank_pic/" + paramString.toLowerCase() + "/log/log.png") {
      return paramString;
    }
  }
  
  public static String i(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = "http://ebinfonew.shengpay.com//bank_pic/bank_bg/" + paramString.toLowerCase() + ".png") {
      return paramString;
    }
  }
  
  public static String j(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    for (;;)
    {
      return str;
      str = paramString;
      if (paramString.length() > 1) {
        str = paramString.replace(paramString.substring(0, 1), "*");
      }
    }
  }
  
  public static String k(String paramString)
  {
    String str = paramString;
    if (f.b(paramString)) {
      str = paramString.replace(paramString.substring(3, 7), "****");
    }
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "";
    }
    return paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/utils/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */