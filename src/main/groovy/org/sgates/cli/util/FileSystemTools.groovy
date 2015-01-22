package org.sgates.cli.util

/**
 * Created by sgates on 1/7/15.
 */
class FileSystemTools {
    static getPathParts(String path){
        if(path.startsWith("/")){ //absolute
            if(path == "/"){
                return ["/"]
            }
            def parts = path.split("/")
            parts[0] = "/"
            return parts
        }
        path.split("/") //relative
    }
}
