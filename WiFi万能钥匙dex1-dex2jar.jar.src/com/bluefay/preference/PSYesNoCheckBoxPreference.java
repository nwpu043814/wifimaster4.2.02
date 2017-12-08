package com.bluefay.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import bluefay.preference.DialogPreference;
import bluefay.preference.Preference.BaseSavedState;

public class PSYesNoCheckBoxPreference
  extends DialogPreference
{
  private boolean b;
  private boolean c;
  
  public PSYesNoCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842895);
  }
  
  public PSYesNoCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(17039379);
    b(17039369);
  }
  
  private void g(boolean paramBoolean)
  {
    this.b = paramBoolean;
    e(paramBoolean);
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      c(paramBoolean);
      return;
    }
  }
  
  protected final Object a(TypedArray paramTypedArray, int paramInt)
  {
    return Boolean.valueOf(paramTypedArray.getBoolean(paramInt, false));
  }
  
  protected final void a(Parcelable paramParcelable)
  {
    if (!paramParcelable.getClass().equals(SavedState.class)) {
      super.a(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.a(paramParcelable.getSuperState());
      g(paramParcelable.a);
    }
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    paramView = paramView.findViewById(16908289);
    if ((paramView != null) && ((paramView instanceof Checkable)))
    {
      paramView.setClickable(false);
      ((Checkable)paramView).setChecked(this.c);
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    int i = 1;
    super.a(paramBoolean);
    boolean bool;
    if (paramBoolean)
    {
      if (this.c) {
        break label62;
      }
      bool = true;
      if (this.c == bool) {
        break label67;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.c = bool;
        c(i());
        z();
      }
      if (x()) {
        g(paramBoolean);
      }
      return;
      label62:
      bool = false;
      break;
      label67:
      i = 0;
    }
  }
  
  protected final void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    for (paramBoolean = f(this.b);; paramBoolean = ((Boolean)paramObject).booleanValue())
    {
      g(paramBoolean);
      return;
    }
  }
  
  protected final Parcelable h()
  {
    Object localObject = super.h();
    if (w()) {}
    for (;;)
    {
      return (Parcelable)localObject;
      localObject = new SavedState((Parcelable)localObject);
      ((SavedState)localObject).a = this.b;
    }
  }
  
  public final boolean i()
  {
    if ((!this.b) || (super.i())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new e();
    boolean a;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.a = bool;
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
        return;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/preference/PSYesNoCheckBoxPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */