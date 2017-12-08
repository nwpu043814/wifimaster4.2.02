package bluefay.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import com.bluefay.framework.R.id;

public class EditTextPreference
  extends DialogPreference
{
  private EditText b;
  private String c;
  
  public EditTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842898);
  }
  
  public EditTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = new EditText(paramContext, paramAttributeSet);
    this.b.setId(16908291);
    this.b.setEnabled(true);
  }
  
  protected final Object a(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getString(paramInt);
  }
  
  protected final void a(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(SavedState.class))) {
      super.a(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.a(paramParcelable.getSuperState());
      a(paramParcelable.a);
    }
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    paramView = paramView.findViewById(R.id.right_value);
    if (paramView != null) {
      ((TextView)paramView).setText(this.c);
    }
  }
  
  public void a(String paramString)
  {
    boolean bool1 = i();
    this.c = paramString;
    c(paramString);
    boolean bool2 = i();
    if (bool2 != bool1) {
      c(bool2);
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      String str = this.b.getText().toString();
      if (x()) {
        a(str);
      }
    }
  }
  
  protected final void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {}
    for (paramObject = d(this.c);; paramObject = (String)paramObject)
    {
      a((String)paramObject);
      return;
    }
  }
  
  protected final void b(View paramView)
  {
    super.b(paramView);
    EditText localEditText = this.b;
    localEditText.setText(this.c);
    ViewParent localViewParent = localEditText.getParent();
    if (localViewParent != paramView)
    {
      if (localViewParent != null) {
        ((ViewGroup)localViewParent).removeView(localEditText);
      }
      paramView = (ViewGroup)paramView.findViewById(R.id.edittext_container);
      if (paramView != null) {
        paramView.addView(localEditText, -1, -2);
      }
    }
    paramView = this.b;
    if ((paramView != null) && (paramView.getText() != null)) {
      paramView.setSelection(paramView.getText().length());
    }
  }
  
  protected final boolean e()
  {
    return true;
  }
  
  protected final Parcelable h()
  {
    Object localObject = super.h();
    if (w()) {}
    for (;;)
    {
      return (Parcelable)localObject;
      localObject = new SavedState((Parcelable)localObject);
      ((SavedState)localObject).a = this.c;
    }
  }
  
  public final boolean i()
  {
    if ((TextUtils.isEmpty(this.c)) || (super.i())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new c();
    String a;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readString();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/EditTextPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */