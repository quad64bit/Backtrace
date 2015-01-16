package org.sgates.cli.gui.panel

import org.sgates.cli.Global
import org.sgates.cli.gui.panel.structure.PrimaryPanel
import org.sgates.cli.gui.panel.structure.RenderablePanel

import java.awt.Color
import java.awt.Graphics2D
import java.awt.RenderingHints

/**
 * Created by sgates on 1/13/15.
 */
class TerminalPanel extends PrimaryPanel implements RenderablePanel{
    private Color backgroundColor = Color.BLACK
    org.sgates.cli.Console console

    void renderBackground(Graphics2D g){
        g.setColor(backgroundColor)
        g.fillRect(0, 0, canvas.width, canvas.height)
    }

    void renderForeground(Graphics2D g){
        g.setColor(Color.red)
        g.drawString("Time: ${System.currentTimeMillis()}", 20, 50)
        renderPrompt(g)
    }

    void renderOverlay(Graphics2D g){

    }

    void renderPrompt(Graphics2D g){
        g.setColor(Color.CYAN)
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON)
        g.setFont(Global.consoleFont)
        g.drawString("\$ ${console?.currentLine}", 20, canvas.height - 20)
    }
}
