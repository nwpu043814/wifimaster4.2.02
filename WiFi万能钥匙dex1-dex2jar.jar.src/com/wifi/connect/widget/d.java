package com.wifi.connect.widget;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import bluefay.app.k;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.lantern.connect.R.drawable;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;
import com.lantern.connect.R.string;
import java.security.MessageDigest;
import java.util.Locale;

public final class d
  extends k
{
  private static String c = "http://master.lianwifi.com/act";
  private View a;
  private ImageView b;
  private boolean d = false;
  private boolean e = true;
  private Context f;
  private TextView g;
  private TextView h;
  private Button i;
  
  public d(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext);
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramContext;
  }
  
  private static String a(PackageInfo paramPackageInfo)
  {
    try
    {
      Object localObject = paramPackageInfo.signatures;
      paramPackageInfo = MessageDigest.getInstance("SHA-1");
      int k = localObject.length;
      for (int j = 0; j < k; j++) {
        paramPackageInfo.update(localObject[j].toByteArray());
      }
      byte[] arrayOfByte = paramPackageInfo.digest();
      localObject = "";
      j = 0;
      if (j < arrayOfByte.length)
      {
        paramPackageInfo = Integer.toHexString(arrayOfByte[j] & 0xFF);
        StringBuilder localStringBuilder;
        if (paramPackageInfo.length() == 1)
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
        }
        for (paramPackageInfo = (String)localObject + "0" + paramPackageInfo;; paramPackageInfo = (String)localObject + paramPackageInfo)
        {
          localObject = paramPackageInfo;
          if (j < arrayOfByte.length - 1)
          {
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            localObject = paramPackageInfo + ":";
          }
          j++;
          break;
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
        }
      }
      paramPackageInfo = ((String)localObject).toUpperCase(Locale.getDefault());
    }
    catch (Exception paramPackageInfo)
    {
      for (;;)
      {
        h.a(paramPackageInfo);
        paramPackageInfo = "";
      }
    }
    return paramPackageInfo;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    a.e().onEvent("keysh9");
    this.a = getLayoutInflater().inflate(R.layout.connect_share_success_dialog, null);
    a(this.a);
    this.g = ((TextView)this.a.findViewById(R.id.connect_share_title));
    this.h = ((TextView)this.a.findViewById(R.id.connect_share_msg));
    this.i = ((Button)this.a.findViewById(R.id.btn_go_apmaster));
    this.a.findViewById(R.id.close).setOnClickListener(new e(this));
    if (this.d)
    {
      this.g.setText(R.string.connect_share_title);
      if (!this.e) {
        break label273;
      }
      this.h.setText(R.string.connect_share_msg_success);
      this.i.setVisibility(8);
    }
    for (;;)
    {
      this.i.setOnClickListener(new f(this));
      super.onCreate(paramBundle);
      this.b = ((ImageView)this.a.findViewById(R.id.rotate_ic));
      paramBundle = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      paramBundle.setDuration(6000L);
      paramBundle.setRepeatCount(-1);
      paramBundle.setInterpolator(new LinearInterpolator());
      this.b.startAnimation(paramBundle);
      getWindow().setBackgroundDrawableResource(R.drawable.transparent);
      paramBundle = getWindow();
      WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
      localLayoutParams.dimAmount = 0.8F;
      paramBundle.setAttributes(localLayoutParams);
      paramBundle.addFlags(2);
      return;
      label273:
      this.h.setText(R.string.connect_share_msg_fail);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */