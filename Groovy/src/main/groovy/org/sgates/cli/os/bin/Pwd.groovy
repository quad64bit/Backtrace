package org.sgates.cli.os.bin

import org.sgates.cli.datastructure.Command

/**
 * Created by sgates on 1/21/15.
 */
class Pwd extends Command{
    @Override
    String execute(Map params) {
        println kernel.fileSystem.pwd.getPath()
        printDivider()
    }

    @Override
    String kill() {
        return null
    }
}
