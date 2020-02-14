package kz.bitlab.group22.beans;

public class MyNewBeanImpl implements MyNewBean {
    @Override
    public String getUserData() {
        return "Hello BITLAB";
    }

    @Override
    public void printUserData() {
        System.out.println(getUserData());
    }
}
