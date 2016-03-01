package de.vaadin.sample.data;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

import com.vaadin.data.Item;
import com.vaadin.guice.annotation.UIScope;
import com.vaadin.ui.Tree;

import de.vaadin.sample.components.SampleTree;
import de.vaadin.sample.db.dao.NodeDao;
import de.vaadin.sample.db.domain.Node;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

@UIScope
public class TreeExpander implements Tree.ExpandListener {

    private Provider<SampleTree> treeProvider;

    protected TreeExpander(Provider<SampleTree> sampleTreeProvider){
        this.treeProvider = sampleTreeProvider;
    }

    @Inject
    private NodeDao nodeDao;

    @Override
    public void nodeExpand(Tree.ExpandEvent expandEvent) {
        Node node = (Node)expandEvent.getItemId();

        if(node == null){
            return;
        }

        for (Node subNode : nodeDao.getSubNodes(node)) {
            SampleTree tree = treeProvider.get();
            tree.addItem(subNode);
            checkState(tree.setParent(subNode, node));
        }
    }
}
