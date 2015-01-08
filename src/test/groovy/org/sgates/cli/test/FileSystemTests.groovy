package org.sgates.cli.test

import org.sgates.cli.os.FileSystem
import spock.lang.Specification


/**
 * Created by sgates on 1/7/15.
 */
class FileSystemTests extends Specification {
    FileSystem fs

    def setup(){
        fs = new FileSystem()
    }

    def "File system should have a root directory, and a pwd pointing at the same directory"(){
        expect: "the file system should have a root directory"
            fs.root != null
            fs.root.name == "/"
        and: "The pwd should exist and be set to root"
            fs.pwd != null
            fs.pwd == fs.root
    }
}