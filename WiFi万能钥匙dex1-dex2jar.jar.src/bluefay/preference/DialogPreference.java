package bluefay.preference;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import bluefay.app.k.a;
import com.bluefay.a.e;

public abstract class DialogPreference
  extends Preference
  implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, r.a
{
  private k.a b;
  private CharSequence c;
  private CharSequence d;
  private Drawable e;
  private CharSequence f;
  private CharSequence g;
  private int h;
  private Dialog i;
  private int j;
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842897);
  }
  
  public DialogPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = e.a("com.android.internal.R$styleable", "DialogPreference");
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
      int i1 = ((Integer)e.a("com.android.internal.R$styleable", "DialogPreference_dialogTitle")).intValue();
      int m = ((Integer)e.a("com.android.internal.R$styleable", "DialogPreference_dialogMessage")).intValue();
      int k = ((Integer)e.a("com.android.internal.R$styleable", "DialogPreference_dialogIcon")).intValue();
      int i2 = ((Integer)e.a("com.android.internal.R$styleable", "DialogPreference_positiveButtonText")).intValue();
      int n = ((Integer)e.a("com.android.internal.R$styleable", "DialogPreference_negativeButtonText")).intValue();
      paramInt = ((Integer)e.a("com.android.internal.R$styleable", "DialogPreference_dialogLayout")).intValue();
      this.c = paramContext.getString(i1);
      if (this.c == null) {
        this.c = r();
      }
      this.d = paramContext.getString(m);
      this.e = paramContext.getDrawable(k);
      this.f = paramContext.getString(i2);
      this.g = paramContext.getString(n);
      this.h = paramContext.getResourceId(paramInt, this.h);
      paramContext.recycle();
    }
  }
  
  private void c(Bundle paramBundle)
  {
    Object localObject = null;
    Context localContext = y();
    this.j = -2;
    this.b = new k.a(localContext).a(this.c).a(this.e).a(this.f, this).b(this.g, this);
    if (this.h == 0)
    {
      if (localObject == null) {
        break label165;
      }
      b((View)localObject);
      this.b.a((View)localObject);
    }
    for (;;)
    {
      a(this.b);
      B().a(this);
      localObject = this.b.c();
      this.i = ((Dialog)localObject);
      if (paramBundle != null) {
        ((Dialog)localObject).onRestoreInstanceState(paramBundle);
      }
      if (e()) {
        ((Dialog)localObject).getWindow().setSoftInputMode(5);
      }
      ((Dialog)localObject).setOnDismissListener(this);
      ((Dialog)localObject).show();
      return;
      localObject = LayoutInflater.from(this.b.a()).inflate(this.h, null);
      break;
      label165:
      this.b.b(this.d);
    }
  }
  
  public final void a(int paramInt)
  {
    this.f = y().getString(paramInt);
  }
  
  protected void a(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(SavedState.class))) {
      super.a(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.a(paramParcelable.getSuperState());
      if (paramParcelable.a) {
        c(paramParcelable.b);
      }
    }
  }
  
  protected void a(k.a parama) {}
  
  protected void a(boolean paramBoolean) {}
  
  public final void b()
  {
    this.e = null;
  }
  
  public final void b(int paramInt)
  {
    this.g = y().getString(paramInt);
  }
  
  protected void b(View paramView)
  {
    paramView = paramView.findViewById(16908299);
    if (paramView != null)
    {
      CharSequence localCharSequence = this.d;
      int k = 8;
      if (!TextUtils.isEmpty(localCharSequence))
      {
        if ((paramView instanceof TextView)) {
          ((TextView)paramView).setText(localCharSequence);
        }
        k = 0;
      }
      if (paramView.getVisibility() != k) {
        paramView.setVisibility(k);
      }
    }
  }
  
  public final Drawable c()
  {
    return this.e;
  }
  
  protected final void d()
  {
    if ((this.i != null) && (this.i.isShowing())) {}
    for (;;)
    {
      return;
      c(null);
    }
  }
  
  protected boolean e()
  {
    return false;
  }
  
  public final Dialog f()
  {
    return this.i;
  }
  
  public final void g()
  {
    if ((this.i == null) || (!this.i.isShowing())) {}
    for (;;)
    {
      return;
      this.i.dismiss();
    }
  }
  
  protected Parcelable h()
  {
    Object localObject = super.h();
    if ((this.i == null) || (!this.i.isShowing())) {}
    for (;;)
    {
      return (Parcelable)localObject;
      localObject = new SavedState((Parcelable)localObject);
      ((SavedState)localObject).a = true;
      ((SavedState)localObject).b = this.i.onSaveInstanceState();
    }
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.j = paramInt;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    B().b(this);
    this.i = null;
    if (this.j == -1) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  private static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new b();
    boolean a;
    Bundle b;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.a = bool;
        this.b = paramParcel.readBundle();
        return;
        bool = false;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      if (this.a) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeBundle(this.b);
        return;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/DialogPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */