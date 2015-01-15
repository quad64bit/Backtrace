package org.sgates.cli.gui.panel.structure

import org.sgates.cli.Global
import org.sgates.cli.datastructure.Offset

import java.awt.Graphics2D
import java.awt.image.BufferedImage

/**
 * Created by sgates on 1/13/15.
 */
abstract class TertiaryPanel extends GenericPanel{
    {
        canvas = new BufferedImage(342, 256, BufferedImage.TYPE_INT_RGB)
        offset = new Offset(682, 0)
        padBottom = padTop = padRight = Global.PANEL_PAD
        padLeft = 0
    }

    Graphics2D getGraphics(){
        canvas.graphics as Graphics2D
    }
}
