# StudySpring
// 테스트코드

POST http://localhost:8080/member/
Content-Type: application/json

{
  "name": "짱구"
}

###
POST http://localhost:8080/item
Content-Type: application/json

{
  "name": "휴지",
  "count": 5
}

###
POST http://localhost:8080/order
Content-Type: application/json

{
  "memberId": 1,
  "itemName": "휴지",
  "count": 2,
  "address": "서울"
}

###
GET http://localhost:8080/order/member/1
