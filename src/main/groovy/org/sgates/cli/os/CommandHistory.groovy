package org.sgates.cli.os

/**
 * Created by sgates on 1/18/15.
 */
class CommandHistory {
    List history
    private static int BUFFER_SIZE

    {
        BUFFER_SIZE = 30
        history = []
//        100.times{
//            history << "$it - ${System.nanoTime()}"
//        }
    }

    List getRecent(){
        if(history.size() < 1){ return []}
        history[-1..(Math.max(0, history.size()-BUFFER_SIZE))].reverse()
    }

    void add (historyItem){
        history << historyItem
    }

    void append(text){
        if(history.size() == 0){
            history << text
            return
        }
        history.set(history.size()-1, history.get(history.size()-1) + text)
    }
}
