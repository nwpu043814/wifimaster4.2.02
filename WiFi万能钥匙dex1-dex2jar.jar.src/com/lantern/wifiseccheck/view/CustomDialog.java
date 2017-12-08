package com.lantern.wifiseccheck.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.vpn.utils.ResTool;

public class CustomDialog
  extends Dialog
{
  private CustomDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  private CustomDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public static class Builder
  {
    private View contentView;
    private Context context;
    private String message;
    private String message2;
    private DialogInterface.OnClickListener negativeButtonClickListener;
    private String negativeButtonText;
    private DialogInterface.OnClickListener positiveButtonClickListener;
    private String positiveButtonText;
    private String title;
    private TextView tvMessage2;
    
    public Builder(Context paramContext)
    {
      this.context = paramContext;
    }
    
    public CustomDialog create()
    {
      Object localObject = (LayoutInflater)this.context.getSystemService("layout_inflater");
      CustomDialog localCustomDialog = new CustomDialog(this.context, ResTool.getStyleId("Dialog", this.context), null);
      localObject = ((LayoutInflater)localObject).inflate(ResTool.getLayoutId("sc_dialog_normal_layout", this.context), null);
      localCustomDialog.addContentView((View)localObject, new ViewGroup.LayoutParams(-1, -2));
      ((TextView)((View)localObject).findViewById(ResTool.getViewId("title", this.context))).setText(this.title);
      if (this.positiveButtonText != null)
      {
        ((Button)((View)localObject).findViewById(ResTool.getViewId("positiveButton", this.context))).setText(this.positiveButtonText);
        ((Button)((View)localObject).findViewById(ResTool.getViewId("positiveButton", this.context))).setOnClickListener(new CustomDialog.Builder.1(this, localCustomDialog));
        if (this.negativeButtonText == null) {
          break label326;
        }
        ((Button)((View)localObject).findViewById(ResTool.getViewId("negativeButton", this.context))).setText(this.negativeButtonText);
        ((Button)((View)localObject).findViewById(ResTool.getViewId("negativeButton", this.context))).setOnClickListener(new CustomDialog.Builder.2(this, localCustomDialog));
        label204:
        if (this.message == null) {
          break label377;
        }
        ((TextView)((View)localObject).findViewById(ResTool.getViewId("message", this.context))).setText(this.message);
        this.tvMessage2 = ((TextView)((View)localObject).findViewById(ResTool.getViewId("message2", this.context)));
        if (this.message2 == null) {
          break label365;
        }
        this.tvMessage2.setVisibility(0);
        this.tvMessage2.setText(this.message2);
      }
      for (;;)
      {
        localCustomDialog.setContentView((View)localObject);
        return localCustomDialog;
        ((View)localObject).findViewById(ResTool.getViewId("positiveButton", this.context)).setVisibility(8);
        ((View)localObject).findViewById(ResTool.getViewId("devider_line", this.context)).setVisibility(8);
        break;
        label326:
        ((View)localObject).findViewById(ResTool.getViewId("negativeButton", this.context)).setVisibility(8);
        ((View)localObject).findViewById(ResTool.getViewId("devider_line", this.context)).setVisibility(8);
        break label204;
        label365:
        this.tvMessage2.setVisibility(8);
        continue;
        label377:
        if (this.contentView != null)
        {
          LogUtils.d("SettingAct", "add content view ");
          ((LinearLayout)((View)localObject).findViewById(ResTool.getViewId("content", this.context))).removeAllViews();
          ((LinearLayout)((View)localObject).findViewById(ResTool.getViewId("content", this.context))).addView(this.contentView, new ViewGroup.LayoutParams(-1, -1));
          this.contentView.setVisibility(0);
        }
      }
    }
    
    public Builder setContentView(View paramView)
    {
      this.contentView = paramView;
      return this;
    }
    
    public Builder setMessage(int paramInt)
    {
      this.message = ((String)this.context.getText(paramInt));
      return this;
    }
    
    public Builder setMessage(String paramString)
    {
      this.message = paramString;
      return this;
    }
    
    public Builder setMessage2(String paramString)
    {
      this.message2 = paramString;
      return this;
    }
    
    public Builder setNegativeButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.negativeButtonText = ((String)this.context.getText(paramInt));
      this.negativeButtonClickListener = paramOnClickListener;
      return this;
    }
    
    public Builder setNegativeButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.negativeButtonText = paramString;
      this.negativeButtonClickListener = paramOnClickListener;
      return this;
    }
    
    public Builder setPositiveButton(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.positiveButtonText = ((String)this.context.getText(paramInt));
      this.positiveButtonClickListener = paramOnClickListener;
      return this;
    }
    
    public Builder setPositiveButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.positiveButtonText = paramString;
      this.positiveButtonClickListener = paramOnClickListener;
      return this;
    }
    
    public Builder setTitle(int paramInt)
    {
      this.title = ((String)this.context.getText(paramInt));
      return this;
    }
    
    public Builder setTitle(String paramString)
    {
      this.title = paramString;
      return this;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/view/CustomDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */