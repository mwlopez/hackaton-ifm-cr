package cpapi.jobs;

import cpapi.entities.LoteEnvio;
import cpapi.entities.LotePagoEncabezado;
import cpapi.model.*;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Startup
@Singleton
public class ProcessBatchEnvio implements Serializable {

    @EJB
    private LotePagoEncabezadoFacade lotePagoEncabezadoFacade;
    @EJB
    private LoteEnvioFacade loteEnvioFacade;
    @EJB
    private LotePagoDetalleFacade lotePagoDetalleFacade;
    @EJB
    private BeneficiarioFacade beneficiarioFacade;

    public ProcessBatchEnvio() {
    }

    @Schedule(minute = "*/1", hour = "*", info = "CP-API-BATCH", persistent = false)
    public void notificaBeneficiarios() {
        System.gc();
        System.out.println("ACTIVA LOTE BATCH");
        List<LotePagoEncabezado> encabezados = lotePagoEncabezadoFacade.findByLoteEnvio(null);
        LoteEnvio loteEnvio = new LoteEnvio();
        loteEnvio.setEstado("TERMINADO");
        loteEnvio.setFecha(new Timestamp(System.currentTimeMillis()));
        loteEnvio.setLoteSinpe(1);
        for (LotePagoEncabezado lp : encabezados) {
            lp.setLoteEnvioByLoteEnvioId(loteEnvio);
            OperationStatus op = new OperationStatus();
            lotePagoEncabezadoFacade.edit(lp, op);
            System.out.println("RESULTADO " + op.isOk());
        }
    }
}
