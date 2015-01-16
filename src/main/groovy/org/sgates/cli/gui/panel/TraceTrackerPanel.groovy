package org.sgates.cli.gui.panel

import org.sgates.cli.gui.panel.structure.TertiaryPanel

import java.awt.Color
import java.awt.Graphics2D

/**
 * Created by sgates on 1/14/15.
 */
class TraceTrackerPanel extends TertiaryPanel{
    private Color backgroundColor = Color.BLACK

    @Override
    void renderBackground(Graphics2D g) {
        g.setColor(backgroundColor)
        g.fillRect(0, 0, canvas.width, canvas.height)
    }

    @Override
    void renderForeground(Graphics2D g) {
        g.setColor(Color.blue)
        g.drawString("Time: ${System.currentTimeMillis()}", 20, 50)
    }

    @Override
    void renderOverlay(Graphics2D g) {

    }
}
