package cpapi.model;

import cpapi.entities.LoteEnvio;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class LoteEnvioFacade extends AbstractFacade<LoteEnvio> {

    private static final String ORDER_COLUMN = "id";
    @PersistenceContext(unitName = "HTP")
    private EntityManager em = null;

    public LoteEnvioFacade() {
        super(LoteEnvio.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected String getOrderColumn() {
        return ORDER_COLUMN;
    }

    public List<LoteEnvio> findByEstado(String estado) {
        List<LoteEnvio> resultado;
        Query q;
        try {
            q = em.createNativeQuery("select * from lote_envio l where " +
                    "l.estado = '" + estado + "' " +
                    "order by l.fecha desc ", LoteEnvio.class);
            resultado = q.getResultList();
        } catch (Exception e) {
            resultado = null;
        }
        return resultado;
    }

}