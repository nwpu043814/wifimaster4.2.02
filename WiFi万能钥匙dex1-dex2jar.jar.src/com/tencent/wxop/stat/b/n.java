package com.tencent.wxop.stat.b;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class n
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    if (Pattern.matches("cpu[0-9]", paramFile.getName())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */