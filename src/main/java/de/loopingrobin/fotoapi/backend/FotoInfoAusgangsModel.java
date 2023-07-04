package de.loopingrobin.fotoapi.backend;

/**
 * Das Model für die Foto-Infos, die über die erstellte API-Schnittstelle
 * zur verfügung gestellt werden.
 */
public class FotoInfoAusgangsModel {

// --------------------------------------------------------
// Attribute
// --------------------------------------------------------

    /** Enthält die ID des Fotos. */
    private Long id;

    /** Enthält die URL des Fotos. */
    private String url;

    /** Enthält die Größe des Fotos in Bytes. */
    private Long sizeInBytes;


// --------------------------------------------------------
// Konstruktoren
// --------------------------------------------------------

    /** Erstellt das Foto-Info-Ausgangsmodel ohne Parameter. */
    public FotoInfoAusgangsModel() {
    }

    /**
     * Erstellt das Foto-Info-Ausgangsmodel mit URL und Größe in Bytes.
     * @param url die URL des Fotos
     * @param sizeInBytes die Größe des Fotos in Bytes
     */
    public FotoInfoAusgangsModel(String url, Long sizeInBytes) {
        this.url = url;
        this.sizeInBytes = sizeInBytes;
    }

    /**
     * Erstellt die Foto-Info-Ausgangsmodel mit ID, URL und Größe in Bytes.
     * @param id die Foto-ID
     * @param url die URL des Fotos
     * @param sizeInBytes die Größe des Fotos in Bytes
     */
    public FotoInfoAusgangsModel(Long id, String url, Long sizeInBytes) {
        this.id = id;
        this.url = url;
        this.sizeInBytes = sizeInBytes;
    }


// --------------------------------------------------------
// Methoden
// --------------------------------------------------------

    /**
     * Gibt die Foto-ID zurück.
     * @return die Foto-ID
     */
    public Long getId() {
        return id;
    }

    /**
     * Setzt die ID des Fotos, wenn noch keins besteht.
     * @param id die zu ersetztende Foto-ID
     */
    public void setId(Long id) {
        if (this.id == null) {
            this.id = id;
        }
    }

    /**
     * Gibt die URL des Fotos zurück.
     * @return die URL des Fotos
     */
    public String getUrl() {
        return url;
    }

    /**
     * Ersetzt die URL des Fotos.
     * @param url die zu ersetztende URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gibt die Größe des Fotos in Bytes zurück.
     * @return die Größe in Bytes
     */
    public Long getSizeInBytes() {
        return sizeInBytes;
    }

    /**
     * Setzt die Größe des Fotos in Bytes.
     * @param sizeInBytes die Größe in Bytes
     */
    public void setSizeInBytes(Long sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    /**
     * Repräsentiert das Objekt bei der Ausgabe.
     * @return das Objekt mit seinen Parametern
     */
    @Override
    public String toString() {
        return "FotoInfo{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", sizeInBytes=" + sizeInBytes +
                '}';
    }
}
