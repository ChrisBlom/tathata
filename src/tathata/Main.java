package tathata;

public class Main {

    public static void main(String[] args) {
	    Explosion ex = new Explosion();

        System.out.println("This is what happened:");
        System.out.println(ex.foo(42l));

        System.out.println("This is what happened:");
        System.out.println(ex.foo(0l));

    }

    static class Explosion {
        public int foo(Long f) {
            return this.bar(f).hashCode();
        }

        public String bar(Long b) {
            return baz(b.toString());
        }

        private String baz(String s) {
            if (s.equals("0")) throw new RuntimeException("You gave a zero");
            return s.concat("---");
        }

    }
}
