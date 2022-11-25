## Endpoints

> 도서 목록 조회하는 기능

GET /api/v1/books

ex) http://localhost:8080/api/v1/books

> 각 Hospital과 병원의 리뷰 

1. 리뷰 등록 기능
   
POST /api/v1/hospitals/{id}/reviews
   
2. 리뷰 1개 조회하기

GET /api/v1/reviews/{id}

3. 해당 병원의 리뷰만 조회하는 기능

GET /api/v1/hospitals/{id}/reviews