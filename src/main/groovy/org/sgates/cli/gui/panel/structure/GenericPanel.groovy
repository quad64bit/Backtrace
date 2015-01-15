package org.sgates.cli.gui.panel.structure

import org.sgates.cli.datastructure.Offset

import java.awt.BasicStroke
import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage

/**
 * Created by sgates on 1/13/15.
 */
abstract class GenericPanel implements RenderablePanel{
    protected BufferedImage canvas
    protected int padLeft, padRight, padTop, padBottom
    protected float borderWeight = 1
    protected Color borderColor = Color.GREEN
    protected Offset offset

    void renderBorder(Graphics2D g){
        g.setStroke(new BasicStroke(borderWeight))
        g.setColor(borderColor)
        g.drawRect(
                padLeft,
                padTop,
                canvas.width - (padRight + padLeft),
                canvas.height - (padBottom + padTop)
        )
    }

    void render(Graphics2D context){
        Graphics2D g = getGraphics()
        renderBackground(g)
        renderBorder(g)
        renderForeground(g)
        renderOverlay(g)
        g.dispose()
        context.drawImage(canvas, offset.x, offset.y, null)
    }
}
