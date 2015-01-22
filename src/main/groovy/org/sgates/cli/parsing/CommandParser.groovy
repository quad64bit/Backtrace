package org.sgates.cli.parsing

import org.sgates.cli.datastructure.Argument
import org.sgates.cli.datastructure.Command
import org.sgates.cli.datastructure.Flag
import org.sgates.cli.os.CommandRegistry

class CommandParser{
    CommandRegistry commandRegistry

    static{
        List.metaClass.lookAhead = {->
            try{return delegate[-2]} catch(e){}
            null
        }
    }

	def getCommand(String commandLine){
		def tokens = tokenize(commandLine)
        Command command = parse(tokens)
        command
	}

	private tokenize(String commandLine){
		commandLine.split(" ") as List
	}

	private parse(List tokens){
        def rawStack = tokens.reverse()
        String exeName = rawStack.pop()
        Command command = commandRegistry.getCommandByName(exeName)
        if(!command){
            throw new Exception("Command not found: ${exeName}")
        }
        String lastPart = ""
		while(!rawStack.isEmpty()){
            String currentToken = rawStack.pop()
            if(currentToken.startsWith("-")){                //flag
                Flag flag = new Flag(name:currentToken)
                command.flags << flag
            } else if(lastPart.startsWith("-")){                                          //argument
                Argument argument = new Argument(name:currentToken)
                command.flags.last().argument = argument
            } else{
                Argument argument = new Argument(name:currentToken)
                command.arguments << argument
            }
            lastPart = currentToken
        }
        command
	}
}