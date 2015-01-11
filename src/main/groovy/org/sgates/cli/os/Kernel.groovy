package org.sgates.cli.os

import org.sgates.cli.parsing.CommandParser

/**
 * Created by sgates on 1/6/15.
 */
class Kernel {
    FileSystem      fileSystem
    CommandParser   commandParser
    CommandRegistry commandRegistry
}
