package de.vaadin.sample.data;

import com.google.inject.Inject;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.ContainerHierarchicalWrapper;

import de.vaadin.sample.db.domain.Node;

public abstract class NodeContainer extends ContainerHierarchicalWrapper {
    @Inject
    public NodeContainer(Node rootNode){
        super(getToBeWrapped());
        addItem(rootNode);
    }

    private static BeanItemContainer<Node> getToBeWrapped() {
        final BeanItemContainer<Node> nodeBeanItemContainer = new BeanItemContainer<>(Node.class);
        nodeBeanItemContainer.removeContainerProperty("parent");
        nodeBeanItemContainer.removeContainerProperty("nodeId");

        return nodeBeanItemContainer;
    }
}
