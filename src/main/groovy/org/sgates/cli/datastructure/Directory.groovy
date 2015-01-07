package org.sgates.cli.datastructure

/**
 * Created by sgates on 1/6/15.
 */
class Directory extends FileSystemNode{
    List<FileSystemNode> contents = []

    public leftShift(FileSystemNode node){
        contents << node
    }

    @Override
    String toString(){
        "$name/"
    }
}
