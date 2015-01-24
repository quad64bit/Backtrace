package org.sgates.cli.datastructure

class Flag{
	String name
	boolean requiresArgument = false
	String argument

    public void setName(String name){
        name = name.startsWith("-") ? name[1..-1] : name
        this.name = name
    }

    String toString(){
        "-$name${argument ? " $argument" : ""}"
    }
}