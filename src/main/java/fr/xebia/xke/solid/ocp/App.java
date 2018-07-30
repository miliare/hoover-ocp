package fr.xebia.xke.solid.ocp;

public class App {

    public static void main( String[] args ) {
        Hoover hoover = new Hoover("ADAAAGADA");
        System.out.println("Starting hoover position is [" + hoover.getPosition().x + ", " + hoover.getPosition().y + "]");
        hoover.clean();
        System.out.println("Final hoover position is [" + hoover.getPosition().x + ", " + hoover.getPosition().y + "]");
    }
}
