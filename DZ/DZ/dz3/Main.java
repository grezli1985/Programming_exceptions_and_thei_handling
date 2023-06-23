package DZ.dz3;

public class Main {
    public static void main(String[] args) {
        Presenter<View> prog = new Presenter<View>(new UserController());
        prog.start();
    }
}
