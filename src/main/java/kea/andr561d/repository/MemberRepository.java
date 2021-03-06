package kea.andr561d.repository;

import kea.andr561d.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository implements IMemberRepository {

    List<Member> members;

    public MemberRepository() {
        this.members = new ArrayList<>();
        this.members.add(new Member("Andr561d@stud.kea.dk", "1234"));
        this.members.add(new Member("Jensd@stud.kea.dk", "123"));
        this.members.add(new Member("Test@stud.kea.dk", "12"));
    }

    @Override
    public boolean create(Member m) {
        return this.members.add(m);
    }

    @Override
    public Member read(String email) {
        for (Member member : members) {
            if (member.getEmail().equals(email)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Member> readAll() {
        return this.members;
    }
}
