import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {

        Object[] options = { "Convertir Divisas", "salir" };
        int eleccion = JOptionPane.showOptionDialog(null, "¿Que quieres hacer?", "Conversor",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (eleccion == 1) {
            JOptionPane.showMessageDialog(null, "Programa cerrado");
            System.exit(0);
        }
        if (eleccion == 0) {
            DecimalFormat formatearDivisas = new DecimalFormat("#.##");
            boolean seguirEjecucion = true;
            while (seguirEjecucion) {
                String[] opciones = { "Pesos a Euros", "Pesos a Dolares" };
                String cambios = (String) JOptionPane.showInputDialog(null, "Elige una opción : ",
                        "Conversor de monedas", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                String input = JOptionPane.showInputDialog(null, "Ingrese cantidad de Pesos:");
                double pesos;
                try {
                    pesos = Double.parseDouble(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Valor no válido");
                    continue; 
                }
                if (cambios.equals("Pesos a Euros")) {
                    double euros = pesos * 0.00023; 
                    JOptionPane.showMessageDialog(null, pesos + " Pesos colombianos son: "
                            + formatearDivisas.format(euros) + " Euros.");
                } else if (cambios.equals("Pesos a Dolares")) {
                    double dolares = pesos * 0.00025; 
                    JOptionPane.showMessageDialog(null, pesos + " Pesos colombianos son: "
                            + formatearDivisas.format(dolares) + " Dolares.");
                }
                int confirm = JOptionPane.showConfirmDialog(null, "¿Deseas continuar?", "Confirmar",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirm == JOptionPane.NO_OPTION || confirm == JOptionPane.CANCEL_OPTION) {
                    seguirEjecucion = false;
                    JOptionPane.showMessageDialog(null, "Programa finalizado");
                }
            }
        }
    }
}
