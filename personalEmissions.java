/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author myrea
 */
public class personalEmissions {
    
     private double carKm;
    private int busTrips;
    private int flights;
    private String dietType;
    private double houseSize;
    private String heatingType;
    
    public personalEmissions(double carKm, int busTrips, int flights, String dietType, double houseSize, String heatingType){
        this.carKm=carKm;
        this.busTrips= busTrips;
        this.flights=flights;
        this.dietType=dietType;
        this.houseSize=houseSize;
        this.heatingType=heatingType;
    }
    
        public double getCarKm() {
        return carKm;
    }
    public int getBusTrips() {
        return busTrips;
    }
    public int getFlights() {
        return flights;
    }
    public String getDietType() {
        return dietType;
    }
    public double getHouseSize() {
        return houseSize;
    }
    public String getHeatingType() {
        return heatingType;
    }
    
    
    
        public void setCarKm(double carKm) {
        this.carKm = carKm;
    }
    public void setBusTrips(int busTrips) {
        this.busTrips = busTrips;
    }
    public void setFlights(int flights) {
        this.flights = flights;
    }
    public void setDietType(String dietType) {
        this.dietType = dietType;
    }
    public void setHouseSize(double houseSize) {
        this.houseSize = houseSize;
    }
    public void setHeatingType(String heatingType) {
        this.heatingType = heatingType;
    }
    
    

    public double calculatorResult(){
        //this is all in kg 
        double total = 0;
            
        //car
        total = total +(carKm * 0.21 *52); //0.21 kg = a 1km trip so each km times that per week then times 52 is equal to years worth of car trips
        
        //public transport
        total = total +(busTrips * 1.5 * 52);//rough guess of 1.5kg worth of co2 for public transport every week by a year
        
        //flighst
        total = total + (flights * 250);
        
        //orgininally was asiing people for their kwt electric but no one would know that so now its house size and heating type 
         total = total + (houseSize *500);
         if(heatingType.equalsIgnoreCase("electric")){
             total = total + 800;
         }else if(heatingType.equalsIgnoreCase("gas")){
             total = total + 600;
         } else if(heatingType.equalsIgnoreCase("renewable")){
             total = total + 200;
         }else{
              throw new IllegalArgumentException("please enter valid heat type");
         }
         
         //diet
         if (dietType.equalsIgnoreCase("meat")) {
             total += 800;
         } else if (dietType.equalsIgnoreCase("vegetarian")) {
             total += 400; 
         } else if (dietType.equalsIgnoreCase("vegan")) { 
             total += 200; 
         }else{
              throw new IllegalArgumentException("please enter avlid diet");
         }
    
         return total;
    }
}
