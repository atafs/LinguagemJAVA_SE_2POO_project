package modules.patterns.factory.cars.types;

import modules.patterns.factory.cars.enums.CarType;

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
