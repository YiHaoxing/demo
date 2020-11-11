package com.yihaoxing.demo.test.serialize;

import lombok.Data;

import java.io.Serializable;

@Data
public class B1 implements Serializable {
    private static final long serialVersionUID = 6066949376716116689L;
    public Long id;
}
