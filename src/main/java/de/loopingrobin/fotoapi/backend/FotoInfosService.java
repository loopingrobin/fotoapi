package de.loopingrobin.fotoapi.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.service.annotation.GetExchange;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Greift auf die Fotodaten zu, die über die Foto-API von Soerensen
 * bereit gestellt wird.
 * Aus den Daten werden die ID und URL in ein Objekt der Klasse
 * "FotoInfo" übertragen und über die URL die SizeInBytes des Bildes
 * ermittelt.
 * Anschließend wird die Liste aller Foto-Infos zurückgegeben.
 */
@Service
public class FotoInfosService {

// --------------------------------------------------------
// Attribute
// --------------------------------------------------------

    /** Enthält das Repository, mit den Foto-Infos. */
    private final FotoInfosRepository repository;

    /**
     * Enthält den ImageSizeChecker mit dem die Größe der Bilder
     * ermittelt werden.
     */
    private final ImageSizeChecker imageSizeChecker;


// --------------------------------------------------------
// Konstruktoren
// --------------------------------------------------------

    /**
     * Erzeugt den Service mit den Referenzen zum Repository und
     * zum ImageSizeChecker.
     * @param repository das Repository mit den Foto-Infos
     * @param imageSizeChecker der Größenermittler für die Bilder
     */
    @Autowired
    public FotoInfosService(FotoInfosRepository repository, ImageSizeChecker imageSizeChecker) {
        this.repository = repository;
        this.imageSizeChecker = imageSizeChecker;
    }


// --------------------------------------------------------
// Methoden
// --------------------------------------------------------

    /**
     * Der GET-Request, der aus der Foto-API von Soerensen die
     * Backend-Daten ausliest und ins Respository schreibt.
     * @return
     */
    @GetExchange("/fotos")
    public List<FotoInfoAusgangsModel> findAllFotoInfos(){
        List<FotoInfoAusgangsModel> rueckgabe = new ArrayList<>();

        for (FotoApiEingangsModel fotoInfo : repository.findAll()) {
            FotoInfoAusgangsModel foto = new FotoInfoAusgangsModel();
            foto.setId(fotoInfo.id());
            foto.setUrl(fotoInfo.url());
            foto.setSizeInBytes(imageSizeChecker.getImageSize(fotoInfo.url()));
            rueckgabe.add(foto);
        }

        return rueckgabe;
    }
}
