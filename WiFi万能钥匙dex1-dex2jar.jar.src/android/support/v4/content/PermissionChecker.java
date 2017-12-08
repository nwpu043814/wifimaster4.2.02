package android.support.v4.content;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import android.support.v4.app.AppOpsManagerCompat;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionChecker
{
  public static final int PERMISSION_DENIED = -1;
  public static final int PERMISSION_DENIED_APP_OP = -2;
  public static final int PERMISSION_GRANTED = 0;
  
  public static int checkCallingOrSelfPermission(Context paramContext, String paramString)
  {
    if (Binder.getCallingPid() == Process.myPid()) {}
    for (String str = paramContext.getPackageName();; str = null) {
      return checkPermission(paramContext, paramString, Binder.getCallingPid(), Binder.getCallingUid(), str);
    }
  }
  
  public static int checkCallingPermission(Context paramContext, String paramString1, String paramString2)
  {
    if (Binder.getCallingPid() == Process.myPid()) {}
    for (int i = -1;; i = checkPermission(paramContext, paramString1, Binder.getCallingPid(), Binder.getCallingUid(), paramString2)) {
      return i;
    }
  }
  
  public static int checkPermission(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    int i = -1;
    if (paramContext.checkPermission(paramString1, paramInt1, paramInt2) == -1) {
      paramInt1 = i;
    }
    for (;;)
    {
      return paramInt1;
      String str = AppOpsManagerCompat.permissionToOp(paramString1);
      if (str == null)
      {
        paramInt1 = 0;
      }
      else
      {
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          paramString1 = paramContext.getPackageManager().getPackagesForUid(paramInt2);
          paramInt1 = i;
          if (paramString1 != null)
          {
            paramInt1 = i;
            if (paramString1.length > 0) {
              paramString1 = paramString1[0];
            }
          }
        }
        else if (AppOpsManagerCompat.noteProxyOp(paramContext, str, paramString1) != 0)
        {
          paramInt1 = -2;
        }
        else
        {
          paramInt1 = 0;
        }
      }
    }
  }
  
  public static int checkSelfPermission(Context paramContext, String paramString)
  {
    return checkPermission(paramContext, paramString, Process.myPid(), Process.myUid(), paramContext.getPackageName());
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PermissionResult {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/content/PermissionChecker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */