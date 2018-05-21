package com.atguigu.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 *  自定义ribbon 服务器负载均衡算法（每个人服务器访问5在访问下一个服务器）
 * @author zhaoyangyang
 *
 */
public class RandomRule_ZY extends AbstractLoadBalancerRule{
	
	private int total = 0; 			// 总共被调用的次数，目前要求每台被调用5次
	private int currentIndex = 0;	// 当前提供服务的机器号
	
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();//可用服务器
            List<Server> allList = lb.getAllServers();//总共服务器

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

           // int index = rand.nextInt(serverCount);
           // server = upList.get(index);

            if(total<5) {
            	server = upList.get(currentIndex);
            	total++;
            }else {
            	total=0;
            	currentIndex++;
            	if (currentIndex >=upList.size()){
            		currentIndex=0;
            	}
            }
            
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }
            System.out.println(currentIndex+":"+server.getHostPort()+":"+server.getHostPort()+""+server.getMetaInfo());

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }
    
    @Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub
		
	}
}
