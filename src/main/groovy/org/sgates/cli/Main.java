package org.sgates.cli;

import org.sgates.cli.os.BootLoader;
import org.sgates.cli.os.Kernel;

/**
 * Created by sgates on 1/6/15.
 */
public class Main {
    public static void main(String[] args){
        Console console = new Console();
        console.setKernel(BootLoader.boot());
        console.display();
    }
}
