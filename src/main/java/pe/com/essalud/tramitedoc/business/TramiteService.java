package pe.com.essalud.tramitedoc.business;

import pe.com.essalud.tramitedoc.beans.ResponseBean;
import pe.com.essalud.tramitedoc.beans.TipoPedido;
import pe.com.essalud.tramitedoc.beans.TramiteBean;
import pe.com.essalud.tramitedoc.exception.DaoException;
import pe.com.essalud.tramitedoc.exception.DaoTimeOutException;

import java.util.List;

public interface TramiteService {

    ResponseBean createTramiteExterno(TramiteBean t) throws DaoException;
    List<TipoPedido> listTipoPedido(String msgTraza)throws DaoException, DaoTimeOutException;

}
