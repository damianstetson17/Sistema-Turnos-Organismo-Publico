
package main;


import controlador.*;

import modelo.*;

import errores.NotificarError;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import vista.Inicioo;


public class TrabajoFinal {

   
    public static void main(String[] args) throws NotificarError {
                
                Controlador controlador =null;
		Persistencia persistencia=null;
                   
		try {

			persistencia= new Persistencia();     
                        controlador = new Controlador(persistencia);

               /*       //tipoTramites
                        controlador.crearUnTipoTramite("deposito");
                        controlador.crearUnTipoTramite("pago de cuentas");
                        
                        TipoTramite tipoTramDeposito=controlador.buscarUnTipoTramite("deposito");
                        TipoTramite tipoTramPagosDeudas=controlador.buscarUnTipoTramite("pago de cuentas");
                        
                        //tipoTramites de area
                        List<TipoTramite> tipostramsAreaCaja= new ArrayList<>();
                        tipostramsAreaCaja.add(tipoTramDeposito);
                        
                        List<TipoTramite> tipostramsAreaDeudas= new ArrayList<>();
                        tipostramsAreaDeudas.add(tipoTramPagosDeudas);
                        
                        //Areas
                        controlador.crearUnArea("caja", tipostramsAreaCaja);
                        controlador.crearUnArea("deudas", tipostramsAreaDeudas);
                     
                        
                        //Requisitos
                        controlador.crearUnRequisito("fotocopia dni");
                        controlador.crearUnRequisito("cbu");
                        controlador.crearUnRequisito("clave cuenta corriente");
                        controlador.crearUnRequisito("fotocopia de boleta");
                        controlador.crearUnRequisito("factura");
                        controlador.crearUnRequisito("constancia de alumno regular");
                        controlador.crearUnRequisito("fotocopia dni alumno");
                        
                        Requisito reqDNI=controlador.buscarRequisito("fotocopia dni");
                        Requisito reqCBU=controlador.buscarRequisito("cbu");
                        Requisito reqBoleta=controlador.buscarRequisito("fotocopia de boleta");
                        Requisito reqFactura=controlador.buscarRequisito("factura");
                        Requisito reqConstancia=controlador.buscarRequisito("constancia de alumno regular");
                        Requisito reqDNIAlumno=controlador.buscarRequisito("fotocopia dni alumno");

                        //listado requisitos de tramites
                        
                        //caja ahorro
                        List<Requisito> requisCajaAhorro= new ArrayList<>();
                        requisCajaAhorro.add(reqDNI);
                        requisCajaAhorro.add(reqCBU);
                        
                        //cuenta corriente
                        List<Requisito> requisCuentaCorriente= new ArrayList<>();
                        requisCuentaCorriente.add(reqDNI);
                        requisCuentaCorriente.add(reqCBU);
                        
                        //pago telefono
                        List<Requisito> requisPagoTelefono= new ArrayList<>();
                        requisPagoTelefono.add(reqDNI);
                        requisPagoTelefono.add(reqBoleta);
                        requisPagoTelefono.add(reqFactura);
                        
                        //pago luz
                        List<Requisito> requisPagoLuz= new ArrayList<>();
                        requisPagoLuz.add(reqDNI);
                        requisPagoLuz.add(reqBoleta);
                        requisPagoLuz.add(reqFactura);
                        
                        //pago agua                       
                        List<Requisito> requisPagoAgua= new ArrayList<>();
                        requisPagoAgua.add(reqDNI);
                        requisPagoAgua.add(reqBoleta);
                        requisPagoAgua.add(reqFactura);
                        
                        //pago escolar
                        List<Requisito> requisPagoEscolar= new ArrayList<>();
                        requisPagoEscolar.add(reqDNI);
                        requisPagoEscolar.add(reqConstancia);
                        requisPagoEscolar.add(reqDNIAlumno);
                        
                        //Tramites
                        //de area deposito
                        controlador.crearUnTramite(0, "caja de ahorro", "deposito", requisCajaAhorro);
                        controlador.crearUnTramite(1, "cuneta corriente", "deposito", requisCuentaCorriente);
                        //de area pago de cuentas
                        controlador.crearUnTramite(2, "telefono", "pago de cuentas", requisPagoTelefono);
                        controlador.crearUnTramite(3, "luz", "pago de cuentas", requisPagoLuz);
                        controlador.crearUnTramite(4, "agua", "pago de cuentas", requisPagoAgua);
                        controlador.crearUnTramite(5, "escolar", "pago de cuentas", requisPagoEscolar);
                        
                        //supervisores
                        //de caja
                        controlador.crearUnSupervisor("damian", "stetson", 41700097, "caja");
                        //deudas
                        controlador.crearUnSupervisor("angeles", "piotroski", 41936338, "deudas");
                      
                        
                        //empleados
                        //de caja
                        controlador.crearUnEmpleado("ruben", "meinchs", 41936335, "caja");
                        controlador.crearUnEmpleado("micaela", "gomez", 41936336, "caja");
                        //deudas
                        controlador.crearUnEmpleado("julian", "montenegro", 41700091, "deudas");
                        controlador.crearUnEmpleado("belen", "lopez", 41700092, "deudas");
                        
                        //usuarios
			controlador.crearUnUsuario("angeles12", "123");
                        Usuario us = controlador.buscarUnUsuario("angeles12");
                        //clientes con su usuario
                        controlador.crearUnCliente("angeles", "britez", 41936336, true, us);
                        Cliente cli = controlador.buscarUnCliente(41936336);
                       
                        //estados turno
                        controlador.crearUnEstadoTurno("baja");
                        controlador.crearUnEstadoTurno("en espera");
                        controlador.crearUnEstadoTurno("atendido");
                        controlador.crearUnEstadoTurno("atendiendo");
                        controlador.crearUnEstadoTurno("para atencion");
                        
                        //prioridades turnos
                        controlador.crearUnaPrioridad("embarazada", 1);
                        controlador.crearUnaPrioridad("con capacidades reducidas", 2);
                        controlador.crearUnaPrioridad("acompañada de menores", 3);
                        controlador.crearUnaPrioridad("anciano", 4);    
                */       
                       Inicioo ventana = new Inicioo(controlador);
                       
                    } catch (NotificarError e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
                        System.out.println(e.getMessage());

			
		}

	}


        
    }
    
