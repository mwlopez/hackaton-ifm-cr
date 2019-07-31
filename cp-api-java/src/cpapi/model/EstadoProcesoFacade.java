package cpapi.model;

import cpapi.entities.EstadoprocesoDemo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EstadoProcesoFacade extends AbstractFacade<EstadoprocesoDemo> {

    private static final String ORDER_COLUMN = "nombre";
    @PersistenceContext(unitName = "HTP")
    private EntityManager em = null;

    public EstadoProcesoFacade() {
        super(EstadoprocesoDemo.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected String getOrderColumn() {
        return ORDER_COLUMN;
    }
}