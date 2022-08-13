package utp.misiontic2022.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import utp.misiontic2022.model.vo.LiderPorCiudadVo;
import utp.misiontic2022.util.JDBCUtilities;

public class LiderPorCiudadDao {

    public ArrayList<LiderPorCiudadVo> listar() throws SQLException {

        ArrayList<LiderPorCiudadVo> resp = new ArrayList<LiderPorCiudadVo>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT L.ID_Lider, L.Nombre, L.Primer_Apellido, L.Ciudad_Residencia FROM Lider AS L ORDER BY L.Ciudad_Residencia;";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()) {
                LiderPorCiudadVo lider = new LiderPorCiudadVo(
                    rs.getInt("ID_Lider"),
                    rs.getString("Nombre"),
                    rs.getString("Primer_Apellido"),
                    rs.getString("Ciudad_Residencia")
                );

                resp.add(lider);
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
