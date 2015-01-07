package org.sgates.cli.os

/**
 * Created by sgates on 1/6/15.
 */
class BootLoader {
    static Kernel boot(){
        CommandRegistry commandRegistry = loadCommands()
        FileSystem fileSystem = loadFileSystem()
        Kernel kernel = new Kernel(
                commandRegistry: commandRegistry,
                fileSystem: fileSystem
        )
        kernel
    }

    private static CommandRegistry loadCommands(){
        CommandRegistry commandRegistry = new CommandRegistry()
        commandRegistry
    }

    private static void loadFileSystem(){
        FileSystem fileSystem = new FileSystem()
        fileSystem
    }
}
