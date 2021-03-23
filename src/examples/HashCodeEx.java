package examples;

public class HashCodeEx {
    int a;
    int b;

    public HashCodeEx(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCodeEx that = (HashCodeEx) o;
        return a == that.a && b == that.b;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(a);
        System.out.println("Integer.hashCode(a) = " + result);
        result = 31 * result + Integer.hashCode(b);
        System.out.println("Integer.hashCode(b) = " + Integer.hashCode(b));
        return result;
    }

    public static void main(String[] args) {
        Object object = new Object();
        String str1 = "Hello";
        String str2 = "World";
        HashCodeEx hashCodeEx1 = new HashCodeEx(69273666,2);
        HashCodeEx hashCodeEx2 = new HashCodeEx(1,3);

        System.out.println(object.hashCode());
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(hashCodeEx1.hashCode());
        System.out.println(hashCodeEx2.hashCode());
    }
}