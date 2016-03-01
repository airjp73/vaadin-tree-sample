package de.vaadin.sample.components;

import com.google.inject.Inject;

import com.vaadin.event.dd.DropHandler;
import com.vaadin.guice.annotation.UIScope;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.TreeTable;

import de.vaadin.sample.data.NodeContainer;
import de.vaadin.sample.data.TreeExpander;
import de.vaadin.sample.db.domain.Node;

import static com.vaadin.ui.Table.TableDragMode.ROW;

@UIScope
public class SampleTree extends TreeTable {

    SampleTree(NodeContainer nodeContainer, TreeExpander treeExpander, DropHandler dropHandler){
        super(null, nodeContainer);
        addExpandListener(treeExpander);
        setDropHandler(dropHandler);

        addGeneratedColumn("name", (source, itemId, columnId) -> {
            Node node = (Node)itemId;
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            horizontalLayout.addComponent(new Image(null, new ExternalResource("http://icons.iconarchive.com/icons/hopstarter/sleek-xp-basic/24/Folder-icon.png")));
            horizontalLayout.addComponent(new Label("node " + node.getNodeId()));
            return horizontalLayout;
        });

        setDragMode(ROW);

        setHeight("100%");
        setWidth("280px");
    }
}
