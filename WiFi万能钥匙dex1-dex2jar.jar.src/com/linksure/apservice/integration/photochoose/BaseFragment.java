package com.linksure.apservice.integration.photochoose;

import android.content.DialogInterface.OnCancelListener;
import bluefay.app.Fragment;
import com.bluefay.material.f;

public class BaseFragment
  extends Fragment
{
  private f g;
  
  protected final void a(String paramString)
  {
    try
    {
      Object localObject = new com/bluefay/material/f;
      ((f)localObject).<init>(getActivity());
      this.g = ((f)localObject);
      this.g.a(paramString);
      this.g.setCanceledOnTouchOutside(false);
      paramString = this.g;
      localObject = new com/linksure/apservice/integration/photochoose/a;
      ((a)localObject).<init>(this);
      paramString.setOnCancelListener((DialogInterface.OnCancelListener)localObject);
      this.g.show();
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  protected final void c()
  {
    try
    {
      if (this.g != null)
      {
        this.g.dismiss();
        this.g = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/BaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */