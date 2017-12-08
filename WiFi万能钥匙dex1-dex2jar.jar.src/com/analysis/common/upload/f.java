package com.analysis.common.upload;

import java.io.File;
import java.io.FilenameFilter;

final class f
  implements FilenameFilter
{
  f(d paramd) {}
  
  public final boolean accept(File paramFile, String paramString)
  {
    return paramString.startsWith("crash_");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/upload/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */