import javafx.scene.control.Label;

public class CPU extends Thread{ 
    private Label choix_parite;
    private Label choix_nombre;
    private int nombre;
    private String prediction;
    
    public CPU(Label choix_parite, Label choix_nombre, String prediction,int nombre) {
        this.choix_parite = choix_parite;
        this.choix_nombre = choix_nombre;
        this.prediction = prediction;
        this.nombre = nombre;
    }

    public CPU(Label choix_parite, Label choix_nombre, String prediction) {
        this.choix_parite = choix_parite;
        this.choix_nombre = choix_nombre;
        this.prediction = prediction;
        this.nombre = -1;
    }
    public int getNombre() {
        return nombre;
    }
    public String getPrediction() {
        return prediction;
    }
    public void run(){
        try
        {
            sleep((int)(Math.random()*10));
        }
        catch(InterruptedException ie){ System.out.println(ie.getMessage());}
        if (nombre==-1) {nombre = (int)(Math.random()*10); }
        choix_parite.setText(choix_parite.getText()+ prediction);
        choix_nombre.setText(choix_nombre.getText()+ String.valueOf(nombre));
    }
    
}  