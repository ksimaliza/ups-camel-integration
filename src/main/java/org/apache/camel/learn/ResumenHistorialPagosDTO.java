package org.apache.camel.learn;

/**
 *
 * @author ksimaliza
 */
public class ResumenHistorialPagosDTO {
    
    private int registroValido;
    private int registroConError;
    private int totalRegistroArchivo;

    public ResumenHistorialPagosDTO(int registroValido, int registroConError, int totalRegistroArchivo) {
        this.registroValido = registroValido;
        this.registroConError = registroConError;
        this.totalRegistroArchivo = totalRegistroArchivo;
    }
    
    

    public int getRegistroValido() {
        return registroValido;
    }

    public void setRegistroValido(int registroValido) {
        this.registroValido = registroValido;
    }

    public int getRegistroConError() {
        return registroConError;
    }

    public void setRegistroConError(int registroConError) {
        this.registroConError = registroConError;
    }

    public int getTotalRegistroArchivo() {
        return totalRegistroArchivo;
    }

    public void setTotalRegistroArchivo(int totalRegistroArchivo) {
        this.totalRegistroArchivo = totalRegistroArchivo;
    }

    @Override
    public String toString() {
        return "ResumenHistorialPagosDTO{" + "TOTAL REGISTRO VALIDO =" + registroValido + ", TOTAL REGISTRO ERROR VALIDACION =" + registroConError + ", TOTAL REGISTRO ARCHIVO=" + totalRegistroArchivo + '}';
    }
    
    
    
    
}
