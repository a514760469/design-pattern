package com.gds.zan;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author zhanglifeng
 * @since 2020-03-11 13:47
 */
public class ProjectIterator implements IProjectIterator {

    private List<IProject> projectList;

    private int current;

    public ProjectIterator(List<IProject> projectList) {
        Objects.requireNonNull(projectList);
        this.projectList = projectList;
        this.current = 0;
    }

    @Override
    public boolean hasNext() {
        return this.current < projectList.size() && projectList.get(this.current) != null;
    }

    @Override
    public IProject next() {
        return projectList.get(current++);
    }
}
