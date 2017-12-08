package com.linksure.apservice.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.linksure.apservice.R.drawable;
import java.util.HashMap;
import java.util.Map;

public final class c
{
  public static int[] a;
  public static String[] b;
  private static Map<String, Integer> c;
  private static int d;
  
  static
  {
    int i = 0;
    c = new HashMap();
    d = 42;
    a = new int[] { R.drawable.aps_ze01, R.drawable.aps_ze02, R.drawable.aps_ze03, R.drawable.aps_ze04, R.drawable.aps_ze05, R.drawable.aps_ze06, R.drawable.aps_ze07, R.drawable.aps_ze08, R.drawable.aps_ze09, R.drawable.aps_ze10, R.drawable.aps_ze11, R.drawable.aps_ze12, R.drawable.aps_ze13, R.drawable.aps_ze14, R.drawable.aps_ze15, R.drawable.aps_ze16, R.drawable.aps_ze17, R.drawable.aps_ze18, R.drawable.aps_ze19, R.drawable.aps_ze20, R.drawable.aps_ze21, R.drawable.aps_ze22, R.drawable.aps_ze23, R.drawable.aps_ze24, R.drawable.aps_ze25, R.drawable.aps_ze26, R.drawable.aps_ze27, R.drawable.aps_ze28, R.drawable.aps_ze29, R.drawable.aps_ze30, R.drawable.aps_ze31, R.drawable.aps_ze32, R.drawable.aps_ze33, R.drawable.aps_ze34, R.drawable.aps_ze35, R.drawable.aps_ze36, R.drawable.aps_ze37, R.drawable.aps_ze38, R.drawable.aps_ze39, R.drawable.aps_ze40, R.drawable.aps_ze41, R.drawable.aps_ze42, R.drawable.aps_ze43, R.drawable.aps_ze44, R.drawable.aps_ze45, R.drawable.aps_ze46, R.drawable.aps_ze47, R.drawable.aps_ze48, R.drawable.aps_ze49, R.drawable.aps_ze50, R.drawable.aps_ze51, R.drawable.aps_ze52, R.drawable.aps_ze53, R.drawable.aps_ze54, R.drawable.aps_ze55, R.drawable.aps_ze56, R.drawable.aps_ze57, R.drawable.aps_ze58, R.drawable.aps_ze59, R.drawable.aps_ze60, R.drawable.aps_ze61, R.drawable.aps_ze62, R.drawable.aps_ze63, R.drawable.aps_ze64, R.drawable.aps_ze65, R.drawable.aps_ze66, R.drawable.aps_ze67, R.drawable.aps_ze68, R.drawable.aps_ze69, R.drawable.aps_ze70, R.drawable.aps_ze71, R.drawable.aps_ze72, R.drawable.aps_ze73, R.drawable.aps_ze74, R.drawable.aps_ze75, R.drawable.aps_ze76, R.drawable.aps_ze77, R.drawable.aps_ze78, R.drawable.aps_ze79, R.drawable.aps_ze80, R.drawable.aps_ze81, R.drawable.aps_ze82, R.drawable.aps_ze83, R.drawable.aps_ze84, R.drawable.aps_ze85, R.drawable.aps_ze86, R.drawable.aps_ze87, R.drawable.aps_ze88, R.drawable.aps_ze89, R.drawable.aps_ze90, R.drawable.aps_ze91, R.drawable.aps_ze92, R.drawable.aps_ze93, R.drawable.aps_ze94, R.drawable.aps_ze95, R.drawable.aps_ze96, R.drawable.aps_ze97, R.drawable.aps_ze98, R.drawable.aps_ze99, R.drawable.aps_ze100, R.drawable.aps_ze101, R.drawable.aps_ze102, R.drawable.aps_ze103, R.drawable.aps_ze104, R.drawable.aps_ze105, R.drawable.aps_ze106, R.drawable.aps_ze107, R.drawable.aps_ze108, R.drawable.aps_ze01, R.drawable.aps_ze02, R.drawable.aps_ze03, R.drawable.aps_ze04, R.drawable.aps_ze05, R.drawable.aps_ze06, R.drawable.aps_ze07, R.drawable.aps_ze08, R.drawable.aps_ze09, R.drawable.aps_ze10, R.drawable.aps_ze11, R.drawable.aps_ze12, R.drawable.aps_ze13, R.drawable.aps_ze14, R.drawable.aps_ze15, R.drawable.aps_ze16, R.drawable.aps_ze17, R.drawable.aps_ze18, R.drawable.aps_ze19, R.drawable.aps_ze20, R.drawable.aps_ze21, R.drawable.aps_ze22, R.drawable.aps_ze23, R.drawable.aps_ze24, R.drawable.aps_ze25, R.drawable.aps_ze26, R.drawable.aps_ze27, R.drawable.aps_ze28, R.drawable.aps_ze29, R.drawable.aps_ze30, R.drawable.aps_ze31, R.drawable.aps_ze32, R.drawable.aps_ze33, R.drawable.aps_ze34, R.drawable.aps_ze35, R.drawable.aps_ze36, R.drawable.aps_ze37, R.drawable.aps_ze38, R.drawable.aps_ze39, R.drawable.aps_ze40, R.drawable.aps_ze41, R.drawable.aps_ze42, R.drawable.aps_ze43, R.drawable.aps_ze44, R.drawable.aps_ze45, R.drawable.aps_ze46, R.drawable.aps_ze47, R.drawable.aps_ze48, R.drawable.aps_ze49, R.drawable.aps_ze50, R.drawable.aps_ze51, R.drawable.aps_ze52, R.drawable.aps_ze53, R.drawable.aps_ze54, R.drawable.aps_ze55, R.drawable.aps_ze56, R.drawable.aps_ze57, R.drawable.aps_ze58, R.drawable.aps_ze59, R.drawable.aps_ze60, R.drawable.aps_ze61, R.drawable.aps_ze62, R.drawable.aps_ze63, R.drawable.aps_ze64, R.drawable.aps_ze65, R.drawable.aps_ze66, R.drawable.aps_ze67, R.drawable.aps_ze68, R.drawable.aps_ze69, R.drawable.aps_ze70, R.drawable.aps_ze71, R.drawable.aps_ze72, R.drawable.aps_ze73, R.drawable.aps_ze74, R.drawable.aps_ze75, R.drawable.aps_ze76, R.drawable.aps_ze77, R.drawable.aps_ze78, R.drawable.aps_ze79, R.drawable.aps_ze80, R.drawable.aps_ze81, R.drawable.aps_ze82, R.drawable.aps_ze83, R.drawable.aps_ze84, R.drawable.aps_ze85, R.drawable.aps_ze86, R.drawable.aps_ze87, R.drawable.aps_ze88, R.drawable.aps_ze89, R.drawable.aps_ze90, R.drawable.aps_ze91, R.drawable.aps_ze92, R.drawable.aps_ze93, R.drawable.aps_ze94, R.drawable.aps_ze95, R.drawable.aps_ze96, R.drawable.aps_ze97, R.drawable.aps_ze98, R.drawable.aps_ze99, R.drawable.aps_ze100, R.drawable.aps_ze101, R.drawable.aps_ze102, R.drawable.aps_ze103, R.drawable.aps_ze104, R.drawable.aps_ze105, R.drawable.aps_ze106, R.drawable.aps_ze107, R.drawable.aps_ze108 };
    b = new String[] { "[微笑]", "[笑cry]", "[色]", "[发呆]", "[得意]", "[大哭]", "[害羞]", "[闭嘴]", "[睡]", "[思考]", "[尴尬]", "[怒]", "[龇牙]", "[惊讶]", "[委屈]", "[囧]", "[抓狂]", "[吐]", "[偷笑]", "[愉快]", "[白眼]", "[傲慢]", "[想吃]", "[惊恐]", "[流汗]", "[憨笑]", "[奋斗]", "[咒骂]", "[疑问]", "[嘘]", "[晕]", "[衰]", "[骷髅]", "[敲打]", "[拜拜]", "[擦汗]", "[抠鼻]", "[鼓掌]", "[糗大了]", "[坏笑]", "[左哼哼]", "[右哼哼]", "[哈欠]", "[鄙视]", "[快哭了]", "[阴险]", "[亲亲]", "[感冒]", "[酷]", "[摸头]", "[撇嘴]", "[爱你]", "[呃]", "[爱钱]", "[不看]", "[不听]", "[不说]", "[打脸]", "[悠闲]", "[捂脸]", "[菜刀]", "[啤酒]", "[干杯]", "[咖啡]", "[玫瑰]", "[凋谢]", "[嘴唇]", "[爱心]", "[心碎]", "[蛋糕]", "[炸弹]", "[便便]", "[月亮]", "[太阳]", "[拥抱]", "[摊手]", "[强]", "[弱]", "[握手]", "[胜利]", "[抱拳]", "[勾引]", "[拳头]", "[OK]", "[差劲]", "[加油]", "[NO]", "[比心]", "[合十]", "[礼物]", "[熊猫]", "[兔子]", "[草泥马]", "[猪头]", "[狗]", "[猫]", "[鞭炮]", "[话筒]", "[喝彩]", "[蜡烛]", "[棒棒糖]", "[浮云]", "[下雨]", "[气球]", "[药丸]", "[喜]", "[红包]", "[肥皂]" };
    while (i < b.length)
    {
      c.put(b[i], Integer.valueOf(a[i]));
      i++;
    }
  }
  
  public static int a(String paramString)
  {
    return ((Integer)c.get(paramString)).intValue();
  }
  
  public static SpannableString a(Context paramContext, CharSequence paramCharSequence)
  {
    SpannableString localSpannableString = new SpannableString(paramCharSequence);
    int k = paramCharSequence.length();
    int j = 0;
    int i = -1;
    if (j < k) {
      if (paramCharSequence.charAt(j) == '[') {
        i = j;
      }
    }
    for (;;)
    {
      j++;
      break;
      if ((paramCharSequence.charAt(j) == ']') && (i != -1))
      {
        Object localObject = paramCharSequence.subSequence(i, j + 1).toString();
        if (!c.containsKey(localObject)) {}
        for (localObject = null;; localObject = new ImageSpan((Drawable)localObject))
        {
          if (localObject != null) {
            localSpannableString.setSpan(localObject, i, j + 1, 33);
          }
          i = -1;
          break;
          localObject = paramContext.getResources().getDrawable(((Integer)c.get(localObject)).intValue());
          ((Drawable)localObject).setBounds(0, 0, d, d);
        }
        return localSpannableString;
      }
    }
  }
  
  public static void a(int paramInt)
  {
    d = paramInt;
  }
  
  public static boolean b(String paramString)
  {
    return c.containsKey(paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */