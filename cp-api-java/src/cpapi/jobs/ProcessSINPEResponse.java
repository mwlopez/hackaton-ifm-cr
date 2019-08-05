package cpapi.jobs;

import cpapi.entities.BeneficiarioDemo;
import cpapi.entities.LoteEnvio;
import cpapi.entities.LotePagoDetalle;
import cpapi.entities.LotePagoEncabezado;
import cpapi.model.*;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.Serializable;
import java.util.List;

@Startup
@Singleton
public class ProcessSINPEResponse implements Serializable {

    @EJB
    private LotePagoEncabezadoFacade lotePagoEncabezadoFacade;
    @EJB
    private LoteEnvioFacade loteEnvioFacade;
    @EJB
    private LotePagoDetalleFacade lotePagoDetalleFacade;
    @EJB
    private BeneficiarioFacade beneficiarioFacade;

    public ProcessSINPEResponse() {
    }

    @Schedule(minute = "*/1", hour = "*", info = "CP-API-SINPE", persistent = false)
    public void procesaRespuestaSINPE() {
        System.gc();
        OperationStatus op;
        BeneficiarioDemo bf;
        List<LoteEnvio> lotesEnvio = loteEnvioFacade.findByEstado("TERMINADO");
        System.out.println("LOTES SINPE RESPUESTA " + lotesEnvio.size());
        for (LoteEnvio le : lotesEnvio) {
            System.out.println("PROCESANDO LOTE RESPUESTA: " + le.getId());
            for (LotePagoEncabezado lp : lotePagoEncabezadoFacade.findByLoteEnvio(le)) {
                System.out.println("NOTIFICANDO A " + lp.getId() + " ENTIDAD " + lp.getEntidad());
                List<LotePagoDetalle> detalles = lotePagoDetalleFacade.findByLoteEncabezado(lp);
                System.out.println("TOTAL REGISTROS " + detalles.size());
                for (LotePagoDetalle d : detalles) {
                    if (d.getResponse().equals("Aceptado"))
                        if (Math.random() > 0.1) {
                            d.setResponse("SINPE-OK");
                        } else {
                            d.setResponse("Rechazado");
                        }
                    op = new OperationStatus();
                    lotePagoDetalleFacade.edit(d, op);
                }
            }
            le.setEstado("SINPE-RES");
            OperationStatus ops = new OperationStatus();
            loteEnvioFacade.edit(le, ops);
            System.out.println("RESULTADO " + ops.isOk());
        }

    }

}
