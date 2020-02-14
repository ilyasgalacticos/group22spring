package kz.bitlab.group22.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class FirstBean implements FirstBeanInterface{

    private String someText;
    private int someInt;

    public FirstBean(){
        System.out.println("Initializing my First Bean");
        this.someInt = 77;
        this.someText = "Hello";
    }

    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }

    public int getSomeInt() {
        return someInt;
    }

    public void setSomeInt(int someInt) {
        this.someInt = someInt;
    }

    @Override
    public String getData(){
        return this.someText + " " + this.someInt;
    }

    @Override
    public void setData(String data) {
        this.someText = data;
    }
}