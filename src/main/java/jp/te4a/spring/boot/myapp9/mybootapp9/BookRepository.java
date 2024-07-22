package jp.te4a.spring.boot.myapp9.mybootapp9;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
//（save, delete, findOne, findAll）は入ってる
public interface BookRepository extends JpaRepository<BookBean, Integer> {
    @Query("SELECT X FROM BookBean X ORDER BY X.title")
   List<BookBean> findAllOrderByTitle();

   //public ConcurrentMap<Integer, BookBean> bookMap = new ConcurrentHashMap<>();
   //public int BOOK_ID = 1;
  
   public BookBean create(BookBean bookBean);
   public BookForm update(BookForm bookForm);
   }
   