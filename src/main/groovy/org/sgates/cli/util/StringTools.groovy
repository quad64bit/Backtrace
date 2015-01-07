package org.sgates.cli.util

/**
 * Created by sgates on 1/6/15.
 */
class StringTools {
    private static printPrinter = { print it }
    private static printlnPrinter = { println it }

    public static delayedPrint(String input, Long delay=300L){
        Thread.sleep(delay)
        printPrinter(input)
    }

    public static delayedPrintln(String input, Long delay=300L){
        Thread.sleep(delay)
        printlnPrinter(input)
    }

    public static delayedPrint(List elements, Long delay=300L){
        delayedPrintHelper(elements, delay, printPrinter)
    }

    public static delayedPrintln(List elements, Long delay=300L){
        delayedPrintHelper(elements, delay, printlnPrinter)
    }

    private static delayedPrintHelper(List elements, Long delay, Closure printer) {
        elements.each { element ->
            Thread.sleep(delay)
            printer element
        }
    }
}
