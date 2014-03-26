interface FlyingCreature {

	String getName();

	default void fly() {
		System.out.println(getName() + " is flying");
	}
}

abstract class NamedCreature {
    String name;
    public NamedCreature(String name) {
        this.name = name;
    }
    public String getName() {
	    return name;
    }
}

class Griffon extends NamedCreature implements FlyingCreature {
    public Griffon(String n) { super(n); }
}

class Dragon extends NamedCreature implements FlyingCreature {
    public Dragon(String n) { super(n); }
}

public class Parenting {
    public static void main(String ... args) {
	    Dragon d = new Dragon("Smaug");
	    Griffon g = new Griffon("Gilda");
	    d.fly(); // Smaug is flying
	    g.fly(); // Gilda is flying
    }
}
