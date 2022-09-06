package com.yihaoxing.demo.test.basic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleModel {
    private Float low;
    private Float high;
    private LocalDateTime time;
    private List<Demo> demos;
}
