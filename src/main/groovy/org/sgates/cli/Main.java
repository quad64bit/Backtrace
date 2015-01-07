package org.sgates.cli;

import org.sgates.cli.os.BootLoader;

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
