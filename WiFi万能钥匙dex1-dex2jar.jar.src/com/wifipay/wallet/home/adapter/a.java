package com.wifipay.wallet.home.adapter;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.wifipay.R.id;
import com.wifipay.wallet.home.widget.image.SmartImageView;

public class a
{
  public SmartImageView a;
  public TextView b;
  public SmartImageView c;
  public TextView d;
  public RelativeLayout e;
  private Context f;
  
  public a(View paramView, Context paramContext)
  {
    this.f = paramContext;
    if (this.f != null)
    {
      int i = ((WindowManager)this.f.getSystemService("window")).getDefaultDisplay().getWidth();
      paramContext = paramView.getLayoutParams();
      paramContext.height = (i / 3);
      paramView.setLayoutParams(paramContext);
    }
    this.e = ((RelativeLayout)paramView.findViewById(R.id.wifipay_home_content));
    this.a = ((SmartImageView)paramView.findViewById(R.id.wifipay_home_content_item_image));
    this.b = ((TextView)paramView.findViewById(R.id.wifipay_home_content_item_first_text));
    this.c = ((SmartImageView)paramView.findViewById(R.id.wifipay_home_content_item_tag));
    this.d = ((TextView)paramView.findViewById(R.id.wifipay_home_content_item_second_text));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */