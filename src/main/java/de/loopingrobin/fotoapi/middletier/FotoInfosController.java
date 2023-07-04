package de.loopingrobin.fotoapi.middletier;

import de.loopingrobin.fotoapi.backend.FotoInfoAusgangsModel;
import de.loopingrobin.fotoapi.backend.FotoInfosService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Die Klasse erzeugt einen Controller, der die Methoden für die
 * API-Schnittstelle bereitstellt.
 * Die Daten werden unter http://localhost:8080/foto-api bereitgestellt.
 */
@RestController
@RequestMapping("/foto-api")
public class FotoInfosController {

// --------------------------------------------------------
// Attribute
// --------------------------------------------------------

    /** Enthält den Service für die Foto-API. */
    private final FotoInfosService service;

    /** Enthält die Liste aller Foto-Infos, die zur Verfügung stehen. */
    private List<FotoInfoAusgangsModel> alleFotoInfos;


// --------------------------------------------------------
// Konstruktoren
// --------------------------------------------------------

    /**
     * Erstellt den Controller mit der Referenz zum Service.
     * @param service der Service zur Foto-API
     */
    @Autowired
    public FotoInfosController(@NotNull FotoInfosService service) {
        this.service = service;
        alleFotoInfos = service.findAllFotoInfos();
    }


// --------------------------------------------------------
// Methoden
// --------------------------------------------------------

    /**
     * Gibt alle Foto-Infos beim GET-Request zurück.
     * @return die Liste aller Foto-Infos
     */
    @GetMapping
    public List<FotoInfoAusgangsModel> getFotoInfos() {

        return service.findAllFotoInfos();
    }

    /**
     * Gibt die Foto-Info für einen Eintrag beim GET-Request zurück.
     * @param FotoInfoId die ID, die den Eintrag auswählt
     * @return die Foto-Info zur ID oder null, wenn der Eintrag nicht
     *         vorhanden ist
     */
    @GetMapping(path = "{studentId}")
    public FotoInfoAusgangsModel getFotoInfoById(@PathVariable("studentId") Long FotoInfoId){
        Optional<FotoInfoAusgangsModel> ergebnis = service.findAllFotoInfos().stream()
                .filter(fotoInfo -> fotoInfo.getId() == FotoInfoId)
                .findFirst();
        if (ergebnis.isPresent()) {
            return ergebnis.get();
        }
        return null;
    }

    /**
     * POST-Request (Neuen Eintrag erstellen)
     */
    @PostMapping
    public void createNewFotoInfo(){}

    /**
     * DELETE-Request nach Foto-ID (Einen Eintrag löschen)
     */
    @DeleteMapping(path = "{fotoId}")
    public void deleteFotoInfo(){}

    /**
     * PUT-Request nach Foto-ID (Einen Eintrag aktuallisieren)
     */
    @PutMapping(path = "{fotoId}")
    public void updateFotoInfo(){}
}
