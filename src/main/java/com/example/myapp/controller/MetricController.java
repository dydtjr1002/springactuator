package com.example.myapp.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class MetricController {

    private final Counter customCounter;

    public MetricController(MeterRegistry registry) {
        // Custom Metric Counter 초기화
        this.customCounter = registry.counter("custom_metric_counter", "type", "example");
    }

    @PostMapping("/api/custom-metric")
    public ResponseEntity<String> incrementCustomMetric() {
        // Metric Counter 증가
        customCounter.increment();
        // 성공 응답 반환
        return ResponseEntity.ok("Custom metric incremented successfully.");
    }
}
