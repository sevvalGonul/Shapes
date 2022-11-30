
public class Dikdortgen extends GeometrikNesne {

    private double en;
    private double boy;

    public Dikdortgen() {  // Parametresiz Constructor
        super();
        en = 1.0;
        boy = 1.0;
    }

    public Dikdortgen(String etiket, Date tarih, double en, double boy) {  // Tüm verileri alan constructor
        super(etiket, tarih);
        setEn(en);
        setBoy(boy);
    }

    public Dikdortgen(Dikdortgen otherDikdortgen) {  // Copy Constructor
        super(otherDikdortgen);
        en = otherDikdortgen.en;
        boy = otherDikdortgen.boy;
    }

    public double getEn() {
        return en;
    }

    public void setEn(double en) {
        if (en < 0) {
            System.out.println("Hata: En negatif olamaz!");
            System.exit(0);
        }
        this.en = en;
    }

    public double getBoy() {
        return boy;
    }

    public void setBoy(double boy) {
        if (boy < 0) {
            System.out.println("Hata: Boy negatif olamaz!");
            System.exit(0);
        }
        this.boy = boy;
    }

    public String toString() {
        return (super.toString() + ", En: " + en + ", Boy: " + boy);
    }

    // Üst sınıftaki soyut metotların gerçekleştirimleri:
    @Override
    public double alanHesapla() {
        return (en * boy);
    }

    @Override
    public double cevreHesapla() {
        return 2 * (en + boy);
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
            Dikdortgen parametre_dikdortgen = (Dikdortgen) o;  // Down Casting
            if (alanHesapla() > parametre_dikdortgen.alanHesapla()) {
                return 1;
            } else if (alanHesapla() < parametre_dikdortgen.alanHesapla()) {
                return -1;
            } else {
                return 0;
            }
        }

    }

}