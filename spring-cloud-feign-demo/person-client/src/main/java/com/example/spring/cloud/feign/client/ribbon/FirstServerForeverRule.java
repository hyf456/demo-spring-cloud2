package com.example.spring.cloud.feign.client.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * 自定义实现 {@link IRule}
 * @Author: hanyf
 * @Description:
 * @Date: 2019/4/11 16:35
 */
public class FirstServerForeverRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        Server server = null;
        ILoadBalancer loadBalancer = getLoadBalancer();
        //返回三个配置Server，即：
        //person-service.ribbon.listOfServers=http://localhost:9090,http://localhost:9090,http://localhost:9090
        List<Server> allServers = loadBalancer.getAllServers();

        return allServers.get(0);
    }
}
