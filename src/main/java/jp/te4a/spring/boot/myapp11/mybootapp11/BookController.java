package jp.te4a.spring.boot.myapp11.mybootapp11;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookService bookService;

    @ModelAttribute
    BookForm setUpForm() {
        return new BookForm();
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @PostMapping(path="create")
    String create(@Validated BookForm form, BindingResult result , Model model) {
    if(result.hasErrors()) {
    return list(model);
    }
    bookService.save(form);
    return "redirect:/books";
    }

    @PostMapping(path = "edit")
    String edit(@RequestParam Integer id, @Validated BookForm form, BindingResult result) {
    if(result.hasErrors()) {
    return editForm(id, form);
    }
    bookService.update(form);
    return "redirect:/books";
    }

    @PostMapping(path = "edit", params = "goToTop")
    public String goToTop() {
        return "redirect:/books";
    }

    @PostMapping(path = "edit", params = "form")
    public String editForm(@RequestParam Integer id, BookForm form) {
        BookForm bookForm = bookService.findById(id);
        BeanUtils.copyProperties(bookForm, form);
        return "books/edit";
    }

    @PostMapping(path = "delete")
    public String delete(@RequestParam Integer id) {
        bookService.deleteById(id);
        return "redirect:/books";
    }
}
