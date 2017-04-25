package com.tencent.lucas.demo.spring;

/**
 * Created by lucasfu on 2017/1/22.
 */
public class Outter {

    private int id;

     public class Inner{

        public void run(){
            //int next = id+1;
        }
        public void execute(){

        }
    }

    public static void main(String[] args) {

    }
}

class Demo{
    public static void main(String[] args) {
        Outter outter  = new Outter();
        Outter.Inner inner = outter.new Inner();
        inner.execute();
    }
}
