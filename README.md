## 📝 Bigs Back-End 개발자 실습 테스트

- 경기도 의정부시 문충로74 지역의 단기예보를 확인할 수 있는 API 를 작성하세요.

- 단기 예보 데이터는 공공데이터 포털의 `기상청_단기예보 ((구)_동네예보) 조회서비스` 를 사용하세요. 

- 이 과제는 서버간 API 연동에 대한 이해도를 확인합니다.  또한, 코드의 가독성을 통해 개발자의 코드 작성 기술과 방식을 파악합니다.

- 프로젝트를 작성할 때는 이러한 요구사항을 충족하는 것을 목표로 하세요.

<br/>

## 📁 프로젝트 구조

```
📦 root
├─ modules
│  ├─ application
│  │  ├─ inquire-application   
│  │  └─ sync-application
│  ├─ domain
│  │  └─ weather-domain
│  └─ internal
│     └─ weather-api
├─ build.gradle
└─ settings.gradle
```
- 우아한 테크세미나의 멀티 모듈 게시글을 참고하여 `애플리케이션 모듈 + 도메인 모듈 + 내부 모듈`로 구성하였습니다.

- (내부 모듈) `weather-api는 RestTemplate을 이용하여 공공 API를 호출하는 모듈`입니다. 

- (애플리케이션 모듈) `inquire-application은 단기 예보를 조회하는 모듈`이고, `sync-application은 단기 예보를 DB에 저장하는 모듈`입니다.

- (도메인 모듈) weather-domain은 각 애플리케이션 모듈에서 공통으로 사용하는 도메인 모듈입니다.

<br/>

## 🔍 기능 구현

- 단기 예보를 DB에 저장하게 하는 API
     
  - POST 요청 시, 공공 데이터 포털의 API를 호출하여 DB에 적재 📌 [[서비스]](https://github.com/akgkfk3/Short-Term-Forecast-Project/blob/main/modules/application/sync-application/src/main/java/com/bigs/service/SyncServiceImpl.java#L38) [[단기 예보 API]](https://github.com/akgkfk3/Short-Term-Forecast-Project/blob/main/modules/internal/weather-api/src/main/java/com/bigs/api/ForecastApi.java#L45)

- 단기 예보를 조회하는 API

  - GET 요청 시, DB에 저장된 데이터를 조회 📌 [[서비스]](https://github.com/akgkfk3/Short-Term-Forecast-Project/blob/main/modules/application/inquire-application/src/main/java/com/bigs/service/InquireServiceImpl.java#L28)
 
  - 데이터가 없을 경우, Http Status 204 오류를 응답 📌 [[컨트롤러]](https://github.com/akgkfk3/Short-Term-Forecast-Project/blob/main/modules/application/inquire-application/src/main/java/com/bigs/controller/InquireController.java#L36)

<br/>

## 🌟 트러블 슈팅

<table>
  	<tr>
  		<td align="center">
      			문제 상황  
    	</td>
		  <td>
      		공공 API의 인증키 (serviceKey) 값이 이상하게 인코딩 되어, API 응답이 오류가 발생
    	</td>
  	</tr>
	  <tr>
		<td align="center">
			원인
		</td>
		<td>
   			RestTemplate에서 HTTP 요청 보낼 때, URL 인코딩을 추가적으로 하게 되어 인증키 값이 변경 
    </td>
	</tr>
 	<tr>
     		<td align="center">
			해결
		</td>
		<td>
      			
```
// RestTemplate의 Encoding 모드를 None으로 변경하여 해결
public ForecastApi() {
        this.template = new RestTemplate();

        // %25 인코딩 방지
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory();
        uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
        template.setUriTemplateHandler(uriBuilderFactory);
}
```
 </td>
 </tr>
</table>


<br/>

## 📄 참고 문헌

- https://techblog.woowahan.com/2637/

- https://stackoverflow.com/questions/60574275/how-can-i-use-with-resttemplate
  
- https://lng1982.tistory.com/341


