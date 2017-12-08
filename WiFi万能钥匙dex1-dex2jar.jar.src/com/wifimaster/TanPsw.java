package com.wifimaster;

import android.app.AlertDialog.Builder;
import android.app.Application;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TanPsw
{
  public static void Cliptext(Context paramContext, String paramString)
  {
    ((ClipboardManager)paramContext.getSystemService("clipboard")).setText(paramString);
  }
  
  public static void Password(Context paramContext, final String paramString)
  {
    if (!paramString.isEmpty())
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
      localBuilder.setTitle("获取密码成功");
      Button localButton = new Button(paramContext);
      localButton.setText("点击下载掌玩小子");
      localButton.setTextSize(20.0F);
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.addView(localButton);
      localBuilder.setView(localLinearLayout);
      localBuilder.setMessage("获取到的Wifi密码为：" + paramString);
      localButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent();
          paramAnonymousView.setAction("android.intent.action.VIEW");
          paramAnonymousView.setData(Uri.parse("http://d.yunapi.org/ibuger_service/comm/d.jsp?k=ibuger_mobilenjoy"));
          TanPsw.this.startActivity(paramAnonymousView);
        }
      });
      localBuilder.setNegativeButton("立即复制", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          TanPsw.Cliptext(TanPsw.this, paramString);
          Toast.makeText(TanPsw.this, "密码复制成功~", 1).show();
        }
      });
      localBuilder.create();
      localBuilder.show();
    }
  }
  
  public static Application getAppliction()
  {
    try
    {
      Object localObject1 = Class.forName("android.app.ActivityThread");
      localObject1 = (Application)((Class)localObject1).getMethod("currentApplication", new Class[0]).invoke(localObject1, new Object[0]);
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("====ok===== 获取包名:");
      localPrintStream.println(((Application)localObject1).getPackageName());
      return (Application)localObject1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        localClassNotFoundException.printStackTrace();
        Object localObject2 = null;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        localNoSuchMethodException.printStackTrace();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localInvocationTargetException.printStackTrace();
      }
    }
  }
  
  private static void startFlick(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(1000L);
      localAlphaAnimation.setInterpolator(new LinearInterpolator());
      localAlphaAnimation.setRepeatCount(-1);
      localAlphaAnimation.setRepeatMode(2);
      paramView.startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifimaster/TanPsw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */