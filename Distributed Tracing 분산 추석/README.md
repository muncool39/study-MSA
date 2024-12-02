# Distributed Tracing 분산 추석
분산 시스템에서의 트랜잭션 추적을 위한 기능

## Zipkin


## 실습 내용
### Zipkin 정보 확인 실습

- build.gradle 에 zipkin 관련 의존성 추가
- 도커에서 zipkin 실행
```Shell
docker run -d -p 9411:9411 openzipkin/zipkin
```
- zipkin 처음 화면
![](./images/zipkin_before.JPG)

- order 요청 
![](./images/request_order.JPG)

- 요청 후 zipkin 확인
![](./images/zipkin_after.JPG)
![](./images/zipkin_detail.JPG)
![](./images/zipkin_dependencies.JPG)