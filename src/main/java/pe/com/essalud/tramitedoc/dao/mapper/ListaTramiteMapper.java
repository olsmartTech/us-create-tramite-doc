package pe.com.essalud.tramitedoc.dao.mapper;

import pe.com.essalud.tramitedoc.beans.DocumentBean;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ListaTramiteMapper implements RowMapper<DocumentBean>{

    @Override
    public DocumentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
        DocumentBean dep = new DocumentBean();
        dep.setTipo(rs.getString("TIPO"));
        dep.setItem(rs.getString("item"));
        dep.setClasep(rs.getString("clasep"));
        dep.setIdClaseTramite(rs.getLong("id_clase_tramite"));
        return dep;
    }

}
