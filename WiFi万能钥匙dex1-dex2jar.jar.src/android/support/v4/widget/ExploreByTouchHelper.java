package android.support.v4.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class ExploreByTouchHelper
  extends AccessibilityDelegateCompat
{
  private static final String DEFAULT_CLASS_NAME = View.class.getName();
  public static final int INVALID_ID = Integer.MIN_VALUE;
  private int mFocusedVirtualViewId = Integer.MIN_VALUE;
  private int mHoveredVirtualViewId = Integer.MIN_VALUE;
  private final AccessibilityManager mManager;
  private ExploreByTouchNodeProvider mNodeProvider;
  private final int[] mTempGlobalRect = new int[2];
  private final Rect mTempParentRect = new Rect();
  private final Rect mTempScreenRect = new Rect();
  private final Rect mTempVisibleRect = new Rect();
  private final View mView;
  
  public ExploreByTouchHelper(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("View may not be null");
    }
    this.mView = paramView;
    this.mManager = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
  }
  
  private boolean clearAccessibilityFocus(int paramInt)
  {
    if (isAccessibilityFocused(paramInt))
    {
      this.mFocusedVirtualViewId = Integer.MIN_VALUE;
      this.mView.invalidate();
      sendEventForVirtualView(paramInt, 65536);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private AccessibilityEvent createEvent(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (AccessibilityEvent localAccessibilityEvent = createEventForChild(paramInt1, paramInt2);; localAccessibilityEvent = createEventForHost(paramInt2)) {
      return localAccessibilityEvent;
    }
  }
  
  private AccessibilityEvent createEventForChild(int paramInt1, int paramInt2)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    localAccessibilityEvent.setEnabled(true);
    localAccessibilityEvent.setClassName(DEFAULT_CLASS_NAME);
    onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent);
    if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }
    localAccessibilityEvent.setPackageName(this.mView.getContext().getPackageName());
    AccessibilityEventCompat.asRecord(localAccessibilityEvent).setSource(this.mView, paramInt1);
    return localAccessibilityEvent;
  }
  
  private AccessibilityEvent createEventForHost(int paramInt)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
    ViewCompat.onInitializeAccessibilityEvent(this.mView, localAccessibilityEvent);
    return localAccessibilityEvent;
  }
  
  private AccessibilityNodeInfoCompat createNode(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = createNodeForChild(paramInt);; localAccessibilityNodeInfoCompat = createNodeForHost()) {
      return localAccessibilityNodeInfoCompat;
    }
  }
  
  private AccessibilityNodeInfoCompat createNodeForChild(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain();
    localAccessibilityNodeInfoCompat.setEnabled(true);
    localAccessibilityNodeInfoCompat.setClassName(DEFAULT_CLASS_NAME);
    onPopulateNodeForVirtualView(paramInt, localAccessibilityNodeInfoCompat);
    if ((localAccessibilityNodeInfoCompat.getText() == null) && (localAccessibilityNodeInfoCompat.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }
    localAccessibilityNodeInfoCompat.getBoundsInParent(this.mTempParentRect);
    if (this.mTempParentRect.isEmpty()) {
      throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }
    int i = localAccessibilityNodeInfoCompat.getActions();
    if ((i & 0x40) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    if ((i & 0x80) != 0) {
      throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    localAccessibilityNodeInfoCompat.setPackageName(this.mView.getContext().getPackageName());
    localAccessibilityNodeInfoCompat.setSource(this.mView, paramInt);
    localAccessibilityNodeInfoCompat.setParent(this.mView);
    if (this.mFocusedVirtualViewId == paramInt)
    {
      localAccessibilityNodeInfoCompat.setAccessibilityFocused(true);
      localAccessibilityNodeInfoCompat.addAction(128);
    }
    for (;;)
    {
      if (intersectVisibleToUser(this.mTempParentRect))
      {
        localAccessibilityNodeInfoCompat.setVisibleToUser(true);
        localAccessibilityNodeInfoCompat.setBoundsInParent(this.mTempParentRect);
      }
      this.mView.getLocationOnScreen(this.mTempGlobalRect);
      paramInt = this.mTempGlobalRect[0];
      i = this.mTempGlobalRect[1];
      this.mTempScreenRect.set(this.mTempParentRect);
      this.mTempScreenRect.offset(paramInt, i);
      localAccessibilityNodeInfoCompat.setBoundsInScreen(this.mTempScreenRect);
      return localAccessibilityNodeInfoCompat;
      localAccessibilityNodeInfoCompat.setAccessibilityFocused(false);
      localAccessibilityNodeInfoCompat.addAction(64);
    }
  }
  
  private AccessibilityNodeInfoCompat createNodeForHost()
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(this.mView);
    ViewCompat.onInitializeAccessibilityNodeInfo(this.mView, localAccessibilityNodeInfoCompat);
    Object localObject = new LinkedList();
    getVisibleVirtualViews((List)localObject);
    localObject = ((LinkedList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      localAccessibilityNodeInfoCompat.addChild(this.mView, localInteger.intValue());
    }
    return localAccessibilityNodeInfoCompat;
  }
  
  private boolean intersectVisibleToUser(Rect paramRect)
  {
    boolean bool;
    if ((paramRect == null) || (paramRect.isEmpty())) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (this.mView.getWindowVisibility() != 0)
      {
        bool = false;
      }
      else
      {
        for (Object localObject = this.mView.getParent();; localObject = ((View)localObject).getParent())
        {
          if (!(localObject instanceof View)) {
            break label79;
          }
          localObject = (View)localObject;
          if ((ViewCompat.getAlpha((View)localObject) <= 0.0F) || (((View)localObject).getVisibility() != 0))
          {
            bool = false;
            break;
          }
        }
        label79:
        if (localObject == null) {
          bool = false;
        } else if (!this.mView.getLocalVisibleRect(this.mTempVisibleRect)) {
          bool = false;
        } else {
          bool = paramRect.intersect(this.mTempVisibleRect);
        }
      }
    }
  }
  
  private boolean isAccessibilityFocused(int paramInt)
  {
    if (this.mFocusedVirtualViewId == paramInt) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean manageFocusForChild(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    boolean bool;
    switch (paramInt2)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      bool = requestAccessibilityFocus(paramInt1);
      continue;
      bool = clearAccessibilityFocus(paramInt1);
    }
  }
  
  private boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    switch (paramInt1)
    {
    }
    for (boolean bool = performActionForChild(paramInt1, paramInt2, paramBundle);; bool = performActionForHost(paramInt2, paramBundle)) {
      return bool;
    }
  }
  
  private boolean performActionForChild(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    switch (paramInt2)
    {
    }
    for (boolean bool = onPerformActionForVirtualView(paramInt1, paramInt2, paramBundle);; bool = manageFocusForChild(paramInt1, paramInt2, paramBundle)) {
      return bool;
    }
  }
  
  private boolean performActionForHost(int paramInt, Bundle paramBundle)
  {
    return ViewCompat.performAccessibilityAction(this.mView, paramInt, paramBundle);
  }
  
  private boolean requestAccessibilityFocus(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mManager.isEnabled())
    {
      if (AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager)) {
        break label28;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label28:
      bool1 = bool2;
      if (!isAccessibilityFocused(paramInt))
      {
        this.mFocusedVirtualViewId = paramInt;
        this.mView.invalidate();
        sendEventForVirtualView(paramInt, 32768);
        bool1 = true;
      }
    }
  }
  
  private void updateHoveredVirtualView(int paramInt)
  {
    if (this.mHoveredVirtualViewId == paramInt) {}
    for (;;)
    {
      return;
      int i = this.mHoveredVirtualViewId;
      this.mHoveredVirtualViewId = paramInt;
      sendEventForVirtualView(paramInt, 128);
      sendEventForVirtualView(i, 256);
    }
  }
  
  public boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if ((!this.mManager.isEnabled()) || (!AccessibilityManagerCompat.isTouchExplorationEnabled(this.mManager))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      switch (paramMotionEvent.getAction())
      {
      case 8: 
      default: 
        bool = false;
        break;
      case 7: 
      case 9: 
        int i = getVirtualViewAt(paramMotionEvent.getX(), paramMotionEvent.getY());
        updateHoveredVirtualView(i);
        if (i == Integer.MIN_VALUE) {
          bool = false;
        }
        break;
      case 10: 
        if (this.mFocusedVirtualViewId != Integer.MIN_VALUE) {
          updateHoveredVirtualView(Integer.MIN_VALUE);
        } else {
          bool = false;
        }
        break;
      }
    }
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    if (this.mNodeProvider == null) {
      this.mNodeProvider = new ExploreByTouchNodeProvider(null);
    }
    return this.mNodeProvider;
  }
  
  public int getFocusedVirtualView()
  {
    return this.mFocusedVirtualViewId;
  }
  
  protected abstract int getVirtualViewAt(float paramFloat1, float paramFloat2);
  
  protected abstract void getVisibleVirtualViews(List<Integer> paramList);
  
  public void invalidateRoot()
  {
    invalidateVirtualView(-1);
  }
  
  public void invalidateVirtualView(int paramInt)
  {
    sendEventForVirtualView(paramInt, 2048);
  }
  
  protected abstract boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle);
  
  protected abstract void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent);
  
  protected abstract void onPopulateNodeForVirtualView(int paramInt, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);
  
  public boolean sendEventForVirtualView(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 != Integer.MIN_VALUE)
    {
      if (this.mManager.isEnabled()) {
        break label27;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label27:
      ViewParent localViewParent = this.mView.getParent();
      bool1 = bool2;
      if (localViewParent != null)
      {
        AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, paramInt2);
        bool1 = ViewParentCompat.requestSendAccessibilityEvent(localViewParent, this.mView, localAccessibilityEvent);
      }
    }
  }
  
  private class ExploreByTouchNodeProvider
    extends AccessibilityNodeProviderCompat
  {
    private ExploreByTouchNodeProvider() {}
    
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
    {
      return ExploreByTouchHelper.this.createNode(paramInt);
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return ExploreByTouchHelper.this.performAction(paramInt1, paramInt2, paramBundle);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/widget/ExploreByTouchHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */