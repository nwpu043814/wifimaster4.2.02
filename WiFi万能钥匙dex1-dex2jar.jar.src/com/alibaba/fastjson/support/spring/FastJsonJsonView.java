package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.AbstractView;

public class FastJsonJsonView
  extends AbstractView
{
  public static final String DEFAULT_CONTENT_TYPE = "application/json";
  public static final Charset UTF8 = Charset.forName("UTF-8");
  private Charset charset = UTF8;
  private boolean disableCaching = true;
  private Set<String> renderedAttributes;
  private SerializerFeature[] serializerFeatures = new SerializerFeature[0];
  private boolean updateContentLength = false;
  
  public FastJsonJsonView()
  {
    setContentType("application/json");
    setExposePathVariables(false);
  }
  
  protected Object filterModel(Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap(paramMap.size());
    if (!CollectionUtils.isEmpty(this.renderedAttributes)) {}
    for (Set localSet = this.renderedAttributes;; localSet = paramMap.keySet())
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if ((!(localEntry.getValue() instanceof BindingResult)) && (localSet.contains(localEntry.getKey()))) {
          localHashMap.put(localEntry.getKey(), localEntry.getValue());
        }
      }
    }
    return localHashMap;
  }
  
  public Charset getCharset()
  {
    return this.charset;
  }
  
  public SerializerFeature[] getFeatures()
  {
    return this.serializerFeatures;
  }
  
  protected void prepareResponse(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
  {
    setResponseContentType(paramHttpServletRequest, paramHttpServletResponse);
    paramHttpServletResponse.setCharacterEncoding(UTF8.name());
    if (this.disableCaching)
    {
      paramHttpServletResponse.addHeader("Pragma", "no-cache");
      paramHttpServletResponse.addHeader("Cache-Control", "no-cache, no-store, max-age=0");
      paramHttpServletResponse.addDateHeader("Expires", 1L);
    }
  }
  
  protected void renderMergedOutputModel(Map<String, Object> paramMap, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
  {
    paramHttpServletRequest = JSON.toJSONString(filterModel(paramMap), this.serializerFeatures).getBytes(this.charset);
    if (this.updateContentLength) {}
    for (paramMap = createTemporaryOutputStream();; paramMap = paramHttpServletResponse.getOutputStream())
    {
      paramMap.write(paramHttpServletRequest);
      if (this.updateContentLength) {
        writeToResponse(paramHttpServletResponse, (ByteArrayOutputStream)paramMap);
      }
      return;
    }
  }
  
  public void setCharset(Charset paramCharset)
  {
    this.charset = paramCharset;
  }
  
  public void setDisableCaching(boolean paramBoolean)
  {
    this.disableCaching = paramBoolean;
  }
  
  public void setFeatures(SerializerFeature... paramVarArgs)
  {
    this.serializerFeatures = paramVarArgs;
  }
  
  public void setRenderedAttributes(Set<String> paramSet)
  {
    this.renderedAttributes = paramSet;
  }
  
  @Deprecated
  public void setSerializerFeature(SerializerFeature... paramVarArgs)
  {
    setFeatures(paramVarArgs);
  }
  
  public void setUpdateContentLength(boolean paramBoolean)
  {
    this.updateContentLength = paramBoolean;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/support/spring/FastJsonJsonView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */