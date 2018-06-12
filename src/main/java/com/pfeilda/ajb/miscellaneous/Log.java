package com.pfeilda.ajb.miscellaneous;

import com.sun.istack.internal.NotNull;

public class Log {
    public static void log(
            @NotNull final String throwObject,
            @NotNull final Exception exception,
            final String message
    ) {
        System.err.printf(
                "[%s][%s]: %s",
                throwObject,
                exception.getClass().getSimpleName(),
                message
        );
    }
}
