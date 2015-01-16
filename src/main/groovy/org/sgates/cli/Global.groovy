package org.sgates.cli

import java.awt.Dimension
import java.awt.Font

/**
 * Created by sgates on 1/11/15.
 */
class Global {
    static final Dimension WINDOW_SIZE = new Dimension(1024, 768)
    static final PANEL_PAD = 7
    static final Font consoleFont = loadFont()

    static Font loadFont() {
        def file = new File("resources/fonts/Glass_TTY_VT220q.ttf");
        Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(20.0f);
    }
}
