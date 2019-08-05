package cpapi.model;

import cpapi.utilities.Logger;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

/**
 * @author alv-ar-o @aaocr
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity, OperationStatus status) {
        try {
            String validations = constraintValidationsDetected(entity);
            if (validations == null) {
                getEntityManager().persist(entity);
                getEntityManager().flush();
                getEntityManager().clear();
            } else {
                Logger.logThis(this, "ERROR revisando requisitos: " + validations);
            }
        } catch (Exception e) {
            Logger.logThis(this, "ERROR de persistencia ", e);
            status.setMessage("error creando registro ");
            status.setOk(false);
        }
    }

    private String constraintValidationsDetected(T entity) {
        StringBuilder validation = new StringBuilder();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<T> cv : constraintViolations) {
                validation.append(cv.getRootBeanClass().getName()).append(".").append(cv.getPropertyPath()).append(" ").append(cv.getMessage());
            }
            return validation.toString();
        } else {
            return null;
        }
    }

    public abstract EntityManager getEntityManager();

    public void edit(T entity, OperationStatus status) {
        try {
            String validations = constraintValidationsDetected(entity);
            if (validations == null) {
                getEntityManager().merge(entity);
                getEntityManager().flush();
                getEntityManager().clear();
            } else {
                Logger.logThis(this, "ERROR revisando requisitos: " + validations);
            }
        } catch (Exception e) {
            Logger.logThis(this, "ERROR de persistencia", e);
            status.setMessage("error guardando registro");
            status.setOk(false);
        }
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(entityClass);
        Root<T> c = cq.from(entityClass);
        cq.select(cq.from(entityClass));
        cq.orderBy(cb.asc(c.get(getOrderColumn())));
        return getEntityManager().createQuery(cq).getResultList();
    }

    protected abstract String getOrderColumn();

    public void refresh(T entity) {
        getEntityManager().refresh(entity);
    }

    public void remove(T entity, OperationStatus status) {
        try {
            getEntityManager().remove(getEntityManager().merge(entity));
            getEntityManager().flush();
        } catch (Exception ex) {
            Logger.logThis(this, "ERROR de persistencia", ex);
            status.setMessage("error eliminando registro " + ex.getMessage());
            status.setOk(false);
        }
    }
}
