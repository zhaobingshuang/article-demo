package org.example;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {

    private String carInfo;

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    @Override
    public Car getObject() throws Exception {
        String carInfo = getCarInfo();
        String[] info = carInfo.split(",");
        Car car = new Car();
        car.setMaxSpeed(Integer.parseInt(info[1]));
        car.setBrand(info[0]);
        car.setPrice(Double.parseDouble(info[2]));

        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
