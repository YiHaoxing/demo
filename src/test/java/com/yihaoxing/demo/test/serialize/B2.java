package com.yihaoxing.demo.test.serialize;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class B2 extends B1 implements Serializable {
    private static final long serialVersionUID = 7010568907049187737L;
    private String desc;
    private Date date;
}
