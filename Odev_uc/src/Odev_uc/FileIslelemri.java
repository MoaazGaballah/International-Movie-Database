/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Odev_uc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Moaaz Gabllah
 */
public class FileIslelemri {

    public static LinkedListQueue<Kullanici> kullanicilar = new LinkedListQueue<Kullanici>();
    public static LinkedListQueue<Film> Filmler = new LinkedListQueue<Film>();
    
    // 2 file okuyup yukaridaki listeleri atar datayi
    public void fileislemi() throws IOException{
        // this is to read Filmlerin id leri ve isimleri
        FileReader f2 = null;
        BufferedReader br2 = null;
        try{
            f2 = new FileReader("movie_idmap.txt");
            br2 = new BufferedReader(f2);
            String satir;
            char[] chars;
            // sayac for the number of digit for id
            int sayac = 1, filmRakam = 0, Ftemp = -1;
            while ((satir = br2.readLine()) != null) {
                chars = satir.toCharArray();
                // film id icin
                for (int i = 1; i < 4; i++) {
                    if (chars[i] > 47 && chars[i] < 58) {
                        int a = Integer.parseInt(String.valueOf(chars[i]));
                        filmRakam = filmRakam * 10 + a;
                        sayac++;
                    } else {
                        break;
                    }
                }
                // film isimi icin
                String filmIsimi=satir.substring(sayac+1);
                Film film = new Film(filmRakam,filmIsimi);
                //film.film_name=filmIsimi;
                Filmler.enqueue(film);
                // to be ready for next film id
                filmRakam=0;
                // to be ready for next film name
                sayac=1;
            }
            //Filmler.printFilmlerList();
            /*
            Node <Kullanici>kul=kullanicilar.getHeader();
            while(kul.data.getKullanici_id()!=6){
                kul=kul.nextNode;
                continue;
            }
            System.out.println(kul.data.izledigi_filmler.getHeader().data.getFilm_id());*/
        }catch (Exception e) {
            Logger.getLogger(FileIslelemri.class.getName()).log(Level.SEVERE, null, e);
            throw new MyException("film File islemlerinde sıkısntı vardır !!");
        } finally {
            if (f2 != null) {
                f2.close();
                br2.close();
            }
        }
        
        // this is to read cullanicilarin izledigi filimleri
        FileReader f = null;
        BufferedReader br = null;
        try {
            f = new FileReader("client-preference.txt");
            br = new BufferedReader(f);
            String satir;
            char[] chars;
            // Ktemp =-1 to get the first user
            int kullaniciRakam = 0, Ktemp = -1, filmRakam = 0, Ftemp = -1;
            // yeni user yapmadan eski user e film eklemek icin
            Kullanici tempUser = new Kullanici(kullaniciRakam);
            while ((satir = br.readLine()) != null) {
                chars = satir.toCharArray();
                // kullanici id icin
                for (int i = 1; i < 3; i++) {
                    if (chars[i] > 47 && chars[i] < 58) {
                        int a = Integer.parseInt(String.valueOf(chars[i]));
                        kullaniciRakam = kullaniciRakam * 10 + a;
                    } else {
                        break;
                    }
                }
                // film id icin
                // m oldugu icin 4 ten basliyor
                for (int i = 4; i < satir.length(); i++) {
                    if (chars[i] > 47 && chars[i] < 58) {
                        int a = Integer.parseInt(String.valueOf(chars[i]));
                        filmRakam = filmRakam * 10 + a;
                    }
                }
                // gecmis bir kullanici liste bir daha eklememek icin
                if (Ktemp != kullaniciRakam) {
                    Kullanici user = new Kullanici(kullaniciRakam);
                    //
                    Film film = getFilmById(filmRakam);
                    user.izledigi_filmler.enqueue(film);
                    kullanicilar.enqueue(user);
                    tempUser = user;
                } else {
                    //
                    Film film = getFilmById(filmRakam);
                    tempUser.izledigi_filmler.enqueue(film);
                }
                Ktemp = kullaniciRakam;
                kullaniciRakam = 0; // be ready to next kullanici id
                filmRakam=0; // be ready to next film id
            }
            //kullanicilar.printList();
            f.close();
            br.close();
        } catch (Exception e) {
            Logger.getLogger(FileIslelemri.class.getName()).log(Level.SEVERE, null, e);
            throw new MyException("File islemlerinde sıkısntı vardır !!");
        } finally {
            if (f != null) {
                f.close();
                br.close();
            }
        }
        //System.out.println("client-preference.txt basarıyla okundu ");
        
    }
    Film getFilmById(int i){
        Node <Film> tempFilm =Filmler.getHeader();
        while(tempFilm!=null){
            if(tempFilm.data.getFilm_id()==i){
                return tempFilm.data;
            }
            tempFilm=tempFilm.nextNode;
        }
        throw new MyException("getFilmById metudunda bir hata vardir !!");
    }
}
