package org.sgates.cli

import org.sgates.cli.os.Kernel
import org.sgates.cli.util.StringTools as ST

class Console{
    Kernel kernel

    void display(){
        def reader = getReader()
        simulateBootProcess()

        while(true){
            print getCommandPrompt()
            String input = reader.readLine()
            echo input
        }
    }

    private getReader(){
        new BufferedReader(new InputStreamReader(System.in))
    }

    private void simulateBootProcess(){
        ST.delayedPrint(['> Bootloader initializing'] + getDots(ran()))
        println()
        ST.delayedPrint(['> Scanning for devices on IO Subsystem'] + getDots(ran()))
        println()
        ST.delayedPrint(['> Loading kernel into primary memory'] + getDots(ran()))
        println()
        ST.delayedPrint(['> Loading application layer'] + getDots(ran()))
        println()
        ST.delayedPrint(['> Initiating network connections'] + getDots(ran()))
        println()
        ST.delayedPrint(['> Establishing encrypted link'] + getDots(ran()))
        println()
        ST.delayedPrintln("> OS Loaded")
        println()
        ST.delayedPrintln("                 >> Welcome to <<")
        println()
        ST.delayedPrintln(getBanner())
    }

    Random random = new Random()

    private int ran(max = 5){
        random.nextInt(max)+2
    }

    private List<String> getDots(Integer dotCount = 3){
        ("."*dotCount).split('')
    }

    private String getBanner(){
'''\
 ██████╗ ███████╗     ██████╗ ██████╗ ██████╗ ███████╗
██╔═══██╗██╔════╝    ██╔════╝██╔═══██╗██╔══██╗██╔════╝
██║   ██║███████╗    ██║     ██║   ██║██████╔╝█████╗
██║   ██║╚════██║    ██║     ██║   ██║██╔══██╗██╔══╝
╚██████╔╝███████║    ╚██████╗╚██████╔╝██║  ██║███████╗
 ╚═════╝ ╚══════╝     ╚═════╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝
'''
    }

    private String getCommandPrompt(){
        "\n\$ "
    }

    private void echo(String output){
        println "> $output"
    }
}