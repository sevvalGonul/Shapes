
public abstract class GeometrikNesne implements Comparable<Object>{
    private String etiket;
    private Date tarih;
    
    public GeometrikNesne() {  // Parametresiz constructor
        etiket = "No-name";
        tarih = new Date();
    }
    
    public GeometrikNesne(String etiket, Date yeni_tarih) {  // İki parametreli constructor
        setEtiket(etiket);
        setTarih(yeni_tarih);
    }
    
    public GeometrikNesne(GeometrikNesne otherObject) {  // Copy constructor
        etiket = otherObject.etiket;
        tarih = new Date(otherObject.tarih);
    }

    public String getEtiket() {
        return etiket;
    }

    public void setEtiket(String etiket) {
        if (etiket == null) {
            System.out.println("Hata: Boş etiket atanamaz.");
            System.exit(0);
        }
        this.etiket = etiket;
    }

    public Date getTarih() {
        return new Date(tarih);
    }

    public void setTarih(Date tarih) {
        if (tarih == null) {
            System.out.println("Hata: Boş tarih atanamaz.");
            System.exit(0);
        }
            
        this.tarih = new Date(tarih);
    }
    
    public String toString() {
        return ("Etiket: " + etiket + ", Date: " + tarih.toString());
    }
    
    // Abstract Methodlar:
    public abstract double alanHesapla();
    public abstract double cevreHesapla();
    public abstract int compareTo(Object o);
    
}
