package hello.core.member;

// 구현체가 하나만 있을 때는 인터페이스명 뒤에 impl을 붙이는 관례
public class MemberServiceImpl implements MemberService {

    // DIP 위반(구현체 의존) => interface에만 의존해야 한다(추상화)
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
