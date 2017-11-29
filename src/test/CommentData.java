package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommentData {

    public static void main(String[] args) {
        Comment c1 = new Comment();
        c1.id = 1;
        c1.name = "lucifer";

        Comment c2 = new Comment();
        c2.id = 1;
        c2.name = "lucifer";

        List<Comment> l1 = new ArrayList<>();
        l1.add(c1);
        l1.add(c2);

        l1.forEach(System.out::println);
        l1.forEach(v->System.out.println(v.name));

        Set<Comment> set = new HashSet<>(l1);

        System.out.println(set.size());
    }
}
