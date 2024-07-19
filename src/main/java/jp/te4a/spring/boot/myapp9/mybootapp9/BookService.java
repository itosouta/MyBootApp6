package jp.te4a.spring.boot.myapp9.mybootapp9;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
@Autowired
 BookRepository bookRepository;
     public BookForm save(BookForm bookForm) {
     BookBean bookBean = new BookBean();
     BeanUtils.copyProperties(bookForm, bookBean);
     bookRepository.save(bookBean);
     return bookForm;
     }

      public BookForm update(BookForm bookForm) {
      BookBean bookBean = new BookBean();
      BeanUtils.copyProperties(bookForm, bookBean);
      bookRepository.save(bookBean);
      return bookForm;
      }  

      public BookForm delete(BookForm formList) {
      BookBean bookBean = new BookBean();
      BeanUtils.copyProperties(formList, bookBean);
      bookRepository.delete(bookBean);
      return formList;
      }

      public BookForm findById(Integer id) {
          Optional<BookBean> bookBeanOptional = bookRepository.findById(id);
          BookBean bookBean = bookBeanOptional.get();
          BookForm bookForm = new BookForm();
          BeanUtils.copyProperties(bookBean, bookForm);
          return bookForm;
     }
}