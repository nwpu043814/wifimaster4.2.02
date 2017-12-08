package com.wifipay.wallet.paypassword.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.wifipay.R.drawable;
import com.wifipay.R.style;
import com.wifipay.framework.b.a.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WPKeyBoardTable
  extends LinearLayout
  implements View.OnClickListener, View.OnLongClickListener
{
  public boolean a = false;
  public onKeyClick b;
  private int c = -3750202;
  private int d;
  private int e;
  private Map<Integer, View> f = new HashMap();
  
  public WPKeyBoardTable(Context paramContext, int paramInt1, int paramInt2, List<b> paramList)
  {
    super(paramContext);
    this.d = paramInt1;
    this.e = paramInt2;
    b(paramList);
  }
  
  private View a(b paramb)
  {
    Object localObject;
    if ("btn".equals(paramb.a))
    {
      localObject = new ImageView(getContext());
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER);
      ((ImageView)localObject).setImageResource(paramb.b);
      ((ImageView)localObject).setBackgroundResource(R.drawable.wifipay_password_delete_key_bg);
      ((ImageView)localObject).setOnLongClickListener(this);
      paramb = (b)localObject;
    }
    for (;;)
    {
      return paramb;
      localObject = new TextView(getContext());
      ((TextView)localObject).setGravity(17);
      ((TextView)localObject).setTextAppearance(getContext(), R.style.wifipay_font_353535_94);
      if ("empty".equals(paramb.a))
      {
        ((TextView)localObject).setText("");
        ((TextView)localObject).setEnabled(false);
        ((TextView)localObject).setBackgroundResource(R.drawable.wifipay_password_delete_key_bg);
        paramb = (b)localObject;
      }
      else
      {
        ((TextView)localObject).setEnabled(true);
        ((TextView)localObject).setText(String.valueOf(paramb.b));
        ((TextView)localObject).setBackgroundResource(R.drawable.wifipay_password_key_bg);
        paramb = (b)localObject;
      }
    }
  }
  
  private void b(List<b> paramList)
  {
    setBackgroundColor(this.c);
    setOrientation(1);
    for (int i = 0; i < this.d; i++)
    {
      LinearLayout localLinearLayout = new LinearLayout(getContext());
      localLinearLayout.setOrientation(0);
      localLinearLayout.setGravity(17);
      addView(localLinearLayout, new LinearLayout.LayoutParams(-1, 0, 1.0F));
      for (int j = 0; j < this.e; j++)
      {
        Object localObject = (b)paramList.get(this.e * i + j);
        View localView = a((b)localObject);
        localView.setTag(((b)localObject).c);
        localView.setClickable(true);
        localView.setOnClickListener(this);
        localObject = new LinearLayout.LayoutParams(0, -1, 1.0F);
        ((LinearLayout.LayoutParams)localObject).setMargins(1, 1, 1, 1);
        ((LinearLayout.LayoutParams)localObject).gravity = 17;
        this.f.put(Integer.valueOf(this.e * i + j), localView);
        localLinearLayout.addView(localView, (ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  public void a(List<b> paramList)
  {
    for (int i = 0; i < this.d; i++) {
      for (int j = 0; j < this.e; j++)
      {
        b localb = (b)paramList.get(this.e * i + j);
        ((View)this.f.get(Integer.valueOf(this.e * i + j))).setTag(localb.c);
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    int k = getWidth();
    int n = getHeight();
    int m = (k + 0) / this.e;
    int j = n / this.d;
    Paint localPaint = new Paint();
    localPaint.setColor(this.c);
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setStrokeWidth(1.0F);
    for (int i = 1; i < this.e; i++) {
      paramCanvas.drawLine(m * i + 0, 0.0F, m * i + 0, n, localPaint);
    }
    for (i = 0; i < this.d; i++) {
      paramCanvas.drawLine(0.0F, j * i + 0, k + 0, j * i + 0, localPaint);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if ("btn".equals(paramView)) {
      if (this.a) {
        this.b.deletePassword(true);
      }
    }
    for (;;)
    {
      return;
      this.b.deletePassword(false);
      continue;
      if (!"empty".equals(paramView)) {
        this.b.addPassword(paramView);
      }
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if ("btn".equals((String)paramView.getTag())) {
      this.b.deletePassword(true);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void setListener(onKeyClick paramonKeyClick)
  {
    this.b = paramonKeyClick;
  }
  
  public static abstract interface onKeyClick
  {
    public abstract void addPassword(String paramString);
    
    public abstract void deletePassword(boolean paramBoolean);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/widget/WPKeyBoardTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */