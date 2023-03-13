package geotree;
import java.util.ArrayList;

public class GeoTree implements Printable{
    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    public void append(Person parent, Person children) {
        tree.add(new Node(parent, Relationship.parent, children));
        tree.add(new Node(children, Relationship.children, parent));
    }


    @Override
    public void print() {
        tree.forEach(node -> System.out.println(node));
    }
}
