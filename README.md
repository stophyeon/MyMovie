### MyMovie

## 프로젝트 설명
open API를 사용해 영화를 검색하고 로그인을 통해 좋아하는 영화를 등록하는 서비스입니다.

## 사용 기술
- Java/Spring
- MySQL
- Spring JPA
- SPring Securty
- Thymeleaf
## 서비스 설명

# 로그인
<img src ="https://github.com/stophyeon/MyMovie/assets/122667296/020771fe-4993-4256-a194-ebb91b7a9129">

로그인을 구현은 Spring Security를 사용했습니다 사용자를 인증하고 권한을 부여했습니다.

# 영화검색
<img src ="https://github.com/stophyeon/MyMovie/assets/122667296/63b871ee-0b6f-4d91-a5ac-7c916a3a756c">

영화의 제목을 Query로 보내서 API를 통해 검색한뒤 Json으로 받은 데이터들을 가공해서 보여줍니다

# 장르별 영화
<img src ="https://github.com/stophyeon/MyMovie/assets/122667296/642dbd54-cea2-47d6-9da7-a59888831e9c">

Query에 장르별 번호를 넣어서 검색한 결과입니다

# 내 영화 등록
<img src ="https://github.com/stophyeon/MyMovie/assets/122667296/e74f6c32-065f-44f8-9abe-327c70bee7cf">

DB에서 연관관계를 맺어서 사용자가 등록한 영화만을 DB에서 검색해서 보여줍니다 

# 배우 검색
<img src ="https://github.com/stophyeon/MyMovie/assets/122667296/4b2e8c49-e300-4f8f-8e4b-92a5d5fda2c8">

Query에 출연진의 정보를 넣어서 검색한 결과입니다

## DataBase ERD


## 아쉬웠던 부분
프로젝트를 진행하면서 아쉬 웠던 부분은 배포입니다. 처음 프로젝트를 시작할 때는 MSA구조로 배포할 생각이 없었지만
프로젝트 서비스를 완성하고 나니 MSA구조로 안정적인 서비스를 제공하고 싶은 생각이 들었습니다.
그러기 위해 Docker와 Kubernets를 공부하고 있습니다.
