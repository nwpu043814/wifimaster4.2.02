package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.IOUtils;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateSerializer
  implements ObjectSerializer
{
  public static final DateSerializer instance = new DateSerializer();
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType)
  {
    paramObject2 = paramJSONSerializer.getWriter();
    if (paramObject1 == null) {
      ((SerializeWriter)paramObject2).writeNull();
    }
    for (;;)
    {
      return;
      if ((((SerializeWriter)paramObject2).isEnabled(SerializerFeature.WriteClassName)) && (paramObject1.getClass() != paramType))
      {
        if (paramObject1.getClass() == Date.class)
        {
          ((SerializeWriter)paramObject2).write("new Date(");
          ((SerializeWriter)paramObject2).writeLongAndChar(((Date)paramObject1).getTime(), ')');
        }
        else
        {
          ((SerializeWriter)paramObject2).write('{');
          ((SerializeWriter)paramObject2).writeFieldName(JSON.DEFAULT_TYPE_KEY);
          paramJSONSerializer.write(paramObject1.getClass().getName());
          ((SerializeWriter)paramObject2).writeFieldValue(',', "val", ((Date)paramObject1).getTime());
          ((SerializeWriter)paramObject2).write('}');
        }
      }
      else
      {
        paramType = (Date)paramObject1;
        if (((SerializeWriter)paramObject2).isEnabled(SerializerFeature.WriteDateUseDateFormat))
        {
          paramObject1 = paramJSONSerializer.getDateFormat();
          paramJSONSerializer = (JSONSerializer)paramObject1;
          if (paramObject1 == null) {
            paramJSONSerializer = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT);
          }
          ((SerializeWriter)paramObject2).writeString(paramJSONSerializer.format(paramType));
        }
        else
        {
          long l = paramType.getTime();
          if (paramJSONSerializer.isEnabled(SerializerFeature.UseISO8601DateFormat))
          {
            label197:
            int k;
            int j;
            int i2;
            int i1;
            int n;
            int i;
            if (paramJSONSerializer.isEnabled(SerializerFeature.UseSingleQuotes))
            {
              ((SerializeWriter)paramObject2).append('\'');
              paramObject1 = Calendar.getInstance();
              ((Calendar)paramObject1).setTimeInMillis(l);
              k = ((Calendar)paramObject1).get(1);
              j = ((Calendar)paramObject1).get(2) + 1;
              i2 = ((Calendar)paramObject1).get(5);
              i1 = ((Calendar)paramObject1).get(11);
              n = ((Calendar)paramObject1).get(12);
              i = ((Calendar)paramObject1).get(13);
              int m = ((Calendar)paramObject1).get(14);
              if (m == 0) {
                break label363;
              }
              paramObject1 = "0000-00-00T00:00:00.000".toCharArray();
              IOUtils.getChars(m, 23, (char[])paramObject1);
              IOUtils.getChars(i, 19, (char[])paramObject1);
              IOUtils.getChars(n, 16, (char[])paramObject1);
              IOUtils.getChars(i1, 13, (char[])paramObject1);
              IOUtils.getChars(i2, 10, (char[])paramObject1);
              IOUtils.getChars(j, 7, (char[])paramObject1);
              IOUtils.getChars(k, 4, (char[])paramObject1);
            }
            for (;;)
            {
              ((SerializeWriter)paramObject2).write((char[])paramObject1);
              if (!paramJSONSerializer.isEnabled(SerializerFeature.UseSingleQuotes)) {
                break label466;
              }
              ((SerializeWriter)paramObject2).append('\'');
              break;
              ((SerializeWriter)paramObject2).append('"');
              break label197;
              label363:
              if ((i == 0) && (n == 0) && (i1 == 0))
              {
                paramObject1 = "0000-00-00".toCharArray();
                IOUtils.getChars(i2, 10, (char[])paramObject1);
                IOUtils.getChars(j, 7, (char[])paramObject1);
                IOUtils.getChars(k, 4, (char[])paramObject1);
              }
              else
              {
                paramObject1 = "0000-00-00T00:00:00".toCharArray();
                IOUtils.getChars(i, 19, (char[])paramObject1);
                IOUtils.getChars(n, 16, (char[])paramObject1);
                IOUtils.getChars(i1, 13, (char[])paramObject1);
                IOUtils.getChars(i2, 10, (char[])paramObject1);
                IOUtils.getChars(j, 7, (char[])paramObject1);
                IOUtils.getChars(k, 4, (char[])paramObject1);
              }
            }
            label466:
            ((SerializeWriter)paramObject2).append('"');
          }
          else
          {
            ((SerializeWriter)paramObject2).writeLong(l);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/serializer/DateSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */