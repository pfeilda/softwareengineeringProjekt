package com.pfeilda.ajb.miscellaneous;

public class Log {
    public static void log(
            final String throwObject,
            final Exception exception,
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
