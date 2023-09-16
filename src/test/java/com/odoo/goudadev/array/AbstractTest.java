package com.odoo.goudadev.array;

import com.odoo.goudadev.utils.extensions.TimeMeasureExtension;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;


@ExtendWith(TimeMeasureExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class AbstractTest {

    public abstract Stream<Arguments> generateTestData();

}
