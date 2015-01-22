package org.sgates.cli.os.bin

import org.sgates.cli.datastructure.Command

/**
 * Created by sgates on 1/21/15.
 */
class Cd extends Command{

    @Override
    String execute(Map params) {
        String path = arguments[0].name
        def destDir = kernel.fileSystem.getDirectory(path)
        if(destDir){
            kernel.fileSystem.setPwd(destDir)
            println "setting pwd to ${destDir}"
        } else{
            println "$path does not exist"
        }
    }
}
