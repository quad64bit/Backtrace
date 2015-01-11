package org.sgates.cli.datastructure

import static java.util.UUID.randomUUID

/**
 * Created by sgates on 1/6/15.
 */
class Directory extends FileSystemNode{
    List<FileSystemNode> contents = []
    String uid

    {
        uid = randomUUID()
    }

    public leftShift(FileSystemNode node){
        contents << node
    }

    public String getPath(){
        if(parent){
            return parent.getPath()+"/$name"
        }
        name
    }

    public void deleteNode(List<String> pathParts){
        FileSystemNode existingNode = contents.find { it.name == pathParts[0] }

        if(pathParts.size() == 1){
            if(existingNode){
                contents.remove(existingNode)
            } else{
                throw new Exception("File not found - ${pathParts[0]}!")
            }
        } else{
            if(existingNode){
                if(existingNode instanceof Directory){
                    (existingNode as Directory).deleteNode(pathParts[1..-1])
                } else{
                    throw new Exception("${pathParts[0]} isn't a directory!")
                }
            } else{
                throw new Exception("File not found!")
            }
        }
    }

    public File getFile(List<String> pathParts){
        FileSystemNode existingNode = contents.find { it.name == pathParts[0] }

        if(pathParts.size() == 1) {
            if (existingNode) {
                if (existingNode instanceof File) {
                    return existingNode as File
                } else {
                    throw new Exception("Existing node is not a directory!")
                }
            } else{
                throw new Exception("File not found!")
            }
        } else{
            if (existingNode instanceof File) {
                return (existingNode as File).getFile(pathParts[1..-1])
            } else {
                throw new Exception("${pathParts[0]} is not a file!")
            }
        }
    }

    public Directory getDirectory(List<String> pathParts){
        FileSystemNode existingNode = contents.find { it.name == pathParts[0] }

        if(pathParts.size() == 1) {
            if (existingNode) {
                if (existingNode instanceof Directory) {
                    return existingNode as Directory
                } else {
                    throw new Exception("Existing node is not a directory!")
                }
            } else{
                throw new Exception("Directory not found!")
            }
        } else{
            if (existingNode instanceof Directory) {
                return (existingNode as Directory).getDirectory(pathParts[1..-1])
            } else {
                throw new Exception("${pathParts[0]} is not a directory!")
            }
        }
    }

    public File touch(List<String> pathParts){
        FileSystemNode existingNode = contents.find { it.name == pathParts[0] }
        if(pathParts.size() == 1){
            if(!existingNode){
                File file = new File(name:pathParts[0], parent: this)
                contents << file
                return file
            }

            if(existingNode instanceof File){
                return existingNode as File
            } else{
                throw new Exception("Tried to create a file, but an existing non-file type already exists")
                return null
            }
        }

        def destDir = mkdir(pathParts[0..-2])
        destDir.touch([pathParts[-1]])
    }

    public Directory mkdir(List<String> pathParts){
        FileSystemNode existingNode = contents.find { it.name == pathParts[0] }

        if(existingNode){
            switch(existingNode){
                case Directory:
                    Directory existingDirectory = existingNode as Directory
                    if(pathParts.size() > 1){
                        return existingDirectory.mkdir(pathParts[1..-1])
                    } else{
                        return existingDirectory
                    }
                    break
                case File:
                    throw new Exception("A directory cannot be created with the same name as a file!")
                    break
                default:
                    throw new Exception("Unsupport type exception! ${existingNode.getClass()}")
            }
        } else{
            Directory newDir = new Directory(
                    name:pathParts[0],
                    parent: this
            )
            contents << newDir
            if(pathParts.size() > 1){
                return newDir.mkdir(pathParts[1..-1])
            }
            return newDir
        }
    }

    @Override
    String toString(){
        "$name/"
    }
}
