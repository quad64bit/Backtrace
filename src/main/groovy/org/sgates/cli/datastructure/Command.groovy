package org.sgates.cli.datastructure

import org.sgates.cli.os.Kernel

abstract class Command{
	String name
	String description
    String manPage
	List<Flag> flags = []
    Kernel kernel


    String toString(){
        String commandString = "$name"
        flags.each{ flag ->
            commandString += " $flag"
        }
        commandString
    }

    abstract String execute(Map params)
}