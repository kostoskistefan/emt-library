import axios from "../custom-axios/axios";

const bookService = {
    getBooks: () => {
       return axios.get("/books");
    },
    getBookById: (id) => {
        return axios.get("/books/" + id);
    },
    takeBook: (id) => {
        return axios.get("/books/take/" + id);
    },
    addBook: (name, category, authorId, availableCopies) => {
        return axios.post("/books", {
            "name": name,
            "category": category,
            "authorId": authorId,
            "availableCopies": availableCopies
        })
    },
    editBook: (id, name, category, authorId, availableCopies) => {
        return axios.put("/books/" + id, {
            "name": name,
            "category": category,
            "authorId": authorId,
            "availableCopies": availableCopies
        })
    },
    deleteBook: (id) => {
        return axios.delete("/books/" + id);
    }
}

export default bookService;