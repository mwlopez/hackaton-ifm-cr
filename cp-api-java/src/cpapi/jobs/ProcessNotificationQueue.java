package cpapi.jobs;

import cpapi.entities.BeneficiarioDemo;
import cpapi.entities.LoteEnvio;
import cpapi.entities.LotePagoDetalle;
import cpapi.entities.LotePagoEncabezado;
import cpapi.model.*;
import cpapi.utilities.Common;
import cpapi.utilities.Email;
import cpapi.utilities.SMSSender;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.Serializable;
import java.util.List;

@Startup
@Singleton
public class ProcessNotificationQueue implements Serializable {

    @EJB
    private LotePagoEncabezadoFacade lotePagoEncabezadoFacade;
    @EJB
    private LoteEnvioFacade loteEnvioFacade;
    @EJB
    private LotePagoDetalleFacade lotePagoDetalleFacade;
    @EJB
    private BeneficiarioFacade beneficiarioFacade;

    public ProcessNotificationQueue() {
    }

    @Schedule(second = "10,20,30,40,50", minute = "*", hour = "*", info = "CP-API-PNQ", persistent = false)
    public void notificaBeneficiarios() {
        System.gc();
        BeneficiarioDemo bf;
        System.out.println("LOTES PROCESAR " + lotePagoEncabezadoFacade.findAll().size());
        List<LoteEnvio> lotesEnvio = loteEnvioFacade.findByEstado("SINPE-RES");
        String cedula = null;
        String nombre = null;
        String telefono = null;
        String email = null;
        String programa = null;
        String monto = null;
        String sms = null;
        String html = null;
        System.out.println("LOTES ENVIO " + lotesEnvio.size());
        for (LoteEnvio le : lotesEnvio) {
            System.out.println("PROCESANDO LOTE ENVIO: " + le.getId());
            for (LotePagoEncabezado lp : lotePagoEncabezadoFacade.findByLoteEnvio(le)) {
                System.out.println("NOTIFICANDO A " + lp.getId() + " ENTIDAD " + lp.getEntidad());
                List<LotePagoDetalle> detalles = lotePagoDetalleFacade.findByLoteEncabezado(lp);
                System.out.println("TOTAL REGISTROS " + detalles.size());
                for (LotePagoDetalle d : detalles) {
                    cedula = d.getIdentificacion();
                    nombre = (d.getFirstName().trim() + " " + d.getLastName().trim()).toUpperCase();
                    bf = beneficiarioFacade.findByCedula(d.getIdentificacion().trim());
                    if (bf != null) {
                        telefono = bf.getTelefono();
                        email = bf.getEmail();
                    } else {
                        telefono = null;
                        email = null;
                    }
                    programa = d.getProgram().toUpperCase();
                    monto = Common.formatDoubleCurrency("₡", d.getValue());
                    System.out.println("cedula " + cedula + " nombre " + nombre +
                            " teléfono " + telefono + " email " + email + " programa " + programa +
                            " monto " + monto);

                    if (d.getResponse().equals("SINPE-OK")) {
                        if (telefono != null) {
                            /* NOTIFICACION POR SMS Y A LA API DE BILLETERA */
                            sms = "MH TRANSFERENCIA A " + cedula + " " + programa + " MONTO " + monto + " EXITOSA";
                            System.out.println("SMS A " + cedula + " TEL " + telefono);
                            SMSSender.send(telefono, sms);
                        }
                        if (Email.isValidEmail(email)) {
                            /* NOTIFICACION POR SMS Y A LA API DE BILLETERA */
                            html = "<strong>NOTIFICACIÓN DE PAGO</strong><br/>";
                            html += "CEDULA: " + cedula + "<br/>";
                            html += "NOMBRE: " + nombre + "<br/>";
                            html += "PROGRAMA: " + programa + "<br/>";
                            html += "FECHA: " + Common.getDateStr() + "<br/>";
                            html += "MONTO: " + monto + "<br/>";
                            System.out.println("EMAIL A " + cedula + " TEL " + email);
                            Email.send(email, "MH NOTIFICACION DE PAGO", html, null);
                        }
                    }
                }
            }
            le.setEstado("NOTIFICADO");
            OperationStatus op = new OperationStatus();
            loteEnvioFacade.edit(le, op);
            System.out.println("RESULTADO " + op.isOk());
        }
    }
}
