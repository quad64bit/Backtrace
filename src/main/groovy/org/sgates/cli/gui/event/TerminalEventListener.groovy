package org.sgates.cli.gui.event

import org.sgates.cli.Console

import javax.swing.JPanel
import java.awt.event.KeyEvent as KE
import java.awt.event.KeyListener

/**
 * Created by sgates on 1/11/15.
 */
class TerminalEventListener implements KeyListener{
    JPanel canvas
    Console console

    @Override
    void keyTyped(KE e) {
        //do nothing
    }

    @Override
    public void keyPressed(KE e) {//enter
        int code = e.getKeyCode();

        switch(code){
            case KE.VK_ENTER: break
            case KE.VK_SPACE:
            case 43..126: // text
                console.currentLine += e.getKeyChar()
                break
            case KE.VK_BACK_SPACE:
                if (console.currentLine.length() > 1) {
                    console.currentLine = console.currentLine[0..-2];
                } else{
                    console.currentLine = ""
                }
                break
            case KE.VK_UP: break
            case KE.VK_DOWN: break
            case KE.VK_LEFT: break
            case KE.VK_RIGHT: break
            case KE.VK_TAB: break
        }

//        println console.currentLine
        canvas.repaint()

//        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//            if (currentLine.length() > 0 || endLine.length() > 0) {
//                currentLine += endLine;
//                displayEnd = false;
//                endLine = "";
//
//                if (prompt.contains("Username:")) {
//                    prompt = currentLine + "@Hackerz:#";
//                    username = currentLine;
//                    currentLine = "";
//                    println("Welcome " + username);
//                    canvas.repaint();
//                    return;
//                }
//
//                // The entire contents of the input box, including
//                // the preexisting shell characters.
//                String wholeCommand = prompt + " " + currentLine;
//
//                // Print the command first before executing the command.
//                println(wholeCommand);
//
//                boolean result = processCommand(currentLine);
//
//                // Do these even if the user enters an invalid command.
//                history.add(currentLine);
//                highlight = 0;
//                commandIndex++;
//
//                if (!result) {
//                    // The user has entered an invalid command.
//                    // Print an error message.
//                    println(String.format(
//                            "Error: '%s' is an invalid command", currentLine));
//                }
//
//                // This way we can at least give the user an error message instead
//                // of just clearing the box when a bad command is entered.
//
//                currentLine = "";
//                canvas.repaint();
//                return;
//            }
//        }
//
//        if (code == 16) {
//            shift = true;
//            return;
//        }
//        if (code == 192) {// `
//            toggleCommandHistory();
//            window.repaint();
//            return;
//        }
//        if (code == 92) {// \
//            toggleWidgets();
//            window.repaint();
//            return;
//        }
//        if (code > 42 && code < 127 || code == 32) {//text
//            currentLine += e.getKeyChar();
//        }
//        if (code == 8) {//delete
//            if (currentLine.length() > 0) {
//                currentLine = currentLine.substring(0, currentLine.length() - 1);
//            }
//        }
//        if (code == 38) {//up
//            displayEnd = false;
//            endLine = "";
//            if (shift) {
//                //scroll console history up
//                if (console.size() > 22 && consoleIndex > 21) {
//                    consoleIndex--;
//                }
//                window.repaint();
//                return;
//            }
//            if (highlight < 5 && history.size() > 0 && highlight < history.size()) {
//                highlight++;
//                currentLine = history.get(commandIndex - (highlight - 1));
//            } else if (highlight == 5 && commandIndex >= 5) {
//                commandIndex--;
//                currentLine = history.get(commandIndex - (highlight - 1));
//            }
//        }
//        if (code == 40) {//down
//            displayEnd = false;
//            endLine = "";
//            if (shift) {
//                //scroll console history down
//                if (console.size() > 22 && consoleIndex < console.size() - 1) {
//                    consoleIndex++;
//                }
//                window.repaint();
//                return;
//            }
//            if (highlight > 1) {
//                highlight--;
//                currentLine = history.get(commandIndex - (highlight - 1));
//            } else if (highlight == 1 && commandIndex < history.size() - 1) {
//                commandIndex++;
//                currentLine = history.get(commandIndex - (highlight - 1));
//            } else if (highlight == 1 && commandIndex == history.size() - 1) {
//                currentLine = "";
//                highlight--;
//                canvas.repaint();
//                return;
//            }
//        }
//        if (code == 37) {//left
//            if(currentLine.length() > 0) {
//                displayEnd = true;
//                endLine = currentLine.substring(currentLine.length() -1, currentLine.length()) + endLine;
//                currentLine = currentLine.substring(0, currentLine.length() - 1);
//            }
//        }
//        if (code == 39) {//right
//            if(endLine.length() == 1) {
//                displayEnd = false;
//                currentLine += endLine;
//                endLine = "";
//            }
//            if(endLine.length() > 1) {
//                currentLine += endLine.substring(0, 1);
//                endLine = endLine.substring(1);
//            }
//        }
//        if (code == e.VK_TAB){
//            autoComplete();
//        }
//        canvas.repaint();
    }

    @Override
    void keyReleased(KE e) {
        //do nothing
    }
}
