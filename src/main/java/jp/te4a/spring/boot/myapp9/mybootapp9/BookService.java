package jp.te4a.spring.boot.myapp9.mybootapp9;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookForm save(BookForm bookForm) {
        BookBean bookBean = new BookBean();
        BeanUtils.copyProperties(bookForm, bookBean);
        bookRepository.save(bookBean);
        return bookForm;
    }

    public BookForm update(BookForm bookForm) {
        BookBean existingBookBean = bookRepository.findById(bookForm.getId())
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        BeanUtils.copyProperties(bookForm, existingBookBean);
        bookRepository.save(existingBookBean);
        return bookForm;
    }

    public BookForm findById(int id) {
        BookBean bookBean = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        BookForm bookForm = new BookForm();
        BeanUtils.copyProperties(bookBean, bookForm);
        return bookForm;
    }

    public List<BookBean> findAll() {
        return bookRepository.findAll();
    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    public void delete(BookBean bookBean) {
        bookRepository.delete(bookBean);
    }
}
