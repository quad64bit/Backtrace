package org.sgates.cli.os

import org.sgates.cli.datastructure.Command
import org.sgates.cli.os.bin.*
import org.sgates.cli.os.bin.test.LongProcess

/**
 * Created by sgates on 1/6/15.
 */
class CommandRegistry {
    def commands = [:]
    Kernel kernel

    public init(){
        commands["ls"]      = {new Ls(name:"ls", kernel: kernel)}
        commands["mkdir"]   = {new Mkdir(name:"mkdir", kernel: kernel)}
        commands["touch"]   = {new Touch(name:"touch", kernel: kernel)}
        commands["cd"]      = {new Cd(name:"cd", kernel: kernel)}
        commands["pwd"]     = {new Pwd(name:"pwd", kernel: kernel)}
        commands["ps"]      = {new Ps(name:"ps", kernel: kernel)}


        commands["lp"]     = {new LongProcess(name:"long process", kernel: kernel)}
        this
    }

    Command getCommandByName(String name){
        def command = commands[name]
        if(!command){
            return null
        }
        commands[name]()
    }
}
