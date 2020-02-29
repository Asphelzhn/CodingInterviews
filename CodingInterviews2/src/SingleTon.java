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
