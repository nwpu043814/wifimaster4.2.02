package android.support.v13.app;

import android.app.Fragment;
import android.os.Build.VERSION;

public class FragmentCompat
{
  static final FragmentCompatImpl IMPL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 15) {
      IMPL = new ICSMR1FragmentCompatImpl();
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 14) {
        IMPL = new ICSFragmentCompatImpl();
      } else {
        IMPL = new BaseFragmentCompatImpl();
      }
    }
  }
  
  public static void setMenuVisibility(Fragment paramFragment, boolean paramBoolean)
  {
    IMPL.setMenuVisibility(paramFragment, paramBoolean);
  }
  
  public static void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean)
  {
    IMPL.setUserVisibleHint(paramFragment, paramBoolean);
  }
  
  static class BaseFragmentCompatImpl
    implements FragmentCompat.FragmentCompatImpl
  {
    public void setMenuVisibility(Fragment paramFragment, boolean paramBoolean) {}
    
    public void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean) {}
  }
  
  static abstract interface FragmentCompatImpl
  {
    public abstract void setMenuVisibility(Fragment paramFragment, boolean paramBoolean);
    
    public abstract void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean);
  }
  
  static class ICSFragmentCompatImpl
    extends FragmentCompat.BaseFragmentCompatImpl
  {
    public void setMenuVisibility(Fragment paramFragment, boolean paramBoolean)
    {
      FragmentCompatICS.setMenuVisibility(paramFragment, paramBoolean);
    }
  }
  
  static class ICSMR1FragmentCompatImpl
    extends FragmentCompat.ICSFragmentCompatImpl
  {
    public void setUserVisibleHint(Fragment paramFragment, boolean paramBoolean)
    {
      FragmentCompatICSMR1.setUserVisibleHint(paramFragment, paramBoolean);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v13/app/FragmentCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */