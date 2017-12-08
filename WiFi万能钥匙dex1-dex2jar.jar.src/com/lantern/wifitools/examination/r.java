package com.lantern.wifitools.examination;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import bluefay.app.Fragment;
import com.bluefay.b.d;
import com.lantern.wifitools.R.animator;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.string;
import java.text.DecimalFormat;
import org.json.JSONException;
import org.json.JSONObject;

public final class r
{
  public static String a(int paramInt)
  {
    return (paramInt & 0xFF) + "." + (paramInt >> 8 & 0xFF) + "." + (paramInt >> 16 & 0xFF) + "." + (paramInt >> 24 & 0xFF);
  }
  
  public static String a(int paramInt, Context paramContext)
  {
    if (paramInt < 1000) {}
    float f;
    DecimalFormat localDecimalFormat;
    for (paramContext = String.format(paramContext.getString(R.string.exam_speed_text), new Object[] { Integer.valueOf(paramInt) });; paramContext = String.format(paramContext.getString(R.string.exam_speed_text_m), new Object[] { localDecimalFormat.format(f) }))
    {
      return paramContext;
      f = paramInt / 1024.0F;
      localDecimalFormat = new DecimalFormat("0.##");
    }
  }
  
  public static String a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localSharedPreferences = paramContext.getSharedPreferences("SIMPLE_SPEED_TEST", 0);
        if (localSharedPreferences == null) {
          continue;
        }
        paramContext = localSharedPreferences.getString("urls", "");
        long l = localSharedPreferences.getLong("time", 0L);
        if ((TextUtils.isEmpty(paramContext)) || (System.currentTimeMillis() - l >= 86400000L)) {
          continue;
        }
      }
      catch (JSONException paramContext)
      {
        SharedPreferences localSharedPreferences;
        String str;
        paramContext.printStackTrace();
        paramContext = "http://www.baidu.com";
        continue;
      }
      return paramContext;
      str = d.a("http://wifi01.51y5.com/app2/apnetspeed.php", null);
      paramContext = new org/json/JSONObject;
      paramContext.<init>(str);
      str = paramContext.getString("urls");
      paramContext = str;
      if (localSharedPreferences != null)
      {
        paramContext = localSharedPreferences.edit();
        paramContext.putString("urls", str);
        paramContext.putLong("time", System.currentTimeMillis());
        paramContext.apply();
        paramContext = str;
      }
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, String paramString, boolean paramBoolean)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      FragmentTransaction localFragmentTransaction = paramActivity.getFragmentManager().beginTransaction();
      if (!paramBoolean)
      {
        localFragmentTransaction.addToBackStack(null);
        localFragmentTransaction.setCustomAnimations(R.animator.framework_fragment_slide_left_enter_no_alpha, R.animator.framework_fragment_slide_left_exit_no_alpha, R.animator.framework_fragment_slide_right_enter_no_alpha, R.animator.framework_fragment_slide_right_exit_no_alpha);
      }
      localFragmentTransaction.replace(R.id.fragment_container, Fragment.instantiate(paramActivity, paramString, paramBundle));
      localFragmentTransaction.commitAllowingStateLoss();
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramString = new Intent("wifi.intent.action.BROWSER", Uri.parse(paramString));
    paramString.setPackage(paramContext.getPackageName());
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("showoptionmenu", false);
    paramString.putExtras(localBundle);
    paramContext.startActivity(paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */