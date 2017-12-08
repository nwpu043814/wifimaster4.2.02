package com.lantern.wifiseccheck.view;

public abstract interface ScoreViewInterface
{
  public abstract int getScore();
  
  public abstract void setBgDuration(int paramInt, long paramLong, float paramFloat1, float paramFloat2);
  
  public abstract void setBgRotate(boolean paramBoolean);
  
  public abstract void setBrightRingDuration(long paramLong);
  
  public abstract void setOnScoreChangeListener(OnScoreChangeListener paramOnScoreChangeListener);
  
  public abstract void setPromptText(String paramString, int paramInt, float paramFloat);
  
  public abstract void setPromptTextVisible(int paramInt);
  
  public abstract void setTargetScore(int paramInt, long paramLong);
  
  public static abstract interface OnScoreChangeListener
  {
    public abstract void onScoreChanged(int paramInt);
    
    public abstract void onScoreChangedFinish();
    
    public abstract void onScoreChangedStart();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/view/ScoreViewInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */