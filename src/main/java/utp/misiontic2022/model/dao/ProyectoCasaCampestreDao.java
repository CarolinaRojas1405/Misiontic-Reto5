package utp.misiontic2022.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utp.misiontic2022.model.vo.ProyectoCasaCampestreVo;
import utp.misiontic2022.util.JDBCUtilities;

public class ProyectoCasaCampestreDao {

    public ArrayList<ProyectoCasaCampestreVo> listar() throws SQLException {

        ArrayList<ProyectoCasaCampestreVo> resp = new ArrayList<ProyectoCasaCampestreVo>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT P.ID_Proyecto, P.Constructora, P.Numero_Habitaciones, P.Ciudad FROM Proyecto AS P WHERE P.Ciudad IN('Santa Marta', 'Cartagena', 'Barranquilla') AND P.Clasificacion = 'Casa Campestre'; ";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()) {
                ProyectoCasaCampestreVo casa = new ProyectoCasaCampestreVo(
                    rs.getInt("ID_Proyecto"),
                    rs.getString("Constructora"),
                    rs.getDouble("Numero_Habitaciones"),
                    rs.getString("Ciudad")
                );

                resp.add(casa);
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
