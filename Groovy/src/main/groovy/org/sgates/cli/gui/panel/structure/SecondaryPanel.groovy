package org.sgates.cli.gui.panel.structure

import org.sgates.cli.Global
import org.sgates.cli.datastructure.Offset

import java.awt.Graphics2D
import java.awt.image.BufferedImage

/**
 * Created by sgates on 1/13/15.
 */
abstract class SecondaryPanel extends GenericPanel{
    {
        canvas = new BufferedImage(342, 512, BufferedImage.TYPE_INT_RGB)
        offset = new Offset(682, 256)
        padLeft = padTop = 0
        padRight = padBottom = Global.PANEL_PAD
    }

    Graphics2D getGraphics(){
        canvas.graphics as Graphics2D
    }
}
