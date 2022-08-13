package utp.misiontic2022.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import utp.misiontic2022.model.dao.CompraPorProveedorDao;
import utp.misiontic2022.model.dao.LiderPorCiudadDao;
import utp.misiontic2022.model.dao.ProyectoCasaCampestreDao;
import utp.misiontic2022.model.vo.CompraPorProveedorVo;
import utp.misiontic2022.model.vo.LiderPorCiudadVo;
import utp.misiontic2022.model.vo.ProyectoCasaCampestreVo;

public class RequestController {

    private LiderPorCiudadDao liderPorCiudadDao;
    private ProyectoCasaCampestreDao proyectoCasaCampestreDao;
    private CompraPorProveedorDao compraPorProveedorDao;

    public RequestController(){
        liderPorCiudadDao = new LiderPorCiudadDao();
        proyectoCasaCampestreDao = new ProyectoCasaCampestreDao();
        compraPorProveedorDao = new CompraPorProveedorDao();
    }

    public ArrayList<LiderPorCiudadVo> listarLiderPorCiudad() throws SQLException{
        return liderPorCiudadDao.listar();
    }

    public ArrayList<ProyectoCasaCampestreVo> listarProyectoCasaCampestre() throws SQLException{
        return proyectoCasaCampestreDao.listar();
    }

    public ArrayList<CompraPorProveedorVo> listarCompraPorProveedor() throws SQLException{
        return compraPorProveedorDao.listar();
    }
}
