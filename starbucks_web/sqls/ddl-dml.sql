-- 스타벅스 공지사항 테이블
CREATE TABLE STARBUCKS_NOTICE (
	sno			NUMBER				PRIMARY KEY,		-- 공지사항 번호
	stitle		varchar2(200)		NOT NULL,   		-- 공지사항 제목	
	scontent 	clob				NOT NULL, 			-- 공지사항 내용
	sdate		DATE				DEFAULT sysdate,	-- 공지사항 등록일자
	scount      NUMBER				DEFAULT 0   		-- 공지사항 조회수
);

-- 스타벅스 공지사항 번호 시퀀스
CREATE SEQUENCE SEQ_SNO NOCACHE;

-- 스타벅스 공지사항 데스트 데이터
INSERT INTO STARBUCKS_NOTICE (sno, stitle, scontent, sdate, scount)
VALUES (SEQ_SNO.NEXTVAL, '공지사항 제목', '공지사항 내용', TO_DATE('2025-05-04', 'YYYY-MM-DD'), 0);
INSERT INTO STARBUCKS_NOTICE (sno, stitle, scontent, sdate, scount)
VALUES (SEQ_SNO.NEXTVAL, '매장 영업시간 변경', '일부 매장의 영업시간이 조정됩니다. 자세한 사항은 홈페이지를 참고해주세요.', TO_DATE('2025-06-11', 'YYYY-MM-DD'), 0);;
INSERT INTO STARBUCKS_NOTICE (sno, stitle, scontent, sdate, scount)
VALUES (SEQ_SNO.NEXTVAL, '멤버십 리워드 변경', '멤버십 리워드 제도가 새롭게 바뀌었습니다. 혜택을 꼭 확인하세요!', TO_DATE('2025-06-12', 'YYYY-MM-DD'), 0);
INSERT INTO STARBUCKS_NOTICE (sno, stitle, scontent, sdate, scount)
VALUES (SEQ_SNO.NEXTVAL, '시즌 한정 프로모션', '겨울 한정 음료 프로모션이 시작되었습니다. 따뜻한 음료와 함께 겨울을 즐기세요.', TO_DATE('2025-07-05', 'YYYY-MM-DD'), 0);
INSERT INTO STARBUCKS_NOTICE (sno, stitle, scontent, sdate, scount)
VALUES (SEQ_SNO.NEXTVAL, '일회용컵 사용 제한', '환경 보호를 위해 일회용컵 사용이 제한됩니다. 다회용컵 사용을 권장드립니다.', TO_DATE('2025-07-06', 'YYYY-MM-DD'), 0);

-- 작성자 컬럼 추가
ALTER TABLE STARBUCKS_NOTICE ADD SWRITER varchar2(100) NULL;