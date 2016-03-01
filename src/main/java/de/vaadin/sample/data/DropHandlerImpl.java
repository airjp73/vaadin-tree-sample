package de.vaadin.sample.data;

import com.google.inject.Inject;
import com.google.inject.Provider;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.guice.annotation.UIScope;
import com.vaadin.ui.AbstractSelect;

import de.vaadin.sample.components.TreeA;
import de.vaadin.sample.components.TreeB;
import de.vaadin.sample.db.dao.NodeDao;
import de.vaadin.sample.db.domain.Node;

import static com.vaadin.ui.AbstractSelect.AcceptItem.ALL;

@UIScope
public class DropHandlerImpl implements DropHandler {

    @Inject
    private Provider<TreeA> treeAProvider;

    @Inject
    private Provider<TreeB> treeBProvider;

    @Inject
    private NodeDao nodeDao;

    @Override
    public void drop(DragAndDropEvent event) {
        Node node = (Node)event.getTransferable().getData("itemId");

        final TreeB treeB = treeBProvider.get();

        treeB.addItem(node);

        Node parent = (Node)((AbstractSelect.AbstractSelectTargetDetails)event.getTargetDetails()).getItemIdOver();

        if (parent != null) {
            treeB.setParent(node, parent);
            treeB.setCollapsed(parent, false);
        }
    }

    @Override
    public AcceptCriterion getAcceptCriterion() {
        return ALL;
    }
}
