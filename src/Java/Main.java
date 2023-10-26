package Java;

abstract class Parent {
    public void hello(String name) {
        System.out.println("안녕하세요, 저는 " + name + "입니다.");
    }

    public abstract void hello();
}

class Child extends Parent{
    @Override
    public void hello() {
        System.out.println("안녕!");
    }
}

public class Main {
    public static void main(String[] args) {

        Child c = new Child();

        c.hello();
        c.hello("망고");
    }
}
