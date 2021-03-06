package org.sgates.cli.gui

import org.sgates.cli.BtConsole
import org.sgates.cli.Global
import org.sgates.cli.gui.panel.ProcessViewerPanel
import org.sgates.cli.gui.panel.TerminalPanel
import org.sgates.cli.gui.panel.TraceTrackerPanel

import javax.swing.JPanel
import java.awt.Color
import java.awt.Graphics
import java.awt.Graphics2D

/**
 * Created by sgates on 1/11/15.
 */
class ConsoleGUI extends JPanel{
    {
        this.setPreferredSize(Global.WINDOW_SIZE)
        this.setSize(Global.WINDOW_SIZE)

        terminalPanel = new TerminalPanel()
        processViewerPanel = new ProcessViewerPanel()
        traceTrackerPanel = new TraceTrackerPanel()
    }

    TerminalPanel terminalPanel
    ProcessViewerPanel processViewerPanel
    TraceTrackerPanel traceTrackerPanel
    BtConsole console

    public void init(){
        terminalPanel.console = console
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics)
        Graphics2D g = graphics as Graphics2D
        renderBackground(g)
        terminalPanel.render(g)
        processViewerPanel.render(g)
        traceTrackerPanel.render(g)
        g.dispose()
    }

    private void renderBackground(Graphics2D g){
        g.setColor(Color.BLACK)
        g.fillRect(0, 0, Global.WINDOW_SIZE.width as int, Global.WINDOW_SIZE.height as int)
    }
}
