package com.yihaoxing.demo.test.serialize;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class A2 extends A1 implements Serializable {
    private static final long serialVersionUID = 8128865470130862532L;
    private String desc;
    private Date date;
}
