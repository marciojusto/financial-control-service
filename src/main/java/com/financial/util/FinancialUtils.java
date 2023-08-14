package com.financial.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FinancialUtils {

    public static File getFile(String path) {
        return new File(Objects.requireNonNull(FinancialUtils.class
                                                   .getClassLoader()
                                                   .getResource(path))
                               .getFile());
    }
}
