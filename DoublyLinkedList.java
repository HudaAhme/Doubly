import org.omg.CORBA.Object;

import java.sql.Struct;


/**
 * Created by DELL on 26/01/2023.
 */
public class DoublyLinkedList <E>{

   private Node<E>hearder=null;
    private Node<E>tailer=null;
    private int size=0;

    public DoublyLinkedList(){
        hearder=new Node<E>(null,null,null);
        tailer=new Node<E>(null,hearder,null);
        hearder.setNext(tailer);
    }

    public  boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }

    public E first(){
        if (isEmpty())return null;
        return  hearder.getNext().getElement();
    }

   public void rotae(int n){
       Node current=hearder;
       if (n==0||n>=size){
           return;
   }
   else {
           for (int i = 0; i < n; i++) {
               current = current.next;
               tailer.next = hearder;
               hearder = current.next;
               hearder.prev = null;
               tailer.next = null;
           }
       }}

    public DoublyLinkedList<E>clone()throws CloneNotSupportedException {

        DoublyLinkedList<E> other = new DoublyLinkedList<E>();
        if (size > 0) {
            other.hearder = new Node<E>(null, null, null);
            other.tailer = new Node<E>(null, other.hearder, null);
            other.hearder.setNext(other.tailer);
            Node<E> walk = hearder.getNext();
            Node<E> otherwalk = other.hearder;
            for (int i = 0; i < size; i++) {
                Node<E> newest = new Node<E>(walk.getElement(), otherwalk, otherwalk.getNext());
                otherwalk.getNext().setPrev(newest);
                otherwalk.setNext(newest);
                otherwalk = otherwalk.getNext();
                walk = walk.getNext();
            }
        }
        return other;
    }




    public E last(){
        if (isEmpty())return null;
        return  tailer.getPrev().getElement();
    }

   public E remove (Node<E> x)
    {
        if (isEmpty())return null;
        Node<E> p=x.getPrev();
        Node<E> s=x.getNext();
        p.setNext(s);
        s.setPrev(p);
        size--;
        return x.getElement();
    }

   public E removefirst (){
        if (isEmpty())return null;
        return remove(hearder.getNext());
    }

   public E removelast(){
        if (isEmpty())return null;
        return remove(tailer.getPrev());


    }

      public boolean equals(Object that)
      {
          if (that==null)
              return false;
          if (!(that instanceof DoublyLinkedList))
              return false;

          DoublyLinkedList<E>other=(DoublyLinkedList<E>)that;
          if (hearder==null&&other.hearder!=null)
              return false;
          if (tailer==null&&other.tailer!=null)
              return false;
          while (hearder.getNext()!=tailer){
              if (!(hearder.equals(other.hearder))){
                  return false;
              }
              hearder=hearder.getNext();
              other.hearder=other.hearder.getNext();
          }
           return true;
      }

    private void addBetween(E element,Node<E>p,Node<E>n){
        Node<E>x=new Node<E>(element,p,n);
        p.next=x;
        n.prev=x;
        size++;
    }

    public void addfirst(E element )
    {
        addBetween(element,hearder,hearder.next);
    }
    public void addLast(E element )
    {
        addBetween(element,hearder,tailer.next);
    }



    private static class Node<E>{
     private    E element;
        private Node<E>next;
        private Node<E>prev;

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }



}
