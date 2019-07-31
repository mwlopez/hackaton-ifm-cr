package cpapi.model;

import cpapi.entities.BeneficiarioDemo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class BeneficiarioFacade extends AbstractFacade<BeneficiarioDemo> {

    private static final String ORDER_COLUMN = "id";
    @PersistenceContext(unitName = "HTP")
    private EntityManager em = null;

    public BeneficiarioFacade() {
        super(BeneficiarioDemo.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected String getOrderColumn() {
        return ORDER_COLUMN;
    }

    public BeneficiarioDemo findByCedula(String cedula) {
        BeneficiarioDemo resultado;
        Query q;
        try {
            String sql = "select * from beneficiario_demo b where b.numdocumento = '" + cedula + "'";
            q = em.createNativeQuery(sql, BeneficiarioDemo.class);
            resultado = (BeneficiarioDemo) q.getResultList().get(0);
        } catch (Exception e) {
            resultado = null;
        }
        return resultado;
    }

}