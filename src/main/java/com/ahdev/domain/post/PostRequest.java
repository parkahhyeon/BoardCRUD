package com.ahdev.domain.post;

import lombok.Data;

@Data
/* @Data
* @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을 한꺼번에 설정해주는 유용한 어노테이션.
* 클래스 레벨에서 @Data 어노테이션을 붙여주면, 모든 필드를 대상으로 접근자와 설정자가 자동으로 생성되고,
* final 또는 @NonNull 필드 값을 파라미터로 받는 생성자가 만들어지며, toStirng, equals, hashCode 메소드가 자동으로 만들어짐.
* */
public class PostRequest {

    private Long id;            // PK
    private String title;       // 제목
    private String content;     // 내용
    private String writer;      // 작성자
    private Boolean noticeYn;   // 공지글 여부
}
