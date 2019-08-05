package cpapi.model;

import cpapi.entities.LoteEnvio;
import cpapi.entities.LotePagoEncabezado;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class LotePagoEncabezadoFacade extends AbstractFacade<LotePagoEncabezado> {

    private static final String ORDER_COLUMN = "id";
    @PersistenceContext(unitName = "HTP")
    private EntityManager em = null;

    public LotePagoEncabezadoFacade() {
        super(LotePagoEncabezado.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected String getOrderColumn() {
        return ORDER_COLUMN;
    }

    public List<LotePagoEncabezado> findByLoteEnvio(LoteEnvio loteEnvio) {
        List<LotePagoEncabezado> resultado;
        Query q;
        try {
            String sql;
            if (loteEnvio != null) {
                sql = "select * from lote_pago_encabezado f where " +
                        "f.lote_envio_id = " + loteEnvio.getId() + " " +
                        "order by f.fecha_registro desc ";
            } else {
                sql = "select * from lote_pago_encabezado f where " +
                        "f.lote_envio_id is null " +
                        "order by f.fecha_registro desc ";
            }
            q = em.createNativeQuery(sql, LotePagoEncabezado.class);
            resultado = q.getResultList();
        } catch (Exception e) {
            resultado = null;
        }
        return resultado;
    }

}