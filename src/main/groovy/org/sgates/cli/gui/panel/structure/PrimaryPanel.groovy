package org.sgates.cli.gui.panel.structure

import org.sgates.cli.Global
import org.sgates.cli.datastructure.Offset

import java.awt.Graphics2D
import java.awt.image.BufferedImage

/**
 * Created by sgates on 1/13/15.
 */
abstract class PrimaryPanel extends GenericPanel{
    {
        canvas = new BufferedImage(682, 768, BufferedImage.TYPE_INT_RGB)
        offset = new Offset(0,0)
        padLeft = padRight = padTop = padBottom = Global.PANEL_PAD
    }

    Graphics2D getGraphics(){
        canvas.graphics as Graphics2D
    }
}
