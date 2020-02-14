package kz.bitlab.group22.beans;

public class MyNewBeanImplNew implements MyNewBean{

    @Override
    public String getUserData() {
        return "This is new Bean";
    }

    @Override
    public void printUserData() {
        System.out.println(getUserData());
    }
}
