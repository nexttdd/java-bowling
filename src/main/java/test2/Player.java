package test2;

public class Player {
    String name;

    public Player(String name) {
        if(name == null){
            throw new NullPointerException();
        }
        if(name.length()>3){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
