package org.sgates.cli.test

import org.sgates.cli.parsing.CommandParser
import spock.lang.*

/**
 * Created by sgates on 1/6/15.
 */
class CommandParserTests extends Specification{
    CommandParser cp

    void setup(){
        cp = new CommandParser()
    }

    void "test that command parser generates a command from a string"(){
        when: "a command parser is given a string"
            def result = cp.getCommand("ls -a 25 -b abcdef")
        then: "result shouldn't be null"
            result != null
    }
}
