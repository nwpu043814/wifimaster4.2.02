package com.wifipay.wallet.paypassword.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.shengpay.crypto.JNICrypto;
import com.wifipay.R.dimen;
import com.wifipay.R.drawable;
import com.wifipay.R.styleable;
import com.wifipay.common.a.g;
import com.wifipay.framework.api.BackgroundExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WPSafeKeyboard
  extends LinearLayout
  implements WPKeyBoardTable.onKeyClick
{
  private int a = 6;
  private boolean b = true;
  private onPasswordChanged c;
  private ArrayList<String> d;
  private String e;
  private WPKeyBoardTable f;
  private com.wifipay.framework.api.d g = new com.wifipay.framework.api.d(new b(this));
  private View.OnClickListener h = new c(this);
  
  public WPSafeKeyboard(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WPSafeKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }
  
  public WPSafeKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WPSafeKeyboard, paramInt, 0);
    this.a = paramContext.getInt(R.styleable.WPSafeKeyboard_wifipay_passwordLength, 6);
    paramContext.recycle();
  }
  
  private void a(Context paramContext, List<com.wifipay.framework.b.a.b> paramList)
  {
    if (this.f != null) {
      removeAllViews();
    }
    setOrientation(1);
    setGravity(17);
    Object localObject = new View(paramContext);
    ((View)localObject).setBackgroundColor(-3750202);
    addView((View)localObject, new LinearLayout.LayoutParams(-1, 1));
    localObject = new LinearLayout(paramContext);
    ((LinearLayout)localObject).setBackgroundResource(R.drawable.wifipay_virtual_keyboard_hide_bg);
    ((LinearLayout)localObject).setGravity(17);
    addView((View)localObject, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.wifipay_xxh_space_98px)));
    paramContext = new ImageView(paramContext);
    paramContext.setImageResource(R.drawable.wifipay_password_keyboard_hide);
    paramContext.setScaleType(ImageView.ScaleType.CENTER);
    int i = getResources().getDimensionPixelOffset(R.dimen.wifipay_padding_20);
    paramContext.setPadding(i, 0, i, 0);
    ((LinearLayout)localObject).setOnClickListener(this.h);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    ((LinearLayout)localObject).addView(paramContext, localLayoutParams);
    this.f = new WPKeyBoardTable(getContext(), 4, 3, paramList);
    this.f.setListener(this);
    paramContext = new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.wifipay_xxh_space_178px) * 4);
    addView(this.f, paramContext);
  }
  
  private List<com.wifipay.framework.b.a.b> e()
  {
    int[] arrayOfInt = new int[10];
    int[] tmp8_6 = arrayOfInt;
    tmp8_6[0] = 1;
    int[] tmp12_8 = tmp8_6;
    tmp12_8[1] = 2;
    int[] tmp16_12 = tmp12_8;
    tmp16_12[2] = 3;
    int[] tmp20_16 = tmp16_12;
    tmp20_16[3] = 4;
    int[] tmp24_20 = tmp20_16;
    tmp24_20[4] = 5;
    int[] tmp28_24 = tmp24_20;
    tmp28_24[5] = 6;
    int[] tmp33_28 = tmp28_24;
    tmp33_28[6] = 7;
    int[] tmp39_33 = tmp33_28;
    tmp39_33[7] = 8;
    int[] tmp45_39 = tmp39_33;
    tmp45_39[8] = 9;
    int[] tmp51_45 = tmp45_39;
    tmp51_45[9] = 0;
    tmp51_45;
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = JNICrypto.createRandomArray(10);
    for (int i = 0; i < 9; i++) {
      localArrayList.add(new com.wifipay.framework.b.a.b("text", arrayOfInt[i], arrayOfString[(i + 1)]));
    }
    localArrayList.add(new com.wifipay.framework.b.a.b("empty", -1, "empty"));
    localArrayList.add(new com.wifipay.framework.b.a.b("text", arrayOfInt[9], arrayOfString[0]));
    localArrayList.add(new com.wifipay.framework.b.a.b("btn", R.drawable.wifipay_password_keyboard_delete, "btn"));
    return localArrayList;
  }
  
  public void a()
  {
    this.d = new ArrayList(this.a);
    JNICrypto.initCrypto(this.a, "Prod");
    List localList = e();
    a(getContext(), localList);
  }
  
  public void addPassword(String paramString)
  {
    if (this.f.a) {
      this.f.a = false;
    }
    if (this.d.size() == this.a) {}
    for (;;)
    {
      return;
      if (this.d.size() < this.a)
      {
        paramString = JNICrypto.inputEncrypt(paramString);
        this.d.add(paramString);
        this.c.addPassword();
      }
      if (this.d.size() == this.a)
      {
        this.c.onCompletedAdd();
        BackgroundExecutor.a(new d(this, "ticket", 0, null));
        this.g.a(2, 30000L);
      }
    }
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void c()
  {
    if (b())
    {
      this.b = false;
      setVisibility(4);
    }
  }
  
  public void d()
  {
    if (!b())
    {
      this.b = true;
      setVisibility(0);
    }
  }
  
  public void deletePassword(boolean paramBoolean)
  {
    if (!g.a(this.e)) {
      this.e = null;
    }
    if (this.d.size() == 0) {}
    label114:
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
          JNICrypto.deleteEncrypt((String)localIterator.next());
        }
        this.d.clear();
      }
      for (;;)
      {
        if (this.c == null) {
          break label114;
        }
        this.c.deletePassword(paramBoolean);
        break;
        JNICrypto.deleteEncrypt((String)this.d.remove(this.d.size() - 1));
      }
    }
  }
  
  public String getPassword()
  {
    return this.e;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    BackgroundExecutor.a("ticket", true);
  }
  
  public void setListener(onPasswordChanged paramonPasswordChanged)
  {
    this.c = paramonPasswordChanged;
  }
  
  public static abstract interface onPasswordChanged
  {
    public abstract void addPassword();
    
    public abstract void deletePassword(boolean paramBoolean);
    
    public abstract void onCompleted(boolean paramBoolean);
    
    public abstract void onCompletedAdd();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/widget/WPSafeKeyboard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */