package org.sgates.cli.datastructure

class Argument{
	String name
	Boolean required = false

    String toString(){
        "$name"
    }
}