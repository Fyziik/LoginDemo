package kea.andr561d.repository;

import kea.andr561d.model.Member;

import java.util.List;

public class MemberRepository implements IMemberRepository {

    @Override
    public boolean create(Member m) {
        return false;
    }

    @Override
    public Member read(String email) {
        return null;
    }

    @Override
    public List<Member> readAll() {
        return null;
    }
}