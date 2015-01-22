package org.sgates.cli.gui.panel

import org.sgates.cli.BtConsole
import org.sgates.cli.Global
import org.sgates.cli.gui.panel.structure.PrimaryPanel

import java.awt.Color
import java.awt.Graphics2D
import java.awt.RenderingHints

/**
 * Created by sgates on 1/13/15.
 */
class TerminalPanel extends PrimaryPanel{
    private Color backgroundColor = Color.BLACK
    BtConsole console

    void renderBackground(Graphics2D g){
        g.setColor(backgroundColor)
        g.fillRect(0, 0, canvas.width, canvas.height)
    }

    void renderForeground(Graphics2D g){
        renderPrompt(g)
        renderHistory(g)
    }

    void renderOverlay(Graphics2D g){
        consoleText(g)
        int pathSize = console.kernel.fileSystem.pwd.getPath().length()
        if(("${System.currentTimeMillis()}"[10..-1] as int) > 500) {
            g.drawString((" " * (console.insertionPoint + pathSize + 3)) + "█", 20, canvas.height - 20)
        }
    }

    private void renderHistory(Graphics2D g){
        consoleText(g)
        console.commandHistory.recent.eachWithIndex{ line, index ->
            g.drawString(line, 20, 30 + 24*index)
        }
    }

    private void renderPrompt(Graphics2D g){
        consoleText(g)
        String path = console.kernel.fileSystem.pwd.getPath()
        g.drawString("$path \$ ${console?.currentLine}", 20, canvas.height - 20)
    }

    private void consoleText(Graphics2D g){
        g.setColor(Color.CYAN)
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON)
        g.setFont(Global.CONSOLE_FONT)
    }

    @Override
    void println(String text) {
        if(text == ""){
            console.commandHistory.add("")
        }
        StringBuffer sb = new StringBuffer(text)
        def lines = sb.readLines()
        lines.each { line ->
            console.commandHistory.add(line)
        }
    }

    @Override
    void print(String text) {
        console.commandHistory.append(text)
    }
}
