interface Foo1 {
    default void foo() {
        System.out.println("foo");
    }
}
interface Foo2 {
    default void foo() {
        System.out.println("foobar");
    }
}
public class Twoface implements Foo1, Foo2 {
    //compilation error!
    
    public static void main(String...args) {
        new Twoface().foo();
    }
//    public void foo() { Foo1.super.foo(); }
}
    
