/**
 * 单例模式
 */

//懒汉式
public class SingleTon {
    private volatile static SingleTon singleTon;

    private SingleTon() {

    }

    public SingleTon getSingleTon() {
        if (singleTon == null) {
            synchronized (SingleTon.class) {
                if (singleTon == null) {

                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}


//饿汉式
class SingleTon2 {

    private SingleTon2() {

    }

    private static class SingletonHoder {
        static SingleTon2 singleTon2 = new SingleTon2();

    }

    public static SingleTon2 getSingleton() {
        return SingletonHoder.singleTon2;
    }


}
