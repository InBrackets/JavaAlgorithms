package com.odoo.goudadev.junitpioneer;

import org.junit.jupiter.api.DisplayName;
import org.junitpioneer.jupiter.RetryingTest;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRetryingTest {
    private static int EXECUTION_COUNT;

    @RetryingTest(maxAttempts = 4, minSuccess = 2, name = "{displayName} [{index}]")
    void failsFirstWithExpectedThenWithUnexpectedException() {
        EXECUTION_COUNT++;
        assertThat(EXECUTION_COUNT).isNotEqualTo(1);
    }
}
