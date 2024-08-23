package com.yihaoxing.demo.test.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常
 *
 * @author yihaoxing
 * @version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class MyException extends RuntimeException{
    private String errorMsg;
}
