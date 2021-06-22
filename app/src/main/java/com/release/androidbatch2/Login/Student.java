package com.release.androidbatch2.Login;

class University {

    int rolno;
    protected void getRoll(){
        System.out.println("new Roll");
    }

}

class Division extends University{

   int div;

   protected void getDiv(){
       System.out.println("new DIv");
   }


}

class Student extends Division{

  int name;
  protected void getName(){
      System.out.println("new Name");
  }
}


interface StudentListner{
    public void onStudentAdd();
    public void onStudentRemove();

}



class main{
    public static void main(String args[]){
        StudentListner listner ;

        Division division = new Division();
        division.getDiv();
        division.getRoll();
        Student s = new Student();
        s.getRoll();
        s.getDiv();
        s.getName();




    }
}