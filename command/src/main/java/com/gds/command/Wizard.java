package com.gds.command;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhanglifeng
 * @since 2020-03-03 17:06
 */
public class Wizard {

    private Deque<Command> undoStack = new LinkedList<>();
    private Deque<Command> redoStack = new LinkedList<>();

    public void castSpell(Command command, Target target) {
        System.out.printf("%s casts %s at %s \n", this, command, target);
        command.execute(target);
        undoStack.offerLast(command);
    }

    public void undoLastSpell() {
        if (!undoStack.isEmpty()) {
            Command command = undoStack.pollLast();
            redoStack.offerLast(command);
            System.out.printf("%s undoes %s \n", this, command);
            command.undo();
        }
    }

    /**
     * 重做最后的法术
     */
    public void redoLastSpell() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pollLast();
            undoStack.offerLast(command);
            System.out.printf("%s redoes %s \n", this, command);
            command.redo();
        }
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}
