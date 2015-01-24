package org.sgates.cli

import org.sgates.cli.gui.event.TerminalEventListener
import org.sgates.cli.gui.ConsoleGUI
import org.sgates.cli.gui.panel.structure.Printable
import org.sgates.cli.os.CommandHistory
import org.sgates.cli.os.Kernel
import groovy.swing.SwingBuilder

import javax.swing.JFrame
import java.awt.Frame
import javax.swing.Timer
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class BtConsole {
    Kernel kernel
    private Frame window
    private SwingBuilder swingBuilder
    private ConsoleGUI consoleGUI
    private TerminalEventListener terminalEventListener
    String currentLine = ""
    int insertionPoint = 0
    boolean skipBoot = false
    BtConsole callback
    CommandHistory commandHistory

    {
        callback = this
        commandHistory = new CommandHistory()
    }

    void clearCurrentLine(){
        currentLine = ""
        insertionPoint = 0
    }

    void display(){
        swingBuilder = new SwingBuilder()
        terminalEventListener = new TerminalEventListener(console: this)

        swingBuilder.edt {
            window = frame(title:'Backtrace', show: true, defaultCloseOperation: JFrame.EXIT_ON_CLOSE) {
                consoleGUI = new ConsoleGUI(console:callback)
                consoleGUI.init()
                widget(consoleGUI)
            }
            window.pack()
            window.setLocationRelativeTo(null)
            terminalEventListener.canvas = consoleGUI
        }

        //Wait for GUI to load, then boot.
        bootProcess()
        window.addKeyListener(terminalEventListener)

        Timer refresh = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.repaint();
            }
        });
        refresh.start()
    }

    public void delayedPrint(String input, Long delay=Global.DEFAULT_PRINT_DELAY){
        Thread.sleep(delay)
        print input
    }

    public void delayedPrint(Collection elements, Long delay=Global.DEFAULT_PRINT_DELAY){
        elements.each { element ->
            Thread.sleep(delay)
            print element
        }
    }

    public delayedPrintln(String input, Long delay=Global.DEFAULT_PRINT_DELAY){
        Thread.sleep(delay)
        println input
    }

    public delayedPrintln(Collection elements, Long delay=Global.DEFAULT_PRINT_DELAY){
        elements.each { element ->
            Thread.sleep(delay)
            println element
        }
    }

    public void println(String text, Printable panel = consoleGUI.terminalPanel){
        panel.println(text)
        consoleGUI.repaint()
    }

    public void print(String text, Printable panel = consoleGUI.terminalPanel){
        panel.print(text)
        consoleGUI.repaint()
    }

    private void bootProcess(){
        if(skipBoot){ return }
        Thread.sleep(2000) // TODO figure out a better way to do this -- can we be notified when the GUI is all loaded?
        delayedPrint(['> Bootloader initializing'] + getDots(ran()))
        println ""
        delayedPrint(['> Scanning for devices on IO Subsystem'] + getDots(ran()))
        println ""
        delayedPrint(['> Loading kernel into primary memory'] + getDots(ran()))
        println ""
        delayedPrint(['> Loading application layer'] + getDots(ran()))
        println ""
        delayedPrint(['> Initiating network connections'] + getDots(ran()))
        println ""
        delayedPrint(['> Establishing encrypted link'] + getDots(ran()))
        println ""
        delayedPrint("> OS Loaded")
        println ""
        delayedPrint("                 >> Welcome to <<")
        println ""
        delayedPrintln(getBanner())
    }

    Random random = new Random()

    private int ran(max = 5){
        random.nextInt(max)+2
    }

    private List<String> getDots(Integer dotCount = 3){
        ("."*dotCount).split('')
    }

    private static String getBanner(){
'''\
 ██████  ███████      ██████  ██████  ██████  ███████ 
██    ██ ██          ██      ██    ██ ██   ██ ██      
██    ██ ███████     ██      ██    ██ ██████  █████ 
██    ██      ██     ██      ██    ██ ██   ██ ██    
 ██████  ███████      ██████  ██████  ██   ██ ███████
'''
    }
}