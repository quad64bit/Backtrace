package org.sgates.cli.os

import org.sgates.cli.datastructure.Directory
import org.sgates.cli.datastructure.File
import org.sgates.cli.util.FileSystemTools as FST

/**
 * Created by sgates on 1/6/15.
 */
class FileSystem {
    long capacity
    Directory root
    Directory pwd

    {
        root = new Directory(name:"/")
        pwd = root

        root.mkdir(["testDir 1"])
        root.mkdir(["testDir 2"])
        root.mkdir(["testDir 3"])

        root.touch(["testFile1"])
        root.touch(["testFile2"])
        root.touch(["testFile3"])
    }

    Directory createDirectory(String path){
        println "creating directory ${path}"
        List<String> pathParts = FST.getPathParts(path)
        if(pathParts[0] == "/"){
            root.mkdir(pathParts[1..-1])
        } else{
            pwd.mkdir(pathParts)
        }
    }

    Directory getDirectory(String path){
        List<String> pathParts = FST.getPathParts(path)
        switch(path){
            case "/": return root; break
            case ".": return pwd; break
            default:
                if(pathParts[0] == "/"){
                    return root.getDirectory(pathParts[1..-1])
                } else{
                    return pwd.getDirectory(pathParts)
                }
        }
    }

    File createFile(String path){
        List<String> pathParts = FST.getPathParts(path)
        if(pathParts[0] == "/"){
            root.touch(pathParts[1..-1])
        } else{
            pwd.touch(pathParts)
        }
    }

    File getFile(String path){
        List<String> pathParts = FST.getPathParts(path)
        if(pathParts[0] == "/"){
            root.getFile(pathParts[1..-1])
        } else{
            pwd.getFile(pathParts)
        }
    }

    //delete a file or a directory
    boolean deleteNode(String path){
        List<String> pathParts = FST.getPathParts(path)
        if(pathParts[0] == "/"){
            root.deleteNode(pathParts[1..-1])
        } else{
            pwd.deleteNode(pathParts)
        }
    }
}
