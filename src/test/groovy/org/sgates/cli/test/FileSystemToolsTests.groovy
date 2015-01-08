package org.sgates.cli.test

import org.sgates.cli.util.FileSystemTools
import spock.lang.Specification


/**
 * Created by sgates on 1/7/15.
 */
class FileSystemToolsTests extends Specification {
    FileSystemTools fst

    def setup(){
        fst = new FileSystemTools()
    }

    def "getPathParts() works with absolute paths"(){
        given: "an absolute path"
            String aPath = "/alpha/beta/gamma"
        when: "getPathParts() is called"
            def parts = fst.getPathParts(aPath)
        then: "The parts should include root, alpha, beta, gamma"
            parts == ["/", "alpha", "beta", "gamma"]
    }

    def "getPathParts() works with relative paths"(){
        given: "a relative path"
            String rPath = "alpha/beta/gamma"
        when: "getPathParts() is called"
            def parts = fst.getPathParts(rPath)
        then: "The parts should include alpha, beta, gamma"
            parts == ["alpha", "beta", "gamma"]
    }
}