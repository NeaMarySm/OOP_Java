package geotree;

import java.util.ArrayList;

public class Research {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> parentNodes = new ArrayList<>();
    ArrayList<Node> childrenNodes = new ArrayList<>();
    ArrayList<String> descendants = new ArrayList<>();
    ArrayList<String> ancestors = new ArrayList<>();
    ArrayList<Node> tree;

    public Research(GeoTree geoTree) {

        tree = geoTree.getTree();
        setChildrenNodes();
        setParentNodes();
    }

    public ArrayList<String> spend(Person p, Relationship re) {
        for (Node t : tree) {
            if (t.p1.equals(p) && t.re == re) {
                result.add(t.p2.toString());
            }
        }
        return result;
    }

    public void setChildrenNodes() {
        for (Node t : tree) {
            if (t.re == Relationship.children) {
                childrenNodes.add(t);
            }
        }
    }
    public void setParentNodes() {
        for (Node t : tree) {
            if (t.re == Relationship.parent) {
                parentNodes.add(t);
            }
        }
    }

    public ArrayList<String> getDescendants(Person p) {
        for(Node t: parentNodes){
            if(t.p1 == p){
                descendants.add(t.p2.toString());
                getDescendants(t.p2);
            }
        }
        return descendants;
    }

    public ArrayList<String> getAncestors(Person p) {
        for (Node t : childrenNodes) {
            if (t.p1==p) {
                ancestors.add(t.p2.toString());
                getAncestors(t.p2);
            }
        }
        return ancestors;
    }

    public ArrayList<String> getClosest(Person p){
        ArrayList<String> result = new ArrayList<>();
        for(Node t: tree){
            if(t.p1 ==p && t.re==Relationship.children){
                if(t.p2.getGender()==Gender.female){
                    result.add("Mother: "+ t.p2.toString());
                } else result.add("Father: "+ t.p2.toString());
            } else if (t.p1 ==p && t.re==Relationship.parent) {
                if(t.p2.getGender()==Gender.female){
                    result.add("Daughter: "+ t.p2.toString());
                } else result.add("Son: "+ t.p2.toString());
            }
        }
        return result;
    }

    public void printNodes() {
        tree.forEach(node -> System.out.println(node));
    }

}
