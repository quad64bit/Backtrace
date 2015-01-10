package org.sgates.cli.test

import org.sgates.cli.datastructure.Directory
import org.sgates.cli.datastructure.File
import spock.lang.Specification


/**
 * Created by sgates on 1/7/15.
 */
class DirectoryTests extends Specification {
    Directory dir

    def setup(){
        dir = new Directory(name:"someFolder")
    }

    def "mkdir should make a nested directory"(){
        given: "a 0 depth path"
            def path = ["childFolder"]
        when: "mkdir() is called"
            Directory subDir = dir.mkdir(path)
        then: "subDir should be non-null"
            subDir != null
        and: "subdir should have the expected name"
            subDir.name == "childFolder"
        and: "dir should have subdir as a child"
            dir.contents.contains(subDir)
    }

    def "directories should generate UIDs automatically, and they should be unique"(){
        given: "several directories"
            Directory d1 = new Directory()
            Directory d2 = new Directory()
            Directory d3 = new Directory()
        when: "their uids are compared"
            def uidsMatch = d1.uid == d2.uid == d3.uid
        then: "they shouldn't match"
            !uidsMatch
    }

    def "if directory exists, return it instead of creating a new one"(){
        given: "an existing subdir and a 0 depth path"
            def existingDir = new Directory(name:"childFolder", parent: dir)
            dir.contents << existingDir
            def existingUid = existingDir.uid
            def path = ["childFolder"]
        when: "mkdir() is called"
            Directory subDir = dir.mkdir(path)
        then: "subDir should be the existing dir"
            subDir.uid == existingUid
    }

    def "mkdir() should create nested directories of n depth"(){
        given: "a path with >0 depth"
            def path = ["alpha","beta","gamma"]
        when: "mkDir() is called"
            def gamma = dir.mkdir(path)
        then: "gamma should be created"
            gamma
        and: "gamma's name should be gamma"
            gamma.name == "gamma"
        and: "gamma's parent should be beta"
            gamma.parent.name == "beta"
        and: "beta's parent should be alpha"
            gamma.parent.parent.name == "alpha"
        and: "dir should contain alpha"
            Directory alpha = dir.contents.find { it.name == "alpha" }
            alpha
        and: "alpha should have gamma as a descendant"
            def foundGamma = (alpha.contents.find { it.name == "beta" } as Directory).
                contents.find { it.name == "gamma"}
            foundGamma == gamma
    }

    def "touching a file should create a file"(){
        when: "touch() is called at 0 depth"
            File file = dir.touch(["banana.txt"])
        then: "file should exist"
            file
        and: "name should be banana.txt"
            file.name == "banana.txt"
        and: "parent should be dir"
            file.parent == dir
        and: "dir should contain this file"
            dir.contents.find{ it.name == "banana.txt" }
    }

    def "touching a nested file should create a nested file"(){
        when: "touch is called at n depth"
            File file = dir.touch(["alpha","beta","gamma","banana.txt"])
        then: "file should exist"
            file
        and: "it should be called banana.txt"
            file.name == "banana.txt"
        and: "it's great great grand parent should be dir"
            file.parent.parent.parent.parent == dir
    }

    def "getting a directory at level 0 should return the expected directory"(){
        given: "a nested directory"
            dir.mkdir(["stuff"])
        when: "we ask to get said directory"
            Directory loadedDir = dir.getDirectory(["stuff"])
        then: "loadedDir shouldn't be null"
            loadedDir
        and: "it should have the correct name"
            loadedDir.name == "stuff"
    }

    def "getting a directory at level n should return the expected directory"(){
        given: "a nested directory"
            dir.mkdir(["alpha", "beta", "gamma", "stuff"])
        when: "we ask to get said directory"
            Directory loadedDir = dir.getDirectory(["alpha", "beta", "gamma", "stuff"])
        then: "loaded dir shouldn't be null"
            loadedDir
        and: "It should have the correct name"
            loadedDir.name == "stuff"
    }

    def "path on a nested folder should return the expected path"(){
        given: "a nested directory"
            Directory nestedDir = dir.mkdir(["alpha", "beta", "gamma", "stuff"])
        when: "we ask for the path on said directory"
            String path = nestedDir.getPath()
        then: "path should be as expected"
            path == "someFolder/alpha/beta/gamma/stuff"
    }
}