package org.sgates.cli.os

import org.sgates.cli.datastructure.Command
import org.sgates.cli.os.commandlist.Ls

/**
 * Created by sgates on 1/6/15.
 */
class CommandRegistry {
    def commands = [:]

    static Command getCommandByName(String name){
        new Ls()
    }
}
