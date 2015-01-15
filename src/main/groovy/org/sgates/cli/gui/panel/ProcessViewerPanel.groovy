package org.sgates.cli.gui.panel

import org.sgates.cli.gui.panel.structure.SecondaryPanel

import java.awt.Color
import java.awt.Graphics2D

/**
 * Created by sgates on 1/14/15.
 */
class ProcessViewerPanel extends SecondaryPanel{
    private Color backgroundColor = Color.BLACK

    void renderBackground(Graphics2D g){
        g.setColor(backgroundColor)
        g.fillRect(0, 0, canvas.width, canvas.height)
    }

    void renderForeground(Graphics2D g) {

    }

    void renderOverlay(Graphics2D g) {

    }
}
