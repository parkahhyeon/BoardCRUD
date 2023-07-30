package com.ahdev.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service    // PostMapper 인터페이스의 @Mapper와 유사하며, 해당 클래스가 비즈니스 로직을 담당하는 Service Layer의 클래스임을 의미함.
@RequiredArgsConstructor  // 클랜스 내에 final로 선언된 모든 멤버에 대한 생성자를 만들어주는 역할
public class PostService {

        private final PostMapper postMapper;

        /** 게시글 저장
         * @param params - 게시글 정보
         * @return Generated PK
         */
        @Transactional  // 호출된 메서드에 해당 어노테이션이 선언되어 있으면
                        // 메서드의 실행과 동시에 트랜잭션이 시작되고,
                        // 메서드의 정상 종료 여부에 따라 Commit 또는 Rollback됨.
        public Long savePost(final PostRequest params) {    // 게시글 생성. INSERT가 완료되면, 생성된 게시글 id를 리턴함.
            postMapper.save(params);
            return params.getId();
        }

        /** 게시글 상세정보 조회
         * @param id - PK
         * @return 게시글 상세정보
         */
        public PostResponse findPostById(final Long id) {   // 특정 게시글의 상세정보를 조회함.
            return postMapper.findById(id);
        }

        /** 게시글 수정
         * @param params - 게시글 정보
         * @return PK
         */
        @Transactional
        public Long updatePost(final PostRequest params) {  // UPDATE가 완료되면, 게시글 id를 리턴함.
            postMapper.update(params);
            return params.getId();
        }

        /** 게시글 삭제
         * @param id - PK
         * @return PK
         */
        public Long deletePost(final Long id) { // UPDATE가 완료되면, 게시글 id를 리턴함.
            postMapper.deleteById(id);
            return id;
        }

        /** 게시글 리스트 조회
         * @return 게시글 리스트
         */
        public List<PostResponse> findAllPost() {   // 게시글 목록을 조회함.
            return postMapper.findAll();
        }

}
