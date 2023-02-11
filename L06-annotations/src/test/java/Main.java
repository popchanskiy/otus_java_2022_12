import homework.*;

public class Main {
    public static void main(String[] args) {
        TestProcessor proccessor = new TestProcessor();
        try {
            proccessor.process(TestClass.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
