package pe.com.essalud.tramitedoc.business;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.essalud.tramitedoc.beans.ResponseBean;
import pe.com.essalud.tramitedoc.beans.TipoPedido;
import pe.com.essalud.tramitedoc.beans.TramiteBean;
import pe.com.essalud.tramitedoc.dao.TramiteDAO;
import pe.com.essalud.tramitedoc.exception.DaoException;
import pe.com.essalud.tramitedoc.exception.DaoTimeOutException;

import java.util.List;

@Service
public class TramiteServiceImpl implements TramiteService {

    @Autowired
    TramiteDAO tramiteDAO;

     @Override
    public ResponseBean createTramiteExterno(TramiteBean t) throws DaoException {

         return tramiteDAO.createTramiteExterno(t);
     }

    @Override
    public List<TipoPedido> listTipoPedido(String msgTraza)throws DaoException, DaoTimeOutException {

        return tramiteDAO.listTipoPedido(msgTraza);
    }
}
