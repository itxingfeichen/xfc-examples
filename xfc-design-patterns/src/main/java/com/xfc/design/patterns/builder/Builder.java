package com.xfc.design.patterns.builder;

/**
 * 构建器
 *
 * @author xf.chen
 * @date 2020/11/2 15:00
 * @since 1.2.0
 */
public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
