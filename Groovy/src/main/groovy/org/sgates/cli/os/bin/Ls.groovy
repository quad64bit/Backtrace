package org.sgates.cli.os.bin

import org.sgates.cli.datastructure.Command
import org.sgates.cli.datastructure.Directory
import org.sgates.cli.datastructure.FileSystemNode

/**
 * Created by sgates on 1/6/15.
 */
class Ls extends Command{
    @Override
    String execute(Map params = [:]) {
        Directory pwd = kernel.fileSystem.pwd
        println "./"
        println "../"
        pwd.contents.each{ FileSystemNode fsn ->
            println fsn.toString()
        }
        println "[${pwd.contents.size()}] items"

        printDivider()
    }

    @Override
    String kill() {
        return null
    }
}
