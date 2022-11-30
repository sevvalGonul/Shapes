
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Deneme {
    
    // Dizide baştan veya sondan istenen sıradaki Silindir nesnesinin indexini bulmayı sağlayan bir method
    // Ör: Dizideki ilk Silindir nesnesi, sondan ikinci Silindir nesnesi gibi...
    public static int silindir_bul(boolean bastan_mi, int sira, GeometrikNesne[] geometrik_nesneler, int sayac) {
        int aranan = 0;
        if (bastan_mi) {  // Baştan arama yapılıyorsa:
            for (int i = 0; i < sayac; i++) {
                if (geometrik_nesneler[i] instanceof Silindir) {
                    aranan += 1;  // Her silindir nesnesine denk geldiğinde arananı 1 arttır.
                    if(aranan == sira) {  // Aranan istenilen sıradaki silindir nesnesine eşitse:
                        return i;  // İstenen sıradaki Silindir nesnesinin dizideki indexini döndür.
                    }
                }
            }
        }
        else {  // Sondan arama yapılıyorsa:
            for (int i = sayac - 1; i >= 0; i--) {
                if (geometrik_nesneler[i] instanceof Silindir) {  // Bu bir Silindir nesnesi ise:
                    aranan += 1;  // aranan değişkenini 1 arttır.
                    if(aranan == sira) {  // Sondan istenilen sıradaki Silindir nesnesine geldiğinde:
                        return i;  // O Silindir nesnesinin dizideki indexini döndür.
                    }
                }
            }
        }
        System.out.println("Aradığınız nesne bulunamadı!");
        System.exit(0);
        return 0;
    }
    
    // Dizide baştan veya sondan istenen sıradaki Daire nesnesinin indexini bulmayı sağlayan bir method
    public static int daire_bul(boolean bastan_mi, int sira, GeometrikNesne[] geometrik_nesneler, int sayac) {
        int aranan = 0;
        if (bastan_mi) {
            for (int i = 0; i < sayac; i++) {
                if (geometrik_nesneler[i] instanceof Daire) {
                    aranan += 1;
                    if(aranan == sira) {
                        return i;
                    }
                }
            }
        }
        else {  // Sondan arama yapılıyorsa:
            for (int i = sayac - 1; i >= 0; i--) {
                if (geometrik_nesneler[i] instanceof Daire) {
                    aranan += 1;
                    if(aranan == sira) {
                        return i;
                    }
                }
            }
        }
        System.out.println("Aradığınız nesne bulunamadı!");
        System.exit(0);
        return 0;
    }
    
    // Dizide baştan veya sondan istenen sıradaki Dikdortgen nesnesinin indexini bulmayı sağlayan bir method
    public static int dikdortgen_bul(boolean bastan_mi, int sira, GeometrikNesne[] geometrik_nesneler, int sayac) {
        int aranan = 0;
        if (bastan_mi) {
            for (int i = 0; i < sayac; i++) {
                if (geometrik_nesneler[i] instanceof Dikdortgen) {
                    aranan += 1;
                    if(aranan == sira) {
                        return i;
                    }
                }
            }
        }
        else {  // Sondan arama yapılıyorsa:
            for (int i = sayac - 1; i >= 0; i--) {
                if (geometrik_nesneler[i] instanceof Dikdortgen) {
                    aranan += 1;
                    if(aranan == sira) {
                        return i;
                    }
                }
            }
        }
        System.out.println("Aradığınız nesne bulunamadı!");
        System.exit(0);
        return 0;
    }
    
    public static void polymorphicYazdir(GeometrikNesne nesne) {
        System.out.println(nesne);  // toString methodları otomatik olarak çağrılır.
        System.out.println("Alan: " + nesne.alanHesapla());
        System.out.println("Çevre: " + nesne.cevreHesapla());
        if (nesne instanceof Silindir) {  // Bu bir Silindir nesnesi ise:
            System.out.println("Hacim: " + ((Silindir)nesne).hacimHesapla());  // Hacim bilgilerini de yazdır.
        }
    }
    
    public static void karsilastir(GeometrikNesne nesne1, GeometrikNesne nesne2) {
        int deger = nesne1.compareTo(nesne2);
        switch (deger) {
            case 1:
                System.out.println(nesne1.getEtiket() + " etiketli nesne " + nesne2.getEtiket() + " etiketli nesneden büyük.");
                break;
            case -1:
                System.out.println(nesne1.getEtiket() + " etiketli nesne " + nesne2.getEtiket() + " etiketli nesneden küçük.");
                break;
            default:  // deger 0 ise:
                System.out.println(nesne1.getEtiket() + " etiketli nesne ile " + nesne2.getEtiket() + " etiketli nesnenin büyüklükleri eşit.");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner fileIn = null;

        try {  // Dosyayı oluşabilecek hatalardan dolayı try-catch kullanarak açıyorum.
            fileIn = new Scanner(new FileInputStream("input.txt")).useLocale(Locale.US);  // Double değerleri nokta ile okuyabilmesi için Locale kullanıyorum.
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı!");
            System.exit(0);
        }

        GeometrikNesne[] geometrik_nesneler = new GeometrikNesne[50];  // GeometrikNesne tipinde 50'lik bir dizi açıyorum.
        int sayac = 0;  // Dizinin kaç elemanının kullanıldığını gösterecek bir değişken, numberUsed

        String etiket;
        double yaricap;
        double en;
        double boy;
        double uzunluk;
        int month;
        int day;
        int year;

        while (fileIn.hasNext()) {  // Dosyayı satır satır okuyorum.
            
            String nesne_turu = fileIn.next();
            etiket = fileIn.next();
            
            if (nesne_turu.equals("daire")) {
                yaricap = fileIn.nextDouble();
                fileIn.next();  // date yazısı için
                month = fileIn.nextInt();
                day = fileIn.nextInt();
                year = fileIn.nextInt();
                geometrik_nesneler[sayac] = new Daire(etiket, new Date(month, day, year), yaricap);

            }
            else if (nesne_turu.equals("dikdortgen")) {
                en = fileIn.nextDouble();
                boy = fileIn.nextDouble();
                fileIn.next();  // date yazısı için
                month = fileIn.nextInt();
                day = fileIn.nextInt();
                year = fileIn.nextInt();
                geometrik_nesneler[sayac] = new Dikdortgen(etiket, new Date(month, day, year), en, boy);
            }
            else if (nesne_turu.equals("silindir")) {                
                yaricap = fileIn.nextDouble();
                uzunluk = fileIn.nextDouble();
                fileIn.next();  // Date yazısı için
                month = fileIn.nextInt();
                day = fileIn.nextInt();
                year = fileIn.nextInt();
                geometrik_nesneler[sayac] = new Silindir(etiket, new Date(month,day,year), yaricap, uzunluk);
            }
            
            sayac++;
        }
        
        fileIn.close();  // Dosyayı kapatıyorum.
        
        // Copy constructor'ları kullanarak belirtilen nesnelerin kopyasını çıkarıyorum:
        int index = daire_bul(false, 1, geometrik_nesneler, sayac);  // Son oluşturulan Daire nesnesinin indexi
        Daire copy_daire = new Daire((Daire)geometrik_nesneler[index]);
        
        index = dikdortgen_bul(false, 1, geometrik_nesneler, sayac);  // Son oluşturulan Dikdortgen nesnesinin indexi
        Dikdortgen copy_dikdortgen = new Dikdortgen((Dikdortgen)geometrik_nesneler[index]);
        
        index = silindir_bul(false, 1, geometrik_nesneler, sayac);  // Son oluşturulan Silindir nesnesinin indexi
        Silindir copy_silindir = new Silindir((Silindir)geometrik_nesneler[index]);
        
        
        
        // Bu nesneleri de diziye ekliyorum:
        geometrik_nesneler[sayac++] = copy_daire;
        geometrik_nesneler[sayac++] = copy_dikdortgen;
        geometrik_nesneler[sayac++] = copy_silindir;
        
        
        // Karşılaştırma Örnekleri:
        int i1 = daire_bul(true, 1, geometrik_nesneler, sayac);  // İlk daire nesnesinin indexi
        int i2 = daire_bul(false, 1, geometrik_nesneler, sayac);  // Son daire nesnesinin indexi
        karsilastir(geometrik_nesneler[i1], geometrik_nesneler[i2]);  // İlk ve son daire nesnelerinin karşılaştırılmaları
        
        i1 = daire_bul(false, 2, geometrik_nesneler, sayac);  // Sondan bir önceki daire nesnesinin indexi
        karsilastir(geometrik_nesneler[i1], geometrik_nesneler[i2]);  // Son daire ve ondan bir önceki dairenin karşılaştırılması
        
        i1 = dikdortgen_bul(true, 1, geometrik_nesneler, sayac);  // İlk Dikdortgen nesnesinin indexi
        i2 = dikdortgen_bul(false, 1, geometrik_nesneler, sayac);  // Son Dikdortgen nesnesinin indexi
        karsilastir(geometrik_nesneler[i1], geometrik_nesneler[i2]);  // İlk ve Son Dikdortgen nesnelerinin karşılaştırılmaları
        
        i1 = dikdortgen_bul(false, 2, geometrik_nesneler, sayac);  // Sondan bir önceki Dikdortgen nesnesinin indexi
        karsilastir(geometrik_nesneler[i1], geometrik_nesneler[i2]);  // Sondan bir önceki ve son Dikdortgen nesnelerinin karşılaştırılması
        
        i1 = silindir_bul(true, 1, geometrik_nesneler, sayac);  // İlk silindir nesnesinin indexi
        i2 = silindir_bul(false, 1, geometrik_nesneler, sayac);  // Son silindir nesnesinin indexi
        karsilastir(geometrik_nesneler[i1], geometrik_nesneler[i2]);  // İlk ve son Silindir nesnelerinin karşılaştırılması
        
        i1 = silindir_bul(false, 2, geometrik_nesneler, sayac);  // Sondan bir önceki silindir nesnesinin indexi
        karsilastir(geometrik_nesneler[i1], geometrik_nesneler[i2]);  // Son silindir ve ondan bir önceki Silindir nesnelerinin karşılaştırılması
        
        
        // İstenen istatistiklerin hesaplanması:
        double cevre_toplami = 0;
        double alan_toplami = 0;
        double hacim_toplami = 0;
        int silindir_say = 0;
        // İlk geometrik nesnenin alan ve çevre değerlerini min ve max kabul edip döngü içinde güncelleyeceğim:
        double min_cevre = geometrik_nesneler[0].cevreHesapla();
        double max_cevre = geometrik_nesneler[0].cevreHesapla();
        double min_alan = geometrik_nesneler[0].alanHesapla();
        double max_alan = geometrik_nesneler[0].alanHesapla();
        // Hacim değerleri silindirler için hesaplanacağından min ve max hacim değerlerinin atamasını şimdilik 0 yapıyorum.
        // Döngü içerisinde ilk gelen silindirin hacim değerlerini min ve max kabul edip gerektiğinde güncelleyeceğim.
        double min_hacim = 0;
        double max_hacim = 0;
        
        for (int i = 0; i < sayac; i++) {
            GeometrikNesne nesne = geometrik_nesneler[i];
            double cevre = nesne.cevreHesapla();
            double alan = nesne.alanHesapla();
            
            cevre_toplami += cevre;
            alan_toplami += alan;
            
            if (cevre > max_cevre) {
                max_cevre = cevre;
            }
            else if (cevre < min_cevre) {
                min_cevre = cevre;
            }
            
            if (alan > max_alan) {
                max_alan = alan;
            }
            else if (alan < min_alan) {
                min_alan = alan;
            }
            
            if (nesne instanceof Silindir) {  // Bu bir silindir nesnesi ise:
                double hacim = ((Silindir)nesne).hacimHesapla();  // Hacim hesaplıyorum.
                hacim_toplami += hacim;  // O anki nesnenin hacmini hacim_toplami değikenine ekliyorum.
                if (silindir_say == 0) {  // Bu gelen ilk silindir nesnesi ise:
                    max_hacim = hacim;  // Hacim değerini min ve max kabul ediyorum.
                    min_hacim = hacim;
                }
                
                if (hacim > max_hacim) {  // Hacim değerlerini gerektiğinde güncelliyorum.
                    max_hacim = hacim;
                }
                else if (hacim < min_hacim) {
                    min_hacim = hacim;
                }
                silindir_say++;
            }
        }
        
        // Ortalama değerlerini hesaplama:
        double cevre_ort = cevre_toplami / sayac;  // Tüm geometrik nesneler için.
        double alan_ort = alan_toplami / sayac;  // Tüm geometrik nesneler için.
        double hacim_ort = hacim_toplami / silindir_say;  // Sadece silindirler için.
        
        
        // İstenen verileri istatistikler adlı tek boyutlu diziye aktarıyorum.
        double[] istatistikler = {cevre_ort, alan_ort, hacim_ort, min_cevre, max_cevre,
                                  min_alan, max_alan, min_hacim, max_hacim};
     
        // İstatistikler adlı tek boyutlu diziyi ondalık basamak sayısı 3 olacak şekilde ekrana yazdırıyorum:
        for (double element: istatistikler) {
            System.out.printf("%.3f%n", element);
        }
        

    }
}
