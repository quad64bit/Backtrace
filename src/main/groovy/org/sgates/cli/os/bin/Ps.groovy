package org.sgates.cli.os.bin

import org.sgates.cli.datastructure.Command

/**
 * Created by sgates on 1/22/15.
 */
class Ps extends Command{
    @Override
    String execute(Map params) {
        def processes = kernel.processMonitor.list()
        if(!processes){
            println "No processes running"
            return
        }
        printProcesses(processes)
        printDivider()
    }

    private void printProcesses(processes){
        println "PID   | Name"
        println "------|----------------------------------"
        processes.each { Command process ->
            println "${(process.pid as String).padRight(6)}| ${process.name}"
        }
    }

    @Override
    String kill() {
        return null
    }
}
