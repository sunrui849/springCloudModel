feign类似于controller的作用，作为服务的消费者，提供负载均衡能力，是用ribbon实现的
以下为通过zuul访问feign：
http://localhost:8765/feign-service-1/callGetMovieName?accessToken=a
http://localhost:8765/feign-service-1/callGetIP?accessToken=a

