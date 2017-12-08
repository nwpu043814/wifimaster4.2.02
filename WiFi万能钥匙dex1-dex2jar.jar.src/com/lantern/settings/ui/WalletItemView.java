package com.lantern.settings.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.styleable;

public class WalletItemView
  extends RelativeLayout
{
  private ImageView a;
  private TextView b;
  
  public WalletItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(R.layout.settings_item_wallet, this, true);
    this.a = ((ImageView)findViewById(R.id.settings_wallet_item_icon));
    this.b = ((TextView)findViewById(R.id.setttings_wallet_item_summary));
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.setting_wallet);
    this.a.setImageDrawable(paramContext.getDrawable(0));
    this.b.setText(paramContext.getText(1));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/WalletItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */