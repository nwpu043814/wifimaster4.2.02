package com.wifipay.wallet.home.widget.image;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SmartImageView
  extends ImageView
{
  private static ExecutorService a = Executors.newFixedThreadPool(4);
  private c b;
  private b c;
  
  public SmartImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SmartImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SmartImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(SmartImage paramSmartImage, Integer paramInteger1, Integer paramInteger2, c.b paramb)
  {
    if (paramInteger2 != null) {
      setImageResource(paramInteger2.intValue());
    }
    if (this.b != null)
    {
      this.b.a();
      this.b = null;
    }
    this.b = new c(getContext(), paramSmartImage);
    this.b.a(new d(this, paramInteger1, paramb));
    a.execute(this.b);
  }
  
  public void a(String paramString, int paramInt)
  {
    setImage(new e(paramString, paramInt));
  }
  
  public boolean performClick()
  {
    boolean bool = super.performClick();
    if (bool)
    {
      if (this.c == null) {
        this.c = new b(this);
      }
      this.c.a();
    }
    return bool;
  }
  
  public void setImage(SmartImage paramSmartImage)
  {
    a(paramSmartImage, null, null, null);
  }
  
  public void setImageContact(long paramLong)
  {
    setImage(new a(paramLong));
  }
  
  public void setImageUrl(String paramString)
  {
    setImage(new e(paramString));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/image/SmartImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */