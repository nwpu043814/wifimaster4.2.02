package bluefay.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import bluefay.app.k.a;
import com.bluefay.a.e;
import java.util.Arrays;

public class MultiCheckPreference
  extends DialogPreference
{
  private CharSequence[] b;
  private String[] c;
  private boolean[] d;
  private boolean[] e;
  private String f;
  
  public MultiCheckPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject = e.a("com.android.internal.R$styleable", "ListPreference");
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, 0, 0);
      int i = ((Integer)e.a("com.android.internal.R$styleable", "ListPreference_entries")).intValue();
      int j = ((Integer)e.a("com.android.internal.R$styleable", "ListPreference_entryValues")).intValue();
      this.b = paramContext.getTextArray(i);
      if (this.b != null)
      {
        paramAttributeSet = this.b;
        this.b = paramAttributeSet;
        this.d = new boolean[paramAttributeSet.length];
        this.e = new boolean[paramAttributeSet.length];
      }
      paramAttributeSet = paramContext.getTextArray(j);
      a(null);
      if (paramAttributeSet != null)
      {
        this.c = new String[paramAttributeSet.length];
        for (i = 0; i < paramAttributeSet.length; i++) {
          this.c[i] = paramAttributeSet[i].toString();
        }
      }
      paramContext.recycle();
    }
  }
  
  private void a(boolean[] paramArrayOfBoolean)
  {
    boolean[] arrayOfBoolean;
    if (this.d != null)
    {
      Arrays.fill(this.d, false);
      Arrays.fill(this.e, false);
      if (paramArrayOfBoolean != null)
      {
        arrayOfBoolean = this.d;
        if (paramArrayOfBoolean.length >= this.d.length) {
          break label54;
        }
      }
    }
    label54:
    for (int i = paramArrayOfBoolean.length;; i = this.d.length)
    {
      System.arraycopy(paramArrayOfBoolean, 0, arrayOfBoolean, 0, i);
      return;
    }
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
  
  protected final void a(k.a parama)
  {
    super.a(parama);
    if ((this.b == null) || (this.c == null)) {
      throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
    }
    this.e = Arrays.copyOf(this.d, this.d.length);
    parama.a(this.b, this.d, new g(this));
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    super.a(paramCharSequence);
    if ((paramCharSequence == null) && (this.f != null)) {
      this.f = null;
    }
    for (;;)
    {
      return;
      if ((paramCharSequence != null) && (!paramCharSequence.equals(this.f))) {
        this.f = paramCharSequence.toString();
      }
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((paramBoolean) && (x())) {}
    for (;;)
    {
      return;
      System.arraycopy(this.e, 0, this.d, 0, this.d.length);
    }
  }
  
  protected final void a(boolean paramBoolean, Object paramObject) {}
  
  protected final Parcelable h()
  {
    Object localObject = super.h();
    if (w()) {}
    for (;;)
    {
      return (Parcelable)localObject;
      localObject = new SavedState((Parcelable)localObject);
      ((SavedState)localObject).a = this.d;
    }
  }
  
  public final CharSequence j()
  {
    if (this.f == null) {}
    for (Object localObject = super.j();; localObject = this.f) {
      return (CharSequence)localObject;
    }
  }
  
  private static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new h();
    boolean[] a;
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.createBooleanArray();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBooleanArray(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/MultiCheckPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */