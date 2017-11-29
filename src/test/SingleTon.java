package test;

public enum  SingleTon {
    INSTANCE;

    public static void main(String[] args) {
        float a = 0;
        System.out.println(a == 0);
    }

    public int add(int a, int b) {
        return a+b;
    }
}
