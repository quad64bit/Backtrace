package org.sgates.cli.os

import org.sgates.cli.datastructure.Command

/**
 * Created by sgates on 1/22/15.
 */
class ProcessMonitor {
    Collection<Command> runningProcesses = []
    long currentPid = 1
    Kernel kernel

    def void addProcess(Command command){
        command.pid = currentPid++
        runningProcesses << command
    }

    def Command get(long pid){
        Command command = runningProcesses.find{ it.pid == pid}
        if(!command){
            kernel.println "Command not found with PID ${pid}"
            return
        }
        command
    }

    def list(){
        runningProcesses
    }

    def kill(long pid){
        Command command = runningProcesses.find{ it.pid == pid}
        if(!command){
            kernel.println "Command not found with PID ${pid}"
            return
        }
        command.kill()
        runningProcesses.remove(command)
        kernel.println "Process $pid terminated."
    }
}
