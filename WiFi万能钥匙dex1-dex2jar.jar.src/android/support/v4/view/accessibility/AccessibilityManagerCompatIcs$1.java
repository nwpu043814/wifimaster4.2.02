package android.support.v4.view.accessibility;

import android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener;

final class AccessibilityManagerCompatIcs$1
  implements AccessibilityManager.AccessibilityStateChangeListener
{
  AccessibilityManagerCompatIcs$1(AccessibilityManagerCompatIcs.AccessibilityStateChangeListenerBridge paramAccessibilityStateChangeListenerBridge) {}
  
  public final void onAccessibilityStateChanged(boolean paramBoolean)
  {
    this.val$bridge.onAccessibilityStateChanged(paramBoolean);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/view/accessibility/AccessibilityManagerCompatIcs$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */