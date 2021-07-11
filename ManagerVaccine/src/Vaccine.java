/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SY NGUYEN
 */
public class Vaccine {
    
    protected String NameVaccine;
    protected String VaccineID;
    protected String VaccineProducer;
    protected String typeOfVaccine;
    protected int numberOfInjection;

    public Vaccine() {
    }

    public Vaccine(String NameVaccine, String VaccineID, String VaccineProducer, String typeOfVaccine, int numberOfInjection) {
        this.NameVaccine = NameVaccine;
        this.VaccineID = VaccineID;
        this.VaccineProducer = VaccineProducer;
        this.typeOfVaccine = typeOfVaccine;
        this.numberOfInjection = numberOfInjection;
    }

    public String getNameVaccine() {
        return NameVaccine;
    }

    public void setNameVaccine(String NameVaccine) {
        this.NameVaccine = NameVaccine;
    }

    public String getVaccineID() {
        return VaccineID;
    }

    public void setVaccineID(String VaccineID) {
        this.VaccineID = VaccineID;
    }

    public String getVaccineProducer() {
        return VaccineProducer;
    }

    public void setVaccineProducer(String VaccineProducer) {
        this.VaccineProducer = VaccineProducer;
    }

    public String getTypeOfVaccine() {
        return typeOfVaccine;
    }

    public void setTypeOfVaccine(String typeOfVaccine) {
        this.typeOfVaccine = typeOfVaccine;
    }

    public int getNumberOfInjection() {
        return numberOfInjection;
    }

    public void setNumberOfInjection(int numberOfInjection) {
        this.numberOfInjection = numberOfInjection;
    }

    @Override
    public String toString() {
        return "Vaccine{" + "NameVaccine=" + NameVaccine + ", VaccineID=" + VaccineID + ", VaccineProducer=" + VaccineProducer + ", typeOfVaccine=" + typeOfVaccine + ", numberOfInjection=" + numberOfInjection + '}';
    }
    
    
}
