package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {
    // static 영역에 객체를 1개만 생성
    private static final SingletonService instance = new SingletonService();

    // 객체 인스턴스를 조회할 수 있는 유일한 경로(public)
    public static SingletonService getInstance(){
        return instance;
    }

    // 생성자가 private이면 외부에서 new 객체 생성 못 한다
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
