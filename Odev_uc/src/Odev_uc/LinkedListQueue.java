/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Odev_uc;

/**
 *
 * @author Moaaz Gabllah
 */
public class LinkedListQueue<T> {

    private Node<T> header;

    public Node<T> getHeader() {
        return header;
    }
    private int size = 0;

    public int getSize() {
        return size;
    }

    void enqueue(T data) {   //addLast
        Node<T> newNode = new Node(data);
        if (header == null) {
            header = newNode;
        } else {
            Node<T> temp = header;
            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = newNode;
        }
        size++;
    }

    T dequeue() {        //removeFirst
        if (header == null) {
            System.out.println("Queue is empty !");
            return null;
        } else {
            Node<T> temp = header;
            header = header.nextNode;
            temp.nextNode = null;
            size--;
            return temp.data;
        }
    }

    // to print kullancilar
    void printList() {
        if (header == null) {
            System.out.println("Queue is empty !");
        } else {
            Node<T> temp = header;
            while (temp != null) {
                System.out.print("c" + ((Kullanici) (temp.data)).getKullanici_id() + "===> ");
                ((Kullanici) (temp.data)).izledigi_filmler.printFilmList();
                temp = temp.nextNode;
                System.out.println("");
            }
            System.out.println("Null");
        }
    }

    // to print bir kullancinin izledigi filmler
    void printFilmList() {
        if (header == null) {
            System.out.println("Queue is empty !");
        } else {
            Node<T> temp = header;
            while (temp != null) {
                System.out.print("m" + ((Film) (temp.data)).getFilm_id() + "===> ");
                temp = temp.nextNode;
            }
            System.out.print("Null");
        }
    }

    // to print film id and name
    void printFilmlerList() {
        if (header == null) {
            System.out.println("Queue is empty !");
        } else {
            Node<T> temp = header;
            while (temp != null) {
                //System.out.println("m" + ((Film) (temp.data)).getFilm_id() + "===> " + ((Film) (temp.data)).film_name);
                System.out.print(((Kullanici)temp.data).secilenKullanicilaOrtakFilmSayisi+" ===> ");
                temp = temp.nextNode;
            }
            System.out.println("Null");
        }
    }

    /*
     // to peek the first element
     Kullanici peek(){
     if (header == null) {
     System.out.println("Queue is empty !");
     throw new MyException("Hata linkedList peekte !!");
     }else{
     Node<T> temp=new Node<T>();
     }
     }*/
    
    
    
    void siraliEkle(Kullanici user) {
        Node newUser = new Node(user);
        if (header == null) {
            header = newUser;
        } else {
            Node<T> temp = header;
            if(temp.nextNode==null){
                if(((Kullanici) temp.data).secilenKullanicilaOrtakFilmSayisi > user.secilenKullanicilaOrtakFilmSayisi || ((Kullanici) temp.data).secilenKullanicilaOrtakFilmSayisi == user.secilenKullanicilaOrtakFilmSayisi) {
                    temp.nextNode = newUser;
                } else{
                    newUser.nextNode=temp;
                    temp=newUser;
                }
                return;
            }
            Node<T> te = temp;
            while (temp != null) {
                if (((Kullanici) temp.data).secilenKullanicilaOrtakFilmSayisi > user.secilenKullanicilaOrtakFilmSayisi || ((Kullanici) temp.data).secilenKullanicilaOrtakFilmSayisi == user.secilenKullanicilaOrtakFilmSayisi) {
                    te=temp;
                    temp = temp.nextNode;
                } else {
                    // once eklemeli
                    if(((Kullanici) te.data).secilenKullanicilaOrtakFilmSayisi< user.secilenKullanicilaOrtakFilmSayisi){
                        newUser.nextNode=te;
                        header=newUser;
                        return;
                    }
                    te.nextNode=newUser;
                    newUser.nextNode=temp;
                    return;
                }
            }
            te.nextNode = newUser;
        }
    }
}
