
public class Silindir extends GeometrikNesne {

    private double yaricap;
    private double uzunluk;

    public Silindir() {  // Parametresiz Constructor
        super();
        yaricap = 1.0;
        uzunluk = 1.0;
    }

    public Silindir(String etiket, Date tarih, double yaricap, double uzunluk) {  // Gerekli verileri alan constructor
        super(etiket, tarih);
        setYaricap(yaricap);
        setUzunluk(uzunluk);
    }

    public Silindir(Silindir otherSilindir) {  // Copy Constructor
        super(otherSilindir);
        yaricap = otherSilindir.yaricap;
        uzunluk = otherSilindir.uzunluk;
    }

    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        if (yaricap < 0) {
            System.out.println("Hata: Yarıçap negatif olamaz!");
            System.exit(0);
        }
        this.yaricap = yaricap;
    }

    public double getUzunluk() {
        return uzunluk;
    }

    public void setUzunluk(double uzunluk) {
        if (uzunluk < 0) {
            System.out.println("Hata: Uzunluk negatif olamaz!");
            System.exit(0);
        }
        this.uzunluk = uzunluk;
    }

    public String toString() {
        return (super.toString() + ", Yaricap: " + yaricap + ", Uzunluk: " + uzunluk);
    }

    public double hacimHesapla() {  // Bu sınıfa özel hacimHesapla methodu
        return (Math.PI * yaricap * yaricap * uzunluk);
    }

    // Üst sınıftaki soyut metotların gerçekleştirimleri:
    @Override
    public double alanHesapla() {
        return 2 * yaricap * Math.PI * (yaricap + uzunluk);
    }

    @Override
    public double cevreHesapla() {
        return ((2 * 2 * yaricap * Math.PI) + (2 * uzunluk));
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            System.out.println("Hata: Boş obje!");
            System.exit(0);
            return 0;  // Compile hatasını düzeltmek için

        } else if (getClass() != o.getClass()) {
            System.out.println("Hata: Karşılaştırılabilir objeler değil!");
            System.exit(0);
            return 0;  // Compile hatasını düzeltmek için
        } else {
            Silindir parametre_silindir = (Silindir) o;
            if (hacimHesapla() > parametre_silindir.hacimHesapla()) {
                return 1;
            } else if (hacimHesapla() < parametre_silindir.hacimHesapla()) {
                return -1;
            } else {
                return 0;
            }
        }

    }

}