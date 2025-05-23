package co.edu.uco.onlinetest.data.dao.factory;

import co.edu.uco.onlinetest.crosscutting.excepciones.DataOnlineTestException;
import co.edu.uco.onlinetest.crosscutting.excepciones.OnlineTestException;
import co.edu.uco.onlinetest.data.dao.entity.Departamento.DepartamentoDao;
import co.edu.uco.onlinetest.data.dao.entity.ciudad.CiudadDao;
import co.edu.uco.onlinetest.data.dao.entity.pais.PaisDao;
import co.edu.uco.onlinetest.data.dao.factory.azuresql.AzureSQLDAOFactory;


public abstract class  DAOFactory{


    public static DAOFactory getFactory(Factory factory) throws OnlineTestException {

        switch (factory){
            case AZURE_SQL: {
                return new AzureSQLDAOFactory();
            }
            default:

                var mensajeUsuario = "Se ha presentado un problema tratando de obtener la infomacion de la fuente de datos ";
                var mensajeTecnico = "se solicito la factoria"+ factory+"pero esta no esta implementada";
                throw DataOnlineTestException.reportar(mensajeUsuario,mensajeTecnico);

        }
    }




    public abstract void abrirConexion() throws OnlineTestException;

    public abstract void iniciartransaccion() throws OnlineTestException ;

    public abstract void confirmartransaccion() throws OnlineTestException;

    public abstract void cancelartransaccion() throws OnlineTestException;

    public abstract void cerrarConexion() throws OnlineTestException;



    public abstract PaisDao getPaisDAO() throws OnlineTestException;

    public abstract DepartamentoDao getDepartamentoDAO() throws OnlineTestException;

    public abstract CiudadDao getCiudadDAO() throws OnlineTestException;


}
