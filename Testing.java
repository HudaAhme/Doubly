/**
 * Created by DELL on 12/02/2023.
 */
public class Testing {
    public static void main(String[] args) {

       DoublyLinkedList<String>list=new DoublyLinkedList<>();
        list.addfirst("first ");
        list.addfirst("second");
        list.addfirst("third");

        list.rotae(7);
        int n=list.size();
        System.out.println("element of DoublylinkedList");

        for (int i = 0; i <n ; i++) {

            System.out.println(list.removelast());
            System.out.println(list.equals("first"));
        }


    }


}
