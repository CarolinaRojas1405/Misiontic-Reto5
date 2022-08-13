package utp.misiontic2022.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utp.misiontic2022.model.vo.CompraPorProveedorVo;
import utp.misiontic2022.util.JDBCUtilities;

public class CompraPorProveedorDao {

    public ArrayList<CompraPorProveedorVo> listar() throws SQLException {
        ArrayList<CompraPorProveedorVo> resp = new ArrayList<CompraPorProveedorVo>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT C.ID_Compra, P.Constructora, P.Banco_Vinculado FROM Compra AS C JOIN Proyecto AS P ON (P.ID_Proyecto = C.ID_Proyecto) WHERE P.Ciudad = 'Salento' AND C.Proveedor ='Homecenter';";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()) {
                CompraPorProveedorVo compra = new CompraPorProveedorVo(
                    rs.getInt("ID_Compra"),
                    rs.getString("Constructora"),
                    rs.getString("Banco_Vinculado")
                );

                resp.add(compra);
            }

            rs.close();
            stmt.close();


        } finally {
            if (conn != null) {
                conn.close();
            }
        }

        return resp;
    }
}
