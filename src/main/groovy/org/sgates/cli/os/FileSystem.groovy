package org.sgates.cli.os

import org.sgates.cli.datastructure.Directory
import org.sgates.cli.datastructure.FileSystemNode
import org.sgates.cli.util.FileSystemTools as FST

/**
 * Created by sgates on 1/6/15.
 */
class FileSystem {
    long capacity
    Directory root = new Directory(name:"/")
    Directory pwd = root

    Directory createDir(String path){
        def pathParts = FST.getPathParts(path)
        if(pathParts[0] == "/"){
            root.mkdir(pathParts[1..-1])
        } else{
            pwd.mkdir(pathParts)
        }
    }

    Directory getDirectory(String path){

    }

    File createFile(String path){

    }

    File getFile(String path){

    }

    //delete a file or a directory
    boolean deleteNode(String path){

    }

    List<FileSystemNode> findByName(String name){

    }


}
