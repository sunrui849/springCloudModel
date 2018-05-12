1. eurker-center-1 \ eurker-center-1 提供了eurker服务端，并注册双实例
2. config-server-1 \ config-server-2 提供了配置中心的服务，并注册双实例，采用读取github上的配置，为共有仓库
3. feign-service-1 \ feign-service-2 提供了feign的方式负载均衡的调用服务
4. ribbon-service-1 \ribbon-service-2 提供了ribbon的方式负载均衡的调用服务
5. service-1 \ service-2 提供了服务，并service-1采用了配置中心的配置
6. hystrix-dashboard 提供了监控页面
7. zuul-1 提供了通用网关