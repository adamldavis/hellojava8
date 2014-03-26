public interface Iface {

    public static double random() {
        return Math.random();
    }

    public default String getName() {
        return "name";
    }
    
    /*public static void main(String...args) {
        System.out.println(Iface.random());
    }//*/
}
