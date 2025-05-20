package hello.core.member;

import java.util.HashMap;
import java.util.Map;

// db 선택이 안 됐다는 가정
// 메모리에서만 동작하기 때문에 테스트용으로 사용.
public class MemoryMemberRepository implements MemberRepository{

    // 동시성 이슈가 있을 수 있는데, ConcurrentHashMap을 써야 한다.
    // 중요하니까 공부해야 한다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
