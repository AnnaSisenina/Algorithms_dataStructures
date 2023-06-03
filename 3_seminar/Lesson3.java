

public class Lesson3 {

    public static void main(String[] args) {

       
        MyLinkedList myLinkedList = new MyLinkedList();


        myLinkedList.add(1);
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);

        myLinkedList.add(5);
        System.out.println(myLinkedList);
        
        MyLinkedList copy = new MyLinkedList();
       
        System.out.println(copy.reversed(myLinkedList));
             
       


    }

}
