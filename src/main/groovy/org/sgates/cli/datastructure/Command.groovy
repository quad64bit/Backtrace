package org.sgates.cli.datastructure

abstract class Command{
	String name
	String description
    String manPage
	List<Flag> flags = []

    String toString(){
        String commandString = "$name"
        flags.each{ flag ->
            commandString += " $flag"
        }
        commandString
    }

    abstract String execute()
}