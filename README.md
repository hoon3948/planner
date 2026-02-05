### 일정관리 어플!


api응답에서 비밀번호는 제외!
api 응답 순서 정렬 `@JsonPropertyOrder({"정렬순서대로 입력"})`
1. 일정생성
   - 일정 제목, 일정 내용, 작성자명, 비밀번호, 작성/수정일을 저장
   - planId 자동 생성하여 저장
2. 댓글 생성
   - 댓글 작성자, 댓글 내용, 비밀번호,작성/수정일, 일정 id 저장
   - 하나의 일정에 댓글은 10개까지
3. 일정 조회 
   - 수정일을 기준으로 정렬
   - 작성자명으로 필터링 가능
4. 일정 단건 조회
   - url의 id를 인식해서 조회
   - 해당 일정에 달린 댓글 함께 조회
5. 일정 단건 수정
   - 비밀번호 입력받고 일치하면 수정
   - 일정 제목, 작성자명만 수정 가능
6. 일정 단건 삭제
   - 비밀번호 확인받아서 일치하면 삭제

---

### API 명세서
https://documenter.getpostman.com/view/51111882/2sBXc7MkQH

---

### ERD
<img width="624" height="546" alt="image" src="https://github.com/user-attachments/assets/46076dfc-9a82-4fde-9370-78fd6f88cd71" />
