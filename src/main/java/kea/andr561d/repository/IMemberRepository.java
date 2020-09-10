package kea.andr561d.repository;

import kea.andr561d.model.Member;
import java.util.List;

public interface IMemberRepository {

    boolean create(Member m);

    Member read(String email);

    List<Member> readAll();

}
