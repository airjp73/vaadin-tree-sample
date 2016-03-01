package de.vaadin.sample.data;

import com.google.inject.Inject;

import com.vaadin.data.util.BeanItemContainer;

import de.vaadin.sample.db.domain.Node;

public abstract class NodeContainer extends BeanItemContainer<Node> {
    @Inject
    public NodeContainer(Node rootNode){
        super(Node.class);
        removeContainerProperty("parent");
        removeContainerProperty("nodeId");
        addItem(rootNode);
    }
}
