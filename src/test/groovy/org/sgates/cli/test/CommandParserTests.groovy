package org.sgates.cli.test

import org.sgates.cli.parsing.CommandParser

/**
 * Created by sgates on 1/6/15.
 */
class CommandParserTests {
    public void test(){
        CommandParser cp = new CommandParser()
        println cp.getCommand("ls -a 25 -b abcdef")
    }
}
