package com.yihaoxing.demo.test.serialize;

import lombok.Data;

import java.io.Serializable;

@Data
public class A1 implements Serializable {
    private static final long serialVersionUID = 5239008603225028653L;
    public Long id;
}
