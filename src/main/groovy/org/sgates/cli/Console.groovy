package org.sgates.cli

import org.sgates.cli.gui.event.TerminalEventListener
import org.sgates.cli.gui.ConsoleGUI
import org.sgates.cli.os.Kernel
import org.sgates.cli.util.StringTools as ST
import groovy.swing.SwingBuilder

import javax.swing.JFrame
import java.awt.Frame

class Console{
    Kernel kernel
    private Frame window
    private SwingBuilder swingBuilder
    private ConsoleGUI terminalGUI
    private TerminalEventListener terminalEventListener
    String currentLine = ""
    boolean skipBoot = false
    org.sgates.cli.Console callback

    {
        callback = this
    }

    void display(){
//        def reader = getReader()
//        bootProcess()
//
//        while(true){
//            print getCommandPrompt()
//            String input = reader.readLine()
//            Command command = kernel.commandParser.getCommand(input)
//            command.execute()
//        }

        swingBuilder = new SwingBuilder()
        terminalEventListener = new TerminalEventListener(console: this)

        swingBuilder.edt {
            window = frame(title:'Backtrace', show: true, defaultCloseOperation: JFrame.EXIT_ON_CLOSE) {
                terminalGUI = new ConsoleGUI(console:callback)
                terminalGUI.init()
                widget(terminalGUI)
            }
            terminalEventListener.canvas = terminalGUI
            window.addKeyListener(terminalEventListener)
        }

        window.pack()
        window.setLocationRelativeTo(null)
    }

    private getReader(){
        new BufferedReader(new InputStreamReader(System.in))
    }

    private void bootProcess(){
        if(skipBoot){ return }
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