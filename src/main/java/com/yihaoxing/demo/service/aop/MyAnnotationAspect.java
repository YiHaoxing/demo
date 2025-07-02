package com.yihaoxing.demo.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 *
 * @author yihaoxing
 * @version 1.0
 */
@Aspect
@Component
public class MyAnnotationAspect {
    private final ExpressionParser parser = new SpelExpressionParser();

    @Before("@annotation(myAnnotation)")
    public void before(JoinPoint joinPoint, MyAnnotation myAnnotation) throws NoSuchMethodException {
        // 获取方法签名和参数
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();

        // 创建SpEL上下文并设置参数
        EvaluationContext context = new StandardEvaluationContext();
        String[] parameterNames = signature.getParameterNames();
        for (int i = 0; i < parameterNames.length; i++) {
            context.setVariable(parameterNames[i], args[i]);
        }

        // 解析SpEL表达式
        String expressionString = myAnnotation.value();
        Expression expression = parser.parseExpression(expressionString);
        Object value = expression.getValue(context);

        // 使用解析结果（示例：打印）
        System.out.println("解析表达式 '" + expressionString + "' 结果: " + value);
    }
}
