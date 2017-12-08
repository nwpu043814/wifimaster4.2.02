package android.support.v4.view.accessibility;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

final class AccessibilityNodeProviderCompatKitKat$1
  extends AccessibilityNodeProvider
{
  AccessibilityNodeProviderCompatKitKat$1(AccessibilityNodeProviderCompatKitKat.AccessibilityNodeInfoBridge paramAccessibilityNodeInfoBridge) {}
  
  public final AccessibilityNodeInfo createAccessibilityNodeInfo(int paramInt)
  {
    return (AccessibilityNodeInfo)this.val$bridge.createAccessibilityNodeInfo(paramInt);
  }
  
  public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String paramString, int paramInt)
  {
    return this.val$bridge.findAccessibilityNodeInfosByText(paramString, paramInt);
  }
  
  public final AccessibilityNodeInfo findFocus(int paramInt)
  {
    return (AccessibilityNodeInfo)this.val$bridge.findFocus(paramInt);
  }
  
  public final boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    return this.val$bridge.performAction(paramInt1, paramInt2, paramBundle);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/view/accessibility/AccessibilityNodeProviderCompatKitKat$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */