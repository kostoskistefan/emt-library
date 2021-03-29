import axios from "../custom-axios/axios";

const authorService = {
    getAuthors: () => {
        return axios.get("/authors");
    },
    getAuthorById: (id) => {
        return axios.get("/authors/" + id);
    },
    addAuthor: (name, surname, countryId) => {
        return axios.post("/authors", {
            "name": name,
            "surname": surname,
            "countryId": countryId
        })
    },
    editAuthor: (id, name, surname, countryId) => {
        return axios.put("/authors/" + id, {
            "name": name,
            "surname": surname,
            "countryId": countryId
        })
    },
    deleteAuthor: (id) => {
        return axios.delete("/authors/" + id);
    },
}

export default authorService;