package org.sgates.cli

import java.awt.Dimension
import java.awt.Font

/**
 * Created by sgates on 1/11/15.
 */
class Global {
    static final Dimension WINDOW_SIZE = new Dimension(1024, 768)
    static final PANEL_PAD = 7
    static final Font CONSOLE_FONT = loadFont("resources/fonts/Glass_TTY_VT220.ttf")
    static final Font BANNER_FONT = loadFont("resources/fonts/monaco.ttf")
    static final Long DEFAULT_PRINT_DELAY = 150

    static Font loadFont(String fontPath) {
        File file = new File(fontPath)
        Font.createFont(Font.TRUETYPE_FONT, file).deriveFont(20.0f);
    }
}
