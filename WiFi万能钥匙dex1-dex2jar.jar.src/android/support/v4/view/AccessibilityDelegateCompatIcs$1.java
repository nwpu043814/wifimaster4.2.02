package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

final class AccessibilityDelegateCompatIcs$1
  extends View.AccessibilityDelegate
{
  AccessibilityDelegateCompatIcs$1(AccessibilityDelegateCompatIcs.AccessibilityDelegateBridge paramAccessibilityDelegateBridge) {}
  
  public final boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.val$bridge.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public final void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.val$bridge.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public final void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    this.val$bridge.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
  }
  
  public final void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.val$bridge.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public final boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return this.val$bridge.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public final void sendAccessibilityEvent(View paramView, int paramInt)
  {
    this.val$bridge.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public final void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    this.val$bridge.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/view/AccessibilityDelegateCompatIcs$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */