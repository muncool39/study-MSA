# Service Discovery 서비스 디스커버리
- MSA에서 각 서비스의 위치를 동적으로 관리하고 찾아주는 기능
- 각 서비스에 대한 정보를 등록 서버에 저장하고 서비스 호출 시 맞는 서비스 서버로 전달해주는 미들웨어
- 서비스 등록 및 조회, 헬스 체크 등

## Eureka
- 넷플릭스가 개발한 서비스 디스커버리 서버
- 모든 서비스 인스턴스의 위치를 저장하는 중앙 저장소 역할
- 서비스 인스턴스릐 상태를 주기적으로 확인하여 가용성을 보장


## 실습 내용
### Eureka server 하나에 같은 기능을 하는 인스턴스 2개를 연결해 본다.
![구성](/images/practice_eureka.png)

**유레카 서버 설정**
- Eureka Service 의존성 추가
- @EnableEurekaServer

**유레카 클라이언트 설정**
- Eureka Discovery Client 의존성 추가

그 외 자세한 내용은 application.propertices의 주석을 참고!

**실행 결과**
- 유레카 서버를 실행
![유레카서버](/images/eureka_server_19090.png)

- 클라이언트 서버를 실행
![유레카클라이언트](/images/eureka_server_19090_connect.png)
오류 메세지는 갱신 시간이 설정되지 않아 실제 보이는 값보다 상태가 예전이라는 경고.