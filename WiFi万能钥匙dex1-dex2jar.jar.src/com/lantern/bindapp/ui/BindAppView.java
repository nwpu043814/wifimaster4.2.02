package com.lantern.bindapp.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import bluefay.widget.BLCheckBox;
import com.bluefay.a.e;
import com.bluefay.b.b;
import com.lantern.core.R.id;
import com.lantern.core.R.layout;
import com.lantern.core.c;
import java.io.File;

public class BindAppView
  extends FrameLayout
{
  private BLCheckBox a;
  private ImageView b;
  private TextView c;
  private TextView d;
  private com.lantern.bindapp.a.a e;
  
  public BindAppView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public BindAppView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public BindAppView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    inflate(getContext(), R.layout.launcher_user_guide_bind_app, this);
    this.a = ((BLCheckBox)findViewById(R.id.vp_kbdown_checkbox));
    this.b = ((ImageView)findViewById(R.id.vp_kbdown_img_apklogo));
    this.c = ((TextView)findViewById(R.id.tv_slogan_main));
    this.d = ((TextView)findViewById(R.id.tv_slogan_sen));
  }
  
  public final void a(com.lantern.bindapp.a.a parama)
  {
    this.e = parama;
    parama = new File(c.getAppCacheDir(), b.c(this.e.c));
    int k;
    int i;
    float f;
    if (parama.exists())
    {
      parama = BitmapFactory.decodeFile(parama.getAbsolutePath());
      if (parama != null)
      {
        int j = e.a(getContext(), 232.0F);
        k = e.a(getContext(), 178.0F);
        int m = parama.getWidth();
        i = parama.getHeight();
        if (m <= i) {
          break label159;
        }
        f = j / m;
        if (f == 1.0F) {
          break label169;
        }
        Bitmap localBitmap = ThumbnailUtils.extractThumbnail(parama, (int)(m * f), (int)(f * i));
        parama.recycle();
        parama = localBitmap;
      }
    }
    label159:
    label169:
    for (;;)
    {
      this.b.setImageBitmap(parama);
      this.c.setText(this.e.g);
      this.d.setText(this.e.h);
      return;
      f = k / i;
      break;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.a.isChecked()) {
      com.lantern.bindapp.a.a(getContext(), this.e);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/bindapp/ui/BindAppView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */