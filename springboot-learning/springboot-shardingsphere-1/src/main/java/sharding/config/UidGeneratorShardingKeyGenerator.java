package sharding.config;

import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.util.Properties;

/**
 * 1：不配置com.baomidou.mybatisplus.annotation.IdType会导致shardingjdbc配置的主键生成策略失效
 */
public class UidGeneratorShardingKeyGenerator implements ShardingKeyGenerator {

    public static Integer ID_START=18;

    @Override
    public Comparable<?> generateKey() {
        return null;
    }

    @Override
    public String getType() {
        return "UidGenerator";
    }

    @Override
    public Properties getProperties() {
        Properties val = new Properties();
        val.setProperty("name", "22");
        return val;
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
