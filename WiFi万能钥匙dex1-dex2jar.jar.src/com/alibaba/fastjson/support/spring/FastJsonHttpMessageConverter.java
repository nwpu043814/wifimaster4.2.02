package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;

public class FastJsonHttpMessageConverter
  extends AbstractHttpMessageConverter<Object>
{
  public static final Charset UTF8 = Charset.forName("UTF-8");
  private Charset charset = UTF8;
  private SerializerFeature[] features = new SerializerFeature[0];
  
  public FastJsonHttpMessageConverter()
  {
    super(new MediaType[] { new MediaType("application", "json", UTF8), new MediaType("application", "*+json", UTF8) });
  }
  
  public Charset getCharset()
  {
    return this.charset;
  }
  
  public SerializerFeature[] getFeatures()
  {
    return this.features;
  }
  
  protected Object readInternal(Class<? extends Object> paramClass, HttpInputMessage paramHttpInputMessage)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    InputStream localInputStream = paramHttpInputMessage.getBody();
    paramHttpInputMessage = new byte['Ѐ'];
    for (;;)
    {
      int i = localInputStream.read(paramHttpInputMessage);
      if (i == -1) {
        break;
      }
      if (i > 0) {
        localByteArrayOutputStream.write(paramHttpInputMessage, 0, i);
      }
    }
    paramHttpInputMessage = localByteArrayOutputStream.toByteArray();
    return JSON.parseObject(paramHttpInputMessage, 0, paramHttpInputMessage.length, this.charset.newDecoder(), paramClass, new Feature[0]);
  }
  
  public void setCharset(Charset paramCharset)
  {
    this.charset = paramCharset;
  }
  
  public void setFeatures(SerializerFeature... paramVarArgs)
  {
    this.features = paramVarArgs;
  }
  
  protected boolean supports(Class<?> paramClass)
  {
    return true;
  }
  
  protected void writeInternal(Object paramObject, HttpOutputMessage paramHttpOutputMessage)
  {
    paramHttpOutputMessage.getBody().write(JSON.toJSONString(paramObject, this.features).getBytes(this.charset));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/support/spring/FastJsonHttpMessageConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */