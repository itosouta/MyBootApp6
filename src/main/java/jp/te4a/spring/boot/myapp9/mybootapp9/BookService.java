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

 public BookForm create(BookForm bookForm) {
  BookBean bookBean = new BookBean();
  BeanUtils.copyProperties(bookForm, bookBean);
  bookRepository.create(bookBean);
  return bookForm;
  }

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

 public List<BookForm> findAll() {
  List<BookBean> beanList = bookRepository.findAll();
  List<BookForm> formList = new ArrayList<BookForm>();
  for(BookBean bookBean: beanList) {
  BookForm bookForm = new BookForm();
  BeanUtils.copyProperties(bookBean, bookForm);
  formList.add(bookForm);
  }
  return formList;
  }

 //deleteとfindbyid
    public void delete(BookBean bookBean) {
      bookRepository.delete(bookBean);
  }
  
  public BookForm findById(Integer id) {
    Optional<BookBean> bookOptional = bookRepository.findById(id);

    BookBean bookBean = bookOptional.get();
    BookForm bookForm = new BookForm();
    BeanUtils.copyProperties(bookBean, bookForm);
    return bookForm;
}
}
      