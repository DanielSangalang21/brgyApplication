public class Child extends Parent {

    private String childOnly;

    public String getChildOnly() {
        return childOnly;
    }

    public void setChildOnly(String childOnly) {
        this.childOnly = childOnly;
    }

    public static void main(String [] args){

        System.out.println("Testing...");
        Child c1 = new Child();
        c1.setChildOnly("childOnly");
        c1.setNotReallyHidden("notReallyHidden");
c1.getNotReallyHidden();
        //Attempting to access parent's reallyHidden
          //  c1.reallyHidden;//Does not even compile

    }//main

}//Child