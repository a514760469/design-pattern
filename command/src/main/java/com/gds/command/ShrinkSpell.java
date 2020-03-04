package com.gds.command;

/**
 * @author zhanglifeng
 * @since 2020-03-04 11:13
 * 缩小术
 */
public class ShrinkSpell extends Command {

    private Target target;

    private Size oldSize;

    @Override
    public void execute(Target target) {
        this.oldSize = target.getSize();
        target.setSize(Size.SMALL);
        this.target = target;
    }

    @Override
    public void undo() {
        if (oldSize != null && target != null) {
            Size temp = target.getSize();
            target.setSize(oldSize);
            oldSize = temp;
        }
    }

    @Override
    public void redo() {
        undo();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
