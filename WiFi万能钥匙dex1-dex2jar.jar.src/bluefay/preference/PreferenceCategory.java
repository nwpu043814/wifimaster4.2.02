package bluefay.preference;

import android.content.Context;
import android.util.AttributeSet;

public class PreferenceCategory
  extends PreferenceGroup
{
  public PreferenceCategory(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PreferenceCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842892);
  }
  
  public PreferenceCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected final boolean a(Preference paramPreference)
  {
    if ((paramPreference instanceof PreferenceCategory)) {
      throw new IllegalArgumentException("Cannot add a PreferenceCategory directly to a PreferenceCategory");
    }
    return super.a(paramPreference);
  }
  
  public final boolean i()
  {
    if (!super.a()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/PreferenceCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */