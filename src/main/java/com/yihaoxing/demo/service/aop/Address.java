package com.yihaoxing.demo.service.aop;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author yihaoxing
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }
}
