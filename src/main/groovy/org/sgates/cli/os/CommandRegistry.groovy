package org.sgates.cli.os

import org.sgates.cli.datastructure.Command
import org.sgates.cli.os.bin.Ls
import org.sgates.cli.parsing.CommandParser

/**
 * Created by sgates on 1/6/15.
 */
class CommandRegistry {
    def commands = [:]
    Kernel kernel

    public init(){
        commands["ls"] = new Ls(name:"ls")
        commands.each{ name, Command command ->
            command.kernel = kernel
        }
        this
    }

    Command getCommandByName(String name){
        commands[name]
    }
}
