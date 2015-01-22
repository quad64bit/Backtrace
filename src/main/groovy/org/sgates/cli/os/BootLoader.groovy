package org.sgates.cli.os

import org.sgates.cli.parsing.CommandParser

/**
 * Created by sgates on 1/6/15.
 */
class BootLoader {
    static Kernel boot(){
        Kernel kernel = new Kernel()
        CommandRegistry commandRegistry = initCommandRegistry(kernel)
        kernel.fileSystem = loadFileSystem()
        kernel.commandRegistry = commandRegistry
        kernel.commandParser = initCommandParser(commandRegistry)
        kernel.processMonitor = new ProcessMonitor(kernel:kernel)
        kernel
    }

    private static FileSystem loadFileSystem(){
        new FileSystem()
    }

    private static CommandRegistry initCommandRegistry(Kernel kernel){
        new CommandRegistry(kernel: kernel).init()
    }

    private static initCommandParser(CommandRegistry commandRegistry){
        new CommandParser(commandRegistry:commandRegistry)
    }
}
