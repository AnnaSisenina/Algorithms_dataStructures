
public class MyLinkedList {

    /**
     * Реализовать следующие методы
     * 1. public int size() - получить размер списка
     * 2. public boolean contains(int value) - проверить наличие элемента в списке
     * 3.* public MyLinkedList reversed() - создать НОВЫЙ список с обратным порядком
     * 4.** Заменить все int значения на дженерик T
     * 5.* Любые другие доработки, которые захотите для тренировки
     */

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node last = findLast();
            last.next = new Node(value);
        }
    }
    
    private Node findLast() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public int getFirst() {
        return get(0);
    }

    public int get(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException(index);
        }

        Node current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        if (currentIndex == index && current != null) {
            return current.value;
        }
        throw new IndexOutOfBoundsException(index);
    }

    public int popFirst() {
        return pop(0);
    }

    public int pop(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index == 0) {
            int pop = head.value;
            head = head.next;
            return pop;
        }

        Node previous = head; // предыдущая от искомой
        int currentIndex = 1;
        while (previous.next != null) {
            if (currentIndex == index) {
                int pop = previous.next.value;
                previous.next = previous.next.next;
                return pop;
            }

            previous = previous.next;
            currentIndex++;
        }
        throw new IndexOutOfBoundsException(index);
    }

    // public int size() - получить размер списка
    
    public int size() {
        int size = 0;
        if (head == null) return size;
        
        else {
            Node current = head;
            while (current != null) {
                current = current.next;
                size++;
            }

        }
        return size;
    }
    //  public boolean contains(int value) - проверить наличие элемента в списке
    public boolean contains(int value) {
        if (head == null) return false;
        else {
            Node current = head;
            while (current != null) {
                if (current.value == value) return true;
                current=current.next;
            }
            return false;
        }
        
    }
    // public MyLinkedList reversed() - создать НОВЫЙ список с обратным порядком
    public MyLinkedList reversed(MyLinkedList list){
        MyLinkedList reversedList = new MyLinkedList();
        reversedList=reversedList.copy(list);
        reversedList.reverseThisList();
        return reversedList;
    }
    
    public void reverseThisList () {
        if (head.next != null){
        Node current = head.next;
        head.next = null;
        while (current != null) {
            Node next= current.next;
            current.next = head;
            head = current;
            current = next;
        }
    }
     }

     public MyLinkedList copy (MyLinkedList list){
        MyLinkedList copyList = new MyLinkedList();
        Node current = list.head;
        
        while (current != null){
                 copyList.add (current.value);
                 current = current.next;
             }
        return copyList;
     }

     



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            result.append(current.value).append(" -> ");
            current = current.next;
        }

        int length = result.length();
        if (length > 4) {
            result.delete(length - 4, length);
        }

        result.append("]");
        return result.toString();
    }
}
