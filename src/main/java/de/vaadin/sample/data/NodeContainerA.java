package de.vaadin.sample.data;

import com.google.inject.Inject;

import com.vaadin.data.util.IndexedContainer;
import com.vaadin.guice.annotation.UIScope;

import de.vaadin.sample.db.dao.NodeDao;
import de.vaadin.sample.db.domain.Node;

@UIScope
public class NodeContainerA extends NodeContainer {

    @Inject
    public NodeContainerA(NodeDao nodeDao) {
        super(nodeDao.get(2));
    }
}
