package geotree;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Research implements FileCreator {
    ArrayList<String> result = new ArrayList<>();
    ArrayList<Node> parentNodes = new ArrayList<>();
    ArrayList<Node> childrenNodes = new ArrayList<>();
    ArrayList<Node> tree;
    private static int counter = 0;

    public Research(GeoTree geoTree) {

        tree = geoTree.getTree();
        setChildrenNodes();
        setParentNodes();
    }

    public ArrayList<String> spend(Person p, Relationship re) {
        result.clear();
        for (Node t : tree) {
            if (t.p1.equals(p) && t.re == re) {
                result.add(t.p2.toString());
            }
        }
        counter++;
        return result;
    }
    public ArrayList<String> spend(Person p, Boolean descendants) {
        result.clear();
        if(descendants){
            getDescendants(p);
        } else {
            getAncestors(p);
        }
        counter++;

        return result;
    }
    public ArrayList<String> spend(Person p){
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
        counter++;
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

    public void getDescendants(Person p) {
        for(Node t: parentNodes){
            if(t.p1 == p){
                result.add(t.p2.toString());
                getDescendants(t.p2);
            }
        }
    }

    public void getAncestors(Person p) {
        for (Node t : childrenNodes) {
            if (t.p1==p) {
                result.add(t.p2.toString());
                getAncestors(t.p2);
            }
        }
    }

    @Override
    public void createFile() throws IOException {
        if(result.isEmpty()){
            System.out.println("Nothing to write");
            return;
        }
        String fileName = String.format("research_%d.txt", counter);
        FileWriter fw = new FileWriter(fileName);
        result.forEach(line-> {
            try {
                fw.write(line+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        fw.close();
    }
}
