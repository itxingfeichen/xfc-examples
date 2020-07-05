package sharding;

import org.apache.shardingsphere.core.yaml.config.sharding.YamlShardingRuleConfiguration;
import org.apache.shardingsphere.core.yaml.config.sharding.YamlTableRuleConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * 分表测试启动类
 *
 * @author xf.chen
 * @date 2020/6/29 11:21
 * @since 1.2.0
 */
@SpringBootApplication
@MapperScan("sharding.mapper")
public class ShardingBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ShardingBootstrap.class);
        YamlShardingRuleConfiguration ruleConfiguration = run.getBean(YamlShardingRuleConfiguration.class);
        Map<String, YamlTableRuleConfiguration> tables = ruleConfiguration.getTables();
        System.out.println("tables = " + tables);
    }

    // 监听spring容器启动完成事件
}
