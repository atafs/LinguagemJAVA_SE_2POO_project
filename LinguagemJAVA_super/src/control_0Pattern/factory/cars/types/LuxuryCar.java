package control_0Pattern.factory.cars.types;

import control_0Pattern.factory.cars.enums.CarType;

public class LuxuryCar extends Car{

    public LuxuryCar() {
        super(CarType.LUXURY);
        construct();
    }
 
    @Override
    public void construct() {
        System.out.println("Building luxury car");
        // add accessories
    }
}
