package org.sgates.cli.os.bin

import org.sgates.cli.datastructure.Argument
import org.sgates.cli.datastructure.Command

/**
 * Created by sgates on 1/21/15.
 */
class Mkdir extends Command{

    @Override
    String execute(Map params) {
        arguments.each{ Argument arg ->
            println "mkdir ${arg.name}"
            kernel.fileSystem.createDirectory(arg.name)
        }

        println "-----------------------------------------"
    }
}
