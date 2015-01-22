package org.sgates.cli.os.bin

import org.sgates.cli.datastructure.Argument
import org.sgates.cli.datastructure.Command

/**
 * Created by sgates on 1/21/15.
 */
class Touch extends Command{

    @Override
    String execute(Map params) {
        arguments.each { Argument argument ->
            kernel.fileSystem.createFile(argument.name)
        }

        println "-----------------------------------------"
    }
}
