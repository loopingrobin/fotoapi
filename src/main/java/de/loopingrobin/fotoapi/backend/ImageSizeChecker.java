package de.loopingrobin.fotoapi.backend;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Der ImageSizeChecker ermittelt die Größe von Bildern die
 * zuvor mittels URL geladen wurden.
 */
@Service
public class ImageSizeChecker {

// --------------------------------------------------------
// Attribute
// --------------------------------------------------------

    /** Enthält die URL des Fotos, dessen Größe ermittelt wird. */
    private URL url;

// --------------------------------------------------------
// Methoden
// --------------------------------------------------------

    /**
     * Lädt ein Foto über die URL und ermittelt die Größe in Bytes.
     * @param urlString die URL des Fotos als String
     * @return die Größe des Fotos in Bytes oder -1, wenn die URL
     *      null ist.
     */
    public long getImageSize(String urlString) {

        url = getCheckedUrl(urlString);

        if (url != null) {
            try {
                // Öffnet einen Input-Stream und liest die Daten byteweise.
                InputStream inputStream = url.openStream();

                int data = inputStream.read();
                int strZaehler = 0;
                while (data != -1) {
                    data = inputStream.read();
                    strZaehler++;
                }

                // Schließt den Input-Stream.
                inputStream.close();

                //  Gibt die Größe in Bytes zurück.
                return strZaehler;

            } catch (IOException exception) {
                System.err.println("Der Stream konnte nicht erstellt, gelesen oder geschlossen werden.");
            }
        }

        // Gibt -1 zurück, wenn die URL null ist.
        return -1;
    }

    private @Nullable URL getCheckedUrl(String urlString) {

        if (urlString == null) {
            return null;
        }
        // Erstetzt in der URL das "http" durch ein "https"
        urlString = urlString.replace("http:", "https:");

        URL rueckgabeUrl = null;
        try {
            rueckgabeUrl = new URL(urlString);

        } catch (MalformedURLException exception) {
            System.err.println("Die URL ist nicht lesbar!");
        }

        if (rueckgabeUrl != null) {
            try {
                HttpURLConnection connection = (HttpURLConnection) rueckgabeUrl.openConnection();
                connection.setConnectTimeout(600);
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();

                if (responseCode != 200) {
                    System.err.println("Die URL kann nicht angesprochen werden!");
                    return null;
                }

            } catch (IOException exception) {
                System.err.println("Es konnte keine HTTP-Connection hergestellt werden!");
            }
        }


        return rueckgabeUrl;
    }
}
