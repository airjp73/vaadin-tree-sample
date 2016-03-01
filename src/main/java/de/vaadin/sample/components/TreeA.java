package de.vaadin.sample.components;

import com.google.inject.Inject;

import com.vaadin.event.dd.DropHandler;
import com.vaadin.server.DragAndDropService;
import com.vaadin.ui.Tree;

import de.vaadin.sample.data.NodeContainerA;
import de.vaadin.sample.data.TreeExpanderA;

public class TreeA extends SampleTree {

    @Inject
    TreeA(NodeContainerA nodeContainer, TreeExpanderA treeExpander, DropHandler dropHandler) {
        super(nodeContainer, treeExpander, dropHandler);
    }
}
