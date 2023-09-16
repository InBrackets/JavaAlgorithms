package com.odoo.goudadev.utils.extensions;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.math.BigDecimal;

@Slf4j
public class TimeMeasureExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    BigDecimal startTime;
    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) {
        startTime = BigDecimal.valueOf(System.nanoTime());
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) {
        BigDecimal executionTime = BigDecimal.valueOf(System.nanoTime()).subtract(startTime).divide(new BigDecimal("1000000"));
        log.info("Time execution = {}ms", String.format("%10.6f", executionTime));
    }
}
