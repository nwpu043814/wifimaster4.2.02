package com.lantern.wifiseccheck.vpn.utils;

import android.app.ActionBar.LayoutParams;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lantern.wifiseccheck.LogUtils;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UIUtils
{
  public static final int DAY = 1;
  public static final int MONTH = 2;
  private static String TAG = "UIUtils";
  private static Intent intent = null;
  
  public static final void collapseStatusBar(Context paramContext)
  {
    Object localObject = paramContext.getSystemService("statusbar");
    for (;;)
    {
      try
      {
        paramContext = Class.forName("android.app.StatusBarManager");
        if (Build.VERSION.SDK_INT >= 17)
        {
          paramContext = paramContext.getMethod("collapsePanels", new Class[0]);
          paramContext.invoke(localObject, new Object[0]);
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        continue;
      }
      paramContext = paramContext.getMethod("collapse", new Class[0]);
    }
  }
  
  public static Dialog createLoadingDialog(Context paramContext, int paramInt)
  {
    return createLoadingDialog(paramContext, paramContext.getString(paramInt));
  }
  
  public static Dialog createLoadingDialog(Context paramContext, String paramString)
  {
    View localView = LayoutInflater.from(paramContext).inflate(ResTool.getLayoutId("sc_progress_dialog", paramContext), null);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(ResTool.getViewId("dialog_view", paramContext));
    ((TextView)localView.findViewById(ResTool.getViewId("tipTextView", paramContext))).setText(paramString);
    paramContext = new Dialog(paramContext, ResTool.getStyleId("loading_dialog", paramContext));
    paramContext.setCancelable(false);
    paramContext.setContentView(localLinearLayout, new ActionBar.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static String formatDateTime(long paramLong)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
    new SimpleDateFormat("MM-dd HH:mm");
    new SimpleDateFormat("yyyy-MM-dd HH:mm");
    Object localObject = new SimpleDateFormat("HH:mm   MM/dd");
    Date localDate = new Date(paramLong);
    Calendar localCalendar2 = Calendar.getInstance();
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.set(1, localCalendar2.get(1));
    localCalendar1.set(2, localCalendar2.get(2));
    localCalendar1.set(5, localCalendar2.get(5));
    localCalendar1.set(11, 0);
    localCalendar1.set(12, 0);
    localCalendar1.set(13, 0);
    Calendar localCalendar3 = Calendar.getInstance();
    localCalendar3.set(1, localCalendar2.get(1));
    localCalendar3.set(2, localCalendar2.get(2));
    localCalendar3.set(5, localCalendar2.get(5) - 1);
    localCalendar3.set(11, 0);
    localCalendar3.set(12, 0);
    localCalendar3.set(13, 0);
    localCalendar2.setTime(localDate);
    if (localCalendar2.after(localCalendar1)) {
      localObject = localSimpleDateFormat.format(localDate);
    }
    for (;;)
    {
      return (String)localObject;
      if ((localCalendar2.before(localCalendar1)) && (localCalendar2.after(localCalendar3))) {
        localObject = localSimpleDateFormat.format(localDate) + "   昨天 ";
      } else {
        localObject = ((DateFormat)localObject).format(localDate);
      }
    }
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = dip2px(paramContext, 23.0F);
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static long getTimestamp(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    switch (paramInt)
    {
    default: 
      LogUtils.d(TAG, "unSupport stamp");
    }
    for (;;)
    {
      return localCalendar.getTimeInMillis();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      continue;
      localCalendar.set(5, 1);
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
    }
  }
  
  public static boolean isLollipopOrAbove()
  {
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isOverOneDay(long paramLong1, long paramLong2)
  {
    boolean bool = false;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong2);
    int m = localCalendar.get(6);
    int j = localCalendar.get(1);
    localCalendar.setTimeInMillis(paramLong1);
    int k = localCalendar.get(6);
    int i = localCalendar.get(1);
    if (j < i) {}
    for (;;)
    {
      return bool;
      if (j == i)
      {
        if (k < m) {
          bool = true;
        }
      }
      else {
        bool = true;
      }
    }
  }
  
  public static boolean isScreenOriatationLandscape(Context paramContext)
  {
    if (paramContext.getResources().getConfiguration().orientation == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void launchWifiKey(Context paramContext)
  {
    Intent localIntent = new Intent("wifi.intent.action.STICKY_SERVICE");
    localIntent.setPackage("com.snda.wifilocating");
    localIntent.putExtra("source", paramContext.getPackageName());
    paramContext.startService(localIntent);
  }
  
  public static int px2dip(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static void showDialog(Context paramContext)
  {
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setMessage("等待功能开发！！");
    paramContext.setPositiveButton("确定", null);
    paramContext.show();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/utils/UIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */