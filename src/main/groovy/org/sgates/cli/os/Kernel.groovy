package org.sgates.cli.os

import org.sgates.cli.BtConsole
import org.sgates.cli.gui.panel.structure.Printable
import org.sgates.cli.parsing.CommandParser

/**
 * Created by sgates on 1/6/15.
 */
class Kernel {
    FileSystem          fileSystem
    CommandParser       commandParser
    CommandRegistry     commandRegistry
    BtConsole           console
    ProcessMonitor      processMonitor
}
