package com.lantern.wifiseccheck.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.vpn.utils.ResTool;
import com.lantern.wifiseccheck.vpn.utils.UIUtils;
import java.util.HashMap;
import java.util.Map;

public class ScoreView
  extends LinearLayout
  implements MyProgressWheel.OnScoreChangedListener, ScrollPositionListView.OnScrollYListener
{
  private static final int[] BLUERGB = { 240, 133, 2 };
  private static final int[] ORAGERGB = { 2, 125, 240 };
  private static final int[] REDRGB = { 55, 55, 231 };
  private static final String TAG = "ScoreView";
  private Animation bigBackgroundAnim;
  private Map<Integer, Integer> colorMap = new HashMap();
  private Context context;
  private int currentScore = 100;
  private View headTitleView;
  private ImageView img_bg_big;
  private ImageView img_bg_light;
  private ImageView img_bg_small;
  private Animation lightBackgroundAnim;
  private MyProgressWheel progressWheel;
  private float scale = 1.0F;
  private TextView scoreChangeView;
  private Animation smallBackgroundAnim;
  
  public ScoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.context = paramContext;
    LayoutInflater.from(paramContext).inflate(ResTool.getLayoutId("sc_score_view", paramContext), this, true);
    this.img_bg_big = ((ImageView)findViewById(ResTool.getViewId("img_score_bg_big", paramContext)));
    this.img_bg_small = ((ImageView)findViewById(ResTool.getViewId("img_score_bg_small", paramContext)));
    this.img_bg_light = ((ImageView)findViewById(ResTool.getViewId("img_score_bg_light", paramContext)));
    this.progressWheel = ((MyProgressWheel)findViewById(ResTool.getViewId("score_wheel", paramContext)));
    this.progressWheel.setOnScoreChangeListener(this);
    this.scoreChangeView = ((TextView)findViewById(ResTool.getViewId("score_change_view", paramContext)));
    startAnimation();
  }
  
  private void startAnimation()
  {
    this.bigBackgroundAnim = AnimationUtils.loadAnimation(getContext(), ResTool.getAnimId("sc_rotate_right", this.context));
    this.smallBackgroundAnim = AnimationUtils.loadAnimation(getContext(), ResTool.getAnimId("sc_rotate_left", this.context));
    this.lightBackgroundAnim = AnimationUtils.loadAnimation(getContext(), ResTool.getAnimId("sc_rotate_circle_left", this.context));
    this.lightBackgroundAnim.setInterpolator(new LinearInterpolator());
    this.bigBackgroundAnim.setInterpolator(new LinearInterpolator());
    this.smallBackgroundAnim.setInterpolator(new LinearInterpolator());
    if (this.img_bg_big != null) {
      this.img_bg_big.startAnimation(this.bigBackgroundAnim);
    }
    if (this.img_bg_small != null) {
      this.img_bg_small.startAnimation(this.smallBackgroundAnim);
    }
    if (this.img_bg_light != null) {
      this.img_bg_light.startAnimation(this.lightBackgroundAnim);
    }
    updateBackground(100);
  }
  
  private void updateBackground(int paramInt)
  {
    Log.d("ScoreView", "update backgound progress :" + paramInt);
    int j = Color.parseColor("#FF0285f0");
    int i = j;
    if (this.colorMap != null)
    {
      i = j;
      if (this.colorMap.size() > 0)
      {
        LogUtils.d("ScoreView", "set color " + Integer.toHexString(((Integer)this.colorMap.get(Integer.valueOf(paramInt))).intValue()));
        i = ((Integer)this.colorMap.get(Integer.valueOf(paramInt))).intValue();
      }
    }
    setBackgroundColor(i);
    if (this.headTitleView != null) {
      this.headTitleView.setBackgroundColor(i);
    }
  }
  
  public void onActStart()
  {
    this.progressWheel.setIsActStop(false);
  }
  
  public void onActStop()
  {
    this.progressWheel.setIsActStop(true);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    paramCanvas.scale(this.scale, this.scale, 0.0F, UIUtils.dip2px(getContext(), 287.0F));
    super.onDraw(paramCanvas);
  }
  
  public void onScoreChanged(int paramInt)
  {
    updateBackground(paramInt);
  }
  
  public void onScrollY(int paramInt)
  {
    this.scale = ((UIUtils.dip2px(getContext(), 287.0F) - paramInt) / UIUtils.dip2px(getContext(), 287.0F));
    LogUtils.d("ScoreView", "onScrollY change scale" + this.scale + "onScrollY change y" + paramInt);
    invalidate();
  }
  
  public void setBGSpeed(BGSpeed paramBGSpeed)
  {
    switch (ScoreView.1.$SwitchMap$com$lantern$wifiseccheck$view$ScoreView$BGSpeed[paramBGSpeed.ordinal()])
    {
    }
    for (;;)
    {
      this.img_bg_big.startAnimation(this.bigBackgroundAnim);
      this.img_bg_small.startAnimation(this.smallBackgroundAnim);
      this.img_bg_light.startAnimation(this.lightBackgroundAnim);
      return;
      this.bigBackgroundAnim.setDuration(3000L);
      this.smallBackgroundAnim.setDuration(3000L);
      this.lightBackgroundAnim.setDuration(2000L);
      continue;
      this.bigBackgroundAnim.setDuration(8000L);
      this.smallBackgroundAnim.setDuration(8000L);
      this.lightBackgroundAnim.setDuration(15000L);
    }
  }
  
  public void setHeadTitleView(View paramView)
  {
    this.headTitleView = paramView;
  }
  
  public void setProgress(int paramInt)
  {
    LogUtils.d("ScoreView", "set progress " + paramInt);
    int k;
    int i;
    int j;
    int m;
    if (paramInt < 100)
    {
      this.colorMap.clear();
      LogUtils.d("ScoreView", "target score 1111111111+ currentScore =" + this.currentScore);
      k = Math.abs(this.currentScore - paramInt);
      LogUtils.d("ScoreView", "target score 22222222");
      LogUtils.d("ScoreView", "target score 333333333");
      if ((k <= 60) && (k > 20))
      {
        LogUtils.d("ScoreView", "target score > 40");
        i = (ORAGERGB[0] - BLUERGB[0]) / k;
        j = (ORAGERGB[1] - BLUERGB[1]) / k;
        m = (ORAGERGB[2] - BLUERGB[2]) / k;
        if (i != 0) {
          break label1183;
        }
        i--;
      }
    }
    label1147:
    label1177:
    label1183:
    for (;;)
    {
      if (j == 0) {
        j--;
      }
      for (;;)
      {
        k = m;
        if (m == 0) {
          k = m + 1;
        }
        LogUtils.d("ScoreView", "unitR =" + i + " unitG=" + j + " unitB=" + k);
        m = this.currentScore;
        int n;
        int i1;
        int i2;
        int i3;
        while (m >= paramInt)
        {
          n = this.currentScore - m;
          i1 = BLUERGB[0] + n * i;
          i2 = BLUERGB[1] + n * j;
          i3 = n * k + BLUERGB[2];
          LogUtils.d("ScoreView", "tempRGB =" + Integer.toHexString(i1) + " " + Integer.toHexString(i2) + " " + Integer.toHexString(i3));
          if (i1 >= ORAGERGB[0])
          {
            n = i1;
            if (m == paramInt)
            {
              n = i1;
              if (i1 == ORAGERGB[0]) {}
            }
          }
          else
          {
            n = ORAGERGB[0];
          }
          if (i2 >= ORAGERGB[1])
          {
            i1 = i2;
            if (m == paramInt)
            {
              i1 = i2;
              if (i2 == ORAGERGB[1]) {}
            }
          }
          else
          {
            i1 = ORAGERGB[1];
          }
          if (i3 <= ORAGERGB[2])
          {
            i2 = i3;
            if (m == paramInt)
            {
              i2 = i3;
              if (i3 == ORAGERGB[2]) {}
            }
          }
          else
          {
            i2 = ORAGERGB[2];
          }
          this.colorMap.put(Integer.valueOf(m), Integer.valueOf(n + i1 * 16 * 16 + i2 * 16 * 16 * 16 * 16 - 16777216));
          m--;
          continue;
          if (k > 60)
          {
            LogUtils.d("ScoreView", "target score > 60");
            k = (ORAGERGB[0] - BLUERGB[0]) / 20;
            m = (ORAGERGB[1] - BLUERGB[1]) / 20;
            j = (ORAGERGB[2] - BLUERGB[2]) / 20;
            LogUtils.d("ScoreView", "target score < 40");
            for (i = this.currentScore; i >= 80; i--)
            {
              n = this.currentScore - i;
              i1 = BLUERGB[0];
              i3 = BLUERGB[1];
              i2 = BLUERGB[2];
              this.colorMap.put(Integer.valueOf(i), Integer.valueOf((n * j + i2) * 16 * 16 * 16 * 16 + (i1 + n * k + (i3 + n * m) * 16 * 16) - 16777216));
            }
            k = 80 - paramInt;
            i = (REDRGB[0] - ORAGERGB[0]) / k;
            j = (REDRGB[1] - ORAGERGB[1]) / k;
            m = (REDRGB[2] - ORAGERGB[2]) / k;
            if (i != 0) {
              break label1177;
            }
            i++;
          }
        }
        for (;;)
        {
          if (j == 0) {
            j--;
          }
          for (;;)
          {
            k = m;
            if (m == 0) {
              k = m - 1;
            }
            LogUtils.d("ScoreView", "unitR =" + i + " unitG=" + j + " unitB=" + k);
            for (m = 80; m >= paramInt; m--)
            {
              int i4 = 80 - m;
              i1 = i4 * i + 2;
              i2 = i4 * j + 125;
              i3 = i4 * k + 240;
              if (i1 <= REDRGB[0])
              {
                n = i1;
                if (m == paramInt)
                {
                  n = i1;
                  if (i1 == REDRGB[0]) {}
                }
              }
              else
              {
                n = REDRGB[0];
              }
              if (i2 >= REDRGB[1])
              {
                i1 = i2;
                if (m == paramInt)
                {
                  i1 = i2;
                  if (i2 == REDRGB[1]) {}
                }
              }
              else
              {
                i1 = REDRGB[1];
              }
              if (i3 >= REDRGB[2])
              {
                i2 = i3;
                if (m == paramInt)
                {
                  i2 = i3;
                  if (i3 == REDRGB[2]) {}
                }
              }
              else
              {
                i2 = REDRGB[2];
              }
              n = n + i1 * 16 * 16 + i2 * 16 * 16 * 16 * 16 - 16777216;
              LogUtils.d("ScoreView", "tempsize =" + i4 + " result=" + Integer.toHexString(n) + " k=" + m);
              this.colorMap.put(Integer.valueOf(m), Integer.valueOf(n));
            }
            if (this.progressWheel != null)
            {
              this.progressWheel.setProgress(paramInt);
              if (paramInt != 100) {
                break label1147;
              }
              this.scoreChangeView.setText(getResources().getString(ResTool.getStringId("protected_opened", this.context)));
            }
            for (;;)
            {
              this.currentScore = paramInt;
              return;
              this.scoreChangeView.setText(getResources().getString(ResTool.getStringId("protected_closed", this.context)));
            }
          }
        }
      }
    }
  }
  
  public static enum BGSpeed
  {
    FAST,  SLOW;
    
    private BGSpeed() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/view/ScoreView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */