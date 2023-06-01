/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package locadora_swing;
import java.util.ArrayList;
import model.DaoVeiculo;
import model.Veiculo;
import view.VeiculoView;
/**
 *
 * @author agp
 */
public class Locadora_Swing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoVeiculo daoVeiculo = new DaoVeiculo();
        ArrayList<Veiculo> veiculos = daoVeiculo.buscarTodos();
        for(Veiculo v : veiculos){
            System.out.println(v.getModelo()
                    + " - " + v.getMarca());
        }
        
        new VeiculoView().setVisible(true);
    }
    
    
}
