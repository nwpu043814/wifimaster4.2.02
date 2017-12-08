package android.support.v4.view.accessibility;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

class AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1
  implements AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge
{
  AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1(AccessibilityNodeProviderCompat.AccessibilityNodeProviderKitKatImpl paramAccessibilityNodeProviderKitKatImpl, AccessibilityNodeProviderCompat paramAccessibilityNodeProviderCompat) {}
  
  public Object createAccessibilityNodeInfo(int paramInt)
  {
    Object localObject = this.val$compat.createAccessibilityNodeInfo(paramInt);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((AccessibilityNodeInfoCompat)localObject).getInfo()) {
      return localObject;
    }
  }
  
  public List<Object> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    List localList = this.val$compat.findAccessibilityNodeInfosByText(paramString, paramInt);
    paramString = new ArrayList();
    int i = localList.size();
    for (paramInt = 0; paramInt < i; paramInt++) {
      paramString.add(((AccessibilityNodeInfoCompat)localList.get(paramInt)).getInfo());
    }
    return paramString;
  }
  
  public Object findFocus(int paramInt)
  {
    Object localObject = this.val$compat.findFocus(paramInt);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((AccessibilityNodeInfoCompat)localObject).getInfo()) {
      return localObject;
    }
  }
  
  public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.val$compat.performAction(paramInt1, paramInt2, paramBundle);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/view/accessibility/AccessibilityNodeProviderCompat$AccessibilityNodeProviderKitKatImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */