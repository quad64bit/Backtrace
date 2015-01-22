package org.sgates.cli.os

import org.sgates.cli.datastructure.Command
import org.sgates.cli.os.bin.*

/**
 * Created by sgates on 1/6/15.
 */
class CommandRegistry {
    def commands = [:]
    Kernel kernel

    public init(){
        commands["ls"] = new Ls(name:"ls")
        commands["mkdir"] = new Mkdir(name:"mkdir")
        commands["touch"] = new Touch(name:"touch")
        commands["cd"] = new Cd(name:"cd")
        commands["pwd"] = new Pwd(name:"pwd")

        commands.each{ name, Command command ->
            command.kernel = kernel
        }
        this
    }

    Command getCommandByName(String name){
        commands[name]
    }
}
