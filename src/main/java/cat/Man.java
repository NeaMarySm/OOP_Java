package cat;

public class Man {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Man(String name) {
        this.name = name;
    }
    public void callCat(Cat cat){
        System.out.println(name +" calls "+cat.getName());
        cat.meow();
    }
    public boolean feedCat(Cat cat, String food){
        System.out.println(name +" feeds "+cat.getName()+" with "+food);

        return cat.eat(food);
    }
}
