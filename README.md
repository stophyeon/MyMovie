### MyMovie

## 프로젝트 설명
open API를 사용해 영화를 검색하고 로그인을 통해 좋아하는 영화를 등록하는 서비스입니다.

## 사용 기술
- Java/Spring Boot
- MySQL
- Spring JPA
- Spring Securty
- Spring Cloud
## 서비스 설명

# 로그인
<img src ="https://github.com/stophyeon/MyMovie/assets/122667296/020771fe-4993-4256-a194-ebb91b7a9129">



# 영화검색
<img src ="https://github.com/stophyeon/MyMovie/assets/122667296/63b871ee-0b6f-4d91-a5ac-7c916a3a756c">



# 장르별 영화
<img src ="https://github.com/stophyeon/MyMovie/assets/122667296/642dbd54-cea2-47d6-9da7-a59888831e9c">


# 내 영화 등록
<img src ="https://github.com/stophyeon/MyMovie/assets/122667296/e74f6c32-065f-44f8-9abe-327c70bee7cf">



# 배우 검색
<img src ="https://github.com/stophyeon/MyMovie/assets/122667296/4b2e8c49-e300-4f8f-8e4b-92a5d5fda2c8">


## DataBase ERD
<img src="https://github.com/stophyeon/MyMovie/assets/122667296/2da63834-ecee-48ac-b530-1c251f9d08f4">

## 리팩토링
1. TMDB API 검색속도 - MovieSearchAPI 클래스의 메서드 내용중 중복되는 기능별로 메서도를 각각 정의, for문을 Stream으로 수정
                       결과) 제목으로 검색하는 속도 72ms -> 54ms

2. API 호출 부분 간결화를 위해 람다표현식으로 수정
3. API 호출로 불러온 Json형식의 데이터 JsonObject가 아닌 ObjectMapper를 사용해 반복적인 코드 개선
4. Spring Cloud를 적용=> API Gateway를 사용해 사용자 요청을 하나의 URL로 통합, Eureka Server를 사용해 Service들을 등록해서 API Gateway에서 URL 매핑을 지원, Config Server를 사용해 설정파일 통합관리하고 재실행없이 설정 변경 적용
5. 모놀리식 아키텍처에서 MSA구조로 변경

