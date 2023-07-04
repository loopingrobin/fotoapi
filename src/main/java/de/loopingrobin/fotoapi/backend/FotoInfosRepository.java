package de.loopingrobin.fotoapi.backend;

import org.springframework.stereotype.Repository;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

/**
 * Das Interface für das Repository, gibt die Methode zu Beschaffung
 * der Foto-Infos, über die Foto-API von Soerensen, vor und bestimmt
 * die Pfadergänzung für die HTTP-Request.
 */
@Repository
public interface FotoInfosRepository {

    @GetExchange("/fotos")
    List<FotoApiEingangsModel> findAll();
}