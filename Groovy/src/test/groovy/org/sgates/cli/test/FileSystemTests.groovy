package org.sgates.cli.test

import org.sgates.cli.os.FileSystem
import org.sgates.cli.datastructure.File
import spock.lang.Specification


/**
 * Created by sgates on 1/7/15.
 */
class FileSystemTests extends Specification {
    FileSystem fs

    def setup(){
        fs = new FileSystem()
    }

    def "there should be a root directory, and a pwd pointing at the same directory"(){
        expect: "the file system should have a root directory"
            fs.root != null
            fs.root.name == "/"
        and: "The pwd should exist and be set to root"
            fs.pwd != null
            fs.pwd == fs.root
    }

    def "getFile should return a file in the root"(){
        given: "a file in the root"
            fs.createFile("/someFile.txt")
        when: "getFile is called"
            File file = fs.getFile("/someFile.txt")
        then: "file shouldn't be null"
            file
        and: "file should have correct name"
            file.name == "someFile.txt"
    }

    def "deleteNode should delete a file in the root"(){
        given: "a file in the root"
            fs.createFile("/someFile.txt")
        when: "deleteNode() is called"
            fs.deleteNode("/someFile.txt")
        then: "the file should be gone"
            try {
                fs.getFile("/someFile.txt")
            } catch (e){
                e != null
            }
    }

    def "deleteNode should delete a directory in the root"(){
        given: "a file in the root"
            fs.createDirectory("/someFolder")
        when: "deleteNode() is called"
            fs.deleteNode("/someFolder")
        then: "the file should be gone"
            try {
                fs.getDirectory("/someFolder")
            } catch (e){
                e != null
            }
    }
}