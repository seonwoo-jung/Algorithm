package algorithm.ch03;

public class IdTester {

    public static void main(String[] args) {
        Id a = new Id();
        Id b = new Id();

        System.out.println("a의 아이디: " + a.getId());
        System.out.println("b의 아이디: " + b.getId());

        System.out.println("부여한 아이디의 개수: " + Id.getCounter());
    }
}

class Id {
    private static int counter = 0;
    private int id;

    public Id() {
        id = ++counter;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }
}
