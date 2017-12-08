package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.asm.ASMException;
import com.alibaba.fastjson.asm.ClassWriter;
import com.alibaba.fastjson.asm.FieldVisitor;
import com.alibaba.fastjson.asm.Label;
import com.alibaba.fastjson.asm.MethodVisitor;
import com.alibaba.fastjson.asm.Opcodes;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.DefaultJSONParser.ResolveTask;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONLexerBase;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.SymbolTable;
import com.alibaba.fastjson.util.ASMClassLoader;
import com.alibaba.fastjson.util.ASMUtils;
import com.alibaba.fastjson.util.DeserializeBeanInfo;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

public class ASMDeserializerFactory
  implements Opcodes
{
  private static final ASMDeserializerFactory instance = new ASMDeserializerFactory();
  private ASMClassLoader classLoader = new ASMClassLoader();
  private final AtomicLong seed = new AtomicLong();
  
  private void _batchSet(Context paramContext, MethodVisitor paramMethodVisitor)
  {
    _batchSet(paramContext, paramMethodVisitor, true);
  }
  
  private void _batchSet(Context paramContext, MethodVisitor paramMethodVisitor, boolean paramBoolean)
  {
    int j = paramContext.getFieldInfoList().size();
    for (int i = 0; i < j; i++)
    {
      Label localLabel = new Label();
      if (paramBoolean) {
        _isFlag(paramMethodVisitor, paramContext, i, localLabel);
      }
      _loadAndSet(paramContext, paramMethodVisitor, (FieldInfo)paramContext.getFieldInfoList().get(i));
      if (paramBoolean) {
        paramMethodVisitor.visitLabel(localLabel);
      }
    }
  }
  
  private void _createInstance(ClassWriter paramClassWriter, Context paramContext)
  {
    paramClassWriter = paramClassWriter.visitMethod(1, "createInstance", "(" + ASMUtils.getDesc(DefaultJSONParser.class) + ASMUtils.getDesc(java.lang.reflect.Type.class) + ")Ljava/lang/Object;", null, null);
    paramClassWriter.visitTypeInsn(187, ASMUtils.getType(paramContext.getClazz()));
    paramClassWriter.visitInsn(89);
    paramClassWriter.visitMethodInsn(183, ASMUtils.getType(paramContext.getClazz()), "<init>", "()V");
    paramClassWriter.visitInsn(176);
    paramClassWriter.visitMaxs(3, 3);
    paramClassWriter.visitEnd();
  }
  
  private void _createInstance(Context paramContext, MethodVisitor paramMethodVisitor)
  {
    if (Modifier.isPublic(paramContext.getBeanInfo().getDefaultConstructor().getModifiers()))
    {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.getType(paramContext.getClazz()));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.getType(paramContext.getClazz()), "<init>", "()V");
      paramMethodVisitor.visitVarInsn(58, paramContext.var("instance"));
    }
    for (;;)
    {
      return;
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.getType(ASMJavaBeanDeserializer.class), "createInstance", "(" + ASMUtils.getDesc(DefaultJSONParser.class) + ")Ljava/lang/Object;");
      paramMethodVisitor.visitTypeInsn(192, ASMUtils.getType(paramContext.getClazz()));
      paramMethodVisitor.visitVarInsn(58, paramContext.var("instance"));
    }
  }
  
  private void _deserObject(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Class<?> paramClass)
  {
    _getFieldDeser(paramContext, paramMethodVisitor, paramFieldInfo);
    paramMethodVisitor.visitVarInsn(25, 1);
    if ((paramFieldInfo.getFieldType() instanceof Class)) {
      paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(paramFieldInfo.getFieldClass())));
    }
    for (;;)
    {
      paramMethodVisitor.visitLdcInsn(paramFieldInfo.getName());
      paramMethodVisitor.visitMethodInsn(185, ASMUtils.getType(ObjectDeserializer.class), "deserialze", "(" + ASMUtils.getDesc(DefaultJSONParser.class) + ASMUtils.getDesc(java.lang.reflect.Type.class) + "Ljava/lang/Object;)Ljava/lang/Object;");
      paramMethodVisitor.visitTypeInsn(192, ASMUtils.getType(paramClass));
      paramMethodVisitor.visitVarInsn(58, paramContext.var(paramFieldInfo.getName() + "_asm"));
      return;
      paramMethodVisitor.visitVarInsn(25, 0);
      paramMethodVisitor.visitLdcInsn(paramFieldInfo.getName());
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(ASMJavaBeanDeserializer.class), "getFieldType", "(Ljava/lang/String;)Ljava/lang/reflect/Type;");
    }
  }
  
  private void _deserialize_endCheck(Context paramContext, MethodVisitor paramMethodVisitor, Label paramLabel)
  {
    Label localLabel = new Label();
    paramMethodVisitor.visitIntInsn(21, paramContext.var("matchedCount"));
    paramMethodVisitor.visitJumpInsn(158, paramLabel);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "token", "()I");
    paramMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "RBRACE", "I");
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "COMMA", "I");
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "nextToken", "(I)V");
    paramMethodVisitor.visitLabel(localLabel);
  }
  
  private void _deserialze_list_obj(Context paramContext, MethodVisitor paramMethodVisitor, Label paramLabel, FieldInfo paramFieldInfo, Class<?> paramClass1, Class<?> paramClass2, int paramInt)
  {
    Label localLabel2 = new Label();
    Label localLabel1 = new Label();
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "matchField", "([C)Z");
    paramMethodVisitor.visitJumpInsn(154, localLabel2);
    paramMethodVisitor.visitInsn(1);
    paramMethodVisitor.visitVarInsn(58, paramContext.var(paramFieldInfo.getName() + "_asm"));
    paramMethodVisitor.visitJumpInsn(167, localLabel1);
    paramMethodVisitor.visitLabel(localLabel2);
    _setFlag(paramMethodVisitor, paramContext, paramInt);
    localLabel2 = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "token", "()I");
    paramMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "NULL", "I");
    paramMethodVisitor.visitJumpInsn(160, localLabel2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "COMMA", "I");
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "nextToken", "(I)V");
    paramMethodVisitor.visitInsn(1);
    paramMethodVisitor.visitTypeInsn(192, ASMUtils.getType(paramClass1));
    paramMethodVisitor.visitVarInsn(58, paramContext.var(paramFieldInfo.getName() + "_asm"));
    paramMethodVisitor.visitLabel(localLabel2);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "token", "()I");
    paramMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "LBRACKET", "I");
    paramMethodVisitor.visitJumpInsn(160, paramLabel);
    _getCollectionFieldItemDeser(paramContext, paramMethodVisitor, paramFieldInfo, paramClass2);
    paramMethodVisitor.visitMethodInsn(185, ASMUtils.getType(ObjectDeserializer.class), "getFastMatchToken", "()I");
    paramMethodVisitor.visitVarInsn(54, paramContext.var("fastMatchToken"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("fastMatchToken"));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "nextToken", "(I)V");
    _newCollection(paramMethodVisitor, paramClass1);
    paramMethodVisitor.visitVarInsn(58, paramContext.var(paramFieldInfo.getName() + "_asm"));
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "getContext", "()" + ASMUtils.getDesc(ParseContext.class));
    paramMethodVisitor.visitVarInsn(58, paramContext.var("listContext"));
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.getName() + "_asm"));
    paramMethodVisitor.visitLdcInsn(paramFieldInfo.getName());
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "setContext", "(Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.getDesc(ParseContext.class));
    paramMethodVisitor.visitInsn(87);
    Label localLabel3 = new Label();
    localLabel2 = new Label();
    paramMethodVisitor.visitInsn(3);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("i"));
    paramMethodVisitor.visitLabel(localLabel3);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "token", "()I");
    paramMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "RBRACKET", "I");
    paramMethodVisitor.visitJumpInsn(159, localLabel2);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.getClassName(), paramFieldInfo.getName() + "_asm_list_item_deser__", ASMUtils.getDesc(ObjectDeserializer.class));
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(paramClass2)));
    paramMethodVisitor.visitVarInsn(21, paramContext.var("i"));
    paramMethodVisitor.visitMethodInsn(184, ASMUtils.getType(Integer.class), "valueOf", "(I)Ljava/lang/Integer;");
    paramMethodVisitor.visitMethodInsn(185, ASMUtils.getType(ObjectDeserializer.class), "deserialze", "(" + ASMUtils.getDesc(DefaultJSONParser.class) + "Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
    paramMethodVisitor.visitVarInsn(58, paramContext.var("list_item_value"));
    paramMethodVisitor.visitIincInsn(paramContext.var("i"), 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.getName() + "_asm"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("list_item_value"));
    if (paramClass1.isInterface()) {
      paramMethodVisitor.visitMethodInsn(185, ASMUtils.getType(paramClass1), "add", "(Ljava/lang/Object;)Z");
    }
    for (;;)
    {
      paramMethodVisitor.visitInsn(87);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.getName() + "_asm"));
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "checkListResolve", "(Ljava/util/Collection;)V");
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "token", "()I");
      paramMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "COMMA", "I");
      paramMethodVisitor.visitJumpInsn(160, localLabel3);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var("fastMatchToken"));
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "nextToken", "(I)V");
      paramMethodVisitor.visitJumpInsn(167, localLabel3);
      paramMethodVisitor.visitLabel(localLabel2);
      paramMethodVisitor.visitVarInsn(25, 1);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("listContext"));
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "setContext", "(" + ASMUtils.getDesc(ParseContext.class) + ")V");
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "token", "()I");
      paramMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "RBRACKET", "I");
      paramMethodVisitor.visitJumpInsn(160, paramLabel);
      paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
      paramMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "COMMA", "I");
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "nextToken", "(I)V");
      paramMethodVisitor.visitLabel(localLabel1);
      return;
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(paramClass1), "add", "(Ljava/lang/Object;)Z");
    }
  }
  
  private void _deserialze_obj(Context paramContext, MethodVisitor paramMethodVisitor, Label paramLabel, FieldInfo paramFieldInfo, Class<?> paramClass, int paramInt)
  {
    paramLabel = new Label();
    Label localLabel = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.getClassName(), paramFieldInfo.getName() + "_asm_prefix__", "[C");
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "matchField", "([C)Z");
    paramMethodVisitor.visitJumpInsn(154, paramLabel);
    paramMethodVisitor.visitInsn(1);
    paramMethodVisitor.visitVarInsn(58, paramContext.var(paramFieldInfo.getName() + "_asm"));
    paramMethodVisitor.visitJumpInsn(167, localLabel);
    paramMethodVisitor.visitLabel(paramLabel);
    _setFlag(paramMethodVisitor, paramContext, paramInt);
    paramMethodVisitor.visitVarInsn(21, paramContext.var("matchedCount"));
    paramMethodVisitor.visitInsn(4);
    paramMethodVisitor.visitInsn(96);
    paramMethodVisitor.visitVarInsn(54, paramContext.var("matchedCount"));
    _deserObject(paramContext, paramMethodVisitor, paramFieldInfo, paramClass);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "getResolveStatus", "()I");
    paramMethodVisitor.visitFieldInsn(178, ASMUtils.getType(DefaultJSONParser.class), "NeedToResolve", "I");
    paramMethodVisitor.visitJumpInsn(160, localLabel);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "getLastResolveTask", "()" + ASMUtils.getDesc(DefaultJSONParser.ResolveTask.class));
    paramMethodVisitor.visitVarInsn(58, paramContext.var("resolveTask"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("resolveTask"));
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "getContext", "()" + ASMUtils.getDesc(ParseContext.class));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.ResolveTask.class), "setOwnerContext", "(" + ASMUtils.getDesc(ParseContext.class) + ")V");
    paramMethodVisitor.visitVarInsn(25, paramContext.var("resolveTask"));
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitLdcInsn(paramFieldInfo.getName());
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(ASMJavaBeanDeserializer.class), "getFieldDeserializer", "(Ljava/lang/String;)" + ASMUtils.getDesc(FieldDeserializer.class));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.ResolveTask.class), "setFieldDeserializer", "(" + ASMUtils.getDesc(FieldDeserializer.class) + ")V");
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitFieldInsn(178, ASMUtils.getType(DefaultJSONParser.class), "NONE", "I");
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "setResolveStatus", "(I)V");
    paramMethodVisitor.visitLabel(localLabel);
  }
  
  private void _getCollectionFieldItemDeser(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo, Class<?> paramClass)
  {
    Label localLabel = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.getClassName(), paramFieldInfo.getName() + "_asm_list_item_deser__", ASMUtils.getDesc(ObjectDeserializer.class));
    paramMethodVisitor.visitJumpInsn(199, localLabel);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "getConfig", "()" + ASMUtils.getDesc(ParserConfig.class));
    paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(paramClass)));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(ParserConfig.class), "getDeserializer", "(" + ASMUtils.getDesc(java.lang.reflect.Type.class) + ")" + ASMUtils.getDesc(ObjectDeserializer.class));
    paramMethodVisitor.visitFieldInsn(181, paramContext.getClassName(), paramFieldInfo.getName() + "_asm_list_item_deser__", ASMUtils.getDesc(ObjectDeserializer.class));
    paramMethodVisitor.visitLabel(localLabel);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.getClassName(), paramFieldInfo.getName() + "_asm_list_item_deser__", ASMUtils.getDesc(ObjectDeserializer.class));
  }
  
  private void _getFieldDeser(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo)
  {
    Label localLabel = new Label();
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.getClassName(), paramFieldInfo.getName() + "_asm_deser__", ASMUtils.getDesc(ObjectDeserializer.class));
    paramMethodVisitor.visitJumpInsn(199, localLabel);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "getConfig", "()" + ASMUtils.getDesc(ParserConfig.class));
    paramMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(paramFieldInfo.getFieldClass())));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(ParserConfig.class), "getDeserializer", "(" + ASMUtils.getDesc(java.lang.reflect.Type.class) + ")" + ASMUtils.getDesc(ObjectDeserializer.class));
    paramMethodVisitor.visitFieldInsn(181, paramContext.getClassName(), paramFieldInfo.getName() + "_asm_deser__", ASMUtils.getDesc(ObjectDeserializer.class));
    paramMethodVisitor.visitLabel(localLabel);
    paramMethodVisitor.visitVarInsn(25, 0);
    paramMethodVisitor.visitFieldInsn(180, paramContext.getClassName(), paramFieldInfo.getName() + "_asm_deser__", ASMUtils.getDesc(ObjectDeserializer.class));
  }
  
  private void _init(ClassWriter paramClassWriter, Context paramContext)
  {
    int j = paramContext.getFieldInfoList().size();
    for (int i = 0; i < j; i++)
    {
      localObject = (FieldInfo)paramContext.getFieldInfoList().get(i);
      paramClassWriter.visitField(1, ((FieldInfo)localObject).getName() + "_asm_prefix__", "[C").visitEnd();
    }
    j = paramContext.getFieldInfoList().size();
    i = 0;
    if (i < j)
    {
      FieldInfo localFieldInfo = (FieldInfo)paramContext.getFieldInfoList().get(i);
      localObject = localFieldInfo.getFieldClass();
      if ((!((Class)localObject).isPrimitive()) && (!((Class)localObject).isEnum()))
      {
        if (!Collection.class.isAssignableFrom((Class)localObject)) {
          break label190;
        }
        paramClassWriter.visitField(1, localFieldInfo.getName() + "_asm_list_item_deser__", ASMUtils.getDesc(ObjectDeserializer.class)).visitEnd();
      }
      for (;;)
      {
        i++;
        break;
        label190:
        paramClassWriter.visitField(1, localFieldInfo.getName() + "_asm_deser__", ASMUtils.getDesc(ObjectDeserializer.class)).visitEnd();
      }
    }
    Object localObject = paramClassWriter.visitMethod(1, "<init>", "(" + ASMUtils.getDesc(ParserConfig.class) + ASMUtils.getDesc(Class.class) + ")V", null, null);
    ((MethodVisitor)localObject).visitVarInsn(25, 0);
    ((MethodVisitor)localObject).visitVarInsn(25, 1);
    ((MethodVisitor)localObject).visitVarInsn(25, 2);
    ((MethodVisitor)localObject).visitMethodInsn(183, ASMUtils.getType(ASMJavaBeanDeserializer.class), "<init>", "(" + ASMUtils.getDesc(ParserConfig.class) + ASMUtils.getDesc(Class.class) + ")V");
    ((MethodVisitor)localObject).visitVarInsn(25, 0);
    ((MethodVisitor)localObject).visitFieldInsn(180, ASMUtils.getType(ASMJavaBeanDeserializer.class), "serializer", ASMUtils.getDesc(ASMJavaBeanDeserializer.InnerJavaBeanDeserializer.class));
    ((MethodVisitor)localObject).visitMethodInsn(182, ASMUtils.getType(JavaBeanDeserializer.class), "getFieldDeserializerMap", "()" + ASMUtils.getDesc(Map.class));
    ((MethodVisitor)localObject).visitInsn(87);
    j = paramContext.getFieldInfoList().size();
    for (i = 0; i < j; i++)
    {
      paramClassWriter = (FieldInfo)paramContext.getFieldInfoList().get(i);
      ((MethodVisitor)localObject).visitVarInsn(25, 0);
      ((MethodVisitor)localObject).visitLdcInsn("\"" + paramClassWriter.getName() + "\":");
      ((MethodVisitor)localObject).visitMethodInsn(182, ASMUtils.getType(String.class), "toCharArray", "()" + ASMUtils.getDesc(char[].class));
      ((MethodVisitor)localObject).visitFieldInsn(181, paramContext.getClassName(), paramClassWriter.getName() + "_asm_prefix__", "[C");
    }
    ((MethodVisitor)localObject).visitInsn(177);
    ((MethodVisitor)localObject).visitMaxs(4, 4);
    ((MethodVisitor)localObject).visitEnd();
  }
  
  private void _isEnable(Context paramContext, MethodVisitor paramMethodVisitor, Feature paramFeature)
  {
    paramMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    paramMethodVisitor.visitFieldInsn(178, ASMUtils.getType(Feature.class), paramFeature.name(), "L" + ASMUtils.getType(Feature.class) + ";");
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "isEnabled", "(L" + ASMUtils.getType(Feature.class) + ";)Z");
  }
  
  private void _loadAndSet(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo)
  {
    Class localClass = paramFieldInfo.getFieldClass();
    java.lang.reflect.Type localType = paramFieldInfo.getFieldType();
    if (localClass == Boolean.TYPE)
    {
      paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
      paramMethodVisitor.visitVarInsn(21, paramContext.var(paramFieldInfo.getName() + "_asm"));
      _set(paramContext, paramMethodVisitor, paramFieldInfo);
    }
    for (;;)
    {
      return;
      if ((localClass == Byte.TYPE) || (localClass == Short.TYPE) || (localClass == Integer.TYPE) || (localClass == Character.TYPE))
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        paramMethodVisitor.visitVarInsn(21, paramContext.var(paramFieldInfo.getName() + "_asm"));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
      }
      else if (localClass == Long.TYPE)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        paramMethodVisitor.visitVarInsn(22, paramContext.var(paramFieldInfo.getName() + "_asm", 2));
        if (paramFieldInfo.getMethod() != null)
        {
          paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(paramContext.getClazz()), paramFieldInfo.getMethod().getName(), ASMUtils.getDesc(paramFieldInfo.getMethod()));
          if (!paramFieldInfo.getMethod().getReturnType().equals(Void.TYPE)) {
            paramMethodVisitor.visitInsn(87);
          }
        }
        else
        {
          paramMethodVisitor.visitFieldInsn(181, ASMUtils.getType(paramFieldInfo.getDeclaringClass()), paramFieldInfo.getField().getName(), ASMUtils.getDesc(paramFieldInfo.getFieldClass()));
        }
      }
      else if (localClass == Float.TYPE)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        paramMethodVisitor.visitVarInsn(23, paramContext.var(paramFieldInfo.getName() + "_asm"));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
      }
      else if (localClass == Double.TYPE)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        paramMethodVisitor.visitVarInsn(24, paramContext.var(paramFieldInfo.getName() + "_asm", 2));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
      }
      else if (localClass == String.class)
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.getName() + "_asm"));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
      }
      else if (localClass.isEnum())
      {
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.getName() + "_asm"));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
      }
      else
      {
        if (Collection.class.isAssignableFrom(localClass))
        {
          paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
          if (getCollectionItemClass(localType) == String.class)
          {
            paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.getName() + "_asm"));
            paramMethodVisitor.visitTypeInsn(192, ASMUtils.getType(localClass));
          }
          for (;;)
          {
            _set(paramContext, paramMethodVisitor, paramFieldInfo);
            break;
            paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.getName() + "_asm"));
          }
        }
        paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
        paramMethodVisitor.visitVarInsn(25, paramContext.var(paramFieldInfo.getName() + "_asm"));
        _set(paramContext, paramMethodVisitor, paramFieldInfo);
      }
    }
  }
  
  private void _newCollection(MethodVisitor paramMethodVisitor, Class<?> paramClass)
  {
    if (paramClass.isAssignableFrom(ArrayList.class))
    {
      paramMethodVisitor.visitTypeInsn(187, ASMUtils.getType(ArrayList.class));
      paramMethodVisitor.visitInsn(89);
      paramMethodVisitor.visitMethodInsn(183, ASMUtils.getType(ArrayList.class), "<init>", "()V");
    }
    for (;;)
    {
      paramMethodVisitor.visitTypeInsn(192, ASMUtils.getType(paramClass));
      return;
      if (paramClass.isAssignableFrom(LinkedList.class))
      {
        paramMethodVisitor.visitTypeInsn(187, ASMUtils.getType(LinkedList.class));
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitMethodInsn(183, ASMUtils.getType(LinkedList.class), "<init>", "()V");
      }
      else if (paramClass.isAssignableFrom(HashSet.class))
      {
        paramMethodVisitor.visitTypeInsn(187, ASMUtils.getType(HashSet.class));
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitMethodInsn(183, ASMUtils.getType(HashSet.class), "<init>", "()V");
      }
      else if (paramClass.isAssignableFrom(TreeSet.class))
      {
        paramMethodVisitor.visitTypeInsn(187, ASMUtils.getType(TreeSet.class));
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitMethodInsn(183, ASMUtils.getType(TreeSet.class), "<init>", "()V");
      }
      else
      {
        paramMethodVisitor.visitTypeInsn(187, ASMUtils.getType(paramClass));
        paramMethodVisitor.visitInsn(89);
        paramMethodVisitor.visitMethodInsn(183, ASMUtils.getType(paramClass), "<init>", "()V");
      }
    }
  }
  
  private void _set(Context paramContext, MethodVisitor paramMethodVisitor, FieldInfo paramFieldInfo)
  {
    if (paramFieldInfo.getMethod() != null)
    {
      paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(paramFieldInfo.getDeclaringClass()), paramFieldInfo.getMethod().getName(), ASMUtils.getDesc(paramFieldInfo.getMethod()));
      if (!paramFieldInfo.getMethod().getReturnType().equals(Void.TYPE)) {
        paramMethodVisitor.visitInsn(87);
      }
    }
    for (;;)
    {
      return;
      paramMethodVisitor.visitFieldInsn(181, ASMUtils.getType(paramFieldInfo.getDeclaringClass()), paramFieldInfo.getField().getName(), ASMUtils.getDesc(paramFieldInfo.getFieldClass()));
    }
  }
  
  private void _setContext(Context paramContext, MethodVisitor paramMethodVisitor)
  {
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("context"));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "setContext", "(" + ASMUtils.getDesc(ParseContext.class) + ")V");
    Label localLabel = new Label();
    paramMethodVisitor.visitVarInsn(25, paramContext.var("childContext"));
    paramMethodVisitor.visitJumpInsn(198, localLabel);
    paramMethodVisitor.visitVarInsn(25, paramContext.var("childContext"));
    paramMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(ParseContext.class), "setObject", "(Ljava/lang/Object;)V");
    paramMethodVisitor.visitLabel(localLabel);
  }
  
  private void defineVarLexer(Context paramContext, MethodVisitor paramMethodVisitor)
  {
    paramMethodVisitor.visitVarInsn(25, 1);
    paramMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "getLexer", "()" + ASMUtils.getDesc(JSONLexer.class));
    paramMethodVisitor.visitTypeInsn(192, ASMUtils.getType(JSONLexerBase.class));
    paramMethodVisitor.visitVarInsn(58, paramContext.var("lexer"));
  }
  
  private Class<?> getCollectionItemClass(java.lang.reflect.Type paramType)
  {
    if ((paramType instanceof ParameterizedType))
    {
      paramType = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      if ((paramType instanceof Class))
      {
        Class localClass = (Class)paramType;
        paramType = localClass;
        if (!Modifier.isPublic(localClass.getModifiers())) {
          throw new ASMException("can not create ASMParser");
        }
      }
      else
      {
        throw new ASMException("can not create ASMParser");
      }
    }
    else
    {
      paramType = Object.class;
    }
    return paramType;
  }
  
  public static final ASMDeserializerFactory getInstance()
  {
    return instance;
  }
  
  void _deserialze(ClassWriter paramClassWriter, Context paramContext)
  {
    if (paramContext.getFieldInfoList().size() == 0) {}
    for (;;)
    {
      return;
      Object localObject2 = paramContext.getFieldInfoList().iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FieldInfo)((Iterator)localObject2).next();
          localObject1 = ((FieldInfo)localObject3).getFieldClass();
          localObject3 = ((FieldInfo)localObject3).getFieldType();
          if (localObject1 == Character.TYPE) {
            break;
          }
          if (Collection.class.isAssignableFrom((Class)localObject1))
          {
            if (!(localObject3 instanceof ParameterizedType)) {
              break;
            }
            if (!(((ParameterizedType)localObject3).getActualTypeArguments()[0] instanceof Class)) {
              break;
            }
          }
        }
      }
      Collections.sort(paramContext.getFieldInfoList());
      localObject2 = paramClassWriter.visitMethod(1, "deserialze", "(" + ASMUtils.getDesc(DefaultJSONParser.class) + ASMUtils.getDesc(java.lang.reflect.Type.class) + "Ljava/lang/Object;)Ljava/lang/Object;", null, null);
      Object localObject1 = new Label();
      paramClassWriter = new Label();
      Object localObject3 = new Label();
      Label localLabel = new Label();
      defineVarLexer(paramContext, (MethodVisitor)localObject2);
      _isEnable(paramContext, (MethodVisitor)localObject2, Feature.SortFeidFastMatch);
      ((MethodVisitor)localObject2).visitJumpInsn(153, paramClassWriter);
      Object localObject4 = new Label();
      ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
      ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "token", "()I");
      ((MethodVisitor)localObject2).visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "LBRACKET", "I");
      ((MethodVisitor)localObject2).visitJumpInsn(160, (Label)localObject4);
      ((MethodVisitor)localObject2).visitVarInsn(25, 0);
      ((MethodVisitor)localObject2).visitVarInsn(25, 1);
      ((MethodVisitor)localObject2).visitVarInsn(25, 2);
      ((MethodVisitor)localObject2).visitVarInsn(25, 3);
      ((MethodVisitor)localObject2).visitMethodInsn(183, paramContext.getClassName(), "deserialzeArrayMapping", "(" + ASMUtils.getDesc(DefaultJSONParser.class) + ASMUtils.getDesc(java.lang.reflect.Type.class) + "Ljava/lang/Object;)Ljava/lang/Object;");
      ((MethodVisitor)localObject2).visitInsn(176);
      ((MethodVisitor)localObject2).visitLabel((Label)localObject4);
      ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
      ((MethodVisitor)localObject2).visitLdcInsn(paramContext.getClazz().getName());
      ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanType", "(Ljava/lang/String;)I");
      ((MethodVisitor)localObject2).visitFieldInsn(178, ASMUtils.getType(JSONLexerBase.class), "NOT_MATCH", "I");
      ((MethodVisitor)localObject2).visitJumpInsn(159, paramClassWriter);
      ((MethodVisitor)localObject2).visitVarInsn(25, 1);
      ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "getContext", "()Lcom/alibaba/fastjson/parser/ParseContext;");
      ((MethodVisitor)localObject2).visitVarInsn(58, paramContext.var("mark_context"));
      ((MethodVisitor)localObject2).visitInsn(3);
      ((MethodVisitor)localObject2).visitVarInsn(54, paramContext.var("matchedCount"));
      _createInstance(paramContext, (MethodVisitor)localObject2);
      ((MethodVisitor)localObject2).visitVarInsn(25, 1);
      ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "getContext", "()" + ASMUtils.getDesc(ParseContext.class));
      ((MethodVisitor)localObject2).visitVarInsn(58, paramContext.var("context"));
      ((MethodVisitor)localObject2).visitVarInsn(25, 1);
      ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("context"));
      ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("instance"));
      ((MethodVisitor)localObject2).visitVarInsn(25, 3);
      ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "setContext", "(" + ASMUtils.getDesc(ParseContext.class) + "Ljava/lang/Object;Ljava/lang/Object;)" + ASMUtils.getDesc(ParseContext.class));
      ((MethodVisitor)localObject2).visitVarInsn(58, paramContext.var("childContext"));
      ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
      ((MethodVisitor)localObject2).visitFieldInsn(180, ASMUtils.getType(JSONLexerBase.class), "matchStat", "I");
      ((MethodVisitor)localObject2).visitFieldInsn(178, ASMUtils.getType(JSONLexerBase.class), "END", "I");
      ((MethodVisitor)localObject2).visitJumpInsn(159, (Label)localObject3);
      ((MethodVisitor)localObject2).visitInsn(3);
      ((MethodVisitor)localObject2).visitIntInsn(54, paramContext.var("matchStat"));
      int j = paramContext.getFieldInfoList().size();
      for (int i = 0; i < j; i += 32)
      {
        ((MethodVisitor)localObject2).visitInsn(3);
        ((MethodVisitor)localObject2).visitVarInsn(54, paramContext.var("_asm_flag_" + i / 32));
      }
      i = 0;
      Object localObject6;
      label1189:
      Object localObject5;
      if (i < j)
      {
        localObject4 = (FieldInfo)paramContext.getFieldInfoList().get(i);
        localObject6 = ((FieldInfo)localObject4).getFieldClass();
        if ((localObject6 == Boolean.TYPE) || (localObject6 == Byte.TYPE) || (localObject6 == Short.TYPE) || (localObject6 == Integer.TYPE))
        {
          ((MethodVisitor)localObject2).visitInsn(3);
          ((MethodVisitor)localObject2).visitVarInsn(54, paramContext.var(((FieldInfo)localObject4).getName() + "_asm"));
        }
        for (;;)
        {
          i++;
          break;
          if (localObject6 == Long.TYPE)
          {
            ((MethodVisitor)localObject2).visitInsn(9);
            ((MethodVisitor)localObject2).visitVarInsn(55, paramContext.var(((FieldInfo)localObject4).getName() + "_asm", 2));
          }
          else if (localObject6 == Float.TYPE)
          {
            ((MethodVisitor)localObject2).visitInsn(11);
            ((MethodVisitor)localObject2).visitVarInsn(56, paramContext.var(((FieldInfo)localObject4).getName() + "_asm"));
          }
          else
          {
            if (localObject6 != Double.TYPE) {
              break label1189;
            }
            ((MethodVisitor)localObject2).visitInsn(14);
            ((MethodVisitor)localObject2).visitVarInsn(57, paramContext.var(((FieldInfo)localObject4).getName() + "_asm", 2));
          }
        }
        if (localObject6 == String.class)
        {
          localObject5 = new Label();
          _isEnable(paramContext, (MethodVisitor)localObject2, Feature.InitStringFieldAsEmpty);
          ((MethodVisitor)localObject2).visitJumpInsn(153, (Label)localObject5);
          _setFlag((MethodVisitor)localObject2, paramContext, i);
          ((MethodVisitor)localObject2).visitLabel((Label)localObject5);
          ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
          ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "stringDefaultValue", "()Ljava/lang/String;");
        }
        for (;;)
        {
          ((MethodVisitor)localObject2).visitTypeInsn(192, ASMUtils.getType((Class)localObject6));
          ((MethodVisitor)localObject2).visitVarInsn(58, paramContext.var(((FieldInfo)localObject4).getName() + "_asm"));
          break;
          ((MethodVisitor)localObject2).visitInsn(1);
        }
      }
      i = 0;
      if (i < j)
      {
        localObject5 = (FieldInfo)paramContext.getFieldInfoList().get(i);
        localObject6 = ((FieldInfo)localObject5).getFieldClass();
        Object localObject7 = ((FieldInfo)localObject5).getFieldType();
        localObject4 = new Label();
        if (localObject6 == Boolean.TYPE)
        {
          ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
          ((MethodVisitor)localObject2).visitVarInsn(25, 0);
          ((MethodVisitor)localObject2).visitFieldInsn(180, paramContext.getClassName(), ((FieldInfo)localObject5).getName() + "_asm_prefix__", "[C");
          ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanFieldBoolean", "([C)Z");
          ((MethodVisitor)localObject2).visitVarInsn(54, paramContext.var(((FieldInfo)localObject5).getName() + "_asm"));
          label1522:
          ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
          ((MethodVisitor)localObject2).visitFieldInsn(180, ASMUtils.getType(JSONLexerBase.class), "matchStat", "I");
          localObject5 = new Label();
          ((MethodVisitor)localObject2).visitJumpInsn(158, (Label)localObject5);
          _setFlag((MethodVisitor)localObject2, paramContext, i);
          ((MethodVisitor)localObject2).visitLabel((Label)localObject5);
          ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
          ((MethodVisitor)localObject2).visitFieldInsn(180, ASMUtils.getType(JSONLexerBase.class), "matchStat", "I");
          ((MethodVisitor)localObject2).visitInsn(89);
          ((MethodVisitor)localObject2).visitVarInsn(54, paramContext.var("matchStat"));
          ((MethodVisitor)localObject2).visitFieldInsn(178, ASMUtils.getType(JSONLexerBase.class), "NOT_MATCH", "I");
          ((MethodVisitor)localObject2).visitJumpInsn(159, (Label)localObject1);
          ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
          ((MethodVisitor)localObject2).visitFieldInsn(180, ASMUtils.getType(JSONLexerBase.class), "matchStat", "I");
          ((MethodVisitor)localObject2).visitJumpInsn(158, (Label)localObject4);
          ((MethodVisitor)localObject2).visitVarInsn(21, paramContext.var("matchedCount"));
          ((MethodVisitor)localObject2).visitInsn(4);
          ((MethodVisitor)localObject2).visitInsn(96);
          ((MethodVisitor)localObject2).visitVarInsn(54, paramContext.var("matchedCount"));
          ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
          ((MethodVisitor)localObject2).visitFieldInsn(180, ASMUtils.getType(JSONLexerBase.class), "matchStat", "I");
          ((MethodVisitor)localObject2).visitFieldInsn(178, ASMUtils.getType(JSONLexerBase.class), "END", "I");
          ((MethodVisitor)localObject2).visitJumpInsn(159, localLabel);
          ((MethodVisitor)localObject2).visitLabel((Label)localObject4);
          if (i == j - 1)
          {
            ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
            ((MethodVisitor)localObject2).visitFieldInsn(180, ASMUtils.getType(JSONLexerBase.class), "matchStat", "I");
            ((MethodVisitor)localObject2).visitFieldInsn(178, ASMUtils.getType(JSONLexerBase.class), "END", "I");
            ((MethodVisitor)localObject2).visitJumpInsn(160, (Label)localObject1);
          }
        }
        for (;;)
        {
          i++;
          break;
          if (localObject6 == Byte.TYPE)
          {
            ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
            ((MethodVisitor)localObject2).visitVarInsn(25, 0);
            ((MethodVisitor)localObject2).visitFieldInsn(180, paramContext.getClassName(), ((FieldInfo)localObject5).getName() + "_asm_prefix__", "[C");
            ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanFieldInt", "([C)I");
            ((MethodVisitor)localObject2).visitVarInsn(54, paramContext.var(((FieldInfo)localObject5).getName() + "_asm"));
            break label1522;
          }
          if (localObject6 == Short.TYPE)
          {
            ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
            ((MethodVisitor)localObject2).visitVarInsn(25, 0);
            ((MethodVisitor)localObject2).visitFieldInsn(180, paramContext.getClassName(), ((FieldInfo)localObject5).getName() + "_asm_prefix__", "[C");
            ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanFieldInt", "([C)I");
            ((MethodVisitor)localObject2).visitVarInsn(54, paramContext.var(((FieldInfo)localObject5).getName() + "_asm"));
            break label1522;
          }
          if (localObject6 == Integer.TYPE)
          {
            ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
            ((MethodVisitor)localObject2).visitVarInsn(25, 0);
            ((MethodVisitor)localObject2).visitFieldInsn(180, paramContext.getClassName(), ((FieldInfo)localObject5).getName() + "_asm_prefix__", "[C");
            ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanFieldInt", "([C)I");
            ((MethodVisitor)localObject2).visitVarInsn(54, paramContext.var(((FieldInfo)localObject5).getName() + "_asm"));
            break label1522;
          }
          if (localObject6 == Long.TYPE)
          {
            ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
            ((MethodVisitor)localObject2).visitVarInsn(25, 0);
            ((MethodVisitor)localObject2).visitFieldInsn(180, paramContext.getClassName(), ((FieldInfo)localObject5).getName() + "_asm_prefix__", "[C");
            ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanFieldLong", "([C)J");
            ((MethodVisitor)localObject2).visitVarInsn(55, paramContext.var(((FieldInfo)localObject5).getName() + "_asm", 2));
            break label1522;
          }
          if (localObject6 == Float.TYPE)
          {
            ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
            ((MethodVisitor)localObject2).visitVarInsn(25, 0);
            ((MethodVisitor)localObject2).visitFieldInsn(180, paramContext.getClassName(), ((FieldInfo)localObject5).getName() + "_asm_prefix__", "[C");
            ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanFieldFloat", "([C)F");
            ((MethodVisitor)localObject2).visitVarInsn(56, paramContext.var(((FieldInfo)localObject5).getName() + "_asm"));
            break label1522;
          }
          if (localObject6 == Double.TYPE)
          {
            ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
            ((MethodVisitor)localObject2).visitVarInsn(25, 0);
            ((MethodVisitor)localObject2).visitFieldInsn(180, paramContext.getClassName(), ((FieldInfo)localObject5).getName() + "_asm_prefix__", "[C");
            ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanFieldDouble", "([C)D");
            ((MethodVisitor)localObject2).visitVarInsn(57, paramContext.var(((FieldInfo)localObject5).getName() + "_asm", 2));
            break label1522;
          }
          if (localObject6 == String.class)
          {
            localObject6 = new Label();
            ((MethodVisitor)localObject2).visitIntInsn(21, paramContext.var("matchStat"));
            ((MethodVisitor)localObject2).visitInsn(7);
            ((MethodVisitor)localObject2).visitJumpInsn(160, (Label)localObject6);
            ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
            ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "stringDefaultValue", "()Ljava/lang/String;");
            ((MethodVisitor)localObject2).visitVarInsn(58, paramContext.var(((FieldInfo)localObject5).getName() + "_asm"));
            ((MethodVisitor)localObject2).visitJumpInsn(167, (Label)localObject4);
            ((MethodVisitor)localObject2).visitLabel((Label)localObject6);
            ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
            ((MethodVisitor)localObject2).visitVarInsn(25, 0);
            ((MethodVisitor)localObject2).visitFieldInsn(180, paramContext.getClassName(), ((FieldInfo)localObject5).getName() + "_asm_prefix__", "[C");
            ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanFieldString", "([C)Ljava/lang/String;");
            ((MethodVisitor)localObject2).visitVarInsn(58, paramContext.var(((FieldInfo)localObject5).getName() + "_asm"));
            break label1522;
          }
          if (((Class)localObject6).isEnum())
          {
            ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
            ((MethodVisitor)localObject2).visitVarInsn(25, 0);
            ((MethodVisitor)localObject2).visitFieldInsn(180, paramContext.getClassName(), ((FieldInfo)localObject5).getName() + "_asm_prefix__", "[C");
            localObject7 = new Label();
            ((MethodVisitor)localObject2).visitInsn(1);
            ((MethodVisitor)localObject2).visitTypeInsn(192, ASMUtils.getType((Class)localObject6));
            ((MethodVisitor)localObject2).visitVarInsn(58, paramContext.var(((FieldInfo)localObject5).getName() + "_asm"));
            ((MethodVisitor)localObject2).visitVarInsn(25, 1);
            ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "getSymbolTable", "()" + ASMUtils.getDesc(SymbolTable.class));
            ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanFieldSymbol", "([C" + ASMUtils.getDesc(SymbolTable.class) + ")Ljava/lang/String;");
            ((MethodVisitor)localObject2).visitInsn(89);
            ((MethodVisitor)localObject2).visitVarInsn(58, paramContext.var(((FieldInfo)localObject5).getName() + "_asm_enumName"));
            ((MethodVisitor)localObject2).visitJumpInsn(198, (Label)localObject7);
            ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var(((FieldInfo)localObject5).getName() + "_asm_enumName"));
            ((MethodVisitor)localObject2).visitMethodInsn(184, ASMUtils.getType((Class)localObject6), "valueOf", "(Ljava/lang/String;)" + ASMUtils.getDesc((Class)localObject6));
            ((MethodVisitor)localObject2).visitVarInsn(58, paramContext.var(((FieldInfo)localObject5).getName() + "_asm"));
            ((MethodVisitor)localObject2).visitLabel((Label)localObject7);
            break label1522;
          }
          if (Collection.class.isAssignableFrom((Class)localObject6))
          {
            ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("lexer"));
            ((MethodVisitor)localObject2).visitVarInsn(25, 0);
            ((MethodVisitor)localObject2).visitFieldInsn(180, paramContext.getClassName(), ((FieldInfo)localObject5).getName() + "_asm_prefix__", "[C");
            localObject7 = getCollectionItemClass((java.lang.reflect.Type)localObject7);
            if (localObject7 == String.class)
            {
              ((MethodVisitor)localObject2).visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc((Class)localObject6)));
              ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanFieldStringArray", "([CLjava/lang/Class;)" + ASMUtils.getDesc(Collection.class));
              ((MethodVisitor)localObject2).visitVarInsn(58, paramContext.var(((FieldInfo)localObject5).getName() + "_asm"));
              break label1522;
            }
            _deserialze_list_obj(paramContext, (MethodVisitor)localObject2, (Label)localObject1, (FieldInfo)localObject5, (Class)localObject6, (Class)localObject7, i);
            if (i != j - 1) {
              continue;
            }
            _deserialize_endCheck(paramContext, (MethodVisitor)localObject2, (Label)localObject1);
            continue;
          }
          _deserialze_obj(paramContext, (MethodVisitor)localObject2, (Label)localObject1, (FieldInfo)localObject5, (Class)localObject6, i);
          if (i == j - 1) {
            _deserialize_endCheck(paramContext, (MethodVisitor)localObject2, (Label)localObject1);
          }
        }
      }
      ((MethodVisitor)localObject2).visitLabel(localLabel);
      if ((!paramContext.getClazz().isInterface()) && (!Modifier.isAbstract(paramContext.getClazz().getModifiers()))) {
        _batchSet(paramContext, (MethodVisitor)localObject2);
      }
      ((MethodVisitor)localObject2).visitLabel((Label)localObject3);
      _setContext(paramContext, (MethodVisitor)localObject2);
      ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("instance"));
      ((MethodVisitor)localObject2).visitInsn(176);
      ((MethodVisitor)localObject2).visitLabel((Label)localObject1);
      _batchSet(paramContext, (MethodVisitor)localObject2);
      ((MethodVisitor)localObject2).visitVarInsn(25, 0);
      ((MethodVisitor)localObject2).visitVarInsn(25, 1);
      ((MethodVisitor)localObject2).visitVarInsn(25, 2);
      ((MethodVisitor)localObject2).visitVarInsn(25, 3);
      ((MethodVisitor)localObject2).visitVarInsn(25, paramContext.var("instance"));
      ((MethodVisitor)localObject2).visitMethodInsn(182, ASMUtils.getType(ASMJavaBeanDeserializer.class), "parseRest", "(" + ASMUtils.getDesc(DefaultJSONParser.class) + ASMUtils.getDesc(java.lang.reflect.Type.class) + "Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
      ((MethodVisitor)localObject2).visitTypeInsn(192, ASMUtils.getType(paramContext.getClazz()));
      ((MethodVisitor)localObject2).visitInsn(176);
      ((MethodVisitor)localObject2).visitLabel(paramClassWriter);
      ((MethodVisitor)localObject2).visitVarInsn(25, 0);
      ((MethodVisitor)localObject2).visitVarInsn(25, 1);
      ((MethodVisitor)localObject2).visitVarInsn(25, 2);
      ((MethodVisitor)localObject2).visitVarInsn(25, 3);
      ((MethodVisitor)localObject2).visitMethodInsn(183, ASMUtils.getType(ASMJavaBeanDeserializer.class), "deserialze", "(" + ASMUtils.getDesc(DefaultJSONParser.class) + ASMUtils.getDesc(java.lang.reflect.Type.class) + "Ljava/lang/Object;)Ljava/lang/Object;");
      ((MethodVisitor)localObject2).visitInsn(176);
      ((MethodVisitor)localObject2).visitMaxs(5, paramContext.getVariantCount());
      ((MethodVisitor)localObject2).visitEnd();
    }
  }
  
  void _deserialzeArrayMapping(ClassWriter paramClassWriter, Context paramContext)
  {
    MethodVisitor localMethodVisitor = paramClassWriter.visitMethod(1, "deserialzeArrayMapping", "(" + ASMUtils.getDesc(DefaultJSONParser.class) + ASMUtils.getDesc(java.lang.reflect.Type.class) + "Ljava/lang/Object;)Ljava/lang/Object;", null, null);
    defineVarLexer(paramContext, localMethodVisitor);
    _createInstance(paramContext, localMethodVisitor);
    List localList = paramContext.getBeanInfo().getSortedFieldList();
    int m = localList.size();
    int i = 0;
    if (i < m)
    {
      int j;
      label96:
      int k;
      label105:
      FieldInfo localFieldInfo;
      Object localObject;
      if (i == m - 1)
      {
        j = 1;
        if (j == 0) {
          break label247;
        }
        k = 93;
        localFieldInfo = (FieldInfo)localList.get(i);
        paramClassWriter = localFieldInfo.getFieldClass();
        localObject = localFieldInfo.getFieldType();
        if ((paramClassWriter != Byte.TYPE) && (paramClassWriter != Short.TYPE) && (paramClassWriter != Integer.TYPE)) {
          break label254;
        }
        localMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
        localMethodVisitor.visitVarInsn(16, k);
        localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanInt", "(C)I");
        localMethodVisitor.visitVarInsn(54, paramContext.var(localFieldInfo.getName() + "_asm"));
      }
      for (;;)
      {
        i++;
        break;
        j = 0;
        break label96;
        label247:
        k = 44;
        break label105;
        label254:
        if (paramClassWriter == Long.TYPE)
        {
          localMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
          localMethodVisitor.visitVarInsn(16, k);
          localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanLong", "(C)J");
          localMethodVisitor.visitVarInsn(55, paramContext.var(localFieldInfo.getName() + "_asm", 2));
        }
        else if (paramClassWriter == Boolean.TYPE)
        {
          localMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
          localMethodVisitor.visitVarInsn(16, k);
          localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanBoolean", "(C)Z");
          localMethodVisitor.visitVarInsn(54, paramContext.var(localFieldInfo.getName() + "_asm"));
        }
        else if (paramClassWriter == Float.TYPE)
        {
          localMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
          localMethodVisitor.visitVarInsn(16, k);
          localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanFloat", "(C)F");
          localMethodVisitor.visitVarInsn(56, paramContext.var(localFieldInfo.getName() + "_asm"));
        }
        else if (paramClassWriter == Double.TYPE)
        {
          localMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
          localMethodVisitor.visitVarInsn(16, k);
          localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanDouble", "(C)D");
          localMethodVisitor.visitVarInsn(57, paramContext.var(localFieldInfo.getName() + "_asm", 2));
        }
        else if (paramClassWriter == Character.TYPE)
        {
          localMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
          localMethodVisitor.visitVarInsn(16, k);
          localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanString", "(C)Ljava/lang/String;");
          localMethodVisitor.visitInsn(3);
          localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(String.class), "charAt", "(I)C");
          localMethodVisitor.visitVarInsn(54, paramContext.var(localFieldInfo.getName() + "_asm"));
        }
        else if (paramClassWriter == String.class)
        {
          localMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
          localMethodVisitor.visitVarInsn(16, k);
          localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanString", "(C)Ljava/lang/String;");
          localMethodVisitor.visitVarInsn(58, paramContext.var(localFieldInfo.getName() + "_asm"));
        }
        else if (paramClassWriter.isEnum())
        {
          localMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
          localMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(paramClassWriter)));
          localMethodVisitor.visitVarInsn(25, 1);
          localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "getSymbolTable", "()" + ASMUtils.getDesc(SymbolTable.class));
          localMethodVisitor.visitVarInsn(16, k);
          localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanEnum", "(Ljava/lang/Class;" + ASMUtils.getDesc(SymbolTable.class) + "C)Ljava/lang/Enum;");
          localMethodVisitor.visitTypeInsn(192, ASMUtils.getType(paramClassWriter));
          localMethodVisitor.visitVarInsn(58, paramContext.var(localFieldInfo.getName() + "_asm"));
        }
        else
        {
          if (!Collection.class.isAssignableFrom(paramClassWriter)) {
            break label1415;
          }
          localObject = getCollectionItemClass((java.lang.reflect.Type)localObject);
          if (localObject != String.class) {
            break label1166;
          }
          localMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
          localMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc(paramClassWriter)));
          localMethodVisitor.visitVarInsn(16, k);
          localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "scanStringArray", "(Ljava/lang/Class;C)Ljava/util/Collection;");
          localMethodVisitor.visitVarInsn(58, paramContext.var(localFieldInfo.getName() + "_asm"));
        }
      }
      label1166:
      localMethodVisitor.visitVarInsn(25, 1);
      if (i == 0) {
        localMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "LBRACKET", "I");
      }
      for (;;)
      {
        localMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "LBRACKET", "I");
        localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "accept", "(II)V");
        _newCollection(localMethodVisitor, paramClassWriter);
        localMethodVisitor.visitInsn(89);
        localMethodVisitor.visitVarInsn(58, paramContext.var(localFieldInfo.getName() + "_asm"));
        _getCollectionFieldItemDeser(paramContext, localMethodVisitor, localFieldInfo, (Class)localObject);
        localMethodVisitor.visitVarInsn(25, 1);
        localMethodVisitor.visitLdcInsn(com.alibaba.fastjson.asm.Type.getType(ASMUtils.getDesc((Class)localObject)));
        localMethodVisitor.visitVarInsn(25, 3);
        localMethodVisitor.visitMethodInsn(184, ASMUtils.getType(ASMUtils.class), "parseArray", "(Ljava/util/Collection;" + ASMUtils.getDesc(ObjectDeserializer.class) + ASMUtils.getDesc(DefaultJSONParser.class) + "Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
        break;
        localMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "COMMA", "I");
      }
      label1415:
      localMethodVisitor.visitVarInsn(25, 1);
      if (i == 0)
      {
        localMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "LBRACKET", "I");
        label1448:
        localMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "LBRACKET", "I");
        localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "accept", "(II)V");
        _deserObject(paramContext, localMethodVisitor, localFieldInfo, paramClassWriter);
        localMethodVisitor.visitVarInsn(25, 1);
        if (j != 0) {
          break label1597;
        }
        localMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "COMMA", "I");
        localMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "LBRACKET", "I");
      }
      for (;;)
      {
        localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(DefaultJSONParser.class), "accept", "(II)V");
        break;
        localMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "COMMA", "I");
        break label1448;
        label1597:
        localMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "RBRACKET", "I");
        localMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "EOF", "I");
      }
    }
    _batchSet(paramContext, localMethodVisitor, false);
    localMethodVisitor.visitVarInsn(25, paramContext.var("lexer"));
    localMethodVisitor.visitFieldInsn(178, ASMUtils.getType(JSONToken.class), "COMMA", "I");
    localMethodVisitor.visitMethodInsn(182, ASMUtils.getType(JSONLexerBase.class), "nextToken", "(I)V");
    localMethodVisitor.visitVarInsn(25, paramContext.var("instance"));
    localMethodVisitor.visitInsn(176);
    localMethodVisitor.visitMaxs(5, paramContext.getVariantCount());
    localMethodVisitor.visitEnd();
  }
  
  void _isFlag(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt, Label paramLabel)
  {
    paramMethodVisitor.visitVarInsn(21, paramContext.var("_asm_flag_" + paramInt / 32));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(1 << paramInt));
    paramMethodVisitor.visitInsn(126);
    paramMethodVisitor.visitJumpInsn(153, paramLabel);
  }
  
  void _setFlag(MethodVisitor paramMethodVisitor, Context paramContext, int paramInt)
  {
    String str = "_asm_flag_" + paramInt / 32;
    paramMethodVisitor.visitVarInsn(21, paramContext.var(str));
    paramMethodVisitor.visitLdcInsn(Integer.valueOf(1 << paramInt));
    paramMethodVisitor.visitInsn(128);
    paramMethodVisitor.visitVarInsn(54, paramContext.var(str));
  }
  
  public FieldDeserializer createFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    Class localClass = paramFieldInfo.getFieldClass();
    if ((localClass == Integer.TYPE) || (localClass == Long.TYPE) || (localClass == String.class)) {}
    for (paramParserConfig = createStringFieldDeserializer(paramParserConfig, paramClass, paramFieldInfo);; paramParserConfig = paramParserConfig.createFieldDeserializerWithoutASM(paramParserConfig, paramClass, paramFieldInfo)) {
      return paramParserConfig;
    }
  }
  
  public ObjectDeserializer createJavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, java.lang.reflect.Type paramType)
  {
    if (paramClass.isPrimitive()) {
      throw new IllegalArgumentException("not support type :" + paramClass.getName());
    }
    String str = getGenClassName(paramClass);
    ClassWriter localClassWriter = new ClassWriter();
    localClassWriter.visit(49, 33, str, ASMUtils.getType(ASMJavaBeanDeserializer.class), null);
    paramType = DeserializeBeanInfo.computeSetters(paramClass, paramType);
    _init(localClassWriter, new Context(str, paramParserConfig, paramType, 3));
    _createInstance(localClassWriter, new Context(str, paramParserConfig, paramType, 3));
    _deserialze(localClassWriter, new Context(str, paramParserConfig, paramType, 4));
    _deserialzeArrayMapping(localClassWriter, new Context(str, paramParserConfig, paramType, 4));
    paramType = localClassWriter.toByteArray();
    return (ObjectDeserializer)this.classLoader.defineClassPublic(str, paramType, 0, paramType.length).getConstructor(new Class[] { ParserConfig.class, Class.class }).newInstance(new Object[] { paramParserConfig, paramClass });
  }
  
  public FieldDeserializer createStringFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    Class localClass = paramFieldInfo.getFieldClass();
    Method localMethod = paramFieldInfo.getMethod();
    String str = getGenFieldDeserializer(paramClass, paramFieldInfo);
    ClassWriter localClassWriter = new ClassWriter();
    Object localObject;
    int i;
    if (localClass == Integer.TYPE)
    {
      localObject = IntegerFieldDeserializer.class;
      if (!paramClass.isInterface()) {
        break label488;
      }
      i = 185;
      label54:
      localClassWriter.visit(49, 33, str, ASMUtils.getType((Class)localObject), null);
      MethodVisitor localMethodVisitor = localClassWriter.visitMethod(1, "<init>", "(" + ASMUtils.getDesc(ParserConfig.class) + ASMUtils.getDesc(Class.class) + ASMUtils.getDesc(FieldInfo.class) + ")V", null, null);
      localMethodVisitor.visitVarInsn(25, 0);
      localMethodVisitor.visitVarInsn(25, 1);
      localMethodVisitor.visitVarInsn(25, 2);
      localMethodVisitor.visitVarInsn(25, 3);
      localMethodVisitor.visitMethodInsn(183, ASMUtils.getType((Class)localObject), "<init>", "(" + ASMUtils.getDesc(ParserConfig.class) + ASMUtils.getDesc(Class.class) + ASMUtils.getDesc(FieldInfo.class) + ")V");
      localMethodVisitor.visitInsn(177);
      localMethodVisitor.visitMaxs(4, 6);
      localMethodVisitor.visitEnd();
      if (localMethod != null)
      {
        if (localClass != Integer.TYPE) {
          break label496;
        }
        localObject = localClassWriter.visitMethod(1, "setValue", "(" + ASMUtils.getDesc(Object.class) + "I)V", null, null);
        ((MethodVisitor)localObject).visitVarInsn(25, 1);
        ((MethodVisitor)localObject).visitTypeInsn(192, ASMUtils.getType(localMethod.getDeclaringClass()));
        ((MethodVisitor)localObject).visitVarInsn(21, 2);
        ((MethodVisitor)localObject).visitMethodInsn(i, ASMUtils.getType(localMethod.getDeclaringClass()), localMethod.getName(), ASMUtils.getDesc(localMethod));
        ((MethodVisitor)localObject).visitInsn(177);
        ((MethodVisitor)localObject).visitMaxs(3, 3);
        ((MethodVisitor)localObject).visitEnd();
      }
    }
    for (;;)
    {
      localObject = localClassWriter.toByteArray();
      return (FieldDeserializer)this.classLoader.defineClassPublic(str, (byte[])localObject, 0, localObject.length).getConstructor(new Class[] { ParserConfig.class, Class.class, FieldInfo.class }).newInstance(new Object[] { paramParserConfig, paramClass, paramFieldInfo });
      if (localClass == Long.TYPE)
      {
        localObject = LongFieldDeserializer.class;
        break;
      }
      localObject = StringFieldDeserializer.class;
      break;
      label488:
      i = 182;
      break label54;
      label496:
      if (localClass == Long.TYPE)
      {
        localObject = localClassWriter.visitMethod(1, "setValue", "(" + ASMUtils.getDesc(Object.class) + "J)V", null, null);
        ((MethodVisitor)localObject).visitVarInsn(25, 1);
        ((MethodVisitor)localObject).visitTypeInsn(192, ASMUtils.getType(localMethod.getDeclaringClass()));
        ((MethodVisitor)localObject).visitVarInsn(22, 2);
        ((MethodVisitor)localObject).visitMethodInsn(i, ASMUtils.getType(localMethod.getDeclaringClass()), localMethod.getName(), ASMUtils.getDesc(localMethod));
        ((MethodVisitor)localObject).visitInsn(177);
        ((MethodVisitor)localObject).visitMaxs(3, 4);
        ((MethodVisitor)localObject).visitEnd();
      }
      else
      {
        localObject = localClassWriter.visitMethod(1, "setValue", "(" + ASMUtils.getDesc(Object.class) + ASMUtils.getDesc(Object.class) + ")V", null, null);
        ((MethodVisitor)localObject).visitVarInsn(25, 1);
        ((MethodVisitor)localObject).visitTypeInsn(192, ASMUtils.getType(localMethod.getDeclaringClass()));
        ((MethodVisitor)localObject).visitVarInsn(25, 2);
        ((MethodVisitor)localObject).visitTypeInsn(192, ASMUtils.getType(localClass));
        ((MethodVisitor)localObject).visitMethodInsn(i, ASMUtils.getType(localMethod.getDeclaringClass()), localMethod.getName(), ASMUtils.getDesc(localMethod));
        ((MethodVisitor)localObject).visitInsn(177);
        ((MethodVisitor)localObject).visitMaxs(3, 3);
        ((MethodVisitor)localObject).visitEnd();
      }
    }
  }
  
  public String getGenClassName(Class<?> paramClass)
  {
    return "Fastjson_ASM_" + paramClass.getSimpleName() + "_" + this.seed.incrementAndGet();
  }
  
  public String getGenFieldDeserializer(Class<?> paramClass, FieldInfo paramFieldInfo)
  {
    paramClass = "Fastjson_ASM__Field_" + paramClass.getSimpleName();
    return paramClass + "_" + paramFieldInfo.getName() + "_" + this.seed.incrementAndGet();
  }
  
  public boolean isExternalClass(Class<?> paramClass)
  {
    return this.classLoader.isExternalClass(paramClass);
  }
  
  static class Context
  {
    private final DeserializeBeanInfo beanInfo;
    private String className;
    private Class<?> clazz;
    private List<FieldInfo> fieldInfoList;
    private int variantIndex = 5;
    private Map<String, Integer> variants = new HashMap();
    
    public Context(String paramString, ParserConfig paramParserConfig, DeserializeBeanInfo paramDeserializeBeanInfo, int paramInt)
    {
      this.className = paramString;
      this.clazz = paramDeserializeBeanInfo.getClazz();
      this.variantIndex = paramInt;
      this.beanInfo = paramDeserializeBeanInfo;
      this.fieldInfoList = new ArrayList(paramDeserializeBeanInfo.getFieldList());
    }
    
    public DeserializeBeanInfo getBeanInfo()
    {
      return this.beanInfo;
    }
    
    public String getClassName()
    {
      return this.className;
    }
    
    public Class<?> getClazz()
    {
      return this.clazz;
    }
    
    public List<FieldInfo> getFieldInfoList()
    {
      return this.fieldInfoList;
    }
    
    public int getVariantCount()
    {
      return this.variantIndex;
    }
    
    public int var(String paramString)
    {
      if ((Integer)this.variants.get(paramString) == null)
      {
        Map localMap = this.variants;
        int i = this.variantIndex;
        this.variantIndex = (i + 1);
        localMap.put(paramString, Integer.valueOf(i));
      }
      return ((Integer)this.variants.get(paramString)).intValue();
    }
    
    public int var(String paramString, int paramInt)
    {
      if ((Integer)this.variants.get(paramString) == null)
      {
        this.variants.put(paramString, Integer.valueOf(this.variantIndex));
        this.variantIndex += paramInt;
      }
      return ((Integer)this.variants.get(paramString)).intValue();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/deserializer/ASMDeserializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */