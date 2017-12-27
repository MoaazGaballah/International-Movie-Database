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
public class Kullanici {
    private final int kullanici_id;
    LinkedListQueue <Film>izledigi_filmler;
    int secilenKullanicilaOrtakFilmSayisi;

    public int getKullanici_id() {
        return kullanici_id;
    }

    public Kullanici(int kullanici_id) {
        this.kullanici_id = kullanici_id;
        this.izledigi_filmler=new LinkedListQueue<Film>();
    }

    public LinkedListQueue<Film> getIzledigi_filmler() {
        return izledigi_filmler;
    }
    
    
}
