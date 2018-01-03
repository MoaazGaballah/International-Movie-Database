# International-Movie-Database


istenilen :-
“ International Movie Database “ sitesinde alınan veriler üzerinden bir kullanıcının başka kullanıcıya film önerisi vermesini gerçekleştirilmesi istenmektedir.
öğrendiklerim :-
* Kendi özel veri yapısı yine den yazmamı gerekti ( kuyruk veri yapısı ) 
* Gerçek manada hayatta kullandığımız veya kullanmak istediğimiz ne varsa programa dökebiliriz.
* File işlemleri yine den canlandı kafamda

Yaptığım :-
İlk başta 2 file okuyorum. Ve client-preference isimli file Kullanıcılar ve movie_idmap ise Filmler linkedliste atadım. Swing ten gelen user izlediği filmleri bulup birinci listeye ekliyorum. Ondan sonra kullanıcılar listesine tek tek gezip o kullanıcıyla ortak filmlerin sayısı bulup ikinci listeye atadım. En sonunda kuyruk yapısı ( yani sıralı ) kullandığım için direk ortak filim sayısına göre siraliListe isimli listeye ekliyorum. Böylece en başında node olan en büyük ortakFilmlerSayisi özelliğe sahip olur ve dışarıdan gelen user i izlemediği filmleri üçüncü listeye ekliyorum.

eksikler :-
eksik bıraktığım hiçbir yer yoktur.

zorlandığım kısımlar :-
zorlandığım kısımları da yok diyebilirm.
