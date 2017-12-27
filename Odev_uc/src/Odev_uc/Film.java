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
public class Film {
    private final int film_id;
    String film_name;

    public int getFilm_id() {
        return film_id;
    }

    public Film(int film_id, String film_name) {
        this.film_id = film_id;
        this.film_name = film_name;
    }

    public Film(int film_id) {
        this.film_id = film_id;
    }
    
}
