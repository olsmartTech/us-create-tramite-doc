package pe.com.essalud.tramitedoc.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import pe.com.essalud.tramitedoc.beans.Documento;
import pe.com.essalud.tramitedoc.beans.ResponseBean;
import pe.com.essalud.tramitedoc.beans.TipoPedido;
import pe.com.essalud.tramitedoc.beans.TramiteBean;
import pe.com.essalud.tramitedoc.business.TramiteService;
import pe.com.essalud.tramitedoc.dao.TramiteDAOImpl;
import pe.com.essalud.tramitedoc.exception.DaoException;
import pe.com.essalud.tramitedoc.exception.DaoTimeOutException;
import pe.com.essalud.tramitedoc.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.LoggerFactory;
import pe.com.essalud.tramitedoc.util.FechaUtil;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tramite/externo")
public class TramiteController {
    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    TramiteService tramiteService;

    @PostMapping("/documento")
    public ResponseBean crearTrmite(@RequestBody TramiteBean bean) throws DaoException{
        logger.info("----------m:crearTrmite--------");
        //convertBase64ToBinari(bean.getDocuPrincipal().getDocumbase64());
        ResponseBean response = tramiteService.createTramiteExterno(bean);
        if(bean.getpAccion().equals("2")){
            bean.setIdDependOrigen(bean.getIdAreaProceso());
        }
        logger.info("----------END m:crearTrmite--------");
        return response;
    }

    private void convertBase64ToBinari(String base64_str){
        System.out.println("imagen convertida in: "  +base64_str );
        byte[] decode = Base64.decodeBase64(base64_str);
        System.out.println("imagen convertida out: "  +decode );
    }

    @GetMapping("/create/{num}")
    String createTramiteDoc(@PathVariable String num) throws DaoException{
        System.out.println("INICIANDO EL METODO CREAR");
        TramiteBean bean=new TramiteBean();
        bean.setIdAreaProceso(182);
        bean.setIdInteresado(3214076);
        bean.setTipoIdDocEntrante("002");
        bean.setPidDocEntrante("RESOLUCION DE PRUEBA");
        bean.setpTipoTramite(74);
        bean.setPasunto("ESTE ASUNTO ES PARA RECONOCIMIENTO DE PRUEBA");
        bean.setpObservacion("");
        bean.setpTipoOrigen(1);
        bean.setpIdUsuarioRegistra(8190);
        bean.setpAccion("2");
        bean.setCadenaReferencias("055|ENVIANDO ANTICIPO DE PRUEBA");
        bean.setCadenaPrioridad("1");
        bean.setCadenaPara("15");
        bean.setCadenaSumilla("CAMPO SUMILLA");
        bean.setCadenaPlazo("1");
        bean.setCadenaFolios("4");
        bean.setCadenaAtencion("CAMPO ATENCION");
        bean.setCadenaConcluye("0");
        bean.setCadenaDirigido("0178-A");
        bean.setCadenaConCopia("");
        bean.setIdPersona(18764);
        bean.setCadenaAcompanamiento("254");
        bean.setIdDependOrigen(0);
        bean.setIdTipoDocSaliente(null);
        bean.setPidPersonaAseg(0);
        bean.setPidTipoProducto(0);
        bean.setPidTipoProceso(0);
        bean.setCadenaPeriodo("1");
        //bean.setFechaRecepFisica(FechaUtil.parseStringDateToDate(new Date(),Constantes.DATE_FORMAT_DDMMYYYYHHMM);
        bean.setFechaRecepFisica(new Date()+"");
        bean.setPidClaseTramite(1);
        if(bean.getpAccion().equals("2")){
            bean.setIdDependOrigen(bean.getIdAreaProceso());
        }
        tramiteService.createTramiteExterno(bean);
        return "INGRESO A REGISTRA>>>";
    }

    @GetMapping("/listarpedidos/{param}")
    public String listarpedidos(@PathVariable String param) throws DaoTimeOutException, DaoException {
        System.out.println("MEODO DALUDAR " + param);
        //logger.info("==Inicio del metodo listarpedidos");
        List<TipoPedido> list=tramiteService.listTipoPedido("inicio");
        for(TipoPedido t: list){
            System.out.println("value: " + t.getIdTipoPed()+" - "+t.getDescripcion());
        }
        //logger.info("Valor de la lista: " + list.size());
        System.out.println("valor de la lista " + list.size());
        return "HOLA MUNDO TEST";
    }

}
