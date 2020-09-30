package pe.com.essalud.tramitedoc.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.essalud.tramitedoc.beans.TipoPedido;
 
public class TipoPedidoMapper implements RowMapper<TipoPedido> {
	
	@Override
	public TipoPedido mapRow(ResultSet rs, int rowNum) throws SQLException {
		TipoPedido tp = new TipoPedido();
		tp.setIdTipoPed(rs.getLong("ID_TIPO_PED"));
		tp.setDescripcion(rs.getString("DESCRIPCION"));
		return tp;
	}
	
}