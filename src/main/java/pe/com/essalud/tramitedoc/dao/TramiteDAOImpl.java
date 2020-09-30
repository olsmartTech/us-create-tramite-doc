package pe.com.essalud.tramitedoc.dao;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;
//import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;
import pe.com.essalud.tramitedoc.beans.*;
//import org.apache.logging.*;
import javax.imageio.ImageIO;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;

import pe.com.essalud.tramitedoc.dao.mapper.ListaTramiteMapper;
import pe.com.essalud.tramitedoc.dao.mapper.TipoPedidoMapper;
import pe.com.essalud.tramitedoc.exception.DaoException;
import oracle.jdbc.OracleTypes;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import pe.com.essalud.tramitedoc.exception.DaoTimeOutException;
import pe.com.essalud.tramitedoc.util.Base64;
import pe.com.essalud.tramitedoc.util.Constantes;
import pe.com.essalud.tramitedoc.util.FechaUtil;
import sun.misc.BASE64Decoder;

import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;
import java.sql.Types;
import java.util.*;


@Repository
public class TramiteDAOImpl implements TramiteDAO {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Override
    public ResponseBean createTramiteExterno(TramiteBean t) throws DaoException {

        String msgTraza = t.getMensajetraza() + "[createTramiteExterno]-";
        logger.info(msgTraza + "==Inicio del metodo createTramiteExterno");
        ResponseBean responseoBean = new ResponseBean();
        try {
            ListaTramiteMapper map=new ListaTramiteMapper();
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource)
                    .withoutProcedureColumnMetaDataAccess()
                    .withSchemaName("TRAMITE_NUEVO")
                    .withProcedureName("PKTD_DERIVA_TRAMITE_BANDEJA.registra_nuevo_tramite_mpv")
                    .declareParameters(
                            new SqlOutParameter("cur_resumen", OracleTypes.CURSOR, map),
                            new SqlOutParameter("RESULTADO",OracleTypes.VARCHAR),
                            new SqlOutParameter("CONTROL",OracleTypes.VARCHAR),
                            new SqlOutParameter("SQLERRORDESC",OracleTypes.VARCHAR),
                           new SqlOutParameter("pIdentificadorx",OracleTypes.VARCHAR),
            new SqlOutParameter("PSEQSEGUIMIENTO",OracleTypes.VARCHAR),
            new SqlParameter("ID_AREA_PROCESO", OracleTypes.NUMBER),
                    new SqlParameter("ID_INTERESADO", OracleTypes.NUMBER),
                    new SqlParameter("TIPO_ID_DOC_ENTRANTE", OracleTypes.VARCHAR),
                    new SqlParameter("PIDDOCENTRANTE", OracleTypes.VARCHAR),
                    new SqlParameter("PTIPOTRAMITE", OracleTypes.NUMBER),
                    new SqlParameter("PASUNTO", OracleTypes.VARCHAR),
                    new SqlParameter("POBSERVACION", OracleTypes.VARCHAR),
                    new SqlParameter("PTIPOORIGEN", OracleTypes.NUMBER),
                    new SqlParameter("PIDUSUARIOREGISTRA", OracleTypes.NUMBER),
                    new SqlParameter("PACCION", OracleTypes.VARCHAR),
                    new SqlParameter("CADENA_REFERENCIAS", OracleTypes.VARCHAR),
                    new SqlParameter("CADENA_PRIORIDAD", OracleTypes.VARCHAR),
                    new SqlParameter("CADENA_PARA", OracleTypes.VARCHAR),
                    new SqlParameter("CADENA_SUMILLA", OracleTypes.VARCHAR),
                    new SqlParameter("CADENA_PLAZO", OracleTypes.VARCHAR),
                    new SqlParameter("CADENA_FOLIOS", OracleTypes.VARCHAR),
                    new SqlParameter("CADENA_ATENCION", OracleTypes.VARCHAR),
                    new SqlParameter("CADENA_CONCLUYE", OracleTypes.VARCHAR),
                    new SqlParameter("CADENA_DIRIGIDO", OracleTypes.VARCHAR),
                    new SqlParameter("CADENA_CON_COPIA", OracleTypes.VARCHAR),
                    new SqlParameter("ID_PERSONA", OracleTypes.NUMBER),
                    new SqlParameter("CADENA_ACOMPANAMIENTO", OracleTypes.VARCHAR),
                    new SqlParameter("ID_DEPEND_ORIGEN", OracleTypes.NUMBER),
                    new SqlParameter("ID_TIPO_DOC_SALIENTE", OracleTypes.NUMBER),
                    new SqlParameter("PID_PERSONA_ASEG", OracleTypes.NUMBER),
                    new SqlParameter("PID_TIPO_PRODUCTO", OracleTypes.NUMBER),
                    new SqlParameter("PID_TIPO_PROCESO", OracleTypes.NUMBER),
                    new SqlParameter("CADENA_PERIODO", OracleTypes.VARCHAR),
                    new SqlParameter("FECHA_RECEP_FISICA", OracleTypes.DATE),
                    new SqlParameter("PID_CLASE_TRAMITE", OracleTypes.NUMBER)
                    );

            logger.info(msgTraza + "Final in");

            logger.info(msgTraza + "Ejecutando SP :");
            logger.info(msgTraza + " Datos de entrada:"+"[ID_AREA_PROCESO:" + t.getIdAreaProceso() + "]-\n" +
                    "[:" + t.getDocuPrincipal().getDocumbase64() + "]-\n" +
                    "[:" + t.getDocuPrincipal().getFlagjerarquia() + "]-\n" +
                    "[:" + t.getDocuPrincipal().getDocumNobre() + "]-\n" +
                    "[:" + t.getDocuPrincipal().getDocumContentType() + "]-\n" +
                    "[:" + t.getDocuPrincipal().getDocumTamanio() + "]-\n" +
                    "[ID_AREA_PROCESO:" + t.getIdAreaProceso() + "]-\n" +
                    " Datos de entrada:"+"[ID_AREA_PROCESO:" + t.getIdAreaProceso() + "]-\n" +
                    "[TIPO_ID_DOC_ENTRANTE:" + t.getTipoIdDocEntrante()+ "]-\n" +
                    "[PIDDOCENTRANTE:" + t.getPidDocEntrante() + "]-\n" +
                    "[PTIPOTRAMITE:" + t.getpTipoTramite() + "]-\n" +
                    "[PASUNTO:" + t.getPasunto() + "]-\n" +
                    "[POBSERVACION:" + t.getpObservacion() + "]-\n" +
                    "[PTIPOORIGEN:" + t.getpTipoOrigen() + "]-\n" +
                    "[PIDUSUARIOREGISTRA:" + t.getpIdUsuarioRegistra() + "]-\n" +
                    "[PACCION:" + t.getpAccion() + "]-\n" +
                    "[CADENA_REFERENCIAS:" + t.getCadenaPrioridad() + "]-\n" +
                    "[CADENA_PRIORIDAD:" + t.getCadenaPrioridad() + "]-\n" +

                    "[CADENA_PARA:" + t.getCadenaPara() + "]-\n" +
                    "[CADENA_SUMILLA:" + t.getCadenaSumilla() + "]-\n" +
                    "[CADENA_PLAZO:" + t.getCadenaPlazo() + "]-\n" +
                    "[CADENA_FOLIOS:" + t.getCadenaFolios() + "]-\n" +
                    "[CADENA_ATENCION:" + t.getCadenaAtencion() + "]-\n" +
                    "[CADENA_CONCLUYE:" + t.getCadenaConcluye() + "]-\n" +
                    "[CADENA_DIRIGIDO:" + t.getCadenaDirigido() + "]-\n" +
                    "[CADENA_CON_COPIA:" + t.getCadenaConCopia() + "]-\n" +
                    "[ID_PERSONA:" + t.getIdPersona() + "]-\n" +
                    "[CADENA_ACOMPANAMIENTO:" + t.getCadenaAcompanamiento() + "]-\n" +
                    "[ID_DEPEND_ORIGEN:" + t.getIdDependOrigen() + "]-\n" +
                    "[ID_TIPO_DOC_SALIENTE:" + t.getTipoIdDocEntrante() + "]-\n" +
                    "[PID_PERSONA_ASEG:" + t.getPidPersonaAseg() + "]-\n" +

                    "[PID_TIPO_PRODUCTO:" + t.getPidTipoProducto() + "]-" +
                    "[PID_TIPO_PROCESO:" + t.getPidTipoProceso() + "]-" +
                    "[CADENA_PERIODO:" + t.getCadenaPeriodo() + "]-" +
                    "[FECHA_RECEP_FISICA:" + t.getFechaRecepFisica() + "]-" +
                    "[PID_CLASE_TRAMITE:" + t.getPidClaseTramite() + "]-");
            logger.info(" FINAL DE TRAZA DE INPUT :");
            ResponseBean response=createInteresadosMpv(t.getInteresadoMpv());
            t.setIdInteresado(response.getIdInteresado());
            logger.info(" MOSTRANDO EL RESULTADO DEL INTERESADO "+ t.getIdInteresado());
            logger.info("-------------------------------------------------------------------");
            logger.info("-----------------------END INTERESADO-------------------------------");
            SqlParameterSource objParametrosIN = new MapSqlParameterSource()
                    .addValue("ID_AREA_PROCESO", t.getIdAreaProceso())
                    .addValue("ID_INTERESADO", t.getIdInteresado())
                    .addValue("TIPO_ID_DOC_ENTRANTE", t.getTipoIdDocEntrante())
                    .addValue("PIDDOCENTRANTE", t.getPidDocEntrante())
                    .addValue("PTIPOTRAMITE", t.getpTipoTramite())
                    .addValue("PASUNTO", t.getPasunto())
                    .addValue("POBSERVACION", t.getpObservacion())
                    .addValue("PTIPOORIGEN", t.getpTipoOrigen())
                    .addValue("PIDUSUARIOREGISTRA",t.getpIdUsuarioRegistra())
                    .addValue("PACCION", t.getpAccion())
                    .addValue("CADENA_REFERENCIAS", t.getCadenaReferencias())
                    .addValue("CADENA_PRIORIDAD", t.getCadenaPrioridad())
                    .addValue("CADENA_PARA", t.getCadenaPara())
					.addValue("CADENA_SUMILLA", t.getCadenaSumilla())
					.addValue("CADENA_PLAZO", t.getCadenaPlazo())
					.addValue("CADENA_FOLIOS", t.getCadenaFolios())
					.addValue("CADENA_ATENCION", t.getCadenaAtencion())
					.addValue("CADENA_CONCLUYE",t.getCadenaConcluye())
					.addValue("CADENA_DIRIGIDO", t.getCadenaDirigido())
					.addValue("CADENA_CON_COPIA", t.getCadenaConCopia())
					.addValue("ID_PERSONA", t.getIdPersona())
					.addValue("CADENA_ACOMPANAMIENTO", t.getCadenaAcompanamiento())
					.addValue("ID_DEPEND_ORIGEN", t.getIdDependOrigen())
					.addValue("ID_TIPO_DOC_SALIENTE", t.getIdTipoDocSaliente())
					.addValue("PID_PERSONA_ASEG", t.getPidPersonaAseg())
					.addValue("PID_TIPO_PRODUCTO", t.getPidTipoProducto())
					.addValue("PID_TIPO_PROCESO", t.getPidTipoProceso())
					.addValue("CADENA_PERIODO", t.getCadenaPeriodo())
					//.addValue("FECHA_RECEP_FISICA", new java.sql.Timestamp(t.getFechaRecepFisica().getTime()))
                    .addValue("FECHA_RECEP_FISICA", new java.sql.Timestamp(new java.util.Date().getTime()))
					.addValue("PID_CLASE_TRAMITE", t.getPidClaseTramite());
                   Map<String,Object> resultMap= jdbcCall.execute(objParametrosIN);
            logger.info(msgTraza + " Datos de salida:"+"[RESULTADO:" + resultMap.get("RESULTADO") + "]-\n" +
                    "[SQLERRORDESC:" + resultMap.get("CONTROL") + "]\n"+
                    "[SQLERRORDESC:" + resultMap.get("SQLERRORDESC") + "]\n"+
                    "[PIDENTIFICADORX:" + resultMap.get("PIDENTIFICADORX") + "]\n"+
                    "[PSEQSEGUIMIENTO:" + resultMap.get("PSEQSEGUIMIENTO") + "]\n"
            );
            List<DocumentBean> listResul = (List<DocumentBean>)resultMap.get("cur_resumen");
            if(listResul!=null){
                int count=0;
                for(DocumentBean d : listResul){
                    System.out.println(" value: :"+ d.getItem()+" " +d.getTipo());
                    if(count==0) {
                        responseoBean.setNumeroNit(d.getItem());
                    }
                    count++;
                }
            }
            long idenficador=(resultMap.get("pIdentificadorx")==null?0:new Long(resultMap.get("pIdentificadorx").toString()));
            if(idenficador>0){
                //createDocumentoTemporal(idenficador);
                ArchivoAnexo aa=downloadDataFile(t);
                aa.setIdentificador(idenficador);
                createFileMpv(aa);//Grabamos el archivo principal
                if(t.getListDocuAnexos()!=null) {
                    logger.info("size anexos " + t.getListDocuAnexos().size());
                    for (Documento d : t.getListDocuAnexos()) {
                        t.getDocuPrincipal().setDocumbase64(d.getDocumbase64());
                        t.getDocuPrincipal().setFlagjerarquia(d.getFlagjerarquia());
                        t.getDocuPrincipal().setDocumNobre(d.getDocumNobre());
                        t.getDocuPrincipal().setDocumTamanio(d.getDocumTamanio());
                        ArchivoAnexo aaa = downloadDataFile(t);
                        aaa.setIdentificador(idenficador);
                        createFileMpv(aaa);//Grabamos los archivos anexos
                    }
                }
            }
            logger.info(" FINALIZANDO Y RECUPERANDO DATOS 2 ***>> :" + listResul);
            responseoBean.setCodRespuesta(resultMap.get("RESULTADO")+"");
            responseoBean.setMsgRespuesta(resultMap.get("CONTROL")+"");
            responseoBean.setMsgRespuesta(resultMap.get("CONTROL")+"");
            responseoBean.setIdenfificador(resultMap.get("pIdentificadorx")==null?"":resultMap.get("pIdentificadorx").toString());
            return responseoBean;
        }
        catch (Exception ex) {
            logger.error(msgTraza + "Exception[ERROR] : " ,ex);
            ex.printStackTrace();
            String error = (ex + Constantes.CADENA_VACIA);
                throw new DaoException("Error al recuperar la informacion:", "", ex);
            }
        finally {
            logger.info(msgTraza + "==Fin del metodo createTramiteExterno ");
        }
    }

    @Override
    public List<TipoPedido> listTipoPedido(String msgTraza) throws DaoException, DaoTimeOutException {
        String mensajeLog = msgTraza + "[listTipoPedido]-";
        logger.info(mensajeLog + "==Inicio del metodo listTipoPedido");
        List<TipoPedido> listPedido = new ArrayList<>();
        TipoPedidoMapper map=new TipoPedidoMapper();
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource)
                    .withoutProcedureColumnMetaDataAccess()
                    .withSchemaName("TRAMITE_NUEVO")
                    .withProcedureName("PKTD_TRAMITE_BANDEJA_CONGRESAL.LISTA_TIPO_PEDIDO")
                    .declareParameters( new SqlParameter("P_ESTADO",OracleTypes.VARCHAR),
                            new SqlOutParameter("S_CODIGO",OracleTypes.CHAR),
                            new SqlOutParameter("S_MENSAJE",OracleTypes.VARCHAR),
                            new SqlOutParameter("S_CURSOR",OracleTypes.CURSOR, map)
                    );

            logger.info(mensajeLog + "Consultando BD TRAMITENUEVO, con JNDI=");
            //jdbcCall.getJdbcTemplate().setQueryTimeout(VALUE_CONFIGURE);

            logger.info(mensajeLog + "--FIN DE Ejecutando SP--");

            logger.info(mensajeLog + " Datos de entrada:"+"[S_CODIGO:" + 1 + "]" );

            SqlParameterSource objParametrosIN = new MapSqlParameterSource()
                    .addValue("P_ESTADO", "1");

            Map<String,Object> resultMap= jdbcCall.execute(objParametrosIN);

            listPedido = (List<TipoPedido>)resultMap.get("S_CURSOR");
            logger.info(msgTraza + " Datos de salida:"+"[S_CODIGO:" + resultMap.get("S_CODIGO") + "]-" +
                    "[S_MENSAJE:" + resultMap.get("S_MENSAJE") + "]"
            );
        }
        catch (Exception ex) {
            logger.error(mensajeLog + "Exception[ERROR] : " ,ex);
            String error = (ex + Constantes.CADENA_VACIA);
                throw new DaoException(error);
        }finally {
            logger.info(mensajeLog + "==Fin del metodo validarRespuestas");
        }
        return listPedido;
    }

    @Override
    public void createDocumentoTemporal(long identificador) throws DaoException{
        String msgTraza = identificador + "[createDocumentoTemporal]-";
        logger.info(msgTraza + "==Inicio del metodo createDocumentoTemporal");
        ResponseBean responseoBean = new ResponseBean();
        try {
            ListaTramiteMapper map=new ListaTramiteMapper();
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource)
                    .withoutProcedureColumnMetaDataAccess()
                    .withSchemaName("TRAMITE_NUEVO")
                    .withProcedureName("PKTD_TRAMITE_BANDEJA_CONGRESAL.CREATE_DOCUMENTO_TEM")
                    .declareParameters(
                            new SqlParameter("P_IDENTIFICAR", OracleTypes.NUMBER),
                            new SqlOutParameter("RESULTADO",OracleTypes.VARCHAR)
                    );

            logger.info(msgTraza + "Final in");
            logger.info(msgTraza + "Ejecutando SP :");
            System.out.println("empezando a ingresar el :");
            logger.info(msgTraza + " Datos de entrada:"+"[P_IDENTIFICAR:" +identificador + "]-");
            System.out.println(" FINAL DE TRAZA DE INPUT :");
            SqlParameterSource objParametrosIN = new MapSqlParameterSource()
                    .addValue("P_IDENTIFICAR", identificador);
            Map<String,Object> resultMap= jdbcCall.execute(objParametrosIN);
            System.out.println(msgTraza + "createDocumentoTemporal:"+"[RESULTADO>>>>:" + resultMap.get("RESULTADO") + "]-\n"
            );
            System.out.println(" FINALIZANDO Y RECUPERANDO DATOS 1 *** :" );
            responseoBean.setCodRespuesta(resultMap.get("RESULTADO")+"");
        }
        catch (Exception ex) {
            logger.error(msgTraza + "Exception[ERROR] : " ,ex);
            System.out.println(" MOSTRANNDOOOOOOO ");
            ex.printStackTrace();
            String error = (ex + Constantes.CADENA_VACIA);
            throw new DaoException("Error al recuperar la informacion:", "", ex);
        }
        finally {
            logger.info(msgTraza + "==Fin del metodo createTramiteExterno ");
        }
    }

    @Override
    public ResponseBean createInteresadosMpv(InteresadoMpv in) throws DaoException{
        String msgTraza = "[createInteresadosMpv]-";
        logger.info(msgTraza + "==Inicio del metodo createInteresadosMpv");
        ResponseBean responseoBean = new ResponseBean();
        try {
            ListaTramiteMapper map=new ListaTramiteMapper();
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource)
                    .withoutProcedureColumnMetaDataAccess()
                    .withSchemaName("TRAMITE_NUEVO")
                    .withProcedureName("PKTD_DERIVA_TRAMITE_BANDEJA.CREATE_INTERESADO_MPV")
                    .declareParameters(
                            new SqlParameter("P_ID_INTERESADO", OracleTypes.NUMBER),
                            new SqlParameter("P_NOMBRE", OracleTypes.VARCHAR),
                            new SqlParameter("P_DIRECCION", OracleTypes.VARCHAR),
                            new SqlParameter("P_NUMERO_DOCUMENTO", OracleTypes.VARCHAR),
                            new SqlParameter("P_TIPO_DOCUMENTO", OracleTypes.NUMBER),
                            new SqlParameter("P_CORREO_ELECTRONICO", OracleTypes.VARCHAR),
                            new SqlParameter("P_NUMERO_TELEFONO", OracleTypes.VARCHAR),
                            new SqlParameter("P_CODIGO_UBIGEO", OracleTypes.VARCHAR),
                            new SqlParameter("P_REFERENCIA", OracleTypes.VARCHAR),
                            new SqlParameter("P_ID_USUARIO_ACTUALIZA", OracleTypes.NUMBER),
                            new SqlParameter("P_CARGO", OracleTypes.VARCHAR),
                            new SqlParameter("P_ID_USUARIO_REGISTRA", OracleTypes.NUMBER),
                            new SqlOutParameter("P_IDENFIFICADOR_OUT", OracleTypes.NUMBER),
                            new SqlOutParameter("P_RESULTADO", OracleTypes.VARCHAR),
                            new SqlOutParameter("P_CODIGO", OracleTypes.CHAR)
                    );

            logger.info(msgTraza + "Final in");
            logger.info(msgTraza + "Ejecutando SP :");
            SqlParameterSource objParametrosIN = new MapSqlParameterSource()
                    .addValue("P_ID_INTERESADO", in.getIdInteresado())
                    .addValue("P_NOMBRE", in.getNombre())
                    .addValue("P_DIRECCION", in.getDireccion())
                    .addValue("P_NUMERO_DOCUMENTO", in.getNumeroDocumento())
                    .addValue("P_TIPO_DOCUMENTO", in.getTipoDocumento())
                    .addValue("P_CORREO_ELECTRONICO", in.getCorreoElectronico())
                    .addValue("P_NUMERO_TELEFONO", in.getNumeroTelefono())
                    .addValue("P_CODIGO_UBIGEO", in.getCodigoUbigeo())
                    .addValue("P_REFERENCIA", in.getReferencia())
                    .addValue("P_ID_USUARIO_ACTUALIZA", in.getUsuarioActualiza())
                    .addValue("P_CARGO", in.getCargo())
                    .addValue("P_ID_USUARIO_REGISTRA", in.getIdUsuarioRegistra());
            Map<String,Object> resultMap= jdbcCall.execute(objParametrosIN);
            logger.info("------------OUT DEL SP-------------------");
            logger.info(" NUMERO DE DOCUMENTO: "+in.getNumeroDocumento());
            logger.info(msgTraza + "RESULTDO DE CREAR INTERESADO :"+"[RESULTADO>>>>: " +
                    resultMap.get("P_IDENFIFICADOR_OUT") + "]-\n"+
                    resultMap.get("P_RESULTADO") + "]-\n"+
                    resultMap.get("P_CODIGO") + "]-\n"
            );
            responseoBean.setIdInteresado(resultMap.get("P_IDENFIFICADOR_OUT")==null?0:new Long(resultMap.get("P_IDENFIFICADOR_OUT").toString()));
        }
        catch (Exception ex) {
            logger.error(msgTraza + "Exception[ERROR] : " ,ex);
            ex.printStackTrace();
            String error = (ex + Constantes.CADENA_VACIA);
            responseoBean.setIdInteresado(0);
            throw new DaoException("Error al recuperar la informacion:", "", ex);
        }
        finally {
            logger.info(msgTraza + "==Fin del metodo createTramiteExterno ");
        }
        return responseoBean;
    }

    @Override
    public ResponseBean createFileMpv(ArchivoAnexo in) throws DaoException {
        String msgTraza = "[createFileMpv]-";
        logger.info(msgTraza + "==Inicio del metodo createFileMpv");
        logger.info("---------INICIO METODO createFileMpv--------------");
        logger.info("iniciando el metodo create tramite:");
        ResponseBean responseoBean = new ResponseBean();

        try {
            ListaTramiteMapper map=new ListaTramiteMapper();
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource)
                    .withoutProcedureColumnMetaDataAccess()
                    .withSchemaName("TRAMITE_NUEVO")
                    .withProcedureName("PKTD_DERIVA_TRAMITE_BANDEJA.CREATE_DOCUMENT_BY_TRAMITE")
                    .declareParameters( new SqlParameter("P_ID_ARCHIVO", OracleTypes.NUMBER),
                            new SqlParameter("P_IDENTIFICADOR", OracleTypes.NUMBER),
                            new SqlParameter("P_SECUENCIA_SEGUIMIENTO", OracleTypes.NUMBER),
                            new SqlParameter("P_TIPO_ARCHIVO", OracleTypes.NUMBER),
                            new SqlParameter("P_NOMBRE_ARCHIVO", OracleTypes.VARCHAR),
                            new SqlParameter("P_CONTENIDO_ARCHIVO", OracleTypes.BLOB),
                            new SqlParameter("P_TEXTO_OCR", OracleTypes.VARCHAR),
                            new SqlParameter("P_TAMANO_ARCHIVO", OracleTypes.NUMBER),
                            new SqlParameter("P_CONTENT_TYPE", OracleTypes.VARCHAR),
                            new SqlParameter("P_DESCRIPCION", OracleTypes.VARCHAR),
                            new SqlParameter("P_ID_USUARIO", OracleTypes.NUMBER),
                            new SqlParameter("P_TIPO_DOCUMENTO", OracleTypes.NUMBER),
                            new SqlParameter("P_ID_DEPENDENCIA", OracleTypes.NUMBER),
                            new SqlParameter("P_FECHA_DOCUMENTO", OracleTypes.DATE),
                            new SqlParameter("P_CORRELATIVO", OracleTypes.NUMBER),
                            new SqlParameter("P_FIRMA_DIGITAL", OracleTypes.VARCHAR),
                            new SqlParameter("P_FLAGJERARQUIA", OracleTypes.CHAR),
                            new SqlOutParameter("P_RESULTADO", OracleTypes.VARCHAR),
                            new SqlOutParameter("P_CODIGO", OracleTypes.CHAR)
                    );

            logger.info(msgTraza + "Final in");
            logger.info(msgTraza + "Ejecutando SP :");
            LobHandler lobhandler = new DefaultLobHandler();
            SqlParameterSource objParametrosIN = new MapSqlParameterSource()
                    .addValue("P_ID_ARCHIVO", in.getIdArchivo())
                    .addValue("P_IDENTIFICADOR", in.getIdentificador())
                    .addValue("P_SECUENCIA_SEGUIMIENTO", in.getSecuenciaSeguimiento())
                    .addValue("P_TIPO_ARCHIVO", in.getTipoArchivo())
                    .addValue("P_NOMBRE_ARCHIVO", in.getNombreArchivo())
                    //.addValue("P_CONTENIDO_ARCHIVO", in.getFile())
            //.addValue("P_CONTENIDO_ARCHIVO", new SqlLobValue(in.getFile(), lobhandler), Types.BLOB)
                    .addValue("P_CONTENIDO_ARCHIVO",
                            new SqlLobValue(new ByteArrayInputStream(in.getFile()),
                                    in.getFile().length, new DefaultLobHandler()), Types.BLOB)

                    .addValue("P_TEXTO_OCR", in.getTextoOcr())
                    .addValue("P_TAMANO_ARCHIVO", in.getTamanoArchivo())
                    .addValue("P_CONTENT_TYPE", in.getContenType())
                    .addValue("P_DESCRIPCION", in.getDescripcion())
                    .addValue("P_ID_USUARIO", in.getIdUsuario())
                    .addValue("P_TIPO_DOCUMENTO", in.getTipoArchivo())
.addValue("P_ID_DEPENDENCIA", in.getIdDependencia())
.addValue("P_FECHA_DOCUMENTO", null)
.addValue("P_CORRELATIVO", in.getCorrelativo())
.addValue("P_FIRMA_DIGITAL", in.getFirmaDigital())
.addValue("P_FLAGJERARQUIA", in.getFlagjerarquia());
            Map<String,Object> resultMap= jdbcCall.execute(objParametrosIN);
            logger.info("------------OUT DEL SP-------------------");
            logger.info(" NUMERO DE DOCUMENTO: ");
            logger.info(msgTraza + "RESULTDO DE CREAR INTERESADO :"+"[RESULTADO>>>>: " +
                    resultMap.get("P_RESULTADO") + "]-\n"+
                    resultMap.get("P_CODIGO") + "]-\n"
            );
            logger.info("-------------------------------------------------");
            logger.info("---------END createInteresadosMpv--------------");
            logger.info("-------------------------------------------------");
        }
        catch (Exception ex) {
            logger.error(msgTraza + "Exception[ERROR] : " ,ex);
            ex.printStackTrace();
            String error = (ex + Constantes.CADENA_VACIA);
            responseoBean.setIdInteresado(0);
            throw new DaoException("Error al recuperar la informacion:", "", ex);
        }
        finally {
            logger.info(msgTraza + "==Fin del metodo createTramiteExterno ");
        }
        return responseoBean;
    }

    private ArchivoAnexo downloadDataFile(TramiteBean tb){
        logger.info("----------ingreso al m:ArchivoAnexo--------");
        ArchivoAnexo aa=new ArchivoAnexo();
        aa.setIdArchivo(0);
        aa.setSecuenciaSeguimiento(0);
        aa.setTipoArchivo(2);
        aa.setNombreArchivo(tb.getDocuPrincipal().getDocumNobre());
        aa.setFile(convertBase64ToBlob(tb.getDocuPrincipal().getDocumbase64()));
        aa.setTextoOcr("");
        aa.setTamanoArchivo(tb.getDocuPrincipal().getDocumTamanio());
        aa.setContenType(tb.getDocuPrincipal().getDocumContentType());
        aa.setDescripcion("");
        aa.setIdUsuario(tb.getpIdUsuarioRegistra());
        aa.setTipoDocumento(1);
        aa.setIdDependencia(tb.getIdAreaProceso());
        aa.setFechaDocumento(new Date());
        aa.setCorrelativo(1);
        aa.setFirmaDigital("");
        aa.setFlagjerarquia(tb.getDocuPrincipal().getFlagjerarquia());
        return aa;
    }

    private byte[] convertBase64ToBlob(String base64_str){
        logger.info("----------ingreso al m:convertBase64ToBlob--------");
        byte[] de = new byte[0];
        logger.info(" INPUT: " + base64_str);
        try {
            de = Base64.decode(base64_str);
            logger.info("OUPUT: " + de);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("---------FIN m:convertBase64ToBlob--------");
        return de;
    }
}
