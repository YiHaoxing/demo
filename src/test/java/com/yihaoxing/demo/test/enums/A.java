package com.yihaoxing.demo.test.enums;

import lombok.Data;

import java.io.Serializable;

@Data
public class A implements Serializable {
    private static final long serialVersionUID = 8146020992385510582L;
    private AppTypeEnum appTypeEnum;
}
