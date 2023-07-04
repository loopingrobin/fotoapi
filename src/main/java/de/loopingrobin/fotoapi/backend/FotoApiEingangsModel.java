package de.loopingrobin.fotoapi.backend;

/**
 * Ein Objekt dieser Klasse ist für die Speicherung der Informationen
 * der Foto-API von Soerensen ausgelegt.
 * @param id die ID des Fotos
 * @param albumid die Album-ID des Fotos
 * @param title der Titel des Fotos
 * @param url die URL zum Foto
 * @param thumbnailUrl die URL zur Thumbnail-Variante des Fotos
 */
public record FotoApiEingangsModel(Long id, Integer albumid, String title, String url, String thumbnailUrl) {

    /**
     * Gibt die ID des Fotos zurück.
     * @return die Foto-ID
     */
    @Override
    public Long id() {
        return id;
    }

    /**
     * Gibt die Album-ID des Fotos zurück.
     * @return die Album-ID des Fotos
     */
    @Override
    public Integer albumid() {
        return albumid;
    }

    /**
     * Gibt den Titel des Fotos zurück.
     * @return der Titel des Fotos
     */
    @Override
    public String title() {
        return title;
    }

    /**
     * Gibt die URL des Fotos zurück
     * @return die URL des Fotos
     */
    @Override
    public String url() {
        return url;
    }

    /**
     * Gibt die URL der Thumbnail-Version des Fotos zurück
     * @return die URL der Thumbnail-Version des Fotos
     */
    @Override
    public String thumbnailUrl() {
        return thumbnailUrl;
    }
}
