package org.sgates.cli.gui.panel.structure

import java.awt.Graphics2D

/**
 * Created by sgates on 1/14/15.
 */
interface RenderablePanel {
    void renderBackground(Graphics2D g)
    void renderForeground(Graphics2D g)
    void renderOverlay(Graphics2D g)
    void render(Graphics2D context)
    Graphics2D getGraphics()
}