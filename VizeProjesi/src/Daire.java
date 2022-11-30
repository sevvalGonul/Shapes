
public class Daire extends GeometrikNesne {

    private double yaricap;

    public Daire() {  // Parametresiz constructor
        super();
        yaricap = 1.0;
    }

    public Daire(String etiket, Date tarih, double yaricap) {  // Tüm verileri alan constructor
        super(etiket, tarih);
        setYaricap(yaricap);

    }

    public Daire(Daire diger_daire) {  // Copy Constructor
        super(diger_daire);
        yaricap = diger_daire.yaricap;
    }

    public double getYaricap() {
        return yaricap;
    }

    public void setYaricap(double yaricap) {
        if (yaricap < 0) {
            System.out.println("Hata: Negatif yarıçap olamaz!");
            System.exit(0);
        }
        this.yaricap = yaricap;
    }

    public String toString() {
        return (super.toString() + ", Yarıçap: " + yaricap);
    }

    // Üst sınıftaki soyut metotların gerçekleştirimleri:
    @Override
    public double alanHesapla() {
        return (Math.PI * yaricap * yaricap);
    }

    @Override
    public double cevreHesapla() {
        return (2 * Math.PI * yaricap);
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
            Daire otherDaire = (Daire) o;  // Down Casting
            if (yaricap > otherDaire.yaricap) {
                return 1;
            } else if (yaricap < otherDaire.yaricap) {
                return -1;
            } else {
                return 0;
            }
        }

    }

}
