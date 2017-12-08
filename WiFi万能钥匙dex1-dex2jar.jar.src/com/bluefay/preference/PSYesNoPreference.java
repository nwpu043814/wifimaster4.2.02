package com.bluefay.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import bluefay.preference.DialogPreference;
import bluefay.preference.Preference.BaseSavedState;

public class PSYesNoPreference
  extends DialogPreference
{
  private boolean b;
  
  public PSYesNoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842896);
  }
  
  public PSYesNoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
  
  protected final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (x()) {
      g(paramBoolean);
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
    public static final Parcelable.Creator<SavedState> CREATOR = new f();
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/preference/PSYesNoPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */