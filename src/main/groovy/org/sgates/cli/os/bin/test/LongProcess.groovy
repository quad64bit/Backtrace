package org.sgates.cli.os.bin.test

import org.sgates.cli.datastructure.Command

/**
 * Created by sgates on 1/22/15.
 */
class LongProcess extends Command{
    @Override
    String execute(Map params) {
        kernel.processMonitor.addProcess(this)
        printDivider()
    }

    @Override
    String kill() {
        return null
    }
}
