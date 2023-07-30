package com.ahdev.domain.post;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// Mapper에는 @Mapper 어노테이션을 필수로 선언해야 함.
// Mapper와 XML Mapper는 XML Mapper의 namespace라는 속성을 통해 연결됨.
@Mapper
public interface PostMapper {

    /** 게시글 저장 : 게시글을 생성하는 INSERT문을 호출.
     * @param params - 게시글 정보
     * */
    void save(PostRequest params); // 파라미터로 전달받는 params는 요청(PostRequest)클래스의 객체이며,
                                    // params에는 저장할 게시글 정보가 담기게 됨.

    /** 게시글 상세정보 조회 : 특정 게시글을 조회하는 SELECT문 호출.
     * @param id - PK
     * @return 게시글 상세정보
     * */
    PostResponse findById(Long id);  // 파라미터로 id(PK)를 전달받아 SQL문의 WHERE 조건으로 사용하며,
                                     // 쿼리가 실행되면 메서드의 리턴 타입인 응답(PostResponse)클래스 객체의 각 멤버 변수에 결과값이 매핑(바인딩)됨.

    /** 게시글 수정 : 게시글 정보를 수정하는 UPDATE문을 호출.
     * @param params - 게시글 정보
     * */
    void update(PostRequest params);  // 요청(PostRequest)클래스의 객체를 파라미터로 전달받으며, params에는 수정할 게시글 정보가 담기게 됨.
                                      // UPDATE문의 WHERE 조건으로 사용되는 id(PK)에 값이 담김.

    /** 게시글 삭제 : 게시글을 삭제처리하는 UPDATE문 호출.
     * @param id - PK
     * */
    void deleteById(Long id); // id(PK)를 파라미터로 전달받아 SQL쿼리의 WHERE 조건으로 사용되며,
                              // SQL 쿼리가 실행되면 삭제 여부(delete_yn)컬럼의 상태 값을 0(false)에서 1(true)로 업데이트.
                              // 삭제 여부(delete_yn)는 컬럼의 상태 값을 기준으로 삭제된 데이터(1)인지, 삭제되지 않은 데이터(0)인지 구분해 주는 역할.
                              // 사용자에게 데이터를 보여줄 땐 삭제 여부가 0(false)인 데이터만 노출하게 됨.
                              // 실무에선 논리적인 삭제 방식을 이용함.

    /** 게시글 리스트 조회 : 게시글 목록을 조회하는 SELECT문 호출.
     * @return 게시글 리스트
     * */
    List<PostResponse> findAll(); // findById()는 id(PK)를 기준으로 하나의 게시글을 조회한다면,
                                // 해당 메서드는 여러 개의 게시글(PostResponse)을 리스트에 담아 리턴해주는 역할.

    /** 게시글 수 카운팅 : 전체 게시글 수를 조회하는 SELECT문 호출.
     * @return 게시글 수
     * */
    int count(); // 페이징
}
