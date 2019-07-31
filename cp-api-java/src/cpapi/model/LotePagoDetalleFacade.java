package cpapi.model;

import cpapi.entities.LotePagoDetalle;
import cpapi.entities.LotePagoEncabezado;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class LotePagoDetalleFacade extends AbstractFacade<LotePagoDetalle> {

    private static final String ORDER_COLUMN = "id";
    @PersistenceContext(unitName = "HTP")
    private EntityManager em = null;

    public LotePagoDetalleFacade() {
        super(LotePagoDetalle.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected String getOrderColumn() {
        return ORDER_COLUMN;
    }

    public List<LotePagoDetalle> findByLoteEncabezado(LotePagoEncabezado lotePagoEncabezado) {
        List<LotePagoDetalle> resultado;
        Query q;
        try {
            String sql = "select * from lote_pago_detalle d where " +
                    "d.id_lote = " + lotePagoEncabezado.getId() + " " +
                    "order by d.estado_id";
            q = em.createNativeQuery(sql, LotePagoDetalle.class);
            resultado = q.getResultList();
        } catch (Exception e) {
            resultado = null;
        }
        return resultado;
    }

}