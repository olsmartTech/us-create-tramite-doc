package pe.com.essalud.tramitedoc.dao;

import pe.com.essalud.tramitedoc.beans.*;
import pe.com.essalud.tramitedoc.exception.DaoException;
import pe.com.essalud.tramitedoc.exception.DaoTimeOutException;

import java.util.List;

public interface TramiteDAO {

    ResponseBean createTramiteExterno(TramiteBean t) throws DaoException;
    List<TipoPedido> listTipoPedido(String msgTraza)throws DaoException, DaoTimeOutException;
    void createDocumentoTemporal(long identificador)throws DaoException;;
    ResponseBean createInteresadosMpv(InteresadoMpv in)throws DaoException;
    ResponseBean createFileMpv(ArchivoAnexo in)throws DaoException;
}
